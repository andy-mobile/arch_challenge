package com.example.coding.images.domain.interactor

import com.example.coding.common.providers.DispatchersProvider
import com.example.coding.images.domain.repository.StorageRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class GetHitByItemIdUseCase @Inject
constructor(
    private val storageRepository: StorageRepository,
    private val dispatchersProvider: DispatchersProvider
) {

    suspend operator fun invoke(id: Int) = withContext(dispatchersProvider.io) {
        storageRepository.getByItemId(id)
    }
}