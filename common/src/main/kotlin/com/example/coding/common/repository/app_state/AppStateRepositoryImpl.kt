package com.example.coding.common.repository.app_state

import com.example.coding.common.repository.app_state.states.ImagesState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class AppStateRepositoryImpl : AppStateRepository {

    private val state = MutableStateFlow(getInitState())

    override val subscribe: Flow<FeaturesState>
        get() = state.asStateFlow()

    override val value: FeaturesState
        get() = state.value

    override fun setState(state: FeaturesState) {
        this.state.update { state }
    }

    private fun getInitState(): FeaturesState = FeaturesState(
        imagesFeatureState = ImagesState(StateConstants.FeatureImages.DEFAULT_SEARCH_STRING)
    )
}

