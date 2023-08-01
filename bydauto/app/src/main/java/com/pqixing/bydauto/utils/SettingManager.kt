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
    private var curs: List<ISetting> = emptyList()

    @Synchronized
    fun updateCurSettings(context: Context): List<ISetting> {

        val sets = Const.SP_SETTING_HIDE.split(",").toSet()
        val filter = settings.filter { !sets.contains(it.javaClass.simpleName) && it.isShow(context) }

        curs.minus(filter).forEach {
            it.onDestroy(context)
            App.log("${it.javaClass.simpleName} onDestroy")
        }
        filter.minus(curs).forEach {
            it.onCreate(context)
            App.log("${it.javaClass.simpleName} onCreate")
        }
        curs = filter
        return curs
    }

    fun getSettings(context: Context) = curs

    fun hideSetting(context: Context, setting: ISetting, hide: Boolean) {
        val key = setting.javaClass.simpleName
        Const.SP_SETTING_HIDE = Const.SP_SETTING_HIDE.split(",")
            .toSet().let { if (hide) it.plus(key) else it.minus(key) }
            .joinToString(",")
    }

    fun getHides(context: Context): List<Pair<ISetting, Boolean>> {
        val hideNames = Const.SP_SETTING_HIDE.split(",").toSet()
        return settings.filter { it.isShow(context) }.map { it to hideNames.contains(it.javaClass.simpleName) }
    }

    fun <T : ISetting> findSetting(clazz: Class<T>): T? {
        return curs.find { it.javaClass == clazz } as? T
    }

}