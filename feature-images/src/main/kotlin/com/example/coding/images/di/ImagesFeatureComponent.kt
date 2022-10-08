package com.example.coding.images.di

import androidx.fragment.app.Fragment
import com.example.coding.common.di.findComponentDependencies
import com.example.coding.common.di.viewmodel.ViewModelFactoryModule
import com.example.coding.images.di.scope.FeatureImages
import com.example.coding.data.sources.api.di.PixabayProvider
import com.example.coding.datasources.get
import com.example.coding.images.api.ImagesScreenDependencies
import com.example.coding.images.di.modules.DataModule
import com.example.coding.images.di.modules.ImagesModule
import com.example.coding.images.presentation.previews.PreviewFragment
import dagger.Component
import java.lang.ref.WeakReference

@FeatureImages
@Component(
    dependencies = [PixabayProvider::class, ImagesScreenDependencies::class],
    modules = [
        DataModule::class,
        ViewModelFactoryModule::class,
        ImagesModule::class
    ]
)
internal interface ImagesFeatureComponent {

    fun inject(fragment: PreviewFragment)

    companion object {
        private var weakInstance = WeakReference<ImagesFeatureComponent>(null)

        fun get(fragment: Fragment): ImagesFeatureComponent {
            val context = fragment.requireContext().applicationContext
            var instance = weakInstance.get()
            if (instance == null) {
                instance = DaggerImagesFeatureComponent
                    .builder().pixabayProvider(PixabayProvider.get(context))
                    .imagesScreenDependencies(fragment.findComponentDependencies())
                    .build()

                weakInstance = WeakReference(instance)
            }
            return instance!!
        }
    }
}

internal val Fragment.injector get() = ImagesFeatureComponent.get(this)