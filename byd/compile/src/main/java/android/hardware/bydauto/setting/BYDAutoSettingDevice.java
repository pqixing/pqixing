package android.hardware.bydauto.setting;

import android.cdrservice.IBYDCDRService;
import android.content.Context;
import android.content.Intent;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoSettingDevice extends AbsBYDAutoDevice {
    public static final int ATMP_RESET = 204;
    public static final int AUTO_LOCK_TIME = 120;
    public static final int AUTO_LOCK_TIME_30S = 1;
    public static final int AUTO_LOCK_TIME_60S = 2;
    public static final int AUTO_RAIN_WIPER_INVALID = 0;
    public static final int AUTO_RAIN_WIPER_OFF = 2;
    public static final int AUTO_RAIN_WIPER_ON = 1;
    public static final int AUTO_RAIN_WIPER_ONLINE = 212;
    public static final int AUTO_RAIN_WIPER_SWITCH = 213;
    public static final int BACK_DOOR_OPENED_HEIGHT_MAX = 100;
    public static final int BACK_DOOR_OPENED_HEIGHT_MIN = 15;
    public static final int BACK_DOOR_OPEN_HEIGHT = 106;
    public static final int BACK_LIGHT_RESET = 206;
    public static final int BT_CALL_REDUCTION_WIND_MENU = 138;
    public static final int BT_CALL_REDUCTION_WIND_MENU_OFF = 0;
    public static final int BT_CALL_REDUCTION_WIND_MENU_ON = 1;
    public static final int BT_CALL_STATE_BE_CALLED = 2;
    public static final int BT_CALL_STATE_CALL_SOMEBODY = 1;
    public static final int BT_CALL_STATE_DEFAULT = 0;
    public static final int BT_CALL_STATE_IGNORED = 4;
    public static final int BT_CALL_STATE_OVER = 5;
    public static final int BT_CALL_STATE_TALKING = 3;
    public static final int BT_LOW_POWER_MODE_ENTER = 1;
    public static final int BT_LOW_POWER_MODE_EXIT = 2;
    public static final int BT_LOW_POWER_MODE_INVALID = 0;
    public static final int CAR_EXTREARMIR_FOLLOWUP_SWITCH = 118;
    public static final int CMD_BTCALL_STATE = 210;
    public static final int CMD_BT_KEY_MAC = 228;
    public static final int CMD_BT_LOW_POWER_MODE = 229;
    public static final int CMD_BT_MAC_ADDR = 230;
    public static final int CMD_HEADLAMP_HEIGHT_LEVEL = 215;
    public static final int CMD_LEFT_HEAD_LIGHT_LEVEL = 226;
    public static final int CMD_RIGHT_HEAD_LIGHT_LEVEL = 227;
    public static final int CMD_WHEEL_DOOR_KEY = 209;
    public static final int COURTESY_LAMP_TIME = 123;
    public static final int COURTESY_LAMP_TIME_15S = 3;
    public static final int COURTESY_LAMP_TIME_30S = 4;
    public static final int COURTESY_LAMP_TIME_7P5S = 2;
    public static final int COURTESY_LAMP_TIME_OFF = 1;
    private static final boolean DEBUG = true;
    public static final int DEVICE_HAS_THE_FEATURE = 1;
    public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
    public static final int DM20_SOC_TARGET_MIN = 15;
    public static final int DM25_SOC_TARGET_MIN = 25;
    public static final int DOOR_WINDOW_RESET = 200;
    public static final int DRIVER_SEAT = 1;
    public static final int DRIVER_SEAT_HEATING_STATE = 187;
    public static final int DRIVER_SEAT_HEATING_STATE1 = 198;
    public static final int DRIVER_SEAT_VENTILATING_STATE = 188;
    public static final int DRIVE_CONFIG_EV_FOUR_WHEEL = 4;
    public static final int DRIVE_CONFIG_FOUR_WHEEL = 2;
    public static final int DRIVE_CONFIG_FRONT = 1;
    public static final int DRIVE_CONFIG_REAR = 3;
    public static final int DRIVE_CONFIG_TYPE = 195;
    public static final int DRIVING_RECORDER_PICTURE = 155;
    public static final int ENGINEOIL_EXIT_UPDATE = 156;
    public static final int ENGINE_OIL_LEVEL = 151;
    public static final int ENGINE_OIL_LEVEL_1P8_MIN = 2;
    public static final int ENGINE_OIL_LEVEL_2P8_MIN = 3;
    public static final int ENGINE_OIL_LEVEL_3P8_MIN = 4;
    public static final int ENGINE_OIL_LEVEL_4P8_MIN = 5;
    public static final int ENGINE_OIL_LEVEL_5P8_MIN = 6;
    public static final int ENGINE_OIL_LEVEL_6P8_MIN = 7;
    public static final int ENGINE_OIL_LEVEL_7P8_MIN = 8;
    public static final int ENGINE_OIL_LEVEL_BELOW_MIN = 0;
    public static final int ENGINE_OIL_LEVEL_CONFIG = 255;
    public static final int ENGINE_OIL_LEVEL_FAULT = 13;
    public static final int ENGINE_OIL_LEVEL_MAX = 9;
    public static final int ENGINE_OIL_LEVEL_MEASUREMENT = 11;
    public static final int ENGINE_OIL_LEVEL_MIN = 1;
    public static final int ENGINE_OIL_LEVEL_OIL_OK = 12;
    public static final int ENGINE_OIL_LEVEL_OVERFILL = 10;
    public static final int ENGINE_OIL_ONLINE = 150;
    public static final int ENGINE_OIL_UPDATE_SIGNAL = 152;
    public static final int ENGINE_OIL_UPDATE_SIGNAL_NO = 0;
    public static final int ENGINE_OIL_UPDATE_SIGNAL_YES = 1;
    public static final int EXIT_UPDATE = 1;
    public static final int FACTORY_RESET_ALL = 122;
    public static final int FACTORY_RESET_DISABLE = 2;
    public static final int FACTORY_RESET_ENABLE = 1;
    public static final String FEATURE_AUTO_RAIN_WIPER = "AutoRainWiper";
    public static final String FEATURE_BACK_DOOR = "BackDoor";
    public static final String FEATURE_BT_CALL_REDUCTION_WIND = "BTCallReductionWind";
    public static final String FEATURE_DRIVER_SEAT_HEATING = "DriverSeatHeating";
    public static final String FEATURE_DRIVER_SEAT_HEATING_LEVEL1 = "DriverSeatHeatingLevel1";
    public static final String FEATURE_DRIVER_SEAT_VENTILATING = "DriverSeatVentilating";
    public static final String FEATURE_DRIVING_RECORDER = "DrivingRecorder";
    public static final String FEATURE_ENGINE_OIL_DETECTION = "EngineOilDetection";
    public static final String FEATURE_FOUR_WHEEL_DRIVE = "FourWheelDrive";
    public static final String FEATURE_FRONT_WINDSCREEN_WIPER_OVERHAUL = "FrontWindscreenWiperOverhaul";
    public static final String FEATURE_INSIDE_LIGHT = "InsideLight";
    public static final String FEATURE_INTERIOR_ATMOSPHERE_LAMP = "InteriorAtmosphereLamp";
    public static final String FEATURE_OVERSPEED_LOCKING = "OverspeedLocking";
    public static final String FEATURE_PARKING_AUTO_INNER_LOOP = "ParkingAutoInnerLoop";
    public static final String FEATURE_PASSENGER_SEAT_HEATING = "PassengerSeatHeating";
    public static final String FEATURE_PASSENGER_SEAT_HEATING_LEVEL1 = "PassengerSeatHeatingLevel1";
    public static final String FEATURE_PASSENGER_SEAT_VENTILATING = "PassengerSeatVentilating";
    public static final String FEATURE_POWER_STEERING = "PowerSteering";
    public static final String FEATURE_REARVIEW_MIRROR_FOLLOW_UP = "RearviewMirrorFollowUp";
    public static final String FEATURE_REAR_LEFT_SEAT_HEATING = "RearLeftSeatHeating";
    public static final String FEATURE_REAR_LEFT_SEAT_VENTILATING = "RearLeftSeatVentilating";
    public static final String FEATURE_REAR_RIGHT_SEAT_HEATING = "RearRightSeatHeating";
    public static final String FEATURE_REAR_RIGHT_SEAT_VENTILATING = "RearRightSeatVentilating";
    public static final String FEATURE_REAR_WINDSCREEN_WIPER_OVERHAUL = "RearWindscreenWiperOverhaul";
    public static final String FEATURE_SEAT_HEATING_AND_VENTILATING = "SeatHeatingAndVentilating";
    public static final String FEATURE_TUNNEL_AUTO_INNER_LOOP = "TunnelAutoInnerLoop";
    public static final int FRONT_WINDSCREEN_WIPER = 1;
    public static final int FRONT_WINDSCREEN_WIPER_OVERHAUL_STATE = 136;
    private static final String GET_PANARAMA_CAMERA = "vehicle.config.cam_sort";
    public static final int HAS_BT_CALL_REDUCTION_WIND = 130;
    public static final int HAS_DRIVER_SEAT_HEATING = 179;
    public static final int HAS_DRIVER_SEAT_HEATING1 = 196;
    public static final int HAS_DRIVER_SEAT_VENTILATING = 180;
    public static final int HAS_FOUR_WHEEL_DRIVE = 153;
    public static final int HAS_FRONT_WINDSCREEN_WIPER_OVERHAUL = 131;
    public static final int HAS_INTERIOR_ATMOSPHERE_LAMP = 91;
    public static final int HAS_OVERSPEED_LOCKING = 101;
    public static final int HAS_PARKING_AUTO_INNER_LOOP = 133;
    public static final int HAS_PASSENGER_SEAT_HEATING = 181;
    public static final int HAS_PASSENGER_SEAT_HEATING1 = 197;
    public static final int HAS_PASSENGER_SEAT_VENTILATING = 182;
    public static final int HAS_POWER_STEERING = 139;
    public static final int HAS_REAR_LEFT_SEAT_HEATING = 183;
    public static final int HAS_REAR_LEFT_SEAT_VENTILATING = 184;
    public static final int HAS_REAR_RIGHT_SEAT_HEATING = 185;
    public static final int HAS_REAR_RIGHT_SEAT_VENTILATING = 186;
    public static final int HAS_REAR_WINDSCREEN_WIPER_OVERHAUL = 132;
    public static final int HAS_SEAT_HEATING_AND_VENTILATING = 96;
    public static final int HAS_SOC_TARGET = 163;
    public static final int HAS_TUNNEL_AUTO_INNER_LOOP = 134;
    public static final int HAVE_REARVIEW_MIRROR_AUTO_FOLD = 211;
    public static final int HEADLAMP_HEIGHT_LEVEL_INVALID = 0;
    public static final int HEADLAMP_HEIGHT_LEVEL_MAX = 11;
    public static final int HEADLAMP_HEIGHT_LEVEL_MIN = 1;
    public static final int IAL_ALL_BRIGHTNESS = 174;
    public static final int IAL_ALL_COLOR = 175;
    public static final int IAL_AREA_ALL_ROW = 3;
    public static final int IAL_AREA_BACK_ROW = 2;
    public static final int IAL_AREA_FRONT_ROW = 1;
    private static final int IAL_AREA_INVALID = 0;
    public static final int IAL_BACK_BRIGHTNESS = 172;
    public static final int IAL_BACK_COLOR = 173;
    private static final int IAL_BRIGHTNESS_INVALID = 0;
    public static final int IAL_BRIGHTNESS_MAX = 5;
    public static final int IAL_BRIGHTNESS_MIN = 0;
    public static final int IAL_COLD_WHITE = 2;
    private static final int IAL_COLOR_INVALID = 0;
    public static final int IAL_CTRL_SOURCE_UI = 0;
    public static final int IAL_CTRL_SOURCE_VOICE = 1;
    public static final int IAL_DARK_BLUE = 7;
    public static final int IAL_FRONT_BRIGHTNESS = 170;
    public static final int IAL_FRONT_COLOR = 171;
    public static final int IAL_ICE_BLUE = 1;
    public static final int IAL_RED_ORANGE = 4;
    public static final int IAL_RED_PURPLE = 6;
    public static final int IAL_TRUE_RED = 5;
    public static final int IAL_WARM_WHITE = 3;
    public static final int IL_DURATION_15_S = 3;
    public static final int IL_DURATION_30_S = 4;
    public static final int IL_DURATION_7p5_S = 2;
    public static final int IL_DURATION_OFF = 1;
    public static final int INSIDE_LIGHT_DOOR_CLOSE = 2;
    public static final int INSIDE_LIGHT_DOOR_INVALID = 0;
    public static final int INSIDE_LIGHT_DOOR_OPEN = 1;
    public static final int INSIDE_LIGHT_DOOR_STATE = 177;
    public static final int INSIDE_LIGHT_ONLINE = 176;
    public static final int INSIDE_LIGHT_STATE = 178;
    public static final int INSIGHT_LIGHT_OFF = 1;
    public static final int INSIGHT_LIGHT_ON = 2;
    public static final int INSTRUMENT_BACKLIGHT_CTL_TYPE = 207;
    public static final int INSTRUMENT_BACKLIGHT_CTL_TYPE_N = 1;
    public static final int INSTRUMENT_BACKLIGHT_CTL_TYPE_R = 0;
    public static final int INS_THEME_VALUE = 111;
    public static final int INTERIOR_ATMOSPHERE_LAMP_AREA = 94;
    public static final int INTERIOR_ATMOSPHERE_LAMP_BRIGHTNESS = 93;
    public static final int INTERIOR_ATMOSPHERE_LAMP_COLOR = 92;
    public static final int INTERIOR_ATMOSPHERE_LAMP_SOURCE = 169;
    public static final int INTERIOR_LAMP_DURATION = 95;
    public static final int LANGUAGE_TYPE = 108;
    public static final int LOCK_RESET = 201;
    public static final int MAINTAIN_REMIND_STATE = 110;
    public static final int MCU_PH2_STATE_H = 1;
    public static final int MCU_PH2_STATE_L = 0;
    public static final int MULTIMEDIA_ELECTRIC_MOTOR_TEMP = 157;
    public static final int MULTIMEDIA_MOTOR_TEMP_NORMAL = 1;
    public static final int MULTIMEDIA_MOTOR_TEMP_OVERHEAT = 2;
    public static final int NIGHT_DRIVE_LIGHT_ON_REMINDER = 135;
    public static final int NIGHT_DRIVE_LIGHT_ON_REMINDER_OFF = 0;
    public static final int NIGHT_DRIVE_LIGHT_ON_REMINDER_ON = 1;
    public static final int OVERSPEED_LOCKING_OFF = 0;
    public static final int OVERSPEED_LOCKING_ON = 1;
    public static final int OVERSPEED_LOCKING_STATE = 102;
    public static final int PAD_ROTATION = 154;
    public static final int PASSENGER_SEAT = 2;
    public static final int PASSENGER_SEAT_HEATING_STATE = 189;
    public static final int PASSENGER_SEAT_HEATING_STATE1 = 199;
    public static final int PASSENGER_SEAT_VENTILATING_STATE = 190;
    public static final int QUERY_ALL_STATE = 56;
    public static final int READING_LIGHT_RESET = 205;
    public static final int REARVIEW_MIRROR_AUTO_FOLD_INVALID = 0;
    public static final int REARVIEW_MIRROR_AUTO_FOLD_NO = 1;
    public static final int REARVIEW_MIRROR_AUTO_FOLD_YES = 2;
    public static final int REAR_LEFT_SEAT = 3;
    public static final int REAR_LEFT_SEAT_HEATING_STATE = 191;
    public static final int REAR_LEFT_SEAT_VENTILATING_STATE = 192;
    public static final int REAR_MIRROR_RESET = 203;
    public static final int REAR_RIGHT_SEAT = 4;
    public static final int REAR_RIGHT_SEAT_HEATING_STATE = 193;
    public static final int REAR_RIGHT_SEAT_VENTILATING_STATE = 194;
    public static final int REAR_WINDSCREEN_WIPER = 2;
    public static final int REAR_WINDSCREEN_WIPER_OVERHAUL_STATE = 137;
    public static final int REMOTE_CONTROL_UNLOCKING = 121;
    public static final int REMOTE_CONTROL_UNLOCKING_OFF = 0;
    public static final int REMOTE_CONTROL_UNLOCKING_ON = 1;
    public static final int REQUEST_UPDATE = 0;
    public static final int RESET_INVALID = 0;
    public static final int RESET_ITEM_ATMP = 4;
    public static final int RESET_ITEM_BACK_LIGHT = 6;
    public static final int RESET_ITEM_DOOR_WINDOW = 0;
    public static final int RESET_ITEM_LOCK = 1;
    public static final int RESET_ITEM_READING_LIGHT = 5;
    public static final int RESET_ITEM_REAR_MIRROR = 3;
    public static final int RESET_ITEM_SEAT_SELF_RETURN = 2;
    public static final int RESET_VALID = 1;
    public static final int RESTORE_CAR_DEFAULT_VALUES = 54;
    public static final int RESTORE_DEFAULT_VALUES = 0;
    public static final int RESTORE_DR_DEFAULT_VALUES = 53;
    public static final int ROTATION_HORIZONTAL = 1;
    public static final int ROTATION_VERTICAL = 2;
    public static final int SAFE_WARN_STATE = 109;
    public static final int SEAT_HEATING_HIGH = 3;
    public static final int SEAT_HEATING_LEVEL1_OFF = 1;
    public static final int SEAT_HEATING_LEVEL1_ON = 2;
    public static final int SEAT_HEATING_LOW = 2;
    public static final int SEAT_HEATING_OFF = 1;
    public static final int SEAT_SELF_RETURN_RESET = 202;
    public static final int SEAT_VENTILATING_HIGH = 3;
    public static final int SEAT_VENTILATING_LOW = 2;
    public static final int SEAT_VENTILATING_OFF = 1;
    public static final int SETTING_COMMAND_BUSY = -2147482647;
    public static final int SETTING_COMMAND_FAILED = -2147482648;
    public static final int SETTING_COMMAND_INVALID = -2147482645;
    public static final int SETTING_COMMAND_SUCCESS = 0;
    public static final int SETTING_COMMAND_TIMEOUT = -2147482646;
    private static final String SETTING_COMMON_PERM = "android.permission.BYDAUTO_SETTING_COMMON";
    static final String SETTING_GET_PERM = "android.permission.BYDAUTO_SETTING_GET";
    static final String SETTING_SET_PERM = "android.permission.BYDAUTO_SETTING_SET";
    public static final int SET_AC_AUTO_AIR = 4;
    public static final int SET_AC_AUTO_AIR_COMFORT = 2;
    public static final int SET_AC_AUTO_AIR_ECONOMY = 1;
    public static final int SET_AC_AUTO_WIND_LV = 5;
    public static final int SET_AC_AUTO_WIND_LV_LARGE = 3;
    public static final int SET_AC_AUTO_WIND_LV_MEDIUM = 2;
    public static final int SET_AC_AUTO_WIND_LV_SMALL = 1;
    public static final int SET_AC_BT = 1;
    public static final int SET_AC_PAUSE_CYCLE = 3;
    public static final int SET_AC_TUNNEL_CYCLE = 2;
    public static final int SET_ALL_INTERFACE_SETTINGS_AND_KEY = 3;
    public static final int SET_ALL_INTERFACE_SETTINGS_NO_KEY = 2;
    public static final int SET_BACKLIGHT_NIGHTMODE = 165;
    public static final int SET_CALL_STATE = 140;
    public static final int SET_CAR_AUTO_LOCK = 33;
    public static final int SET_CAR_AUTO_LOCK_DET = 69;
    public static final int SET_CAR_AUTO_PANORAMA = 20;
    public static final int SET_CAR_BACK_DOOR_ELECTRIC_MODE = 84;
    public static final int SET_CAR_BACK_DOOR_ELECTRIC_MODE_DET = 83;
    public static final int SET_CAR_BACK_HOME_LIGHT_DELAY = 34;
    public static final int SET_CAR_BACK_HOME_LIGHT_DELAY_VALUE = 35;
    public static final int SET_CAR_BACK_ROW = 119;
    public static final int SET_CAR_BASE_PAD_AUTO_RISE = 73;
    public static final int SET_CAR_BASE_PAD_AUTO_RISE_DET = 74;
    public static final int SET_CAR_CTRL_WINDOW = 30;
    public static final int SET_CAR_DOOR_LOCK = 39;
    public static final int SET_CAR_DRIVER_SEATBK_DET = 67;
    public static final int SET_CAR_DRIVING_RECORD_SWITCH = 75;
    public static final int SET_CAR_DRVING_RECORD_DET = 70;
    public static final int SET_CAR_DUAL_TEMP_AREA_AC_DET = 82;
    public static final int SET_CAR_DVR_RECORD = 40;
    public static final int SET_CAR_DV_AUTO_RETURN = 22;
    public static final int SET_CAR_ELEC_HANDBRAKE_DET = 80;
    public static final int SET_CAR_EXT_REARVIEW_MIRROR_AUTO_FOLD = 16;
    public static final int SET_CAR_EXT_REARVIEW_MIRROR_AUTO_FOLD_DET = 85;
    public static final int SET_CAR_EX_MIRROW_FOLD = 19;
    public static final int SET_CAR_FORMAT_MEMORY_CARD = 78;
    public static final int SET_CAR_HOME_LIGHT_DET = 65;
    public static final int SET_CAR_HOME_OFF_LIGHT_DET = 66;
    public static final int SET_CAR_INSIDE_REAR_MIRROR_SCREEN = 77;
    public static final int SET_CAR_INSIDE_REAR_MIRROR_SCREEN_SWITCH = 76;
    public static final int SET_CAR_LEFT_HOME_LIGHT_DELAY = 36;
    public static final int SET_CAR_LEFT_HOME_LIGHT_DELAY_VALUE = 37;
    public static final int SET_CAR_LIGHT_DELAY_VALUE_MAX = 60;
    public static final int SET_CAR_LIGHT_DELAY_VALUE_MIN = 0;
    public static final int SET_CAR_LIGHT_NIGHT = 13;
    public static final int SET_CAR_LOCK_AUTO_WINDOW_DET = 61;
    public static final int SET_CAR_LOCK_CLOSEWINDOW = 31;
    public static final int SET_CAR_LOCK_OFF = 89;
    public static final int SET_CAR_LOCK_OFF_4DOORS = 0;
    public static final int SET_CAR_LOCK_OFF_DR_SIDE = 1;
    public static final int SET_CAR_LOCK_REPLAY_VIDEO = 79;
    public static final int SET_CAR_LPSWITCH_DNWINDOW_DET = 64;
    public static final int SET_CAR_LPSWITCH_UPWINDOW_DET = 63;
    public static final int SET_CAR_LPUNLOCKWINDOW = 32;
    public static final int SET_CAR_L_VIEW = 17;
    public static final int SET_CAR_MICRO_SWITCH_LOCK_WINDOW = 72;
    public static final int SET_CAR_NIGHT_SYS = 28;
    public static final int SET_CAR_PANORAMIC_SUNROOF_DET = 90;
    public static final int SET_CAR_PEDESTRAIN_RECOGNIZE = 29;
    public static final int SET_CAR_PM25_CTRL = 27;
    public static final int SET_CAR_PM25_POWER = 24;
    public static final int SET_CAR_PM25_SW_CHECK = 25;
    public static final int SET_CAR_PM25_TIME = 26;
    public static final int SET_CAR_REAR_AC_DET = 81;
    public static final int SET_CAR_REAR_MIRROR_FLIP_DET = 58;
    public static final int SET_CAR_REAR_VIEW = 86;
    public static final int SET_CAR_REAR_VIEW_FLIP_ANGLE_MAX = 8;
    public static final int SET_CAR_REAR_VIEW_FLIP_ANGLE_MIN = 0;
    public static final int SET_CAR_REMOTE_CTRL_UPWINDOW = 71;
    public static final int SET_CAR_REMOTE_DRIVING_DET = 87;
    public static final int SET_CAR_R_VIEW = 18;
    public static final int SET_CAR_SAFE_DR = 115;
    public static final int SET_CAR_SPEECH_HINT = 112;
    public static final int SET_CAR_SPEECH_VOL = 113;
    public static final int SET_CAR_SPEECH_VOL_HIGH = 3;
    public static final int SET_CAR_SPEECH_VOL_LOW = 1;
    public static final int SET_CAR_SPEECH_VOL_MEDIUM = 2;
    public static final int SET_CAR_STEER_BACK_DET = 68;
    public static final int SET_CAR_ST_AUTO_RETURN = 23;
    public static final int SET_CAR_TELECTRL_DNWINDOW_DET = 60;
    public static final int SET_CAR_TELECTRL_UPWINDOW_DET = 59;
    public static final int SET_CAR_UNLOCK_AUTO_WINDOW_DET = 62;
    public static final int SET_CAR_UNLOCK_SETTING_DET = 88;
    public static final int SET_CAR_WARN = 12;
    public static final int SET_DR_CHARGER_PORT = 8;
    public static final int SET_DR_ENERGY_FB = 6;
    public static final int SET_DR_ENERGY_FB_LARGE = 2;
    public static final int SET_DR_ENERGY_FB_STANDARD = 1;
    public static final int SET_DR_SOC_TARGET = 7;
    public static final int SET_DR_SOC_TARGET_MAX = 70;
    public static final int SET_DR_SOC_TARGET_MIN = 15;
    public static final int SET_DR_ST_ASSIS = 9;
    public static final int SET_DR_ST_ASSIS_COMFORT = 1;
    public static final int SET_DR_ST_ASSIS_SPORT = 2;
    public static final int SET_DR_SWITCH_FAIL = 0;
    public static final int SET_DR_SWITCH_FAIL_WHILE_LOCKING = 2;
    public static final int SET_DR_SWITCH_SUCCESS = 1;
    public static final int SET_EPS_PERMISSION = 166;
    public static final int SET_INSIDE_REAR_SCREEN_COMPASS = 2;
    public static final int SET_INSIDE_REAR_SCREEN_OFF = 3;
    public static final int SET_INSIDE_REAR_SCREEN_VIDEO_RECORDING = 1;
    public static final int SET_INS_THEME_MAX = 10;
    public static final int SET_INS_THEME_MIN = 1;
    public static final int SET_INVALID = 255;
    public static final int SET_LANGUAGE_ARABIC = 5;
    public static final int SET_LANGUAGE_COMPLEX_CHINESE = 2;
    public static final int SET_LANGUAGE_ENGLISH = 3;
    public static final int SET_LANGUAGE_RUSSIAN = 4;
    public static final int SET_LANGUAGE_SIMPLE_CHINESE = 1;
    public static final int SET_MMS_AUTO_TIME = 116;
    public static final int SET_MMS_BELT = 45;
    public static final int SET_MMS_DOOR_CLOSE = 44;
    public static final int SET_MMS_FREE_P = 43;
    public static final int SET_MMS_KEY_LOW = 47;
    public static final int SET_MMS_LEAVE_P = 46;
    public static final int SET_MMS_LOW_BAT = 51;
    public static final int SET_MMS_LOW_OIL = 50;
    public static final int SET_MMS_MIS_KEY = 48;
    public static final int SET_MMS_NIGHT_DR = 49;
    public static final int SET_MMS_START_F = 42;
    public static final int SET_MMS_STOP_REMOTECTRL_DRIVE = 52;
    public static final int SET_NO_DETECT = 0;
    public static final int SET_NO_INTERFACE_ALL_SETTINGS = 0;
    public static final int SET_OFF = 0;
    public static final int SET_ON = 1;
    public static final int SET_ONLINE = 1;
    public static final int SET_ONLY_RECORD = 1;
    public static final int SET_PM25_SWITCH_OFF_ALL = 0;
    public static final int SET_PM25_SWITCH_ON_ALL = 3;
    public static final int SET_PM25_SWITCH_ON_IN = 1;
    public static final int SET_PM25_SWITCH_ON_OUT = 2;
    public static final int SET_STEER_ASSIST_FORBIT = 1;
    public static final int SET_STEER_ASSIST_PERMISSION = 0;
    public static final int SET_UNINVALID = 255;
    public static final int SOC_CONFIG_DM20 = 3;
    public static final int SOC_CONFIG_DM25 = 2;
    public static final int SOC_CONFIG_OFFLINE = 1;
    public static final int SOC_DM_VERSION = 164;
    public static final int START_KEY_BOTH_VALID = 3;
    public static final int START_KEY_INVALID = 0;
    public static final int START_KEY_SIG1_VALID = 1;
    public static final int START_KEY_SIG2_VALID = 2;
    public static final int START_KEY_STATE = 208;
    public static final int STATE_LOCK_RECORD = 2;
    public static final int STATE_NORMAL_RECORD = 1;
    public static final int STATE_TAKE_PICTURE = 4;
    public static final int STEER_INVALID = 0;
    public static final int STEER_QIN_WITHOUT_ACC = 3;
    public static final int STEER_QIN_WITH_ACC = 4;
    public static final int STEER_YUAN_WITHOUT_ACC = 1;
    public static final int STEER_YUAN_WITH_ACC = 2;
    protected static final String TAG = "BYDAutoSettingDevice";
    public static final int VOICE_CMD_CLOSE = 3;
    public static final int VOICE_CMD_OPEN = 1;
    public static final int VOICE_CMD_STOP = 2;
    public static final int VOICE_CTRL_BACK_DOOR = 143;
    public static final int WINDSCREEN_WIPER_OVERHAUL_CLOSE = 2;
    public static final int WINDSCREEN_WIPER_OVERHAUL_INVALID = 0;
    public static final int WINDSCREEN_WIPER_OVERHAUL_OPEN = 1;
    public static final int WINDSCREEN_WIPER_UNALLOWED_OVERHAUL = 3;
    private static int mDeviceType = 1023;
    private static BYDAutoSettingDevice mInstance;
    private final Context mContext;
    private IBYDCDRService mBydCDRService = null;
    private final int INTELLIGENTV_VOICE_RECORD = 0;
    private final int INTELLIGENTV_VOICE_TAKE_PICTURE = 1;
    private final int INTELLIGENTV_VOICE_LOCK = 2;
    private final int KEY_TAKE_PICTURE = 3;
    private final int KEY_LOCK_VIDEO = 4;
    private final String CDR_LOCK_VIDEO = "cdrLockVideo";
    private final String CDR_TAKE_PICTURE = "cdrTakePicture";
    private final String CDR_SWITCH = "cdrSwitch";

    private BYDAutoSettingDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoSettingDevice getInstance(Context context) {
        BYDAutoSettingDevice bYDAutoSettingDevice;
        synchronized (BYDAutoSettingDevice.class) {
            if (mInstance == null) {
                context.enforceCallingOrSelfPermission(SETTING_COMMON_PERM, null);
                mInstance = new BYDAutoSettingDevice(context);
            }
            bYDAutoSettingDevice = mInstance;
        }
        return bYDAutoSettingDevice;
    }

    private int sentBroadcastForCDRCommand(String str, int i) {
        Log.d(TAG, "sentBroadcastForCDRCommand commandType is: " + str + "  commandValue is : " + i);
        Intent intent = new Intent();
        intent.setAction("byd.intent.action.CDRCOMMAND");
        intent.putExtra("commandType", str);
        intent.putExtra("commandValue", i);
        this.mContext.sendBroadcast(intent);
        return 1;
    }

    private int setCDRCommand(int i, int i2) {
        if (this.mBydCDRService == null) {
            if (ServiceManager.checkService("android.cdrservice.IBYDCDRService") != null) {
                this.mBydCDRService = IBYDCDRService.Stub.asInterface();
            } else {
                Log.d(TAG, "setCDRCommand ServiceManager.checkService(IBYDCDRService.NAME)==null");
                return -2147482648;
            }
        }
        int i3 = 0;
        try {
            i3 = this.mBydCDRService.setCommand(i, i2);
        } catch (RemoteException unused) {
        }
        Log.d(TAG, "setCDRCommand return is " + i3);
        return i3;
    }

    public int factoryResetAll(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "factoryResetAll: The state is " + i);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 122, i);
        }
        return -2147482645;
    }

    public int getACAutoAir() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 4);
        Log.d(TAG, "getACAutoAir value is: " + i);
        return i;
    }

    public int getACAutoWindLevel() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 5);
        Log.d(TAG, "getACAutoWindLevel value is: " + i);
        return i;
    }

    public int getACBTWind() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getACBTWind value is: " + i);
        return i;
    }

    public int getACPauseCycle() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getACPauseCycle value is: " + i);
        return i;
    }

    public int getACTunnelCycle() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getACTunnelCycle value is: " + i);
        return i;
    }

    public int getAutoExternalRearMirrorFollowUpSwitch() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 118);
        Log.d(TAG, "getAutoExternalRearMirrorFollowUpSwitch value is: " + i);
        return i;
    }

    public int getAutoLock() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 69);
        Log.d(TAG, "getAutoLock value is: " + i);
        return i;
    }

    public int getAutoLockSwitch() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 33);
        Log.d(TAG, "getAutoLockSwitch value is: " + i);
        return i;
    }

    public int getAutoLockTime() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 120);
        Log.d(TAG, "getAutoLockTime: The auto lock time is " + i);
        return i;
    }

    public int getAutoRainWiperState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 213);
        Log.d(TAG, "getAutoRainWiperState state is: " + i);
        return i;
    }

    public int getBTCallReductionWindMenuState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 138);
        Log.d(TAG, "getBTCallReductionWindMenuState: state is: " + i);
        return i;
    }

    public byte[] getBTMacAddr() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, 228);
        byte[] bArr = {0, 0, 0, 0, 0, 0};
        if (buffer.length <= 4) {
            Log.d(TAG, "getBTMacAddr error");
            return bArr;
        }
        byte[] copyOfRange = Arrays.copyOfRange(buffer, 4, 10);
        Log.d(TAG, "getBTMacAddr is" + Arrays.toString(copyOfRange));
        return copyOfRange;
    }

    public int getBackDoorElectricMode() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 84);
        Log.d(TAG, "getBackDoorElectricMode value is: " + i);
        return i;
    }

    public int getBackDoorElectricModeOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 83);
        Log.d(TAG, "getBackDoorElectricModeOnlineState value is: " + i);
        return i;
    }

    public int getBackDoorOpenedHeight() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 106);
        Log.d(TAG, "getBackDoorOpenedHeight: The height when back door opened is " + i);
        return i;
    }

    public int getBackHomeLightDelay() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 34);
        Log.d(TAG, "getBackHomeLightDelay value is: " + i);
        return i;
    }

    public int getBackHomeLightDelayValue() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 35);
        Log.d(TAG, "getBackHomeLightDelayValue value is: " + i);
        return i;
    }

    public int getBackRowControl() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 119);
        Log.d(TAG, "getBackRowControl value is: " + i);
        return i;
    }

    public int getBasePadAutoRise() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 74);
        Log.d(TAG, "getBasePadAutoRise value is: " + i);
        return i;
    }

    public int getBasePadAutoRiseState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 73);
        Log.d(TAG, "getBasePadAutoRiseState value is: " + i);
        return i;
    }

    public int getCarRecorderRecording() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 40);
        Log.d(TAG, "getCarRecorderRecording value is: " + i);
        return i;
    }

    public int getChargingPort() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 8);
        Log.d(TAG, "getChargingPort value is: " + i);
        return i;
    }

    public int getCourtesyLampTime() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 123);
        Log.d(TAG, "getCourtesyLampTime: The courtesy lamp time is " + i);
        return i;
    }

    public int getDoorLock() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 39);
        Log.d(TAG, "getDoorLock value is: " + i);
        return i;
    }

    public int getDriveConfig() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 195);
        Log.d(TAG, "getDriveConfig: The drive config type is " + i);
        return i;
    }

    public int getDriveDoorCloseInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 44);
        Log.d(TAG, "getDriveDoorCloseInd value is: " + i);
        return i;
    }

    public int getDriverSeatAutoReturn() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 22);
        Log.d(TAG, "getDriverSeatAutoReturn value is: " + i);
        return i;
    }

    public int getDriverSeatBack() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 67);
        Log.d(TAG, "getDriverSeatBack value is: " + i);
        return i;
    }

    public int getDrivingRecorder() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 70);
        Log.d(TAG, "getDrivingRecorder value is: " + i);
        return i;
    }

    public int getDrivingRecorderSwitchState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = SystemProperties.getInt("sys.byd.cdr_recording", -1);
        Log.d(TAG, "getDrivingRecorderSwitchState result is: " + i);
        return i;
    }

    public int getDualTempAreaAcOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 82);
        Log.d(TAG, "getDualTempAreaAcOnlineState value is: " + i);
        return i;
    }

    public int getElecHandbrakeState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 80);
        Log.d(TAG, "getElecHandbrakeState value is: " + i);
        return i;
    }

    public int getEnergyFeedback() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 6);
        Log.d(TAG, "getEnergyFeedback value is: " + i);
        return i;
    }

    public int getEngineOilExitUpdateState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 156);
        Log.d(TAG, "getEngineOilExitUpdateState: The state is " + i);
        return i;
    }

    public int getEngineOilLevel() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 151);
        Log.d(TAG, "getEngineOilLevel: level is: " + i);
        return i;
    }

    public int getEngineOilUpdateSignal() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 152);
        Log.d(TAG, "getEngineOilUpdateSignal: state is: " + i);
        return i;
    }

    public int getExternalRearMirrorAutoFoldSetting() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 211);
        Log.d(TAG, "getExternalRearMirrorAutoFoldSetting value is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getHomeLightTime() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 65);
        Log.d(TAG, "getHomeLightTime value is: " + i);
        return i;
    }

    public int getIALArea() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 94);
        Log.d(TAG, "getIALArea: The area of interior atmosphere lamp is " + i);
        return i;
    }

    public int getIALBrightness() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 93);
        Log.d(TAG, "getIALBrightness: The brightness of interior atmosphere lamp is " + i);
        return i;
    }

    public int getIALColor() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 92);
        Log.d(TAG, "getIALColor: The color of interior atmosphere lamp is " + i);
        return i;
    }

    public int getIKEYBTLowPowerMode() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 229);
        Log.d(TAG, "getIKEYBTLowPowerMode mode is: " + i);
        return i;
    }

    public int getILDuration() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 95);
        Log.d(TAG, "getILDuration: The duration of interior lamp is " + i);
        return i;
    }

    public int getINSTheme() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 111);
        Log.d(TAG, "getINSTheme: The type of INS theme is " + i);
        return i;
    }

    public int getInsBacklightCtl() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 207);
        Log.d(TAG, "getInsBackklightCtl value is: " + i);
        return i;
    }

    public int getInsideLightDoorState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 177);
        Log.d(TAG, "getInsideLightDoorState: The inside light door state is " + i);
        return i;
    }

    public int getInsideRearMirrorScreenSwitchState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 76);
        Log.d(TAG, "getInsideRearMirrorScreenSwitchState value is: " + i);
        return i;
    }

    public int getIntelligentVoiceIND() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 112);
        Log.d(TAG, "getIntelligentVoiceIND value is: " + i);
        return i;
    }

    public int getKeyPowerLowInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 47);
        Log.d(TAG, "getKeyPowerLowInd value is: " + i);
        return i;
    }

    public int getLPSwitchDownwindow() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 64);
        Log.d(TAG, "getLPSwitchDownwindow value is: " + i);
        return i;
    }

    public int getLPSwitchUpwindow() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 63);
        Log.d(TAG, "getLPSwitchUpwindow value is: " + i);
        return i;
    }

    public int getLanguage() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 108);
        Log.d(TAG, "getLanguage: The type of language is " + i);
        return i;
    }

    public int getLeaveCarPInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 46);
        Log.d(TAG, "getLeaveCarPInd value is: " + i);
        return i;
    }

    public int getLeaveHomeLightTime() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 66);
        Log.d(TAG, "getLeaveHomeLightTime value is: " + i);
        return i;
    }

    public int getLeftHeadlampLevel() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 226);
        Log.d(TAG, "getLeftHeadlampLevel level is: " + i);
        return i;
    }

    public int getLeftHomeLightDelay() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 36);
        Log.d(TAG, "getLeftHomeLightDelay state is: " + i);
        return i;
    }

    public int getLeftHomeLightDelayValue() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 37);
        Log.d(TAG, "getLeftHomeLightDelayValue value is: " + i);
        return i;
    }

    public int getLeftViewMirrorFlipAngle() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 17);
        Log.d(TAG, "getLeftViewMirrorFlipAngle value is: " + i);
        return i;
    }

    public int getLockCarRiseWindow() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 31);
        Log.d(TAG, "getLockCarRiseWindow value is: " + i);
        return i;
    }

    public int getLockOff() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 89);
        Log.d(TAG, "getLockOff value is: " + i);
        return i;
    }

    public int getLockUpwindow() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 61);
        Log.d(TAG, "getLockUpwindow value is: " + i);
        return i;
    }

    public int getLongPressUnlockWindow() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 32);
        Log.d(TAG, "getLongPressUnlockWindow value is: " + i);
        return i;
    }

    public int getLowBatteryInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 51);
        Log.d(TAG, "getLowBatteryInd value is: " + i);
        return i;
    }

    public int getLowOilInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 50);
        Log.d(TAG, "getLowOilInd value is: " + i);
        return i;
    }

    public int getMaintainRemindState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 110);
        Log.d(TAG, "getSafeWarnState: The maintain remind is " + i);
        return i;
    }

    public int getMicroSwitchLockWindowState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 72);
        Log.d(TAG, "getMicroSwitchLockWindowState value is: " + i);
        return i;
    }

    public int getMicroSwitchUnlockWindowState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int longPressUnlockWindow = getLongPressUnlockWindow();
        Log.d(TAG, "getMicroSwitchUnockWindowState value is: " + longPressUnlockWindow);
        return longPressUnlockWindow;
    }

    public int getMissKeyInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 48);
        Log.d(TAG, "getMissKeyInd value is: " + i);
        return i;
    }

    public int getMultimediaMotorTemperatureState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 157);
        Log.d(TAG, "getMultimediaMotorTemperatureState: The state is " + i);
        return i;
    }

    public int getNightDRLightOnInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 49);
        Log.d(TAG, "getNightDRLightOnInd value is: " + i);
        return i;
    }

    public int getNightDriveLightOnReminder() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 135);
        Log.d(TAG, "getNightDriveLightOnReminder: value is: " + i);
        return i;
    }

    public int getOverspeedLock() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 102);
        Log.d(TAG, "getOverspeedLock: The state of overspeed locking is " + i);
        return i;
    }

    public int getOverspeedLockingState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 102);
        Log.d(TAG, "getOverspeedLockingState: The state of overspeed locking is " + i);
        return i;
    }

    public int getPM25Power() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 24);
        Log.d(TAG, "getPM25Power value is: " + i);
        return i;
    }

    public int getPM25Switch() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 27);
        Log.d(TAG, "getPM25Switch value is: " + i);
        return i;
    }

    public int getPM25SwitchCheck() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 25);
        Log.d(TAG, "getPM25SwitchCheck value is: " + i);
        return i;
    }

    public int getPM25TimeCheck() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 26);
        Log.d(TAG, "getPM25TimeCheck value is: " + i);
        return i;
    }

    public int getPanoramaSunRoofOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 90);
        Log.d(TAG, "getPanoramaSunRoofOnlineState value is: " + i);
        return i;
    }

    public int getParkBrakeInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 43);
        Log.d(TAG, "getParkBrakeInd value is: " + i);
        return i;
    }

    public int getRearAcOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 81);
        Log.d(TAG, "getRearAcOnlineState value is: " + i);
        return i;
    }

    public int getRearMirrorFlip() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 58);
        Log.d(TAG, "getRearMirrorFlip value is: " + i);
        return i;
    }

    public int getRearViewMirrorAutoFoldMode() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 16);
        Log.d(TAG, "getRearViewMirrorAutoFoldMode value is: " + i);
        return i;
    }

    public int getRearViewMirrorAutoFoldModeOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 85);
        Log.d(TAG, "getRearViewMirrorAutoFoldModeOnlineState value is: " + i);
        return i;
    }

    public int getRearViewMirrorFlip() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 86);
        Log.d(TAG, "getRearViewMirrorFlip value is: " + i);
        return i;
    }

    public int getRemoteControlDownwindow() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 60);
        Log.d(TAG, "getRemoteControlDownwindow value is: " + i);
        return i;
    }

    public int getRemoteControlDownwindowState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 30);
        Log.d(TAG, "getRemoteControlDownwindowState value is: " + i);
        return i;
    }

    public int getRemoteControlUpwindow() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 59);
        Log.d(TAG, "getRemoteControlUpwindow value is: " + i);
        return i;
    }

    public int getRemoteControlUpwindowState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 71);
        Log.d(TAG, "getRemoteControlUpwindowState value is: " + i);
        return i;
    }

    public int getRemoteCtlUnlockingState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 121);
        Log.d(TAG, "getRemoteCtlUnlockingState: The state of remote control unlocking is " + i);
        return i;
    }

    public int getRemoteDrivingOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 87);
        Log.d(TAG, "getRemoteDrivingOnlineState value is: " + i);
        return i;
    }

    public int getRightHeadlampLevel() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 227);
        Log.d(TAG, "getRightHeadlampLevel level is: " + i);
        return i;
    }

    public int getRightViewMirrorFlipAngle() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 18);
        Log.d(TAG, "getRightViewMirrorFlipAngle value is: " + i);
        return i;
    }

    public int getSOCConfig() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = 1;
        if (super.get(mDeviceType, 163) == 1) {
            i = super.get(mDeviceType, 164);
        }
        Log.d(TAG, "getSOCConfig: The soc config is " + i);
        return i;
    }

    public int getSOCTarget() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 7);
        Log.d(TAG, "getSOCTarget value is: " + i);
        return i;
    }

    public int getSafeBeltInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 45);
        Log.d(TAG, "getSafeBeltInd value is: " + i);
        return i;
    }

    public int getSafeWarnState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 109);
        Log.d(TAG, "getSafeWarnState: The safe warn is " + i);
        return i;
    }

    public int getSeatHeatingState(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (i == 1) {
            i2 = 187;
        } else if (i == 2) {
            i2 = 189;
        } else if (i == 3) {
            i2 = 191;
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = 193;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getSeatHeatingState: The state of " + i + " seat heating is " + i3);
        return i3;
    }

    public int getSeatHeatingState1(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (i == 1) {
            i2 = 198;
        } else if (i != 2) {
            return -2147482645;
        } else {
            i2 = 199;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getSeatHeatingState1: The state of " + i + " 1 level seat heating is " + i3);
        return i3;
    }

    public int getSeatVentilatingState(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (i == 1) {
            i2 = 188;
        } else if (i == 2) {
            i2 = 190;
        } else if (i == 3) {
            i2 = 192;
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = 194;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getSeatVentilatingState: The state of " + i + " seat ventilating is " + i3);
        return i3;
    }

    public int getStartKeyState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 208);
        Log.d(TAG, "getStartKeyState: start key state is " + i);
        return i;
    }

    public int getStartOrPowerInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 42);
        Log.d(TAG, "getStartOrPowerInd value is: " + i);
        return i;
    }

    public int getSteerAssis() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getSteerAssis value is: " + i);
        return i;
    }

    public int getSteerAssistPermission() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 166);
        Log.d(TAG, "getSteerAssistPermission: The settings steer assist permissions state is " + i);
        return i;
    }

    public int getSteerBack() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 68);
        Log.d(TAG, "getSteerBack value is: " + i);
        return i;
    }

    public int getSteerPositionAutoReturn() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 23);
        Log.d(TAG, "getSteerPositionAutoReturn value is: " + i);
        return i;
    }

    public int getSteerType() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 209);
        Log.d(TAG, "getSteerType type is: " + i);
        return i;
    }

    public int getStopRemoteCtrlDriveInd() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 52);
        Log.d(TAG, "getStopRemoteCtrlDriveInd value is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_SETTING;
    }

    public int getUnlockDownwindow() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 62);
        Log.d(TAG, "getUnlockDownwindow value is: " + i);
        return i;
    }

    public int getUnlockSettingOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 88);
        Log.d(TAG, "getUnlockSettingOnlineState value is: " + i);
        return i;
    }

    public int getVoiceINDLevel() {
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        int i = super.get(mDeviceType, 113);
        Log.d(TAG, "getVoiceINDLevel value is: " + i);
        return i;
    }

    public int getWindscreenWiperOverhaulState(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (i == 1) {
            i2 = 136;
        } else if (i != 2) {
            return -2147482645;
        } else {
            i2 = 137;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getWindscreenWiperOverhaulState: area is: " + i + " the state is " + i3);
        return i3;
    }

    public int hasFeature(String str) {
        int i;
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (str.equals(FEATURE_INTERIOR_ATMOSPHERE_LAMP)) {
            i = 91;
        } else if (str.equals(FEATURE_SEAT_HEATING_AND_VENTILATING)) {
            i = 96;
        } else if (str.equals(FEATURE_OVERSPEED_LOCKING)) {
            i = 101;
        } else if (str.equals(FEATURE_BACK_DOOR)) {
            i = 83;
        } else if (str.equals(FEATURE_DRIVING_RECORDER)) {
            return SystemProperties.get("vehicle.config.cam_sort").contains("rear") ? 1 : 0;
        } else if (str.equals(FEATURE_BT_CALL_REDUCTION_WIND)) {
            i = 130;
        } else if (str.equals(FEATURE_FRONT_WINDSCREEN_WIPER_OVERHAUL)) {
            i = 131;
        } else if (str.equals(FEATURE_REAR_WINDSCREEN_WIPER_OVERHAUL)) {
            i = 132;
        } else if (str.equals(FEATURE_PARKING_AUTO_INNER_LOOP)) {
            i = 133;
        } else if (str.equals(FEATURE_TUNNEL_AUTO_INNER_LOOP)) {
            i = 134;
        } else if (str.equals(FEATURE_REARVIEW_MIRROR_FOLLOW_UP)) {
            i = 85;
        } else if (str.equals(FEATURE_POWER_STEERING)) {
            i = 139;
        } else if (str.equals(FEATURE_ENGINE_OIL_DETECTION)) {
            i = 150;
        } else if (str.equals(FEATURE_FOUR_WHEEL_DRIVE)) {
            i = 153;
        } else if (str.equals(FEATURE_INSIDE_LIGHT)) {
            i = 176;
        } else if (str.equals(FEATURE_DRIVER_SEAT_HEATING)) {
            i = 179;
        } else if (str.equals(FEATURE_DRIVER_SEAT_VENTILATING)) {
            i = 180;
        } else if (str.equals(FEATURE_PASSENGER_SEAT_HEATING)) {
            i = 181;
        } else if (str.equals(FEATURE_PASSENGER_SEAT_VENTILATING)) {
            i = 182;
        } else if (str.equals(FEATURE_REAR_LEFT_SEAT_HEATING)) {
            i = 183;
        } else if (str.equals(FEATURE_REAR_LEFT_SEAT_VENTILATING)) {
            i = 184;
        } else if (str.equals(FEATURE_REAR_RIGHT_SEAT_HEATING)) {
            i = 185;
        } else if (str.equals(FEATURE_REAR_RIGHT_SEAT_VENTILATING)) {
            i = 186;
        } else if (str.equals(FEATURE_DRIVER_SEAT_HEATING_LEVEL1)) {
            i = 196;
        } else if (str.equals(FEATURE_PASSENGER_SEAT_HEATING_LEVEL1)) {
            i = 197;
        } else if (!str.equals(FEATURE_AUTO_RAIN_WIPER)) {
            return -2147482645;
        } else {
            i = 212;
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

    public int queryAllStatus() {
        Log.d(TAG, "getAllStatus.");
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        return super.set(mDeviceType, 56, 56);
    }

    public void registerListener(AbsBYDAutoSettingListener absBYDAutoSettingListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (absBYDAutoSettingListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSettingListener);
        }
    }

    public int reset(int i, int i2) {
        int i3;
        Log.d(TAG, "resetSetting item is: " + i + " and value is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i2 == 0 || i2 == 1) {
            switch (i) {
                case 0:
                    i3 = 200;
                    break;
                case 1:
                    i3 = 201;
                    break;
                case 2:
                    i3 = 202;
                    break;
                case 3:
                    i3 = 203;
                    break;
                case 4:
                    i3 = 204;
                    break;
                case 5:
                    i3 = 205;
                    break;
                case 6:
                    i3 = 206;
                    break;
                default:
                    return -2147482645;
            }
            return super.set(mDeviceType, i3, i2);
        }
        return -2147482645;
    }

    public int restoreCarDefaultValue() {
        Log.d(TAG, "restoreCarDefaultValue!");
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        return super.set(mDeviceType, 54, 0);
    }

    public int restoreDrDefaultValue() {
        Log.d(TAG, "restoreDrDefaultValue!");
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        return super.set(mDeviceType, 53, 0);
    }

    public int sendBTMacToIKEY(byte[] bArr) {
        Log.d(TAG, "sendBTMacToIKEY addr is: " + Arrays.toString(bArr));
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (bArr.length != 6) {
            return -2147482645;
        }
        return super.set(mDeviceType, 230, bArr);
    }

    public int setACAutoAir(int i) {
        Log.d(TAG, "setACAutoAir value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 4, i);
        }
        return -2147482645;
    }

    public int setACAutoWindLevel(int i) {
        Log.d(TAG, "setACAutoWindLevel value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 2 || i == 3) {
            return super.set(mDeviceType, 5, i);
        }
        return -2147482645;
    }

    public int setACBTWind(int i) {
        Log.d(TAG, "setACBTWind value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 1, i);
        }
        return -2147482645;
    }

    public int setACPauseCycle(int i) {
        Log.d(TAG, "setACPauseCycle value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 3, i);
        }
        return -2147482645;
    }

    public int setACTunnelCycle(int i) {
        Log.d(TAG, "setACTunnelCycle value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 2, i);
        }
        return -2147482645;
    }

    public void setAllStatus() {
    }

    public int setAutoExternalRearMirrorFollowUpSwitch(int i) {
        Log.d(TAG, "setAutoExternalRearMirrorFollowUpSwitch is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 118, i);
        }
        return -2147482645;
    }

    public int setAutoLockSwitch(int i) {
        Log.d(TAG, "setAutoLockSwitch is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 33, i);
        }
        return -2147482645;
    }

    public int setAutoLockTime(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setAutoLockTime: The auto lock time is " + i);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 120, i);
        }
        return -2147482645;
    }

    public int setAutoRainWiperState(int i) {
        Log.d(TAG, "setAutoRainWiperState state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1 || i == 2) {
            return super.set(mDeviceType, 213, i);
        }
        return -2147482645;
    }

    public int setBTCallState(int i) {
        Log.d(TAG, "setBTCallState state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i < 0 || i > 5) {
            return -2147482645;
        }
        return super.set(mDeviceType, 210, i);
    }

    public int setBackDoorElectricMode(int i) {
        Log.d(TAG, "setBackDoorElectricMode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 84, i);
        }
        return -2147482645;
    }

    public int setBackDoorOpenedHeight(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setBackDoorOpenedHeight: The height when back door opened is " + i);
        if (i < 15 || i > 100) {
            return -2147482645;
        }
        return super.set(mDeviceType, 106, i);
    }

    public int setBackHomeLightDelay(int i) {
        Log.d(TAG, "setBackHomeLightDelay is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 34, i);
        }
        return -2147482645;
    }

    public int setBackHomeLightDelayValue(int i) {
        Log.d(TAG, "setBackHomeLightDelayValue is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i < 0 || i > 60) {
            return -2147482645;
        }
        return super.set(mDeviceType, 35, i);
    }

    public int setBackRowControl(int i) {
        Log.d(TAG, "setBackRowControl is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 119, i);
        }
        return -2147482645;
    }

    public int setBasePadAutoRiseState(int i) {
        Log.d(TAG, "setBasePadAutoRiseState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 73, i);
        }
        return -2147482645;
    }

    public int setCallState(int i) {
        Log.d(TAG, "setCallState value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, 140, i);
        }
        return -2147482645;
    }

    public int setCarRecorderRecording(int i) {
        Log.d(TAG, "setCarRecorderRecording is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 40, i);
        }
        return -2147482645;
    }

    public int setChargingPort(int i) {
        Log.d(TAG, "setChargingPort value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 8, i);
        }
        return -2147482645;
    }

    public int setCourtesyLampTime(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setCourtesyLampTime: The courtesy lamp time is " + i);
        if (i < 1 || i > 4) {
            return -2147482645;
        }
        return super.set(mDeviceType, 123, i);
    }

    public int setDoorLock(int i) {
        Log.d(TAG, "setDoorLock is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 39, i);
        }
        return -2147482645;
    }

    public int setDriveDoorCloseInd(int i) {
        Log.d(TAG, "setDriveDoorCloseInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 44, i);
        }
        return -2147482645;
    }

    public int setDriverSeatAutoReturn(int i) {
        Log.d(TAG, "setDriverSeatAutoReturn is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 22, i);
        }
        return -2147482645;
    }

    public int setDrivingRecorderSwitchState(int i) {
        Log.d(TAG, "setDrivingRecorderSwitchState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return setCDRCommand(0, i);
        }
        return -2147482645;
    }

    public int setEnergyFeedback(int i) {
        Log.d(TAG, "setEnergyFeedback value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 6, i);
        }
        return -2147482645;
    }

    public int setEngineOilExitUpdateState(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setEngineOilExitUpdateState: The state of " + i);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 156, i);
        }
        return -2147482645;
    }

    public int setFormatMemoryCard(int i) {
        Log.d(TAG, "setFormatMemoryCard is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i != 0) {
            return -2147482645;
        }
        return super.set(mDeviceType, 78, i);
    }

    public int setHeadlampLevel(int i) {
        Log.d(TAG, "setHeadlampLevel level is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i < 0 || i > 11) {
            return -2147482645;
        }
        return super.set(mDeviceType, 215, i);
    }

    public int setIALArea(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setIALArea: the area of interior atmosphere lamp is " + i);
        if (i == 1 || i == 2 || i == 3) {
            return super.set(mDeviceType, 94, i);
        }
        return -2147482645;
    }

    public int setIALBrightness(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setIALBrightness: the brightness of interior atmosphere lamp is " + i);
        if (i < 0 || i > 5) {
            return -2147482645;
        }
        return super.set(mDeviceType, 93, i);
    }

    public int setIALColor(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setIALColor: the color of interior atmosphere lamp is " + i);
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7) {
            return super.set(mDeviceType, 92, i);
        }
        return -2147482645;
    }

    public int setIALInfo(int i, int i2, int i3, int i4) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setIALInfo: the area is " + i + ", the color is " + i2 + ", the brightness is " + i3 + ", the source is " + i4);
        if (i == 1 || i == 2 || i == 3) {
            if ((i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) || i3 < 0 || i3 > 5) {
                return -2147482645;
            }
            if (i4 != 0 && i4 != 1) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{92, 93, 94, 169}, new int[]{i2, i3 + 1, i, i4});
        }
        return -2147482645;
    }

    public int setILDuration(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setILDuration: the duration of interior lamp is " + i);
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return super.set(mDeviceType, 95, i);
        }
        return -2147482645;
    }

    public int setINSTheme(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setINSTheme: The type of INS theme is " + i);
        if (i < 1 || i > 10) {
            return -2147482645;
        }
        return super.set(mDeviceType, 111, i);
    }

    public int setInsideLightDoorState(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setInsideLightDoorState: The state of " + i);
        if (i == 0 || i == 1 || i == 2) {
            return super.set(mDeviceType, 177, i);
        }
        return -2147482645;
    }

    public int setInsideRearMirrorScreenState(int i) {
        Log.d(TAG, "setInsideRearMirrorScreenState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 2 || i == 3) {
            return super.set(mDeviceType, 77, i);
        }
        return -2147482645;
    }

    public int setInsideRearMirrorScreenSwitchState(int i) {
        Log.d(TAG, "setInsideRearMirrorScreenSwitchState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 76, i);
        }
        return -2147482645;
    }

    public int setIntelligentVoiceIND(int i) {
        Log.d(TAG, "setIntelligentVoiceIND is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 112, i);
        }
        return -2147482645;
    }

    public int setKeyPowerLowInd(int i) {
        Log.d(TAG, "setKeyPowerLowInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 47, i);
        }
        return -2147482645;
    }

    public int setLanguage(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setLanguage: The type of language is " + i);
        if (i < 1 || i > 5) {
            return -2147482645;
        }
        return super.set(mDeviceType, 108, i);
    }

    public int setLeaveCarPInd(int i) {
        Log.d(TAG, "setLeaveCarPInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 46, i);
        }
        return -2147482645;
    }

    public int setLeftHomeLightDelay(int i) {
        Log.d(TAG, "setLeftHomeLightDelay is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 36, i);
        }
        return -2147482645;
    }

    public int setLeftHomeLightDelayValue(int i) {
        Log.d(TAG, "setLeftHomeLightDelayValue is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i < 0 || i > 60) {
            return -2147482645;
        }
        return super.set(mDeviceType, 37, i);
    }

    public int setLeftViewMirrorFlipAngle(int i) {
        Log.d(TAG, "setLeftViewMirrorFlipAngle is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i < 0 || i > 8) {
            return -2147482645;
        }
        return super.set(mDeviceType, 17, i);
    }

    public int setLockCarRiseWindow(int i) {
        Log.d(TAG, "setLockCarRiseWindow is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 31, i);
        }
        return -2147482645;
    }

    public int setLockOff(int i) {
        Log.d(TAG, "setLockOff is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 89, i);
        }
        return -2147482645;
    }

    public int setLockReplayVideo(int i) {
        Log.d(TAG, "setLockReplayVideo is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i != 0) {
            return -2147482645;
        }
        return setCDRCommand(2, 0);
    }

    public int setLongPressUnlockWindow(int i) {
        Log.d(TAG, "setLongPressUnlockWindow is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 32, i);
        }
        return -2147482645;
    }

    public int setLowBatteryInd(int i) {
        Log.d(TAG, "setLowBatteryInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 51, i);
        }
        return -2147482645;
    }

    public int setLowOilInd(int i) {
        Log.d(TAG, "setLowOilInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 50, i);
        }
        return -2147482645;
    }

    public int setMcuPH2State(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setMcuPH2State: The state of " + i);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 165, i);
        }
        return -2147482645;
    }

    public int setMicroSwitchLockWindowState(int i) {
        Log.d(TAG, "setMicroSwitchLockWindowState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 72, i);
        }
        return -2147482645;
    }

    public int setMicroSwitchUnlockWindowState(int i) {
        Log.d(TAG, "setMicroSwitchUnlockWindowState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return setLongPressUnlockWindow(i);
        }
        return -2147482645;
    }

    public int setMissKeyInd(int i) {
        Log.d(TAG, "setMissKeyInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 48, i);
        }
        return -2147482645;
    }

    public int setNightDRLightOnInd(int i) {
        Log.d(TAG, "setNightDRLightOnInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 49, i);
        }
        return -2147482645;
    }

    public int setOverspeedLock(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setOverspeedLock: The value of overspeed locking is " + i);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 102, i);
        }
        return -2147482645;
    }

    public int setOverspeedLockingState(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setOverspeedLockingState: The state of overspeed locking is " + i);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 102, i);
        }
        return -2147482645;
    }

    public int setPM25Power(int i) {
        Log.d(TAG, "setPM25Power is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 24, i);
        }
        return -2147482645;
    }

    public int setPM25Switch(int i) {
        Log.d(TAG, "setPM25Switch is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i < 0 || i > 3) {
            return -2147482645;
        }
        return super.set(mDeviceType, 27, i);
    }

    public int setPM25SwitchCheck(int i) {
        Log.d(TAG, "setPM25SwitchCheck is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 25, i);
        }
        return -2147482645;
    }

    public int setPM25TimeCheck(int i) {
        Log.d(TAG, "setPM25TimeCheck is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 26, i);
        }
        return -2147482645;
    }

    public int setPadRotation(int i) {
        Log.d(TAG, "setPadRotation is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 154, i);
        }
        return -2147482645;
    }

    public int setParkBrakeInd(int i) {
        Log.d(TAG, "setParkBrakeInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 43, i);
        }
        return -2147482645;
    }

    public int setRearViewMirrorAutoFoldMode(int i) {
        Log.d(TAG, "setRearViewMirrorAutoFoldMode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 16, i);
        }
        return -2147482645;
    }

    public int setRearViewMirrorFlip(int i) {
        Log.d(TAG, "setRearViewMirrorFlip is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 86, i);
        }
        return -2147482645;
    }

    public int setRemoteControlDownwindowState(int i) {
        Log.d(TAG, "setRemoteControlDownwindowState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 30, i);
        }
        return -2147482645;
    }

    public int setRemoteControlUpwindowState(int i) {
        Log.d(TAG, "setRemoteControlUpwindowState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 71, i);
        }
        return -2147482645;
    }

    public int setRemoteCtlUnlockingState(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setRemoteCtlUnlockingState: The state of remote control unlocking is " + i);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 121, i);
        }
        return -2147482645;
    }

    public int setRightViewMirrorFlipAngle(int i) {
        Log.d(TAG, "setRightViewMirrorFlipAngle is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i < 0 || i > 8) {
            return -2147482645;
        }
        return super.set(mDeviceType, 18, i);
    }

    public int setSOCTarget(int i) {
        Log.d(TAG, "setSOCTarget value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i < 15 || i > 70) {
            return -2147482645;
        }
        return super.set(mDeviceType, 7, i);
    }

    public int setSafeBeltInd(int i) {
        Log.d(TAG, "setSafeBeltInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 45, i);
        }
        return -2147482645;
    }

    public int setSeatHeatingState(int i, int i2) {
        int i3;
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setSeatHeatingState: The state of " + i + " seat heating is " + i2);
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (i == 1) {
                i3 = 187;
            } else if (i == 2) {
                i3 = 189;
            } else if (i == 3) {
                i3 = 191;
            } else if (i != 4) {
                return -2147482645;
            } else {
                i3 = 193;
            }
            return super.set(mDeviceType, i3, i2);
        }
        return -2147482645;
    }

    public int setSeatHeatingState1(int i, int i2) {
        int i3;
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setSeatHeatingState1: The state of " + i + " seat heating is " + i2);
        if (i2 == 1 || i2 == 2) {
            if (i2 == 2) {
                i2++;
            }
            if (i == 1) {
                i3 = 187;
            } else if (i != 2) {
                return -2147482645;
            } else {
                i3 = 189;
            }
            return super.set(mDeviceType, i3, i2);
        }
        return -2147482645;
    }

    public int setSeatVentilatingState(int i, int i2) {
        int i3;
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setSeatVentilatingState: The state of " + i + " seat ventilating is " + i2);
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (i == 1) {
                i3 = 188;
            } else if (i == 2) {
                i3 = 190;
            } else if (i == 3) {
                i3 = 192;
            } else if (i != 4) {
                return -2147482645;
            } else {
                i3 = 194;
            }
            return super.set(mDeviceType, i3, i2);
        }
        return -2147482645;
    }

    public int setStartOrPowerInd(int i) {
        Log.d(TAG, "setStartOrPowerInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 42, i);
        }
        return -2147482645;
    }

    public int setSteerAssis(int i) {
        Log.d(TAG, "setSteerAssis value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 9, i);
        }
        return -2147482645;
    }

    public int setSteerPositionAutoReturn(int i) {
        Log.d(TAG, "setSteerPositionAutoReturn is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 23, i);
        }
        return -2147482645;
    }

    public int setStopRemoteCtrlDriveInd(int i) {
        Log.d(TAG, "setStopRemoteCtrlDriveInd is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 52, i);
        }
        return -2147482645;
    }

    public int setVoiceINDLevel(int i) {
        Log.d(TAG, "setVoiceINDLevel is: " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 2 || i == 3) {
            return super.set(mDeviceType, 113, i);
        }
        return -2147482645;
    }

    public int setWindscreenWiperOverhaulState(int i, int i2) {
        int i3;
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setWindscreenWiperOverhaulState: The area of " + i + " state is " + i2);
        if (i2 == 1 || i2 == 2) {
            if (i == 1) {
                i3 = 136;
            } else if (i != 2) {
                return -2147482645;
            } else {
                i3 = 137;
            }
            return super.set(mDeviceType, i3, i2);
        }
        return -2147482645;
    }

    public int takeDrivingRecorderPicture() {
        Log.d(TAG, "takeDrivingRecorderPicture: ");
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        return setCDRCommand(1, 0);
    }

    public int turnOffInsideLight() {
        Log.d(TAG, "turn off inside light");
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        return super.set(mDeviceType, 178, 1);
    }

    public void unregisterListener(AbsBYDAutoSettingListener absBYDAutoSettingListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (absBYDAutoSettingListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoSettingListener);
        }
    }

    public int voiceCtlBackDoor(int i) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "voiceCtlBackDoor: The cmd is " + i);
        if (i < 1 || i > 3) {
            return -2147482645;
        }
        return super.set(mDeviceType, 143, i);
    }

    public int getIALBrightness(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (i == 1) {
            i2 = 170;
        } else if (i == 2) {
            i2 = 172;
        } else if (i != 3) {
            return -2147482645;
        } else {
            i2 = 174;
        }
        int i3 = super.get(mDeviceType, i2) - 1;
        Log.d(TAG, "getIALBrightness: The area(" + i + ") brightness of interior atmosphere lamp is " + i3);
        return i3;
    }

    public int getIALColor(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (i == 1) {
            i2 = 171;
        } else if (i == 2) {
            i2 = 173;
        } else if (i != 3) {
            return -2147482645;
        } else {
            i2 = 175;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getIALColor: The area(" + i + ") color of interior atmosphere lamp is " + i3);
        return i3;
    }

    public void registerListener(AbsBYDAutoSettingListener absBYDAutoSettingListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(SETTING_GET_PERM, null);
        if (absBYDAutoSettingListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoSettingListener, iArr);
        }
    }

    public int setIALArea(int i, int i2) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setIALArea: the area is " + i + ", the source is " + i2);
        if (i == 1 || i == 2 || i == 3) {
            if (i2 != 0 && i2 != 1) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{92, 93, 94, 169}, new int[]{0, 0, i, i2});
        }
        return -2147482645;
    }

    public int setIALBrightness(int i, int i2, int i3) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setIALBrightness: the area is " + i + ", the brightness is " + i2 + ", the source is " + i3);
        if ((i == 1 || i == 2 || i == 3) && i2 >= 0 && i2 <= 5) {
            if (i3 != 0 && i3 != 1) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{92, 93, 94, 169}, new int[]{0, i2 + 1, i, i3});
        }
        return -2147482645;
    }

    public int setIALColor(int i, int i2, int i3) {
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        Log.d(TAG, "setIALColor: the area is " + i + ", the color is " + i2 + ", the source is " + i3);
        if (i == 1 || i == 2 || i == 3) {
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
                return -2147482645;
            }
            if (i3 != 0 && i3 != 1) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{92, 93, 94, 169}, new int[]{i2, 0, i, i3});
        }
        return -2147482645;
    }

    public int turnOffInsideLight(int i) {
        Log.d(TAG, "turnOffInsideLight state is " + i);
        this.mContext.enforceCallingOrSelfPermission(SETTING_SET_PERM, null);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 178, i);
        }
        return -2147482645;
    }
}
