package android.hardware.bydauto.version;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoVersionDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    protected static final String TAG = "BYDAutoVersionDevice";
    public static final int VERSION_AC = 13;
    public static final int VERSION_BATTERY_CTRL = 9;
    public static final int VERSION_CAR_CHARGER = 10;
    public static final int VERSION_COMMAND_BUSY = -2147482647;
    public static final int VERSION_COMMAND_FAILED = -2147482648;
    public static final int VERSION_COMMAND_INVALID_VALUE = -2147482645;
    public static final int VERSION_COMMAND_SUCCESS = 0;
    public static final int VERSION_COMMAND_TIMEOUT = -2147482646;
    public static final int VERSION_DSP = 2;
    public static final int VERSION_DSP_BOOT = 12;
    public static final int VERSION_DTC = 12;
    public static final int VERSION_ENGINE_CTRL = 4;
    static final String VERSION_GET_PERM = "android.permission.BYDAUTO_VERSION_GET";
    public static final int VERSION_INSTRUMENT = 3;
    public static final int VERSION_MCU = 1;
    public static final int VERSION_MCU_BOOT = 11;
    public static final int VERSION_MOTOR_CTRL = 6;
    public static final int VERSION_MOTOR_CTRL_F = 7;
    public static final int VERSION_MOTOR_CTRL_R = 8;
    static final String VERSION_SET_PERM = "android.permission.BYDAUTO_VERSION_SET";
    public static final int VERSION_TRANS_CTRL = 5;
    private static int mDeviceType = 1027;
    private static BYDAutoVersionDevice mInstance;
    private final Context mContext;

    private BYDAutoVersionDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoVersionDevice getInstance(Context context) {
        BYDAutoVersionDevice bYDAutoVersionDevice;
        synchronized (BYDAutoVersionDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoVersionDevice(context);
            }
            bYDAutoVersionDevice = mInstance;
        }
        return bYDAutoVersionDevice;
    }

    public String getACEcuVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 13);
        if (buffer.length <= 4) {
            Log.d(TAG, "getACEcuVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length), "US-ASCII");
            Log.d(TAG, "getACEcuVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public void getAllStatus() {
    }

    public String getBatteryCtrlVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 9);
        if (buffer.length <= 4) {
            Log.d(TAG, "getBatteryCtrlVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getMotorCtrl3Version is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getCarChargerVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 10);
        if (buffer.length <= 4) {
            Log.d(TAG, "getCarChargerVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getCarChargerVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getDSPBootVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 12);
        if (buffer.length <= 4) {
            Log.d(TAG, "getDSPBootVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length), "US-ASCII");
            Log.d(TAG, "getDSPBootVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getDspVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 2);
        if (buffer.length <= 4) {
            Log.d(TAG, "getDspVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getDspVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getDtcVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 12);
        if (buffer.length <= 4) {
            Log.d(TAG, "getDtcVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getDtcVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getEngineCtrlVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 4);
        if (buffer.length <= 4) {
            Log.d(TAG, "getEngineCtrlVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getEngineCtrlVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public String getInstrumentVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 3);
        if (buffer.length <= 4) {
            Log.d(TAG, "getInstrumentVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getInstrumentVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getMcuBootVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 11);
        if (buffer.length <= 4) {
            Log.d(TAG, "getMcuBootVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length), "US-ASCII");
            Log.d(TAG, "getMcuBootVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getMcuVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 1);
        if (buffer.length <= 4) {
            Log.d(TAG, "getMcuVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length), "US-ASCII");
            Log.d(TAG, "getMcuVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getMotorCtrl1Version() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 6);
        if (buffer.length <= 4) {
            Log.d(TAG, "getMotorCtrl1Version error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getMotorCtrl1Version is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getMotorCtrl2Version() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 7);
        if (buffer.length <= 4) {
            Log.d(TAG, "getMotorCtrl2Version error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getMotorCtrl2Version is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getMotorCtrl3Version() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 8);
        if (buffer.length <= 4) {
            Log.d(TAG, "getMotorCtrl3Version error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getMotorCtrl3Version is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public String getTransmissionCtrlVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 5);
        if (buffer.length <= 4) {
            Log.d(TAG, "getTransmissionCtrlVersion error");
            return "V1.0.1";
        }
        try {
            String str = new String(Arrays.copyOfRange(buffer, 4, buffer.length - 1), "US-ASCII");
            Log.d(TAG, "getTransmissionCtrlVersion is:" + str);
            return str;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_VERSION;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public int queryAcEcuVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 2, 13);
        Log.d(TAG, "queryAcEcuVersion the ret = " + i);
        return i;
    }

    public int queryBatteryCtrlVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 9, 9);
        Log.d(TAG, "queryBatteryCtrlVersion the ret = " + i);
        return i;
    }

    public int queryCarChargerVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 10, 10);
        Log.d(TAG, "queryCarChargerVersion the ret = " + i);
        return i;
    }

    public int queryDSPBootVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 12, 1);
        Log.d(TAG, "queryDSPBootVersion the ret = " + i);
        return i;
    }

    public int queryDspVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 2, 2);
        Log.d(TAG, "queryDspVersion the ret = " + i);
        return i;
    }

    public int queryEngineCtrlVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 4, 4);
        Log.d(TAG, "queryEngineCtrlVersion the ret = " + i);
        return i;
    }

    public int queryInstrumentVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 3, 3);
        Log.d(TAG, "queryInstrumentVersion the ret = " + i);
        return i;
    }

    public int queryMcuBootVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 11, 1);
        Log.d(TAG, "queryMcuBootVersion the ret = " + i);
        return i;
    }

    public int queryMcuVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 1, 1);
        Log.d(TAG, "queryMcuVersion the ret = " + i);
        return i;
    }

    public int queryMotorCtrl1Version() {
        int i = super.set(mDeviceType, 6, 6);
        Log.d(TAG, "queryMotorCtrl1Version the ret = " + i);
        return i;
    }

    public int queryMotorCtrl2Version() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 7, 7);
        Log.d(TAG, "queryMotorCtrl2Version the ret = " + i);
        return i;
    }

    public int queryMotorCtrl3Version() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 8, 8);
        Log.d(TAG, "queryMotorCtrl3Version the ret = " + i);
        return i;
    }

    public int queryTransmissionCtrlVersion() {
        this.mContext.enforceCallingOrSelfPermission(VERSION_SET_PERM, null);
        int i = super.set(mDeviceType, 5, 5);
        Log.d(TAG, "queryTransmissionCtrlVersion the ret = " + i);
        return i;
    }

    public void registerListener(AbsBYDAutoVersionListener absBYDAutoVersionListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        if (absBYDAutoVersionListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoVersionListener);
        }
    }

    public void setAllStatus() {
    }

    public void unregisterListener(AbsBYDAutoVersionListener absBYDAutoVersionListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        if (absBYDAutoVersionListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoVersionListener);
        }
    }

    public void registerListener(AbsBYDAutoVersionListener absBYDAutoVersionListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(VERSION_GET_PERM, null);
        if (absBYDAutoVersionListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoVersionListener, iArr);
        }
    }
}
