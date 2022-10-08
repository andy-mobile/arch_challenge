package com.example.coding.images.presentation.detail

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.coding.common.delegate.viewBinding
import com.example.coding.images.R
import com.example.coding.images.databinding.DetailFragmentBinding
import com.example.coding.images.presentation.common.model.DetailItemModel

class DetailFragment : Fragment(R.layout.detail_fragment) {

    private val binding by viewBinding(DetailFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.model = requireArguments().getDetail()
    }

    companion object {
        private const val ARGUMENTS = "ARGUMENTS"
        operator fun invoke(item: DetailItemModel): DetailFragment = DetailFragment().apply {
            arguments = bundleOf(ARGUMENTS to item)
        }
    }

    @Suppress("DEPRECATION")
    private fun Bundle.getDetail() = getParcelable<DetailItemModel>("ARGUMENTS")
}