package com.example.coding.common.delegate

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentViewBindingDelegate<T : ViewBinding>(
        val fragment: Fragment,
        val viewBindingFactory: (View) -> T
) : ReadOnlyProperty<Fragment, T> {
    private val handler = Handler(Looper.getMainLooper())
    private var binding: T? = null

    init {
        fragment.lifecycle.addObserver(object : LifecycleEventObserver {

            val viewLifecycleOwnerObserver = Observer<LifecycleOwner?> {
                val viewLifecycleOwner = it ?: return@Observer

                viewLifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
                    override fun onStateChanged(
                            source: LifecycleOwner,
                            event: Lifecycle.Event
                    ) {
                        when (event) {
                            Lifecycle.Event.ON_DESTROY -> handler.post { binding = null }
                            else -> Unit
                        }
                    }
                })
            }

            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) =
                    when (event) {
                        Lifecycle.Event.ON_CREATE -> fragment.viewLifecycleOwnerLiveData
                                .observeForever(viewLifecycleOwnerObserver)

                        Lifecycle.Event.ON_DESTROY -> fragment.viewLifecycleOwnerLiveData
                                .removeObserver(viewLifecycleOwnerObserver)

                        else -> Unit

                    }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment by.makarov.smarttvlgrc.shared.extension.getViews are destroyed.")
        }

        return viewBindingFactory(thisRef.requireView()).also { this.binding = it }
    }
}

inline fun <reified T : ViewBinding> Fragment.viewBinding(noinline viewBindingFactory: (View) -> T) =
        FragmentViewBindingDelegate(this, viewBindingFactory)

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
        crossinline bindingInflater: (LayoutInflater) -> T) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater(layoutInflater)
}