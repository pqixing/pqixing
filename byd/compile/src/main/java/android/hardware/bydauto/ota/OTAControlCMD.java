package android.hardware.bydauto.ota;

/* loaded from: classes.dex */
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
    private int eclPowerOn = 0;
    private int exitSmartCharging = 0;
    private int exitChargingDis = 0;
    private int enterOtaMode = 0;
    private int otaPowerCmd = 0;
    private int highVoltageCmd = 7;
    private int powerOnForbid = 0;

    public int getEclPowerOn() {
        return this.eclPowerOn;
    }

    public int getEnterOtaMode() {
        return this.enterOtaMode;
    }

    public int getExitChargingDis() {
        return this.exitChargingDis;
    }

    public int getExitSmartCharging() {
        return this.exitSmartCharging;
    }

    public int getHighVoltageCmd() {
        return this.highVoltageCmd;
    }

    public int getOtaPowerCmd() {
        return this.otaPowerCmd;
    }

    public int getPowerOnForbid() {
        return this.powerOnForbid;
    }

    public void setEclPowerOn(int i) {
        this.eclPowerOn = i;
    }

    public void setEnterOtaMode(int i) {
        this.enterOtaMode = i;
    }

    public void setExitChargingDis(int i) {
        this.exitChargingDis = i;
    }

    public void setExitSmartCharging(int i) {
        this.exitSmartCharging = i;
    }

    public void setHighVoltageCmd(int i) {
        this.highVoltageCmd = i;
    }

    public void setOtaPowerCmd(int i) {
        this.otaPowerCmd = i;
    }

    public void setPowerOnForbid(int i) {
        this.powerOnForbid = i;
    }
}
