package com.pqixing.bydauto.widget

import android.hardware.bydauto.ac.BYDAutoAcDevice
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_CTRLMODE_AUTO
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_CTRLMODE_MANUAL
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_CTRL_SOURCE_UI_KEY
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_CYCLEMODE_INLOOP
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_CYCLEMODE_OUTLOOP
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_POWER_ON
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_TEMPCTRL_SEPARATE_OFF
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_TEMPCTRL_SEPARATE_ON
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_TEMPERATURE_DEPUTY
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_TEMPERATURE_MAIN
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_TEMPERATURE_UNIT_OC
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_VENTILATION_STATE_OFF
import android.hardware.bydauto.ac.BYDAutoAcDevice.AC_VENTILATION_STATE_ON
import android.hardware.bydauto.setting.AbsBYDAutoSettingListener
import android.hardware.bydauto.setting.BYDAutoSettingDevice
import android.hardware.bydauto.setting.BYDAutoSettingDevice.DRIVER_SEAT
import android.hardware.bydauto.setting.BYDAutoSettingDevice.PASSENGER_SEAT
import android.hardware.bydauto.setting.BYDAutoSettingDevice.SEAT_HEATING_LOW
import android.hardware.bydauto.setting.BYDAutoSettingDevice.SEAT_HEATING_OFF
import android.hardware.bydauto.setting.BYDAutoSettingDevice.SEAT_VENTILATING_LOW
import android.hardware.bydauto.setting.BYDAutoSettingDevice.SEAT_VENTILATING_OFF
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.toast

class SetListener(val info: AcControlInfo) : AbsBYDAutoSettingListener() {
    override fun onSeatVentilatingStateChanged(i: Int, i2: Int) {
        super.onSeatVentilatingStateChanged(i, i2)
        info.exeLoad { it.mainVent;it.deputyVent }
    }

    override fun onSeatHeatingStateChanged(i: Int, i2: Int) {
        super.onSeatHeatingStateChanged(i, i2)
        info.exeLoad { it.mainHeat;it.deputyHeat }
    }
}

class AcControlInfo(val host: MenuFloatView) {
    private var load = false
    private var acListener: Any? = null
    private var setListener: Any? = null

    fun onVisible() {
        kotlin.runCatching {
            if (acListener == null) {
                val l = AcListener(this)
                ac.registerListener(l)
                acListener = l
            }
            if (setListener == null) {
                val l = SetListener(this)
                set.registerListener(l)
                acListener = l
            }
        }
    }

    fun onHide() {
        kotlin.runCatching {
            if (acListener != null) {
                ac.unregisterListener(acListener as AcListener)
                acListener = null
            }
            if (setListener != null) {
                set.unregisterListener(setListener as SetListener)
                setListener = null
            }
        }
    }

    var open: Boolean = false
        get() {
            if (load) field = ac.acStartState == AC_POWER_ON
            return field
        }
        set(value) {
            field = value
            if (value) ac.start(AC_CTRL_SOURCE_UI_KEY) else ac.stop(AC_CTRL_SOURCE_UI_KEY)
        }
    var inLoop: Boolean = false
        get() {
            if (load) {
                field = ac.acCycleMode == AC_CYCLEMODE_INLOOP
            }
            return field
        }
        set(value) {
            field = value
            ac.setAcCycleMode(AC_CTRL_SOURCE_UI_KEY, if (value) AC_CYCLEMODE_OUTLOOP else AC_CYCLEMODE_INLOOP)
        }
    var auto: Boolean = false
        get() {
            if (load) {
                field = ac.acControlMode == AC_CTRLMODE_AUTO
            }
            return field
        }
        set(value) {
            field = value
            ac.setAcControlMode(AC_CTRL_SOURCE_UI_KEY, if (value) AC_CTRLMODE_AUTO else AC_CTRLMODE_MANUAL)
        }

