package com.pqixing.bydauto.ui

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Point
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cgutman.androidremotedebugger.service.ShellService
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.MainService

class SettingActivity : Activity() {
    var splitWidth = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!Settings.canDrawOverlays(this)) kotlin.runCatching {
            val i = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setData(Uri.parse("package:${packageName}"))
            startActivity(i)
        }
        //从应用启动
        if (intent.getStringExtra("from") == "boot") {
            finish()
            return
        }
        startService(Intent(this, MainService::class.java))
        startService(Intent(this, ShellService::class.java))
        setContentView(R.layout.activity_settings)

        val rvData = findViewById<RecyclerView>(R.id.rv_data)
        updaLayoutManager(rvData)
        rvData.adapter = SettingAdapter(Const.settings)
        rvData.isNestedScrollingEnabled = true
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updaLayoutManager(findViewById<RecyclerView>(R.id.rv_data))
    }

    private fun updaLayoutManager(rvData: RecyclerView) {

        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE && splitWidth <= 0) {
            val point = Point()
            windowManager.defaultDisplay.getRealSize(point)
            splitWidth = (point.x * 0.75).toInt()
        }

        if (orientation == Configuration.ORIENTATION_LANDSCAPE && resources.displayMetrics.widthPixels >= splitWidth) {
            rvData.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        } else {
            rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        Log.w("SettingActivity", "enforceCallingOrSelfPermission: $permission")
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        Log.w("SettingActivity", "enforceCallingPermission: ")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}


