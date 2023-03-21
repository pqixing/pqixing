package android.hardware.bydauto.light;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoLightDevice extends AbsBYDAutoDevice {
    public static final int AFS_SWITCH = 2;
    public static final int CMD_DAY_RUNNING_LIGHT_STATE = 15;
    public static final int CMD_DOUBLE_FLASH_STATE = 17;
    public static final int CMD_REVERSING_LIGHT_STATE = 18;
    public static final int CMD_SEQUENTIAL_STATE = 16;
    public static final int CMD_STOP_LIGHT_STATE = 14;
    public static final int DAY_RUNNING_LIGHT_INVALID = 0;
    public static final int DAY_RUNNING_LIGHT_OFF = 2;
    public static final int DAY_RUNNING_LIGHT_ON = 1;
    private static final boolean DEBUG = true;
    public static final int DOUBLE_FLASH_INVALID = 0;
    public static final int DOUBLE_FLASH_OFF = 2;
    public static final int DOUBLE_FLASH_ON = 1;
    public static final int FOOT_LIGHT = 11;
    public static final int FRONT_FOG_LIGHT = 9;
    public static final int GROUP_LEFT_LIGHT = 12;
    public static final int GROUP_RIGHT_LIGHT = 13;
    public static final int HIGH_BEAM_LIGHT = 6;
    public static final int ILLUMINATION_LEVEL = 1;
    public static final int LEFT_TURN_SIGNAL_LIGHT = 7;
    public static final int LIGHT_AUTO_SWITCH = 3;
    public static final int LIGHT_COMMAND_BUSY = -2147482647;
    public static final int LIGHT_COMMAND_FAILED = -2147482648;
    public static final int LIGHT_COMMAND_INVALID = -2147482645;
    public static final int LIGHT_COMMAND_SUCCESS = 0;
    public static final int LIGHT_COMMAND_TIMEOUT = -2147482646;
    public static final int LIGHT_FOOT = 8;
    public static final int LIGHT_FRONT_FOG = 6;
    static final String LIGHT_GET_PERM = "android.permission.BYDAUTO_LIGHT_GET";
    public static final int LIGHT_GROUP_LEFT = 0;
    public static final int LIGHT_GROUP_RIGHT = 1;
    public static final int LIGHT_HIGH_BEAM = 3;
    public static final int LIGHT_ILLUM_LEVEL1 = 1;
    public static final int LIGHT_ILLUM_LEVEL2 = 2;
    public static final int LIGHT_ILLUM_LEVEL3 = 3;
    public static final int LIGHT_ILLUM_LEVEL4 = 4;
    public static final int LIGHT_ILLUM_LEVEL5 = 5;
    public static final int LIGHT_LEFT_TURN_SIGNAL = 4;
    public static final int LIGHT_LOW_BEAM = 2;
    public static final int LIGHT_OFF = 0;
    public static final int LIGHT_ON = 1;
    public static final int LIGHT_REAR_FOG = 7;
    public static final int LIGHT_RIGHT_TURN_SIGNAL = 5;
    static final String LIGHT_SET_PERM = "android.permission.BYDAUTO_LIGHT_SET";
    public static final int LIGHT_SIDE = 1;
    public static final int LIGHT_STATE_FAULT = 1;
    public static final int LIGHT_STATE_INVALID = 2;
    public static final int LIGHT_STATE_NORMAL = 0;
    public static final int LOW_BEAM_LIGHT = 5;
    public static final int REAR_FOG_LIGHT = 10;
    public static final int REVERSING_LIGHT_INVALID = 0;
    public static final int REVERSING_LIGHT_OFF = 2;
    public static final int REVERSING_LIGHT_ON = 1;
    public static final int RIGHT_TURN_SIGNAL_LIGHT = 8;
    public static final int SEQUENTIAL_LIGHT_INVALID = 3;
    public static final int SEQUENTIAL_LIGHT_OFF = 1;
    public static final int SEQUENTIAL_LIGHT_ON = 0;
    public static final int SIDE_LIGHT = 4;
    public static final int STOP_LIGHT_FLASH = 2;
    public static final int STOP_LIGHT_INVALID = 0;
    public static final int STOP_LIGHT_OFF = 3;
    public static final int STOP_LIGHT_ON = 1;
    protected static final String TAG = "BYDAutoLightDevice";
    private static int mDeviceType = 1004;
    private static int mFrontFogLightIsOn;
    private static int mHighBeamLightIsOn;
    private static BYDAutoLightDevice mInstance;
    private static int mLeftTurnLightIsOn;
    private static int mLightAutoIsOn;
    private static int mLowBeamLightIsOn;
    private static int mRearFogLightIsOn;
    private static int mRightTurnLightIsOn;
    private static int mSideLightIsOn;
    private final Context mContext;

    private BYDAutoLightDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoLightDevice getInstance(Context context) {
        BYDAutoLightDevice bYDAutoLightDevice;
        synchronized (BYDAutoLightDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoLightDevice(context);
            }
            bYDAutoLightDevice = mInstance;
        }
        return bYDAutoLightDevice;
    }

    public int getAFSSwitch() {
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getAFSSwitch state is: " + i);
        return i;
    }

    public void getAllStatus() {
    }

    public int getDayRunningLightState() {
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        int i = super.get(mDeviceType, 15);
        Log.d(TAG, "getDayRunningLightState result is: " + i);
        return i;
    }

    public int getDoubleFlashLightState() {
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        int i = super.get(mDeviceType, 17);
        Log.d(TAG, "getDoubleFlashLightState result is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getGroupHeadlightState(int i) {
        int i2;
        Log.d(TAG, "getGroupHeadlightState area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        if (i == 0) {
            i2 = 12;
        } else if (i != 1) {
            return -2147482645;
        } else {
            i2 = 13;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getGroupHeadlightState result is: " + i3);
        return i3;
    }

    public int getIlluminationIntensityLevel() {
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getIlluminationIntensityLevel level is: " + i);
        return i;
    }

    public int getLightAutoStatus() {
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getLightAutoStatus result is: " + i);
        return i;
    }

    public int getLightStatus(int i) {
        int i2;
        Log.d(TAG, "getLightStatus type is: " + i);
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        switch (i) {
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 5;
                break;
            case 3:
                i2 = 6;
                break;
            case 4:
                i2 = 7;
                break;
            case 5:
                i2 = 8;
                break;
            case 6:
                i2 = 9;
                break;
            case 7:
                i2 = 10;
                break;
            case 8:
                i2 = 11;
                break;
            default:
                return -2147482645;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getLightStatus result is: " + i3);
        return i3;
    }

    public int getReversingLightState() {
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        int i = super.get(mDeviceType, 18);
        Log.d(TAG, "getReversingLightState result is: " + i);
        return i;
    }

    public int getSequentialLightState() {
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        int i = super.get(mDeviceType, 16);
        Log.d(TAG, "getSequentialLightState result is: " + i);
        return i;
    }

    public int getStopLightState() {
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        int i = super.get(mDeviceType, 14);
        Log.d(TAG, "getStopLightState result is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1004;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoLightListener absBYDAutoLightListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        if (absBYDAutoLightListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoLightListener);
        }
    }

    public void unregisterListener(AbsBYDAutoLightListener absBYDAutoLightListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        if (absBYDAutoLightListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoLightListener);
        }
    }

    public void registerListener(AbsBYDAutoLightListener absBYDAutoLightListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(LIGHT_GET_PERM, null);
        if (absBYDAutoLightListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoLightListener, iArr);
        }
    }
}
