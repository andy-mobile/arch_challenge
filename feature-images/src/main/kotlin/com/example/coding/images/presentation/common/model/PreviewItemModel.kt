package com.example.coding.images.presentation.common.model

data class PreviewItemModel(
    val id: Int,
    val imageUrl: String,
    val userName: String,
    val tags: List<String>
)
