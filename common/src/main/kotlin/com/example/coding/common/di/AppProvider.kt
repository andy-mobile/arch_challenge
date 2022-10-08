package com.example.coding.common.di

import android.content.Context
import com.example.coding.common.providers.DispatchersProvider
import com.example.coding.common.providers.resources.ResourceProvider

interface AppProvider {

    val resourceProvider: ResourceProvider

    val dispatchersProvider: DispatchersProvider

    val context: Context

    companion object
}