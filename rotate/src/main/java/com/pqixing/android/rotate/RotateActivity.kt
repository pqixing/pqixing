package com.pqixing.android.rotate

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup

class RotateActivity : Activity() {
    companion object {
        fun getSp(context: Context): SharedPreferences = context.getSharedPreferences("BOOT", 0)
    }

    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rotate_activity)
        tryStartService(intent.getBooleanExtra("fromBoot", false))

        sp = getSp(this)
        val cbBoot = findViewById<CheckBox>(R.id.cbBoot)
        cbBoot.isChecked = sp.getBoolean("boot", false)

        val lastCheckedId = findRadioId(sp.getInt("orientation", ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED))
        findViewById<RadioButton>(lastCheckedId)?.isChecked = true

        cbBoot.setOnCheckedChangeListener { _, checked -> sp.edit().putBoolean("boot", checked).apply() }
        findViewById<RadioGroup>(R.id.group).setOnCheckedChangeListener { _, checkedId -> onCheckChange(checkedId) }
        findViewById<View>(R.id.tvAbout).setOnClickListener { startBrowse("https://github.com/pqixing/pqixing") }
    }

    private fun findRadioId(orientation: Int): Int {
        return when (orientation) {
            ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR -> R.id.rbFullSensor
            ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE -> R.id.rbLandScape
            ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT -> R.id.rbPortrait
            else -> R.id.rbUndefine
        }
    }

    private fun onCheckChange(checkedId: Int) {
        val orientation = when (checkedId) {
            R.id.rbFullSensor -> ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
            R.id.rbLandScape -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
            R.id.rbPortrait -> ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT
            else -> ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        }
        sp.edit().putInt("orientation", orientation).apply()
        tryStartService()
    }

    private fun startBrowse(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)))
    }

    fun tryStartService(exit: Boolean = false) {
        if (Settings.canDrawOverlays(this)) {
            startService(Intent(this, RotateService::class.java))
            if (exit) finish()
        } else {
            startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION).setData(Uri.parse("package:$packageName")))
        }
    }
}