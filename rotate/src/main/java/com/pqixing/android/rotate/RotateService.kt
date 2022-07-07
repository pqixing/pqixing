package com.pqixing.android.rotate

import android.app.Service
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.graphics.PixelFormat
import android.os.IBinder
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager

class RotateService : Service() {
    lateinit var sp: SharedPreferences
    var mView: View? = null
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if (!this::sp.isInitialized) {
            sp = RotateActivity.getSp(this)
        }
        val orientation = sp.getInt("orientation", ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
        if (orientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            stopSelf()
        } else {
            updateFloatView(orientation)
        }
        Log.v("", "onSta rtCommand action: ${intent.action}")
        return START_STICKY
    }

    private fun updateFloatView(orientation: Int) {
        val wm = getSystemService(WINDOW_SERVICE) as WindowManager
        if (mView != null) {
            wm.updateViewLayout(mView, layoutParams(orientation))
        } else {
            mView = View(this)
            wm.addView(mView, layoutParams(orientation))
        }
    }

    override fun onDestroy() {
        removeView()
        super.onDestroy()
    }

    private fun layoutParams(orientation: Int): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = 1
            it.height = 1
            it.format = PixelFormat.TRANSLUCENT
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            it.gravity = Gravity.START or Gravity.TOP
            it.screenOrientation = orientation
            it.alpha = 0f
        }
    }

    private fun removeView() {
        if (mView != null) kotlin.runCatching {
            val wm = getSystemService(WINDOW_SERVICE) as WindowManager
            wm.removeView(mView)
            mView = null
        }
    }
}