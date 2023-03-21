package android.hardware.bydauto.tyre;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoTyreDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int DEVICE_HAS_THE_FEATURE = 1;
    public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
    public static final String FEATURE_INDIRECT_TYRE_PRESSURE_ONLINE = "IndirectTyrePressureMonitor";
    public static final String FEATURE_TYRE_PRESSURE_ONLINE = "TyrePressureMonitor";
    public static final int HAS_INDIRECT_TYRE_PRESSURE_ONLINE = 25;
    public static final int HAS_TYRE_PRESSURE_ONLINE = 24;
    public static final int INDIRECT_TYRE_PRESSURE_CONFIRM = 1;
    public static final int INDIRECT_TYRE_SYSTEM_CONFIRM = 27;
    public static final int INDITECT_TYRE_SYSTEM_RESETTING = 1;
    public static final int INDITECT_TYRE_SYSTEM_RESET_FAILED = 3;
    public static final int INDITECT_TYRE_SYSTEM_RESET_SUCCESS = 2;
    public static final int INDITECT_TYRE_SYSTEM_STATE = 26;
    protected static final String TAG = "BYDAutoTyreDevice";
    public static final int TYRE_AIR_LEAK_STATE_LEFT_FRONT = 1;
    public static final int TYRE_AIR_LEAK_STATE_LEFT_REAR = 11;
    public static final int TYRE_AIR_LEAK_STATE_NORMAL = 0;
    public static final int TYRE_AIR_LEAK_STATE_QUICK = 1;
    public static final int TYRE_AIR_LEAK_STATE_RIGHT_FRONT = 6;
    public static final int TYRE_AIR_LEAK_STATE_RIGHT_REAR = 16;
    public static final int TYRE_AIR_LEAK_STATE_SLOW = 2;
    public static final int TYRE_BATTERY_STATE = 23;
    public static final int TYRE_BATTERY_STATE_LOW = 1;
    public static final int TYRE_BATTERY_STATE_NORMAL = 0;
    public static final int TYRE_BATTERY_VALUE_LEFT_FRONT = 2;
    public static final int TYRE_BATTERY_VALUE_LEFT_REAR = 12;
    public static final int TYRE_BATTERY_VALUE_RIGHT_FRONT = 7;
    public static final int TYRE_BATTERY_VALUE_RIGHT_REAR = 17;
    public static final double TYRE_BATTERY_VOLTAGE_MAX = 40.0d;
    public static final double TYRE_BATTERY_VOLTAGE_MIN = 0.0d;
    public static final int TYRE_COMMAND_AREA_LEFT_FRONT = 1;
    public static final int TYRE_COMMAND_AREA_LEFT_REAR = 3;
    public static final int TYRE_COMMAND_AREA_RIGHT_FRONT = 2;
    public static final int TYRE_COMMAND_AREA_RIGHT_REAR = 4;
    public static final int TYRE_COMMAND_BUSY = -2147482647;
    public static final int TYRE_COMMAND_FAILED = -2147482648;
    public static final int TYRE_COMMAND_INVALID_VALUE = -2147482645;
    public static final int TYRE_COMMAND_SUCCESS = 0;
    public static final int TYRE_COMMAND_TIMEOUT = -2147482646;
    static final String TYRE_GET_PERM = "android.permission.BYDAUTO_TYRE_GET";
    public static final int TYRE_PRESSURE_STATE_LEFT_FRONT = 4;
    public static final int TYRE_PRESSURE_STATE_LEFT_REAR = 14;
    public static final int TYRE_PRESSURE_STATE_NORMAL = 0;
    public static final int TYRE_PRESSURE_STATE_OVERPRESSURE = 1;
    public static final int TYRE_PRESSURE_STATE_RIGHT_FRONT = 9;
    public static final int TYRE_PRESSURE_STATE_RIGHT_REAR = 19;
    public static final int TYRE_PRESSURE_STATE_UNDERPRESSURE = 2;
    public static final int TYRE_PRESSURE_VALUE_LEFT_FRONT = 3;
    public static final int TYRE_PRESSURE_VALUE_LEFT_REAR = 13;
    public static final int TYRE_PRESSURE_VALUE_MAX = 4094;
    public static final int TYRE_PRESSURE_VALUE_MIN = 0;
    public static final int TYRE_PRESSURE_VALUE_RIGHT_FRONT = 8;
    public static final int TYRE_PRESSURE_VALUE_RIGHT_REAR = 18;
    static final String TYRE_SET_PERM = "android.permission.BYDAUTO_TYRE_SET";
    public static final int TYRE_SIGNAL_STATE_ERROR = 1;
    public static final int TYRE_SIGNAL_STATE_LEFT_FRONT = 5;
    public static final int TYRE_SIGNAL_STATE_LEFT_REAR = 15;
    public static final int TYRE_SIGNAL_STATE_NORMAL = 0;
    public static final int TYRE_SIGNAL_STATE_RIGHT_FRONT = 10;
    public static final int TYRE_SIGNAL_STATE_RIGHT_REAR = 20;
    public static final int TYRE_SYSTEM_STATE = 21;
    public static final int TYRE_SYSTEM_STATE_BREAKDOWN = 3;
    public static final int TYRE_SYSTEM_STATE_MASKED = 4;
    public static final int TYRE_SYSTEM_STATE_NORMAL = 0;
    public static final int TYRE_SYSTEM_STATE_SELF_CHECKING = 1;
    public static final int TYRE_SYSTEM_STATE_SIGNAL_ANOMAL = 2;
    public static final double TYRE_TEMPERATURE_MAX = 369.4d;
    public static final double TYRE_TEMPERATURE_MIN = -40.0d;
    public static final int TYRE_TEMPERATURE_STATE = 22;
    public static final int TYRE_TEMPERATURE_STATE_HIGH = 2;
    public static final int TYRE_TEMPERATURE_STATE_NORMAL = 0;
    public static final int TYRE_TEMPERATURE_STATE_SLEEP = 3;
    public static final int TYRE_TEMPERATURE_STATE_SUPER_HIGH = 1;
    private static int mDeviceType = 1016;
    private static BYDAutoTyreDevice mInstance;
    private final Context mContext;

    private BYDAutoTyreDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoTyreDevice getInstance(Context context) {
        BYDAutoTyreDevice bYDAutoTyreDevice;
        synchronized (BYDAutoTyreDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoTyreDevice(context);
            }
            bYDAutoTyreDevice = mInstance;
        }
        return bYDAutoTyreDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getIndirectTyreSystemState() {
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        int i = super.get(mDeviceType, 26);
        Log.d(TAG, "getIndirectTyreSystemState state is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1016;
    }

    public int getTyreAirLeakState(int i) {
        int i2;
        Log.d(TAG, "getTyreAirLeakState area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (i == 1) {
            i2 = super.get(mDeviceType, 1);
        } else if (i == 2) {
            i2 = super.get(mDeviceType, 6);
        } else if (i == 3) {
            i2 = super.get(mDeviceType, 11);
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = super.get(mDeviceType, 16);
        }
        Log.d(TAG, "getTyreAirLeakState state is: " + i2);
        return i2;
    }

    public int getTyreBatteryState() {
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        int i = super.get(mDeviceType, 23);
        Log.d(TAG, "getTyreBatteryState state is: " + i);
        return i;
    }

    public double getTyreBatteryValue(int i) {
        double d2;
        Log.d(TAG, "getTyreBatteryValue area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (i == 1) {
            d2 = super.getDouble(mDeviceType, 2);
        } else if (i == 2) {
            d2 = super.getDouble(mDeviceType, 7);
        } else if (i == 3) {
            d2 = super.getDouble(mDeviceType, 12);
        } else if (i != 4) {
            return -2.147482645E9d;
        } else {
            d2 = super.getDouble(mDeviceType, 17);
        }
        Log.d(TAG, "getTyreBatteryValue value is: " + d2);
        if (d2 < 0.0d || d2 > 40.0d) {
            Log.w(TAG, "The battery voltage value is invalid!");
            return -2.147482645E9d;
        }
        return d2;
    }

    public int getTyrePressureState(int i) {
        int i2;
        Log.d(TAG, "getTyrePressureState area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (i == 1) {
            i2 = super.get(mDeviceType, 4);
        } else if (i == 2) {
            i2 = super.get(mDeviceType, 9);
        } else if (i == 3) {
            i2 = super.get(mDeviceType, 14);
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = super.get(mDeviceType, 19);
        }
        Log.d(TAG, "getTyrePressureState state is: " + i2);
        return i2;
    }

    public int getTyrePressureValue(int i) {
        int i2;
        Log.d(TAG, "getTyrePressureValue area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (i == 1) {
            i2 = super.get(mDeviceType, 3);
        } else if (i == 2) {
            i2 = super.get(mDeviceType, 8);
        } else if (i == 3) {
            i2 = super.get(mDeviceType, 13);
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = super.get(mDeviceType, 18);
        }
        Log.d(TAG, "getTyrePressureValue value is: " + i2);
        if (i2 < 0 || i2 > 4094) {
            Log.w(TAG, "The pressure value is invalid!");
            return -2147482645;
        }
        return i2;
    }

    public int getTyreSignalState(int i) {
        int i2;
        Log.d(TAG, "getTyreSignalState area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (i == 1) {
            i2 = super.get(mDeviceType, 5);
        } else if (i == 2) {
            i2 = super.get(mDeviceType, 10);
        } else if (i == 3) {
            i2 = super.get(mDeviceType, 15);
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = super.get(mDeviceType, 20);
        }
        Log.d(TAG, "getTyreSignalState state is: " + i2);
        return i2;
    }

    public int getTyreSystemState() {
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        int i = super.get(mDeviceType, 21);
        Log.d(TAG, "getTyreSystemState state is: " + i);
        return i;
    }

    public int getTyreTemperatureState() {
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        int i = super.get(mDeviceType, 22);
        Log.d(TAG, "getTyreTemperatureState state is: " + i);
        return i;
    }

    public int hasFeature(String str) {
        int i;
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (str.equals(FEATURE_TYRE_PRESSURE_ONLINE)) {
            i = 24;
        } else if (!str.equals(FEATURE_INDIRECT_TYRE_PRESSURE_ONLINE)) {
            return -2147482645;
        } else {
            i = 25;
        }
        int i2 = super.get(mDeviceType, i);
        Log.d(TAG, "hasFeature: If has the feature(" + str + "): " + i2);
        return i2;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoTyreListener absBYDAutoTyreListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (absBYDAutoTyreListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoTyreListener);
        }
    }

    public int setIndirectTyreConfirm(int i) {
        Log.d(TAG, "setIndirectTyreConfirm value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TYRE_SET_PERM, null);
        if (i != 1) {
            return -2147482645;
        }
        return super.set(mDeviceType, 27, i);
    }

    public void unregisterListener(AbsBYDAutoTyreListener absBYDAutoTyreListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (absBYDAutoTyreListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoTyreListener);
        }
    }

    public void registerListener(AbsBYDAutoTyreListener absBYDAutoTyreListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(TYRE_GET_PERM, null);
        if (absBYDAutoTyreListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoTyreListener, iArr);
        }
    }
}
