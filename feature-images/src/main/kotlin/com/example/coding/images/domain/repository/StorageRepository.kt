package com.example.coding.images.domain.repository

import com.example.coding.images.domain.entity.HitEntity

internal interface StorageRepository {

    suspend fun getByItemId(id: Int): HitEntity?
}