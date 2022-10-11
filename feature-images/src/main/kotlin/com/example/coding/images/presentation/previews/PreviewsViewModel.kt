package com.example.coding.images.presentation.previews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.coding.common.delegate.SingleBufferedEventObserver
import com.example.coding.images.domain.interactor.GetHitByItemIdUseCase
import com.example.coding.images.domain.interactor.GetHitPagedUseCase
import com.example.coding.images.domain.interactor.PreviewStateInteractor
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
    private val previewStateInteractor: PreviewStateInteractor,
    singleBufferedEvent: SingleBufferedEventObserver<PreviewsViewModelEffect>
) : ViewModel(),
    SingleBufferedEventObserver<PreviewsViewModelEffect> by singleBufferedEvent {

    sealed interface PreviewsViewModelEffect {
        data class OpenDetailScreen(val param: DetailItemModel) : PreviewsViewModelEffect
    }

    internal data class ViewState(
        val query: String? = null
    )

    private val queryFlow = MutableStateFlow(ViewState())
    val query = queryFlow.asStateFlow()

    val pageData: Flow<PagingData<PreviewItemModel>> = queryFlow
        .map { it.query }
        .filterNotNull()
        .debounce(QUERY_DEBOUNCE)
        .flatMapLatest { getHit(it) }
        .map { items -> items.map { hitEntityMapper.map(it) } }
        .cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
            val query = previewStateInteractor.value
            queryFlow.value = ViewState(query = query.query)
        }
    }

    fun onPreviewCLick(value: PreviewItemModel) {
        viewModelScope.launch {
            val full = getHitById(value.id)
                ?: return@launch

            val detail = hitEntityToDetailMapper.map(full)
            OpenDetailScreen(detail).emmit()
        }
    }

    fun onTextChanged(text: String) {
        queryFlow.value = queryFlow.value.copy(query = text)
        viewModelScope.launch { previewStateInteractor.setQuery(text) }
    }

    companion object {
        private const val QUERY_DEBOUNCE = 300L
    }
}