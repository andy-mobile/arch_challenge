package com.example.coding.di

import android.content.Context
import com.example.coding.common.di.AppProvider
import com.example.coding.common.providers.DispatchersProvider
import com.example.coding.common.providers.DispatchersProviderImpl
import com.example.coding.common.providers.resources.ResourceProvider
import com.example.coding.common.providers.resources.ResourceProviderImpl
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
internal interface AppComponent : AppProvider {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }
}

@Module
private object AppModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideResourceProvider(context: Context): ResourceProvider = ResourceProviderImpl(context)

    @Provides
    @Singleton
    @JvmStatic
    fun provideDispatchersProvider(): DispatchersProvider = DispatchersProviderImpl()
}

fun AppProvider.Companion.init(context: Context): AppProvider {
    return DaggerAppComponent.builder()
        .bindContext(context.applicationContext)
        .build()
}

