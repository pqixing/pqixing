package android.hardware.bydauto.doorlock;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoDoorLockDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int DOOR_LOCK_AREA_BACK = 5;
    public static final int DOOR_LOCK_AREA_CHILDLOCK_LEFT = 6;
    public static final int DOOR_LOCK_AREA_CHILDLOCK_RIGHT = 7;
    public static final int DOOR_LOCK_AREA_LEFT_FRONT = 1;
    public static final int DOOR_LOCK_AREA_LEFT_REAR = 2;
    public static final int DOOR_LOCK_AREA_RIGHT_FRONT = 3;
    public static final int DOOR_LOCK_AREA_RIGHT_REAR = 4;
    public static final int DOOR_LOCK_COMMAND_AREA_BACK = 5;
    public static final int DOOR_LOCK_COMMAND_AREA_CHILDLOCK_LEFT = 6;
    public static final int DOOR_LOCK_COMMAND_AREA_CHILDLOCK_RIGHT = 7;
    public static final int DOOR_LOCK_COMMAND_AREA_LEFT_FRONT = 1;
    public static final int DOOR_LOCK_COMMAND_AREA_LEFT_REAR = 2;
    public static final int DOOR_LOCK_COMMAND_AREA_RIGHT_FRONT = 3;
    public static final int DOOR_LOCK_COMMAND_AREA_RIGHT_REAR = 4;
    public static final int DOOR_LOCK_COMMAND_BUSY = -2147482647;
    public static final int DOOR_LOCK_COMMAND_FAILED = -2147482648;
    public static final int DOOR_LOCK_COMMAND_INVALID_VALUE = -2147482645;
    public static final int DOOR_LOCK_COMMAND_SUCCESS = 0;
    public static final int DOOR_LOCK_COMMAND_TIMEOUT = -2147482646;
    private static final String DOOR_LOCK_COMMON_PERM = "android.permission.BYDAUTO_DOOR_LOCK_COMMON";
    static final String DOOR_LOCK_GET_PERM = "android.permission.BYDAUTO_DOOR_LOCK_GET";
    static final String DOOR_LOCK_SET_PERM = "android.permission.BYDAUTO_DOOR_LOCK_SET";
    public static final int DOOR_LOCK_STATE_INVALID = 0;
    public static final int DOOR_LOCK_STATE_LOCK = 2;
    public static final int DOOR_LOCK_STATE_UNLOCK = 1;
    protected static final String TAG = "BYDAutoDoorLockDevice";
    private static int mDeviceType = 1041;
    private static BYDAutoDoorLockDevice mInstance;
    private final Context mContext;

    private BYDAutoDoorLockDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoDoorLockDevice getInstance(Context context) {
        BYDAutoDoorLockDevice bYDAutoDoorLockDevice;
        synchronized (BYDAutoDoorLockDevice.class) {
            if (mInstance == null) {
                context.enforceCallingOrSelfPermission(DOOR_LOCK_COMMON_PERM, null);
                mInstance = new BYDAutoDoorLockDevice(context);
            }
            bYDAutoDoorLockDevice = mInstance;
        }
        return bYDAutoDoorLockDevice;
    }

    public int getDoorLockStatus(int i) {
        int i2;
        Log.d(TAG, "getDoorLockStatus area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(DOOR_LOCK_GET_PERM, null);
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            case 5:
                i2 = 5;
                break;
            case 6:
                i2 = 6;
                break;
            case 7:
                i2 = 7;
                break;
            default:
                return -2147482645;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getDoorLockStatus state is: " + i3);
        return i3;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_DOOR_LOCK;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoDoorLockListener absBYDAutoDoorLockListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(DOOR_LOCK_GET_PERM, null);
        if (absBYDAutoDoorLockListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoDoorLockListener);
        }
    }

    public void unregisterListener(AbsBYDAutoDoorLockListener absBYDAutoDoorLockListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(DOOR_LOCK_GET_PERM, null);
        if (absBYDAutoDoorLockListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoDoorLockListener);
        }
    }

    public void registerListener(AbsBYDAutoDoorLockListener absBYDAutoDoorLockListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(DOOR_LOCK_GET_PERM, null);
        if (absBYDAutoDoorLockListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoDoorLockListener, iArr);
        }
    }
}
