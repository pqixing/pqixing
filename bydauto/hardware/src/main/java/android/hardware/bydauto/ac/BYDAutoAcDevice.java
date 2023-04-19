//refactor
package android.hardware.bydauto.ac;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoAcDevice extends AbsBYDAutoDevice {
public static final int AC = 1;
public static final int AC_AIR_QUAL_CTRL_MENU_OFF = 0;
public static final int AC_AIR_QUAL_CTRL_MENU_ON = 1;
public static final int AC_AIR_QUAL_CTRL_MENU_STATE = 24;
public static final int AC_COMMAND_BUSY = -2147482647;
public static final int AC_COMMAND_FAILED = -2147482648;
public static final int AC_COMMAND_INVALID_VALUE = -2147482645;
public static final int AC_COMMAND_SUCCESS = 0;
public static final int AC_COMMAND_TIMEOUT = -2147482646;
public static final int AC_COMPRESSOR_MANUAL_SIGN = 12;
public static final int AC_COMPRESSOR_MANUAL_SIGN_OFF = 0;
public static final int AC_COMPRESSOR_MANUAL_SIGN_ON = 1;
public static final int AC_COMPRESSOR_MODE = 9;
public static final int AC_COMPRESSOR_OFF = 0;
public static final int AC_COMPRESSOR_ON = 1;
public static final int AC_COOL_HOT_SIGNAL = 19;
public static final int AC_CTRLMODE_AUTO = 0;
public static final int AC_CTRLMODE_MANUAL = 1;
public static final int AC_CTRL_MODE = 1;
public static final int AC_CTRL_SOURCE = 26;
public static final int AC_CTRL_SOURCE_UI_KEY = 0;
public static final int AC_CTRL_SOURCE_VOICE = 1;
public static final int AC_CYCLEMODE_INLOOP = 1;
public static final int AC_CYCLEMODE_OUTLOOP = 0;
public static final int AC_CYCLE_MODE = 2;
public static final int AC_DEFROST_5S_OFFLINE = 0;
public static final int AC_DEFROST_5S_ONLINE = 1;
public static final int AC_DEFROST_AREA_FRONT = 1;
public static final int AC_DEFROST_AREA_REAR = 2;
public static final int AC_DEFROST_FRONT_STATE = 10;
public static final int AC_DEFROST_REAR_STATE = 11;
public static final int AC_DEFROST_STATE_OFF = 0;
public static final int AC_DEFROST_STATE_ON = 1;
public static final int AC_FAULT_NUM_SHOWN_STATE = 22;
public static final int AC_FAULT_NUM_SHOWN_STATE_INVALID = 0;
public static final int AC_FAULT_NUM_SHOWN_STATE_OFF = 1;
public static final int AC_FAULT_NUM_SHOWN_STATE_ON = 2;
public static final int AC_FAULT_NUM_SHOWN_STATE_RESERVED = 3;
public static final int AC_KEY_ACTION_FALSE = 1;
public static final int AC_KEY_ACTION_INVALID = 0;
public static final int AC_KEY_ACTION_STATE = 27;
public static final int AC_KEY_ACTION_TRUE = 2;
public static final int AC_MAX_COOLING_OFF = 0;
public static final int AC_MAX_COOLING_ON = 1;
public static final int AC_MAX_COOLING_STATE = 16;
public static final int AC_ONLINE_STATE = 17;
public static final int AC_ONLINE_STATE_OFF = 0;
public static final int AC_ONLINE_STATE_ON = 1;
public static final int AC_POWER_OFF = 0;
public static final int AC_POWER_ON = 1;
public static final int AC_POWER_STATE = 0;
public static final int AC_PROMPT_BOX_SHOWN_STATE = 21;
public static final int AC_PROMPT_BOX_SHOWN_STATE_INVALID = 0;
public static final int AC_PROMPT_BOX_SHOWN_STATE_OFF = 1;
public static final int AC_PROMPT_BOX_SHOWN_STATE_ON = 2;
public static final int AC_PROMPT_BOX_SHOWN_STATE_RESERVE = 3;
public static final int AC_PTC_PREHEAT_ILLUME = 1;
public static final int AC_PTC_PREHEAT_INVALID = 0;
public static final int AC_PTC_PREHEAT_NOTILLUME = 2;
public static final int AC_PTC_PREHEAT_RESERVE = 3;
public static final int AC_PTC_PREHEAT_SIGNAL = 41;
public static final int AC_PURIFICATION_FUNCTION_PEOMPT = 36;
public static final int AC_QUR_ALL_STATUS = 28;
public static final int AC_REAR_COOL_HOT_SIGNAL = 20;
public static final int AC_REAR_CTRL_MODE = 32;
public static final int AC_REAR_LOCK_STATE = 33;
public static final int AC_REAR_LOCK_STATE_OFF = 0;
public static final int AC_REAR_LOCK_STATE_ON = 1;
public static final int AC_REAR_MAX_WIND_LEVEL = 37;
public static final int AC_REAR_POWER_STATE = 29;
public static final int AC_REAR_WIND_LEVEL = 31;
public static final int AC_REAR_WIND_MODE = 30;
public static final int AC_REMOTE_CTRL_TIME = 39;
public static final int AC_REMOTE_CTRL_TIME_10 = 1;
public static final int AC_REMOTE_CTRL_TIME_15 = 2;
public static final int AC_REMOTE_CTRL_TIME_20 = 3;
public static final int AC_REMOTE_CTRL_TIME_25 = 4;
public static final int AC_REMOTE_CTRL_TIME_30 = 5;
public static final int AC_RESET = 42;
public static final int AC_TEMPCTRL_RANGE_SINGLE = 3;
public static final int AC_TEMPCTRL_SEPARATE_OFF = 0;
public static final int AC_TEMPCTRL_SEPARATE_ON = 1;
public static final int AC_TEMPCTRL_SEPARATE_STATE = 8;
public static final int AC_TEMPERATURE_DEPUTY = 2;
public static final int AC_TEMPERATURE_MAIN = 1;
public static final int AC_TEMPERATURE_MAIN_DEPUTY = 0;
public static final int AC_TEMPERATURE_OUT = 4;
public static final int AC_TEMPERATURE_REAR = 3;
public static final int AC_TEMPERATURE_UNIT = 15;
public static final int AC_TEMPERATURE_UNIT_OC = 1;
public static final int AC_TEMPERATURE_UNIT_OF = 0;
public static final int AC_TEMP_DEPUTY = 6;
public static final int AC_TEMP_INVALID = 0;
public static final int AC_TEMP_IN_CELSIUS_MAX = 33;
public static final int AC_TEMP_IN_CELSIUS_MIN = 17;
public static final int AC_TEMP_IN_FAHRENHEIT_MAX = 91;
public static final int AC_TEMP_IN_FAHRENHEIT_MIN = 64;
public static final int AC_TEMP_MAIN = 5;
public static final int AC_TEMP_OUT = 7;
public static final int AC_TEMP_OUT_CELSIUS_MAX = 50;
public static final int AC_TEMP_OUT_CELSIUS_MIN = -40;
public static final int AC_TEMP_OUT_FAHRENHEIT_MAX = 122;
public static final int AC_TEMP_OUT_FAHRENHEIT_MIN = -40;
public static final int AC_TEMP_REAR = 25;
public static final int AC_TYPE = 40;
public static final int AC_TYPE_AUTO = 1;
public static final int AC_TYPE_ELECTRIC = 2;
public static final int AC_TYPE_INVALID = 0;
public static final int AC_VENTILATION_STATE = 18;
public static final int AC_VENTILATION_STATE_OFF = 0;
public static final int AC_VENTILATION_STATE_ON = 1;
public static final int AC_VOICE_CMD_RESULT = 34;
public static final int AC_WARM_FUEL = 2;
public static final int AC_WARM_INVALID = 0;
public static final int AC_WARM_PTC = 1;
public static final int AC_WARM_STATE = 50;
public static final int AC_WARM_TYPE_FLAG = 49;
public static final int AC_WARM_TYPE_FLAG_FUEL = 2;
public static final int AC_WARM_TYPE_FLAG_INVALID = 0;
public static final int AC_WARM_TYPE_FLAG_PTC = 1;
public static final int AC_WARM_TYPE_FLAG_PTCFUEL = 3;
public static final int AC_WINDLEVEL_0 = 0;
public static final int AC_WINDLEVEL_1 = 1;
public static final int AC_WINDLEVEL_2 = 2;
public static final int AC_WINDLEVEL_3 = 3;
public static final int AC_WINDLEVEL_4 = 4;
public static final int AC_WINDLEVEL_5 = 5;
public static final int AC_WINDLEVEL_6 = 6;
public static final int AC_WINDLEVEL_7 = 7;
public static final int AC_WINDLEVEL_MANUAL_SIGN = 13;
public static final int AC_WINDLEVEL_MANUAL_SIGN_OFF = 0;
public static final int AC_WINDLEVEL_MANUAL_SIGN_ON = 1;
public static final int AC_WINDMODE_DEFROST = 5;
public static final int AC_WINDMODE_FACE = 1;
public static final int AC_WINDMODE_FACEDEFROST = 7;
public static final int AC_WINDMODE_FACEFOOT = 2;
public static final int AC_WINDMODE_FACEFOOTDEFROST = 6;
public static final int AC_WINDMODE_FOOT = 3;
public static final int AC_WINDMODE_FOOTDEFROST = 4;
public static final int AC_WINDMODE_MANUAL_SIGN = 14;
public static final int AC_WINDMODE_MANUAL_SIGN_OFF = 0;
public static final int AC_WINDMODE_MANUAL_SIGN_ON = 1;
public static final int AC_WINDMODE_SHOWN_STATE = 23;
public static final int AC_WINDMODE_SHOWN_STATE_OFF = 0;
public static final int AC_WINDMODE_SHOWN_STATE_ON = 1;
public static final int AC_WIND_LEVEL = 3;
public static final int AC_WIND_MODE = 4;
public static final int AC_WIND_MODE_NUM = 43;
public static final int AC_WIND_TOTAL_MODES_NUM_5 = 1;
public static final int AC_WIND_TOTAL_MODES_NUM_7 = 2;
public static final int AC_WIND_TOTAL_MODES_NUM_INVALID = 0;
public static final int CMD_AC_DEFROST_5S_ONLINE = 45;
public static final int CMD_OTA_SUB_BATTERY_TEMPRATURE = 52;
public static final int COLD = 1;
public static final int DEVICE_HAS_THE_FEATURE = 1;
public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
public static final String FEATURE_AC_AUTO_MODE = "ACAutoMode";
public static final String FEATURE_AC_DEFROST = "ACDefrost";
public static final String FEATURE_AC_REMOTE_CTL = "ACRemoteControl";
public static final int HAS_AC_AUTO_MODE = 35;
public static final int HAS_AC_DEFROST = 44;
public static final int HAS_AC_REMOTE_CTRL = 38;
public static final int HOT = 0;
public static final int OTA_SUB_BATTERY_TEMPRATURE_INVALID = 65535;
public static final int OTA_SUB_BATTERY_TEMPRATURE_MAX = 160;
public static final int OTA_SUB_BATTERY_TEMPRATURE_MIN = -60;
public static final int PURIFICATION_FUNCTION_PROMPT_ENABLE = 1;
public static final int REAR_AC = 2;
public static final int REAR_AC_MAX_WINDLEVEL_4 = 1;
public static final int REAR_AC_MAX_WINDLEVEL_7 = 2;
public static final int RESET_INVALID = 0;
public static final int RESET_ITEM_AC = 0;
public static final int RESET_VALID = 1;
public static final int VOICE_AC_ALREADY_IN_MAX_TEMP = 5;
public static final int VOICE_AC_ALREADY_IN_MIN_TEMP = 4;
public static final int VOICE_CMD_INVALID = 0;
public static final int VOICE_SET_INVALID_TEMP = 2;
public static final int VOICE_SET_INVALID_WIND_LEVEL = 3;
public static final int VOICE_START_AC_SUCCESS = 1;
public static synchronized BYDAutoAcDevice getInstance(Context context) { return null; }
public int enablePurificationFunctionPrompt(int i) { return 0; }
public int feelColdHot(int i, int i2) { return 0; }
public int getAcCompressorManualSign() { return 0; }
public int getAcCompressorMode() { return 0; }
public int getAcControlMode() { return 0; }
public int getAcCycleMode() { return 0; }
public int getAcDefrostOnlineState() { return 0; }
public int getAcDefrostState(int i) { return 0; }
public int getAcFaultNumShownState() { return 0; }
public int getAcKeyActionState() { return 0; }
public int getAcMaxCoolingState() { return 0; }
public int getAcOnlineState() { return 0; }
public int getAcPromptBoxShownState() { return 0; }
public int getAcPtcPreheatSignal() { return 0; }
public int getAcRemoteCtrlTime() { return 0; }
public int getAcStartState() { return 0; }
public int getAcSubBatteryTemperature() { return 0; }
public int getAcTemperatureControlMode() { return 0; }
public int getAcType() { return 0; }
public int getAcVentilationState() { return 0; }
public int getAcWarmState() { return 0; }
public int getAcWarmTypeOnlineState() { return 0; }
public int getAcWindLevel() { return 0; }
public int getAcWindLevelManualSign() { return 0; }
public int getAcWindMode() { return 0; }
public int getAcWindModeManualSign() { return 0; }
public int getAcWindModeNum() { return 0; }
public int getAcWindModeShownState() { return 0; }
public int getAirQualityCtrlMenuState() { return 0; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getRearAcControlMode() { return 0; }
public int getRearAcLockState() { return 0; }
public int getRearAcMaxWindLevel() { return 0; }
public int getRearAcStartState() { return 0; }
public int getRearAcWindLevel() { return 0; }
public int getRearAcWindMode() { return 0; }
public int getTemperatureUnit() { return 0; }
public int getTemprature(int i) { return 0; }
public int getType() { return 0; }
public int getVoiceCmdResult() { return 0; }
public int hasFeature(String str) { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public int qurAcAllStatus() { return 0; }
public void registerListener(AbsBYDAutoAcListener absBYDAutoAcListener) { }
public int reset(int i, int i2) { return 0; }
public int setAcCompressorMode(int i, int i2) { return 0; }
public int setAcControlMode(int i, int i2) { return 0; }
public int setAcCycleMode(int i, int i2) { return 0; }
public int setAcDefrostState(int i, int i2, int i3) { return 0; }
public int setAcMaxCoolingState(int i) { return 0; }
public int setAcRemoteCtrlTime(int i) { return 0; }
public int setAcTemperature(int r7, int r8, int r9, int r10) { return 0; }
public int setAcTemperatureControlMode(int i, int i2) { return 0; }
public int setAcVentilationState(int i, int i2) { return 0; }
public int setAcWarmState(int i) { return 0; }
public int setAcWindLevel(int i, int i2) { return 0; }
public int setAcWindMode(int i, int i2) { return 0; }
public void setAllStatus() { }
public int setRearAcControlMode(int i, int i2) { return 0; }
public int setRearAcLockState(int i) { return 0; }
public int setRearAcWindLevel(int i, int i2) { return 0; }
public int setRearAcWindMode(int i, int i2) { return 0; }
public int start(int i) { return 0; }
public int startRearAc(int i) { return 0; }
public int stop(int i) { return 0; }
public int stopRearAc(int i) { return 0; }
public void unregisterListener(AbsBYDAutoAcListener absBYDAutoAcListener) { }
public void registerListener(AbsBYDAutoAcListener absBYDAutoAcListener, int[] iArr) { }
 }
