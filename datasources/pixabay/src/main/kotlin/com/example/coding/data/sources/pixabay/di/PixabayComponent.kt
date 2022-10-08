package com.example.coding.data.sources.pixabay.di

import android.content.Context
import com.example.coding.data.sources.api.di.PixabayProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        DataSourceModule::class,
        StorageModule::class
    ]
)
interface PixabayComponent : PixabayProvider {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context): PixabayComponent.Builder

        fun build(): PixabayComponent
    }
}