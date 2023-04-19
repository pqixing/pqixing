//refactor
package android.hardware.bydauto.setting;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
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
public static final int IAL_BACK_BRIGHTNESS = 172;
public static final int IAL_BACK_COLOR = 173;
public static final int IAL_BRIGHTNESS_MAX = 5;
public static final int IAL_BRIGHTNESS_MIN = 0;
public static final int IAL_COLD_WHITE = 2;
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
public static final int VOICE_CMD_CLOSE = 3;
public static final int VOICE_CMD_OPEN = 1;
public static final int VOICE_CMD_STOP = 2;
public static final int VOICE_CTRL_BACK_DOOR = 143;
public static final int WINDSCREEN_WIPER_OVERHAUL_CLOSE = 2;
public static final int WINDSCREEN_WIPER_OVERHAUL_INVALID = 0;
public static final int WINDSCREEN_WIPER_OVERHAUL_OPEN = 1;
public static final int WINDSCREEN_WIPER_UNALLOWED_OVERHAUL = 3;
public static synchronized BYDAutoSettingDevice getInstance(Context context) { return null; }
public int factoryResetAll(int i) { return 0; }
public int getACAutoAir() { return 0; }
public int getACAutoWindLevel() { return 0; }
public int getACBTWind() { return 0; }
public int getACPauseCycle() { return 0; }
public int getACTunnelCycle() { return 0; }
public int getAutoExternalRearMirrorFollowUpSwitch() { return 0; }
public int getAutoLock() { return 0; }
public int getAutoLockSwitch() { return 0; }
public int getAutoLockTime() { return 0; }
public int getAutoRainWiperState() { return 0; }
public int getBTCallReductionWindMenuState() { return 0; }
public byte[] getBTMacAddr() { return null; }
public int getBackDoorElectricMode() { return 0; }
public int getBackDoorElectricModeOnlineState() { return 0; }
public int getBackDoorOpenedHeight() { return 0; }
public int getBackHomeLightDelay() { return 0; }
public int getBackHomeLightDelayValue() { return 0; }
public int getBackRowControl() { return 0; }
public int getBasePadAutoRise() { return 0; }
public int getBasePadAutoRiseState() { return 0; }
public int getCarRecorderRecording() { return 0; }
public int getChargingPort() { return 0; }
public int getCourtesyLampTime() { return 0; }
public int getDoorLock() { return 0; }
public int getDriveConfig() { return 0; }
public int getDriveDoorCloseInd() { return 0; }
public int getDriverSeatAutoReturn() { return 0; }
public int getDriverSeatBack() { return 0; }
public int getDrivingRecorder() { return 0; }
public int getDrivingRecorderSwitchState() { return 0; }
public int getDualTempAreaAcOnlineState() { return 0; }
public int getElecHandbrakeState() { return 0; }
public int getEnergyFeedback() { return 0; }
public int getEngineOilExitUpdateState() { return 0; }
public int getEngineOilLevel() { return 0; }
public int getEngineOilUpdateSignal() { return 0; }
public int getExternalRearMirrorAutoFoldSetting() { return 0; }
public int[] getFeatureList() { return null; }
public int getHomeLightTime() { return 0; }
public int getIALArea() { return 0; }
public int getIALBrightness() { return 0; }
public int getIALColor() { return 0; }
public int getIKEYBTLowPowerMode() { return 0; }
public int getILDuration() { return 0; }
public int getINSTheme() { return 0; }
public int getInsBacklightCtl() { return 0; }
public int getInsideLightDoorState() { return 0; }
public int getInsideRearMirrorScreenSwitchState() { return 0; }
public int getIntelligentVoiceIND() { return 0; }
public int getKeyPowerLowInd() { return 0; }
public int getLPSwitchDownwindow() { return 0; }
public int getLPSwitchUpwindow() { return 0; }
public int getLanguage() { return 0; }
public int getLeaveCarPInd() { return 0; }
public int getLeaveHomeLightTime() { return 0; }
public int getLeftHeadlampLevel() { return 0; }
public int getLeftHomeLightDelay() { return 0; }
public int getLeftHomeLightDelayValue() { return 0; }
public int getLeftViewMirrorFlipAngle() { return 0; }
public int getLockCarRiseWindow() { return 0; }
public int getLockOff() { return 0; }
public int getLockUpwindow() { return 0; }
public int getLongPressUnlockWindow() { return 0; }
public int getLowBatteryInd() { return 0; }
public int getLowOilInd() { return 0; }
public int getMaintainRemindState() { return 0; }
public int getMicroSwitchLockWindowState() { return 0; }
public int getMicroSwitchUnlockWindowState() { return 0; }
public int getMissKeyInd() { return 0; }
public int getMultimediaMotorTemperatureState() { return 0; }
public int getNightDRLightOnInd() { return 0; }
public int getNightDriveLightOnReminder() { return 0; }
public int getOverspeedLock() { return 0; }
public int getOverspeedLockingState() { return 0; }
public int getPM25Power() { return 0; }
public int getPM25Switch() { return 0; }
public int getPM25SwitchCheck() { return 0; }
public int getPM25TimeCheck() { return 0; }
public int getPanoramaSunRoofOnlineState() { return 0; }
public int getParkBrakeInd() { return 0; }
public int getRearAcOnlineState() { return 0; }
public int getRearMirrorFlip() { return 0; }
public int getRearViewMirrorAutoFoldMode() { return 0; }
public int getRearViewMirrorAutoFoldModeOnlineState() { return 0; }
public int getRearViewMirrorFlip() { return 0; }
public int getRemoteControlDownwindow() { return 0; }
public int getRemoteControlDownwindowState() { return 0; }
public int getRemoteControlUpwindow() { return 0; }
public int getRemoteControlUpwindowState() { return 0; }
public int getRemoteCtlUnlockingState() { return 0; }
public int getRemoteDrivingOnlineState() { return 0; }
public int getRightHeadlampLevel() { return 0; }
public int getRightViewMirrorFlipAngle() { return 0; }
public int getSOCConfig() { return 0; }
public int getSOCTarget() { return 0; }
public int getSafeBeltInd() { return 0; }
public int getSafeWarnState() { return 0; }
public int getSeatHeatingState(int i) { return 0; }
public int getSeatHeatingState1(int i) { return 0; }
public int getSeatVentilatingState(int i) { return 0; }
public int getStartKeyState() { return 0; }
public int getStartOrPowerInd() { return 0; }
public int getSteerAssis() { return 0; }
public int getSteerAssistPermission() { return 0; }
public int getSteerBack() { return 0; }
public int getSteerPositionAutoReturn() { return 0; }
public int getSteerType() { return 0; }
public int getStopRemoteCtrlDriveInd() { return 0; }
public int getType() { return 0; }
public int getUnlockDownwindow() { return 0; }
public int getUnlockSettingOnlineState() { return 0; }
public int getVoiceINDLevel() { return 0; }
public int getWindscreenWiperOverhaulState(int i) { return 0; }
public int hasFeature(String str) { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public int queryAllStatus() { return 0; }
public void registerListener(AbsBYDAutoSettingListener absBYDAutoSettingListener) { }
public int reset(int i, int i2) { return 0; }
public int restoreCarDefaultValue() { return 0; }
public int restoreDrDefaultValue() { return 0; }
public int sendBTMacToIKEY(byte[] bArr) { return 0; }
public int setACAutoAir(int i) { return 0; }
public int setACAutoWindLevel(int i) { return 0; }
public int setACBTWind(int i) { return 0; }
public int setACPauseCycle(int i) { return 0; }
public int setACTunnelCycle(int i) { return 0; }
public void setAllStatus() { }
public int setAutoExternalRearMirrorFollowUpSwitch(int i) { return 0; }
public int setAutoLockSwitch(int i) { return 0; }
public int setAutoLockTime(int i) { return 0; }
public int setAutoRainWiperState(int i) { return 0; }
public int setBTCallState(int i) { return 0; }
public int setBackDoorElectricMode(int i) { return 0; }
public int setBackDoorOpenedHeight(int i) { return 0; }
public int setBackHomeLightDelay(int i) { return 0; }
public int setBackHomeLightDelayValue(int i) { return 0; }
public int setBackRowControl(int i) { return 0; }
public int setBasePadAutoRiseState(int i) { return 0; }
public int setCallState(int i) { return 0; }
public int setCarRecorderRecording(int i) { return 0; }
public int setChargingPort(int i) { return 0; }
public int setCourtesyLampTime(int i) { return 0; }
public int setDoorLock(int i) { return 0; }
public int setDriveDoorCloseInd(int i) { return 0; }
public int setDriverSeatAutoReturn(int i) { return 0; }
public int setDrivingRecorderSwitchState(int i) { return 0; }
public int setEnergyFeedback(int i) { return 0; }
public int setEngineOilExitUpdateState(int i) { return 0; }
public int setFormatMemoryCard(int i) { return 0; }
public int setHeadlampLevel(int i) { return 0; }
public int setIALArea(int i) { return 0; }
public int setIALBrightness(int i) { return 0; }
public int setIALColor(int i) { return 0; }
public int setIALInfo(int i, int i2, int i3, int i4) { return 0; }
public int setILDuration(int i) { return 0; }
public int setINSTheme(int i) { return 0; }
public int setInsideLightDoorState(int i) { return 0; }
public int setInsideRearMirrorScreenState(int i) { return 0; }
public int setInsideRearMirrorScreenSwitchState(int i) { return 0; }
public int setIntelligentVoiceIND(int i) { return 0; }
public int setKeyPowerLowInd(int i) { return 0; }
public int setLanguage(int i) { return 0; }
public int setLeaveCarPInd(int i) { return 0; }
public int setLeftHomeLightDelay(int i) { return 0; }
public int setLeftHomeLightDelayValue(int i) { return 0; }
public int setLeftViewMirrorFlipAngle(int i) { return 0; }
public int setLockCarRiseWindow(int i) { return 0; }
public int setLockOff(int i) { return 0; }
public int setLockReplayVideo(int i) { return 0; }
public int setLongPressUnlockWindow(int i) { return 0; }
public int setLowBatteryInd(int i) { return 0; }
public int setLowOilInd(int i) { return 0; }
public int setMcuPH2State(int i) { return 0; }
public int setMicroSwitchLockWindowState(int i) { return 0; }
public int setMicroSwitchUnlockWindowState(int i) { return 0; }
public int setMissKeyInd(int i) { return 0; }
public int setNightDRLightOnInd(int i) { return 0; }
public int setOverspeedLock(int i) { return 0; }
public int setOverspeedLockingState(int i) { return 0; }
public int setPM25Power(int i) { return 0; }
public int setPM25Switch(int i) { return 0; }
public int setPM25SwitchCheck(int i) { return 0; }
public int setPM25TimeCheck(int i) { return 0; }
public int setPadRotation(int i) { return 0; }
public int setParkBrakeInd(int i) { return 0; }
public int setRearViewMirrorAutoFoldMode(int i) { return 0; }
public int setRearViewMirrorFlip(int i) { return 0; }
public int setRemoteControlDownwindowState(int i) { return 0; }
public int setRemoteControlUpwindowState(int i) { return 0; }
public int setRemoteCtlUnlockingState(int i) { return 0; }
public int setRightViewMirrorFlipAngle(int i) { return 0; }
public int setSOCTarget(int i) { return 0; }
public int setSafeBeltInd(int i) { return 0; }
public int setSeatHeatingState(int i, int i2) { return 0; }
public int setSeatHeatingState1(int i, int i2) { return 0; }
public int setSeatVentilatingState(int i, int i2) { return 0; }
public int setStartOrPowerInd(int i) { return 0; }
public int setSteerAssis(int i) { return 0; }
public int setSteerPositionAutoReturn(int i) { return 0; }
public int setStopRemoteCtrlDriveInd(int i) { return 0; }
public int setVoiceINDLevel(int i) { return 0; }
public int setWindscreenWiperOverhaulState(int i, int i2) { return 0; }
public int takeDrivingRecorderPicture() { return 0; }
public int turnOffInsideLight() { return 0; }
public void unregisterListener(AbsBYDAutoSettingListener absBYDAutoSettingListener) { }
public int voiceCtlBackDoor(int i) { return 0; }
public int getIALBrightness(int i) { return 0; }
public int getIALColor(int i) { return 0; }
public void registerListener(AbsBYDAutoSettingListener absBYDAutoSettingListener, int[] iArr) { }
public int setIALArea(int i, int i2) { return 0; }
public int setIALBrightness(int i, int i2, int i3) { return 0; }
public int setIALColor(int i, int i2, int i3) { return 0; }
public int turnOffInsideLight(int i) { return 0; }
 }
