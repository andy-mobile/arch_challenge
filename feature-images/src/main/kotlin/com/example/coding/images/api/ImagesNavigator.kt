package com.example.coding.images.api

import androidx.fragment.app.FragmentManager
import com.example.coding.images.presentation.common.model.DetailItemModel

interface ImagesNavigator {
    fun toDetailsScreen(
        param: DetailItemModel,
        fragmentManager: FragmentManager
    )
}