package com.seogaemo.hackseoul_android.util

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

internal class SpacingItemDecoration : RecyclerView.ItemDecoration() {
    private val negativeSpacing = (-2f * Resources.getSystem().displayMetrics.density).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        if (position > 0) {
            outRect.top = negativeSpacing
        }
    }
}
