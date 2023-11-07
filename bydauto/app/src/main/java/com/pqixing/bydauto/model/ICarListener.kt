package com.pqixing.bydauto.model

import android.hardware.bydauto.ac.AbsBYDAutoAcListener
import android.hardware.bydauto.charging.AbsBYDAutoChargingListener
import android.hardware.bydauto.setting.AbsBYDAutoSettingListener


class SetListener(val info: CarInfo) : AbsBYDAutoSettingListener() {
    override fun onSeatVentilatingStateChanged(i: Int, i2: Int) {
        super.onSeatVentilatingStateChanged(i, i2)
        info.ac_vent_main.update()
        info.ac_vent_deputy.update()
    }

    override fun onSeatHeatingStateChanged(i: Int, i2: Int) {
        super.onSeatHeatingStateChanged(i, i2)
        info.ac_heat_main.update()
        info.ac_heat_deputy.update()
    }

    override fun onSOCTargetRangeChanged(i: Int) {
        super.onSOCTargetRangeChanged(i)
        info.soc_target.update()
    }
}

class ChargeListener(val info: CarInfo) : AbsBYDAutoChargingListener() {
    override fun onSocSaveSwitchChanged(i: Int) {
        super.onSocSaveSwitchChanged(i)
        info.soc_mode.update()
    }

    override fun onWirelessChargingSwitchStateChanged(i: Int) {
        super.onWirelessChargingSwitchStateChanged(i)
        info.wcharge.update()
    }
}


class AcListener(val info: CarInfo) : AbsBYDAutoAcListener() {

    override fun onAcCtrlModeChanged(i: Int) {
        super.onAcCtrlModeChanged(i)
        info.ac_control_model.update()
    }


    override fun onTemperatureChanged(i: Int, i2: Int) {
        super.onTemperatureChanged(i, i2)
        info.ac_temp_deputy.update()
    }

    override fun onAcWindLevelChanged(i: Int) {
        super.onAcWindLevelChanged(i)
        info.ac_wind.update()
    }

    override fun onAcStarted() {
        super.onAcStarted()
        info.ac_open.update()
    }

    override fun onAcStoped() {
        super.onAcStoped()
        info.ac_open.update()
    }

    override fun onAcCycleModeChanged(i: Int) {
        super.onAcCycleModeChanged(i)
        info.ac_loop.update()
    }

    override fun onAcTemperatureControlModeChanged(i: Int) {
        super.onAcTemperatureControlModeChanged(i)
        info.ac_separate.update()
    }

    override fun onAcVentilationStateChanged(i: Int) {
        super.onAcVentilationStateChanged(i)
        info.ac_vent.update()
    }
}
