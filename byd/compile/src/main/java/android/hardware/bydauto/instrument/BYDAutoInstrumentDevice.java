package android.hardware.bydauto.instrument;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;

import java.util.ArrayList;

public final class BYDAutoInstrumentDevice extends AbsBYDAutoDevice {

    private BYDAutoInstrumentDevice(Context context) {
        super(context);
    }

    public static synchronized BYDAutoInstrumentDevice getInstance(Context context) {
        return null;
    }

    public int clearInfo(int i) {
        return 0;
    }

    public int getAlarmBuzzleState() {
        return 0;
    }

    public void getAllStatus() {
    }

    public int getAverageSpeed() {
        return 0;
    }

    public int getBacklightBrightness() {
        return 0;
    }

    public int getBacklightModeState(int i) {
        return 0;
    }

    public int getCallInfoResult() {
        return 0;
    }

    public double getExternalChargingPower() {
        return 0;
    }

    public int[] getFeatureList() {
        return null;
    }

    public int getInstrumentScreenType() {
        return 0;
    }

    public int getKeyDetectionReminder() {
        return 0;
    }

    public int getMaintenanceInfo(int i) {
        return 0;
    }

    public int getMalfunctionInfo(int i) {
        return 0;
    }

    public int getMalfunctionInfo2(int i) {
        return 0;
    }

    public ArrayList<Integer> getMalfunctionList() {
        return null;
    }

    public int getMusicInfoResult() {
        return 0;
    }

    public int getPowerOffErrInfo() {
        return 0;
    }

    public int getPowerOnErrInfo() {
        return 0;
    }

    public int getRadioInfoResult() {
        return 0;
    }

    public int getRemoteDrivingReminder() {
        return 0;
    }

    public int getType() {
        return 1007;
    }

    public int getUnit(int i) {
        return 0;
    }

    public boolean postEvent(int i, int i2, int i3, Object obj) {
        return false;
    }


    public int reset(int i, int i2) {
        return 0;
    }

    public int sendAddressInfo(int i, String str) {
        return 0;
    }

    public int sendCallInfo(byte[] bArr) {
        return 0;
    }

    public int sendCallState(int i) {
        return 0;
    }

    public int sendCallTime(int i, int i2, int i3) {
        return 0;
    }

    public int sendCameraGuidanceInfo(int i, int i2, int i3) {
        return 0;
    }

    public int sendMusicInfo(byte[] bArr) {
        return 0;
    }

    public int sendMusicName(String str) {
        return 0;
    }

    public int sendMusicPlaybackProgress(int i) {
        return 0;
    }

    public int sendMusicSource(int i) {
        return 0;
    }

    public int sendMusicState(int i) {
        return 0;
    }

    public int sendNextPathName(String str) {
        return 0;
    }

    public int sendRadioInfo(byte[] bArr) {
        return 0;
    }

    public int sendRadioState(int i) {
        return 0;
    }

    public int sendRestRouteInfo(int i, int i2, int i3) {
        return 0;
    }

    public int sendSafeGuidanceInfo(int i, int i2, int i3) {
        return 0;
    }

    public int sendSimpleGuidanceInfo(int i, int i2) {
        return 0;
    }

    public void setAllStatus() {
    }

    public int setBacklightBrightness(int i) {
        return 0;
    }

    public int setBacklightModeState(int i, int i2) {
        return 0;
    }

    public int setMaintenanceInfo(int i, int i2) {
        return 0;
    }

    public int setUnit(int i, int i2) {
        return 0;
    }


    public boolean postEvent(int i, int i2, double d, Object obj) {
        return false;
    }

}
