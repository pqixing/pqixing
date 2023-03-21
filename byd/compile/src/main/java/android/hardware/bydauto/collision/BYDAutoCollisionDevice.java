package android.hardware.bydauto.collision;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoCollisionDevice extends AbsBYDAutoDevice {
    public static final int COLLISION_COMMAND_BUSY = -2147482647;
    public static final int COLLISION_COMMAND_FAILED = -2147482648;
    public static final int COLLISION_COMMAND_INVALID_VALUE = -2147482645;
    public static final int COLLISION_COMMAND_SUCCESS = 0;
    public static final int COLLISION_COMMAND_TIMEOUT = -2147482646;
    static final String COLLISION_GET_PERM = "android.permission.BYDAUTO_COLLISION_GET";
    static final String COLLISION_SET_PERM = "android.permission.BYDAUTO_COLLISION_SET";
    public static final int COLLISION_SIGNAL = 2;
    public static final int COLLISION_STATE_S = 1;
    private static final boolean DEBUG = true;
    public static final int NORMAL_SIGNAL = 1;
    protected static final String TAG = "BYDAutoCollisionDevice";
    private static int mDeviceType = 1015;
    private static BYDAutoCollisionDevice mInstance;
    private final Context mContext;

    private BYDAutoCollisionDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoCollisionDevice getInstance(Context context) {
        BYDAutoCollisionDevice bYDAutoCollisionDevice;
        synchronized (BYDAutoCollisionDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoCollisionDevice(context);
            }
            bYDAutoCollisionDevice = mInstance;
        }
        return bYDAutoCollisionDevice;
    }

    public void getAllStatus() {
    }

    public byte[] getCollisionInfo() {
        this.mContext.enforceCallingOrSelfPermission(COLLISION_GET_PERM, null);
        return super.getBuffer(mDeviceType, 1);
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1015;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + Arrays.toString(bArr));
        return onPostEvent(new BYDAutoCollisionEvent(i, i2, bArr, obj));
    }

    public void registerListener(AbsBYDAutoCollisionListener absBYDAutoCollisionListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(COLLISION_GET_PERM, null);
        if (absBYDAutoCollisionListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoCollisionListener);
        }
    }

    public void unregisterListener(AbsBYDAutoCollisionListener absBYDAutoCollisionListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(COLLISION_GET_PERM, null);
        if (absBYDAutoCollisionListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoCollisionListener);
        }
    }

    public void registerListener(AbsBYDAutoCollisionListener absBYDAutoCollisionListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(COLLISION_GET_PERM, null);
        if (absBYDAutoCollisionListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoCollisionListener, iArr);
        }
    }
}
