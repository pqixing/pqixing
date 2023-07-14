package com.pqixing.bydauto.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
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
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.net.URL
import kotlin.system.exitProcess


class MainUI : BaseActivity() {

    val mainAdapter = MainAdapter(emptyList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, MainService::class.java))
        setContentView(R.layout.activity_settings)
        findViewById<View>(R.id.tv_title).setOnClickListener { showHideSetting() }
        findViewById<View>(R.id.tv_title).setOnLongClickListener { showHideMenu();true }
        val rvData = findViewById<RecyclerView>(R.id.rv_data)
        rvData.adapter = mainAdapter
        rvData.isNestedScrollingEnabled = true
        updaLayoutManager(rvData)
    }

    private fun showHideMenu() {
        val names = arrayOf("更新", "关闭")

        AlertDialog.Builder(this).setTitle(getString(R.string.main_title_add_setting))
            .setSingleChoiceItems(names, -1) { d, w ->
                d.dismiss()
                when (w) {
                    0 -> updateSelf()
                    1 -> exitProcess(0)
                }
            }.setOnDismissListener {
                mainAdapter.setDiffData(SettingManager.updateCurSettings(this))
            }.show()
    }

    private fun updateSelf() = App.uiScope.launch(Dispatchers.IO) {
        val downloadApk = File(App.get().cacheDir, "temp.apk")
        downloadApk.writeBytes(URL(Const.URL_DOWNLOAD).openStream().use { it.readBytes() })

        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setDataAndType(Uri.fromFile(downloadApk), "application/vnd.android.package-archive")
        startActivity(intent)
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
        if (orientation == Configuration.ORIENTATION_LANDSCAPE && UiUtils.inSplitMode(this)) {
            rvData.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        } else {
            rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }
}


