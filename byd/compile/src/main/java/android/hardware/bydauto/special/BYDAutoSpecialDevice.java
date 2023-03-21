package android.hardware.bydauto.special;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoSpecialDevice extends AbsBYDAutoDevice {
    public static final int CMD_WHEEL_DIECTION = 2;
    public static final int CMD_WHEEL_SPEED = 1;
    private static final boolean DEBUG = true;
    public static final int SPECIAL_COMMAND_BUSY = -2147482647;
    public static final int SPECIAL_COMMAND_FAILED = -2147482648;
    public static final int SPECIAL_COMMAND_INVALID_VALUE = -2147482645;
    public static final int SPECIAL_COMMAND_SUCCESS = 0;
    public static final int SPECIAL_COMMAND_TIMEOUT = -2147482646;
    static final String SPECIAL_GET_PERM = "android.permission.BYDAUTO_SPECIAL_GET";
    protected static final String TAG = "BYDAutoSpecialDevice";
    private static int mDeviceType = 1049;
    private static BYDAutoSpecialDevice mInstance;
    private final Context mContext;

    private BYDAutoSpecialDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoSpecialDevice getInstance(Context context) {
        BYDAutoSpecialDevice bYDAutoSpecialDevice;
        synchronized (BYDAutoSpecialDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoSpecialDevice(context);
            }
            bYDAutoSpecialDevice = mInstance;
        }
        return bYDAutoSpecialDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_SPECIAL;
    }

    public byte[] getWheelDirection() {
        this.mContext.enforceCallingOrSelfPermission(SPECIAL_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 2);
        Log.d(TAG, "getWheelDirection" + Arrays.toString(buffer));
        return buffer;
    }

    public byte[] getWheelSpeed() {
        this.mContext.enforceCallingOrSelfPermission(SPECIAL_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 1);
        Log.d(TAG, "getWheelSpeed" + Arrays.toString(buffer));
        return buffer;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoSpecialListener absBYDAutoSpecialListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(SPECIAL_GET_PERM, null);
        if (absBYDAutoSpecialListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSpecialListener);
        }
    }

    public void unregisterListener(AbsBYDAutoSpecialListener absBYDAutoSpecialListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(SPECIAL_GET_PERM, null);
        if (absBYDAutoSpecialListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoSpecialListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + Arrays.toString(bArr));
        return onPostEvent(new BYDAutoSpecialEvent(i, i2, bArr, obj));
    }

    public void registerListener(AbsBYDAutoSpecialListener absBYDAutoSpecialListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(SPECIAL_GET_PERM, null);
        if (absBYDAutoSpecialListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSpecialListener, iArr);
        }
    }
}
