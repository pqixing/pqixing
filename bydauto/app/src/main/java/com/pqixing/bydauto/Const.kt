package com.pqixing.bydauto

import com.pqixing.bydauto.boot.BootSetting
import com.pqixing.bydauto.byd.ChargeSetting
import com.pqixing.bydauto.music.MusicSetting
import com.pqixing.bydauto.radar.RadarSetting
import com.pqixing.bydauto.rotate.RotateSetting
import com.pqixing.bydauto.setting.ISetting

object Const {

    val settings = arrayOf<ISetting>(BootSetting(), ChargeSetting(), RotateSetting(), MusicSetting(), RadarSetting())

    var lastMediaReceiver: Long = -1L

    /**
     * 延迟进入页面
     */
    var SP_ENTER_DELAY: Boolean
        get() = App.sp.getBoolean("SP_ENTER_DELAY", false)
        set(value) = App.sp.edit().putBoolean("SP_ENTER_DELAY", value).apply()

    var SP_MUSIC_PKG: String
        get() = App.sp.getString("SP_MUSIC_PKG", "")!!
        set(value) = App.sp.edit().putString("SP_MUSIC_PKG", value).apply()


    val ACTION_AUTOVOICE_SEARCH_PLUS = "com.byd.action.AUTOVOICE_SEARCH_PLUS"

}