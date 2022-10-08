package com.example.coding.data.sources.api.sources

import androidx.paging.PagingData
import com.example.coding.data.sources.api.dto.FilterPhotoDTO
import com.example.coding.data.sources.api.dto.CachableHitDTO
import kotlinx.coroutines.flow.Flow

interface HitsPagedDataSource {

    fun getPaged(filter: FilterPhotoDTO): Flow<PagingData<CachableHitDTO>>

}