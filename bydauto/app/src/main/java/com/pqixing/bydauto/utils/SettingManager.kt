package com.pqixing.bydauto.utils

import android.content.Context
import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.ISetting
import com.pqixing.bydauto.setting.item.AdbItem
import com.pqixing.bydauto.setting.item.FloatBarItem
import com.pqixing.bydauto.setting.item.MusicItem
import com.pqixing.bydauto.setting.item.PermItem
import com.pqixing.bydauto.setting.item.RadarItem
import com.pqixing.bydauto.setting.item.RotationItem
import com.pqixing.bydauto.setting.item.WireChargeItem

object SettingManager {
    private val settings = arrayOf<ISetting>(
        PermItem(),
        FloatBarItem(),
        WireChargeItem(),
        RadarItem(),
        MusicItem(),
        RotationItem(),
        AdbItem(),
    )
    private var shows: List<ISetting> = emptyList()
    private var hides: List<ISetting> = emptyList()

    @Synchronized
    fun updateSettings(): List<ISetting> {

        val context = App.get()
        val lastShows = shows

        shows = settings.filter { it.isShow(context) }
        hides = settings.filter { !it.isShow(context) }

        lastShows.minus(shows.toSet()).forEach {
            it.onDestroy(context)
            App.log("${it.javaClass.simpleName} onDestroy")
        }
        shows.minus(lastShows.toSet()).forEach {
            it.onCreate(context)
            App.log("${it.javaClass.simpleName} onCreate")
        }
        return getSettings()
    }

    fun getSettings() = shows + hides

    fun changeSetting(setting: ISetting, show: Boolean) {
        return App.sp.edit().putBoolean("show_${setting.javaClass.simpleName}", show).apply()
    }

    fun getHides(context: Context): List<Pair<ISetting, Boolean>> {
        val hideNames = Const.SP_SETTING_HIDE.split(",").toSet()
        return settings.filter { it.isShow(context) }.map { it to hideNames.contains(it.javaClass.simpleName) }
    }

    fun <T : ISetting> findSetting(clazz: Class<T>): T? {
        return shows.find { it.javaClass == clazz } as? T
    }

}