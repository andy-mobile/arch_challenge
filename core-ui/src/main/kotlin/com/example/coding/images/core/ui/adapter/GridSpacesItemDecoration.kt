package com.example.coding.images.core.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import kotlin.math.roundToInt

class GridSpacesItemDecoration(
    private val spacing: Int = 0,
    private val includeEdge: Boolean = false,
    private val types: IntArray = intArrayOf(0)
) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val layoutManager = parent.layoutManager as? GridLayoutManager ?: return
        val type = parent.getChildViewHolder(view).itemViewType
        if (!types.contains(type)) return

        val spanCount = layoutManager.spanCount

        val position = parent.getChildAdapterPosition(view)
        val column = layoutManager.spanSizeLookup.getSpanIndex(position, spanCount)

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount
            outRect.right = (column + 1) * spacing / spanCount
            outRect.top = (spacing * .5f).roundToInt()
            outRect.bottom = (spacing * .5f).roundToInt() // item bottom
        } else {
            when (layoutManager.orientation) {
                RecyclerView.HORIZONTAL -> {
                    outRect.top = column * spacing / spanCount
                    outRect.bottom = spacing - (column + 1) * spacing / spanCount
                    if (position >= spanCount) {
                        outRect.left = spacing // item top
                    }
                }
                RecyclerView.VERTICAL -> {
                    outRect.left = column * spacing / spanCount
                    outRect.right = spacing - (column + 1) * spacing / spanCount
                    if (position >= spanCount) {
                        outRect.top = spacing // item top
                    }
                }
            }
        }
    }
}
