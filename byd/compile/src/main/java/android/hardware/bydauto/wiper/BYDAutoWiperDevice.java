package android.hardware.bydauto.wiper;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoWiperDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    protected static final String TAG = "BYDAutoWiperDevice";
    public static final int WINDSCREEN_WIPER_SENSITIVITY = 3;
    public static final int WIPER_AREA_FRONT = 0;
    public static final int WIPER_AREA_FRONT_STATE = 1;
    public static final int WIPER_AREA_REAR = 1;
    public static final int WIPER_AREA_REAR_STATE = 2;
    public static final int WIPER_COMMAND_BUSY = -2147482647;
    public static final int WIPER_COMMAND_FAILED = -2147482648;
    public static final int WIPER_COMMAND_INVALID = -2147482645;
    public static final int WIPER_COMMAND_SUCCESS = 0;
    public static final int WIPER_COMMAND_TIMEOUT = -2147482646;
    private static final String WIPER_GET_PERM = "android.permission.BYDAUTO_WIPER_GET";
    public static final int WIPER_RELAY_STATE = 4;
    public static final int WIPER_RELAY_STATE_ACTUATION = 1;
    public static final int WIPER_RELAY_STATE_DISCONNECT = 2;
    public static final int WIPER_RELAY_STATE_INVALID = 0;
    public static final int WIPER_SENSITIVITY_1 = 1;
    public static final int WIPER_SENSITIVITY_2 = 2;
    public static final int WIPER_SENSITIVITY_3 = 3;
    public static final int WIPER_SENSITIVITY_4 = 4;
    public static final int WIPER_SENSITIVITY_INVALID = 0;
    private static final String WIPER_SET_PERM = "android.permission.BYDAUTO_WIPER_SET";
    public static final int WIPER_STATE_INVALID = 0;
    public static final int WIPER_STATE_NOT_RESET = 1;
    public static final int WIPER_STATE_RESET = 2;
    private static int mDeviceType = 1046;
    private static BYDAutoWiperDevice mInstance;
    private final Context mContext;

    private BYDAutoWiperDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoWiperDevice getInstance(Context context) {
        BYDAutoWiperDevice bYDAutoWiperDevice;
        synchronized (BYDAutoWiperDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoWiperDevice(context);
            }
            bYDAutoWiperDevice = mInstance;
        }
        return bYDAutoWiperDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_WIPER;
    }

    public int getWindscreenWiperRelayState() {
        this.mContext.enforceCallingOrSelfPermission(WIPER_GET_PERM, null);
        int i = super.get(mDeviceType, 4);
        Log.d(TAG, "getWindscreenWiperRelayState state is: " + i);
        return i;
    }

    public int getWindscreenWiperResetState(int i) {
        Log.d(TAG, "getWindscreenWiperResetState area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(WIPER_GET_PERM, null);
        int i2 = 1;
        if (i != 0) {
            if (i != 1) {
                return -2147482645;
            }
            i2 = 2;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getWindscreenWiperResetState result is: " + i3);
        return i3;
    }

    public int getWindscreenWiperSensitivity() {
        this.mContext.enforceCallingOrSelfPermission(WIPER_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getWindscreenWiperSensitivity value is: " + i);
        return i;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoWiperListener absBYDAutoWiperListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(WIPER_GET_PERM, null);
        if (absBYDAutoWiperListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoWiperListener);
        }
    }

    public void unregisterListener(AbsBYDAutoWiperListener absBYDAutoWiperListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(WIPER_GET_PERM, null);
        if (absBYDAutoWiperListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoWiperListener);
        }
    }

    public void registerListener(AbsBYDAutoWiperListener absBYDAutoWiperListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(WIPER_GET_PERM, null);
        if (absBYDAutoWiperListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoWiperListener, iArr);
        }
    }
}
