package com.example.coding.images.domain.interactor

import com.example.coding.common.repository.app_state.AppStateRepository
import com.example.coding.common.repository.app_state.states.ImagesState
import javax.inject.Inject

class PreviewStateInteractor @Inject constructor(
    private val appStateRepository: AppStateRepository
) {

    val value: ImagesState
        get() = appStateRepository.value.imagesFeatureState as ImagesState

    fun setQuery(text: String) {
        val state = value.copy(query = text)
        val value = appStateRepository.value.copy(imagesFeatureState = state)
        appStateRepository.setState(value)
    }
}