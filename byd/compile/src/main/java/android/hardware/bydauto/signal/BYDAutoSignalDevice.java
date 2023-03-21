package android.hardware.bydauto.signal;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoSignalDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int SIGNAL_COMMAND_BUSY = -2147482647;
    public static final int SIGNAL_COMMAND_FAILED = -2147482648;
    public static final int SIGNAL_COMMAND_INVALID_VALUE = -2147482645;
    public static final int SIGNAL_COMMAND_SUCCESS = 0;
    public static final int SIGNAL_COMMAND_TIMEOUT = -2147482646;
    static final String SIGNAL_SET_PERM = "android.permission.BYDAUTO_SIGNAL_SET";
    public static final int SIGNAL_STATUS = 1;
    public static final int SIGNAL_STATUS_NORMAL = 1;
    public static final int SIGNAL_STATUS_WORSE = 2;
    protected static final String TAG = "BYDAutoSignaldevice";
    private static int mDeviceType = 1037;
    private static BYDAutoSignalDevice mInstance;
    private final Context mContext;

    private BYDAutoSignalDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoSignalDevice getInstance(Context context) {
        BYDAutoSignalDevice bYDAutoSignalDevice;
        synchronized (BYDAutoSignalDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoSignalDevice(context);
            }
            bYDAutoSignalDevice = mInstance;
        }
        return bYDAutoSignalDevice;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_SIGNAL;
    }

    public void setAllStatus() {
    }

    public int setSignalStatus(int i) {
        Log.d(TAG, "setSiganlStatus value is:" + i);
        this.mContext.enforceCallingOrSelfPermission(SIGNAL_SET_PERM, null);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 1, i);
        }
        return -2147482645;
    }
}
