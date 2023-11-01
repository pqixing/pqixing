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
import android.hardware.bydauto.charging.AbsBYDAutoChargingListener
import android.hardware.bydauto.charging.BYDAutoChargingDevice
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

class SetListener(val info: AutoInfo) : AbsBYDAutoSettingListener() {
    override fun onSeatVentilatingStateChanged(i: Int, i2: Int) {
        super.onSeatVentilatingStateChanged(i, i2)
        info.exeLoad { it.ac_vent_main;it.ac_vent_deputy }
    }

    override fun onSeatHeatingStateChanged(i: Int, i2: Int) {
        super.onSeatHeatingStateChanged(i, i2)
        info.exeLoad { it.ac_heat_main;it.ac_heat_deputy }
    }

    override fun onSOCTargetRangeChanged(i: Int) {
        super.onSOCTargetRangeChanged(i)
        info.exeLoad { it.soc_target;it.soc_mode }
    }
}

class ChargeListener(val info: AutoInfo) : AbsBYDAutoChargingListener() {
    override fun onSocSaveSwitchChanged(i: Int) {
        super.onSocSaveSwitchChanged(i)
        info.exeLoad { it.soc_target;it.soc_mode }
    }
}

class AutoInfo(val host: MenuFloatView) {
    private var load = false
    private var acListener: Any? = null
    private var setListener: Any? = null
    private var chargeListener: Any? = null

    fun onAttach() {
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
            if (chargeListener == null) {
                val l = ChargeListener(this)
                charge.registerListener(l)
                chargeListener = l
            }
        }
    }

    fun onDetach() {
        kotlin.runCatching {
            if (acListener != null) {
                ac.unregisterListener(acListener as AcListener)
                acListener = null
            }
            if (setListener != null) {
                set.unregisterListener(setListener as SetListener)
                setListener = null
            }
            if (chargeListener != null) {
                charge.unregisterListener(chargeListener as SetListener)
                chargeListener = null
            }
        }
    }

    private val notify = mutableSetOf<String>()

    var ac_open: Boolean = false
        get() {
            if (load) {
                field = ac.acStartState == AC_POWER_ON
                notify += "ac_open"
            }
            return field
        }
        set(value) {
            field = value
            if (value) ac.start(AC_CTRL_SOURCE_UI_KEY) else ac.stop(AC_CTRL_SOURCE_UI_KEY)
        }
    var ac_loop: Boolean = false
        get() {
            if (load) {
                notify += "ac_loop"
                field = ac.acCycleMode == AC_CYCLEMODE_INLOOP
            }
            return field
        }
        set(value) {
            field = value
            ac.setAcCycleMode(AC_CTRL_SOURCE_UI_KEY, if (value) AC_CYCLEMODE_OUTLOOP else AC_CYCLEMODE_INLOOP)
        }
    var ac_control_model: Boolean = false
        get() {
            if (load) {
                notify += "ac_control_model"
                field = ac.acControlMode == AC_CTRLMODE_AUTO
            }
            return field
        }
        set(value) {
            field = value
            ac.setAcControlMode(AC_CTRL_SOURCE_UI_KEY, if (value) AC_CTRLMODE_AUTO else AC_CTRLMODE_MANUAL)
        }

    var ac_separate: Boolean = false
        get() {
            if (load) {
                notify += "ac_separate"
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
    var ac_wind: Int = 0
        get() {
            if (load) {
                notify += "ac_wind"
                field = ac.acWindLevel ?: 0
            }
            return field
        }
        set(value) {
            field = value
            ac.setAcWindLevel(AC_CTRL_SOURCE_UI_KEY, value)
        }
    var ac_temp: Int = 0
        get() {
            if (load) {
                notify += "ac_temp"
                field = ac.getTemprature(if (host.reverse()) AC_TEMPERATURE_DEPUTY else AC_TEMPERATURE_MAIN)
            }
            return field
        }
        set(value) {
            field = value
            val type = when {
                !ac_separate -> BYDAutoAcDevice.AC_TEMPERATURE_MAIN_DEPUTY
                else -> if (host.reverse()) AC_TEMPERATURE_DEPUTY else AC_TEMPERATURE_MAIN
            }
            ac.setAcTemperature(type, value, AC_CTRL_SOURCE_UI_KEY, AC_TEMPERATURE_UNIT_OC)
        }
    var soc_target: Int = 60
        get() {
            if (load) {
                notify += "soc_target"
                field = set.socTarget
            }
            return field
        }
        private set
    var soc_mode: Boolean = false
        get() {
            if (load) {
                notify += "soc_mode"
                field = charge.socSaveSwitch == 2
            }
            return field
        }
        set(value) {
            field = value
            charge.setSocSaveSwitch(if (value) 2 else 1)
        }


    var ac_vent: Boolean = false
        get() {
            if (load) {
                notify += "ac_vent"
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

    var ac_vent_main: Boolean = false
        get() {
            if (load) {
                notify += "ac_vent_main"
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

    var ac_vent_deputy: Boolean = false
        get() {
            if (load) {
                notify += "ac_vent_deputy"
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
    var ac_heat_main: Boolean = false
        get() {
            if (load) {
                notify += "ac_heat_main"
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
    var ac_heat_deputy: Boolean = false
        get() {
            if (load) {
                notify += "ac_heat_deputy"
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
    private val charge: BYDAutoChargingDevice
        get() = BYDAutoUtils.getAutoCharging()

    fun exeLoad(block: (info: AutoInfo) -> Unit) {
        load = true
        kotlin.runCatching {
            block(this)
        }.onFailure { it.message?.toast() }
        load = false
        host.notifyAcControl(notify.toSet())
        notify.clear()
    }

    override fun toString(): String {
        return "AutoInfo(open=$ac_open, inLoop=$ac_loop, auto=$ac_control_model, separate=$ac_separate, wind=$ac_wind, temp=$ac_temp, soc=$soc_target, socSave=$soc_mode, ventilation=$ac_vent, mainVent=$ac_vent_main, deputyVent=$ac_vent_deputy, mainHeat=$ac_heat_main, deputyHeat=$ac_heat_deputy)"
    }


}
