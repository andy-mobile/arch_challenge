package com.example.coding.images.domain.entity

internal data class HitEntity(
    val id: Int,
    val itemId:Int,
    val pageURL: String,
    val type: String,
    val tags: List<String>,
    val previewURL: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageURL: String,
    val fullHDURL: String,
    val imageURL: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val userId: Int,
    val user: String,
    val userImageURL: String
)