    var separate: Boolean = false
        get() {
            if (load) {
                field = ac.acTemperatureControlMode == AC_TEMPCTRL_SEPARATE_ON
            }
            return field
        }
        set(value) {
            field = value
            ac.setAcTemperatureControlMode(
                AC_CTRL_SOURCE_UI_KEY, if (value) AC_TEMPCTRL_SEPARATE_ON else AC_TEMPCTRL_SEPARATE_OFF
            )
        }
    var wind: Int = 0
        get() {
            if (load) {
                field = ac.acWindLevel ?: 0
            }
            return field
        }
        set(value) {
            field = value
            ac.setAcWindLevel(AC_CTRL_SOURCE_UI_KEY, value)
        }
    var temp: Int = 0
        get() {
            if (load) {
                field = ac.getTemprature(if (host.reverse()) AC_TEMPERATURE_DEPUTY else AC_TEMPERATURE_MAIN)
            }
            return field
        }
        set(value) {
            field = value
            val type = when {
                !separate -> BYDAutoAcDevice.AC_TEMPERATURE_MAIN_DEPUTY
                else -> if (host.reverse()) AC_TEMPERATURE_DEPUTY else AC_TEMPERATURE_MAIN
            }
            ac.setAcTemperature(type, value, AC_CTRL_SOURCE_UI_KEY, AC_TEMPERATURE_UNIT_OC)
        }

    var ventilation: Boolean = false
        get() {
            if (load) {
                field = ac.acVentilationState == AC_VENTILATION_STATE_ON
            }
            return field
        }
        set(value) {
            field = value
            ac.setAcVentilationState(
                AC_CTRL_SOURCE_UI_KEY, if (value) AC_VENTILATION_STATE_ON else AC_VENTILATION_STATE_OFF
            )
        }

    var mainVent: Boolean = false
        get() {
            if (load) {
                field = set.getSeatVentilatingState(DRIVER_SEAT) != SEAT_VENTILATING_OFF
            }
            return field
        }
        set(value) {
            field = value
            set.setSeatVentilatingState(
                DRIVER_SEAT, if (value) SEAT_VENTILATING_LOW else SEAT_VENTILATING_OFF
            )
        }

    var deputyVent: Boolean = false
        get() {
            if (load) {
                field = set.getSeatVentilatingState(PASSENGER_SEAT) != SEAT_VENTILATING_OFF
            }
            return field
        }
        set(value) {
            field = value
            set.setSeatVentilatingState(
                PASSENGER_SEAT, if (value) SEAT_VENTILATING_LOW else SEAT_VENTILATING_OFF
            )
        }
    var mainHeat: Boolean = false
        get() {
            if (load) {
                field = set.getSeatHeatingState(DRIVER_SEAT) != SEAT_HEATING_OFF
            }
            return field
        }
        set(value) {
            field = value
            set.setSeatHeatingState(
                DRIVER_SEAT, if (value) SEAT_HEATING_LOW else SEAT_HEATING_OFF
            )
        }
    var deputyHeat: Boolean = false
        get() {
            if (load) {
                field = set.getSeatHeatingState(PASSENGER_SEAT) != SEAT_HEATING_OFF
            }
            return field
        }
        set(value) {
            field = value
            set.setSeatHeatingState(
                PASSENGER_SEAT, if (value) SEAT_HEATING_LOW else SEAT_HEATING_OFF
            )
        }


    private val ac: BYDAutoAcDevice
        get() = BYDAutoUtils.getAcControl()

    private val set: BYDAutoSettingDevice
        get() = BYDAutoUtils.getSetting()

    fun exeLoad(block: (info: AcControlInfo) -> Unit) {
        kotlin.runCatching {
            load = true
            block(this)
            load = false
            host.notifyAcControl()
        }.onFailure { it.message?.toast() }
    }

    override fun toString(): String {
        return "AcControlInfo(load=$load, open=$open, separate=$separate, inLoop=$inLoop, auto=$auto, wind=$wind, temp=$temp, ventilation=$ventilation, mainVent=$mainVent, deputyVent=$deputyVent, mainHeat=$mainHeat, deputyHeat=$deputyHeat)"
    }
}
