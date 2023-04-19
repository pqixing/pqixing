//refactor
package android.hardware.bydauto.setting;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
public abstract class AbsBYDAutoSettingListener implements IBYDAutoListener {
public void onACAutoAirModeChanged(int i) { }
public void onACAutoWindLevelChanged(int i) { }
public void onACBTWindSwitchChanged(int i) { }
public void onACPauseCycleSwitchChanged(int i) { }
public void onACTunnelCycleSwitchChanged(int i) { }
public void onAirLightPanelStateChanged(int i) { }
public void onAirLightTextNumberChanged(int i) { }
public void onAirLightTextStateChanged(int i) { }
public void onAutoExternalRearMirrorFoldChanged(int i) { }
public void onAutoExternalRearMirrorFollowUpSwitchChanged(int i) { }
public void onAutoLockChanged(int i) { }
public void onAutoLockSwitchChanged(int i) { }
public void onAutoLockTimeChanged(int i) { }
public void onAutoRainWiperStateChanged(int i) { }
public void onBTCallReductionWindMenuStateChanged(int i) { }
public void onBackDoorElectricModeChanged(int i) { }
public void onBackDoorOpenedHeightChanged(int i) { }
public void onBackHomeLightDelaySwitchChanged(int i) { }
public void onBackHomeLightDelayValueChanged(int i) { }
public void onBackRowControlSwitchChanged(int i) { }
public void onBasePadAutoRiseStateChanged(int i) { }
public void onCarRecorderRecordingChanged(int i) { }
public void onCarWarnINDSwitchChanged(int i) { }
public void onChargingPortSwitchChanged(int i) { }
public void onControlWindowSwitchChanged(int i) { }
public void onCourtesyLampTimeChanged(int i) { }
public void onCruiseBulletBoxChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDoorLockChanged(int i) { }
public void onDriveConfigTypeChanged(int i) { }
public void onDriveDoorCloseIndSwitchChanged(int i) { }
public void onDriverSeatAutoReturnSwitchChanged(int i) { }
public void onDriverSeatBackChanged(int i) { }
public void onDrivingRecorderChanged(int i) { }
public void onDrivingRecorderSwitchChanged(int i) { }
public void onElecHandbrakeStateChanged(int i) { }
public void onEnergyFeedbackStrengthChanged(int i) { }
public void onEngineOilExitUpdateStateChanged(int i) { }
public void onEngineOilLevelChanged(int i) { }
public void onEngineOilUpdateSignalChanged(int i) { }
public void onHomeLightTimeChanged(int i) { }
public void onIALAreaChanged(int i) { }
public void onIALBrightnessChanged(int i) { }
public void onIALColorChanged(int i) { }
public void onIKEYBTLowPowerModeChanged(int i) { }
public void onILDurationChanged(int i) { }
public void onINSThemeChanged(int i) { }
public void onInsideLightDoorStateChanged(int i) { }
public void onInsideRearMirrorScreenSwitchChanged(int i) { }
public void onIntelligentVoiceINDLevelChanged(int i) { }
public void onIntelligentVoiceINDSwitchChanged(int i) { }
public void onKeyPowerLowIndSwitchChanged(int i) { }
public void onLPSwitchDownwindowChanged(int i) { }
public void onLPSwitchUpwindowChanged(int i) { }
public void onLanguageChanged(int i) { }
public void onLearnerDriverAccLimitStateChanged(int i) { }
public void onLearnerDriverModeStateChanged(int i) { }
public void onLearnerDriverModeSwitchStateChanged(int i) { }
public void onLeaveCarPIndSwitchChanged(int i) { }
public void onLeaveHomeLightTimeChanged(int i) { }
public void onLeftHeadlampLevelChanged(int i) { }
public void onLeftHomeLightDelaySwitchChanged(int i) { }
public void onLeftHomeLightDelayValueChanged(int i) { }
public void onLeftViewMirrorFlipAngleChanged(int i) { }
public void onLockCarRiseWindowChanged(int i) { }
public void onLockOffDoorChanged(int i) { }
public void onLockUpwindowChanged(int i) { }
public void onLongPressUnlockWindowSwitchChanged(int i) { }
public void onLowBatteryIndSwitchChanged(int i) { }
public void onLowOilIndSwitchChanged(int i) { }
public void onMaintainRemindStateChanged(int i) { }
public void onMassageLevelStateChanged(int i, int i2) { }
public void onMassageModeStateChanged(int i, int i2) { }
public void onMicroSwitchLockWindowStateChanged(int i) { }
public void onMicroSwitchUnlockWindowStateChanged(int i) { }
public void onMissKeyIndSwitchChanged(int i) { }
public void onMultimediaMotorTemperatureStateChanged(int i) { }
public void onNightDRLightOnIndSwitchChanged(int i) { }
public void onNightDriveLightOnReminderChanged(int i) { }
public void onNightSystemModeSwitchChanged(int i) { }
public void onOffReminderChanged(int i) { }
public void onOverspeedLockStateChanged(int i) { }
public void onPM25PowerSwitchChanged(int i) { }
public void onPM25SwitchChanged(int i) { }
public void onPM25SwitchCheckChanged(int i) { }
public void onPM25TimeCheckChanged(int i) { }
public void onParkBrakeIndSwitchChanged(int i) { }
public void onPedestrianRecognizeSwitchChanged(int i) { }
public void onRearAcOnlineStateChanged(int i) { }
public void onRearAcPanelAutoLockTimeChanged(int i) { }
public void onRearMirrorFlipChanged(int i) { }
public void onRearViewMirrorAutoFoldModeChanged(int i) { }
public void onRearViewMirrorFlipSwitchChanged(int i) { }
public void onRemoteControlDownwindowChanged(int i) { }
public void onRemoteControlUpwindowChanged(int i) { }
public void onRemoteControlUpwindowStateChanged(int i) { }
public void onRemoteCtlUnlockingStateChanged(int i) { }
public void onRightHeadlampLevelChanged(int i) { }
public void onRightViewMirrorFlipAngleChanged(int i) { }
public void onSOCConfigChanged(int i) { }
public void onSOCTargetRangeChanged(int i) { }
public void onSafeBeltIndSwitchChanged(int i) { }
public void onSafeWarnStateChanged(int i) { }
public void onSeatHeatingStateChanged(int i, int i2) { }
public void onSeatHeatingStateChanged1(int i, int i2) { }
public void onSeatVentilatingStateChanged(int i, int i2) { }
public void onSmartWelcomeLightStateChanged(int i) { }
public void onStartKeyStateChanged(int i) { }
public void onStartOrPowerIndSwitchChanged(int i) { }
public void onSteerAssisModeChanged(int i) { }
public void onSteerAssistPermissionChanged(int i) { }
public void onSteerBackChanged(int i) { }
public void onSteerPositionAutoReturnSwitchChanged(int i) { }
public void onSteeringWheelHeatingStateChanged(int i) { }
public void onStopRemoteCtrlDriveIndChanged(int i) { }
public void onUnlockDownwindowChanged(int i) { }
public void onWindscreenWiperOverhaulStateChanged(int i, int i2) { }
public void onIALBrightnessChanged(int i, int i2) { }
public void onIALColorChanged(int i, int i2) { }
 }
