package com.pqixing.android

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.pqixing.android.boot.BootSetting
import com.pqixing.android.byd.BYDAutoInstrumentUtils
import com.pqixing.android.setting.SettingManager

class MainActivity : Activity() {

    companion object {
        var instance: MainActivity? = null
        var hadReceiver: Boolean = false
        var tryDelay: Long = 2100L
    }

    var startTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        instance = this
        super.onCreate(savedInstanceState)
        startService(Intent(this, MainService::class.java))
        if (intent.getStringExtra("from") == "boot") {
            return finish()
        }
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val delay = if (hadReceiver && App.sp.getBoolean(BootSetting.AUTO_FINISH, false)) tryDelay else 0L
        App.mThread.postDelayed({ initView() }, delay)
    }

    override fun onResume() {
        super.onResume()
        startTime = System.currentTimeMillis()
    }

    private fun initView() {
        if (isFinishing || isDestroyed) {
            return
        }
        val inflater = LayoutInflater.from(this);
        val content = inflater.inflate(R.layout.main_activity, null)

        content.findViewById<View>(R.id.tvAbout).setOnLongClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://gitee.com/pqixing/pqixing/raw/main/apks/byd-test.apk")))
            true
        }
        content.findViewById<View>(R.id.tvAbout).setOnClickListener {
            App.toast("getAllRadarDistance : ${BYDAutoInstrumentUtils.getAllRadarDistance().joinToString(",")}")
//            startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://gitee.com/pqixing/pqixing")))
        }
        content.findViewById<View>(R.id.tvTitle).setOnClickListener {
            App.toast("getAllRadarStatus : ${BYDAutoInstrumentUtils.getAllRadarStatus().joinToString(",")}")
        }
        val llContainer = content.findViewById<LinearLayout>(R.id.llContainer)
        SettingManager.settings.forEach {
            llContainer.addView(TextView(this).apply {
                text = it.getName()
                setPadding(0, 0, 0, 0)
            })
            llContainer.addView(it.onUiCreate(this, inflater, llContainer))
        }
        runOnUiThread {
            if (!isFinishing && !isDestroyed) {
                window.setBackgroundDrawable(ColorDrawable(Color.WHITE))
                setContentView(content)
            }
        }
    }


    fun onNewBydBroadcast(action: String) {
        hadReceiver = true
        val delay = System.currentTimeMillis() - startTime
        //启动后2秒内，收到byd媒体广播，则自动关闭页面
        if (App.sp.getBoolean(BootSetting.AUTO_FINISH, false)) {
            tryDelay = delay + 1000L
            finish()
        }
    }

    override fun onDestroy() {
        instance = null
        super.onDestroy()
        SettingManager.settings.forEach { it.onUiDestroy(this) }
    }
}