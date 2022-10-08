package com.example.coding.data.sources.api.dto

data class HitDTO(
    override val id: Int?,
    override val itemId: Int,
    override val pageURL: String,
    override val type: String,
    override val tags: List<String>,
    override val previewURL: String,
    override val previewWidth: Int,
    override val previewHeight: Int,
    override val webformatURL: String,
    override val webformatWidth: Int,
    override val webformatHeight: Int,
    override val largeImageURL: String,
    override val fullHDURL: String,
    override val imageURL: String,
    override val imageWidth: Int,
    override val imageHeight: Int,
    override val imageSize: Int,
    override val views: Int,
    override val downloads: Int,
    override val likes: Int,
    override val comments: Int,
    override val userId: Int,
    override val user: String,
    override val userImageURL: String
) : CachableHitDTO