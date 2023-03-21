package android.hardware.bydauto.ac;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
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
    private static final String AC_COMMON_PERM = "android.permission.BYDAUTO_AC_COMMON";
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
    private static final String AC_GET_PERM = "android.permission.BYDAUTO_AC_GET";
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
    private static final String AC_SET_PERM = "android.permission.BYDAUTO_AC_SET";
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
    private static final boolean DEBUG = true;
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
    protected static final String TAG = "BYDAutoAcDevice";
    public static final int VOICE_AC_ALREADY_IN_MAX_TEMP = 5;
    public static final int VOICE_AC_ALREADY_IN_MIN_TEMP = 4;
    public static final int VOICE_CMD_INVALID = 0;
    public static final int VOICE_SET_INVALID_TEMP = 2;
    public static final int VOICE_SET_INVALID_WIND_LEVEL = 3;
    public static final int VOICE_START_AC_SUCCESS = 1;
    private static int mDeviceType = 1000;
    private static BYDAutoAcDevice mInstance;
    private final Context mContext;

    private BYDAutoAcDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoAcDevice getInstance(Context context) {
        BYDAutoAcDevice bYDAutoAcDevice;
        synchronized (BYDAutoAcDevice.class) {
            if (mInstance == null && context != null) {
                context.enforceCallingOrSelfPermission(AC_COMMON_PERM, null);
                mInstance = new BYDAutoAcDevice(context);
            }
            bYDAutoAcDevice = mInstance;
        }
        return bYDAutoAcDevice;
    }

    public int enablePurificationFunctionPrompt(int i) {
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        Log.d(TAG, "enablePurificationFunctionPrompt: enable is" + i);
        if (i != 1) {
            return -2147482645;
        }
        return super.set(mDeviceType, 36, i);
    }

    public int feelColdHot(int i, int i2) {
        int i3;
        Log.d(TAG, "feelColdHot whichAC = " + i + ", signal = " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i2 == 1 || i2 == 0) {
            if (i == 1) {
                i3 = 19;
            } else if (i != 2) {
                return -2147482645;
            } else {
                i3 = 20;
            }
            return super.set(mDeviceType, new int[]{i3, 26}, new int[]{i2, 1});
        }
        return -2147482645;
    }

    public int getAcCompressorManualSign() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 12);
        Log.d(TAG, "getAcCompressorManualSign sign is: " + i);
        return i;
    }

    public int getAcCompressorMode() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getAcCompressorMode mode is: " + i);
        return i;
    }

    public int getAcControlMode() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getAcControlMode mode is: " + i);
        return i;
    }

    public int getAcCycleMode() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getAcCycleMode mode is: " + i);
        return i;
    }

    public int getAcDefrostOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 45);
        Log.d(TAG, "getAcDefrostOnlineState state is: " + i);
        return i;
    }

    public int getAcDefrostState(int i) {
        int i2;
        Log.d(TAG, "getAcDefrostState area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        if (i == 1) {
            i2 = super.get(mDeviceType, 10);
        } else if (i != 2) {
            return -2147482645;
        } else {
            i2 = super.get(mDeviceType, 11);
        }
        Log.d(TAG, "getAcDefrostState state is: " + i2);
        return i2;
    }

    public int getAcFaultNumShownState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 22);
        Log.d(TAG, "getAcFaultNumShownState state is: " + i);
        return i;
    }

    public int getAcKeyActionState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 27);
        Log.d(TAG, "getAcKeyActionState state is: " + i);
        return i;
    }

    public int getAcMaxCoolingState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 16);
        Log.d(TAG, "getAcMaxCoolingState state is: " + i);
        return i;
    }

    public int getAcOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 17);
        Log.d(TAG, "AC getAcOnlineState state is: " + i);
        return i;
    }

    public int getAcPromptBoxShownState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 21);
        Log.d(TAG, "getAcPromptBoxShownState state is: " + i);
        return i;
    }

    public int getAcPtcPreheatSignal() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 41);
        Log.d(TAG, "getAcPtcPreheatSignal value is: " + i);
        return i;
    }

    public int getAcRemoteCtrlTime() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 39);
        Log.d(TAG, "getAcRemoteCtrlTime value is: " + i);
        return i;
    }

    public int getAcStartState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 0);
        Log.d(TAG, "AC getAcStartState state is: " + i);
        return i;
    }

    public int getAcSubBatteryTemperature() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 52);
        Log.d(TAG, "getAcSubBatteryTemperature state is: " + i);
        return i;
    }

    public int getAcTemperatureControlMode() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 8);
        Log.d(TAG, "getAcTemperatureControlMode mode is: " + i);
        return i;
    }

    public int getAcType() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 40);
        Log.d(TAG, "getAcType type is: " + i);
        return i;
    }

    public int getAcVentilationState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 18);
        Log.d(TAG, "getAcVentilationState state is: " + i);
        return i;
    }

    public int getAcWarmState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 50);
        Log.d(TAG, "getAcWarmState state is: " + i);
        return i;
    }

    public int getAcWarmTypeOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 49);
        Log.d(TAG, "getAcWarmTypeOnlineState state is: " + i);
        return i;
    }

    public int getAcWindLevel() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getAcWindLevel value is: " + i);
        return i;
    }

    public int getAcWindLevelManualSign() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 13);
        Log.d(TAG, "getAcWindLevelManualSign sign is: " + i);
        return i;
    }

    public int getAcWindMode() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 4);
        Log.d(TAG, "getAcWindMode mode is: " + i);
        return i;
    }

    public int getAcWindModeManualSign() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 14);
        Log.d(TAG, "getAcWindModeManualSign sign is: " + i);
        return i;
    }

    public int getAcWindModeNum() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 43);
        Log.d(TAG, "getAcWindModeNum is: " + i);
        return i;
    }

    public int getAcWindModeShownState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 23);
        Log.d(TAG, "getAcWindModeShownState state is: " + i);
        return i;
    }

    public int getAirQualityCtrlMenuState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 24);
        Log.d(TAG, "getAirQualityCtrlMenuState state is: " + i);
        return i;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getRearAcControlMode() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 32);
        Log.d(TAG, "getRearAcControlMode: mode is: " + i);
        return i;
    }

    public int getRearAcLockState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 33);
        Log.d(TAG, "getRearAcLockState state is: " + i);
        return i;
    }

    public int getRearAcMaxWindLevel() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 37);
        Log.d(TAG, "getRearAcMaxWindLevel value is: " + i);
        return i;
    }

    public int getRearAcStartState() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 29);
        Log.d(TAG, "AC getRearAcStartState state is: " + i);
        return i;
    }

    public int getRearAcWindLevel() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 31);
        Log.d(TAG, "getRearAcWindLevel value is: " + i);
        return i;
    }

    public int getRearAcWindMode() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 30);
        Log.d(TAG, "getRearAcWindMode mode is: " + i);
        return i;
    }

    public int getTemperatureUnit() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 15);
        Log.d(TAG, "getTemperatureUnit unit is: " + i);
        return i;
    }

    public int getTemprature(int i) {
        int i2;
        Log.d(TAG, "getTemprature area is: " + i);
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        if (i == 1) {
            i2 = super.get(mDeviceType, 5);
        } else if (i == 2) {
            i2 = super.get(mDeviceType, 6);
        } else if (i == 3) {
            i2 = super.get(mDeviceType, 25);
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = super.get(mDeviceType, 7);
        }
        Log.d(TAG, "getTemprature temprature is: " + i2);
        return i2;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1000;
    }

    public int getVoiceCmdResult() {
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        int i = super.get(mDeviceType, 34);
        Log.d(TAG, "getVoiceCmdResult result is: " + i);
        return i;
    }

    public int hasFeature(String str) {
        int i;
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        if (str.equals(FEATURE_AC_AUTO_MODE)) {
            i = 35;
        } else if (str.equals(FEATURE_AC_REMOTE_CTL)) {
            i = 38;
        } else if (!str.equals(FEATURE_AC_DEFROST)) {
            return -2147482645;
        } else {
            i = 44;
        }
        int i2 = super.get(mDeviceType, i);
        Log.d(TAG, "hasFeature: If has the feature(" + str + "): " + i2);
        return i2;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public int qurAcAllStatus() {
        Log.d(TAG, "qurAcAllStatus.");
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        return super.set(mDeviceType, 28, 28);
    }

    public void registerListener(AbsBYDAutoAcListener absBYDAutoAcListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        if (absBYDAutoAcListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoAcListener);
        }
    }

    public int reset(int i, int i2) {
        Log.d(TAG, "resetAC item is: " + i + " and value is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if ((i2 == 0 || i2 == 1) && i == 0) {
            return super.set(mDeviceType, 42, i2);
        }
        return -2147482645;
    }

    public int setAcCompressorMode(int i, int i2) {
        Log.d(TAG, "setAcCompressorMode mode is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            if (i2 != 1 && i2 != 0) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{9, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int setAcControlMode(int i, int i2) {
        Log.d(TAG, "setAcControlMode changed ");
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            if (i2 != 0 && i2 != 1) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{1, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int setAcCycleMode(int i, int i2) {
        Log.d(TAG, "setAcCycleMode mode is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            if (i2 != 1 && i2 != 0) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{2, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int setAcDefrostState(int i, int i2, int i3) {
        int i4;
        Log.d(TAG, "setAcDefrostState source is: " + i + ", area is: " + i2 + ", state is: " + i3);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if ((i == 1 || i == 0) && (i3 == 0 || i3 == 1)) {
            if (i2 == 1) {
                i4 = 10;
            } else if (i2 != 2) {
                return -2147482645;
            } else {
                i4 = 11;
            }
            return super.set(mDeviceType, new int[]{i4, 26}, new int[]{i3, i});
        }
        return -2147482645;
    }

    public int setAcMaxCoolingState(int i) {
        Log.d(TAG, "setAcMaxCoolingState state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 16, i);
        }
        return -2147482645;
    }

    public int setAcRemoteCtrlTime(int i) {
        Log.d(TAG, "setAcRemoteCtrlTime value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i < 1 || i > 5) {
            return -2147482645;
        }
        return super.set(mDeviceType, 39, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0068, code lost:
        if (r8 <= 33) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setAcTemperature(int r7, int r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.bydauto.ac.BYDAutoAcDevice.setAcTemperature(int, int, int, int):int");
    }

    public int setAcTemperatureControlMode(int i, int i2) {
        Log.d(TAG, "setAcTemperatureControlMode mode is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            if (i2 != 0 && i2 != 1) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{8, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int setAcVentilationState(int i, int i2) {
        Log.d(TAG, "setAcVentilationState state is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            if (i2 != 0 && i2 != 1) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{18, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int setAcWarmState(int i) {
        Log.d(TAG, "setAcWarmState state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i < 0 || i > 2) {
            return -2147482645;
        }
        return super.set(mDeviceType, 50, i);
    }

    public int setAcWindLevel(int i, int i2) {
        Log.d(TAG, "setAcWindLevel level is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if ((i == 1 || i == 0) && i2 >= 0 && i2 <= 7) {
            return super.set(mDeviceType, new int[]{3, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int setAcWindMode(int i, int i2) {
        Log.d(TAG, "setAcWindMode mode is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if ((i == 1 || i == 0) && i2 >= 1 && i2 <= 7) {
            return super.set(mDeviceType, new int[]{4, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public void setAllStatus() {
    }

    public int setRearAcControlMode(int i, int i2) {
        Log.d(TAG, "setRearAcControlMode: mode = " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            if (i2 != 0 && i2 != 1) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{32, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int setRearAcLockState(int i) {
        Log.d(TAG, "setRearAcLockState state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (1 == i || i == 0) {
            return super.set(mDeviceType, 33, i);
        }
        return -2147482645;
    }

    public int setRearAcWindLevel(int i, int i2) {
        Log.d(TAG, "setRearAcWindLevel level is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if ((i == 1 || i == 0) && i2 >= 0 && i2 <= 7) {
            return super.set(mDeviceType, new int[]{31, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int setRearAcWindMode(int i, int i2) {
        Log.d(TAG, "setRearAcWindMode mode is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if ((i == 1 || i == 0) && i2 >= 1 && i2 <= 5) {
            return super.set(mDeviceType, new int[]{30, 26}, new int[]{i2, i});
        }
        return -2147482645;
    }

    public int start(int i) {
        Log.d(TAG, "start setSource is:" + i);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, new int[]{0, 26}, new int[]{1, i});
        }
        Log.d(TAG, "the input setSource is out of scope,return");
        return -2147482645;
    }

    public int startRearAc(int i) {
        Log.d(TAG, "startRearAc.");
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, new int[]{29, 26}, new int[]{1, i});
        }
        Log.d(TAG, "the input setSource is out of scope,return");
        return -2147482645;
    }

    public int stop(int i) {
        Log.d(TAG, "stop setSource is: " + i);
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, new int[]{0, 26}, new int[]{0, i});
        }
        Log.d(TAG, "the input setSource is out of scope,return");
        return -2147482645;
    }

    public int stopRearAc(int i) {
        Log.d(TAG, "stopRearAc.");
        this.mContext.enforceCallingOrSelfPermission(AC_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, new int[]{29, 26}, new int[]{0, i});
        }
        Log.d(TAG, "the input setSource is out of scope,return");
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoAcListener absBYDAutoAcListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        if (absBYDAutoAcListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoAcListener);
        }
    }

    public void registerListener(AbsBYDAutoAcListener absBYDAutoAcListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(AC_GET_PERM, null);
        if (absBYDAutoAcListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoAcListener, iArr);
        }
    }
}
