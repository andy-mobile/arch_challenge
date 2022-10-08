package com.example.coding.data.sources.pixabay.sources.paged

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.coding.data.sources.api.dto.FilterPhotoDTO
import com.example.coding.data.sources.api.dto.HitsDTO
import com.example.coding.data.sources.api.dto.CachableHitDTO
import com.example.coding.data.sources.pixabay.sources.remote.mapper.HitsMapper
import com.example.coding.data.sources.pixabay.sources.remote.service.PixabayApiService
import com.example.coding.data.sources.pixabay.sources.storage.database.dao.HitDao
import com.example.coding.data.sources.pixabay.sources.storage.mapper.HitStorageMapper
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

@OptIn(ExperimentalPagingApi::class)
class PixabayRemoteMediator @AssistedInject constructor(
    private val hitdao: HitDao,
    private val apiRemote: PixabayApiService,
    private val hitStorageMapper: HitStorageMapper,
    private val hitsMapper: HitsMapper,
    @Assisted private val filter: FilterPhotoDTO
) : RemoteMediator<Int, CachableHitDTO>() {
    private var pageIndex = 0

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CachableHitDTO>
    ): MediatorResult {
        pageIndex = getPageIndex(loadType)
            ?: return MediatorResult.Success(endOfPaginationReached = true)

        val limit = filter.perPage ?: state.config.pageSize

        return try {
            val response = fetchLaunches(pageIndex, limit)
            val hits = response.hits.map { item ->
                hitStorageMapper.map(item)
            }
            if (loadType == LoadType.REFRESH) {
                hitdao.refresh(hits)
                pageIndex = 1
            } else {

                hitdao.insert(hits)
            }

            MediatorResult.Success(
                endOfPaginationReached = response.hits.size < limit
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun fetchLaunches(
        pageNumber: Int,
        limit: Int
    ): HitsDTO {
        val response = apiRemote.find(
            query = filter.query,
            lang = filter.lang?.name,
            id = filter.id,
            imageType = filter.imageType,
            orientation = filter.orientation,
            category = filter.category?.name,
            minWidth = filter.minWidth,
            minHeight = filter.minHeight,
            colors = filter.colors?.name,
            editorsChoice = filter.editorsChoice,
            safeSearch = filter.safeSearch,
            order = filter.order?.name,
            page = pageNumber,
            perPage = limit,
            pretty = filter.pretty
        )

        return hitsMapper.map(response)
    }

    private fun getPageIndex(loadType: LoadType): Int? {
        pageIndex = when (loadType) {
            LoadType.REFRESH -> filter.page
            LoadType.PREPEND -> return null
            LoadType.APPEND -> ++pageIndex
        }
        return pageIndex
    }

    @AssistedFactory
    interface Factory {
        fun create(filter: FilterPhotoDTO): PixabayRemoteMediator
    }
}