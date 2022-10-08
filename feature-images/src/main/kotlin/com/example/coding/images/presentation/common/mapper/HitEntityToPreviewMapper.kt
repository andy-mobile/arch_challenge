package com.example.coding.images.presentation.common.mapper

import com.example.coding.images.domain.entity.HitEntity
import com.example.coding.images.presentation.common.model.PreviewItemModel
import javax.inject.Inject

internal class HitEntityToPreviewMapper @Inject constructor(){

    fun map(item: HitEntity) = PreviewItemModel(
        id = item.itemId,
        imageUrl = item.previewURL,
        userName = item.user,
        tags = item.tags
    )
}