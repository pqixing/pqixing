package com.pqixing.android.setting

import com.pqixing.android.debug.DebugSetting
import com.pqixing.android.boot.BootSetting
import com.pqixing.android.byd.ChargeSetting
import com.pqixing.android.music.MusicSetting
import com.pqixing.android.radar.RadarSetting
import com.pqixing.android.rotate.RotateSetting

object SettingManager {
    val settings = listOf<ISetting>(
        DebugSetting(), BootSetting(), ChargeSetting(), RotateSetting(), MusicSetting(), RadarSetting()
    )
}