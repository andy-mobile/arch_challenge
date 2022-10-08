package com.example.coding.images.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.coding.data.sources.api.dto.FilterPhotoDTO
import com.example.coding.data.sources.api.sources.HitsPagedDataSource
import com.example.coding.images.data.mapper.CachedHitMapper
import com.example.coding.images.domain.repository.HitsPagedRepository
import com.example.coding.images.domain.entity.HitEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class HitsPagedRepositoryImpl
@Inject
constructor(
    private val hitsPagedDataSource: HitsPagedDataSource,
    private val cachedHitMapper: CachedHitMapper
) : HitsPagedRepository {

    override fun getPaged(query: String): Flow<PagingData<HitEntity>> {
        val filter = FilterPhotoDTO(query = query)

        return hitsPagedDataSource.getPaged(filter).map { pagingData ->
            pagingData.map { cachedHitMapper.map(it) }
        }
    }
}