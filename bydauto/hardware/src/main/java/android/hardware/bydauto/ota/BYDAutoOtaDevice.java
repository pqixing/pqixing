//refactor
package android.hardware.bydauto.ota;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;
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
public static final int OTA_LF_DOOR_LOCK = 32;
public static final int OTA_POWEROFF_INFORM = 10;
public static final int OTA_POWERON_FORBID = 31;
public static final int OTA_SCREEN_CTL = 26;
public static final int OTA_SCREEN_OFF = 0;
public static final int OTA_SCREEN_ON = 1;
public static final int OTA_SET_MCU_MESSAGE = 38;
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
public static synchronized BYDAutoOtaDevice getInstance(Context context) { return null; }
public int FinishOTA() { return 0; }
public int StartOTA() { return 0; }
public double getBatteryPowerVoltage() { return 0; }
public double getBatteryVoltage() { return 0; }
public byte[] getCanInfo() { return null; }
public int getDischargeMainContactorState() { return 0; }
public byte[] getECUSoftcode() { return null; }
public byte[] getECUVersion() { return null; }
public byte[] getFaultCodeInfo() { return null; }
public int[] getFeatureList() { return null; }
public int getLFDoorLockState() { return 0; }
public byte[] getOTAInfoACK() { return null; }
public int getOTAState() { return 0; }
public int getOTATimecountState() { return 0; }
public int getPowerOnForbidState() { return 0; }
public int getPoweroffInform() { return 0; }
public int getType() { return 0; }
public int notifyTargetID(byte[] bArr) { return 0; }
public int notifyTargetID2(byte[] bArr) { return 0; }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public void registerListener(AbsBYDAutoOtaListener absBYDAutoOtaListener) { }
public int sendECUIds(int i, byte[] bArr) { return 0; }
public int sendECUIds2(int i, byte[] bArr) { return 0; }
public int sendOTACtlCMD(OTAControlCMD oTAControlCMD) { return 0; }
public int sendOTAData(byte[] bArr) { return 0; }
public int sendOTAData2(byte[] bArr) { return 0; }
public int sendOTAServiceData(byte[] bArr) { return 0; }
public int sendOTATimecountCtlCMD(int i, int i2, int i3, int i4) { return 0; }
public void setAllStatus() { }
public int setCanInfoSwitchState(int i) { return 0; }
public int setMcuMessage(int i) { return 0; }
public int setPowerOnForbidState(int i) { return 0; }
public int setScreenState(int i) { return 0; }
public int syncMcuState() { return 0; }
public void unregisterListener(AbsBYDAutoOtaListener absBYDAutoOtaListener) { }
public void registerListener(AbsBYDAutoOtaListener absBYDAutoOtaListener, int[] iArr) { }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public boolean postEvent(int i, int i2, double d2, Object obj) { return false; }
 }
