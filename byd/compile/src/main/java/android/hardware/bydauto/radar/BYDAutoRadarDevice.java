package android.hardware.bydauto.radar;


import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;

/* loaded from: classes.dex */
public final class BYDAutoRadarDevice extends AbsBYDAutoDevice {

    public BYDAutoRadarDevice(Context context) {
        super(context);
    }

    public static synchronized BYDAutoRadarDevice getInstance(Context context) {
        return null;
    }

    /**
     * 获取所有雷达距离
     * @return
     */
    public int[] getAllRadarDistance() {
        return null;
    }

    /**
     *获取所有雷达障碍距离
     * @return
     */
    public int[] getAllRadarObstacleDistances() {
        return null;
    }

    /**
     *获取所有雷达距离
     */
    public int[] getAllRadarProbeStates() {
        return null;
    }

    /**
     * 获取所有雷达探测状态
     * @return
     */
    public int[][] getAllRadarStatus() {
        return null;
    }

    public void getAllStatus() {
    }

    public int[] getFeatureList() {
        return null;
    }

    public int getRadarManufacture() {
        return 0;
    }

    public int getRadarObstacleDistance(int i) {
        return 0;
    }

    public int getRadarProbeState(int i) {
        return 0;
    }

    public int getReverseRadarSwitchState() {
        return 0;
    }

    public int getType() {
        return 1025;
    }

    public void setAllStatus() {
    }

    public int setRadarSoundState(int i) {
        return 0;
    }

    public int setReverseRadarSwitchState(int i) {
        return 0;
    }

    public void registerListener(AbsBYDAutoRadarListener absBYDAutoRadarListener) {
    }

    public void unregisterListener(AbsBYDAutoRadarListener absBYDAutoRadarListener) {
    }

}
