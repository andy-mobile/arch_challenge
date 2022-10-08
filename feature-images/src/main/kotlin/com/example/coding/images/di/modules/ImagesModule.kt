package com.example.coding.images.di.modules

import androidx.lifecycle.ViewModel
import com.example.coding.common.delegate.SingleBufferedEventObserver
import com.example.coding.common.delegate.SingleBufferedEventObserverImpl
import com.example.coding.common.di.viewmodel.ViewModelKey
import com.example.coding.images.di.scope.FeatureImages
import com.example.coding.images.presentation.previews.PreviewsViewModel
import com.example.coding.images.presentation.previews.PreviewsViewModel.PreviewsViewModelEffect
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ImagesModule {

    @FeatureImages
    @Binds
    @IntoMap
    @ViewModelKey(PreviewsViewModel::class)
    fun bindPreviewsViewModel(viewModel: PreviewsViewModel): ViewModel


    @Binds
    @FeatureImages
    fun singleBufferedEvent(what: SingleBufferedEventObserverImpl<PreviewsViewModelEffect>): SingleBufferedEventObserver<PreviewsViewModelEffect>
}