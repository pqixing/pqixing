package android.hardware.bydauto.sensor;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoSensorDevice extends AbsBYDAutoDevice {
    public static final int AUTO_SLOPE_MAX = 60;
    public static final int AUTO_SLOPE_MIN = -60;
    private static final boolean DEBUG = true;
    public static final int G_SENSOR_OR_ANGLE = 4;
    public static final int G_SENSOR_OR_ANGLE_MAX = 359;
    public static final int G_SENSOR_OR_ANGLE_MIN = 0;
    public static final double HUMIDITY_MAX = 100.0d;
    public static final double HUMIDITY_MIN = 0.0d;
    public static final int LIGHT_INTENSITY_LEVEL1 = 1;
    public static final int LIGHT_INTENSITY_LEVEL2 = 2;
    public static final int LIGHT_INTENSITY_LEVEL3 = 3;
    public static final int LIGHT_INTENSITY_LEVEL4 = 4;
    public static final int LIGHT_INTENSITY_LEVEL5 = 5;
    public static final int SENSOR_AUTO_SLOPE = 5;
    public static final int SENSOR_COMMAND_BUSY = -2147482647;
    public static final int SENSOR_COMMAND_FAILED = -2147482648;
    public static final int SENSOR_COMMAND_INVALID_VALUE = -2147482645;
    public static final int SENSOR_COMMAND_SUCCESS = 0;
    public static final int SENSOR_COMMAND_TIMEOUT = -2147482646;
    static final String SENSOR_GET_PERM = "android.permission.BYDAUTO_SENSOR_GET";
    public static final int SENSOR_HUMIDITY = 2;
    public static final int SENSOR_LIGHT = 3;
    static final String SENSOR_SET_PERM = "android.permission.BYDAUTO_SENSOR_SET";
    public static final int SENSOR_TEMPERATURE = 1;
    protected static final String TAG = "BYDAutoSensorDevice";
    public static final double TEMPERATURE_MAX = 125.0d;
    public static final double TEMPERATURE_MIN = -40.0d;
    private static int mDeviceType = 1043;
    private static BYDAutoSensorDevice mInstance;
    private final Context mContext;

    private BYDAutoSensorDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoSensorDevice getInstance(Context context) {
        BYDAutoSensorDevice bYDAutoSensorDevice;
        synchronized (BYDAutoSensorDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoSensorDevice(context);
            }
            bYDAutoSensorDevice = mInstance;
        }
        return bYDAutoSensorDevice;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public double getHumiditySensorValue() {
        this.mContext.enforceCallingOrSelfPermission(SENSOR_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 2);
        Log.d(TAG, "getHumiditySensorValue: humidity is " + d2);
        return d2;
    }

    public int getLightIntensity() {
        this.mContext.enforceCallingOrSelfPermission(SENSOR_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getLightIntensity: light intensity is " + i);
        return i;
    }

    public int getSlope() {
        this.mContext.enforceCallingOrSelfPermission(SENSOR_GET_PERM, null);
        int i = super.get(mDeviceType, 5);
        Log.d(TAG, "getSlope: auto obliquity is " + i);
        return i;
    }

    public double getTemperatureSensorValue() {
        this.mContext.enforceCallingOrSelfPermission(SENSOR_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 1);
        Log.d(TAG, "getTemperatureSensorValue: temperature is " + d2);
        return d2;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_SENSOR;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoSensorListener absBYDAutoSensorListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(SENSOR_GET_PERM, null);
        if (absBYDAutoSensorListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSensorListener);
        }
    }

    public int setOrientationAngle(int i) {
        this.mContext.enforceCallingOrSelfPermission(SENSOR_SET_PERM, null);
        if (i < 0 || i > 359) {
            return -2147482645;
        }
        return super.set(mDeviceType, 4, i);
    }

    public void unregisterListener(AbsBYDAutoSensorListener absBYDAutoSensorListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(SENSOR_GET_PERM, null);
        if (absBYDAutoSensorListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoSensorListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + d2);
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }

    public void registerListener(AbsBYDAutoSensorListener absBYDAutoSensorListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(SENSOR_GET_PERM, null);
        if (absBYDAutoSensorListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSensorListener, iArr);
        }
    }
}
