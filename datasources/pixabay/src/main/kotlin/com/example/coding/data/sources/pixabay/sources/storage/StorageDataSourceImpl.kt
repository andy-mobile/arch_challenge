package com.example.coding.data.sources.pixabay.sources.storage

import com.example.coding.data.sources.api.dto.CachableHitDTO
import com.example.coding.data.sources.api.sources.StorageDataSource
import com.example.coding.data.sources.pixabay.sources.storage.database.dao.HitDao
import javax.inject.Inject

class StorageDataSourceImpl
@Inject
constructor(
    private val hitsStorageRepository: HitDao,
) : StorageDataSource {

    override suspend fun getByItemId(id: Int): CachableHitDTO? {
        return hitsStorageRepository.getByItemId(id)
    }
}