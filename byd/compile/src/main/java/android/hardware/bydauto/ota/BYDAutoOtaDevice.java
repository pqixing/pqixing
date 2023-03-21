package android.hardware.bydauto.ota;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoOtaDevice extends AbsBYDAutoDevice {
    public static final double BATTERY_POWER_VOLTAGE_MAX = 17.0d;
    public static final double BATTERY_POWER_VOLTAGE_MIN = 6.0d;
    public static final double BATTERY_VOLTAGE_MAX = 16.0d;
    public static final double BATTERY_VOLTAGE_MIN = 8.0d;
    public static final int CAN_INFO_SWITCH_CLOSE = 0;
    public static final int CAN_INFO_SWITCH_OPEN = 1;
    public static final int CAN_INFO_SWITCH_STATE = 35;
    public static final int CAN_INST_COM1 = 4;
    public static final int CAN_INST_COM2 = 0;
    public static final int CAN_INST_ECM = 5;
    public static final int CAN_INST_ESC = 1;
    public static final int CAN_INST_EX = 2;
    public static final int CONTACTOR_STATE_CONNECT = 1;
    public static final int CONTACTOR_STATE_DISCONNECT = 0;
    private static final boolean DEBUG = true;
    public static final int LF_DOOR_LOCK = 2;
    public static final int LF_DOOR_LOCK_INVALID = 0;
    public static final int LF_DOOR_UNLOCK = 1;
    public static final int OTA_BATTERY_POWER_VOLTAGE = 36;
    public static final int OTA_BATTERY_VOLTAGE = 30;
    public static final int OTA_CMD_ACK = 1;
    public static final int OTA_CMD_CAN_INFO = 34;
    public static final int OTA_CMD_DATA = 3;
    public static final int OTA_CMD_ECL_POWER_ON = 11;
    public static final int OTA_CMD_ECU_GET_FAULTCODE = 37;
    public static final int OTA_CMD_ECU_GET_SOFTCODE = 23;
    public static final int OTA_CMD_ECU_GET_SOFTCODE2 = 29;
    public static final int OTA_CMD_ECU_GET_VER = 8;
    public static final int OTA_CMD_ECU_GET_VER2 = 28;
    public static final int OTA_CMD_ECU_SOFTCODE = 7;
    public static final int OTA_CMD_ECU_VER = 6;
    public static final int OTA_CMD_ENTER_OTA_MODE = 14;
    public static final int OTA_CMD_EXIT_CHARGING_DIS = 13;
    public static final int OTA_CMD_EXIT_SMART_CHARGING = 12;
    public static final int OTA_CMD_FINISH = 4;
    public static final int OTA_CMD_OTA_HIGH_VOLTAGE_MODULE = 16;
    public static final int OTA_CMD_OTA_POWER_CMD = 15;
    public static final int OTA_CMD_SERVICE_DATA = 5;
    public static final int OTA_CMD_TARGET_CAN_ID = 2;
    public static final int OTA_COMMAND_BUSY = -2147482647;
    public static final int OTA_COMMAND_FAILED = -2147482648;
    public static final int OTA_COMMAND_INVALID = -2147482645;
    public static final int OTA_COMMAND_SUCCESS = 0;
    public static final int OTA_COMMAND_TIMEOUT = -2147482646;
    public static final int OTA_DATA_WITH_CHANNEL = 25;
    public static final int OTA_DISCHARGE_MAIN_CONTACTOR_STATE = 27;
    static final String OTA_GET_PERM = "android.permission.BYDAUTO_OTA_GET";
    public static final int OTA_LF_DOOR_LOCK = 32;
    public static final int OTA_POWEROFF_INFORM = 10;
    public static final int OTA_POWERON_FORBID = 31;
    public static final int OTA_SCREEN_CTL = 26;
    public static final int OTA_SCREEN_OFF = 0;
    public static final int OTA_SCREEN_ON = 1;
    public static final int OTA_SET_MCU_MESSAGE = 38;
    static final String OTA_SET_PERM = "android.permission.BYDAUTO_OTA_SET";
    public static final int OTA_START = 9;
    public static final int OTA_STATE = 17;
    public static final int OTA_STATE_INVALID = 0;
    public static final int OTA_STATE_UPGRADE = 1;
    public static final int OTA_SYNC_MCU_STATE = 40;
    public static final int OTA_TARGET_CAN_ID_WITH_CHANNEL = 24;
    public static final int OTA_TIMECOUNT_CTL_HOUR = 21;
    public static final int OTA_TIMECOUNT_CTL_HOUR_INVALID = 31;
    public static final int OTA_TIMECOUNT_CTL_HOUR_MAX = 23;
    public static final int OTA_TIMECOUNT_CTL_HOUR_MIN = 0;
    public static final int OTA_TIMECOUNT_CTL_INSTALL = 19;
    public static final int OTA_TIMECOUNT_CTL_INSTALL_APPOINTMENT = 2;
    public static final int OTA_TIMECOUNT_CTL_INSTALL_CANCLE = 3;
    public static final int OTA_TIMECOUNT_CTL_INSTALL_INVALID = 0;
    public static final int OTA_TIMECOUNT_CTL_INSTALL_NOW = 1;
    public static final int OTA_TIMECOUNT_CTL_MINUTE = 22;
    public static final int OTA_TIMECOUNT_CTL_MINUTE_INVALID = 63;
    public static final int OTA_TIMECOUNT_CTL_MINUTE_MAX = 59;
    public static final int OTA_TIMECOUNT_CTL_MINUTE_MIN = 0;
    public static final int OTA_TIMECOUNT_CTL_USER = 20;
    public static final int OTA_TIMECOUNT_CTL_USER_CANCLE = 2;
    public static final int OTA_TIMECOUNT_CTL_USER_CONFIRM = 1;
    public static final int OTA_TIMECOUNT_CTL_USER_DO_NOTHING = 3;
    public static final int OTA_TIMECOUNT_CTL_USER_INVALID = 0;
    public static final int OTA_TIMECOUNT_STATE = 18;
    public static final int OTA_TIMECOUNT_STATE_ALLOW = 0;
    public static final int OTA_TIMECOUNT_STATE_NOT_ALLOW = 1;
    public static final int OTA_UPGRADE_INFO = 33;
    public static final int POWER_OFF_INFORM_INVALID = 0;
    public static final int POWER_OFF_INFORM_POWEROFF = 1;
    public static final int POWER_ON_FORBID_DISABLE = 2;
    public static final int POWER_ON_FORBID_ENABLE = 1;
    public static final int POWER_ON_FORBID_INVALID = 0;
    public static final int SEND_ECU_IDS_PURPOSE_FAULTCODE = 3;
    public static final int SEND_ECU_IDS_PURPOSE_SOFTCODE = 2;
    public static final int SEND_ECU_IDS_PURPOSE_VERSION_INFO = 1;
    public static final int START_REBOOT_RECOVERY = 1;
    public static final int SYNC_MCU_STATE_DONE = 1;
    public static final int SYNC_MCU_STATE_INVALID = 0;
    protected static final String TAG = "BYDAutoOTAdevice";
    private static int mDeviceType = 1032;
    private static BYDAutoOtaDevice mInstance;
    private final Context mContext;

    private BYDAutoOtaDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoOtaDevice getInstance(Context context) {
        BYDAutoOtaDevice bYDAutoOtaDevice;
        synchronized (BYDAutoOtaDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoOtaDevice(context);
            }
            bYDAutoOtaDevice = mInstance;
        }
        return bYDAutoOtaDevice;
    }

    public int FinishOTA() {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        Log.d(TAG, "FinishOTA");
        return super.set(mDeviceType, 4, 1);
    }

    public int StartOTA() {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        Log.d(TAG, "StartOTA");
        return super.set(mDeviceType, 9, 1);
    }

    public double getBatteryPowerVoltage() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 36);
        Log.d(TAG, "getBatteryPowerVoltage: voltage is " + d2);
        return d2;
    }

    public double getBatteryVoltage() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 30);
        Log.d(TAG, "getBatteryVoltage: voltage is " + d2);
        return d2;
    }

    public byte[] getCanInfo() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        Log.d(TAG, "getCanInfo");
        return super.getBuffer(mDeviceType, 34);
    }

    public int getDischargeMainContactorState() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        int i = super.get(mDeviceType, 27);
        Log.d(TAG, "getDischargeMainContactorState: state is " + i);
        return i;
    }

    public byte[] getECUSoftcode() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        Log.d(TAG, "getECUSoftcode");
        return super.getBuffer(mDeviceType, 7);
    }

    public byte[] getECUVersion() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        Log.d(TAG, "getECUVersion");
        return super.getBuffer(mDeviceType, 6);
    }

    public byte[] getFaultCodeInfo() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        Log.d(TAG, "getFaultCodeInfo");
        return super.getBuffer(mDeviceType, 37);
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getLFDoorLockState() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        int i = super.get(mDeviceType, 32);
        Log.d(TAG, "getLFDoorLockState: state is " + i);
        return i;
    }

    public byte[] getOTAInfoACK() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 1);
        Log.d(TAG, "getOTAInfoACK");
        return buffer;
    }

    public int getOTAState() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        int i = super.get(mDeviceType, 17);
        Log.d(TAG, "getOTAState: state is " + i);
        return i;
    }

    public int getOTATimecountState() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        int i = super.get(mDeviceType, 18);
        Log.d(TAG, "getOTATimecountState: state is " + i);
        return i;
    }

    public int getPowerOnForbidState() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        int i = super.get(mDeviceType, 31);
        Log.d(TAG, "getPowerOnForbidState: state is " + i);
        return i;
    }

    public int getPoweroffInform() {
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        int i = super.get(mDeviceType, 10);
        Log.d(TAG, "getPoweroffInform: inform is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_OTA;
    }

    public int notifyTargetID(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (bArr == null || bArr.length < 1) {
            return -2147482645;
        }
        Log.d(TAG, "notifyTargetID");
        return super.set(mDeviceType, 2, bArr);
    }

    public int notifyTargetID2(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (bArr == null || bArr.length < 1) {
            return -2147482645;
        }
        Log.d(TAG, "notifyTargetID2");
        return super.set(mDeviceType, 24, bArr);
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + Arrays.toString(bArr));
        return onPostEvent(new BYDAutoOtaEvent(i, i2, bArr, obj));
    }

    public void registerListener(AbsBYDAutoOtaListener absBYDAutoOtaListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        if (absBYDAutoOtaListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoOtaListener);
        }
    }

    public int sendECUIds(int i, byte[] bArr) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (bArr != null && bArr.length >= 1) {
            Log.d(TAG, "sendECUIds: purpose is " + i);
            if (i == 1) {
                i2 = 8;
            } else if (i == 2) {
                i2 = 23;
            } else if (i == 3) {
                i2 = 37;
            }
            return super.set(mDeviceType, i2, bArr);
        }
        return -2147482645;
    }

    public int sendECUIds2(int i, byte[] bArr) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (bArr != null && bArr.length >= 1) {
            Log.d(TAG, "sendECUIds2: purpose is " + i);
            if (i == 1) {
                i2 = 28;
            } else if (i == 2) {
                i2 = 29;
            }
            return super.set(mDeviceType, i2, bArr);
        }
        return -2147482645;
    }

    public int sendOTACtlCMD(OTAControlCMD oTAControlCMD) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (oTAControlCMD == null) {
            return -2147482645;
        }
        int eclPowerOn = oTAControlCMD.getEclPowerOn();
        int exitSmartCharging = oTAControlCMD.getExitSmartCharging();
        int exitChargingDis = oTAControlCMD.getExitChargingDis();
        int enterOtaMode = oTAControlCMD.getEnterOtaMode();
        int otaPowerCmd = oTAControlCMD.getOtaPowerCmd();
        int highVoltageCmd = oTAControlCMD.getHighVoltageCmd();
        int powerOnForbid = oTAControlCMD.getPowerOnForbid();
        Log.d(TAG, "sendOTACtlCMD: eclPowerOn = " + eclPowerOn + ", exitSmartCharging = " + exitSmartCharging + ", exitChargingDis = " + exitChargingDis + ", enterOtaMode = " + enterOtaMode + ", otaPowerCmd = " + otaPowerCmd + ", highVoltageCmd = " + highVoltageCmd + ", powerOnForbid = " + powerOnForbid);
        if ((eclPowerOn != 0 && eclPowerOn != 1) || ((exitSmartCharging != 0 && exitSmartCharging != 1) || ((exitChargingDis != 0 && exitChargingDis != 1) || ((enterOtaMode != 0 && enterOtaMode != 1) || ((otaPowerCmd != 0 && otaPowerCmd != 1 && otaPowerCmd != 2 && otaPowerCmd != 3) || (highVoltageCmd != 0 && highVoltageCmd != 1 && highVoltageCmd != 2 && highVoltageCmd != 3 && highVoltageCmd != 4 && highVoltageCmd != 6 && highVoltageCmd != 7 && powerOnForbid != 1 && powerOnForbid != 2)))))) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{11, 12, 13, 14, 15, 16, 33}, new int[]{eclPowerOn, exitSmartCharging, exitChargingDis, enterOtaMode, otaPowerCmd, highVoltageCmd, powerOnForbid});
    }

    public int sendOTAData(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (bArr == null || bArr.length < 1) {
            return -2147482645;
        }
        Log.d(TAG, "sendOTAData");
        return super.set(mDeviceType, 3, bArr);
    }

    public int sendOTAData2(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (bArr == null || bArr.length < 1) {
            return -2147482645;
        }
        Log.d(TAG, "sendOTAData2");
        return super.set(mDeviceType, 25, bArr);
    }

    public int sendOTAServiceData(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (bArr == null || bArr.length < 1) {
            return -2147482645;
        }
        Log.d(TAG, "sendOTAServiceData");
        return super.set(mDeviceType, 5, bArr);
    }

    public int sendOTATimecountCtlCMD(int i, int i2, int i3, int i4) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        Log.d(TAG, "sendOTATimecountCtlCMD: install = " + i + ", user = " + i2 + ", hour = " + i3 + ", minute = " + i4);
        if (i < 0 || i > 3 || i2 < 0 || i2 > 3 || i3 < 0) {
            return -2147482645;
        }
        if ((i3 > 23 && i3 != 31) || i4 < 0) {
            return -2147482645;
        }
        if (i4 > 59 && i4 != 63) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{19, 20, 21, 22}, new int[]{i, i2, i3, i4});
    }

    public void setAllStatus() {
    }

    public int setCanInfoSwitchState(int i) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        Log.d(TAG, "setCanInfoSwitchState: state is " + i);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, 35, i);
        }
        return -2147482645;
    }

    public int setMcuMessage(int i) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        Log.d(TAG, "setMcuMessage: message is " + i);
        if (i != 1) {
            return -2147482645;
        }
        return super.set(mDeviceType, 38, i);
    }

    public int setPowerOnForbidState(int i) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        Log.d(TAG, "setPowerOnForbidState: state is " + i);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 33, i);
        }
        return -2147482645;
    }

    public int setScreenState(int i) {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        if (i == 1 || i == 0) {
            Log.d(TAG, "setScreenState: state is " + i);
            return super.set(mDeviceType, 26, i);
        }
        return -2147482645;
    }

    public int syncMcuState() {
        this.mContext.enforceCallingOrSelfPermission(OTA_SET_PERM, null);
        Log.d(TAG, "syncMcuState");
        return super.set(mDeviceType, 40, 1);
    }

    public void unregisterListener(AbsBYDAutoOtaListener absBYDAutoOtaListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        if (absBYDAutoOtaListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoOtaListener);
        }
    }

    public void registerListener(AbsBYDAutoOtaListener absBYDAutoOtaListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(OTA_GET_PERM, null);
        if (absBYDAutoOtaListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoOtaListener, iArr);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + d2);
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }
}
