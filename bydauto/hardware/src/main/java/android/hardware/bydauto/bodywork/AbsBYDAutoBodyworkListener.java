//refactor
package android.hardware.bydauto.bodywork;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
public abstract class AbsBYDAutoBodyworkListener implements IBYDAutoListener {
public void onAlarmStateChanged(int i) { }
public void onAutoSystemStateChanged(int i) { }
public void onAutoVINChanged(String str) { }
public void onBatteryVoltageLevelChanged(int i) { }
public void onCarWindowAntiPinchConfigChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDoorStateChanged(int i, int i2) { }
public void onFuelElecLowPowerChanged(int i) { }
public void onMessage5sOnlineStateChanged(int i, int i2) { }
public void onMoonRoofConfigChanged(int i) { }
public void onPowerDayModeChanged(int i) { }
public void onPowerLevelChanged(int i) { }
public void onRainCloseWindowChanged(int i) { }
public void onSmartVoiceLimitChanged(int i) { }
public void onSteeringWheelAngleChanged(double d2, int i, int i2) { }
public void onSteeringWheelValueChanged(int i, double d2) { }
public void onSunroofCloseNoticeChanged(int i) { }
public void onSunroofInitStateChanged(int i) { }
public void onSunroofPositionChanged(int i) { }
public void onSunroofStateChanged(int i) { }
public void onSunroofWindowblindPositionChanged(int i) { }
public void onWindoblindInitStateChanged(int i) { }
public void onWindowOpenPercentChanged(int i, int i2) { }
public void onWindowPermitStateChanged(int i) { }
public void onWindowStateChanged(int i, int i2) { }
 }
