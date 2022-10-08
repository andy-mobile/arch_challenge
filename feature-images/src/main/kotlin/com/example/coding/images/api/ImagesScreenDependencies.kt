package com.example.coding.images.api

import com.example.coding.common.di.ComponentDependencies
import com.example.coding.common.providers.DispatchersProvider
import com.example.coding.common.providers.resources.ResourceProvider

interface ImagesScreenDependencies : ComponentDependencies {
    fun imagesNavigator(): ImagesNavigator
    fun resourceProvider(): ResourceProvider
    fun dispatcherProvider(): DispatchersProvider
}