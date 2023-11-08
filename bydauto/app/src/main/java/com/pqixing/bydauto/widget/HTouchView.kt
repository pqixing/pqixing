package com.pqixing.bydauto.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.pqixing.bydauto.R

class HTouchView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, layoutDirection: Int) : super(context) {
        setLayoutDirection(layoutDirection)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

    }


    private val direction = layoutDirection
    private val content = inflate(context, R.layout.float_h_touch, this)

    init {
        layoutDirection
    }

}


