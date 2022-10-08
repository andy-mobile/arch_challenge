package com.example.coding.images.presentation.previews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.coding.common.delegate.SingleBufferedEventObserver
import com.example.coding.images.domain.interactor.GetHitByItemIdUseCase
import com.example.coding.images.domain.interactor.GetHitPagedUseCase
import com.example.coding.images.presentation.common.mapper.HitEntityToDetailMapper
import com.example.coding.images.presentation.common.mapper.HitEntityToPreviewMapper
import com.example.coding.images.presentation.common.model.DetailItemModel
import com.example.coding.images.presentation.common.model.PreviewItemModel
import com.example.coding.images.presentation.previews.PreviewsViewModel.PreviewsViewModelEffect
import com.example.coding.images.presentation.previews.PreviewsViewModel.PreviewsViewModelEffect.OpenDetailScreen
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class PreviewsViewModel
@Inject
constructor(
    private val hitEntityMapper: HitEntityToPreviewMapper,
    private val hitEntityToDetailMapper: HitEntityToDetailMapper,
    private val getHit: GetHitPagedUseCase,
    private val getHitById: GetHitByItemIdUseCase,
    singleBufferedEvent: SingleBufferedEventObserver<PreviewsViewModelEffect>
) : ViewModel(),
    SingleBufferedEventObserver<PreviewsViewModelEffect> by singleBufferedEvent {

    sealed interface PreviewsViewModelEffect {
        data class OpenDetailScreen(val param: DetailItemModel) : PreviewsViewModelEffect
    }

    private val queryFlow = MutableStateFlow("")

    val pageData: Flow<PagingData<PreviewItemModel>> = queryFlow
        .flatMapLatest { getHit(it) }
        .map { items -> items.map { hitEntityMapper.map(it) } }
        .cachedIn(viewModelScope)

    fun onPreviewCLick(value: PreviewItemModel) {
        viewModelScope.launch {
            val full = getHitById(value.id)
                ?: return@launch

            val detail = hitEntityToDetailMapper.map(full)
            OpenDetailScreen(detail).emmit()
        }
    }

    fun onTextChanged(text: CharSequence?) {
        queryFlow.value = text?.toString().orEmpty()
    }
}