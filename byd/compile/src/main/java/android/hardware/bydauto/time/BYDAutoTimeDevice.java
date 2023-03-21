package android.hardware.bydauto.time;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoTimeDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    protected static final String TAG = "BYDAutoTIMEDevice";
    public static final int TIME_CHANGE = 11;
    public static final int TIME_COMMAND_BUSY = -2147482647;
    public static final int TIME_COMMAND_FAILED = -2147482648;
    public static final int TIME_COMMAND_INVALID_VALUE = -2147482645;
    public static final int TIME_COMMAND_SUCCESS = 0;
    public static final int TIME_COMMAND_TIMEOUT = -2147482646;
    public static final int TIME_DATE_FORMAT = 13;
    public static final int TIME_DATE_FORMAT1 = 1;
    public static final int TIME_DATE_FORMAT2 = 2;
    public static final int TIME_DATE_FORMAT3 = 3;
    public static final int TIME_DAY = 4;
    public static final int TIME_DAY_MAX = 31;
    public static final int TIME_DAY_MIN = 1;
    public static final int TIME_FORMAT_24H = 9;
    public static final int TIME_FORMAT_24H_OFF = 0;
    public static final int TIME_FORMAT_24H_ON = 1;
    static final String TIME_GET_PERM = "android.permission.BYDAUTO_TIME_GET";
    public static final int TIME_HOUR = 5;
    public static final int TIME_HOUR_MAX = 23;
    public static final int TIME_HOUR_MIN = 0;
    public static final int TIME_MINUTE = 6;
    public static final int TIME_MINUTE_MAX = 59;
    public static final int TIME_MINUTE_MIN = 0;
    public static final int TIME_MONTH = 3;
    public static final int TIME_MONTH_MAX = 12;
    public static final int TIME_MONTH_MIN = 1;
    public static final int TIME_SECOND = 7;
    public static final int TIME_SECOND_MAX = 59;
    public static final int TIME_SECOND_MIN = 0;
    public static final int TIME_SET_AUTO = 1;
    public static final int TIME_SET_MANUAL = 2;
    public static final int TIME_SET_MODE = 1;
    static final String TIME_SET_PERM = "android.permission.BYDAUTO_TIME_SET";
    public static final int TIME_SUMMERTIME_OFF = 0;
    public static final int TIME_SUMMERTIME_ON = 1;
    public static final int TIME_SUMMERTIME_STATE = 14;
    public static final int TIME_WEEKDAY = 8;
    public static final int TIME_WEEKDAY_MAX = 7;
    public static final int TIME_WEEKDAY_MIN = 1;
    public static final int TIME_YEAR = 2;
    public static final int TIME_YEAR_MAX = 2255;
    public static final int TIME_YEAR_MIN = 2001;
    public static final int TIME_ZONE = 10;
    public static final int TIME_ZONE_MAX = 23;
    public static final int TIME_ZONE_MIN = 0;
    private static int mDeviceType = 1024;
    private static BYDAutoTimeDevice mInstance;
    private final Context mContext;

    private BYDAutoTimeDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoTimeDevice getInstance(Context context) {
        BYDAutoTimeDevice bYDAutoTimeDevice;
        synchronized (BYDAutoTimeDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoTimeDevice(context);
            }
            bYDAutoTimeDevice = mInstance;
        }
        return bYDAutoTimeDevice;
    }

    public void getAllStatus() {
    }

    public int getDateFormat() {
        this.mContext.enforceCallingOrSelfPermission(TIME_GET_PERM, null);
        int i = super.get(mDeviceType, 13);
        Log.d(TAG, "getDateFormat is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getSummertimeState() {
        this.mContext.enforceCallingOrSelfPermission(TIME_GET_PERM, null);
        int i = super.get(mDeviceType, 14);
        Log.d(TAG, "getSummertimeState is: " + i);
        return i;
    }

    public int[] getTime() {
        this.mContext.enforceCallingOrSelfPermission(TIME_GET_PERM, null);
        int[] iArr = {super.get(mDeviceType, 2), super.get(mDeviceType, 3), super.get(mDeviceType, 4), super.get(mDeviceType, 5), super.get(mDeviceType, 6), super.get(mDeviceType, 7)};
        Log.d(TAG, " getTime year is:" + iArr[0] + "month is:" + iArr[1] + "day is" + iArr[2]);
        Log.d(TAG, " getTime hour is:" + iArr[3] + "minute is:" + iArr[4] + "second is" + iArr[5]);
        return iArr;
    }

    public int getTimeFormat() {
        this.mContext.enforceCallingOrSelfPermission(TIME_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, " getTimeFormat is: " + i);
        return i;
    }

    public int getTimeZone() {
        this.mContext.enforceCallingOrSelfPermission(TIME_GET_PERM, null);
        int i = super.get(mDeviceType, 10);
        Log.d(TAG, "getTimeZone is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1024;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoTimeListener absBYDAutoTimeListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(TIME_GET_PERM, null);
        if (absBYDAutoTimeListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoTimeListener);
        }
    }

    public void setAllStatus() {
    }

    public int setDate(int i, int i2, int i3, int i4) {
        Log.d(TAG, "setDate year is:" + i + "month is:" + i2 + "day is:" + i3 + "weekday is:" + i4);
        this.mContext.enforceCallingOrSelfPermission(TIME_SET_PERM, null);
        if (i < 2001 || i > 2255 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > 31 || i4 < 1 || i4 > 7) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{1, 2, 3, 4, 8}, new int[]{2, i, i2, i3, i4});
    }

    public int setFullTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Log.d(TAG, "setFullTime mode is: " + i + "year is:" + i2 + "month is:" + i3 + "day is:" + i4);
        Log.d(TAG, "setFullTime weekday is:" + i5 + "hour is:" + i6 + "minute is:" + i7 + "second is:" + i8);
        this.mContext.enforceCallingOrSelfPermission(TIME_SET_PERM, null);
        if ((i == 1 || i == 2) && i2 >= 2001 && i2 <= 2255 && i3 >= 1 && i3 <= 12 && i4 >= 1 && i4 <= 31 && i5 >= 1 && i5 <= 7 && i6 >= 0 && i6 <= 23 && i7 >= 0 && i7 <= 59 && i8 >= 0 && i8 <= 59) {
            return super.set(mDeviceType, new int[]{1, 2, 3, 4, 8, 5, 6, 7}, new int[]{i, i2, i3, i4, i5, i6, i7, i8});
        }
        return -2147482645;
    }

    public int setTime(int i, int i2, int i3) {
        Log.d(TAG, "setTime hour is:" + i + "minute is:" + i2 + "second is:" + i3);
        this.mContext.enforceCallingOrSelfPermission(TIME_SET_PERM, null);
        if (i < 0 || i > 23 || i2 < 0 || i2 > 59 || i3 < 0 || i3 > 59) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{1, 5, 6, 7}, new int[]{2, i, i2, i3});
    }

    public int setTimeFormat(int i) {
        Log.d(TAG, "setTimeFormat24H is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TIME_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, 9, i);
        }
        return -2147482645;
    }

    public int setTimeZone(int i) {
        Log.d(TAG, "setTimeZone is: " + i);
        this.mContext.enforceCallingOrSelfPermission(TIME_SET_PERM, null);
        if (i < 0 || i > 23) {
            return -2147482645;
        }
        return super.set(mDeviceType, 10, i);
    }

    public void unregisterListener(AbsBYDAutoTimeListener absBYDAutoTimeListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(TIME_GET_PERM, null);
        if (absBYDAutoTimeListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoTimeListener);
        }
    }

    public void registerListener(AbsBYDAutoTimeListener absBYDAutoTimeListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(TIME_GET_PERM, null);
        if (absBYDAutoTimeListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoTimeListener, iArr);
        }
    }
}
