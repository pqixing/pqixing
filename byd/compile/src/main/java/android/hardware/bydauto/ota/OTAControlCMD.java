//refactor
package android.hardware.bydauto.ota;
public class OTAControlCMD {
public static final int OTA_CTL_CMD_INVALID = 0;
public static final int OTA_CTL_ECL_POWERON = 1;
public static final int OTA_CTL_ENTER_OTA_MODE = 1;
public static final int OTA_CTL_EXIT_CHARGING_DIS = 1;
public static final int OTA_CTL_EXIT_SMART_CHARGING = 1;
public static final int OTA_CTL_FINISH_OTA_MODE = 0;
public static final int OTA_CTL_HV_EXIT_OTA = 3;
public static final int OTA_CTL_HV_KEEP_DISCHARGING = 6;
public static final int OTA_CTL_HV_KEEP_POWEROFF = 2;
public static final int OTA_CTL_HV_PAUSE_WRITE = 4;
public static final int OTA_CTL_HV_RESERVE = 7;
public static final int OTA_CTL_HV_START_DISCHARGING = 0;
public static final int OTA_CTL_HV_START_POWEROFF = 1;
public static final int OTA_CTL_OTA_NORMAL = 3;
public static final int OTA_CTL_OTA_POWEROFF = 1;
public static final int OTA_CTL_OTA_POWERON = 2;
public static final int POWER_ON_FORBID_DISABLE = 2;
public static final int POWER_ON_FORBID_ENABLE = 1;
public static final int POWER_ON_FORBID_INVALID = 0;
public int getEclPowerOn() { return 0; }
public int getEnterOtaMode() { return 0; }
public int getExitChargingDis() { return 0; }
public int getExitSmartCharging() { return 0; }
public int getHighVoltageCmd() { return 0; }
public int getOtaPowerCmd() { return 0; }
public int getPowerOnForbid() { return 0; }
public void setEclPowerOn(int i) { }
public void setEnterOtaMode(int i) { }
public void setExitChargingDis(int i) { }
public void setExitSmartCharging(int i) { }
public void setHighVoltageCmd(int i) { }
public void setOtaPowerCmd(int i) { }
public void setPowerOnForbid(int i) { }
 }
