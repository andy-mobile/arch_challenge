package com.example.coding.common.repository.app_state

import kotlinx.coroutines.flow.Flow

interface AppStateRepository {

    val subscribe: Flow<FeaturesState>

    val value:  FeaturesState

    fun setState(state: FeaturesState)
}