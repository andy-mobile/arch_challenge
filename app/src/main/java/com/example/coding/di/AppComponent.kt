package com.example.coding.di

import android.content.Context
import com.example.coding.common.di.AppProvider
import com.example.coding.common.di.CommonModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CommonModule::class]
)
internal interface AppComponent : AppProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }
}

fun AppProvider.Companion.init(context: Context): AppProvider {
    return DaggerAppComponent.builder()
        .bindContext(context.applicationContext)
        .build()
}

