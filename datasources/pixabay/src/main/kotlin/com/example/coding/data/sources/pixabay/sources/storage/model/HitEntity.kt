package com.example.coding.data.sources.pixabay.sources.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.coding.data.sources.api.dto.CachableHitDTO

@Entity(tableName = "hit")
data class HitEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val  id: Int? = null,

    @ColumnInfo(name = "item_id")
    override val  itemId: Int,

    @ColumnInfo(name = "pageURL")
    override val pageURL: String,

    @ColumnInfo(name = "type")
    override val type: String,

    @ColumnInfo(name = "tags")
    override val tags: List<String>,

    @ColumnInfo(name = "previewURL")
    override val previewURL: String,

    @ColumnInfo(name = "previewWidth")
    override val previewWidth: Int,

    @ColumnInfo(name = "previewHeight")
    override val previewHeight: Int,

    @ColumnInfo(name = "webformatURL")
    override val webformatURL: String,

    @ColumnInfo(name = "webformatWidth")
    override val webformatWidth: Int,

    @ColumnInfo(name = "webformatHeight")
    override val webformatHeight: Int,

    @ColumnInfo(name = "largeImageURL")
    override val largeImageURL: String,

    @ColumnInfo(name = "fullHDURL")
    override val fullHDURL: String,

    @ColumnInfo(name = "imageURL")
    override val imageURL: String,

    @ColumnInfo(name = "imageWidth")
    override val imageWidth: Int,

    @ColumnInfo(name = "imageHeight")
    override val imageHeight: Int,

    @ColumnInfo(name = "imageSize")
    override val imageSize: Int,

    @ColumnInfo(name = "views")
    override val views: Int,

    @ColumnInfo(name = "downloads")
    override val downloads: Int,

    @ColumnInfo(name = "likes")
    override val likes: Int,

    @ColumnInfo(name = "comments")
    override val comments: Int,

    @ColumnInfo(name = "user_id")
    override val userId: Int,

    @ColumnInfo(name = "user")
    override val user: String,

    @ColumnInfo(name = "userImageURL")
    override val userImageURL: String
) : CachableHitDTO
