//refactor
package android.hardware.bydauto.ac;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoAcListener implements IBYDAutoListener {
public void onAcAirQualityCtrlMenuStateChanged(int i) { }
public void onAcCompressorManualSignChanged(int i) { }
public void onAcCompressorModeChanged(int i) { }
public void onAcCtrlModeChanged(int i) { }
public void onAcCycleModeChanged(int i) { }
public void onAcDefrostOnlineStateChanged(int i) { }
public void onAcDefrostStateChanged(int i, int i2) { }
public void onAcFaultNumShownStateChanged(int i) { }
public void onAcKeyActionStateChanged(int i) { }
public void onAcMaxCoolingStateChanged(int i) { }
public void onAcOnlineStateChanged(int i) { }
public void onAcPromptBoxShownStateChanged(int i) { }
public void onAcPtcPreheatSignalChanged(int i) { }
public void onAcRearStarted() { }
public void onAcRearStoped() { }
public void onAcRemoteCtrlTimeChanged(int i) { }
public void onAcStarted() { }
public void onAcStoped() { }
public void onAcTemperatureControlModeChanged(int i) { }
public void onAcVentilationStateChanged(int i) { }
public void onAcWarmStateChanged(int i) { }
public void onAcWarmTypeOnlineStateChanged(int i) { }
public void onAcWindLevelChanged(int i) { }
public void onAcWindLevelManualSignChanged(int i) { }
public void onAcWindModeChanged(int i) { }
public void onAcWindModeManualSignChanged(int i) { }
public void onAcWindModeShownStateChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onFeatureChanged(String str, int i) { }
public void onOtaSubBatteryTemperatureChanged(int i) { }
public void onRearAcCtrlModeChanged(int i) { }
public void onRearAcLockStateChanged(int i) { }
public void onRearAcMaxWindLevelChanged(int i) { }
public void onRearAcWindLevelChanged(int i) { }
public void onRearAcWindModeChanged(int i) { }
public void onTemperatureChanged(int i, int i2) { }
public void onTemperatureUnitChanged(int i) { }
public void onVoiceCmdResultChanged(int i) { }
 }
