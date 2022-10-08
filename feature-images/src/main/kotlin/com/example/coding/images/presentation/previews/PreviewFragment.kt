package com.example.coding.images.presentation.previews

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coding.common.delegate.collectEvent
import com.example.coding.common.delegate.viewBinding
import com.example.coding.images.R
import com.example.coding.images.databinding.PreviewFragmentBinding
import com.example.coding.images.di.scope.FeatureImages
import com.example.coding.images.api.ImagesNavigator
import com.example.coding.images.core.ui.adapter.GridSpacesItemDecoration
import com.example.coding.images.di.injector
import com.example.coding.images.presentation.previews.PreviewsViewModel.PreviewsViewModelEffect.OpenDetailScreen
import com.example.coding.images.presentation.previews.adapter.PreviewAdapter
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class PreviewFragment : Fragment(R.layout.preview_fragment) {

    @Inject
    @FeatureImages
    protected lateinit var navigator: ImagesNavigator

    @Inject
    @FeatureImages
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<PreviewsViewModel> { viewModelFactory }

    private val binding by viewBinding(PreviewFragmentBinding::bind)

    private val previewAdapter = PreviewAdapter { item ->
        viewModel.onPreviewCLick(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareView()
        bindData()
    }

    private fun bindData() {
        lifecycleScope.launchWhenStarted {
            viewModel.pageData.collectLatest {
                previewAdapter.submitData(it)
            }
        }

        viewModel.collectEvent(viewLifecycleOwner) { event ->
            when (event) {
                is OpenDetailScreen -> {
                    navigator.toDetailsScreen(event.param, parentFragmentManager)
                }
            }
        }
    }

    private fun prepareView() {
        with(binding.previewsView) {
            adapter = previewAdapter
            val spanCount = if (resources.getBoolean(R.bool.isLandscape)) 2 else 1
            layoutManager = GridLayoutManager(requireContext(), spanCount)
            val space = resources.getDimension(R.dimen.space_decoration).toInt()
            addItemDecoration(GridSpacesItemDecoration(spacing = space, includeEdge = true))
        }

        binding.inputTextView.doOnTextChanged { text, _, _, _ ->
            viewModel.onTextChanged(text)
        }

        binding.inputLayout.setEndIconOnClickListener {}
    }
}