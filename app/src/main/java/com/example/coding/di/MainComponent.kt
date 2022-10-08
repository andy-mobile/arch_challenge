package com.example.coding.di

import com.example.coding.App
import com.example.coding.MainActivity
import com.example.coding.common.di.AppProvider
import com.example.coding.common.di.ComponentDependencies
import com.example.coding.common.di.ComponentDependenciesKey
import com.example.coding.images.api.ImagesScreenDependencies
import com.example.coding.images.api.ImagesNavigator
import com.example.coding.navigation.NavigationManagerImpl
import dagger.*
import dagger.multibindings.IntoMap
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.SOURCE)
annotation class MainActivityScope

@MainActivityScope
@Component(
    dependencies = [AppProvider::class],
    modules = [BindingsModule::class, ComponentDependenciesModule::class]
)
interface MainComponent : ImagesScreenDependencies {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {

        fun bindAppProvider(appProvider: AppProvider): Builder

        fun build(): MainComponent
    }

    companion object
}

@Module
private interface BindingsModule {

    @Binds
    @MainActivityScope
    fun provideStartScreenNavigator(what: NavigationManagerImpl): ImagesNavigator
}

@Module
private interface ComponentDependenciesModule {
    @Binds
    @IntoMap
    @ComponentDependenciesKey(ImagesScreenDependencies::class)
    fun provideStartScreenDependencies(component: MainComponent): ComponentDependencies
}

fun MainComponent.Companion.inject(activity: MainActivity) {
    val appProvider = (activity.applicationContext as App).appProvider
    DaggerMainComponent.builder()
        .bindAppProvider(appProvider).build()
        .inject(activity)
}