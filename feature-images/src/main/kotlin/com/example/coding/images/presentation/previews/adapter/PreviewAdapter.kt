package com.example.coding.images.presentation.previews.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.example.coding.images.presentation.common.model.PreviewItemModel

class PreviewAdapter(
    private val onClick: (PreviewItemModel) -> Unit
) : PagingDataAdapter<PreviewItemModel, PreviewViewHolder>(DiffCallback) {
    private object DiffCallback : ItemCallback<PreviewItemModel>() {
        override fun areItemsTheSame(
            oldItem: PreviewItemModel,
            newItem: PreviewItemModel
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: PreviewItemModel,
            newItem: PreviewItemModel
        ): Boolean = oldItem == newItem

        override fun getChangePayload(
            oldItem: PreviewItemModel,
            newItem: PreviewItemModel
        ) = Any()
    }

    override fun onBindViewHolder(
        holder: PreviewViewHolder,
        position: Int
    ) {
        val item = getItem(position)
            ?: return

        holder.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = PreviewViewHolder(parent, onClick)
}