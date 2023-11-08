package com.pqixing.bydauto.utils

import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.Perms
import com.pqixing.bydauto.setting.ISetting
import com.pqixing.bydauto.setting.item.AdbItem
import com.pqixing.bydauto.setting.item.FloatBarItem
import com.pqixing.bydauto.setting.item.HideItem
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
        HideItem(),
    )
    private var shows: List<ISetting> = emptyList()
    private var hides: List<ISetting> = emptyList()
    val perms = Perms()

    val prepare: Boolean
        get() = perms.all()


    @Synchronized
    fun updateSettings(): List<ISetting> {
        perms.updatePermission()
        val context = App.get()
        val lastShows = shows

        shows = if (!prepare) listOf(settings[0]) else settings.filter { it.isShow(context) }
        hides = if (!prepare) emptyList() else settings.filter { !it.isShow(context) }

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
        "SHOW_${setting.javaClass.simpleName}".spBoolean = show
    }

    fun getHides(): List<ISetting> {
        return hides
    }

    fun <T : ISetting> findSetting(clazz: Class<T>): T? {
        return shows.find { it.javaClass == clazz } as? T
    }

}