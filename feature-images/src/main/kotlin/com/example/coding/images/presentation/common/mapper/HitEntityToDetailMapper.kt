package com.example.coding.images.presentation.common.mapper

import com.example.coding.common.providers.resources.ResourceProvider
import com.example.coding.images.R
import com.example.coding.images.domain.entity.HitEntity
import com.example.coding.images.presentation.common.model.DetailItemModel
import javax.inject.Inject

internal class HitEntityToDetailMapper @Inject constructor(
    private val resourceProvider: ResourceProvider
) {

    fun map(item: HitEntity): DetailItemModel {
        val resources = resourceProvider
        return DetailItemModel(
            id = item.itemId,
            imageUrl = item.previewURL,
            userName = resources.getString(R.string.detail_user_name, item.user),
            tags = item.tags,
            likes = resources.getString(R.string.detail_likes, item.likes),
            downloads = resources.getString(R.string.detail_download, item.downloads),
            comments = resources.getString(R.string.detail_comments, item.comments)
        )
    }
}