package com.example.coding.data.sources.api.di

import com.example.coding.data.sources.api.sources.HitsPagedDataSource
import com.example.coding.data.sources.api.sources.StorageDataSource

interface PixabayProvider {

    fun provideHitsPagedDataSource(): HitsPagedDataSource

    fun provideStorageDataSource(): StorageDataSource

    companion object
}