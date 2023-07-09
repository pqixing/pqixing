package com.pqixing.bydauto.ui

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App

class FloatBarView : RecyclerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        minimumHeight = 400
        minimumWidth = 300
        background = ColorDrawable(Color.GREEN)
    }
    fun setReverse(reverse: Boolean): FloatBarView {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, reverse)
        return this
    }

    override fun onTouchEvent(e: MotionEvent?): Boolean {
        if(e?.action == MotionEvent.ACTION_DOWN){
            App.toast("触控")
            minimumWidth += 10
        }
        return super.onTouchEvent(e)
    }
}