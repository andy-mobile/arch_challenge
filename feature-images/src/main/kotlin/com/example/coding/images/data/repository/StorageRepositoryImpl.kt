package com.example.coding.images.data.repository

import com.example.coding.data.sources.api.sources.StorageDataSource
import com.example.coding.images.data.mapper.CachedHitMapper
import com.example.coding.images.domain.entity.HitEntity
import com.example.coding.images.domain.repository.StorageRepository
import javax.inject.Inject

internal class StorageRepositoryImpl
@Inject
constructor(
    private val hitsPagedDataSource: StorageDataSource,
    private val cachedHitMapper: CachedHitMapper
) : StorageRepository {

    override suspend fun getByItemId(id: Int): HitEntity? {
       val data= hitsPagedDataSource.getByItemId(id)
           ?:return null

        return cachedHitMapper.map(data)
    }
}