//package com.pqixing.bydauto.ui
//
//import android.accessibilityservice.AccessibilityService
//import android.content.Context
//import android.util.AttributeSet
//import android.view.MotionEvent
//import android.view.View
//import android.widget.FrameLayout
//import androidx.recyclerview.widget.RecyclerView
//import com.pqixing.bydauto.App
//import com.pqixing.bydauto.R
//import com.pqixing.bydauto.model.Const
//import com.pqixing.bydauto.service.CAService
//import com.pqixing.bydauto.utils.AdbManager
//import com.pqixing.bydauto.utils.UiManager
//import com.pqixing.bydauto.utils.UiUtils
//import kotlinx.coroutines.launch
//
//class FloatBarMenuView : FrameLayout {
//    companion object {
//        const val FLOAT_TAG_BAR_MEMU = "FLOAT_TAG_BAR_MEMU"
//    }
//
//    constructor(context: Context) : super(context)
//
//    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
//
//    private val close = Runnable { UiUtils.closeFloatView(FLOAT_TAG_BAR_MEMU) }
//
//    init {
//
//        inflate(context, R.layout.float_bar_menu, this)
//        findViewById<View>(R.id.cb_home).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME) }
//        findViewById<View>(R.id.cb_recent).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS) }
//        findViewById<View>(R.id.cb_split).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN) }
//        findViewById<View>(R.id.cb_full).setOnClickListener { UiUtils.switchFullScreen(context, !Const.SP_FULL_SCREEN) }
//        findViewById<View>(R.id.cb_back).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK) }
//        findViewById<View>(R.id.cb_notify).setOnClickListener { CAService.perform(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS) }
//        findViewById<View>(R.id.cb_air_control).setOnClickListener {
//            AdbManager.getClient().runAsync("input tap 100 1100 && input tap 100 1100 ")
//        }
//        findViewById<View>(R.id.cb_setting).setOnClickListener {
//            AdbManager.getClient().runAsync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
//        }
//        findViewById<View>(R.id.iv_close).setOnClickListener { close.run() }
//
//        App.get().uiScope.launch {
//            val infos = UiManager.getAppInfo(emptyList())
//            val rcvDatas = findViewById<RecyclerView>(R.id.rcv_apps)
//            rcvDatas.adapter = AppAdapter(infos, FLOAT_TAG_BAR_MEMU)
//            App.get().mHandle.postDelayed(close, 15000L)
//        }
//    }
//
//    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        App.get().mHandle.removeCallbacks(close)
//        if (ev?.action == MotionEvent.ACTION_UP || ev?.action == MotionEvent.ACTION_CANCEL) {
//            App.get().mHandle.postDelayed(close, 15000L)
//        }
//
//        return super.dispatchTouchEvent(ev)
//    }
//
//    override fun onDetachedFromWindow() {
//        super.onDetachedFromWindow()
//        App.get().mHandle.removeCallbacks(close)
//    }
//}