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
import com.pqixing.bydauto.service.LaunchSplitCASExe
import com.pqixing.bydauto.utils.AdbManager
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


    private var touch: TouchBarContentView
    private var content: FrameLayout


    init {
        inflate(context, R.layout.ui_recent_float, this)
        touch = findViewById(R.id.ll_touch_bar)
        content = findViewById(R.id.fl_content)
        val items = listOf(
            TouchBarContentView.BarItem("下拉设置") {
                AdbManager.getClient().runAsync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
            },
            TouchBarContentView.BarItem("返回", 3) { CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK) },
            TouchBarContentView.BarItem("快捷", 3) {
                val musicPkg = UiUtils.getDefualtMusic()
                if (UiManager.inSplitMode && UiManager.isResumePkg("com.byd.automap")
                    && UiManager.isResumePkg(musicPkg)
                ) {
                    UiUtils.sendDiCmd("左右互换")
                } else CAService.performs(
                    ActionCASExe(AccessibilityService.GLOBAL_ACTION_HOME) to 0L,
                    LaunchCASExe(musicPkg) to 1000L,
                    LaunchSplitCASExe("com.byd.automap") to 1500L,
                )
            },
            TouchBarContentView.BarItem("分屏") { CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) },
        )
        touch.setItems(items)
    }


    fun setLeft(left: Boolean): RecentFloatView {
        val params = touch.layoutParams as LayoutParams
        params.gravity = if (left) Gravity.LEFT else Gravity.RIGHT
        return this
    }

}