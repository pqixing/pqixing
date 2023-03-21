package android.hardware.bydauto.safetybelt;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoSafetyBeltDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int MESSAGE_481 = 1;
    public static final int MESSAGE_OFFLINE = 0;
    public static final int MESSAGE_ONLINE = 1;
    public static final int MSR_481_ONLINE = 12;
    public static final int MSR_STATE = 11;
    public static final int SAFETY_BELT_AREA_DEPUTY = 2;
    public static final int SAFETY_BELT_AREA_MAIN = 1;
    public static final int SAFETY_BELT_AREA_SECOND_ROW_SEAT_LEFT = 3;
    public static final int SAFETY_BELT_AREA_SECOND_ROW_SEAT_MID = 5;
    public static final int SAFETY_BELT_AREA_SECOND_ROW_SEAT_RIGHT = 4;
    public static final int SAFETY_BELT_COMMAND_AREA_DEPUTY = 2;
    public static final int SAFETY_BELT_COMMAND_AREA_MAIN = 1;
    public static final int SAFETY_BELT_COMMAND_AREA_SECOND_ROW_SEAT_LEFT = 3;
    public static final int SAFETY_BELT_COMMAND_AREA_SECOND_ROW_SEAT_MID = 5;
    public static final int SAFETY_BELT_COMMAND_AREA_SECOND_ROW_SEAT_RIGHT = 4;
    public static final int SAFETY_BELT_COMMAND_BUSY = -2147482647;
    public static final int SAFETY_BELT_COMMAND_FAILED = -2147482648;
    public static final int SAFETY_BELT_COMMAND_INVALID_VALUE = -2147482645;
    public static final int SAFETY_BELT_COMMAND_SUCCESS = 0;
    public static final int SAFETY_BELT_COMMAND_TIMEOUT = -2147482646;
    static final String SAFETY_BELT_GET_PERM = "android.permission.BYDAUTO_SAFETY_BELT_GET";
    public static final int SAFETY_BELT_MSR_SWITCH_OFF = 1;
    public static final int SAFETY_BELT_MSR_SWITCH_ON = 0;
    public static final int SAFETY_BELT_PASSENGER_COMMAND_DEPUTY = 6;
    public static final int SAFETY_BELT_PASSENGER_COMMAND_SECOND_ROW_SEAT_LEFT = 7;
    public static final int SAFETY_BELT_PASSENGER_COMMAND_SECOND_ROW_SEAT_MID = 9;
    public static final int SAFETY_BELT_PASSENGER_COMMAND_SECOND_ROW_SEAT_RIGHT = 8;
    public static final int SAFETY_BELT_PASSENGER_DEPUTY = 1;
    public static final int SAFETY_BELT_PASSENGER_SECOND_ROW_SEAT_LEFT = 2;
    public static final int SAFETY_BELT_PASSENGER_SECOND_ROW_SEAT_MID = 4;
    public static final int SAFETY_BELT_PASSENGER_SECOND_ROW_SEAT_RIGHT = 3;
    public static final int SAFETY_BELT_PASSENGER_STATE_INVALID = 2;
    public static final int SAFETY_BELT_PASSENGER_STATE_NOBODY = 0;
    public static final int SAFETY_BELT_PASSENGER_STATE_SOMEBODY = 1;
    public static final int SAFETY_BELT_REMINDER = 10;
    public static final int SAFETY_BELT_REMINDER_ENABLED = 1;
    public static final int SAFETY_BELT_SBCD_INVALID = 0;
    public static final int SAFETY_BELT_SBCD_OFF = 1;
    public static final int SAFETY_BELT_SBCD_ON = 2;
    static final String SAFETY_BELT_SET_PERM = "android.permission.BYDAUTO_SAFETY_BELT_SET";
    public static final int SAFETY_BELT_STATE_INVALID = 2;
    public static final int SAFETY_BELT_STATE_LOCK = 1;
    public static final int SAFETY_BELT_STATE_UNLOCK = 0;
    protected static final String TAG = "BYDAutoSafetyBeltDevice";
    private static int mDeviceType = 1042;
    private static BYDAutoSafetyBeltDevice mInstance;
    private final Context mContext;

    private BYDAutoSafetyBeltDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoSafetyBeltDevice getInstance(Context context) {
        BYDAutoSafetyBeltDevice bYDAutoSafetyBeltDevice;
        synchronized (BYDAutoSafetyBeltDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoSafetyBeltDevice(context);
            }
            bYDAutoSafetyBeltDevice = mInstance;
        }
        return bYDAutoSafetyBeltDevice;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getMessage5sOnlineState(int i) {
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_GET_PERM, null);
        if (i == 1) {
            int i2 = super.get(mDeviceType, 12);
            Log.d(TAG, "getMessage5sOnlineState id is: " + i + " and state is: " + i2);
            return i2;
        }
        return -2147482645;
    }

    public int getPassengerStatus(int i) {
        int i2;
        Log.d(TAG, "getPassengerStatus area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_GET_PERM, null);
        if (i == 1) {
            i2 = 6;
        } else if (i == 2) {
            i2 = 7;
        } else if (i == 3) {
            i2 = 8;
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = 9;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getPassengerStatus state is: " + i3);
        return i3;
    }

    public int getSafetyBeltMsrState() {
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_GET_PERM, null);
        int i = super.get(mDeviceType, 11);
        Log.d(TAG, "getSafetyBeltMsrState: value is " + i);
        return i;
    }

    public int getSafetyBeltReminder() {
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_GET_PERM, null);
        int i = super.get(mDeviceType, 10);
        Log.d(TAG, "getSafetyBeltReminder: value is " + i);
        return i;
    }

    public int getSafetyBeltStatus(int i) {
        Log.d(TAG, "getSafetyBeltStatus area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_GET_PERM, null);
        int i2 = 5;
        if (i == 1) {
            i2 = 1;
        } else if (i == 2) {
            i2 = 2;
        } else if (i == 3) {
            i2 = 3;
        } else if (i == 4) {
            i2 = 4;
        } else if (i != 5) {
            return -2147482645;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getSafetyBeltStatus state is: " + i3);
        return i3;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_SAFETY_BELT;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoSafetyBeltListener absBYDAutoSafetyBeltListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_GET_PERM, null);
        if (absBYDAutoSafetyBeltListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSafetyBeltListener);
        }
    }

    public int setSafetyBeltSbcdState(int i) {
        Log.d(TAG, "setSafetyBeltSbcdState state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_SET_PERM, null);
        if (i < 0 || i > 1) {
            return -2147482645;
        }
        return super.set(mDeviceType, 11, i);
    }

    public void unregisterListener(AbsBYDAutoSafetyBeltListener absBYDAutoSafetyBeltListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_GET_PERM, null);
        if (absBYDAutoSafetyBeltListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoSafetyBeltListener);
        }
    }

    public void registerListener(AbsBYDAutoSafetyBeltListener absBYDAutoSafetyBeltListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(SAFETY_BELT_GET_PERM, null);
        if (absBYDAutoSafetyBeltListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSafetyBeltListener, iArr);
        }
    }
}
