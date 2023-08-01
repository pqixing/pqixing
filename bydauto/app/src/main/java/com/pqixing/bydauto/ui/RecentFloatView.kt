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
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils

class RecentFloatView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    var barContent: TouchBarContentView
    var content: FrameLayout


    init {
        inflate(context, R.layout.ui_recent_float, this)
        barContent = findViewById<TouchBarContentView>(R.id.ll_touch_bar)
        content = findViewById<FrameLayout>(R.id.fl_content)
        val items = listOf(
            TouchBarContentView.BarItem("返回") { CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK) },
            TouchBarContentView.BarItem("快捷") {
                if (UiManager.inSplitMode && UiManager.isResumeActivity("com.byd.automap")
                    && UiManager.isResumeActivity(getDefualtMusic())
                ) {
                    UiUtils.sendDiCmd("左右互换")
                } else CAService.performs(
                    ActionCASExe(AccessibilityService.GLOBAL_ACTION_HOME) to 0L,
                    LaunchCASExe(getDefualtMusic()) to 800L,
                    ActionCASExe(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) to 1500L,
                    LaunchCASExe("com.byd.automap") to 500L,
                )
            },
            TouchBarContentView.BarItem("分屏") { CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) },
        )
        barContent.setItems(items)
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