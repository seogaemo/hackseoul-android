package com.seogaemo.hackseoul_android.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.journeyapps.barcodescanner.ViewfinderView
import com.seogaemo.hackseoul_android.R

class ViewFinderViewEx @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
) : ViewfinderView(context, attrs) {
    private val density = context.resources.displayMetrics.density

    private val radius = 40f

    private val backgroundRect = Rect()
    private val roundRect = RectF()

    private val transparentPaint = Paint().apply {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    private val textPaint = Paint().apply {
        color = 0xFFFFFFFF.toInt()
        textSize = 15 * density
        isAntiAlias = true
        textAlign = Paint.Align.CENTER
        typeface = resources.getFont(R.font.pretendard_medium)
    }


    private val text = "제품의 QR을 스캔해주세요"
    private val textOffsetDp = 26f * density

    override fun onDraw(canvas: Canvas) {
        refreshSizes()

        if (framingRect == null) return

        roundRect.apply {
            left = framingRect.left.toFloat()
            top = framingRect.top.toFloat()
            right = framingRect.right.toFloat()
            bottom = framingRect.bottom.toFloat()
        }

        backgroundRect.apply {
            left = 0
            top = 0
            right = width
            bottom = height
        }

        paint.apply {
            color = maskColor
            alpha = 0x66
        }

        val guideViewVector =
            VectorDrawableCompat.create(context.resources, R.drawable.qr_background, null)?.apply {
                setBounds(roundRect.left.toInt(), roundRect.top.toInt(), roundRect.right.toInt(), roundRect.bottom.toInt())
            }

        canvas.apply {
            drawRect(backgroundRect, paint)

            drawRoundRect(roundRect, radius, radius, transparentPaint)

            guideViewVector?.draw(this)

            val textX = width / 2f
            val textY = roundRect.bottom + textOffsetDp + textPaint.textSize / 2
            drawText(text, textX, textY, textPaint)
        }
    }
}
