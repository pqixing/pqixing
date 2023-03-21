//refactor
package android.hardware.bydauto.power;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoPowerDevice extends AbsBYDAutoDevice {
public static final int ACC_STATUS = 3;
public static final int BCM_POWER_ON_LEVEL = 11;
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
public static synchronized BYDAutoPowerDevice getInstance(Context context) { return null; }
public int dspReset() { return 0; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getMcuStatus() { return 0; }
public int getPowerCtlStatus(int i) { return 0; }
public int getShutdownInfo(int i) { return 0; }
public int getTftBacklight() { return 0; }
public int getTpDisplayController() { return 0; }
public int getType() { return 0; }
public int padReset() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public int qcomWakeup(int i) { return 0; }
public void registerListener(AbsBYDAutoPowerListener absBYDAutoPowerListener) { }
public int sendQcomRebootState(int i) { return 0; }
public void setAllStatus() { }
public int setBCMPowerOnLevel() { return 0; }
public int setPowerCtlStatus(int i, int i2) { return 0; }
public int setTftBacklight(int i) { return 0; }
public int setTpDisplayController(int i) { return 0; }
public void unregisterListener(AbsBYDAutoPowerListener absBYDAutoPowerListener) { }
public int wakeUpMcu() { return 0; }
public void registerListener(AbsBYDAutoPowerListener absBYDAutoPowerListener, int[] iArr) { }
 }
