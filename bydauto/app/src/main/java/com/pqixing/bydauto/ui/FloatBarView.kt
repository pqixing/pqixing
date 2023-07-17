package com.pqixing.bydauto.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.UiUtils

class FloatBarView : RecyclerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        minimumWidth = 10
//        minimumHeight = context.resources.displayMetrics.heightPixels
//        background = ColorDrawable(Color.GRAY)
    }

    fun setReverse(reverse: Boolean): FloatBarView {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, reverse)
        return this
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        if (e?.action == MotionEvent.ACTION_UP) {
            val isChecked = !Const.SP_FULL_SCREEN
            val cmd = "wm overscan 0,${if (isChecked) -UiUtils.getStatusBarH(context) else 0},0,${
                if (isChecked) -UiUtils.getNavigationBarH(context) else 0
            }"
            AdbManager.getClient().runAsync(cmd)
            Const.SP_FULL_SCREEN = isChecked
        }
        return true
    }
}