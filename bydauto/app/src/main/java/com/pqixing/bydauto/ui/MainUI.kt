package com.pqixing.bydauto.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.model.PermType
import com.pqixing.bydauto.service.MainService
import com.pqixing.bydauto.utils.SettingManager
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import kotlin.system.exitProcess


class MainUI : BaseActivity() {

    val mainAdapter = MainAdapter(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, MainService::class.java))
        setContentView(R.layout.activity_settings)
        findViewById<View>(R.id.tv_title).setOnClickListener { showHideMenu() }
        findViewById<View>(R.id.tv_title).setOnLongClickListener { showHideSetting();true }
        val rvData = findViewById<RecyclerView>(R.id.rv_data)
        rvData.adapter = mainAdapter
        rvData.isNestedScrollingEnabled = true
        updaLayoutManager(rvData)
    }

    private fun showHideMenu() {
        val names = arrayOf("重装", "新版本", "崩溃日志", "停止进程")

        AlertDialog.Builder(this).setTitle(
            getString(R.string.main_title_cur_version) + "_${packageManager.getPackageInfo(packageName, 0).versionName}"
        ).setSingleChoiceItems(names, -1) { d, w ->
            d.dismiss()
            when (w) {
                0 -> updateSelf()
                1 -> UiUtils.downloadAndInstallAPK(this, Const.URL_DOWNLOAD)
                2 -> showCrashLog()
                3 -> exitProcess(0)
            }
        }.setOnDismissListener {
            mainAdapter.setDiffData(SettingManager.updateCurSettings(this))
        }.show()
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
        val hides = SettingManager.getHides(this)
        val names = Array<CharSequence>(hides.size) { getString(hides[it].first.getNameId()) }
        val checks = BooleanArray(hides.size) { !hides[it].second }

        AlertDialog.Builder(this).setTitle(getString(R.string.main_title_add_setting))
            .setMultiChoiceItems(names, checks) { d, w, c ->
                SettingManager.hideSetting(this, hides[w].first, !c)
            }.setOnDismissListener {
                mainAdapter.setDiffData(SettingManager.updateCurSettings(this))
            }.show()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updaLayoutManager(findViewById(R.id.rv_data))
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onStart() {
        super.onStart()
        PermType.clearCache()
        mainAdapter.setDiffData(SettingManager.updateCurSettings(this))
    }

    private fun updaLayoutManager(rvData: RecyclerView?) {
        rvData ?: return
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE && !UiManager.inSplitMode) {
            rvData.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        } else {
            rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }
}


