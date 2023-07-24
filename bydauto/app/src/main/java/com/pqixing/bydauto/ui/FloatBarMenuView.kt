package com.pqixing.bydauto.ui

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.pm.PackageManager
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FloatBarMenuView : FrameLayout {
    companion object {
        const val FLOAT_TAG_BAR_MEMU = "FLOAT_TAG_BAR_MEMU"
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val close = Runnable { UiUtils.closeFloatView(FLOAT_TAG_BAR_MEMU) }

    init {

        inflate(context, R.layout.float_bar_menu, this)
        findViewById<View>(R.id.cb_home).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME) }
        findViewById<View>(R.id.cb_recent).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS) }
        findViewById<View>(R.id.cb_split).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) }
        findViewById<View>(R.id.cb_lock).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_LOCK_SCREEN) }
        findViewById<View>(R.id.cb_back).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK) }
        findViewById<View>(R.id.cb_notify).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS) }
        findViewById<View>(R.id.cb_air_control).setOnClickListener { AdbManager.getClient().runAsync("input tap 100 1100") }
        findViewById<View>(R.id.cb_setting).setOnClickListener {  AdbManager.getClient().runAsync("input swipe 100 -10 100 300") }
        findViewById<View>(R.id.iv_close).setOnClickListener { close.run() }

        App.get().uiScope.launch {
            val infos = withContext(Dispatchers.IO) {
                val pkgs =
                    context.packageManager.getInstalledApplications(PackageManager.MATCH_ALL).map { it.packageName }
                UiUtils.loadAppInfos(context, pkgs).filter { it.intent != null }
            }
            val rcvDatas = findViewById<RecyclerView>(R.id.rcv_apps)
            rcvDatas.adapter = AppAdapter(infos, FLOAT_TAG_BAR_MEMU)
            App.get().mHandle.postDelayed(close, 5000L)
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        App.get().mHandle.removeCallbacks(close)
        if (ev?.action == MotionEvent.ACTION_UP || ev?.action == MotionEvent.ACTION_CANCEL) {
            App.get().mHandle.postDelayed(close, 5000L)
        }

        return super.dispatchTouchEvent(ev)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        App.get().mHandle.removeCallbacks(close)
    }
}