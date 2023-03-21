package android.hardware.bydauto.radar;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import com.byd.nlu.dm.StringUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.shiro.config.Ini;

/* loaded from: classes.dex */
public final class BYDAutoRadarDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int RADAR_AREA_FRONT_LEFT_MID = 7;
    public static final int RADAR_AREA_FRONT_RIGHT_MID = 8;
    public static final int RADAR_AREA_LEFT = 5;
    public static final int RADAR_AREA_LEFT_FRONT = 1;
    public static final int RADAR_AREA_LEFT_REAR = 3;
    public static final int RADAR_AREA_MIDDLE_REAR = 9;
    private static final int RADAR_AREA_NUM = 8;
    public static final int RADAR_AREA_RIGHT = 6;
    public static final int RADAR_AREA_RIGHT_FRONT = 2;
    public static final int RADAR_AREA_RIGHT_REAR = 4;
    public static final int RADAR_COMMAND_BUSY = -2147482647;
    public static final int RADAR_COMMAND_FAILED = -2147482648;
    public static final int RADAR_COMMAND_INVALID_VALUE = -2147482645;
    public static final int RADAR_COMMAND_SUCCESS = 0;
    public static final int RADAR_COMMAND_TIMEOUT = -2147482646;
    public static final int RADAR_DISTANCE_MAX = 155;
    public static final int RADAR_DISTANCE_MIN = 0;
    private static final String RADAR_GET_PERM = "android.permission.BYDAUTO_RADAR_GET";
    public static final int RADAR_MANUFACTURE = 19;
    public static final int RADAR_MANUFACTURE_15_SECTOR = 0;
    public static final int RADAR_MANUFACTURE_VALEO = 1;
    public static final int RADAR_MR_OBSTACLE_DIS = 21;
    public static final int RADAR_MR_SONDE_STATUS = 20;
    public static final int RADAR_OBSTACLE_DISTANCE_ALL = 2;
    public static final int RADAR_OBSTACLE_DISTANCE_FRONT_LEFT_MID = 14;
    public static final int RADAR_OBSTACLE_DISTANCE_FRONT_RIGHT_MID = 16;
    public static final int RADAR_OBSTACLE_DISTANCE_LEFT = 10;
    public static final int RADAR_OBSTACLE_DISTANCE_LEFT_FRONT = 2;
    public static final int RADAR_OBSTACLE_DISTANCE_LEFT_REAR = 6;
    public static final int RADAR_OBSTACLE_DISTANCE_MAX = 6;
    public static final int RADAR_OBSTACLE_DISTANCE_MIN = 0;
    public static final int RADAR_OBSTACLE_DISTANCE_RIGHT = 12;
    public static final int RADAR_OBSTACLE_DISTANCE_RIGHT_FRONT = 4;
    public static final int RADAR_OBSTACLE_DISTANCE_RIGHT_REAR = 8;
    public static final int RADAR_OBSTACLE_DISTANCE_SAFE = 14;
    public static final int RADAR_OBSTACLE_DIS_MAX = 12;
    public static final int RADAR_PROBE_STATE_ABNORMAL = 0;
    public static final int RADAR_PROBE_STATE_ALL = 1;
    public static final int RADAR_PROBE_STATE_FRONT_LEFT_MID = 13;
    public static final int RADAR_PROBE_STATE_FRONT_RIGHT_MID = 15;
    public static final int RADAR_PROBE_STATE_GREEN = 2;
    public static final int RADAR_PROBE_STATE_LEFT = 9;
    public static final int RADAR_PROBE_STATE_LEFT_FRONT = 1;
    public static final int RADAR_PROBE_STATE_LEFT_REAR = 5;
    public static final int RADAR_PROBE_STATE_RED = 4;
    public static final int RADAR_PROBE_STATE_RIGHT = 11;
    public static final int RADAR_PROBE_STATE_RIGHT_FRONT = 3;
    public static final int RADAR_PROBE_STATE_RIGHT_REAR = 7;
    public static final int RADAR_PROBE_STATE_SAFE = 1;
    public static final int RADAR_PROBE_STATE_YELLOW = 3;
    public static final int RADAR_REVERSE_SWITCH_OFF = 0;
    public static final int RADAR_REVERSE_SWITCH_ON = 1;
    private static final String RADAR_SET_PERM = "android.permission.BYDAUTO_RADAR_SET";
    public static final int RADAR_SOUND_STATE = 18;
    public static final int RADAR_SOUND_STATE_OFF = 0;
    public static final int RADAR_SOUND_STATE_ON = 1;
    public static final int RADAR_STATUS_ALL = 1;
    public static final int REVERSE_RADAR_SWITCH_STATE = 17;
    protected static final String TAG = "BYDAutoRadarDevice";
    private static int mDeviceType = 1025;
    private static BYDAutoRadarDevice mInstance;
    private final Context mContext;

    private BYDAutoRadarDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoRadarDevice getInstance(Context context) {
        BYDAutoRadarDevice bYDAutoRadarDevice;
        synchronized (BYDAutoRadarDevice.class) {
            if (mInstance == null && context != null) {
                mInstance = new BYDAutoRadarDevice(context);
            }
            bYDAutoRadarDevice = mInstance;
        }
        return bYDAutoRadarDevice;
    }

    public int[] getAllRadarDistance() {
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        int[] intArray = super.getIntArray(mDeviceType, new int[]{2, 4, 6, 8, 10, 12, 14, 16, 21});
        if (intArray.length < 2) {
            Log.e(TAG, "getAllRadarDistance: error is " + intArray[0]);
            return new int[]{intArray[0], intArray[0], intArray[0], intArray[0], intArray[0], intArray[0], intArray[0], intArray[0], intArray[0]};
        }
        Log.d(TAG, "getAllRadarDistance: left front is " + intArray[0] + ", right front is " + intArray[1] + ", left rear is " + intArray[2] + ", right rear is " + intArray[3] + ", left is " + intArray[4] + ", right is " + intArray[5] + ", front left is " + intArray[6] + ", front right is " + intArray[7] + ", middle rear radar is " + intArray[8]);
        return intArray;
    }

    public int[] getAllRadarObstacleDistances() {
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        int[] iArr = new int[8];
        byte[] buffer = super.getBuffer(mDeviceType, 2);
        byte[] copyOfRange = Arrays.copyOfRange(buffer, 4, buffer.length);
        int i = 0;
        if (16 != copyOfRange.length) {
            while (i < 8) {
                iArr[i] = -2147482648;
                i++;
            }
            Log.e(TAG, "getAllRadarObstacleDistances vformat.length is: " + copyOfRange.length);
            return iArr;
        }
        Log.d(TAG, "getAllRadarObstacleDistances int value: \n");
        while (i < 8) {
            iArr[i] = copyOfRange[(i * 2) + 1];
            Log.d(TAG, Ini.SECTION_PREFIX + i + "]: " + iArr[i] + StringUtils.SPACE);
            i++;
        }
        return iArr;
    }

    public int[] getAllRadarProbeStates() {
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        int[] intArray = super.getIntArray(mDeviceType, new int[]{1, 3, 5, 7, 9, 11, 13, 15, 20});
        if (intArray.length < 2) {
            Log.e(TAG, "getAllRadarProbeStates: error is " + intArray[0]);
            return new int[]{intArray[0], intArray[0], intArray[0], intArray[0], intArray[0], intArray[0], intArray[0], intArray[0], intArray[0]};
        }
        Log.d(TAG, "getAllRadarProbeStates: left front state is " + intArray[0] + ", right front state is " + intArray[1] + ", left rear state is " + intArray[2] + ", right rear state " + intArray[3] + ", left state is " + intArray[4] + ", right state is " + intArray[5] + ", front left min state is " + intArray[6] + ", front right state is " + intArray[7] + ", middle rear radar is " + intArray[8]);
        return intArray;
    }

    public int[][] getAllRadarStatus() {
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        int[][] iArr = (int[][]) Array.newInstance(int.class, 2, 8);
        byte[] buffer = super.getBuffer(mDeviceType, 1);
        byte[] copyOfRange = Arrays.copyOfRange(buffer, 4, buffer.length);
        int i = 0;
        if (16 != copyOfRange.length) {
            while (i < 16) {
                iArr[i % 2][i / 2] = -2147482648;
                i++;
            }
            Log.e(TAG, "getAllRadarStatus vformat.length is: " + copyOfRange.length);
            return iArr;
        }
        Log.d(TAG, "getAllRadarStatus int value: \n");
        while (i < 16) {
            int i2 = i % 2;
            int i3 = i / 2;
            iArr[i2][i3] = copyOfRange[i];
            Log.d(TAG, Ini.SECTION_PREFIX + i2 + "][" + i3 + "]: " + iArr[i2][i3] + StringUtils.SPACE);
            i++;
        }
        return iArr;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getRadarManufacture() {
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        int i = super.get(mDeviceType, 19);
        Log.d(TAG, "getRadarManufacture is: " + i);
        return i;
    }

    public int getRadarObstacleDistance(int i) {
        Log.d(TAG, "getRadarObstacleDistance area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        if (i < 1 || i > 9) {
            return -2147482645;
        }
        int i2 = -2147482648;
        switch (i) {
            case 1:
                i2 = super.get(mDeviceType, 2);
                break;
            case 2:
                i2 = super.get(mDeviceType, 4);
                break;
            case 3:
                i2 = super.get(mDeviceType, 6);
                break;
            case 4:
                i2 = super.get(mDeviceType, 8);
                break;
            case 5:
                i2 = super.get(mDeviceType, 10);
                break;
            case 6:
                i2 = super.get(mDeviceType, 12);
                break;
            case 7:
                i2 = super.get(mDeviceType, 14);
                break;
            case 8:
                i2 = super.get(mDeviceType, 16);
                break;
            case 9:
                i2 = super.get(mDeviceType, 21);
                break;
        }
        Log.d(TAG, "getRadarObstacleDistance distance is: " + i2);
        return i2;
    }

    public int getRadarProbeState(int i) {
        int i2;
        Log.d(TAG, "getRadarProbeState area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        switch (i) {
            case 1:
                i2 = super.get(mDeviceType, 1);
                break;
            case 2:
                i2 = super.get(mDeviceType, 3);
                break;
            case 3:
                i2 = super.get(mDeviceType, 5);
                break;
            case 4:
                i2 = super.get(mDeviceType, 7);
                break;
            case 5:
                i2 = super.get(mDeviceType, 9);
                break;
            case 6:
                i2 = super.get(mDeviceType, 11);
                break;
            case 7:
                i2 = super.get(mDeviceType, 13);
                break;
            case 8:
                i2 = super.get(mDeviceType, 15);
                break;
            case 9:
                i2 = super.get(mDeviceType, 20);
                break;
            default:
                return -2147482645;
        }
        Log.d(TAG, "getRadarProbeState state is: " + i2);
        return i2;
    }

    public int getReverseRadarSwitchState() {
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        int i = super.get(mDeviceType, 17);
        Log.d(TAG, "getReverseRadarSwitchState is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1025;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoRadarListener absBYDAutoRadarListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        if (absBYDAutoRadarListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoRadarListener);
        }
    }

    public void setAllStatus() {
    }

    public int setRadarSoundState(int i) {
        this.mContext.enforceCallingOrSelfPermission(RADAR_SET_PERM, null);
        Log.d(TAG, "setRadarSoundState: the state is " + i);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, 18, i);
        }
        return -2147482645;
    }

    public int setReverseRadarSwitchState(int i) {
        this.mContext.enforceCallingOrSelfPermission(RADAR_SET_PERM, null);
        Log.d(TAG, "setReverseRadarSwitchState: the state is " + i);
        if (i == 0 || i == 1) {
            int i2 = super.get(mDeviceType, 17);
            if (i2 == i) {
                Log.e(TAG, "setReverseRadarSwitchState: the current state already is " + i2);
                return -2147482648;
            }
            return super.set(mDeviceType, 17, 1);
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoRadarListener absBYDAutoRadarListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        if (absBYDAutoRadarListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoRadarListener);
        }
    }

    public void registerListener(AbsBYDAutoRadarListener absBYDAutoRadarListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(RADAR_GET_PERM, null);
        if (absBYDAutoRadarListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoRadarListener, iArr);
        }
    }
}
