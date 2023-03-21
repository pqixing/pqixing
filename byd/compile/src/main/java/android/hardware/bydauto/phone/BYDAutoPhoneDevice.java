package android.hardware.bydauto.phone;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import com.byd.autovoice_common.utils.excel.CollectExcelUtils;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class BYDAutoPhoneDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int PHONE_COMMAND_BUSY = -2147482647;
    public static final int PHONE_COMMAND_FAILED = -2147482648;
    public static final int PHONE_COMMAND_INVALID = -2147482645;
    public static final int PHONE_COMMAND_SUCCESS = 0;
    public static final int PHONE_COMMAND_TIMEOUT = -2147482646;
    public static final int PHONE_EVENT = 2;
    public static final int PHONE_EVENT_ANSWER = 1;
    public static final int PHONE_EVENT_HANGUP = 3;
    public static final int PHONE_EVENT_REJECT = 2;
    static final String PHONE_GET_PERM = "android.permission.BYDAUTO_PHONE_GET";
    public static final int PHONE_INFO_CALLING = 2;
    public static final int PHONE_INFO_DAIL = 1;
    public static final int PHONE_INFO_HANGUP = 4;
    public static final int PHONE_INFO_ONLINE = 3;
    public static final int PHONE_INFO_ST = 3;
    public static final int PHONE_MUTE = 1;
    public static final int PHONE_MUTE_OFF = 1;
    public static final int PHONE_MUTE_ON = 0;
    public static final int PHONE_NAME = 5;
    public static final int PHONE_NAME_LEN_MAX = 160;
    public static final int PHONE_NAME_LEN_MIN = 1;
    public static final int PHONE_NUMBER = 4;
    public static final int PHONE_NUMBER_LEN_MAX = 20;
    public static final int PHONE_NUMBER_LEN_MIN = 1;
    static final String PHONE_SET_PERM = "android.permission.BYDAUTO_PHONE_SET";
    protected static final String TAG = "BYDAutoPhoneDevice";
    private static int mDeviceType = 1029;
    private static BYDAutoPhoneDevice mInstance;
    private final Context mContext;
    private int mPhoneInfoState;

    private BYDAutoPhoneDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoPhoneDevice getInstance(Context context) {
        BYDAutoPhoneDevice bYDAutoPhoneDevice;
        synchronized (BYDAutoPhoneDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoPhoneDevice(context);
            }
            bYDAutoPhoneDevice = mInstance;
        }
        return bYDAutoPhoneDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getPhoneEvent() {
        this.mContext.enforceCallingOrSelfPermission(PHONE_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getPhoneEvent value is: " + i);
        return i;
    }

    public int getPhoneMute() {
        this.mContext.enforceCallingOrSelfPermission(PHONE_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getPhoneMute value is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_PHONE;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoPhoneListener absBYDAutoPhoneListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(PHONE_GET_PERM, null);
        if (absBYDAutoPhoneListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoPhoneListener);
        }
    }

    public void setAllStatus() {
    }

    public int setPhoneInfoState(int i) {
        Log.d(TAG, "setPhoneInfoState value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(PHONE_SET_PERM, null);
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            this.mPhoneInfoState = i;
            return super.set(mDeviceType, 3, i);
        }
        return -2147482645;
    }

    public int setPhoneMute(int i) {
        Log.d(TAG, "setPhoneMute value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(PHONE_SET_PERM, null);
        if (i == 0 || i == 1) {
            super.set(mDeviceType, 1, i);
            return super.set(mDeviceType, 3, this.mPhoneInfoState);
        }
        return -2147482645;
    }

    public int[] setPhoneNameNumber(String str, String str2) {
        byte[] bArr;
        Log.d(TAG, "setPhoneNameNumber name is: " + str + "number is:" + str2);
        byte[] bArr2 = null;
        this.mContext.enforceCallingOrSelfPermission(PHONE_SET_PERM, null);
        int length = str.length();
        int length2 = str2.length();
        int[] iArr = new int[2];
        if (length < 1 || length > 160 || length2 < 1 || length2 > 20) {
            iArr[0] = -2147482645;
            return iArr;
        }
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            bArr = null;
        }
        try {
            bArr2 = str2.getBytes(CollectExcelUtils.GBK_ENCODING);
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            e.printStackTrace();
            iArr[0] = super.set(mDeviceType, 5, bArr);
            iArr[1] = super.set(mDeviceType, 4, bArr2);
            return iArr;
        }
        iArr[0] = super.set(mDeviceType, 5, bArr);
        iArr[1] = super.set(mDeviceType, 4, bArr2);
        return iArr;
    }

    public void unregisterListener(AbsBYDAutoPhoneListener absBYDAutoPhoneListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(PHONE_GET_PERM, null);
        if (absBYDAutoPhoneListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoPhoneListener);
        }
    }

    public void registerListener(AbsBYDAutoPhoneListener absBYDAutoPhoneListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(PHONE_GET_PERM, null);
        if (absBYDAutoPhoneListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoPhoneListener, iArr);
        }
    }
}
