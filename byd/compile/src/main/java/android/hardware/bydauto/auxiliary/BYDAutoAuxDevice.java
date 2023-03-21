package android.hardware.bydauto.auxiliary;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoAuxDevice extends AbsBYDAutoDevice {
    public static final int AUX_COMMAND_BUSY = -2147482647;
    public static final int AUX_COMMAND_FAILED = -2147482648;
    public static final int AUX_COMMAND_INVALID_VALUE = -2147482645;
    public static final int AUX_COMMAND_SUCCESS = 0;
    public static final int AUX_COMMAND_TIMEOUT = -2147482646;
    public static final int AUX_CONNECTED = 1;
    public static final int AUX_CONNECT_STATE = 1;
    public static final int AUX_DISCONNECTED = 0;
    static final String AUX_GET_PERM = "android.permission.BYDAUTO_AUX_GET";
    public static final int AUX_NO_SIGNAL = 0;
    static final String AUX_SET_PERM = "android.permission.BYDAUTO_AUX_SET";
    public static final int AUX_SIGNAL = 1;
    public static final int AUX_SIGNAL_STATE = 2;
    private static final boolean DEBUG = true;
    protected static final String TAG = "BYDAutoAuxDevice";
    private static int mConnectState = 0;
    private static int mDeviceType = 1019;
    private static BYDAutoAuxDevice mInstance;
    private static int mSignalState;
    private final Context mContext;

    private BYDAutoAuxDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoAuxDevice getInstance(Context context) {
        BYDAutoAuxDevice bYDAutoAuxDevice;
        synchronized (BYDAutoAuxDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoAuxDevice(context);
            }
            bYDAutoAuxDevice = mInstance;
        }
        return bYDAutoAuxDevice;
    }

    public void getAllStatus() {
    }

    public int getAuxConnectStatus() {
        this.mContext.enforceCallingOrSelfPermission(AUX_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, " getAuxConnectStatus is: " + i);
        return i;
    }

    public int getAuxSignalStatus() {
        this.mContext.enforceCallingOrSelfPermission(AUX_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, " getAuxSignalStatus is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1019;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoAuxListener absBYDAutoAuxListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(AUX_GET_PERM, null);
        if (absBYDAutoAuxListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoAuxListener);
        }
    }

    public void setAllStatus() {
    }

    public void unregisterListener(AbsBYDAutoAuxListener absBYDAutoAuxListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(AUX_GET_PERM, null);
        if (absBYDAutoAuxListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoAuxListener);
        }
    }

    public void registerListener(AbsBYDAutoAuxListener absBYDAutoAuxListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(AUX_GET_PERM, null);
        if (absBYDAutoAuxListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoAuxListener, iArr);
        }
    }
}
