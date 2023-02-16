package com.pqixing.android

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.pqixing.android.boot.BootSetting
import com.pqixing.android.setting.SettingManager
import java.io.File
import java.util.*

class MainActivity : Activity() {

    companion object {
        var lastStart: Long = System.currentTimeMillis()
    }

    private var realLaunch = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, MainService::class.java))
        if (requestFinish()) {
            return finish()
        }
        realLaunch = true
        setContentView(R.layout.main_activity)

        findViewById<View>(R.id.tvTitle).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://gitee.com/pqixing/pqixing")))
        }
        findViewById<View>(R.id.tvTitle).setOnLongClickListener {
            App.toast("start download apk")
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://gitee.com/pqixing/pqixing/raw/main/asessts/apks/d_plus.apk")))
            true
        }

        findViewById<View>(R.id.tvAdd).setOnClickListener {
            App.sp.edit().putStringSet("exclude", setOf("调试开关")).apply()
            refreshContainer()
        }
        findViewById<View>(R.id.tvAdd).setOnLongClickListener {
            App.sp.edit().remove("exclude").apply()
            refreshContainer()
            true
        }

        val file = File(cacheDir, "crash.log")

        val ivLog = findViewById<View>(R.id.ivLog)

        ivLog.visibility = if (file.exists()) View.VISIBLE else View.GONE
        ivLog.setOnClickListener { showCrashLog(file, ivLog) }

        ivLog.setOnLongClickListener { throw RuntimeException("---Crash Mock ${System.currentTimeMillis()} : ${Date().toLocaleString()}---") }
        refreshContainer()
    }

    private fun showCrashLog(file: File, ivLog: View) {
        if (!file.exists()) {
            App.toast("日志文件不存在")
            return
        }
        AlertDialog.Builder(this).setMessage(file.readText())
            .setNegativeButton("关闭") { d, i -> d.dismiss() }
            .setPositiveButton("删除") { d, i ->
                d.dismiss()
                kotlin.runCatching {
                    file.delete()
                    App.toast("崩溃日志已删除")
                }
                ivLog.visibility = View.GONE
            }.show()
    }

    private fun requestFinish(): Boolean {
        if (intent.getStringExtra("from") == "boot") return true
        val autoFinish = App.sp.getBoolean(BootSetting.AUTO_FINISH, false)
        if (autoFinish && System.currentTimeMillis() - lastStart > 5000L) {
            lastStart = System.currentTimeMillis()
            return true
        }
        return false
    }

    private fun refreshContainer() {

        val inflater = LayoutInflater.from(this);
        val llContainer = findViewById<LinearLayout>(R.id.llContainer)
        val childCount = llContainer.childCount
        if (childCount > 1) {
            llContainer.removeViews(1, childCount - 1)
        }
        val drawable = getDrawable(android.R.drawable.ic_delete)?.also {
            it.setBounds(0, 0, 40, 40)
        }
        val exclude = App.sp.getStringSet("exclude", null)?.toMutableSet() ?: mutableSetOf()
        SettingManager.settings.filter { !exclude.contains(it.getName()) }.forEach { item ->
            val title = TextView(this).apply {
                text = item.getName()
                gravity = Gravity.CENTER_VERTICAL
                isClickable = true
                textSize = 16f
                setTextColor(Color.GRAY)
                setCompoundDrawables(null, null, drawable, null)
            }
            val child = item.onUiCreate(this, inflater, llContainer)
            llContainer.addView(title,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                    .also {
                        it.setMargins(0, 20, 0, 15)
                    })
            llContainer.addView(child)
            title.setOnLongClickListener {
                llContainer.removeView(title)
                llContainer.removeView(child)
                exclude.add(item.getName())
                App.sp.edit().putStringSet("exclude", exclude).apply()
                true
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (realLaunch) {
            SettingManager.settings.forEach { it.onUiDestroy(this) }
        }
    }


    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingOrSelfPermission: $permission")
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w("MainService", "enforceCallingPermission: ")
    }
}