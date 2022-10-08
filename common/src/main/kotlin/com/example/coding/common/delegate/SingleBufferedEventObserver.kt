package com.example.coding.common.delegate

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface SingleBufferedEventObserver<Event> {
    val subscribeEvent: Flow<Event>
    fun Event.emmit()
}

class SingleBufferedEventObserverImpl<Event>
@Inject constructor() : SingleBufferedEventObserver<Event> {
    private val _event = Channel<Event>(Channel.BUFFERED)
    override val subscribeEvent: Flow<Event> = _event.receiveAsFlow()

    override fun Event.emmit() {
        _event.trySend(this)
    }
}

/**
 * send [Event] with [lifecycleState]
 * The UI re-renders based on the new event
 **/
fun <Event> SingleBufferedEventObserver<Event>.collectEvent(
    lifecycleOwner: LifecycleOwner,
    lifecycleState: Lifecycle.State = Lifecycle.State.RESUMED,
    block: (event: Event) -> Unit
): Job = lifecycleOwner.lifecycleScope.launch {
    subscribeEvent.flowWithLifecycle(
        lifecycle = lifecycleOwner.lifecycle,
        minActiveState = lifecycleState,
    ).collect(block::invoke)
}