package com.example.coding.common.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun provideViewModelProviderFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}
