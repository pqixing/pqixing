package com.pqixing.bydauto.widget

import android.hardware.bydauto.ac.AbsBYDAutoAcListener
import android.hardware.bydauto.ac.BYDAutoAcDevice
import android.hardware.bydauto.setting.BYDAutoSettingDevice
import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AcListener(val floatView: MenuFloatView) : AbsBYDAutoAcListener() {

    override fun onTemperatureChanged(i: Int, i2: Int) {
        super.onTemperatureChanged(i, i2)
        "onTemperatureChanged $i2".toast()
    }

    override fun onAcWindLevelChanged(i: Int) {
        super.onAcWindLevelChanged(i)
        "onTemperatureChanged $i".toast()
    }
}

class AcInfo(val floatView: MenuFloatView) {
    var open: Boolean = false
    var inLoop: Boolean = false
    var auto: Boolean = false
    var wind: Int = 0
    var temp: Int = 0
    var separate: Boolean = false
    var ventilation: Boolean = false
    var seatVent: Int = 1
    var seatHeat: Int = 1

    fun loadData(delayTs: Long = 500) = App.get().uiScope.launch {
        delay(delayTs)
        withContext(Dispatchers.IO) {
            kotlin.runCatching {
                val acControl = BYDAutoUtils.getAcControl()
                open = acControl.acStartState == BYDAutoAcDevice.AC_POWER_ON
                inLoop = acControl.acCycleMode == BYDAutoAcDevice.AC_CYCLEMODE_INLOOP
                auto = acControl.acControlMode == BYDAutoAcDevice.AC_CTRLMODE_AUTO
                wind = acControl.acWindLevel
                temp =
                    acControl.getTemprature(if (floatView.reverseLayout()) BYDAutoAcDevice.AC_TEMPERATURE_DEPUTY else BYDAutoAcDevice.AC_TEMPERATURE_MAIN)
                separate = acControl.acTemperatureControlMode == BYDAutoAcDevice.AC_TEMPCTRL_SEPARATE_ON
                ventilation = acControl.acVentilationState == BYDAutoAcDevice.AC_VENTILATION_STATE_ON

                val setting = BYDAutoUtils.getSetting()
                seatVent = setting.getSeatVentilatingState(BYDAutoSettingDevice.DRIVER_SEAT_VENTILATING_STATE)
                seatHeat = setting.getSeatHeatingState(BYDAutoSettingDevice.DRIVER_SEAT_HEATING_STATE)
            }.onFailure { it.message?.toast() }
        }
        floatView.notifyAcControl()
    }
}
