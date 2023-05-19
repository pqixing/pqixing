package com.pqixing.bydauto.music

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.DSetting

class MusicSetting : DSetting("音乐助手") {
    companion object {
        const val MUSIC_PKG = "MUSIC_PKG"
        const val DEFAULT_PKG = "com.music.auto_select"
    }

    override fun onUiCreate(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.setting_music, container, false)
        val radio = view.findViewById<RadioGroup>(R.id.group)
        val pm = activity.packageManager

        App.mThread.post { addChilds(pm, activity, radio) }
        return view
    }

    private fun addChilds(pm: PackageManager, activity: Activity, radio: RadioGroup) {
        val items = mutableListOf(DEFAULT_PKG to "自动")
        items += pm.queryBroadcastReceivers(
            Intent("com.byd.action.AUTOVOICE_SEARCH_PLUS"),
            PackageManager.GET_META_DATA
        ).map { it.activityInfo.packageName }.minus(activity.packageName).map {
            it to pm.getApplicationLabel(pm.getApplicationInfo(it, PackageManager.GET_META_DATA)).toString()
        }
        val lastPkg = App.sp.getString(MUSIC_PKG, DEFAULT_PKG)


        val childs = items.mapIndexed { index, item ->
            val auto = RadioButton(activity)
            auto.id = index
            auto.text = item.second
            auto.isChecked = item.first == lastPkg
            auto.setOnLongClickListener {
                Toast.makeText(it.context, item.first, Toast.LENGTH_SHORT).show()
                true
            }
            auto
        }

        App.mHandle.post {
            childs.forEach { child -> radio.addView(child) }

            radio.setOnCheckedChangeListener { _, id ->
                val item = items[id]
                App.sp.edit().putString(MUSIC_PKG, item.first).apply()
                App.toast("${item.second} : ${item.first}")
            }
        }
    }


}