package android.hardware.bydauto;

import android.content.Context;
import android.hardware.BYDAutoManager;
import android.hardware.IBYDAutoDevice;
import android.os.Handler;
import android.util.Log;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class BYDAutoDeviceManager implements BYDAutoManager.OnBYDAutoListener {
    private static final boolean DEBUG = false;
    private static final Object LOCK_OBJ = new Object();
    private static final String TAG = "BYDAutoDeviceManager";
    private static BYDAutoDeviceManager mInstance;
    protected BYDAutoManager mAutoManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends BYDAutoDeviceManager {
        private HashMap<Integer, IBYDAutoDevice> a = new HashMap<>();

        protected a(Context context) {
            super(context);
            new Handler(context.getMainLooper());
        }

        @Override // android.hardware.bydauto.BYDAutoDeviceManager
        public void addDevice(IBYDAutoDevice iBYDAutoDevice) {
            BYDAutoManager bYDAutoManager;
            if (this.a.containsKey(Integer.valueOf(iBYDAutoDevice.getType()))) {
                return;
            }
            this.a.put(Integer.valueOf(iBYDAutoDevice.getType()), iBYDAutoDevice);
            if (this.a.size() != 1 || (bYDAutoManager = this.mAutoManager) == null) {
                return;
            }
            bYDAutoManager.registerListener(this);
        }

        @Override // android.hardware.bydauto.BYDAutoDeviceManager
        public void removeDevice(IBYDAutoDevice iBYDAutoDevice) {
            BYDAutoManager bYDAutoManager;
            if (!this.a.containsKey(Integer.valueOf(iBYDAutoDevice.getType()))) {
                return;
            }
            this.a.remove(Integer.valueOf(iBYDAutoDevice.getType()));
            if (this.a.size() != 0 || (bYDAutoManager = this.mAutoManager) == null) {
                return;
            }
            bYDAutoManager.unregisterListener(this);
        }
    }

    protected BYDAutoDeviceManager(Context context) {
        this.mAutoManager = null;
        this.mAutoManager = (BYDAutoManager) context.getSystemService("auto");
    }

    public static synchronized BYDAutoDeviceManager getInstance(Context context) {
        synchronized (BYDAutoDeviceManager.class) {
            synchronized (LOCK_OBJ) {
                if (mInstance == null) {
                    if (context == null) {
                        Log.e(TAG, "getInstance: both the instance and the input con is null, can`t create the instance.");
                        return null;
                    }
                    mInstance = new a(context);
                }
                return mInstance;
            }
        }
    }

    public abstract void addDevice(IBYDAutoDevice iBYDAutoDevice);

    public int disableDevice(IBYDAutoDevice iBYDAutoDevice) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.disableDevice(iBYDAutoDevice.getType());
        }
        Log.e(TAG, "disableDevice: mAutoManager is null and error exit");
        return -2147482648;
    }

    public int enableDevice(IBYDAutoDevice iBYDAutoDevice) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.enableDevice(iBYDAutoDevice.getType());
        }
        Log.e(TAG, "enableDevice: mAutoManager is null and error exit");
        return -2147482648;
    }

    public byte[] getBuffer(int i, int i2) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.getBuffer(i, i2);
        }
        Log.e(TAG, "getIntArray: mAutoManager is null and error exit");
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[3 - i3] = (byte) (((-2147482648) >> (i3 * 8)) & 255);
        }
        return bArr;
    }

    public double getDouble(int i, int i2) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.getDouble(i, i2);
        }
        Log.e(TAG, "getDouble: mAutoManager is null and error exit");
        return -2.147482648E9d;
    }

    public double[] getDoubleArray(int i, int[] iArr) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.getDoubleArray(i, iArr);
        }
        Log.e(TAG, "getDoubleArray: mAutoManager is null and error exit");
        return new double[]{-2.147482648E9d};
    }

    public int getInt(int i, int i2) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.getInt(i, i2);
        }
        Log.e(TAG, "getInt: mAutoManager is null and error exit");
        return -2147482648;
    }

    public int[] getIntArray(int i, int[] iArr) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.getIntArray(i, iArr);
        }
        Log.e(TAG, "getIntArray: mAutoManager is null and error exit");
        return new int[]{-2147482648};
    }

    public abstract void removeDevice(IBYDAutoDevice iBYDAutoDevice);

    public int setBuffer(int i, int i2, byte[] bArr) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.setBuffer(i, i2, bArr);
        }
        Log.e(TAG, "setBuffer: mAutoManager is null and error exit");
        return -2147482648;
    }

    public int setDouble(int i, int i2, double d2) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.setDouble(i, i2, d2);
        }
        Log.e(TAG, "setDouble: mAutoManager is null and error exit");
        return -2147482648;
    }

    public int setDoubleArray(int i, int[] iArr, double[] dArr) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.setDoubleArray(i, iArr, dArr);
        }
        Log.e(TAG, "setDoubleArray: mAutoManager is null and error exit");
        return -2147482648;
    }

    public int setInt(int i, int i2, int i3) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.setInt(i, i2, i3);
        }
        Log.e(TAG, "setInt: mAutoManager is null and error exit");
        return -2147482648;
    }

    public int setIntArray(int i, int[] iArr, int[] iArr2) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.setIntArray(i, iArr, iArr2);
        }
        Log.e(TAG, "setIntArray: mAutoManager is null and error exit");
        return -2147482648;
    }

    public int enableDevice(IBYDAutoDevice iBYDAutoDevice, int[] iArr) {
        BYDAutoManager bYDAutoManager = this.mAutoManager;
        if (bYDAutoManager != null) {
            return bYDAutoManager.enableDevice(iBYDAutoDevice.getType(), iArr);
        }
        Log.e(TAG, "enableDevice: mAutoManager is null and error exit");
        return -2147482648;
    }
}
