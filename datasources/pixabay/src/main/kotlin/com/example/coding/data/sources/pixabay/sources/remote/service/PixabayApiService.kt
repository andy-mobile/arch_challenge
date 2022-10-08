package com.example.coding.data.sources.pixabay.sources.remote.service

import com.example.coding.data.sources.pixabay.Constants
import com.example.coding.data.sources.pixabay.sources.remote.model.HitsRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApiService {

    @GET("/api/")
    suspend fun find(
        @Query("key") key: String = Constants.API_KEY,
        @Query("q") query: String,
        @Query("lang") lang: String? = null,
        @Query("id") id: String? = null,
        @Query("image_type") imageType: String? = null,
        @Query("orientation") orientation: String? = null,
        @Query("category") category: String? = null,
        @Query("min_width") minWidth: Int? = null,
        @Query("min_height") minHeight: Int? = null,
        @Query("colors") colors: String? = null,
        @Query("editors_choice") editorsChoice: Boolean = false,
        @Query("safesearch") safeSearch: Boolean = false,
        @Query("order") order: String? = null,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 1,
        @Query("pretty") pretty: Boolean = false
    ): HitsRemote
}