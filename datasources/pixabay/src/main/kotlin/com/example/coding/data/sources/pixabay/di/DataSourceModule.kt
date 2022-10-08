package com.example.coding.data.sources.pixabay.di

import com.example.coding.data.sources.api.sources.HitsPagedDataSource
import com.example.coding.data.sources.api.sources.StorageDataSource
import com.example.coding.data.sources.pixabay.sources.paged.HitsPagedDataSourceImpl
import com.example.coding.data.sources.pixabay.sources.storage.StorageDataSourceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataSourceModule {

    @Binds
    @Singleton
    fun provideHitsPagedDataSourceImpl(what: HitsPagedDataSourceImpl): HitsPagedDataSource

    @Binds
    @Singleton
    fun provideHitsPagedDataSource(what: StorageDataSourceImpl): StorageDataSource
}