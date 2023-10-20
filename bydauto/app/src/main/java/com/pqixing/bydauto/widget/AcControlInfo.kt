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
        info.exeLoad { it.mainVent; it.deputyVent }
        "onSeatVentilatingStateChanged".toast()
    }

    override fun onSafeWarnStateChanged(i: Int) {
        super.onSafeWarnStateChanged(i)
        "onSafeWarnStateChanged".toast()
    }

    override fun onSeatHeatingStateChanged1(i: Int, i2: Int) {
        super.onSeatHeatingStateChanged1(i, i2)
        "onSeatHeatingStateChanged1".toast()
    }

    override fun onSmartWelcomeLightStateChanged(i: Int) {
        super.onSmartWelcomeLightStateChanged(i)
        "onSmartWelcomeLightStateChanged".toast()
    }

    override fun onStartKeyStateChanged(i: Int) {
        super.onStartKeyStateChanged(i)
        "onStartKeyStateChanged".toast()
    }

    override fun onStartOrPowerIndSwitchChanged(i: Int) {
        super.onStartOrPowerIndSwitchChanged(i)
        "onStartOrPowerIndSwitchChanged".toast()
    }

    override fun onSteerAssisModeChanged(i: Int) {
        super.onSteerAssisModeChanged(i)
        "onSteerAssisModeChanged".toast()
    }

    override fun onSteerAssistPermissionChanged(i: Int) {
        super.onSteerAssistPermissionChanged(i)
        "onSteerAssistPermissionChanged".toast()
    }

    override fun onSteerBackChanged(i: Int) {
        super.onSteerBackChanged(i)
        "onSteerBackChanged".toast()
    }

    override fun onSteerPositionAutoReturnSwitchChanged(i: Int) {
        super.onSteerPositionAutoReturnSwitchChanged(i)
        "onSteerPositionAutoReturnSwitchChanged".toast()
    }

    override fun onSteeringWheelHeatingStateChanged(i: Int) {
        super.onSteeringWheelHeatingStateChanged(i)
        "onSteeringWheelHeatingStateChanged".toast()
    }

    override fun onStopRemoteCtrlDriveIndChanged(i: Int) {
        super.onStopRemoteCtrlDriveIndChanged(i)
        "onStopRemoteCtrlDriveIndChanged".toast()
    }

    override fun onUnlockDownwindowChanged(i: Int) {
        super.onUnlockDownwindowChanged(i)
        "onUnlockDownwindowChanged".toast()
    }

    override fun onWindscreenWiperOverhaulStateChanged(i: Int, i2: Int) {
        super.onWindscreenWiperOverhaulStateChanged(i, i2)
        "onWindscreenWiperOverhaulStateChanged".toast()
    }

    override fun onSeatHeatingStateChanged(i: Int, i2: Int) {
        super.onSeatHeatingStateChanged(i, i2)
        info.exeLoad { it.mainHeat; it.deputyHeat }
        "onSeatHeatingStateChanged".toast()
    }

    override fun onACAutoAirModeChanged(i: Int) {
        super.onACAutoAirModeChanged(i)
        "onACAutoAirModeChanged".toast()
    }

    override fun onACAutoWindLevelChanged(i: Int) {
        super.onACAutoWindLevelChanged(i)
        "onACAutoWindLevelChanged".toast()
    }

    override fun onACBTWindSwitchChanged(i: Int) {
        super.onACBTWindSwitchChanged(i)
        "onACBTWindSwitchChanged".toast()
    }

    override fun onACPauseCycleSwitchChanged(i: Int) {
        super.onACPauseCycleSwitchChanged(i)
        "onACPauseCycleSwitchChanged".toast()
    }

    override fun onACTunnelCycleSwitchChanged(i: Int) {
        super.onACTunnelCycleSwitchChanged(i)
        "onACTunnelCycleSwitchChanged".toast()
    }

    override fun onAirLightPanelStateChanged(i: Int) {
        super.onAirLightPanelStateChanged(i)
        "onAirLightPanelStateChanged".toast()
    }

    override fun onAirLightTextNumberChanged(i: Int) {
        super.onAirLightTextNumberChanged(i)
        "onAirLightTextNumberChanged".toast()
    }

    override fun onAirLightTextStateChanged(i: Int) {
        super.onAirLightTextStateChanged(i)
        "onAirLightTextStateChanged".toast()
    }

    override fun onAutoExternalRearMirrorFoldChanged(i: Int) {
        super.onAutoExternalRearMirrorFoldChanged(i)
        "onAutoExternalRearMirrorFoldChanged".toast()
    }

    override fun onAutoExternalRearMirrorFollowUpSwitchChanged(i: Int) {
        super.onAutoExternalRearMirrorFollowUpSwitchChanged(i)
        "onAutoExternalRearMirrorFollowUpSwitchChanged".toast()
    }

    override fun onAutoLockChanged(i: Int) {
        super.onAutoLockChanged(i)
        "onAutoLockChanged".toast()
    }

    override fun onAutoLockSwitchChanged(i: Int) {
        super.onAutoLockSwitchChanged(i)
        "onAutoLockSwitchChanged".toast()
    }

    override fun onAutoLockTimeChanged(i: Int) {
        super.onAutoLockTimeChanged(i)
        "onAutoLockTimeChanged".toast()
    }

    override fun onAutoRainWiperStateChanged(i: Int) {
        super.onAutoRainWiperStateChanged(i)
        "onAutoRainWiperStateChanged".toast()
    }

    override fun onBTCallReductionWindMenuStateChanged(i: Int) {
        super.onBTCallReductionWindMenuStateChanged(i)
        "onBTCallReductionWindMenuStateChanged".toast()
    }

    override fun onBackDoorElectricModeChanged(i: Int) {
        super.onBackDoorElectricModeChanged(i)
        "onBackDoorElectricModeChanged".toast()
    }

    override fun onBackDoorOpenedHeightChanged(i: Int) {
        super.onBackDoorOpenedHeightChanged(i)
        "onBackDoorOpenedHeightChanged".toast()
    }

    override fun onBackHomeLightDelaySwitchChanged(i: Int) {
        super.onBackHomeLightDelaySwitchChanged(i)
        "onBackHomeLightDelaySwitchChanged".toast()
    }

    override fun onBackHomeLightDelayValueChanged(i: Int) {
        super.onBackHomeLightDelayValueChanged(i)
        "onBackHomeLightDelayValueChanged".toast()
    }

    override fun onBackRowControlSwitchChanged(i: Int) {
        super.onBackRowControlSwitchChanged(i)
        "onBackRowControlSwitchChanged".toast()
    }

    override fun onBasePadAutoRiseStateChanged(i: Int) {
        super.onBasePadAutoRiseStateChanged(i)
        "onBasePadAutoRiseStateChanged".toast()
    }

    override fun onCarRecorderRecordingChanged(i: Int) {
        super.onCarRecorderRecordingChanged(i)
        "onCarRecorderRecordingChanged".toast()
    }

    override fun onCarWarnINDSwitchChanged(i: Int) {
        super.onCarWarnINDSwitchChanged(i)
        "onCarWarnINDSwitchChanged".toast()
    }

    override fun onChargingPortSwitchChanged(i: Int) {
        super.onChargingPortSwitchChanged(i)
        "onChargingPortSwitchChanged".toast()
    }

    override fun onControlWindowSwitchChanged(i: Int) {
        super.onControlWindowSwitchChanged(i)
        "onControlWindowSwitchChanged".toast()
    }

    override fun onCourtesyLampTimeChanged(i: Int) {
        super.onCourtesyLampTimeChanged(i)
        "onCourtesyLampTimeChanged".toast()
    }

    override fun onCruiseBulletBoxChanged(i: Int) {
        super.onCruiseBulletBoxChanged(i)
        "onCruiseBulletBoxChanged".toast()
    }

    override fun onDoorLockChanged(i: Int) {
        super.onDoorLockChanged(i)
        "onDoorLockChanged".toast()
    }

    override fun onDriveConfigTypeChanged(i: Int) {
        super.onDriveConfigTypeChanged(i)
        "onDriveConfigTypeChanged".toast()
    }

    override fun onDriveDoorCloseIndSwitchChanged(i: Int) {
        super.onDriveDoorCloseIndSwitchChanged(i)
        "onDriveDoorCloseIndSwitchChanged".toast()
    }

    override fun onDriverSeatAutoReturnSwitchChanged(i: Int) {
        super.onDriverSeatAutoReturnSwitchChanged(i)
        "onDriverSeatAutoReturnSwitchChanged".toast()
    }

    override fun onDriverSeatBackChanged(i: Int) {
        super.onDriverSeatBackChanged(i)
        "onDriverSeatBackChanged".toast()
    }

    override fun onDrivingRecorderChanged(i: Int) {
        super.onDrivingRecorderChanged(i)
        "onDrivingRecorderChanged".toast()
    }

    override fun onDrivingRecorderSwitchChanged(i: Int) {
        super.onDrivingRecorderSwitchChanged(i)
        "onDrivingRecorderSwitchChanged".toast()
    }

    override fun onElecHandbrakeStateChanged(i: Int) {
        super.onElecHandbrakeStateChanged(i)
        "onElecHandbrakeStateChanged".toast()
    }

    override fun onEnergyFeedbackStrengthChanged(i: Int) {
        super.onEnergyFeedbackStrengthChanged(i)
        "onEnergyFeedbackStrengthChanged".toast()
    }

    override fun onEngineOilExitUpdateStateChanged(i: Int) {
        super.onEngineOilExitUpdateStateChanged(i)
        "onEngineOilExitUpdateStateChanged".toast()
    }

    override fun onEngineOilLevelChanged(i: Int) {
        super.onEngineOilLevelChanged(i)
        "onEngineOilLevelChanged".toast()
    }

    override fun onEngineOilUpdateSignalChanged(i: Int) {
        super.onEngineOilUpdateSignalChanged(i)
        "onEngineOilUpdateSignalChanged".toast()
    }

    override fun onHomeLightTimeChanged(i: Int) {
        super.onHomeLightTimeChanged(i)
        "onHomeLightTimeChanged".toast()
    }

    override fun onIALAreaChanged(i: Int) {
        super.onIALAreaChanged(i)
        "onIALAreaChanged".toast()
    }

    override fun onIALBrightnessChanged(i: Int) {
        super.onIALBrightnessChanged(i)
        "onIALBrightnessChanged".toast()
    }

    override fun onIALBrightnessChanged(i: Int, i2: Int) {
        super.onIALBrightnessChanged(i, i2)
        "onIALBrightnessChanged".toast()
    }

    override fun onIALColorChanged(i: Int) {
        super.onIALColorChanged(i)
        "onIALColorChanged".toast()
    }

    override fun onIALColorChanged(i: Int, i2: Int) {
        super.onIALColorChanged(i, i2)
        "onIALColorChanged".toast()
    }

    override fun onIKEYBTLowPowerModeChanged(i: Int) {
        super.onIKEYBTLowPowerModeChanged(i)
        "onIKEYBTLowPowerModeChanged".toast()
    }

    override fun onILDurationChanged(i: Int) {
        super.onILDurationChanged(i)
        "onILDurationChanged".toast()
    }

    override fun onINSThemeChanged(i: Int) {
        super.onINSThemeChanged(i)
        "onINSThemeChanged".toast()
    }

    override fun onInsideLightDoorStateChanged(i: Int) {
        super.onInsideLightDoorStateChanged(i)
        "onInsideLightDoorStateChanged".toast()
    }

    override fun onInsideRearMirrorScreenSwitchChanged(i: Int) {
        super.onInsideRearMirrorScreenSwitchChanged(i)
        "onInsideRearMirrorScreenSwitchChanged".toast()
    }

    override fun onIntelligentVoiceINDLevelChanged(i: Int) {
        super.onIntelligentVoiceINDLevelChanged(i)
        "onIntelligentVoiceINDLevelChanged".toast()
    }

    override fun onIntelligentVoiceINDSwitchChanged(i: Int) {
        super.onIntelligentVoiceINDSwitchChanged(i)
        "onIntelligentVoiceINDSwitchChanged".toast()
    }

    override fun onKeyPowerLowIndSwitchChanged(i: Int) {
        super.onKeyPowerLowIndSwitchChanged(i)
        "onKeyPowerLowIndSwitchChanged".toast()
    }

    override fun onLPSwitchDownwindowChanged(i: Int) {
        super.onLPSwitchDownwindowChanged(i)
        "onLPSwitchDownwindowChanged".toast()
    }

    override fun onLPSwitchUpwindowChanged(i: Int) {
        super.onLPSwitchUpwindowChanged(i)
        "onLPSwitchUpwindowChanged".toast()
    }

    override fun onLanguageChanged(i: Int) {
        super.onLanguageChanged(i)
        "onLanguageChanged".toast()
    }

    override fun onLearnerDriverAccLimitStateChanged(i: Int) {
        super.onLearnerDriverAccLimitStateChanged(i)
        "onLearnerDriverAccLimitStateChanged".toast()
    }

    override fun onLearnerDriverModeStateChanged(i: Int) {
        super.onLearnerDriverModeStateChanged(i)
        "onLearnerDriverModeStateChanged".toast()
    }

    override fun onLearnerDriverModeSwitchStateChanged(i: Int) {
        super.onLearnerDriverModeSwitchStateChanged(i)
        "onLearnerDriverModeSwitchStateChanged".toast()
    }

    override fun onLeaveCarPIndSwitchChanged(i: Int) {
        super.onLeaveCarPIndSwitchChanged(i)
        "onLeaveCarPIndSwitchChanged".toast()
    }

    override fun onLeaveHomeLightTimeChanged(i: Int) {
        super.onLeaveHomeLightTimeChanged(i)
        "onLeaveHomeLightTimeChanged".toast()
    }

    override fun onLeftHeadlampLevelChanged(i: Int) {
        super.onLeftHeadlampLevelChanged(i)
        "onLeftHeadlampLevelChanged".toast()
    }

    override fun onLeftHomeLightDelaySwitchChanged(i: Int) {
        super.onLeftHomeLightDelaySwitchChanged(i)
        "onLeftHomeLightDelaySwitchChanged".toast()
    }

    override fun onLeftHomeLightDelayValueChanged(i: Int) {
        super.onLeftHomeLightDelayValueChanged(i)
        "onLeftHomeLightDelayValueChanged".toast()
    }

    override fun onLeftViewMirrorFlipAngleChanged(i: Int) {
        super.onLeftViewMirrorFlipAngleChanged(i)
        "onLeftViewMirrorFlipAngleChanged".toast()
    }

    override fun onLockCarRiseWindowChanged(i: Int) {
        super.onLockCarRiseWindowChanged(i)
        "onLockCarRiseWindowChanged".toast()
    }

    override fun onLockOffDoorChanged(i: Int) {
        super.onLockOffDoorChanged(i)
        "onLockOffDoorChanged".toast()
    }

    override fun onLockUpwindowChanged(i: Int) {
        super.onLockUpwindowChanged(i)
        "onLockUpwindowChanged".toast()
    }

    override fun onLongPressUnlockWindowSwitchChanged(i: Int) {
        super.onLongPressUnlockWindowSwitchChanged(i)
        "onLongPressUnlockWindowSwitchChanged".toast()
    }

    override fun onLowBatteryIndSwitchChanged(i: Int) {
        super.onLowBatteryIndSwitchChanged(i)
        "onLowBatteryIndSwitchChanged".toast()
    }

    override fun onLowOilIndSwitchChanged(i: Int) {
        super.onLowOilIndSwitchChanged(i)
        "onLowOilIndSwitchChanged".toast()
    }

    override fun onMaintainRemindStateChanged(i: Int) {
        super.onMaintainRemindStateChanged(i)
        "onMaintainRemindStateChanged".toast()
    }

    override fun onMassageLevelStateChanged(i: Int, i2: Int) {
        super.onMassageLevelStateChanged(i, i2)
        "onMassageLevelStateChanged".toast()
    }

    override fun onMassageModeStateChanged(i: Int, i2: Int) {
        super.onMassageModeStateChanged(i, i2)
        "onMassageModeStateChanged".toast()
    }

    override fun onMicroSwitchLockWindowStateChanged(i: Int) {
        super.onMicroSwitchLockWindowStateChanged(i)
        "onMicroSwitchLockWindowStateChanged".toast()
    }

    override fun onMicroSwitchUnlockWindowStateChanged(i: Int) {
        super.onMicroSwitchUnlockWindowStateChanged(i)
        "onMicroSwitchUnlockWindowStateChanged".toast()
    }

    override fun onMissKeyIndSwitchChanged(i: Int) {
        super.onMissKeyIndSwitchChanged(i)
        "onMissKeyIndSwitchChanged".toast()
    }

    override fun onMultimediaMotorTemperatureStateChanged(i: Int) {
        super.onMultimediaMotorTemperatureStateChanged(i)
        "onMultimediaMotorTemperatureStateChanged".toast()
    }

    override fun onNightDRLightOnIndSwitchChanged(i: Int) {
        super.onNightDRLightOnIndSwitchChanged(i)
        "onNightDRLightOnIndSwitchChanged".toast()
    }

    override fun onNightDriveLightOnReminderChanged(i: Int) {
        super.onNightDriveLightOnReminderChanged(i)
        "onNightDriveLightOnReminderChanged".toast()
    }

    override fun onNightSystemModeSwitchChanged(i: Int) {
        super.onNightSystemModeSwitchChanged(i)
        "onNightSystemModeSwitchChanged".toast()
    }

    override fun onOffReminderChanged(i: Int) {
        super.onOffReminderChanged(i)
        "onOffReminderChanged".toast()
    }

    override fun onOverspeedLockStateChanged(i: Int) {
        super.onOverspeedLockStateChanged(i)
        "onOverspeedLockStateChanged".toast()
    }

    override fun onPM25PowerSwitchChanged(i: Int) {
        super.onPM25PowerSwitchChanged(i)
        "onPM25PowerSwitchChanged".toast()
    }

    override fun onPM25SwitchChanged(i: Int) {
        super.onPM25SwitchChanged(i)
        "onPM25SwitchChanged".toast()
    }

    override fun onPM25SwitchCheckChanged(i: Int) {
        super.onPM25SwitchCheckChanged(i)
        "onPM25SwitchCheckChanged".toast()
    }

    override fun onPM25TimeCheckChanged(i: Int) {
        super.onPM25TimeCheckChanged(i)
        "onPM25TimeCheckChanged".toast()
    }

    override fun onParkBrakeIndSwitchChanged(i: Int) {
        super.onParkBrakeIndSwitchChanged(i)
        "onParkBrakeIndSwitchChanged".toast()
    }

    override fun onPedestrianRecognizeSwitchChanged(i: Int) {
        super.onPedestrianRecognizeSwitchChanged(i)
        "onPedestrianRecognizeSwitchChanged".toast()
    }

    override fun onRearAcOnlineStateChanged(i: Int) {
        super.onRearAcOnlineStateChanged(i)
        "onRearAcOnlineStateChanged".toast()
    }

    override fun onRearAcPanelAutoLockTimeChanged(i: Int) {
        super.onRearAcPanelAutoLockTimeChanged(i)
        "onRearAcPanelAutoLockTimeChanged".toast()
    }

    override fun onRearMirrorFlipChanged(i: Int) {
        super.onRearMirrorFlipChanged(i)
        "onRearMirrorFlipChanged".toast()
    }

    override fun onRearViewMirrorAutoFoldModeChanged(i: Int) {
        super.onRearViewMirrorAutoFoldModeChanged(i)
        "onRearViewMirrorAutoFoldModeChanged".toast()
    }

    override fun onRearViewMirrorFlipSwitchChanged(i: Int) {
        super.onRearViewMirrorFlipSwitchChanged(i)
        "onRearViewMirrorFlipSwitchChanged".toast()
    }

    override fun onRemoteControlDownwindowChanged(i: Int) {
        super.onRemoteControlDownwindowChanged(i)
        "onRemoteControlDownwindowChanged".toast()
    }

    override fun onRemoteControlUpwindowChanged(i: Int) {
        super.onRemoteControlUpwindowChanged(i)
        "onRemoteControlUpwindowChanged".toast()
    }

    override fun onRemoteControlUpwindowStateChanged(i: Int) {
        super.onRemoteControlUpwindowStateChanged(i)
        "onRemoteControlUpwindowStateChanged".toast()
    }

    override fun onRemoteCtlUnlockingStateChanged(i: Int) {
        super.onRemoteCtlUnlockingStateChanged(i)
        "onRemoteCtlUnlockingStateChanged".toast()
    }

    override fun onRightHeadlampLevelChanged(i: Int) {
        super.onRightHeadlampLevelChanged(i)
        "onRightHeadlampLevelChanged".toast()
    }

    override fun onRightViewMirrorFlipAngleChanged(i: Int) {
        super.onRightViewMirrorFlipAngleChanged(i)
        "onRightViewMirrorFlipAngleChanged".toast()
    }

    override fun onSOCConfigChanged(i: Int) {
        super.onSOCConfigChanged(i)
        "onSOCConfigChanged".toast()
    }

    override fun onSOCTargetRangeChanged(i: Int) {
        super.onSOCTargetRangeChanged(i)
        "onSOCTargetRangeChanged".toast()
    }

    override fun onSafeBeltIndSwitchChanged(i: Int) {
        super.onSafeBeltIndSwitchChanged(i)
        "onSafeBeltIndSwitchChanged".toast()
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
