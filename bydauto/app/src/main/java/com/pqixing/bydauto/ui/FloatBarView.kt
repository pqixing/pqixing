package com.pqixing.bydauto.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.UiUtils

class FloatBarView : FrameLayout {
    companion object {
        const val LONG_PRESS_TIME = 600L
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var onDownTime = -1L
    private var onTouchUp: (short: Boolean, e: MotionEvent) -> Unit = { _, _ -> }
    private var onTouchDrawable: Drawable = ColorDrawable(Color.GRAY)

    var minDefault = UiUtils.dp2dx(5)
    var minPress = 3 * minDefault


    private var onLongPress = Runnable { isSelected = true }

    fun setOnTouchUp(onTouchDrawable: Drawable?, onTouchUp: (short: Boolean, e: MotionEvent) -> Unit) {
        this.onTouchUp = onTouchUp
        this.onTouchDrawable = onTouchDrawable ?: ColorDrawable(Color.GRAY)
    }

    init {
        setState(false)
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        e ?: return true
        if (e.action == MotionEvent.ACTION_UP) {
            App.get().mHandle.removeCallbacks(onLongPress)
            onTouchUp.invoke(
                System.currentTimeMillis() - onDownTime <= LONG_PRESS_TIME,
                e
            )
            setState(false)

        } else if (e.action == MotionEvent.ACTION_DOWN || onDownTime == -1L) {
            App.get().mHandle.postDelayed(onLongPress, LONG_PRESS_TIME)
            setState(true)
        }
        return true
    }

    fun setState(press: Boolean) {
        isSelected = false
        background = if (press) onTouchDrawable else null
        onDownTime = if (press) System.currentTimeMillis() else -1L
        minimumHeight = if (press) minPress else minDefault
        minimumWidth = if (press) minPress else minDefault
    }
}