package com.example.coding.datasources

import android.content.Context
import com.example.coding.data.sources.api.di.PixabayProvider
import com.example.coding.data.sources.pixabay.di.DaggerPixabayComponent

fun PixabayProvider.Companion.get(context: Context): PixabayProvider = DaggerPixabayComponent
    .builder()
    .applicationContext(context)
    .build()