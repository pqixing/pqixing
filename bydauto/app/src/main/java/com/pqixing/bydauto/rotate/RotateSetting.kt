package com.pqixing.bydauto.rotate

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.PixelFormat
import android.net.Uri
import android.provider.Settings
import android.view.*
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SettingImpl

class RotateSetting : SettingImpl("强制旋转") {
    private var mView: View? = null

    override fun onServiceCreate(context: Context) {
        super.onServiceCreate(context)
        val orientation = App.sp.getInt("orientation", ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
        updateFloatView(context, orientation)
    }

    private fun updateFloatView(context: Context, orientation: Int) {
        if (!Settings.canDrawOverlays(context)) kotlin.runCatching {
            val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.parse("package:${context.packageName}"))
            context.startActivity(i)
        }

        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        if (orientation == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {
            removeFloatView(context)
        } else if (mView == null) {
            mView = View(context)
            wm.addView(mView, layoutParams(orientation))
        } else {
            wm.updateViewLayout(mView, layoutParams(orientation))
        }
        mView?.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN;
    }

    override fun onServiceDestroy(context: Context) {
        super.onServiceDestroy(context)
        removeFloatView(context)
    }

    private fun layoutParams(orientation: Int): WindowManager.LayoutParams {
        return WindowManager.LayoutParams().also {
            it.width = 1
            it.height = 1
            it.format = PixelFormat.TRANSLUCENT
            it.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            it.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or WindowManager.LayoutParams.FLAG_FULLSCREEN
            it.gravity = Gravity.START or Gravity.TOP
            it.systemUiVisibility  = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN;

            it.screenOrientation = orientation
            it.alpha = 0f
        }
    }

    private fun removeFloatView(context: Context) {
        if (mView != null) kotlin.runCatching {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            wm.removeView(mView)
            mView = null
        }
    }

    override fun onBind(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View {
        val rotate: RadioGroup = inflater.inflate(R.layout.rotate_charge, container, false) as RadioGroup
        val lastCheckedId = findRadioId(App.sp.getInt("orientation", ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED))
        rotate.findViewById<RadioButton>(lastCheckedId)?.isChecked = true
        rotate.setOnCheckedChangeListener { _, checkedId -> onCheckChange(activity, checkedId) }
        return rotate
    }


    private fun onCheckChange(context: Context, checkedId: Int) {
        val orientation = when (checkedId) {
            R.id.rbFullSensor -> ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
            R.id.rbLandScape -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
            R.id.rbPortrait -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
            else -> ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        }
        App.sp.edit().putInt("orientation", orientation).apply()
        updateFloatView(context, orientation)
    }

    private fun findRadioId(orientation: Int): Int {
        return when (orientation) {
            ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR -> R.id.rbFullSensor
            ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE -> R.id.rbLandScape
            ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT -> R.id.rbPortrait
            else -> R.id.rbUndefine
        }
    }
}