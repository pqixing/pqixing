package android.hardware.bydauto.ac;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;

public final class BYDAutoAcDevice extends AbsBYDAutoDevice {

    private BYDAutoAcDevice(Context context) {
        super(context);
    }

    public static synchronized BYDAutoAcDevice getInstance(Context context) {

        return null;
    }

    public int enablePurificationFunctionPrompt(int i) {return 0;  }

    public int feelColdHot(int i, int i2) {return 0;  }

    public int getAcCompressorManualSign() {return 0;  }

    public int getAcCompressorMode() {return 0;  }

    public int getAcControlMode() {return 0;  }

    public int getAcCycleMode() {return 0;  }

    public int getAcDefrostOnlineState() {return 0;  }

    public int getAcDefrostState(int i) {return 0;  }

    public int getAcFaultNumShownState() {return 0;  }

    public int getAcKeyActionState() {return 0;  }

    public int getAcMaxCoolingState() {return 0;  }

    public int getAcOnlineState() {return 0;  }

    public int getAcPromptBoxShownState() {return 0;  }

    public int getAcPtcPreheatSignal() {return 0;  }

    public int getAcRemoteCtrlTime() {return 0;  }

    public int getAcStartState() {return 0;  }

    public int getAcSubBatteryTemperature() {return 0;  }

    public int getAcTemperatureControlMode() {return 0;  }

    public int getAcType() {return 0;  }

    public int getAcVentilationState() {return 0;  }

    public int getAcWarmState() {return 0;  }

    public int getAcWarmTypeOnlineState() {return 0;  }

    public int getAcWindLevel() {return 0;  }

    public int getAcWindLevelManualSign() {return 0;  }

    public int getAcWindMode() {return 0;  }

    public int getAcWindModeManualSign() {return 0;  }

    public int getAcWindModeNum() {return 0;  }

    public int getAcWindModeShownState() {return 0;  }

    public int getAirQualityCtrlMenuState() {return 0;  }

    public void getAllStatus() {
    }

    public int[] getFeatureList() {
        return null;
    }

    public int getRearAcControlMode() {return 0;  }

    public int getRearAcLockState() {return 0;  }

    public int getRearAcMaxWindLevel() {return 0;  }

    public int getRearAcStartState() {return 0;  }

    public int getRearAcWindLevel() {return 0;  }

    public int getRearAcWindMode() {return 0;  }

    public int getTemperatureUnit() {return 0;  }

    public int getTemprature(int i) {return 0;  }

    public int getType() {
        return 1000;
    }

    public int getVoiceCmdResult() {return 0;  }

    public int hasFeature(String str) {return 0;  }


    public int qurAcAllStatus() {return 0;  }

    public int reset(int i, int i2) {return 0;  }

    public int setAcCompressorMode(int i, int i2) {return 0;  }

    public int setAcControlMode(int i, int i2) {return 0;  }

    public int setAcCycleMode(int i, int i2) {return 0;  }

    public int setAcDefrostState(int i, int i2, int i3) {return 0;  }

    public int setAcMaxCoolingState(int i) {return 0;  }

    public int setAcRemoteCtrlTime(int i) {return 0;  }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
        if (r8 <= 33) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setAcTemperature(int r7, int r8, int r9, int r10) {return 0;  }

    public int setAcTemperatureControlMode(int i, int i2) {return 0;  }

    public int setAcVentilationState(int i, int i2) {return 0;  }

    public int setAcWarmState(int i) {return 0;  }

    public int setAcWindLevel(int i, int i2) {return 0;  }

    public int setAcWindMode(int i, int i2) {return 0;  }

    public void setAllStatus() {  }

    public int setRearAcControlMode(int i, int i2) {return 0;  }

    public int setRearAcLockState(int i) {return 0;  }

    public int setRearAcWindLevel(int i, int i2) {return 0;  }

    public int setRearAcWindMode(int i, int i2) {return 0;  }

    public int start(int i) {return 0;  }

    public int startRearAc(int i) {return 0;  }

    public int stop(int i) {return 0;  }

}
