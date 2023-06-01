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
    var enterDelay: Boolean
        get() = App.sp.getBoolean("delay_enter", false)
        set(value) = App.sp.edit().putBoolean("delay_enter", value).apply()

}