package com.pqixing.bydauto.widget

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.ui.MainUI
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.UiUtils

class MenuFloatView : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    private var touch = TouchBarContentView(context).also {
        it.layoutParams = LayoutParams(UiUtils.dp2dx(9), ViewGroup.LayoutParams.MATCH_PARENT).also { p ->
            p.topMargin = UiUtils.dp2dx(60)
            p.bottomMargin = UiUtils.dp2dx(60)
        }
        it.orientation = VERTICAL
    }
    private var content = LinearLayout(context).also {
        it.layoutParams = LayoutParams(UiUtils.dp2dx(56), ViewGroup.LayoutParams.MATCH_PARENT).also { p ->
            p.topMargin = UiUtils.dp2dx(60)
            p.bottomMargin = UiUtils.dp2dx(60)
        }
        it.orientation = VERTICAL
        it.isClickable = true
        it.background = ColorDrawable(Color.parseColor("#33000000"))
        it.visibility = View.GONE
    }

    private var left: Boolean = true

    init {
        val items = listOf(
            TouchBarContentView.BarItem("返回") { CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK) },
            TouchBarContentView.BarItem("桌面", 2) { CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME) },
            TouchBarContentView.BarItem("更多") { reShowContent() },
        )
        touch.setItems(items)
    }

    private fun initContent() {
        content.removeAllViews()
        listOf(

            TouchBarContentView.BarItem("返回", 3, R.drawable.icon_menu_back) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK)
            },
            TouchBarContentView.BarItem("桌面", 3, R.drawable.icon_menu_home) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
            },
            TouchBarContentView.BarItem("最近", 3, R.drawable.icon_menu_recent) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
            },
            TouchBarContentView.BarItem("分屏", 3, R.drawable.icon_menu_split) {
                CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
            },
            TouchBarContentView.BarItem("全屏", 3, R.drawable.icon_menu_full) {
                UiUtils.switchFullScreen(context, !Const.SP_FULL_SCREEN)
            },
            TouchBarContentView.BarItem("应用", 3, R.drawable.icon_menu_app) {
                UiUtils.showOrUpdate(ApplicationView.FLOAT_TAG) { ApplicationView(context) }
            },
            TouchBarContentView.BarItem("设置", 3, R.drawable.icon_menu_setting) {
                UiUtils.tryLaunch(context, Intent(context, MainUI::class.java))
            },
            TouchBarContentView.BarItem(
                "",
                1,
                if (left) R.drawable.icon_menu_arrow_left else R.drawable.icon_menu_arrow_right
            ) {
                hideContent.run()
            },
        ).map {
            content.addView(
                TouchBarContentView.BarView(context).setBarItem(it),
                LayoutParams(LayoutParams.MATCH_PARENT, 0, it.weight.toFloat())
            )
        }
    }

    private var hideContent = object : Runnable {
        override fun run() {
            removeCallbacks(this)
            content.visibility = View.GONE
            touch.visibility = View.VISIBLE
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN && content.visibility == View.VISIBLE) {
            reShowContent()
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun getLayoutParams(): ViewGroup.LayoutParams {
        return super.getLayoutParams() as? WindowManager.LayoutParams ?: createParams()
    }

    private fun createParams(): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = WindowManager.LayoutParams.WRAP_CONTENT
            it.height = WindowManager.LayoutParams.MATCH_PARENT
            it.format = PixelFormat.RGBA_8888
            it.flags =
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.gravity = if (left) Gravity.START or Gravity.CENTER_VERTICAL else Gravity.END or Gravity.CENTER_VERTICAL
            it.alpha = 1f
        }
    }

    private fun reShowContent() {
        removeCallbacks(hideContent)
        content.visibility = View.VISIBLE
        touch.visibility = View.GONE
        postDelayed(hideContent, Const.SP_DELAY_DISMISS)
    }

    fun setLeft(left: Boolean): MenuFloatView {
        this.left = left
        removeAllViews()
        if (left) {
            addView(touch)
            addView(content)
        } else {
            addView(content)
            addView(touch)
        }
        initContent()
        return this
    }

}