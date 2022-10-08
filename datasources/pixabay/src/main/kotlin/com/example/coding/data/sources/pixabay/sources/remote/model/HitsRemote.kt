package com.example.coding.data.sources.pixabay.sources.remote.model

import com.google.gson.annotations.SerializedName

data class HitsRemote(
    @SerializedName("total")
    val total:Int?,

    @SerializedName("totalHits")
    val totalHits:Int?,

    @SerializedName("hits")
    val hits: List<HitRemote>?
)
