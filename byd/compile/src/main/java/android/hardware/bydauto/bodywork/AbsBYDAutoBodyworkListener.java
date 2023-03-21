package android.hardware.bydauto.bodywork;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoBodyworkListener implements IBYDAutoListener {
    protected static final String TAG = "AbsBYDAutoBodyworkListener";

    public AbsBYDAutoBodyworkListener() {
        throw new RuntimeException("Stub!");
    }

    public void onAlarmStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onAutoSystemStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onAutoVINChanged(String str) {
        throw new RuntimeException("Stub!");
    }

    public void onBatteryVoltageLevelChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onCarWindowAntiPinchConfigChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        throw new RuntimeException("Stub!");
    }

    public void onDoorStateChanged(int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public void onFuelElecLowPowerChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onMessage5sOnlineStateChanged(int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public void onMoonRoofConfigChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onPowerDayModeChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onPowerLevelChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onRainCloseWindowChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onSmartVoiceLimitChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onSteeringWheelAngleChanged(double d2, int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public void onSteeringWheelValueChanged(int i, double d2) {
        throw new RuntimeException("Stub!");
    }

    public void onSunroofCloseNoticeChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onSunroofInitStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onSunroofPositionChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onSunroofStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onSunroofWindowblindPositionChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onWindoblindInitStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onWindowOpenPercentChanged(int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public void onWindowPermitStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onWindowStateChanged(int i, int i2) {
        throw new RuntimeException("Stub!");
    }
}
