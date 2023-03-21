package android.hardware.bydauto.pm2p5;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoPM2p5Device extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int PM2P5_ALL_STATUS = 11;
    public static final int PM2P5_COMMAND_BUSY = -2147482647;
    public static final int PM2P5_COMMAND_FAILED = -2147482648;
    public static final int PM2P5_COMMAND_INVALID_VALUE = -2147482645;
    public static final int PM2P5_COMMAND_SUCCESS = 0;
    public static final int PM2P5_COMMAND_TIMEOUT = -2147482646;
    private static final String PM2P5_GET_PERM = "android.permission.BYDAUTO_PM2P5_GET";
    public static final int PM2P5_LEVEL_CHANGED = 9;
    public static final int PM2P5_LEVEL_EXCELLENT = 1;
    public static final int PM2P5_LEVEL_GOOD = 2;
    public static final int PM2P5_LEVEL_HEAVY = 5;
    public static final int PM2P5_LEVEL_IN = 2;
    public static final int PM2P5_LEVEL_INVALID = 0;
    public static final int PM2P5_LEVEL_LOW_GRADE = 3;
    public static final int PM2P5_LEVEL_MIDDLE = 4;
    public static final int PM2P5_LEVEL_OUT = 5;
    public static final int PM2P5_LEVEL_SERIOUS = 6;
    public static final int PM2P5_ONLINE_STATE = 10;
    public static final int PM2P5_ONLINE_STATE_NULL = 0;
    public static final int PM2P5_ONLINE_STATE_OFF = 2;
    public static final int PM2P5_ONLINE_STATE_ON = 1;
    public static final int PM2P5_PROMPT_INFO = 12;
    private static final String PM2P5_SET_PERM = "android.permission.BYDAUTO_PM2P5_SET";
    public static final int PM2P5_STATE_CHANGED = 8;
    public static final int PM2P5_STATE_IN = 1;
    public static final int PM2P5_STATE_OFF = 0;
    public static final int PM2P5_STATE_ON = 1;
    public static final int PM2P5_STATE_OUT = 4;
    public static final int PM2P5_VALUE_CHANGED = 7;
    public static final int PM2P5_VALUE_IN = 3;
    public static final int PM2P5_VALUE_MAX = 3000;
    public static final int PM2P5_VALUE_MIN = 0;
    public static final int PM2P5_VALUE_OUT = 6;
    public static final int PM2P5_WARNING_INFO = 13;
    public static final int PROMPT_INFO_INNER_LOOP = 2;
    public static final int PROMPT_INFO_NORMAL = 0;
    public static final int PROMPT_INFO_START_AC = 1;
    protected static final String TAG = "BYDAutoPM2p5Device";
    public static final int WARNING_INFO_EXCESS_IN = 1;
    public static final int WARNING_INFO_EXCESS_OUT = 2;
    public static final int WARNING_INFO_NORMAL = 0;
    private static int mDeviceType = 1008;
    private static BYDAutoPM2p5Device mInstance;
    private final Context mContext;

    private BYDAutoPM2p5Device(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoPM2p5Device getInstance(Context context) {
        BYDAutoPM2p5Device bYDAutoPM2p5Device;
        synchronized (BYDAutoPM2p5Device.class) {
            if (mInstance == null && context != null) {
                mInstance = new BYDAutoPM2p5Device(context);
            }
            bYDAutoPM2p5Device = mInstance;
        }
        return bYDAutoPM2p5Device;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int[] getPM2p5CheckState() {
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        int[] iArr = {super.get(mDeviceType, 1), super.get(mDeviceType, 4)};
        Log.d(TAG, "getPM2p5CheckState state in is: " + iArr[0] + "state out is: " + iArr[1]);
        return iArr;
    }

    public int[] getPM2p5Level() {
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        int[] iArr = {super.get(mDeviceType, 2), super.get(mDeviceType, 5)};
        Log.d(TAG, "getPM2p5Level level in is: " + iArr[0] + "level out is: " + iArr[1]);
        return iArr;
    }

    public int getPM2p5OnlineState() {
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        int i = super.get(mDeviceType, 10);
        Log.d(TAG, "getPM2p5OnlineState state is: " + i);
        return i;
    }

    public int[] getPM2p5Value() {
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        int[] iArr = {super.get(mDeviceType, 3), super.get(mDeviceType, 6)};
        Log.d(TAG, "getPM2p5Value value in is: " + iArr[0] + "value out is: " + iArr[1]);
        return iArr;
    }

    public int getPM2p5WarningInfo() {
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        int i = super.get(mDeviceType, 13);
        Log.d(TAG, "getPM2p5WarningInfo value is: " + i);
        return i;
    }

    public int getPromptInfo() {
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        int i = super.get(mDeviceType, 12);
        Log.d(TAG, "getPromptInfo value is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1008;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoPM2p5Listener absBYDAutoPM2p5Listener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        if (absBYDAutoPM2p5Listener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoPM2p5Listener);
        }
    }

    public void setAllStatus() {
    }

    public int syncPM2p5AllStatus() {
        this.mContext.enforceCallingOrSelfPermission(PM2P5_SET_PERM, null);
        int i = super.set(mDeviceType, 11, -1);
        Log.d(TAG, "syncPM2p5AllStatus ret is: " + i);
        return i;
    }

    public void unregisterListener(AbsBYDAutoPM2p5Listener absBYDAutoPM2p5Listener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        if (absBYDAutoPM2p5Listener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoPM2p5Listener);
        }
    }

    public void registerListener(AbsBYDAutoPM2p5Listener absBYDAutoPM2p5Listener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(PM2P5_GET_PERM, null);
        if (absBYDAutoPM2p5Listener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoPM2p5Listener, iArr);
        }
    }
}
