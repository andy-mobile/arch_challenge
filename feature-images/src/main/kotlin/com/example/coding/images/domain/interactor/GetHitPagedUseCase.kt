package com.example.coding.images.domain.interactor

import androidx.paging.PagingData
import com.example.coding.images.domain.entity.HitEntity
import com.example.coding.images.domain.repository.HitsPagedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetHitPagedUseCase
@Inject
internal constructor(
    private val repository: HitsPagedRepository
) {
    operator fun invoke(query:String): Flow<PagingData<HitEntity>> {

        return repository.getPaged(query = query)
    }
}