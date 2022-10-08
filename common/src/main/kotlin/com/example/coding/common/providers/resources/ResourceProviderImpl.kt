package com.example.coding.common.providers.resources

import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import androidx.core.content.ContextCompat
import java.io.File

class ResourceProviderImpl constructor(
    private val context: Context
) : ResourceProvider {
    override val packageName: String
        get() = context.packageName

    private val resources: Resources
        get() = context.resources

    override val density: Float
        get() = resources.displayMetrics.density

    override fun getString(res: Int) = resources.getString(res)

    override fun getString(res: Int, vararg args: Any) = resources.getString(res, *args)

    override fun getStringArray(res: Int): List<String> = resources.getStringArray(res).asList()

    override fun getColor(res: Int) = ContextCompat.getColor(context, res)

    override fun getIntegerArray(resId: Int): List<Int> = resources
        .getIntArray(resId).toTypedArray().toList()

    override fun getInteger(resId: Int) = resources.getInteger(resId)

    override fun getDimensionPixelSize(dimenRes: Int) = resources.getDimensionPixelSize(dimenRes)

    override fun getBoolean(resId: Int) = resources.getBoolean(resId)

    override fun px(dp: Int): Float = dp * resources.displayMetrics.density

    override fun getDrawable(resId: Int) = ContextCompat.getDrawable(context, resId)

    override fun openRawResource(resId: Int) = resources.openRawResource(resId)

    override fun getFilesDir(): File = context.filesDir

    override fun getAssets(): AssetManager = resources.assets
}