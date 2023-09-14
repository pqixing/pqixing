package com.pqixing.bydauto.widget

import android.content.Context
import android.content.res.Configuration
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.utils.toast

class DefaultFloatView : View {

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        "onConfigurationChanged = ${newConfig.orientation}".toast()
        UiUtils.switchFullScreen(context, Const.SP_FULL_SCREEN, newConfig.orientation)
    }


    override fun getLayoutParams(): ViewGroup.LayoutParams {
        return (super.getLayoutParams() as? WindowManager.LayoutParams ?: createParams()).also {
            it.screenOrientation = Const.SP_ORIENTATION
        }
    }

    private fun createParams(): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = 1
            it.height = 1
            it.format = PixelFormat.TRANSLUCENT
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            it.gravity = Gravity.CENTER
            it.alpha = 0f
        }
    }
}