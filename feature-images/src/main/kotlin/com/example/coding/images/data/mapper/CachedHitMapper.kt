package com.example.coding.images.data.mapper

import com.example.coding.data.sources.api.dto.CachableHitDTO
import com.example.coding.images.domain.entity.HitEntity
import javax.inject.Inject

internal class CachedHitMapper
@Inject
constructor() {
    fun map(item: CachableHitDTO) = HitEntity(
        id = item.id!!,
        itemId=item.itemId,
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