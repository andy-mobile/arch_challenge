package com.example.coding.common.di

import android.content.Context
import com.example.coding.common.providers.DispatchersProvider
import com.example.coding.common.providers.resources.ResourceProvider
import com.example.coding.common.repository.app_state.AppStateRepository

interface AppProvider {

    val resourceProvider: ResourceProvider

    val dispatchersProvider: DispatchersProvider

    val appStateRepository: AppStateRepository

    val context: Context

    companion object
}