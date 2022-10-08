package com.example.coding.data.sources.pixabay.sources.remote.mapper

import com.example.coding.data.sources.api.dto.HitDTO
import com.example.coding.data.sources.api.exception.MapperException
import com.example.coding.data.sources.pixabay.sources.remote.model.HitRemote
import javax.inject.Inject


class HitMapper @Inject constructor() {

    fun map(item: HitRemote): HitDTO = try {
        HitDTO(
            id = null,
            itemId = item.id!!,
            pageURL = item.pageURL!!,
            type = item.type!!,
            tags = item.tags.orEmpty().split(","),
            previewURL = item.previewURL!!,
            previewWidth = item.previewWidth!!,
            previewHeight = item.previewHeight!!,
            webformatURL = item.webformatURL!!,
            webformatHeight = item.webformatHeight!!,
            webformatWidth = item.webformatWidth!!,
            largeImageURL = item.largeImageURL!!,
            fullHDURL = item.fullHDURL.orEmpty(),
            imageURL = item.imageURL.orEmpty(),
            imageWidth = item.imageWidth!!,
            imageHeight = item.imageHeight!!,
            imageSize = item.imageSize!!,
            views = item.views!!,
            downloads = item.downloads!!,
            likes = item.likes!!,
            comments = item.comments!!,
            userId = item.userId!!,
            user = item.user!!,
            userImageURL = item.userImageURL!!
        )
    } catch (exception: Exception) {
        throw MapperException(exception)
    }
}