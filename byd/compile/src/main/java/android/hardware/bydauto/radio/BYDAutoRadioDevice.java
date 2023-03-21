package android.hardware.bydauto.radio;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoRadioDevice extends AbsBYDAutoDevice {
    public static final int AM_STEP_10KHZ = 10;
    public static final int AM_STEP_9KHZ = 9;
    private static final boolean DEBUG = true;
    public static final int FM_STEP_100KHZ = 100;
    public static final int FM_STEP_50KHZ = 50;
    public static final int RADIO_AM_INIT_ENDFREQ = 5;
    public static final int RADIO_AM_INIT_STARTFREQ = 4;
    public static final int RADIO_AM_INIT_STEP = 6;
    public static final int RADIO_BAND_AM = 2;
    public static final int RADIO_BAND_FM = 1;
    public static final int RADIO_COMMAND_BUSY = -2147482647;
    public static final int RADIO_COMMAND_FAILED = -2147482648;
    public static final int RADIO_COMMAND_INVALID_VALUE = -2147482645;
    public static final int RADIO_COMMAND_SUCCESS = 0;
    public static final int RADIO_COMMAND_TIMEOUT = -2147482646;
    public static final int RADIO_CURRENT_FREQ = 8;
    public static final int RADIO_CURRENT_STATUS = 7;
    public static final int RADIO_FM_INIT_ENDFREQ = 2;
    public static final int RADIO_FM_INIT_STARTFREQ = 1;
    public static final int RADIO_FM_INIT_STEP = 3;
    static final String RADIO_GET_PERM = "android.permission.BYDAUTO_RADIO_GET";
    public static final int RADIO_NEXT_STATUS = 12;
    public static final int RADIO_PLAY_BAND = 14;
    public static final int RADIO_PLAY_FREQ = 15;
    public static final int RADIO_POWER = 20;
    public static final int RADIO_PREV_STATUS = 13;
    public static final int RADIO_SEARCH_BAND = 9;
    public static final int RADIO_SEARCH_FREQ = 10;
    public static final int RADIO_SEARCH_NEXT = 17;
    public static final int RADIO_SEARCH_PREV = 18;
    public static final int RADIO_SEARCH_RESULT = 21;
    public static final int RADIO_SEARCH_START = 16;
    public static final int RADIO_SEARCH_STATUS = 11;
    public static final int RADIO_SEARCH_STOP = 19;
    static final String RADIO_SET_PERM = "android.permission.BYDAUTO_RADIO_SET";
    public static final int RADIO_STATE_OFF = 0;
    public static final int RADIO_STATE_PLAY = 1;
    public static final int RADIO_STATE_SEARCH_ALL = 3;
    public static final int RADIO_STATE_SEARCH_NEXT_PREV = 2;
    public static final int SEARCH_FREQUENCY_EFFECTIVE = 1;
    public static final int SEARCH_FREQUENCY_INVALID = 0;
    public static final int SEARCH_PROCESS_STATE_FINISH = 0;
    public static final int SEARCH_PROCESS_STATE_UNFINISH = 1;
    protected static final String TAG = "BYDAutoRADIODevice";
    public static final int TURN_OFF_RADIO = 0;
    public static final int TURN_ON_RADIO = 1;
    private static int mDeviceType = 1021;
    private static BYDAutoRadioDevice mInstance;
    private final Context mContext;

    private BYDAutoRadioDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoRadioDevice getInstance(Context context) {
        BYDAutoRadioDevice bYDAutoRadioDevice;
        synchronized (BYDAutoRadioDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoRadioDevice(context);
            }
            bYDAutoRadioDevice = mInstance;
        }
        return bYDAutoRadioDevice;
    }

    public int autoSearch() {
        this.mContext.enforceCallingOrSelfPermission(RADIO_SET_PERM, null);
        Log.d(TAG, "autoSearch");
        return super.set(mDeviceType, 16, 1);
    }

    public int cancelAutoSearch() {
        this.mContext.enforceCallingOrSelfPermission(RADIO_SET_PERM, null);
        Log.d(TAG, "cancelAutoSearch");
        return super.set(mDeviceType, 19, 1);
    }

    public int getCurFreq() {
        this.mContext.enforceCallingOrSelfPermission(RADIO_GET_PERM, null);
        int i = super.get(mDeviceType, 8);
        Log.d(TAG, "getCurFreq: frequency is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getRadioBand() {
        this.mContext.enforceCallingOrSelfPermission(RADIO_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getRadioBand:  band is " + i);
        return i;
    }

    public int[] getRadioParam(int i) {
        int i2;
        int i3;
        int i4;
        this.mContext.enforceCallingOrSelfPermission(RADIO_GET_PERM, null);
        Log.d(TAG, "getRadioParam: band = " + i);
        if (i == 1 || i == 2) {
            if (i == 1) {
                i4 = 3;
                i3 = 2;
                i2 = 1;
            } else {
                i2 = 4;
                i3 = 5;
                i4 = 6;
            }
            int[] intArray = super.getIntArray(mDeviceType, new int[]{i2, i3, i4});
            return intArray.length < 2 ? new int[]{intArray[0], intArray[0], intArray[0]} : intArray;
        }
        return new int[]{-2147482645, -2147482645, -2147482645};
    }

    public int getRadioState() {
        this.mContext.enforceCallingOrSelfPermission(RADIO_GET_PERM, null);
        int i = super.get(mDeviceType, 7);
        Log.d(TAG, "getRadioState: state is " + i);
        return i;
    }

    public int getSearchProcessState() {
        this.mContext.enforceCallingOrSelfPermission(RADIO_GET_PERM, null);
        int i = super.get(mDeviceType, 11);
        Log.d(TAG, "getSearchProcessState: state is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1021;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public int radioOff() {
        this.mContext.enforceCallingOrSelfPermission(RADIO_SET_PERM, null);
        Log.d(TAG, "radioOff");
        return super.set(mDeviceType, 20, 0);
    }

    public int radioOn() {
        this.mContext.enforceCallingOrSelfPermission(RADIO_SET_PERM, null);
        Log.d(TAG, "radioOn");
        return super.set(mDeviceType, 20, 1);
    }

    public void registerListener(AbsBYDAutoRadioListener absBYDAutoRadioListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(RADIO_GET_PERM, null);
        if (absBYDAutoRadioListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoRadioListener);
        }
    }

    public int seek(boolean z) {
        this.mContext.enforceCallingOrSelfPermission(RADIO_SET_PERM, null);
        Log.d(TAG, "seek: next is " + z);
        return super.set(mDeviceType, z ? 17 : 18, 1);
    }

    public int setCurFreq(int i, int i2) {
        this.mContext.enforceCallingOrSelfPermission(RADIO_SET_PERM, null);
        Log.d(TAG, "setCurFreq band is: " + i + "frequency is:" + i2 + "khz");
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, new int[]{14, 15}, new int[]{i, i2});
        }
        return -2147482645;
    }

    public int setRadioParam(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        this.mContext.enforceCallingOrSelfPermission(RADIO_SET_PERM, null);
        Log.d(TAG, "setRadioParam: band = " + i + ", start = " + i2 + ", end = " + i3 + ", step = " + i4);
        if (i == 1 || i == 2) {
            if (i4 != 50 && i4 != 100 && i4 != 9 && i4 != 10) {
                return -2147482645;
            }
            if (i == 1) {
                i6 = 2;
                i5 = 1;
                i7 = 3;
            } else {
                i5 = 4;
                i6 = 5;
                i7 = 6;
            }
            return super.set(mDeviceType, new int[]{i5, i6, i7}, new int[]{i2, i3, i4});
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoRadioListener absBYDAutoRadioListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(RADIO_GET_PERM, null);
        if (absBYDAutoRadioListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoRadioListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + Arrays.toString(bArr));
        return onPostEvent(new BYDAutoRadioEvent(i, i2, bArr, obj));
    }

    public void registerListener(AbsBYDAutoRadioListener absBYDAutoRadioListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(RADIO_GET_PERM, null);
        if (absBYDAutoRadioListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoRadioListener, iArr);
        }
    }
}
