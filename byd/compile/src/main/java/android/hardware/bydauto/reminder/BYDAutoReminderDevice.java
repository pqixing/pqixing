//refactor
package android.hardware.bydauto.reminder;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoReminderDevice extends AbsBYDAutoDevice {
public static final int REMINDER = 1;
public static final int REMINDER_COMMAND_BUSY = -2147482647;
public static final int REMINDER_COMMAND_FAILED = -2147482648;
public static final int REMINDER_COMMAND_INVALID = -2147482645;
public static final int REMINDER_COMMAND_SUCCESS = 0;
public static final int REMINDER_COMMAND_TIMEOUT = -2147482646;
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
public static synchronized BYDAutoReminderDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getIndicatorValue() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoReminderListener absBYDAutoReminderListener) { }
public void unregisterListener(AbsBYDAutoReminderListener absBYDAutoReminderListener) { }
public void registerListener(AbsBYDAutoReminderListener absBYDAutoReminderListener, int[] iArr) { }
 }
