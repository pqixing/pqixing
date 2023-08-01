package com.pqixing.bydauto.ui

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.ActionCASExe
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.service.LaunchCASExe
import com.pqixing.bydauto.utils.BYDAutoUtils

class RecentFloatView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

//    var bottomFloatHeight: Int = UiUtils.dp2dx(100)

    var barContent: TouchBarContentView
    var content: FrameLayout


    init {
        inflate(context, R.layout.ui_recent_float, this)
        barContent = findViewById<TouchBarContentView>(R.id.ll_touch_bar)
        content = findViewById<FrameLayout>(R.id.fl_content)
        val items = listOf("返回", "快捷", "分屏")
        barContent.setItems(items) { index, distance ->
            when (items[index]) {
                "返回" -> CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK)
                "快捷" -> CAService.performs(
                    ActionCASExe(AccessibilityService.GLOBAL_ACTION_HOME) to 0L,
                    LaunchCASExe(getDefualtMusic()) to 1500L,
                    ActionCASExe(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) to 1500L,
                    LaunchCASExe("com.byd.automap") to 500L,
                )

                "分屏" -> CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
            }

        }
//        setPadding(0, 0, 0, bottomFloatHeight)
    }

    fun getDefualtMusic(): String {
        return BYDAutoUtils.getCurrentAudioFocusPackage()?.trim()?.takeIf { it.isNotEmpty() }
            ?: Const.SP_MUSIC_PKG.trim().takeIf { it.isNotEmpty() }
            ?: "com.kuwo.tingshu"
    }

    fun setLeft(left: Boolean): RecentFloatView {
        val params = barContent.layoutParams as LayoutParams
        params.gravity = if (left) Gravity.LEFT else Gravity.RIGHT
        return this
    }

}