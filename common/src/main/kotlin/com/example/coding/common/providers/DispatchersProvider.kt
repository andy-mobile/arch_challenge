package com.example.coding.common.providers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface DispatchersProvider {

    val default: CoroutineDispatcher

    val main: CoroutineDispatcher

    val mainImmediate: CoroutineDispatcher

    val io: CoroutineDispatcher

    val unconfined: CoroutineDispatcher
}

class DispatchersProviderImpl
@Inject
constructor() : DispatchersProvider {
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val mainImmediate: CoroutineDispatcher
        get() = Dispatchers.Main.immediate

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val unconfined: CoroutineDispatcher
        get() = Dispatchers.Unconfined

}