package com.example.coding.images.domain.repository

import androidx.paging.PagingData
import com.example.coding.images.domain.entity.HitEntity
import kotlinx.coroutines.flow.Flow

internal interface HitsPagedRepository {

    fun getPaged(query: String): Flow<PagingData<HitEntity>>
}