package android.hardware.bydauto.test;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoTestDevice extends AbsBYDAutoDevice {
    public static final int AUDIO_DEBUG_MODE_ENTER = 1;
    public static final int AVAH_DEBUG_1K = 1;
    public static final int AVAH_DEBUG_2K = 2;
    public static final int AVAH_DEBUG_3K = 3;
    public static final int CMD_FEATURE_MCU_STATE = 3;
    public static final int CMD_TEST_AUDIO_AVAH = 9;
    public static final int CMD_TEST_AUDIO_FM = 11;
    public static final int CMD_TEST_AUDIO_MODE = 8;
    public static final int CMD_TEST_AUDIO_XF = 10;
    private static final boolean DEBUG = true;
    public static final int DEBUG_EXIT = 0;
    public static final int FM_DEBUG_1K = 1;
    public static final int FM_DEBUG_2K = 2;
    public static final int FM_DEBUG_3K = 3;
    public static final int IFLY_DEBUG_FUNCTION = 2;
    public static final int IFLY_DEBUG_RECORDING = 1;
    protected static final String TAG = "BYDAutoTestDevice";
    public static final int TEST_COMMAND_BUSY = -2147482647;
    public static final int TEST_COMMAND_FAILED = -2147482648;
    public static final int TEST_COMMAND_INVALID_VALUE = -2147482645;
    public static final int TEST_COMMAND_SUCCESS = 0;
    public static final int TEST_COMMAND_TIMEOUT = -2147482646;
    static final String TEST_GET_PERM = "android.permission.BYDAUTO_TEST_GET";
    static final String TEST_SET_PERM = "android.permission.BYDAUTO_TEST_SET";
    public static final int TEST_SET_TEC_LEVEL = 1;
    public static final int TEST_SET_TEC_LEVEL_0 = 0;
    public static final int TEST_SET_TEC_LEVEL_1 = 1;
    public static final int TEST_SET_TEC_LEVEL_2 = 2;
    public static final int TEST_SET_TEC_LEVEL_3 = 3;
    public static final int TEST_SET_TEC_LEVEL_4 = 4;
    public static final int TEST_SET_TEC_LEVEL_5 = 5;
    private static int mDeviceType = 1022;
    private static BYDAutoTestDevice mInstance;
    private final Context mContext;

    private BYDAutoTestDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoTestDevice getInstance(Context context) {
        BYDAutoTestDevice bYDAutoTestDevice;
        synchronized (BYDAutoTestDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoTestDevice(context);
            }
            bYDAutoTestDevice = mInstance;
        }
        return bYDAutoTestDevice;
    }

    public int getAVAHDebugMode() {
        this.mContext.enforceCallingOrSelfPermission(TEST_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getAVAHDebugMode mode is: " + i);
        return i;
    }

    public int getAudioDebugMode() {
        this.mContext.enforceCallingOrSelfPermission(TEST_GET_PERM, null);
        int i = super.get(mDeviceType, 8);
        Log.d(TAG, "getAudioDebugMode mode is: " + i);
        return i;
    }

    public int getFMDebugMode() {
        this.mContext.enforceCallingOrSelfPermission(TEST_GET_PERM, null);
        int i = super.get(mDeviceType, 11);
        Log.d(TAG, "getFMDebugMode mode is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getIflyDebugMode() {
        this.mContext.enforceCallingOrSelfPermission(TEST_GET_PERM, null);
        int i = super.get(mDeviceType, 10);
        Log.d(TAG, "getIflyDebugMode mode is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_TEST;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoTestListener absBYDAutoTestListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(TEST_GET_PERM, null);
        if (absBYDAutoTestListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoTestListener);
        }
    }

    public int setAVAHDebugMode(int i) {
        Log.d(TAG, "setAVAHDebugMode mode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TEST_SET_PERM, null);
        if (i < 0 || i > 3) {
            return -2147482645;
        }
        return super.set(mDeviceType, 9, i);
    }

    public int setAudioDebugMode(int i) {
        Log.d(TAG, "setAudioDebugMode mode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TEST_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 8, i);
        }
        return -2147482645;
    }

    public int setFMDebugMode(int i) {
        Log.d(TAG, "setFMDebugMode mode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TEST_SET_PERM, null);
        if (i < 0 || i > 3) {
            return -2147482645;
        }
        return super.set(mDeviceType, 11, i);
    }

    public int setIflyDebugMode(int i) {
        Log.d(TAG, "setIflyDebugMode mode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TEST_SET_PERM, null);
        if (i < 0 || i > 2) {
            return -2147482645;
        }
        return super.set(mDeviceType, 10, i);
    }

    public int setTecLevel(int i) {
        Log.d(TAG, "setTecLevel level is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TEST_SET_PERM, null);
        if (i < 0 || i > 5) {
            return -2147482645;
        }
        return super.set(mDeviceType, 1, i);
    }

    public void unregisterListener(AbsBYDAutoTestListener absBYDAutoTestListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(TEST_GET_PERM, null);
        if (absBYDAutoTestListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoTestListener);
        }
    }

    public void registerListener(AbsBYDAutoTestListener absBYDAutoTestListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(TEST_GET_PERM, null);
        if (absBYDAutoTestListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoTestListener, iArr);
        }
    }
}
