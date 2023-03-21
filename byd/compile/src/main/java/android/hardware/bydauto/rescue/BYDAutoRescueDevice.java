package android.hardware.bydauto.rescue;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoRescueDevice extends AbsBYDAutoDevice {
    public static final int CALL_AIRBAG_STATE = 3;
    private static final boolean DEBUG = true;
    public static final int INFO_FROM_MCU = 1;
    public static final int INFO_TO_MCU = 2;
    public static final int RESCUE_COMMAND_BUSY = -2147482647;
    public static final int RESCUE_COMMAND_FAILED = -2147482648;
    public static final int RESCUE_COMMAND_INVALID_VALUE = -2147482645;
    public static final int RESCUE_COMMAND_SUCCESS = 0;
    public static final int RESCUE_COMMAND_TIMEOUT = -2147482646;
    static final String RESCUE_GET_PERM = "android.permission.BYDAUTO_RESCUE_GET";
    static final String RESCUE_SET_PERM = "android.permission.BYDAUTO_RESCUE_SET";
    protected static final String TAG = "BYDAutoRescueDevice";
    private static int mDeviceType = 1040;
    private static BYDAutoRescueDevice mInstance;
    private final Context mContext;

    private BYDAutoRescueDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoRescueDevice getInstance(Context context) {
        BYDAutoRescueDevice bYDAutoRescueDevice;
        synchronized (BYDAutoRescueDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoRescueDevice(context);
            }
            bYDAutoRescueDevice = mInstance;
        }
        return bYDAutoRescueDevice;
    }

    public int getAirbagState() {
        this.mContext.enforceCallingOrSelfPermission(RESCUE_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getAirbagState: airbag collision state is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getInfoFromMCU() {
        this.mContext.enforceCallingOrSelfPermission(RESCUE_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getInfoFromMCU: info is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_RESCUE;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoRescueListener absBYDAutoRescueListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(RESCUE_GET_PERM, null);
        if (absBYDAutoRescueListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoRescueListener);
        }
    }

    public int setInfoToMCU(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(RESCUE_SET_PERM, null);
        if (bArr == null) {
            Log.e(TAG, "setInfoToMCU: info is null!");
            return -2147482645;
        }
        int length = bArr.length;
        Log.d(TAG, "setInfoToMCU: the info length is " + length);
        if (length >= 1) {
            return super.set(mDeviceType, 2, bArr);
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoRescueListener absBYDAutoRescueListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(RESCUE_GET_PERM, null);
        if (absBYDAutoRescueListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoRescueListener);
        }
    }

    public void registerListener(AbsBYDAutoRescueListener absBYDAutoRescueListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(RESCUE_GET_PERM, null);
        if (absBYDAutoRescueListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoRescueListener, iArr);
        }
    }
}
