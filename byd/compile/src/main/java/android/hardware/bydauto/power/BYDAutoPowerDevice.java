package android.hardware.bydauto.power;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoPowerDevice extends AbsBYDAutoDevice {
    public static final int ACC_STATUS = 3;
    public static final int BCM_POWER_ON_LEVEL = 11;
    private static final boolean DEBUG = true;
    public static final int DEVICE_PAD = 1;
    public static final int DISPLAY_OWNER = 19;
    public static final int DSP_RESET = 2;
    public static final int FREESCALE_POWER = 12;
    public static final int FREESCALE_RESET = 13;
    public static final int GBDATA_TRANSMIT = 10;
    public static final int MCU_SLEEP = 0;
    public static final int MCU_STATUS = 4;
    public static final int MCU_WAKE = 1;
    public static final int MOTOR_POWER = 16;
    public static final int OUTPUT_12V = 7;
    public static final int OUTPUT_5V = 6;
    public static final int PAD_BOOT = 14;
    public static final int PAD_RESET = 1;
    public static final int POWER_COMMAND_BUSY = -2147482647;
    public static final int POWER_COMMAND_FAILED = -2147482648;
    public static final int POWER_COMMAND_INVALID_VALUE = -2147482645;
    public static final int POWER_COMMAND_SUCCESS = 0;
    public static final int POWER_COMMAND_TIMEOUT = -2147482646;
    public static final int POWER_CTL_STATE_OFF = 0;
    public static final int POWER_CTL_STATE_ON = 1;
    static final String POWER_GET_PERM = "android.permission.BYDAUTO_POWER_GET";
    static final String POWER_SET_PERM = "android.permission.BYDAUTO_POWER_SET";
    public static final int QCOM_REBOOT_STATE = 22;
    public static final int QCOM_REBOOT_STATE_DONE = 2;
    public static final int QCOM_REBOOT_STATE_INVALID = 0;
    public static final int QCOM_REBOOT_STATE_START = 1;
    public static final int QCOM_WAKEUP = 9;
    public static final int SHUTDOWN_INFO_INVALID = 0;
    public static final int SHUTDOWN_INFO_PAD = 20;
    public static final int SHUTDOWN_INFO_WARNING = 1;
    public static final int START_GBDATA_TRANSMIT = 1;
    public static final int SYSTEM_SUSPEND = 17;
    protected static final String TAG = "BYDAutoPowerDevice";
    public static final int TFT_BACKLIGHT = 15;
    public static final int TFT_BACKLIGHT_MAX = 11;
    public static final int TFT_BACKLIGHT_MIN = 0;
    public static final int TFT_TP_POWER = 8;
    public static final int TP_DISPLAY_FREESCALE = 2;
    public static final int TP_DISPLAY_PAD = 1;
    public static final int TP_OWNER = 18;
    public static final int WAKEUP_ABNORMAL_RESTART = 2;
    public static final int WAKEUP_ACC_ON = 1;
    public static final int WAKEUP_EMERGENCY = 4;
    public static final int WAKEUP_NORMAL_START = 0;
    public static final int WAKEUP_REMOTE = 5;
    public static final int WAKEUP_UPGRADE = 3;
    private static int mDeviceType = 1005;
    private static BYDAutoPowerDevice mInstance;
    private final Context mContext;

    private BYDAutoPowerDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoPowerDevice getInstance(Context context) {
        BYDAutoPowerDevice bYDAutoPowerDevice;
        synchronized (BYDAutoPowerDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoPowerDevice(context);
            }
            bYDAutoPowerDevice = mInstance;
        }
        return bYDAutoPowerDevice;
    }

    public int dspReset() {
        Log.d(TAG, "POWER dspReset");
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        return super.set(mDeviceType, 2, 1);
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getMcuStatus() {
        this.mContext.enforceCallingOrSelfPermission(POWER_GET_PERM, null);
        int i = super.get(mDeviceType, 4);
        Log.d(TAG, " POWER getMcuStatus value is:" + i);
        return i;
    }

    public int getPowerCtlStatus(int i) {
        Log.d(TAG, "getPowerCtlStatus event_type is: " + i);
        this.mContext.enforceCallingOrSelfPermission(POWER_GET_PERM, null);
        if (i == 12 || i == 13 || i == 3 || i == 14 || i == 8 || i == 16 || i == 6 || i == 7 || i == 17) {
            int i2 = super.get(mDeviceType, i);
            Log.d(TAG, "getPowerCtlStatus is: " + i2);
            return i2;
        }
        return -2147482645;
    }

    public int getShutdownInfo(int i) {
        this.mContext.enforceCallingOrSelfPermission(POWER_GET_PERM, null);
        if (i != 1) {
            return -2147482645;
        }
        int i2 = super.get(mDeviceType, 20);
        Log.d(TAG, "getShutdownInfo: the device is:" + i + ", and info is:" + i2);
        return i2;
    }

    public int getTftBacklight() {
        this.mContext.enforceCallingOrSelfPermission(POWER_GET_PERM, null);
        int i = super.get(mDeviceType, 15);
        Log.d(TAG, " POWER getTftBacklight value is:" + i);
        return i;
    }

    public int getTpDisplayController() {
        this.mContext.enforceCallingOrSelfPermission(POWER_GET_PERM, null);
        int i = super.get(mDeviceType, 18);
        if (i != super.get(mDeviceType, 19)) {
            return -2147482648;
        }
        Log.d(TAG, "getTpDisplayController is:" + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1005;
    }

    public int padReset() {
        Log.d(TAG, "POWER padReset");
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        return super.set(mDeviceType, 1, 1);
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public int qcomWakeup(int i) {
        Log.d(TAG, "The qcomWakeup reason is:" + i);
        if (i < 0 || i > 5) {
            return -2147482645;
        }
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        return super.set(mDeviceType, 9, i);
    }

    public void registerListener(AbsBYDAutoPowerListener absBYDAutoPowerListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(POWER_GET_PERM, null);
        if (absBYDAutoPowerListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoPowerListener);
        }
    }

    public int sendQcomRebootState(int i) {
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        Log.d(TAG, "sendQcomRebootState state is: " + i);
        if (i == 0 || i == 1 || i == 2) {
            return super.set(mDeviceType, 22, i);
        }
        return -2147482645;
    }

    public void setAllStatus() {
    }

    public int setBCMPowerOnLevel() {
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        int i = super.set(mDeviceType, 11, 1);
        Log.d(TAG, "setBCMPowerOnLevel:" + i);
        return i;
    }

    public int setPowerCtlStatus(int i, int i2) {
        Log.d(TAG, "POWER setPowerCtlStatus event_type is: " + i + "value is:" + i2);
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        if (i2 == 1 || i2 == 0) {
            if (i != 6 && i != 7 && i != 8) {
                return -2147482645;
            }
            return super.set(mDeviceType, i, i2);
        }
        return -2147482645;
    }

    public int setTftBacklight(int i) {
        Log.d(TAG, "POWER setTftBacklight value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        if (i < 0 || i > 11) {
            return -2147482645;
        }
        return super.set(mDeviceType, 15, i);
    }

    public int setTpDisplayController(int i) {
        Log.d(TAG, "POWER setTpDisplayController value is:" + i);
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        if (i == 1 || i == 2) {
            int i2 = super.set(mDeviceType, 18, i);
            return i2 != 0 ? i2 : super.set(mDeviceType, 19, i);
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoPowerListener absBYDAutoPowerListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(POWER_GET_PERM, null);
        if (absBYDAutoPowerListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoPowerListener);
        }
    }

    public int wakeUpMcu() {
        Log.d(TAG, "POWER wakeUpMcu.");
        this.mContext.enforceCallingOrSelfPermission(POWER_SET_PERM, null);
        return super.set(mDeviceType, 4, 1);
    }

    public void registerListener(AbsBYDAutoPowerListener absBYDAutoPowerListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(POWER_GET_PERM, null);
        if (absBYDAutoPowerListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoPowerListener, iArr);
        }
    }
}
