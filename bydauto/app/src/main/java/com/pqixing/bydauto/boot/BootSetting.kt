package com.pqixing.bydauto.boot

import android.app.Activity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import com.pqixing.bydauto.App
import com.pqixing.bydauto.setting.DSetting

class BootSetting : DSetting("启动") {
    companion object {
        const val IS_BOOT: String = "IS_BOOT"
        const val AUTO_FINISH: String = "AUTO_FINISH"
    }

    override fun onUiCreate(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View {
        val content = LinearLayout(activity)
        content.orientation = LinearLayout.HORIZONTAL
        content.gravity = Gravity.CENTER_VERTICAL
        val boot = CheckBox(activity)
        boot.gravity = Gravity.CENTER_VERTICAL
        boot.isChecked = App.sp.getBoolean(IS_BOOT, false)
        boot.text = "开机"
        boot.setPadding(20, 0, 0, 0)
        boot.setOnCheckedChangeListener { _, check ->
            App.sp.edit().putBoolean(IS_BOOT, check).apply()
        }
        content.addView(boot)
        content.addView(View(activity), LinearLayout.LayoutParams(60, 1))

        val launch = CheckBox(activity)
        launch.isChecked = App.sp.getBoolean(AUTO_FINISH, false)
        launch.text = "双击启动"
        launch.setPadding(20, 0, 0, 0)
        launch.setOnCheckedChangeListener { _, check ->
            App.sp.edit().putBoolean(AUTO_FINISH, check).apply()
            if (check) {
                App.toast("5秒内双击启动应用")
            }
        }
        content.addView(launch)
        return content
    }
}