package com.pqixing.bydauto.widget

import android.hardware.bydauto.ac.AbsBYDAutoAcListener
import android.hardware.bydauto.ac.BYDAutoAcDevice
import android.hardware.bydauto.setting.BYDAutoSettingDevice
import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.BYDAutoUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AcInfo(val floatView: MenuFloatView) : AbsBYDAutoAcListener() {
    var open: Boolean = false
    var inLoop: Boolean = false
    var auto: Boolean = false
    var wind: Int = 0
    var temp: Int = 0
    var separate: Boolean = false
    var ventilation: Boolean = false
    var seatVent: Int = 1
    var seatHeat: Int = 1

    init {
        BYDAutoUtils.getAcControl().registerListener(this)
    }

    fun loadData(delayTs: Long = 500) = App.get().uiScope.launch {
        delay(delayTs)
        withContext(Dispatchers.IO) {
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
        }
        floatView.notifyAcControl()
    }
}