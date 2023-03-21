package android.hardware.bydauto.location;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoLocationDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int LOCATION_ALTITUDE = 8;
    public static final double LOCATION_ALTITUDE_INVALID = 8001.0d;
    public static final double LOCATION_ALTITUDE_MAX = 8000.0d;
    public static final double LOCATION_ALTITUDE_MIN = -8000.0d;
    public static final int LOCATION_CHANGE = 5;
    public static final int LOCATION_COMMAND_BUSY = -2147482647;
    public static final int LOCATION_COMMAND_FAILED = -2147482648;
    public static final int LOCATION_COMMAND_INVALID_VALUE = -2147482645;
    public static final int LOCATION_COMMAND_SUCCESS = 0;
    public static final int LOCATION_COMMAND_TIMEOUT = -2147482646;
    public static final int LOCATION_FIXPOSITION = 6;
    public static final int LOCATION_FIXPOSITION_FAIL = 0;
    public static final int LOCATION_FIXPOSITION_SUCCESS = 1;
    static final String LOCATION_GET_PERM = "android.permission.BYDAUTO_LOCATION_GET";
    public static final int LOCATION_GPS_SPEED_MAX = 240;
    public static final int LOCATION_GPS_SPEED_MIN = 0;
    public static final int LOCATION_GPS_SPPED = 9;
    public static final double LOCATION_LATITUDE_MAX = 90.0d;
    public static final double LOCATION_LATITUDE_MIN = 0.0d;
    public static final int LOCATION_LATITUDE_TYPE = 1;
    public static final int LOCATION_LATITUDE_TYPE_NORTH = 2;
    public static final int LOCATION_LATITUDE_TYPE_SOUTH = 1;
    public static final int LOCATION_LATITUDE_VALUE = 2;
    public static final double LOCATION_LONGITUDE_MAX = 180.0d;
    public static final double LOCATION_LONGITUDE_MIN = 0.0d;
    public static final int LOCATION_LONGITUDE_TYPE = 3;
    public static final int LOCATION_LONGITUDE_TYPE_EAST = 1;
    public static final int LOCATION_LONGITUDE_TYPE_WEST = 2;
    public static final int LOCATION_LONGITUDE_VALUE = 4;
    public static final int LOCATION_ORIENTATION = 7;
    public static final float LOCATION_ORIENTATION_INVALID = 360.0f;
    public static final float LOCATION_ORIENTATION_MAX = 359.0f;
    public static final float LOCATION_ORIENTATION_MIN = 0.0f;
    static final String LOCATION_SET_PERM = "android.permission.BYDAUTO_LOCATION_SET";
    protected static final String TAG = "BYDAutoLocationDevice";
    public static final int VISIBLE_SATELLITE_NUMBER = 10;
    public static final int VISIBLE_SATELLITE_NUMBER_MAX = 50;
    public static final int VISIBLE_SATELLITE_NUMBER_MIN = 0;
    private static int mDeviceType = 1017;
    private static BYDAutoLocationDevice mInstance;
    private final Context mContext;

    private BYDAutoLocationDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoLocationDevice getInstance(Context context) {
        BYDAutoLocationDevice bYDAutoLocationDevice;
        synchronized (BYDAutoLocationDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoLocationDevice(context);
            }
            bYDAutoLocationDevice = mInstance;
        }
        return bYDAutoLocationDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public double[] getLocationLongitudeLatitudeValue() {
        this.mContext.enforceCallingOrSelfPermission(LOCATION_GET_PERM, null);
        double[] dArr = {super.get(mDeviceType, 3), super.getDouble(mDeviceType, 4), super.get(mDeviceType, 1), super.getDouble(mDeviceType, 2), super.getDouble(mDeviceType, 6), super.getDouble(mDeviceType, 7), super.getDouble(mDeviceType, 8)};
        Log.d(TAG, "getLocationLongitudeLatitudeValue longitude type is:" + dArr[0] + "longitude value is:" + dArr[1] + "latitude type is:" + dArr[2] + "latitude value is: " + dArr[3] + "fixposition result:" + dArr[4] + "orientation is:" + dArr[5] + "altitude is:" + dArr[6]);
        return dArr;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1017;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoLocationListener absBYDAutoLocationListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(LOCATION_GET_PERM, null);
        if (absBYDAutoLocationListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoLocationListener);
        }
    }

    public int setLocationInfo(int i, double d2, int i2, double d3, int i3, float f2, double d4, int i4, int i5) {
        Log.d(TAG, "setLocationInfo longitude type is:" + i + "longitude value is:" + d2 + "latitude type is:" + i2 + "latitude value is: " + d3 + "fixposition result is:" + i3 + "orientation is:" + f2 + "altitude is :" + d4 + "gps speed is:" + i4 + "satellites number is:" + i5);
        this.mContext.enforceCallingOrSelfPermission(LOCATION_SET_PERM, null);
        if ((i == 1 || i == 2) && d2 >= 0.0d && d2 <= 180.0d && ((i2 == 1 || i2 == 2) && d3 >= 0.0d && d3 <= 90.0d)) {
            if (i3 != 1 && i3 != 0) {
                return -2147482645;
            }
            if (f2 < 0.0f || f2 > 360.0f) {
                return -2147482645;
            }
            if (d4 < -8000.0d || d4 > 8001.0d) {
                return -2147482645;
            }
            if (i4 >= 0 && i4 <= 240) {
                if (i5 < 0 || i5 > 50) {
                    return -2147482645;
                }
                return super.set(mDeviceType, new int[]{3, 4, 1, 2, 6, 7, 8, 9, 10}, new double[]{i, d2, i2, d3, i3, f2, d4, i4, i5});
            }
            return -2147482645;
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoLocationListener absBYDAutoLocationListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(LOCATION_GET_PERM, null);
        if (absBYDAutoLocationListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoLocationListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + d2);
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }

    public void registerListener(AbsBYDAutoLocationListener absBYDAutoLocationListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(LOCATION_GET_PERM, null);
        if (absBYDAutoLocationListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoLocationListener, iArr);
        }
    }
}
