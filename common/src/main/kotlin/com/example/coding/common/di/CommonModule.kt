package com.example.coding.common.di

import android.content.Context
import com.example.coding.common.providers.DispatchersProvider
import com.example.coding.common.providers.DispatchersProviderImpl
import com.example.coding.common.providers.resources.ResourceProvider
import com.example.coding.common.providers.resources.ResourceProviderImpl
import com.example.coding.common.repository.app_state.AppStateRepository
import com.example.coding.common.repository.app_state.AppStateRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object CommonModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideResourceProvider(context: Context): ResourceProvider = ResourceProviderImpl(context)

    @Provides
    @Singleton
    @JvmStatic
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProviderImpl()

    @Provides
    @Singleton
    @JvmStatic
    fun provideAppStateRepository(): AppStateRepository = AppStateRepositoryImpl()
}