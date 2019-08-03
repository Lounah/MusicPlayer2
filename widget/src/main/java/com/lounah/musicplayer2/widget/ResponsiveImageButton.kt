package com.lounah.musicplayer2.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent.*
import androidx.appcompat.widget.AppCompatImageButton


/**
 *  An [AppCompatImageButton], which reacts on user touch events
 *  If u put a finger on it, it will decrease self scale
 */

private const val SCALE_VALUE_PRESSED = 0.7f

open class ResponsiveImageButton : AppCompatImageButton {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        setOnTouchListener { _, event ->
            when (event.actionMasked) {
                ACTION_DOWN -> animate()
                    .scaleX(SCALE_VALUE_PRESSED)
                    .scaleY(SCALE_VALUE_PRESSED)
                    .start()
                ACTION_UP -> releaseScale(animate = true)
                ACTION_OUTSIDE -> releaseScale(animate = true)
                ACTION_MOVE -> releaseScale(animate = true)
            }
            false
        }
    }

    override fun performClick(): Boolean {
        animate()
            .scaleX(SCALE_VALUE_PRESSED)
            .scaleY(SCALE_VALUE_PRESSED)
            .withEndAction { postInvalidateOnAnimation() }
            .start()

        releaseScale(animate = true)
        return super.performClick()
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        releaseScale()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        releaseScale()
    }

    private fun releaseScale(animate: Boolean = false) {
        if (animate)
            animate()
                .scaleX(1f)
                .scaleY(1f)
                .start()
        else {
            scaleX = 1f
            scaleY = 1f
        }
    }
}