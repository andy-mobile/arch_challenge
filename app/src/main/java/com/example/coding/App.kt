package com.example.coding

import android.app.Application
import com.example.coding.common.di.AppProvider
import com.example.coding.di.init

class App : Application() {
    val appProvider: AppProvider by lazy {
        AppProvider.init(this)
    }
}