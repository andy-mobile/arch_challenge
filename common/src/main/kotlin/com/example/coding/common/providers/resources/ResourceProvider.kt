package com.example.coding.common.providers.resources

import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import androidx.annotation.*
import java.io.File
import java.io.InputStream

interface ResourceProvider {

    val packageName: String

    val density: Float

    fun getString(@StringRes res: Int): String

    fun getString(@StringRes res: Int, vararg args: Any): String

    fun getStringArray(@ArrayRes res: Int): List<String>

    fun getIntegerArray(resId: Int): List<Int>

    fun getInteger(resId: Int): Int

    fun getColor(@ColorRes res: Int): Int

    @Px
    fun getDimensionPixelSize(dimenRes: Int): Int

    fun getBoolean(resId: Int): Boolean

    @Px
    fun px(dp: Int): Float

    fun getDrawable(@DrawableRes resId: Int): Drawable?

    fun openRawResource(resId: Int): InputStream

    fun getFilesDir(): File

    fun getAssets(): AssetManager
}