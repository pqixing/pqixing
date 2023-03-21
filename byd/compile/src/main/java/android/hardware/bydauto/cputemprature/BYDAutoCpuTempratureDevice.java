package android.hardware.bydauto.cputemprature;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoCpuTempratureDevice extends AbsBYDAutoDevice {
    public static final int CPUTEMPRATURE_COMMAND_BUSY = -2147482647;
    public static final int CPUTEMPRATURE_COMMAND_FAILED = -2147482648;
    public static final int CPUTEMPRATURE_COMMAND_INVALID_VALUE = -2147482645;
    public static final int CPUTEMPRATURE_COMMAND_SUCCESS = 0;
    public static final int CPUTEMPRATURE_COMMAND_TIMEOUT = -2147482646;
    static final String CPUTEMPRATURE_SET_PERM = "android.permission.BYDAUTO_CPUTEMPRATURE_SET";
    public static final int CPU_TEMPRATURE = 1;
    public static final int CPU_TEMPRATURE_MAX = 155;
    public static final int CPU_TEMPRATURE_MIN = -100;
    private static final boolean DEBUG = true;
    public static final int PMIC_TEMPRATURE = 2;
    public static final int PMIC_TEMPRATURE_MAX = 155;
    public static final int PMIC_TEMPRATURE_MIN = -100;
    protected static final String TAG = "BYDAutoCPUTEMPATUREDevice";
    public static final int TEC_CTL = 3;
    public static final int TEC_CTL_MAX = 100;
    public static final int TEC_CTL_MIN = 0;
    private static int mDeviceType = 1030;
    private static BYDAutoCpuTempratureDevice mInstance;
    private final Context mContext;

    private BYDAutoCpuTempratureDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoCpuTempratureDevice getInstance(Context context) {
        BYDAutoCpuTempratureDevice bYDAutoCpuTempratureDevice;
        synchronized (BYDAutoCpuTempratureDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoCpuTempratureDevice(context);
            }
            bYDAutoCpuTempratureDevice = mInstance;
        }
        return bYDAutoCpuTempratureDevice;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_CPUTEMPRATURE;
    }

    public void setAllStatus() {
    }

    public int setCpuTemprature(int i) {
        Log.d(TAG, "setCpuTemprature temprature is:" + i);
        this.mContext.enforceCallingOrSelfPermission(CPUTEMPRATURE_SET_PERM, null);
        if (i < -100 || i > 155) {
            return -2147482645;
        }
        return super.set(mDeviceType, 1, i);
    }

    public int setPmicTemprature(int i) {
        Log.d(TAG, "setPmicTemprature temprature is:" + i);
        this.mContext.enforceCallingOrSelfPermission(CPUTEMPRATURE_SET_PERM, null);
        if (i < -100 || i > 155) {
            return -2147482645;
        }
        return super.set(mDeviceType, 2, i);
    }

    public int setTecCtrlLevel(int i) {
        Log.d(TAG, "setTecCtrlLevel level is:" + i);
        this.mContext.enforceCallingOrSelfPermission(CPUTEMPRATURE_SET_PERM, null);
        if (i < 0 || i > 100) {
            return -2147482645;
        }
        return super.set(mDeviceType, 3, i);
    }

    public int setTemprature(int i, int i2) {
        Log.d(TAG, "setTemprature: cpu temprature is " + i + ",pmic temprature is " + i2);
        this.mContext.enforceCallingOrSelfPermission(CPUTEMPRATURE_SET_PERM, null);
        if (i < -100 || i > 155 || i2 < -100 || i2 > 155) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{1, 2}, new int[]{i, i2});
    }
}
