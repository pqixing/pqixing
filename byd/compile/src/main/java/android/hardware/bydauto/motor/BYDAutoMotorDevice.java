package android.hardware.bydauto.motor;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoMotorDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int MOTOR_ANGLE = 3;
    public static final double MOTOR_ANGLE_MAX = 359.9d;
    public static final double MOTOR_ANGLE_MIN = 0.0d;
    public static final int MOTOR_ANGLE_VALUE = 0;
    public static final int MOTOR_COMMAND_BUSY = -2147482647;
    public static final int MOTOR_COMMAND_FAILED = -2147482648;
    public static final int MOTOR_COMMAND_INVALID = -2147482645;
    public static final int MOTOR_COMMAND_SUCCESS = 0;
    public static final int MOTOR_COMMAND_TIMEOUT = -2147482646;
    static final String MOTOR_GET_PERM = "android.permission.BYDAUTO_MOTOR_GET";
    public static final int MOTOR_LOCK = 2;
    public static final int MOTOR_OFF = 0;
    public static final int MOTOR_ON = 1;
    public static final int MOTOR_POS = 4;
    public static final int MOTOR_POS_MAX = 500;
    public static final int MOTOR_POS_MIN = -500;
    public static final int MOTOR_POWER_STATE = 1;
    static final String MOTOR_SET_PERM = "android.permission.BYDAUTO_MOTOR_SET";
    public static final int MOTOR_SPEED = 6;
    public static final int MOTOR_SPEED_VALUE = 0;
    public static final int MOTOR_STATE = 5;
    public static final int MOTOR_STATE_ANTICLOCKWISE = 8;
    public static final int MOTOR_STATE_BACKWARD = 6;
    public static final int MOTOR_STATE_CLOCKWISE = 7;
    public static final int MOTOR_STATE_DOWNWARD = 2;
    public static final int MOTOR_STATE_FORWARD = 5;
    public static final int MOTOR_STATE_LEFT = 3;
    public static final int MOTOR_STATE_RIGHT = 4;
    public static final int MOTOR_STATE_STOP = 0;
    public static final int MOTOR_STATE_UPWARD = 1;
    protected static final String TAG = "BYDAutoMotorDevice";
    private static int mDeviceType = 1020;
    private static BYDAutoMotorDevice mInstance;
    private final Context mContext;

    private BYDAutoMotorDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoMotorDevice getInstance(Context context) {
        BYDAutoMotorDevice bYDAutoMotorDevice;
        synchronized (BYDAutoMotorDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoMotorDevice(context);
            }
            bYDAutoMotorDevice = mInstance;
        }
        return bYDAutoMotorDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getMotorAngle() {
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getMotorAngle angle is: " + i);
        return i;
    }

    public int getMotorDirection() {
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        int i = super.get(mDeviceType, 5);
        Log.d(TAG, "getMotorDirection state is: " + i);
        return i;
    }

    public int getMotorLock() {
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getMotorLock state is: " + i);
        return i;
    }

    public int getMotorPosition() {
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        int i = super.get(mDeviceType, 4);
        Log.d(TAG, "getMotorPosition position is: " + i);
        return i;
    }

    public int getMotorPower() {
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getMotorPower state is: " + i);
        return i;
    }

    public int getMotorSpeed() {
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        int i = super.get(mDeviceType, 6);
        Log.d(TAG, "getMotorSpeed speed is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1020;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoMotorListener absBYDAutoMotorListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        if (absBYDAutoMotorListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoMotorListener);
        }
    }

    public void setAllStatus() {
    }

    public int setMotorDirection(int i) {
        Log.d(TAG, "setMotorDirection state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(MOTOR_SET_PERM, null);
        if (i < 0 || i > 8) {
            return -2147482645;
        }
        return super.set(mDeviceType, 5, i);
    }

    public int setMotorLock(int i) {
        Log.d(TAG, "setMotorLock state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(MOTOR_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 2, i);
        }
        return -2147482645;
    }

    public int setMotorPower(int i) {
        Log.d(TAG, "setMotorPower state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(MOTOR_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 1, i);
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoMotorListener absBYDAutoMotorListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        if (absBYDAutoMotorListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoMotorListener);
        }
    }

    public void registerListener(AbsBYDAutoMotorListener absBYDAutoMotorListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(MOTOR_GET_PERM, null);
        if (absBYDAutoMotorListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoMotorListener, iArr);
        }
    }
}
