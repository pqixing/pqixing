package android.hardware.bydauto.security;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoSecurityDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int SECURITY_COMMAND_BUSY = -2147482647;
    public static final int SECURITY_COMMAND_FAILED = -2147482648;
    public static final int SECURITY_COMMAND_SUCCESS = 0;
    public static final int SECURITY_COMMAND_TIMEOUT = -2147482646;
    private static final String SECURITY_GET_PERM = "android.permission.BYDAUTO_SECURITY_GET";
    public static final int SECURITY_STATE_S = 1;
    public static final int SECURITY_STATE_SAFE = 0;
    public static final int SECURITY_STATE_WARNING = 1;
    protected static final String TAG = "BYDAutoSecurityDevice";
    private static int mDeviceType = 1010;
    private static BYDAutoSecurityDevice mInstance;
    private final Context mContext;

    private BYDAutoSecurityDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoSecurityDevice getInstance(Context context) {
        BYDAutoSecurityDevice bYDAutoSecurityDevice;
        synchronized (BYDAutoSecurityDevice.class) {
            if (mInstance == null && context != null) {
                mInstance = new BYDAutoSecurityDevice(context);
            }
            bYDAutoSecurityDevice = mInstance;
        }
        return bYDAutoSecurityDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public byte[] getSecurityState() {
        this.mContext.enforceCallingOrSelfPermission(SECURITY_GET_PERM, null);
        return super.getBuffer(mDeviceType, 1);
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1010;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + Arrays.toString(bArr));
        return onPostEvent(new BYDAutoSecurityEvent(i, i2, bArr, obj));
    }

    public void registerListener(AbsBYDAutoSecurityListener absBYDAutoSecurityListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(SECURITY_GET_PERM, null);
        if (absBYDAutoSecurityListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSecurityListener);
        }
    }

    public void setAllStatus() {
    }

    public void unregisterListener(AbsBYDAutoSecurityListener absBYDAutoSecurityListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(SECURITY_GET_PERM, null);
        if (absBYDAutoSecurityListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoSecurityListener);
        }
    }

    public void registerListener(AbsBYDAutoSecurityListener absBYDAutoSecurityListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(SECURITY_GET_PERM, null);
        if (absBYDAutoSecurityListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSecurityListener, iArr);
        }
    }
}
