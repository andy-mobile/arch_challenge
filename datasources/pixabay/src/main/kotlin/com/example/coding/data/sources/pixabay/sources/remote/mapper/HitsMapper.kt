package com.example.coding.data.sources.pixabay.sources.remote.mapper

import com.example.coding.data.sources.api.dto.HitsDTO
import com.example.coding.data.sources.api.exception.MapperException
import com.example.coding.data.sources.pixabay.sources.remote.model.HitsRemote
import javax.inject.Inject

class HitsMapper
@Inject
constructor(
    private val hitMapper: HitMapper
) {

    fun map(item: HitsRemote) = try {
        HitsDTO(
            total = item.total!!,
            totalHits = item.totalHits!!,
            hits = item.hits.orEmpty().map { hitMapper.map(it) }
        )
    } catch (exception: Exception) {
        throw MapperException(exception)
    }
}