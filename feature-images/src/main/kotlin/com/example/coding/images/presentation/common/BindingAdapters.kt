package com.example.coding.images.presentation.common

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.coding.images.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

@BindingAdapter("image")
fun setImage(image: ImageView, url: String) {
    Glide.with(image.context).load(url)
        .centerCrop()
        .override(image.width, image.height)
        .into(image)
}

@BindingAdapter("chips")
fun setChips(parent: ChipGroup, texts: List<String>) {
    parent.removeAllViews()

    for (text in texts) {
        val chip = LayoutInflater.from(parent.context)
            .inflate(R.layout.chip_item, parent,false) as Chip
        chip.text = text
        parent.addView(chip)
    }
}