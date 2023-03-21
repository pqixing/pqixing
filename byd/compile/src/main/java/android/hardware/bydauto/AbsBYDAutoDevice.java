package android.hardware.bydauto;

import android.content.Context;
import android.hardware.IBYDAutoDevice;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoDevice implements IBYDAutoDevice {
    private static final boolean DEBUG = false;
    private static String TAG = "AbsBYDAutoDevice";
    private final ArrayList<IBYDAutoListener> mAutoListener = new ArrayList<>();
    private BYDAutoDeviceManager mDeviceManager;

    public AbsBYDAutoDevice(Context context) {
        this.mDeviceManager = null;
        BYDAutoDeviceManager bYDAutoDeviceManager = BYDAutoDeviceManager.getInstance(context);
        this.mDeviceManager = bYDAutoDeviceManager;
        if (bYDAutoDeviceManager != null) {
            bYDAutoDeviceManager.addDevice(this);
        }
    }

    public int get(int i, int i2) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.getInt(i, i2);
        }
        Log.e(TAG, "get: the device manager is null and error exit!");
        return -2147482648;
    }

    public byte[] getBuffer(int i, int i2) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.getBuffer(i, i2);
        }
        Log.e(TAG, "getIntArray: the device manager is null and error exit!");
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[3 - i3] = (byte) (((-2147482648) >> (i3 * 8)) & 255);
        }
        return bArr;
    }

    public double getDouble(int i, int i2) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.getDouble(i, i2);
        }
        Log.e(TAG, "getDouble: the device manager is null and error exit!");
        return -2.147482648E9d;
    }

    public double[] getDoubleArray(int i, int[] iArr) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.getDoubleArray(i, iArr);
        }
        Log.e(TAG, "getDoubleArray: the device manager is null and error exit!");
        return new double[]{-2.147482648E9d};
    }

    public int[] getIntArray(int i, int[] iArr) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.getIntArray(i, iArr);
        }
        Log.e(TAG, "getIntArray: the device manager is null and error exit!");
        return new int[]{-2147482648};
    }

    @Override // android.hardware.IBYDAutoDevice
    public boolean onPostEvent(IBYDAutoEvent iBYDAutoEvent) {
        if (iBYDAutoEvent == null || getType() != iBYDAutoEvent.getDeviceType()) {
            return false;
        }
        ArrayList<IBYDAutoListener> arrayList = this.mAutoListener;
        if (arrayList == null) {
            return true;
        }
        synchronized (arrayList) {
            for (int i = 0; i < this.mAutoListener.size(); i++) {
                IBYDAutoListener iBYDAutoListener = this.mAutoListener.get(i);
                if (iBYDAutoListener != null) {
                    iBYDAutoListener.onDataChanged(iBYDAutoEvent);
                }
            }
        }
        return true;
    }

    @Override // android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    @Override // android.hardware.IBYDAutoDevice
    public void registerListener(IBYDAutoListener iBYDAutoListener) {
        BYDAutoDeviceManager bYDAutoDeviceManager;
        if (iBYDAutoListener != null) {
            boolean z = false;
            synchronized (this.mAutoListener) {
                if (!this.mAutoListener.contains(iBYDAutoListener)) {
                    this.mAutoListener.add(iBYDAutoListener);
                    if (this.mAutoListener.size() == 1 && this.mDeviceManager != null) {
                        z = true;
                    }
                }
            }
            if (!z || (bYDAutoDeviceManager = this.mDeviceManager) == null) {
                return;
            }
            bYDAutoDeviceManager.enableDevice(this);
        }
    }

    public int set(int i, int i2, int i3) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.setInt(i, i2, i3);
        }
        Log.e(TAG, "set: the device manager is null and error exit!");
        return -2147482648;
    }

    @Override // android.hardware.IBYDAutoDevice
    public void unregisterListener(IBYDAutoListener iBYDAutoListener) {
        BYDAutoDeviceManager bYDAutoDeviceManager;
        if (iBYDAutoListener != null) {
            boolean z = false;
            synchronized (this.mAutoListener) {
                this.mAutoListener.remove(iBYDAutoListener);
                if (this.mAutoListener.size() == 0 && this.mDeviceManager != null) {
                    z = true;
                }
            }
            if (!z || (bYDAutoDeviceManager = this.mDeviceManager) == null) {
                return;
            }
            bYDAutoDeviceManager.disableDevice(this);
        }
    }

    @Override // android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }

    @Override // android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
        }
        return true;
    }

    public int set(int i, int i2, byte[] bArr) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.setBuffer(i, i2, bArr);
        }
        Log.e(TAG, "set: the device manager is null and error exit!");
        return -2147482648;
    }

    public int set(int i, int i2, double d2) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.setDouble(i, i2, d2);
        }
        Log.e(TAG, "set: the device manager is null and error exit!");
        return -2147482648;
    }

    public void registerListener(IBYDAutoListener iBYDAutoListener, int[] iArr) {
        if (iBYDAutoListener != null) {
            synchronized (this.mAutoListener) {
                if (!this.mAutoListener.contains(iBYDAutoListener)) {
                    this.mAutoListener.add(iBYDAutoListener);
                }
            }
            BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
            if (bYDAutoDeviceManager == null) {
                return;
            }
            bYDAutoDeviceManager.enableDevice(this, iArr);
        }
    }

    public int set(int i, int[] iArr, int[] iArr2) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.setIntArray(i, iArr, iArr2);
        }
        Log.e(TAG, "set: the device manager is null and error exit!");
        return -2147482648;
    }

    public int set(int i, int[] iArr, double[] dArr) {
        BYDAutoDeviceManager bYDAutoDeviceManager = this.mDeviceManager;
        if (bYDAutoDeviceManager != null) {
            return bYDAutoDeviceManager.setDoubleArray(i, iArr, dArr);
        }
        Log.e(TAG, "set: the device manager is null and error exit!");
        return -2147482648;
    }
}
