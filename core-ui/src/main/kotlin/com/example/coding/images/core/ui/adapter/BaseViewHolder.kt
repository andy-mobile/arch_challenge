package com.example.coding.images.core.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T, V : ViewBinding>(
    val binding: V,
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: T)
}