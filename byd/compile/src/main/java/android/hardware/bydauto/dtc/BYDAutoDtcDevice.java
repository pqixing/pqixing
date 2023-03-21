package android.hardware.bydauto.dtc;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoDtcDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int DTC_COMMAND_BUSY = -2147482647;
    public static final int DTC_COMMAND_FAILED = -2147482648;
    public static final int DTC_COMMAND_INVALID_VALUE = -2147482645;
    public static final int DTC_COMMAND_SUCCESS = 0;
    public static final int DTC_COMMAND_TIMEOUT = -2147482646;
    private static final String DTC_GET_PERM = "android.permission.BYDAUTO_DTC_GET";
    public static final int DTC_SET_FAULT_CODE = 1;
    private static final String DTC_SET_PERM = "android.permission.BYDAUTO_DTC_SET";
    protected static final String TAG = "BYDAutoDtcDevice";
    private static int mDeviceType = 1045;
    private static BYDAutoDtcDevice mInstance;
    private final Context mContext;

    private BYDAutoDtcDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoDtcDevice getInstance(Context context) {
        BYDAutoDtcDevice bYDAutoDtcDevice;
        synchronized (BYDAutoDtcDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoDtcDevice(context);
            }
            bYDAutoDtcDevice = mInstance;
        }
        return bYDAutoDtcDevice;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_DTC;
    }

    public int sendFaultCodeData(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(DTC_SET_PERM, null);
        if (bArr == null || bArr.length < 1) {
            return -2147482645;
        }
        Log.d(TAG, "sendFaultCodeData");
        return super.set(mDeviceType, 1, bArr);
    }
}
