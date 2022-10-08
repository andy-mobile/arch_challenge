package com.example.coding.images.di.modules

import com.example.coding.images.data.repository.HitsPagedRepositoryImpl
import com.example.coding.images.di.scope.FeatureImages
import com.example.coding.images.data.repository.StorageRepositoryImpl
import com.example.coding.images.domain.repository.HitsPagedRepository
import com.example.coding.images.domain.repository.StorageRepository
import dagger.Binds
import dagger.Module

@Module
internal interface DataModule {

    @Binds
    @FeatureImages
    fun bindHitsPagedRepository(what: HitsPagedRepositoryImpl): HitsPagedRepository

    @Binds
    @FeatureImages
    fun bindStorageRepository(what: StorageRepositoryImpl): StorageRepository
}