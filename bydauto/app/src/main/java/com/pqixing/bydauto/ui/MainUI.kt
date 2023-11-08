package com.pqixing.bydauto.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.service.MainService
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.SettingManager
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import kotlin.system.exitProcess


class MainUI : BaseActivity() {

    val mainAdapter = MainAdapter(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        findViewById<RecyclerView>(R.id.rv_data).adapter = mainAdapter
    }

    private fun showHideMenu() {

        val names = arrayOf("重装", "新版本", "崩溃日志", "停止进程", "备份应用")

        AlertDialog.Builder(this).setTitle(
            getString(R.string.main_title_cur_version) + "_${packageManager.getPackageInfo(packageName, 0).versionName}"
        ).setSingleChoiceItems(names, -1) { d, w ->
            d.dismiss()
            when (w) {
                0 -> updateSelf()
                1 -> UiUtils.downloadAndInstallAPK(this, Const.URL_DOWNLOAD)
                2 -> showCrashLog()
                3 -> exitProcess(0)
                4 -> backupThird()
            }
        }.setOnDismissListener {
            mainAdapter.setDiffData(SettingManager.updateSettings())
        }.show()
    }

    private fun backupThird() {
        App.uiScope.launch {
            val client = AdbManager.getClient()
            val apks = UiManager.getAppInfo().filter { !it.system }
            "开始备份${apks.size}个应用".toast()
            client.runSync("mkdir /sdcard/thirdApks/")
            apks.forEach {
                client.runSync("cp ${it.sourceDir} /sdcard/thirdApks/${it.name}_${it.pkg}.apk")
            }
            client.runSync("cp /system/framework/framework.jar /sdcard/thirdApks/framework.jar")
            "备份应用完成".toast()
        }

    }

    private fun showCrashLog() {
        val logFile = File(cacheDir, "crash.log")
        if (!logFile.exists()) return App.toast("暂无崩溃日志")
        AlertDialog.Builder(this).setMessage(logFile.readText()).setNegativeButton("取消") { d, _ ->
            d.dismiss()
        }.setPositiveButton("清除") { d, w ->
            d.dismiss()
            logFile.delete()
        }.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        UiUtils.enableAccessibility(this, false)
    }

    private fun updateSelf() = App.uiScope.launch(Dispatchers.IO) {

        val dataDir = File(packageResourcePath)
        val downloadApk = File(App.get().getExternalFilesDir(null), "temp.apk")
        downloadApk.writeBytes(dataDir.readBytes())

        UiUtils.installApk(this@MainUI, downloadApk)
    }

    private fun showHideSetting() {
//        val hides = SettingManager.getHides()
//        val names = Array<CharSequence>(hides.size) { getString(hides[it].first.getNameId()) }
//        val checks = BooleanArray(hides.size) { !hides[it].second }

//        AlertDialog.Builder(this).setTitle(getString(R.string.main_title_add_setting))
//            .setMultiChoiceItems(names, checks) { d, w, c ->
//                SettingManager.changeSetting(this, hides[w].first, !c)
//            }.setOnDismissListener {
//                mainAdapter.setDiffData(SettingManager.updateSettings())
//            }.show()

//        val niftySlider2: NiftySlider
//        niftySlider2.apply {
//            effect = ITEffect(this).apply {
//                setStartIcon(R.drawable.icon_font)
//                setEndIcon(R.drawable.icon_font)
//                startIconSize = 10.dp
//                endIconSize = 14.dp
//                startTintList = ColorStateList.valueOf(iconTintColor)
//                endTintList = ColorStateList.valueOf(iconTintColor)
//                startPadding = 12.dp
//                endPadding = 12.dp
//            }
//            setTrackTintList(ColorStateList.valueOf(activeTrackColor))
//            setTrackInactiveTintList(ColorStateList.valueOf(inactiveTrackColor))
//            addOnIntValueChangeListener { slider, value, fromUser ->
//                setThumbText(Data.weReadFontSizeMap[value].toString())
//            }
//        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        mainAdapter.notifyDiff()
        if (SettingManager.prepare) {
            startService(Intent(this, MainService::class.java))
        }
    }


}


