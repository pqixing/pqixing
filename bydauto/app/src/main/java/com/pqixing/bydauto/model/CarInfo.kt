package com.pqixing.bydauto.model

import android.content.Context
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
import android.hardware.bydauto.charging.BYDAutoChargingDevice
import android.hardware.bydauto.charging.BYDAutoChargingDevice.CHARGE_WIRELESS_CHARGING_OFF
import android.hardware.bydauto.charging.BYDAutoChargingDevice.CHARGE_WIRELESS_CHARGING_ON
import android.hardware.bydauto.setting.BYDAutoSettingDevice
import android.hardware.bydauto.setting.BYDAutoSettingDevice.DRIVER_SEAT
import android.hardware.bydauto.setting.BYDAutoSettingDevice.PASSENGER_SEAT
import android.hardware.bydauto.setting.BYDAutoSettingDevice.SEAT_HEATING_LOW
import android.hardware.bydauto.setting.BYDAutoSettingDevice.SEAT_HEATING_OFF
import android.hardware.bydauto.setting.BYDAutoSettingDevice.SEAT_VENTILATING_LOW
import android.hardware.bydauto.setting.BYDAutoSettingDevice.SEAT_VENTILATING_OFF
import com.pqixing.bydauto.App
import com.pqixing.bydauto.service.MainService
import com.pqixing.bydauto.utils.BYDAutoUtils

class CarInfo() {
    private var acListener: Any? = null
    private var setListener: Any? = null
    private var chargeListener: Any? = null

    fun onCreate(context: Context) {
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
        App.mThread.post { update() }
    }

    fun update() = kotlin.runCatching {
        this.javaClass.declaredFields
            .filter { it.type == Properties::class.java }
            .mapNotNull {
                it.isAccessible = true
                it.get(this) as? Properties<*>
            }.forEach { it.update() }
    }

    fun onDestroy(context: Context) {
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

    var ac_open = Properties { ac.acStartState == AC_POWER_ON }
        .onSet { if (it) ac.start(AC_CTRL_SOURCE_UI_KEY) else ac.stop(AC_CTRL_SOURCE_UI_KEY) }

    var ac_loop = Properties { ac.acCycleMode == AC_CYCLEMODE_INLOOP }
        .onSet { ac.setAcCycleMode(AC_CTRL_SOURCE_UI_KEY, if (it) AC_CYCLEMODE_OUTLOOP else AC_CYCLEMODE_INLOOP) }

    var ac_control_model = Properties { ac.acControlMode == AC_CTRLMODE_AUTO }
        .onSet { ac.setAcControlMode(AC_CTRL_SOURCE_UI_KEY, if (it) AC_CTRLMODE_AUTO else AC_CTRLMODE_MANUAL) }


    var ac_separate = Properties { ac.acTemperatureControlMode == AC_TEMPCTRL_SEPARATE_ON }
        .onSet {
            ac.setAcTemperatureControlMode(
                AC_CTRL_SOURCE_UI_KEY, if (it) AC_TEMPCTRL_SEPARATE_ON else AC_TEMPCTRL_SEPARATE_OFF
            )
        }

    var ac_wind = Properties { ac.acWindLevel }.onSet { ac.setAcWindLevel(AC_CTRL_SOURCE_UI_KEY, it) }

    var ac_temp_main = Properties { ac.getTemprature(AC_TEMPERATURE_MAIN) }.onSet {
        val type = if (ac_separate.getValue()) AC_TEMPERATURE_MAIN else BYDAutoAcDevice.AC_TEMPERATURE_MAIN_DEPUTY
        ac.setAcTemperature(type, it, AC_CTRL_SOURCE_UI_KEY, AC_TEMPERATURE_UNIT_OC)
    }
    var ac_temp_deputy = Properties { ac.getTemprature(AC_TEMPERATURE_DEPUTY) }.onSet {
        val type = if (ac_separate.getValue()) AC_TEMPERATURE_DEPUTY else BYDAutoAcDevice.AC_TEMPERATURE_MAIN_DEPUTY
        ac.setAcTemperature(type, it, AC_CTRL_SOURCE_UI_KEY, AC_TEMPERATURE_UNIT_OC)
    }

    var soc_target = Properties { set.socTarget }.onSet { set.socTarget = it }

    var soc_mode = Properties { charge.socSaveSwitch == 2 }.onSet { charge.socSaveSwitch = if (it) 2 else 1 }

    var ac_vent = Properties { ac.acVentilationState == AC_VENTILATION_STATE_ON }.onSet {
        ac.setAcVentilationState(
            AC_CTRL_SOURCE_UI_KEY, if (it) AC_VENTILATION_STATE_ON else AC_VENTILATION_STATE_OFF
        )
    }


    var ac_vent_main = Properties { set.getSeatVentilatingState(DRIVER_SEAT) != SEAT_VENTILATING_OFF }.onSet {
        set.setSeatVentilatingState(
            DRIVER_SEAT, if (it) SEAT_VENTILATING_LOW else SEAT_VENTILATING_OFF
        )
    }


    var ac_vent_deputy = Properties { set.getSeatVentilatingState(PASSENGER_SEAT) != SEAT_VENTILATING_OFF }.onSet {
        set.setSeatVentilatingState(
            PASSENGER_SEAT, if (it) SEAT_VENTILATING_LOW else SEAT_VENTILATING_OFF
        )
    }

    var ac_heat_main = Properties { set.getSeatHeatingState(DRIVER_SEAT) != SEAT_HEATING_OFF }.onSet {
        set.setSeatHeatingState(
            DRIVER_SEAT, if (it) SEAT_HEATING_LOW else SEAT_HEATING_OFF
        )
    }

    var ac_heat_deputy = Properties { set.getSeatHeatingState(PASSENGER_SEAT) != SEAT_HEATING_OFF }.onSet {
        set.setSeatHeatingState(
            PASSENGER_SEAT, if (it) SEAT_HEATING_LOW else SEAT_HEATING_OFF
        )
    }

    var wcharge = Properties { charge.wirelessChargingSwitchState == CHARGE_WIRELESS_CHARGING_ON }
        .onSet {
            charge.wirelessChargingSwitchState = if (it) CHARGE_WIRELESS_CHARGING_ON else CHARGE_WIRELESS_CHARGING_OFF
        }


    private val ac: BYDAutoAcDevice
        get() = BYDAutoUtils.getAcControl()

    private val set: BYDAutoSettingDevice
        get() = BYDAutoUtils.getSetting()
    private val charge: BYDAutoChargingDevice
        get() = BYDAutoUtils.getAutoCharging()


}
