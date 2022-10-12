package com.pqixing.android.setting

import com.pqixing.android.boot.BootSetting
import com.pqixing.android.charger.ChargeSetting
import com.pqixing.android.music.MusicSetting
import com.pqixing.android.rotate.RotateSetting

object SettingManager {
    val settings = listOf<ISetting>(BootSetting(), ChargeSetting(), RotateSetting(), MusicSetting())
}