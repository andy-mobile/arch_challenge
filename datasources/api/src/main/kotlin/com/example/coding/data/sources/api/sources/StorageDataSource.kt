package com.example.coding.data.sources.api.sources

import com.example.coding.data.sources.api.dto.CachableHitDTO

interface StorageDataSource {

    suspend fun getByItemId(id: Int): CachableHitDTO?

}