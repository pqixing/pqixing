package android.hardware.bydauto.speed;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoSpeedDevice extends AbsBYDAutoDevice {
    public static final double ACCELERATE_MAX = 31.0d;
    public static final double ACCELERATE_MIN = -30.0d;
    public static final int ACCELERATE_VALUE = 4;
    public static final int ACCELERATOR_BREAK_DEPTH_CHANGED = 5;
    public static final int ACCELERATOR_S = 2;
    public static final int AUTO_SPEED = 1;
    public static final int BRAKE_S = 3;
    private static final boolean DEBUG = true;
    public static final int DEEP_PERSENT_MAX = 100;
    public static final int DEEP_PERSENT_MIN = 0;
    public static final int SPEED_COMMAND_BUSY = -2147482647;
    public static final int SPEED_COMMAND_FAILED = -2147482648;
    public static final int SPEED_COMMAND_INVALID = -2147482645;
    public static final int SPEED_COMMAND_SUCCESS = 0;
    public static final int SPEED_COMMAND_TIMEOUT = -2147482646;
    public static final int SPEED_FROM_GATEWAY = 6;
    static final String SPEED_GET_PERM = "android.permission.BYDAUTO_SPEED_GET";
    public static final double SPEED_MAX = 282.0d;
    public static final double SPEED_MIN = 0.0d;
    static final String SPEED_SET_PERM = "android.permission.BYDAUTO_SPEED_SET";
    protected static final String TAG = "BYDAutoSpeedDevice";
    private static int mDeviceType = 1013;
    private static BYDAutoSpeedDevice mInstance;
    private final Context mContext;

    private BYDAutoSpeedDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoSpeedDevice getInstance(Context context) {
        BYDAutoSpeedDevice bYDAutoSpeedDevice;
        synchronized (BYDAutoSpeedDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoSpeedDevice(context);
            }
            bYDAutoSpeedDevice = mInstance;
        }
        return bYDAutoSpeedDevice;
    }

    public int getAccelerateDeepness() {
        this.mContext.enforceCallingOrSelfPermission(SPEED_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getAccelerateDeepness value is: " + i);
        return i;
    }

    public double getAccelerateValue() {
        this.mContext.enforceCallingOrSelfPermission(SPEED_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 4);
        Log.d(TAG, "getAccelerateValue value is: " + d2);
        return d2;
    }

    public void getAllStatus() {
    }

    public int getBrakeDeepness() {
        this.mContext.enforceCallingOrSelfPermission(SPEED_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getBrakeDeepness value is: " + i);
        return i;
    }

    public double getCurrentSpeed() {
        this.mContext.enforceCallingOrSelfPermission(SPEED_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 1);
        Log.d(TAG, "getCurrentSpeed: speed is " + d2);
        return d2;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public double getSpeedFromGateway() {
        this.mContext.enforceCallingOrSelfPermission(SPEED_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 6);
        Log.d(TAG, "getSpeedFromGateway: speed is " + d2);
        return d2;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1013;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + Arrays.toString(bArr));
        return onPostEvent(new BYDAutoSpeedEvent(i, i2, bArr, obj));
    }

    public void registerListener(AbsBYDAutoSpeedListener absBYDAutoSpeedListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(SPEED_GET_PERM, null);
        if (absBYDAutoSpeedListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSpeedListener);
        }
    }

    public void unregisterListener(AbsBYDAutoSpeedListener absBYDAutoSpeedListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(SPEED_GET_PERM, null);
        if (absBYDAutoSpeedListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoSpeedListener);
        }
    }

    public void registerListener(AbsBYDAutoSpeedListener absBYDAutoSpeedListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(SPEED_GET_PERM, null);
        if (absBYDAutoSpeedListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSpeedListener, iArr);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + d2);
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }
}
