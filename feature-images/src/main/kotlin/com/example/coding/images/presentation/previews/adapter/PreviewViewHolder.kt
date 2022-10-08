package com.example.coding.images.presentation.previews.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.coding.images.databinding.PreviewItemBinding
import com.example.coding.images.core.ui.adapter.BaseViewHolder
import com.example.coding.images.presentation.common.model.PreviewItemModel
import kotlin.properties.Delegates

class PreviewViewHolder(
    parent: ViewGroup,
    private val onClick: (PreviewItemModel) -> Unit
) : BaseViewHolder<PreviewItemModel, PreviewItemBinding>(
    PreviewItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
) {
    private var item: PreviewItemModel by Delegates.notNull()

    init {
        itemView.setOnClickListener { onClick(item) }
    }

    override fun bind(item: PreviewItemModel) {
        this.item = item
        binding.model = item
        binding.executePendingBindings()
    }
}