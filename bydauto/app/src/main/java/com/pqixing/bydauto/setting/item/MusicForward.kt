package com.pqixing.bydauto.setting.item

import android.content.Intent
import android.content.pm.PackageManager
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.Dispatchers

class MusicForward : SettingImpl(R.layout.setting_music) {
    override fun getNameId(): Int = R.string.setting_name_music

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val radio: RadioGroup = viewHolder.findViewById(R.id.group)
        val lastPkg = Const.SP_MUSIC_PKG
        val appInfos = with(Dispatchers.IO) {
            val pm = viewHolder.context.packageManager
            UiUtils.loadAppInfos(viewHolder.context, pm.queryBroadcastReceivers(
                Intent(Const.ACTION_AUTOVOICE_SEARCH_PLUS),
                PackageManager.GET_META_DATA
            ).map { it.activityInfo.packageName })
        }
        appInfos.forEachIndexed { index, appInfo ->
            val auto = RadioButton(viewHolder.context)
            auto.id = index
            auto.text = appInfo.name
            auto.isChecked = appInfo.pkg == lastPkg
            radio.addView(auto)
        }
        radio.setOnCheckedChangeListener { _, id ->
            val item = appInfos[id]
            Const.SP_MUSIC_PKG = item.pkg
            App.toast("${item.name} : ${item.pkg}")
        }

        val musicBackGround = viewHolder.findViewById<CheckBox>(R.id.cb_music_background)
        musicBackGround.isChecked = Const.SP_MUSIC_BACKGROUND
        musicBackGround.setOnCheckedChangeListener { _, isChecked -> Const.SP_MUSIC_BACKGROUND = isChecked }

        val autoSwitch = viewHolder.findViewById<CheckBox>(R.id.cb_auto_switch)
        autoSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Const.SP_MUSIC_PKG = ""
                radio.isEnabled = false
            } else {
                radio.isEnabled = true
                Const.SP_MUSIC_PKG = appInfos.getOrNull(radio.checkedRadioButtonId)?.pkg ?: ""
            }
        }
        autoSwitch.isChecked = lastPkg.isEmpty()
    }
}