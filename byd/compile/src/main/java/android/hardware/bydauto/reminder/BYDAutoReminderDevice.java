package android.hardware.bydauto.reminder;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoReminderDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int REMINDER = 1;
    public static final int REMINDER_COMMAND_BUSY = -2147482647;
    public static final int REMINDER_COMMAND_FAILED = -2147482648;
    public static final int REMINDER_COMMAND_INVALID = -2147482645;
    public static final int REMINDER_COMMAND_SUCCESS = 0;
    public static final int REMINDER_COMMAND_TIMEOUT = -2147482646;
    static final String REMINDER_GET_PERM = "android.permission.BYDAUTO_REMINDER_GET";
    static final String REMINDER_SET_PERM = "android.permission.BYDAUTO_REMINDER_SET";
    public static final int RMD_AC_DECREASE_WIND_LEVEL = 83;
    public static final int RMD_ATTTION_DRIVING = 12;
    public static final int RMD_AUTO_LIGHT_OFF = 14;
    public static final int RMD_AUTO_LIGHT_ON = 13;
    public static final int RMD_BEAM_LIGHT_ON = 38;
    public static final int RMD_CHANGE_LOWKEY = 10;
    public static final int RMD_DOOR_OK = 9;
    public static final int RMD_FINISH_STUDY = 35;
    public static final int RMD_FST_PWD_BTN = 5;
    public static final int RMD_HIGHT_TEMPERATURE = 39;
    public static final int RMD_KEYCLSTART_BTN = 6;
    public static final int RMD_KEY_INCAR = 7;
    public static final int RMD_LOCK_SAFEBELT = 36;
    public static final int RMD_LOW_BATT = 1;
    public static final int RMD_LOW_OIL = 37;
    public static final int RMD_LOW_SINGAL_NET = 42;
    public static final int RMD_LOW_TEMPERATURE = 40;
    public static final int RMD_LPSTART_BTN = 4;
    public static final int RMD_NPLEAVE_CAR = 3;
    public static final int RMD_PM2P5_AUTO_INTER_CIRCUL = 82;
    public static final int RMD_PM2P5_INTER_CIRCUL = 81;
    public static final int RMD_PM2P5_OPEN_AC = 80;
    public static final int RMD_RM_BRAKE = 8;
    public static final int RMD_START_CAR = 2;
    public static final int RMD_STEER_START = 11;
    public static final int RMD_STOP_REMOTECTRL_DRV = 41;
    public static final int RMD_SYS_FATIGUE_DEMO = 33;
    public static final int RMD_SYS_FATIGUE_OFF = 32;
    public static final int RMD_SYS_FATIGUE_ON = 15;
    public static final int RMD_SYS_FATIGUE_WORK = 34;
    protected static final String TAG = "BYDAutoReminderDevice";
    private static int mDeviceType = 1026;
    private static BYDAutoReminderDevice mInstance;
    private final Context mContext;

    private BYDAutoReminderDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoReminderDevice getInstance(Context context) {
        BYDAutoReminderDevice bYDAutoReminderDevice;
        synchronized (BYDAutoReminderDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoReminderDevice(context);
            }
            bYDAutoReminderDevice = mInstance;
        }
        return bYDAutoReminderDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getIndicatorValue() {
        this.mContext.enforceCallingOrSelfPermission(REMINDER_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getIndicatorValue event_type is: 1value is : " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_REMINDER;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoReminderListener absBYDAutoReminderListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(REMINDER_GET_PERM, null);
        if (absBYDAutoReminderListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoReminderListener);
        }
    }

    public void unregisterListener(AbsBYDAutoReminderListener absBYDAutoReminderListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(REMINDER_GET_PERM, null);
        if (absBYDAutoReminderListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoReminderListener);
        }
    }

    public void registerListener(AbsBYDAutoReminderListener absBYDAutoReminderListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(REMINDER_GET_PERM, null);
        if (absBYDAutoReminderListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoReminderListener, iArr);
        }
    }
}
