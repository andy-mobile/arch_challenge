package com.example.coding.data.sources.api.dto

data class HitsDTO(
    val total: Int,
    val totalHits: Int,
    val hits: List<HitDTO>
)
