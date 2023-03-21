package android.hardware.bydauto.vehicledata;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoVehicleDataDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int EVENT_DATA_ACQ = 2;
    public static final int PERIOD_DATA_ACQ = 3;
    protected static final String TAG = "BYDAutoVehicleDataDevice";
    public static final int VEHICLE_DATA_ACQ_CONFIGURE = 1;
    public static final int VEHICLE_DATA_COMMAND_BUSY = -2147482647;
    public static final int VEHICLE_DATA_COMMAND_FAILED = -2147482648;
    public static final int VEHICLE_DATA_COMMAND_INVALID_VALUE = -2147482645;
    public static final int VEHICLE_DATA_COMMAND_SUCCESS = 0;
    public static final int VEHICLE_DATA_COMMAND_TIMEOUT = -2147482646;
    static final String VEHICLE_DATA_GET_PERM = "android.permission.BYDAUTO_VEHICLE_DATA_GET";
    static final String VEHICLE_DATA_SET_PERM = "android.permission.BYDAUTO_VEHICLE_DATA_SET";
    private static int mDeviceType = 1048;
    private static BYDAutoVehicleDataDevice mInstance;
    private final Context mContext;

    private BYDAutoVehicleDataDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoVehicleDataDevice getInstance(Context context) {
        BYDAutoVehicleDataDevice bYDAutoVehicleDataDevice;
        synchronized (BYDAutoVehicleDataDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoVehicleDataDevice(context);
            }
            bYDAutoVehicleDataDevice = mInstance;
        }
        return bYDAutoVehicleDataDevice;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_VEHICLE_DATA;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoVehicleDataListener absBYDAutoVehicleDataListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(VEHICLE_DATA_GET_PERM, null);
        if (absBYDAutoVehicleDataListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoVehicleDataListener);
        }
    }

    public int sendVehicleDataAcq(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(VEHICLE_DATA_SET_PERM, null);
        if (bArr == null || bArr.length < 1) {
            return -2147482645;
        }
        Log.d(TAG, "sendVehicleDataAcq");
        return super.set(mDeviceType, 1, bArr);
    }

    public void unregisterListener(AbsBYDAutoVehicleDataListener absBYDAutoVehicleDataListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(VEHICLE_DATA_GET_PERM, null);
        if (absBYDAutoVehicleDataListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoVehicleDataListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + bArr);
        return onPostEvent(new BYDAutoVehicleDataEvent(i, i2, bArr, obj));
    }

    public void registerListener(AbsBYDAutoVehicleDataListener absBYDAutoVehicleDataListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(VEHICLE_DATA_GET_PERM, null);
        if (absBYDAutoVehicleDataListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoVehicleDataListener, iArr);
        }
    }
}
