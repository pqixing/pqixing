package com.pqixing.bydauto.music

import android.content.Intent
import android.content.pm.PackageManager
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.pqixing.bydauto.Const
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import kotlinx.coroutines.Dispatchers

class MusicSetting : SettingImpl(R.layout.setting_music) {
    override fun getLayoutId(): Int = R.layout.setting_music

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val radio: RadioGroup = viewHolder.findViewById(R.id.group)
        val childs = with(Dispatchers.IO) {
            val pm = viewHolder.context.packageManager
            pm.queryBroadcastReceivers(
                Intent(Const.ACTION_AUTOVOICE_SEARCH_PLUS),
                PackageManager.GET_META_DATA
            ).map { it.activityInfo.packageName }.minus(viewHolder.context.packageName).map {
                it to pm.getApplicationLabel(pm.getApplicationInfo(it, PackageManager.GET_META_DATA)).toString()
            }.mapIndexed { index, item ->
                val auto = RadioButton(viewHolder.context)
                auto.id = index
                auto.text = item.second
                auto.isChecked = item.first == "lastPkg"
                auto.setOnLongClickListener {
                    Toast.makeText(it.context, item.first, Toast.LENGTH_SHORT).show()
                    true
                }
                auto
            }
        }
        childs.forEach { child -> radio.addView(child) }

        radio.setOnCheckedChangeListener { _, id ->
//            val item = items[id]
//            App.sp.edit().putString(MUSIC_PKG, item.first).apply()
//            App.toast("${item.second} : ${item.first}")
        }

    }


}