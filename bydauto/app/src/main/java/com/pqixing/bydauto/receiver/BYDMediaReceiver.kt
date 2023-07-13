package com.pqixing.bydauto.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.item.MusicItem
import com.pqixing.bydauto.utils.SettingManager
import kotlinx.coroutines.launch


class BYDMediaReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        intent ?: return
        Const.lastMediaReceiver = System.currentTimeMillis()
        App.uiScope.launch {
            runCatching {
                SettingManager.findSetting(MusicItem::class.java)?.resend(context, intent)
            }
        }
    }

}