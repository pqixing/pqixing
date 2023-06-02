package com.pqixing.bydauto

import com.pqixing.bydauto.byd.ChargeSetting
import com.pqixing.bydauto.music.MusicSetting
import com.pqixing.bydauto.radar.RadarSetting
import com.pqixing.bydauto.rotate.RotateSetting
import com.pqixing.bydauto.setting.ISetting

object Const {

    val settings = arrayOf<ISetting>(ChargeSetting(), RotateSetting(), MusicSetting(), RadarSetting())

    var lastMediaReceiver: Long = -1L


    var SP_OPEN_RADAR: Boolean
        get() = App.sp.getBoolean("SP_OPEN_RADAR", true)
        set(value) = App.sp.edit().putBoolean("SP_OPEN_RADAR", value).apply()

    var SP_CHARGE_TYPE: String
        get() = App.sp.getString("SP_CHARGE_TYPE", "")!!
        set(value) = App.sp.edit().putString("SP_CHARGE_TYPE", value).apply()
    var SP_MUSIC_PKG: String
        get() = App.sp.getString("SP_MUSIC_PKG", "")!!
        set(value) = App.sp.edit().putString("SP_MUSIC_PKG", value).apply()
    var SP_MUSIC_BACKGROUND: Boolean
        get() = App.sp.getBoolean("SP_MUSIC_BACKGROUND", true)
        set(value) = App.sp.edit().putBoolean("SP_MUSIC_BACKGROUND", value).apply()
    var SP_ORIENTATION: Int
        get() = App.sp.getInt("SP_ORIENTATION", -1)
        set(value) = App.sp.edit().putInt("SP_ORIENTATION", value).apply()


    const val ACTION_AUTOVOICE_SEARCH_PLUS = "com.byd.action.AUTOVOICE_SEARCH_PLUS"


}