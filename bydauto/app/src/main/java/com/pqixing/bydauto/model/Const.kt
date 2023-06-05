package com.pqixing.bydauto.model

import com.pqixing.bydauto.App
import com.pqixing.bydauto.setting.ISetting
import com.pqixing.bydauto.setting.item.*

object Const {

    val settings = arrayOf<ISetting>(WirelessCharge(), ForceRotation(), RadarDistance(), MusicForward(), DebugSetting(), AdbSetting())

    var lastMediaReceiver: Long = -1L


    var SP_OPEN_RADAR: Boolean
        get() = App.sp.getBoolean("SP_OPEN_RADAR", false)
        set(value) = App.sp.edit().putBoolean("SP_OPEN_RADAR", value).apply()

    var SP_CHARGE_TYPE: String
        get() = App.sp.getString("SP_CHARGE_TYPE", "")!!
        set(value) = App.sp.edit().putString("SP_CHARGE_TYPE", value).apply()
    var SP_MUSIC_PKG: String
        get() = App.sp.getString("SP_MUSIC_PKG", "")!!
        set(value) = App.sp.edit().putString("SP_MUSIC_PKG", value).apply()
    var SP_MUSIC_SWITCH: Boolean
        get() = App.sp.getBoolean("SP_MUSIC_SWITCH", true)
        set(value) = App.sp.edit().putBoolean("SP_MUSIC_SWITCH", value).apply()
    var SP_SWITCH_BACKGROUND: Boolean
        get() = App.sp.getBoolean("SP_SWITCH_BACKGROUND", true)
        set(value) = App.sp.edit().putBoolean("SP_SWITCH_BACKGROUND", value).apply()
    var SP_MUSIC_BACKGROUND: Boolean
        get() = App.sp.getBoolean("SP_MUSIC_BACKGROUND", true)
        set(value) = App.sp.edit().putBoolean("SP_MUSIC_BACKGROUND", value).apply()
    var SP_ORIENTATION: Int
        get() = App.sp.getInt("SP_ORIENTATION", -1)
        set(value) = App.sp.edit().putInt("SP_ORIENTATION", value).apply()


    const val ACTION_AUTOVOICE_SEARCH_PLUS = "com.byd.action.AUTOVOICE_SEARCH_PLUS"
    const val MEDIA_HOST = "host.intent.action.MEDIA"
    const val MEDIA_TRANSFORM = "transform.intent.action.MEDIA"


}