package com.example.coding.data.sources.pixabay.sources.storage.mapper

import com.example.coding.data.sources.api.dto.HitDTO
import com.example.coding.data.sources.pixabay.sources.storage.model.HitEntity
import javax.inject.Inject

class HitStorageMapper @Inject constructor() {

    fun map(item: HitDTO): HitEntity = HitEntity(
        id = null,
        itemId = item.itemId,
        pageURL = item.pageURL,
        type = item.type,
        tags = item.tags,
        previewURL = item.previewURL,
        previewWidth = item.previewWidth,
        previewHeight = item.previewHeight,
        webformatURL = item.webformatURL,
        webformatHeight = item.webformatHeight,
        webformatWidth = item.webformatWidth,
        largeImageURL = item.largeImageURL,
        fullHDURL = item.fullHDURL,
        imageURL = item.imageURL,
        imageWidth = item.imageWidth,
        imageHeight = item.imageHeight,
        imageSize = item.imageSize,
        views = item.views,
        downloads = item.downloads,
        likes = item.likes,
        comments = item.comments,
        userId = item.userId,
        user = item.user,
        userImageURL = item.userImageURL
    )
}