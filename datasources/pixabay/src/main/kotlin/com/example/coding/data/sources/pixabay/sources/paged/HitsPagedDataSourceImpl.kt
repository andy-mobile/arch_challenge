package com.example.coding.data.sources.pixabay.sources.paged

import androidx.paging.*
import com.example.coding.data.sources.api.dto.FilterPhotoDTO
import com.example.coding.data.sources.api.dto.CachableHitDTO
import com.example.coding.data.sources.api.sources.HitsPagedDataSource
import com.example.coding.data.sources.pixabay.Constants
import com.example.coding.data.sources.pixabay.sources.storage.database.dao.HitDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class HitsPagedDataSourceImpl
@Inject
constructor(
    private val mediatorFactory: PixabayRemoteMediator.Factory,
    private val hitDao: HitDao
) : HitsPagedDataSource {

    @Suppress("UNCHECKED_CAST")
    override fun getPaged(filter: FilterPhotoDTO): Flow<PagingData<CachableHitDTO>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        remoteMediator = mediatorFactory.create(filter),
        pagingSourceFactory = { hitDao.getPaged() as PagingSource<Int, CachableHitDTO> },
    ).flow

    private companion object {
        const val PAGE_SIZE = Constants.PAGE_SIZE
    }
}