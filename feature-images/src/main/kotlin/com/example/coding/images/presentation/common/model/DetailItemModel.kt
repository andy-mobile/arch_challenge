package com.example.coding.images.presentation.common.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailItemModel(
    val id: Int,
    val imageUrl: String,
    val userName: String,
    val tags: List<String>,
    val likes: String,
    val downloads: String,
    val comments: String
) : Parcelable
