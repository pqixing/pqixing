package android.hardware.bydauto.instrument;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class BYDAutoInstrumentDevice extends AbsBYDAutoDevice {
    public static final int ALARM_BUZZLE_STATE = 32;
    public static final int AVERAGE_SPEED_MAX = 240;
    public static final int AVERAGE_SPEED_MIN = 0;
    public static final int BAR = 1;
    public static final int B_MALFUNCTION_ABS = 14;
    public static final int B_MALFUNCTION_ACC_SYSTEM = 36;
    public static final int B_MALFUNCTION_AC_HEAT_MANAGEMENT = 7;
    public static final int B_MALFUNCTION_AEB_SYSTEM = 43;
    public static final int B_MALFUNCTION_AUTO_NETWORK = 24;
    public static final int B_MALFUNCTION_BRAKE_FLUID_LEVEL_LOW = 3;
    public static final int B_MALFUNCTION_BRAKE_PAD = 32;
    public static final int B_MALFUNCTION_BRAKE_SYSTEM = 4;
    public static final int B_MALFUNCTION_BRAKE_SYSTEM_1 = 11;
    public static final int B_MALFUNCTION_BSD_SYSTEM = 40;
    public static final int B_MALFUNCTION_CHARGING_EQUIPMENT = 2;
    public static final int B_MALFUNCTION_CHARGING_SYSTEM = 20;
    public static final int B_MALFUNCTION_COOLANT_LEVEL_LOW = 6;
    public static final int B_MALFUNCTION_ELECTRONIC_PARKING_SYSTEM = 12;
    public static final int B_MALFUNCTION_ENGINE_ACCESSORY_FUNCTION_LIMIT = 26;
    public static final int B_MALFUNCTION_ENGINE_OIL_DETECTING_SYSTEM = 9;
    public static final int B_MALFUNCTION_ENGINE_OIL_PRESSURE_LACK = 8;
    public static final int B_MALFUNCTION_ENGINE_SYSTEM = 25;
    public static final int B_MALFUNCTION_ESP = 30;
    public static final int B_MALFUNCTION_EV_FUNCTION_LIMIT = 18;
    public static final int B_MALFUNCTION_FCW_SYSTEM = 41;
    public static final int B_MALFUNCTION_GEAR_SYSTEM = 19;
    public static final int B_MALFUNCTION_HDC = 31;
    public static final int B_MALFUNCTION_HMA_SYSTEM = 39;
    public static final int B_MALFUNCTION_IRON_BATTERY = 22;
    public static final int B_MALFUNCTION_IRON_BATTERY_POWER_LOW = 23;
    public static final int B_MALFUNCTION_LDW = 47;
    public static final int B_MALFUNCTION_LEFT_HEADLAMP_SYSTEM = 33;
    public static final int B_MALFUNCTION_LKS = 46;
    public static final int B_MALFUNCTION_LOW_VOLTAGE_POWER_SUPPLY_SYSTEM = 15;
    public static final int B_MALFUNCTION_MAX = 48;
    public static final int B_MALFUNCTION_MEMORY_SYSTEM = 35;
    public static final int B_MALFUNCTION_MULTIFUNCTION_VIDEO_CONTROLLER = 44;
    public static final int B_MALFUNCTION_MULTI_VIDEO_CON_FUNCTION_LIMIT = 45;
    public static final int B_MALFUNCTION_PARKING_POWER_LACK = 13;
    public static final int B_MALFUNCTION_PEDESTRIAN_DETECTION_SYSTEM = 37;
    public static final int B_MALFUNCTION_POWER_GENERATION_SYSTEM = 16;
    public static final int B_MALFUNCTION_POWER_SYSTEM = 17;
    public static final int B_MALFUNCTION_PRE_MILLIMETER_WAVE_RADAR = 42;
    public static final int B_MALFUNCTION_RIGHT_HEADLAMP_SYSTEM = 34;
    public static final int B_MALFUNCTION_SRS = 29;
    public static final int B_MALFUNCTION_START_TYPE_IRON_BATTERY_SYSTEM = 21;
    public static final int B_MALFUNCTION_STEERING_SYSTEM = 5;
    public static final int B_MALFUNCTION_TIRE_PRESSURE_DETECTING_SYSTEM = 10;
    public static final int B_MALFUNCTION_TRAFFIC_SIGN_RECOGNITION_SYSTEM = 38;
    public static final int B_MALFUNCTION_TRANSMISSION_FUNCTION_LIMIT = 27;
    public static final int B_MALFUNCTION_TRANSMISSION_SYSTEM = 28;
    public static final int B_MALFUNCTION_VEHICLE_CHARGING_SYSTEM = 1;
    public static final int B_M_ABS = 113;
    public static final int B_M_ACC_SYSTEM = 135;
    public static final int B_M_AC_HEAT_MANAGEMENT = 106;
    public static final int B_M_AEB_SYSTEM = 142;
    public static final int B_M_AUTO_NETWORK = 123;
    public static final int B_M_BRAKE_FLUID_LEVEL_LOW = 102;
    public static final int B_M_BRAKE_PAD = 131;
    public static final int B_M_BRAKE_SYSTEM = 103;
    public static final int B_M_BRAKE_SYSTEM_1 = 110;
    public static final int B_M_BSD_SYSTEM = 139;
    public static final int B_M_CHARGING_EQUIPMENT = 101;
    public static final int B_M_CHARGING_SYSTEM = 119;
    public static final int B_M_COOLANT_LEVEL_LOW = 105;
    public static final int B_M_ELECTRONIC_PARKING_SYSTEM = 111;
    public static final int B_M_ENGINE_ACCESSORY_FUNCTION_LIMIT = 125;
    public static final int B_M_ENGINE_OIL_DETECTING_SYSTEM = 108;
    public static final int B_M_ENGINE_OIL_PRESSURE_LACK = 107;
    public static final int B_M_ENGINE_SYSTEM = 124;
    public static final int B_M_ESP = 129;
    public static final int B_M_EV_FUNCTION_LIMIT = 117;
    public static final int B_M_FCW_SYSTEM = 140;
    public static final int B_M_GEAR_SYSTEM = 118;
    public static final int B_M_HDC = 130;
    public static final int B_M_HMA_SYSTEM = 138;
    public static final int B_M_IRON_BATTERY = 121;
    public static final int B_M_IRON_BATTERY_POWER_LOW = 122;
    public static final int B_M_LDW = 146;
    public static final int B_M_LEFT_HEADLAMP_SYSTEM = 132;
    public static final int B_M_LKS = 145;
    public static final int B_M_LOW_VOLTAGE_POWER_SUPPLY_SYSTEM = 114;
    public static final int B_M_MEMORY_SYSTEM = 134;
    public static final int B_M_MULTIFUNCTION_VIDEO_CONTROLLER = 143;
    public static final int B_M_MULTI_VIDEO_CON_FUNCTION_LIMIT = 144;
    public static final int B_M_PARKING_POWER_LACK = 112;
    public static final int B_M_PEDESTRIAN_DETECTION_SYSTEM = 136;
    public static final int B_M_POWER_GENERATION_SYSTEM = 115;
    public static final int B_M_POWER_SYSTEM = 116;
    public static final int B_M_PRE_MILLIMETER_WAVE_RADAR = 141;
    public static final int B_M_RIGHT_HEADLAMP_SYSTEM = 133;
    public static final int B_M_SRS = 128;
    public static final int B_M_START_TYPE_IRON_BATTERY_SYSTEM = 120;
    public static final int B_M_STEERING_SYSTEM = 104;
    public static final int B_M_TIRE_PRESSURE_DETECTING_SYSTEM = 109;
    public static final int B_M_TRAFFIC_SIGN_RECOGNITION_SYSTEM = 137;
    public static final int B_M_TRANSMISSION_FUNCTION_LIMIT = 126;
    public static final int B_M_TRANSMISSION_SYSTEM = 127;
    public static final int B_M_VEHICLE_CHARGING_SYSTEM = 100;
    public static final int CALL_DIAL = 1;
    public static final int CALL_HANG_UP = 2;
    public static final int CALL_TIME_HOUR_INVALID = 255;
    public static final int CALL_TIME_HOUR_MAX = 99;
    public static final int CALL_TIME_HOUR_MIN = 0;
    public static final int CALL_TIME_MINUTE_INVALID = 255;
    public static final int CALL_TIME_MINUTE_MAX = 59;
    public static final int CALL_TIME_MINUTE_MIN = 0;
    public static final int CALL_TIME_SECOND_INVALID = 255;
    public static final int CALL_TIME_SECOND_MAX = 59;
    public static final int CALL_TIME_SECOND_MIN = 0;
    public static final int CAMERA_TYPE_BUS_LANE = 8;
    public static final int CAMERA_TYPE_EMERGENCY_LANE = 17;
    public static final int CAMERA_TYPE_HOV_LANE = 18;
    public static final int CAMERA_TYPE_INTERVAL_IN = 5;
    public static final int CAMERA_TYPE_INTERVAL_OUT = 9;
    public static final int CAMERA_TYPE_LEFT_TURN_FOBIDDEN = 12;
    public static final int CAMERA_TYPE_NONE = 0;
    public static final int CAMERA_TYPE_NO_ADMITTANCE = 15;
    public static final int CAMERA_TYPE_NO_AUTO_LANE = 6;
    public static final int CAMERA_TYPE_NO_PARKING = 10;
    public static final int CAMERA_TYPE_NO_PASS_GREEN_LIGHT = 19;
    public static final int CAMERA_TYPE_ONE_WAY_ROAD = 11;
    public static final int CAMERA_TYPE_PECCANRY = 3;
    public static final int CAMERA_TYPE_PRESS_PHOTO = 4;
    public static final int CAMERA_TYPE_RIGHT_TURN_FOBIDDEN = 13;
    public static final int CAMERA_TYPE_SECURITY_MONITORING = 7;
    public static final int CAMERA_TYPE_SPEED_LIMITED = 1;
    public static final int CAMERA_TYPE_TRAFFIC_LIGHT = 2;
    public static final int CAMERA_TYPE_U_TURN_FOBIDDEN = 14;
    public static final int CAMERA_TYPE_VEHICLE_LIMITED = 16;
    public static final int CLEAR_INFO_AVERAGE_ENERGY_CONSUMPTION_LATEST_50KM = 5;
    public static final int CLEAR_INFO_AVERAGE_SPEED = 3;
    public static final int CLEAR_INFO_EXTERNAL_CHARGE_POWER = 2;
    public static final int CLEAR_INFO_FUEL_CONSUMPTION = 1;
    public static final int CLEAR_INFO_TRAVEL_TIME = 4;
    private static final boolean DEBUG = true;
    public static final int DEFAULT_STATE = 0;
    public static final int DEGREE_CENTIGRADE = 1;
    public static final int DEGREE_FAHRENHEIT = 2;
    public static final int DEVICE_HAS_THE_MALFUNCTION = 1;
    public static final int DEVICE_NOT_HAS_THE_MALFUNCTION = 0;
    public static final int DISTANCE_MAX = 16777214;
    public static final int DISTANCE_MIN = 0;
    public static final double EXTERNAL_CHARGING_POWER_MAX = 10000.0d;
    public static final double EXTERNAL_CHARGING_POWER_MIN = 0.0d;
    public static final int FUEL_CONSUMPTION_AND_DISTANCE_UNIT = 3;
    public static final int HP = 2;
    public static final int INFOR_LENGTH_MAX = 255;
    public static final int INFOR_LENGTH_MIN = 0;
    public static final int INSTRUMENT_ABS_SYSTEM_BREAKDOWN = 5;
    public static final int INSTRUMENT_AC_CHARGING_EQUIPMENT = 87;
    public static final int INSTRUMENT_AC_HEAT_MANAGEMENT = 53;
    public static final int INSTRUMENT_ADAPTIVE_CRUISE_CONTROL_SYSTEM = 69;
    public static final int INSTRUMENT_ALARM_BUZZLE_ATATE_OFF = 0;
    public static final int INSTRUMENT_ALARM_BUZZLE_ATATE_ON = 1;
    public static final int INSTRUMENT_AVERAGE_SPEED = 76;
    public static final int INSTRUMENT_BACKLIGHT_AUTO_MODE_STATE = 23;
    public static final int INSTRUMENT_BACKLIGHT_BRIGHTNESS = 24;
    public static final int INSTRUMENT_BACKLIGHT_BRIGHTNESS_MAX = 11;
    public static final int INSTRUMENT_BACKLIGHT_BRIGHTNESS_MIN = 1;
    public static final int INSTRUMENT_BACKLIGHT_LINK_MODE_STATE = 31;
    public static final int INSTRUMENT_BACKLIGHT_MODE_AUTO = 1;
    public static final int INSTRUMENT_BACKLIGHT_MODE_OFF = 0;
    public static final int INSTRUMENT_BACKLIGHT_MODE_ON = 1;
    public static final int INSTRUMENT_BACKLIGHT_MODE_RELATE = 2;
    public static final int INSTRUMENT_BATTERY_BREAKDOWN = 15;
    public static final int INSTRUMENT_BATTERY_TOO_HIGH = 16;
    public static final int INSTRUMENT_BLIND_AREA_DETECTION_SYSTEM = 73;
    public static final int INSTRUMENT_BRAKE_PADS = 62;
    public static final int INSTRUMENT_CALL_INFO = 42;
    public static final int INSTRUMENT_CALL_INFO_RESULT = 46;
    public static final int INSTRUMENT_CALL_STATE = 34;
    public static final int INSTRUMENT_CALL_TIME_HOUR = 37;
    public static final int INSTRUMENT_CALL_TIME_MINUTE = 38;
    public static final int INSTRUMENT_CALL_TIME_SECOND = 39;
    public static final int INSTRUMENT_CAMERA_DISPLAY_STATE = 154;
    public static final int INSTRUMENT_CAR_CHARGER = 86;
    public static final int INSTRUMENT_CHARGING_CABINET = 85;
    public static final int INSTRUMENT_CHARGING_GUN_CONNECTION = 88;
    public static final int INSTRUMENT_CHARGING_GUN_NOT_DISCONNECT = 166;
    public static final int INSTRUMENT_CHARGING_SOCKET = 68;
    public static final int INSTRUMENT_CHARGING_SYSTEM_BREAKDOWN = 3;
    public static final int INSTRUMENT_CLEAR_INFO_AVERAGE_ENERGY_CONSUMPTION_LATEST_50KM = 78;
    public static final int INSTRUMENT_CLEAR_INFO_AVERAGE_SPEED = 81;
    public static final int INSTRUMENT_CLEAR_INFO_EXTERNAL_CHARGE_POWER = 80;
    public static final int INSTRUMENT_CLEAR_INFO_FUEL_CONSUMPTION = 79;
    public static final int INSTRUMENT_CLEAR_INFO_TRAVEL_TIME = 82;
    public static final int INSTRUMENT_COMMAND_BUSY = -2147482647;
    public static final int INSTRUMENT_COMMAND_FAILED = -2147482648;
    public static final int INSTRUMENT_COMMAND_INVALID_VALUE = -2147482645;
    public static final int INSTRUMENT_COMMAND_SUCCESS = 0;
    public static final int INSTRUMENT_COMMAND_TIMEOUT = -2147482646;
    private static final String INSTRUMENT_COMMON_PERM = "android.permission.BYDAUTO_INSTRUMENT_COMMON";
    public static final int INSTRUMENT_DC_SYSTEM = 75;
    public static final int INSTRUMENT_DISPLAY_BREAKDOWN = 0;
    public static final int INSTRUMENT_ELECTIC_PARKING_FAIL = 54;
    public static final int INSTRUMENT_ELECTRONIC_PARKING = 9;
    public static final int INSTRUMENT_ENERGY_SYSTEM_INDICATOR = 17;
    public static final int INSTRUMENT_ENGINE_BREAKDOWN = 4;
    public static final int INSTRUMENT_ENGINE_COOLANT_LOW = 89;
    public static final int INSTRUMENT_ENGINE_OIL_DETECTION_SYSTEM = 90;
    public static final int INSTRUMENT_ENGINE_PART_FUNCTION = 59;
    public static final int INSTRUMENT_ENGINE_SYSTEM = 58;
    public static final int INSTRUMENT_EPS_INDICATOR = 11;
    public static final int INSTRUMENT_ESC_INDICATOR = 6;
    public static final int INSTRUMENT_EV_FUNCTION = 55;
    public static final int INSTRUMENT_EV_MODE_INDICATORE = 19;
    public static final int INSTRUMENT_EXTERNAL_CHARGING_POWER = 77;
    public static final int INSTRUMENT_FRONT_CROSSING_DISTANCE = 149;
    public static final int INSTRUMENT_FRONT_LIGHT_SYSTEM = 65;
    public static final int INSTRUMENT_FRONT_SAFEBELT_WARN_SWITCH = 22;
    public static final int INSTRUMENT_GEAR_SYSTEM = 56;
    private static final String INSTRUMENT_GET_PERM = "android.permission.BYDAUTO_INSTRUMENT_GET";
    public static final int INSTRUMENT_GUIDE_INFO_CAMERA = 153;
    public static final int INSTRUMENT_GUIDE_INFO_SAFETY = 155;
    public static final int INSTRUMENT_GUIDE_INFO_SIMPLE = 148;
    public static final int INSTRUMENT_HEV_MODE_INDICATORE = 20;
    public static final int INSTRUMENT_HIGH_VOLTAGE_SYSTEM_LEAKAGE = 163;
    public static final int INSTRUMENT_HIGH_WATER_TEMPERATURE = 8;
    public static final int INSTRUMENT_INTELLIGENT_FAR_LIGHT_LAMP_SYSTEM = 72;
    public static final int INSTRUMENT_IRON_BATTERY = 57;
    public static final int INSTRUMENT_LANE_ASSISTANCE_SYSTEM = 70;
    public static final int INSTRUMENT_LCD_SCREEN = 2;
    public static final int INSTRUMENT_LEFT_FRONT_LIGHT_SYSTEM = 63;
    public static final int INSTRUMENT_LOW_OIL_PRESSURE = 1;
    public static final int INSTRUMENT_LOW_VOLTAGE_BATTERY_SYSTEM = 165;
    public static final int INSTRUMENT_MAINTAIN_RESET = 161;
    public static final int INSTRUMENT_MAINTENANCE_MILEAGE = 30;
    public static final int INSTRUMENT_MAINTENANCE_TIME = 29;
    public static final int INSTRUMENT_MEMORY_SYSTEM = 66;
    public static final int INSTRUMENT_MOTOR_COOLANT_TEMP_OVER_HIGH = 164;
    public static final int INSTRUMENT_MOTOR_TOO_HIGH = 14;
    public static final int INSTRUMENT_MUSIC_INFO = 41;
    public static final int INSTRUMENT_MUSIC_INFO_RESULT = 45;
    public static final int INSTRUMENT_MUSIC_PLAYBACK_PROGRESS = 36;
    public static final int INSTRUMENT_MUSIC_SOURCE = 40;
    public static final int INSTRUMENT_MUSIC_STATE = 33;
    public static final int INSTRUMENT_NETWORK_SYSTEM = 91;
    public static final int INSTRUMENT_OK_INDICATOR = 18;
    public static final int INSTRUMENT_PARKING_BRAKING = 2;
    public static final int INSTRUMENT_PEN_DUAN_SCREEN = 1;
    public static final int INSTRUMENT_PREDICTIVE_BRAKE_SYSTEM = 74;
    public static final int INSTRUMENT_QUICK_AIR_LEAK = 7;
    public static final int INSTRUMENT_RADIO_INFO = 43;
    public static final int INSTRUMENT_RADIO_INFO_RESULT = 47;
    public static final int INSTRUMENT_RADIO_STATE = 35;
    public static final int INSTRUMENT_RIGHT_FRONT_LIGHT_SYSTEM = 64;
    public static final int INSTRUMENT_SAFETY_DISPLAY_STATE = 156;
    public static final int INSTRUMENT_SCREEN_INVALID = 0;
    public static final int INSTRUMENT_SCREEN_TYPE = 147;
    private static final String INSTRUMENT_SET_PERM = "android.permission.BYDAUTO_INSTRUMENT_SET";
    public static final int INSTRUMENT_SMART_KEY_SYS_WARN_LIGHT = 21;
    public static final int INSTRUMENT_SRS_BREAKDOWN = 10;
    public static final int INSTRUMENT_STEERING_SYSTEM = 52;
    public static final int INSTRUMENT_SUNROOF_SYSTEM = 67;
    public static final int INSTRUMENT_SVS_INDICATOR = 13;
    public static final int INSTRUMENT_TIRE_PRESSURE_BREAKDOWN = 12;
    public static final int INSTRUMENT_TRAFFIC_SIGN_RECOGNITION_SYSTEM = 71;
    public static final int INSTRUMENT_TRANSMISSION_FUNCTION = 60;
    public static final int INSTRUMENT_TRANSMISSION_SYSTEM = 61;
    public static final int INSTRUMENT_UNIT_FUELCON_DISTANCE = 27;
    public static final int INSTRUMENT_UNIT_POWER = 28;
    public static final int INSTRUMENT_UNIT_PRESSURE = 26;
    public static final int INSTRUMENT_UNIT_RESET = 162;
    public static final int INSTRUMENT_UNIT_TEMPERATURE = 25;
    public static final int KEY_DETECTION_REMINDER = 51;
    public static final int KEY_DETECTION_REMINDER_INVALID = 0;
    public static final int KEY_DETECTION_REMINDER_KEY_LEAVING = 2;
    public static final int KEY_DETECTION_REMINDER_NO_KEY = 1;
    public static final int KM_P_L_AND_KM = 2;
    public static final int KPA = 3;
    public static final int KW = 1;
    public static final int KWH_P_100KM_AND_KM = 5;
    public static final int KWH_P_100MI_AND_MILE = 6;
    public static final int L_P_100KM_AND_KM = 1;
    public static final int MAINTENANCE_MILEAGE = 2;
    public static final int MAINTENANCE_MILEAGE_KILOMETER_MAX = 20001;
    public static final int MAINTENANCE_MILEAGE_KILOMETER_MIN = 0;
    public static final int MAINTENANCE_TIME = 1;
    public static final int MAINTENANCE_TIME_DAY_MAX = 991;
    public static final int MAINTENANCE_TIME_DAY_MIN = 0;
    public static final int MALFUNCTION_ABS_SYSTEM = 6;
    public static final int MALFUNCTION_AC_CHARGING_EQUIPMENT = 50;
    public static final int MALFUNCTION_AC_HEAT_MANAGEMENT = 25;
    public static final int MALFUNCTION_ADAPTIVE_CRUISE_CONTROL_SYSTEM = 41;
    public static final int MALFUNCTION_BATTERY = 16;
    public static final int MALFUNCTION_BLIND_AREA_DETECTION_SYSTEM = 45;
    public static final int MALFUNCTION_BRAKE_PADS = 34;
    public static final int MALFUNCTION_CAR_CHARGER = 49;
    public static final int MALFUNCTION_CHARGING_CABINET = 48;
    public static final int MALFUNCTION_CHARGING_GUN_CONNECTION = 51;
    public static final int MALFUNCTION_CHARGING_GUN_NOT_DISCONNECT = 58;
    public static final int MALFUNCTION_CHARGING_SOCKET = 40;
    public static final int MALFUNCTION_CHARGING_SYSTEM = 4;
    public static final int MALFUNCTION_DC_SYSTEM = 47;
    public static final int MALFUNCTION_ELECTRIC_PARKING_BRAKE = 10;
    public static final int MALFUNCTION_ELECTRONIC_PARKING = 26;
    public static final int MALFUNCTION_ENGINE = 5;
    public static final int MALFUNCTION_ENGINE_COOLANT_LOW = 52;
    public static final int MALFUNCTION_ENGINE_OIL_DETECTION_SYSTEM = 53;
    public static final int MALFUNCTION_ENGINE_PART_FUNCTION = 31;
    public static final int MALFUNCTION_ENGINE_SYSTEM = 30;
    public static final int MALFUNCTION_EPS = 12;
    public static final int MALFUNCTION_ESP = 7;
    public static final int MALFUNCTION_EV = 20;
    public static final int MALFUNCTION_EV_FUNCTION = 27;
    public static final int MALFUNCTION_FRONT_BELT = 23;
    public static final int MALFUNCTION_FRONT_LIGHT_SYSTEM = 37;
    public static final int MALFUNCTION_GEAR_SYSTEM = 28;
    public static final int MALFUNCTION_HEV = 21;
    public static final int MALFUNCTION_HIGH_BATTERY_TEMPERATURE = 17;
    public static final int MALFUNCTION_HIGH_MOTOR_TEMPERATURE = 15;
    public static final int MALFUNCTION_HIGH_VOLTAGE_SYSTEM_LEAKAGE = 55;
    public static final int MALFUNCTION_HIGH_WATER_TEMPERATURE = 9;
    public static final int MALFUNCTION_INSTRUMENT_DISPLAY = 1;
    public static final int MALFUNCTION_INTELLIGENT_FAR_LIGHT_LAMP_SYSTEM = 44;
    public static final int MALFUNCTION_IRON_BATTERY = 29;
    public static final int MALFUNCTION_LANE_ASSISTANCE_SYSTEM = 42;
    public static final int MALFUNCTION_LEFT_FRONT_LIGHT_SYSTEM = 35;
    public static final int MALFUNCTION_LOW_VOLTAGE_BATTERY_SYSTEM = 57;
    public static final int MALFUNCTION_MACHINE_OIL_LOW_PRESSURE = 2;
    public static final int MALFUNCTION_MAX = 59;
    public static final int MALFUNCTION_MEMORY_SYSTEM = 38;
    public static final int MALFUNCTION_MOTOR_COOLANT_TEMP_OVER_HIGH = 56;
    public static final int MALFUNCTION_NETWORK_SYSTEM = 54;
    public static final int MALFUNCTION_OK = 19;
    public static final int MALFUNCTION_PARKING_BRAKE = 3;
    public static final int MALFUNCTION_POWER_SYSTEM = 18;
    public static final int MALFUNCTION_PREDICTIVE_BRAKE_SYSTEM = 46;
    public static final int MALFUNCTION_QUICK_AIR_LEAK = 8;
    public static final int MALFUNCTION_RIGHT_FRONT_LIGHT_SYSTEM = 36;
    public static final int MALFUNCTION_SMART_KEY = 22;
    public static final int MALFUNCTION_SRS = 11;
    public static final int MALFUNCTION_STEERING_SYSTEM = 24;
    public static final int MALFUNCTION_SUNROOF_SYSTEM = 39;
    public static final int MALFUNCTION_SVS = 14;
    public static final int MALFUNCTION_TRAFFIC_SIGN_RECOGNITION_SYSTEM = 43;
    public static final int MALFUNCTION_TRANSMISSION_FUNCTION = 32;
    public static final int MALFUNCTION_TRANSMISSION_SYSTEM = 33;
    public static final int MALFUNCTION_TYRE_PRESSURE = 13;
    public static final int MPG_GB_AND_MILE = 3;
    public static final int MPG_US_AND_MILE = 4;
    public static final int MUSIC_PAUSE = 2;
    public static final int MUSIC_PLAY = 1;
    public static final int MUSIC_PLAYBACK_PROGRESS_MAX = 100;
    public static final int MUSIC_PLAYBACK_PROGRESS_MIN = 0;
    public static final int MUSIC_SOURCE_AUX = 5;
    public static final int MUSIC_SOURCE_BT = 6;
    public static final int MUSIC_SOURCE_LOCAL = 1;
    public static final int MUSIC_SOURCE_SD = 4;
    public static final int MUSIC_SOURCE_USB1 = 2;
    public static final int MUSIC_SOURCE_USB2 = 3;
    public static final int MUSIC_STOP = 3;
    public static final int NAVI_TRIP_INFO_HOUR = 150;
    public static final int NAVI_TRIP_INFO_MILEAGE = 152;
    public static final int NAVI_TRIP_INFO_MINUTE = 151;
    public static final int NONE = 0;
    public static final int NO_B_MALFUNCTION = 0;
    public static final int NO_MALFUNCTION = 0;
    public static final int POWER_OFF_ERROR_GEAR_SIGNAL_ERR = 3;
    public static final int POWER_OFF_ERROR_INFO = 49;
    public static final int POWER_OFF_ERROR_INVALID = 0;
    public static final int POWER_OFF_ERROR_NO_3G_SIGNAL = 6;
    public static final int POWER_OFF_ERROR_SPEED_OVER_5KMH = 4;
    public static final int POWER_OFF_ERROR_SPEED_OVER_5KMH_START_VALID = 5;
    public static final int POWER_OFF_ERROR_SPEED_SIGNAL_ERR = 1;
    public static final int POWER_OFF_ERROR_WRONG_GEAR = 2;
    public static final int POWER_ON_ERROR_AUTO_NOT_RIGHT_GEAR = 6;
    public static final int POWER_ON_ERROR_BRAKING_SWITCH_ERR = 5;
    public static final int POWER_ON_ERROR_CHECKING_WITH_ECM_ERR = 8;
    public static final int POWER_ON_ERROR_CHECKING_WITH_MM_ERR = 9;
    public static final int POWER_ON_ERROR_COMMU_WITH_ECU_ERR = 4;
    public static final int POWER_ON_ERROR_GEAR_SIGNAL_ERR = 3;
    public static final int POWER_ON_ERROR_IG1_POWER_ERR = 1;
    public static final int POWER_ON_ERROR_INFO = 48;
    public static final int POWER_ON_ERROR_INVALID = 0;
    public static final int POWER_ON_ERROR_MANUAL_NOT_NEUTRAL_GEAR = 10;
    public static final int POWER_ON_ERROR_NO_DETECT_KEY = 11;
    public static final int POWER_ON_ERROR_NO_READY_SIGNAL = 7;
    public static final int POWER_ON_ERROR_PROHIBIT_STARTING = 2;
    public static final int POWER_UNIT = 4;
    public static final int PRESSURE_UNIT = 2;
    public static final int PSI = 2;
    public static final int RADIO_PLAY = 1;
    public static final int RADIO_STOP = 2;
    public static final int REMOTE_DRIVING_REMINDER = 50;
    public static final int REMOTE_DRIVING_REMINDER_OFF = 1;
    public static final int REMOTE_DRIVING_REMINDER_ON = 2;
    public static final int RESET_INVALID = 0;
    public static final int RESET_ITEM_MAINTAIN = 0;
    public static final int RESET_ITEM_UNIT = 1;
    public static final int RESET_VALID = 1;
    public static final int REST_HOURE_MAX = 254;
    public static final int REST_HOUR_MIN = 0;
    public static final int REST_MILEAGE_MAX = Integer.MAX_VALUE;
    public static final int REST_MILEAGE_MIN = 0;
    public static final int REST_MINUTE_MAX = 59;
    public static final int REST_MINUTE_MIN = 0;
    public static final int SAFETY_TYPE_ACCIDENT = 10;
    public static final int SAFETY_TYPE_BLIND_BEND_CONTINUE = 25;
    public static final int SAFETY_TYPE_BLIND_BEND_LEFT = 22;
    public static final int SAFETY_TYPE_BLIND_BEND_REVERSE = 24;
    public static final int SAFETY_TYPE_BLIND_BEND_RIGHT = 23;
    public static final int SAFETY_TYPE_BLIND_SLOPE_CONDOWN = 21;
    public static final int SAFETY_TYPE_BLIND_SLOPE_DOWN = 20;
    public static final int SAFETY_TYPE_BLIND_SLOPE_UP = 19;
    public static final int SAFETY_TYPE_CROSS_WIND = 7;
    public static final int SAFETY_TYPE_HILLSIDE_DANGEROUS = 4;
    public static final int SAFETY_TYPE_HONK = 30;
    public static final int SAFETY_TYPE_HUMP_BRIDGE = 9;
    public static final int SAFETY_TYPE_JOINT_LEFT = 12;
    public static final int SAFETY_TYPE_JOINT_RIGHT = 13;
    public static final int SAFETY_TYPE_LOW_SPEED = 1;
    public static final int SAFETY_TYPE_MANAGE_TRAIN_CROSSWAY = 32;
    public static final int SAFETY_TYPE_NARROW_BOTH = 16;
    public static final int SAFETY_TYPE_NARROW_BRIDGE = 3;
    public static final int SAFETY_TYPE_NARROW_LEFT = 14;
    public static final int SAFETY_TYPE_NARROW_RIGHT = 15;
    public static final int SAFETY_TYPE_NONE = 0;
    public static final int SAFETY_TYPE_OVERTAKE_FORBIDDEN = 29;
    public static final int SAFETY_TYPE_RAILWAY_MANAGED = 26;
    public static final int SAFETY_TYPE_RAILWAY_UNMANAGED = 27;
    public static final int SAFETY_TYPE_ROCK_DOWN_LEFT = 17;
    public static final int SAFETY_TYPE_ROCK_DOWN_RIGHT = 18;
    public static final int SAFETY_TYPE_SCHOOL_ZONE = 8;
    public static final int SAFETY_TYPE_SLIP = 6;
    public static final int SAFETY_TYPE_TUNNEL = 31;
    public static final int SAFETY_TYPE_UNDER_WATER = 2;
    public static final int SAFETY_TYPE_UNEVEN = 5;
    public static final int SAFETY_TYPE_VILLAGE = 28;
    public static final int SAFETY_TYPE_ZIP_PASS = 11;
    public static final int SEND_INFO_FAIL = 2;
    public static final int SEND_INFO_SUCCESS = 1;
    public static final int STATE_INVISIBLE = 1;
    public static final int STATE_VISIBLE = 2;
    protected static final String TAG = "BYDAutoInstrumentDevice";
    public static final int TARGET_COMPANY = 2;
    public static final int TARGET_COMPANY_ADDRESS_INFO = 159;
    public static final int TARGET_HOME = 1;
    public static final int TARGET_HOME_ADDRESS_INFO = 158;
    public static final int TARGET_NEXT_PATHNAME_INFO = 157;
    public static final int TEMPERATURE_UNIT = 1;
    public static final int TURN_KIND_BACK = 5;
    public static final int TURN_KIND_BACK_2BRANCH_LEFT_BASE = 64;
    public static final int TURN_KIND_BACK_2BRANCH_RIGHT_BASE = 65;
    public static final int TURN_KIND_BACK_3BRANCH_LEFT_BASE = 66;
    public static final int TURN_KIND_BACK_3BRANCH_MIDDLE_BASE = 67;
    public static final int TURN_KIND_BACK_3BRANCH_RIGHT_BASE = 68;
    public static final int TURN_KIND_BLANK = 0;
    public static final int TURN_KIND_BRANCH_CENTER = 22;
    public static final int TURN_KIND_BRANCH_CENTER_IC = 40;
    public static final int TURN_KIND_BRANCH_CENTER_IC_STRAIGHT = 43;
    public static final int TURN_KIND_BRANCH_CENTER_STRAIGHT = 37;
    public static final int TURN_KIND_BRANCH_LEFT = 20;
    public static final int TURN_KIND_BRANCH_LEFT_IC = 39;
    public static final int TURN_KIND_BRANCH_LEFT_IC_STRAIGHT = 42;
    public static final int TURN_KIND_BRANCH_LEFT_MAIN = 14;
    public static final int TURN_KIND_BRANCH_LEFT_STRAIGHT = 36;
    public static final int TURN_KIND_BRANCH_RIGHT = 21;
    public static final int TURN_KIND_BRANCH_RIGHT_IC = 41;
    public static final int TURN_KIND_BRANCH_RIGHT_IC_STRAIGHT = 44;
    public static final int TURN_KIND_BRANCH_RIGHT_MAIN = 16;
    public static final int TURN_KIND_BRANCH_RIGHT_STRAIGHT = 38;
    public static final int TURN_KIND_CAR_SIGN = 102;
    public static final int TURN_KIND_CENTER_MAIN = 17;
    public static final int TURN_KIND_DEST = 24;
    public static final int TURN_KIND_FRONT = 1;
    public static final int TURN_KIND_INFERRY = 29;
    public static final int TURN_KIND_LEFT = 7;
    public static final int TURN_KIND_LEFT_2BRANCH_LEFT = 50;
    public static final int TURN_KIND_LEFT_2BRANCH_RIGHT = 51;
    public static final int TURN_KIND_LEFT_3BRANCH_LEFT = 52;
    public static final int TURN_KIND_LEFT_3BRANCH_MIDDLE = 53;
    public static final int TURN_KIND_LEFT_3BRANCH_RIGHT = 54;
    public static final int TURN_KIND_LEFT_BACK = 6;
    public static final int TURN_KIND_LEFT_FRONT = 8;
    public static final int TURN_KIND_LEFT_FRONT_2BRANCH_LEFT = 60;
    public static final int TURN_KIND_LEFT_FRONT_2BRANCH_RIGHT = 61;
    public static final int TURN_KIND_LEFT_SIDE = 11;
    public static final int TURN_KIND_LEFT_SIDE_BACK = 81;
    public static final int TURN_KIND_LEFT_SIDE_IC = 18;
    public static final int TURN_KIND_LEFT_SIDE_MAIN = 13;
    public static final int TURN_KIND_LEFT_SIDE_STRAIGHT = 34;
    public static final int TURN_KIND_LEFT_SIDE_STRAIGHT_IC = 32;
    public static final int TURN_KIND_OUTFERRY = 30;
    public static final int TURN_KIND_RIGHT = 3;
    public static final int TURN_KIND_RIGHT_2BRANCH_LEFT = 55;
    public static final int TURN_KIND_RIGHT_2BRANCH_RIGHT = 56;
    public static final int TURN_KIND_RIGHT_3BRANCH_LEFT = 57;
    public static final int TURN_KIND_RIGHT_3BRANCH_MIDDLE = 58;
    public static final int TURN_KIND_RIGHT_3BRANCH_RIGHT = 59;
    public static final int TURN_KIND_RIGHT_BACK = 4;
    public static final int TURN_KIND_RIGHT_FRONT = 2;
    public static final int TURN_KIND_RIGHT_SIDE = 12;
    public static final int TURN_KIND_RIGHT_SIDE_IC = 19;
    public static final int TURN_KIND_RIGHT_SIDE_MAIN = 15;
    public static final int TURN_KIND_RIGHT_SIDE_STRAIGHT = 35;
    public static final int TURN_KIND_RIGHT_SIDE_STRAIGHT_IC = 33;
    public static final int TURN_KIND_RING = 9;
    public static final int TURN_KIND_RING_BACK = 73;
    public static final int TURN_KIND_RING_FRONT = 69;
    public static final int TURN_KIND_RING_LEFT = 75;
    public static final int TURN_KIND_RING_LEFTBACK = 74;
    public static final int TURN_KIND_RING_LEFTFRONT = 76;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_10OUT = 101;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_1OUT = 92;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_2OUT = 93;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_3OUT = 94;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_4OUT = 95;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_5OUT = 96;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_6OUT = 97;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_7OUT = 98;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_8OUT = 99;
    public static final int TURN_KIND_RING_LEFT_SIDE_ANTICCLOCKWISE_IN_9OUT = 100;
    public static final int TURN_KIND_RING_LEFT_SIDE_CLOCKWISE_IN = 79;
    public static final int TURN_KIND_RING_LEFT_SIDE_CLOCKWISE_OUT = 80;
    public static final int TURN_KIND_RING_OUT = 10;
    public static final int TURN_KIND_RING_RIGHT = 71;
    public static final int TURN_KIND_RING_RIGHTBACK = 72;
    public static final int TURN_KIND_RING_RIGHTFRONT = 70;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_10OUT = 91;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_1OUT = 82;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_2OUT = 83;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_3OUT = 84;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_4OUT = 85;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_5OUT = 86;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_6OUT = 87;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_7OUT = 88;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_8OUT = 89;
    public static final int TURN_KIND_RING_RIGHT_SIDE_ANTICCLOCKWISE_IN_91OUT = 90;
    public static final int TURN_KIND_RIRHGT_FRONT_2BRANCH_LEFT = 62;
    public static final int TURN_KIND_RIRHGT_FRONT_2BRANCH_RIGHT = 63;
    public static final int TURN_KIND_START = 23;
    public static final int TURN_KIND_STRAIGHT = 77;
    public static final int TURN_KIND_STRAIGHT_2BRANCH_LEFT = 45;
    public static final int TURN_KIND_STRAIGHT_2BRANCH_RIGHT = 46;
    public static final int TURN_KIND_STRAIGHT_3BRANCH_LEFT = 47;
    public static final int TURN_KIND_STRAIGHT_3BRANCH_MIDDLE = 48;
    public static final int TURN_KIND_STRAIGHT_3BRANCH_RIGHT = 49;
    public static final int TURN_KIND_TOLLGATE = 31;
    public static final int TURN_KIND_VIA_1 = 25;
    public static final int TURN_KIND_VIA_2 = 26;
    public static final int TURN_KIND_VIA_3 = 27;
    public static final int TURN_KIND_VIA_4 = 28;
    public static final int TURN_KIN_REST_AREA = 78;
    private static int mDeviceType = 1007;
    private static BYDAutoInstrumentDevice mInstance;
    private final Context mContext;

    private BYDAutoInstrumentDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoInstrumentDevice getInstance(Context context) {
        BYDAutoInstrumentDevice bYDAutoInstrumentDevice;
        synchronized (BYDAutoInstrumentDevice.class) {
            if (mInstance == null && context != null) {
                context.enforceCallingOrSelfPermission(INSTRUMENT_COMMON_PERM, null);
                mInstance = new BYDAutoInstrumentDevice(context);
            }
            bYDAutoInstrumentDevice = mInstance;
        }
        return bYDAutoInstrumentDevice;
    }

    public int clearInfo(int i) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "clearInfo: the info is " + i);
        int[] iArr = {0, 0, 0, 0, 0};
        if (i == 1) {
            iArr[0] = 1;
        } else if (i == 2) {
            iArr[1] = 1;
        } else if (i == 3) {
            iArr[2] = 1;
        } else if (i == 4) {
            iArr[3] = 1;
        } else if (i != 5) {
            return -2147482645;
        } else {
            iArr[4] = 1;
        }
        return super.set(mDeviceType, new int[]{79, 80, 81, 82, 78}, iArr);
    }

    public int getAlarmBuzzleState() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 32);
        Log.d(TAG, "getAlarmBuzzleState: the alarm buzzle state is " + i);
        return i;
    }

    public void getAllStatus() {
    }

    public int getAverageSpeed() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 76);
        Log.d(TAG, "getAverageSpeed: the value is " + i);
        return i;
    }

    public int getBacklightBrightness() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 24);
        Log.d(TAG, "getBacklightBrightness: the brightness is " + i);
        return i;
    }

    public int getBacklightModeState(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        if (i == 1) {
            i2 = 23;
        } else if (i != 2) {
            return -2147482645;
        } else {
            i2 = 31;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getBacklightModeState: the backlightMode is " + i + ", and state is " + i3);
        return i3;
    }

    public int getCallInfoResult() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 46);
        Log.d(TAG, "getCallInfoResult: the info result is " + i);
        return i;
    }

    public double getExternalChargingPower() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 77);
        Log.d(TAG, "getExternalChargingPower: the value is " + d2);
        return d2;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getInstrumentScreenType() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 147);
        Log.d(TAG, "getInstrumentScreenType: the type is " + i);
        return i;
    }

    public int getKeyDetectionReminder() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 51);
        Log.d(TAG, "getKeyDetectionReminder: the value is " + i);
        return i;
    }

    public int getMaintenanceInfo(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        if (i == 1) {
            i2 = 29;
        } else if (i != 2) {
            return -2147482645;
        } else {
            i2 = 30;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getMaintenanceInfo: the type name is " + i + ", and info value is " + i3);
        return i3;
    }

    public int getMalfunctionInfo(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        switch (i) {
            case 1:
                i2 = 0;
                break;
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 4;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 6;
                break;
            case 8:
                i2 = 7;
                break;
            case 9:
                i2 = 8;
                break;
            case 10:
                i2 = 9;
                break;
            case 11:
                i2 = 10;
                break;
            case 12:
                i2 = 11;
                break;
            case 13:
                i2 = 12;
                break;
            case 14:
                i2 = 13;
                break;
            case 15:
                i2 = 14;
                break;
            case 16:
                i2 = 15;
                break;
            case 17:
                i2 = 16;
                break;
            case 18:
                i2 = 17;
                break;
            case 19:
                i2 = 18;
                break;
            case 20:
                i2 = 19;
                break;
            case 21:
                i2 = 20;
                break;
            case 22:
                i2 = 21;
                break;
            case 23:
                i2 = 22;
                break;
            case 24:
                i2 = 52;
                break;
            case 25:
                i2 = 53;
                break;
            case 26:
                i2 = 54;
                break;
            case 27:
                i2 = 55;
                break;
            case 28:
                i2 = 56;
                break;
            case 29:
                i2 = 57;
                break;
            case 30:
                i2 = 58;
                break;
            case 31:
                i2 = 59;
                break;
            case 32:
                i2 = 60;
                break;
            case 33:
                i2 = 61;
                break;
            case 34:
                i2 = 62;
                break;
            case 35:
                i2 = 63;
                break;
            case 36:
                i2 = 64;
                break;
            case 37:
                i2 = 65;
                break;
            case 38:
                i2 = 66;
                break;
            case 39:
                i2 = 67;
                break;
            case 40:
                i2 = 68;
                break;
            case 41:
                i2 = 69;
                break;
            case 42:
                i2 = 70;
                break;
            case 43:
                i2 = 71;
                break;
            case 44:
                i2 = 72;
                break;
            case 45:
                i2 = 73;
                break;
            case 46:
                i2 = 74;
                break;
            case 47:
                i2 = 75;
                break;
            case 48:
                i2 = 85;
                break;
            case 49:
                i2 = 86;
                break;
            case 50:
                i2 = 87;
                break;
            case 51:
                i2 = 88;
                break;
            case 52:
                i2 = 89;
                break;
            case 53:
                i2 = 90;
                break;
            case 54:
                i2 = 91;
                break;
            case 55:
                i2 = 163;
                break;
            case 56:
                i2 = 164;
                break;
            case 57:
                i2 = 165;
                break;
            case 58:
                i2 = 166;
                break;
            default:
                return -2147482645;
        }
        int i3 = super.get(mDeviceType, i2);
        if (i3 == 1) {
            Log.d(TAG, "getMalfunctionInfo: If has the malfunction (" + i + "): " + i3);
        }
        return i3;
    }

    public int getMalfunctionInfo2(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        switch (i) {
            case 1:
                i2 = 100;
                break;
            case 2:
                i2 = 101;
                break;
            case 3:
                i2 = 102;
                break;
            case 4:
                i2 = 103;
                break;
            case 5:
                i2 = 104;
                break;
            case 6:
                i2 = 105;
                break;
            case 7:
                i2 = 106;
                break;
            case 8:
                i2 = 107;
                break;
            case 9:
                i2 = 108;
                break;
            case 10:
                i2 = 109;
                break;
            case 11:
                i2 = 110;
                break;
            case 12:
                i2 = 111;
                break;
            case 13:
                i2 = 112;
                break;
            case 14:
                i2 = 113;
                break;
            case 15:
                i2 = 114;
                break;
            case 16:
                i2 = 115;
                break;
            case 17:
                i2 = 116;
                break;
            case 18:
                i2 = 117;
                break;
            case 19:
                i2 = 118;
                break;
            case 20:
                i2 = 119;
                break;
            case 21:
                i2 = 120;
                break;
            case 22:
                i2 = 121;
                break;
            case 23:
                i2 = 122;
                break;
            case 24:
                i2 = 123;
                break;
            case 25:
                i2 = 124;
                break;
            case 26:
                i2 = 125;
                break;
            case 27:
                i2 = 126;
                break;
            case 28:
                i2 = 127;
                break;
            case 29:
                i2 = 128;
                break;
            case 30:
                i2 = 129;
                break;
            case 31:
                i2 = 130;
                break;
            case 32:
                i2 = 131;
                break;
            case 33:
                i2 = 132;
                break;
            case 34:
                i2 = 133;
                break;
            case 35:
                i2 = 134;
                break;
            case 36:
                i2 = 135;
                break;
            case 37:
                i2 = 136;
                break;
            case 38:
                i2 = 137;
                break;
            case 39:
                i2 = 138;
                break;
            case 40:
                i2 = 139;
                break;
            case 41:
                i2 = 140;
                break;
            case 42:
                i2 = 141;
                break;
            case 43:
                i2 = 142;
                break;
            case 44:
                i2 = 143;
                break;
            case 45:
                i2 = 144;
                break;
            case 46:
                i2 = 145;
                break;
            case 47:
                i2 = 146;
                break;
            default:
                return -2147482645;
        }
        int i3 = super.get(mDeviceType, i2);
        if (i3 == 1) {
            Log.d(TAG, "getMalfunctionInfo2: If has the malfunction (" + i + "): " + i3);
        }
        return i3;
    }

    public ArrayList<Integer> getMalfunctionList() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        Log.d(TAG, "getMalfunctionList");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < 48; i++) {
            if (getMalfunctionInfo2(i) == 1) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public int getMusicInfoResult() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 45);
        Log.d(TAG, "getMusicInfoResult: the info result is " + i);
        return i;
    }

    public int getPowerOffErrInfo() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 49);
        Log.d(TAG, "getPowerOffErrInfo: the error is " + i);
        return i;
    }

    public int getPowerOnErrInfo() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 48);
        Log.d(TAG, "getPowerOnErrInfo: the error is " + i);
        return i;
    }

    public int getRadioInfoResult() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 47);
        Log.d(TAG, "getRadioInfoResult: the info result is " + i);
        return i;
    }

    public int getRemoteDrivingReminder() {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        int i = super.get(mDeviceType, 50);
        Log.d(TAG, "getRemoteDrivingReminder: the value is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1007;
    }

    public int getUnit(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        if (i == 1) {
            i2 = 25;
        } else if (i == 2) {
            i2 = 26;
        } else if (i == 3) {
            i2 = 27;
        } else if (i != 4) {
            return -2147482645;
        } else {
            i2 = 28;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getUnit: the unit name is " + i + ", and unit value is " + i3);
        return i3;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoInstrumentListener absBYDAutoInstrumentListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        if (absBYDAutoInstrumentListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoInstrumentListener);
        }
    }

    public int reset(int i, int i2) {
        int i3;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "resetInstrument: item is " + i + " and value is " + i2);
        if (i2 == 0 || i2 == 1) {
            if (i == 0) {
                i3 = 161;
            } else if (i != 1) {
                return -2147482645;
            } else {
                i3 = 162;
            }
            return super.set(mDeviceType, i3, i2);
        }
        return -2147482645;
    }

    public int sendAddressInfo(int i, String str) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        if (str == null) {
            Log.e(TAG, "sendAddressInfo: address is null!");
            return -2147482645;
        }
        try {
            byte[] bytes = str.getBytes("UnicodeLittleUnmarked");
            int length = bytes.length;
            Log.d(TAG, "sendAddressInfo: the address length is " + length);
            if (length >= 0 && length <= 255) {
                if (i == 1) {
                    i2 = 158;
                } else if (i == 2) {
                    i2 = 159;
                }
                return super.set(mDeviceType, i2, bytes);
            }
            return -2147482645;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public int sendCallInfo(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        if (bArr == null) {
            Log.e(TAG, "sendCallInfo: info is null!");
            return -2147482645;
        }
        int length = bArr.length;
        Log.d(TAG, "sendCallInfo: the info length is " + length);
        if (length >= 0 && length <= 255) {
            return super.set(mDeviceType, 42, bArr);
        }
        return -2147482645;
    }

    public int sendCallState(int i) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendCallState: the state is " + i);
        if (i == 0 || i == 1 || i == 2) {
            return super.set(mDeviceType, 34, i);
        }
        return -2147482645;
    }

    public int sendCallTime(int i, int i2, int i3) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendCallTime: hour=" + i + ", minute=" + i2 + ", second=" + i3);
        if (i >= 0) {
            if ((i > 99 && i != 255) || i2 < 0) {
                return -2147482645;
            }
            if ((i2 > 59 && i2 != 255) || i3 < 0) {
                return -2147482645;
            }
            if (i3 > 59 && i3 != 255) {
                return -2147482645;
            }
            return super.set(mDeviceType, new int[]{37, 38, 39}, new int[]{i, i2, i3});
        }
        return -2147482645;
    }

    public int sendCameraGuidanceInfo(int i, int i2, int i3) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendCameraGuidanceInfo: the camera type is " + i + ", and front compress diatance is " + i2 + ", and state is " + i3);
        if ((i3 == 2 || i3 == 1) && i >= 0 && i <= 19) {
            return super.set(mDeviceType, new int[]{153, 154}, new int[]{i, i3});
        }
        return -2147482645;
    }

    public int sendMusicInfo(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        if (bArr == null) {
            Log.e(TAG, "sendMusicInfo: info is null!");
            return -2147482645;
        }
        int length = bArr.length;
        Log.d(TAG, "sendMusicInfo: the info length is " + length);
        if (length >= 0 && length <= 255) {
            return super.set(mDeviceType, 41, bArr);
        }
        return -2147482645;
    }

    public int sendMusicName(String str) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        if (str == null) {
            Log.e(TAG, "sendMusicName: name is null!");
            return -2147482645;
        }
        try {
            byte[] bytes = str.getBytes("UnicodeLittleUnmarked");
            int length = bytes.length;
            Log.d(TAG, "sendMusicName: the name length is " + length);
            if (length >= 0 && length <= 255) {
                return super.set(mDeviceType, 41, bytes);
            }
            return -2147482645;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public int sendMusicPlaybackProgress(int i) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendMusicPlaybackProgress: the progress is " + i);
        if (i < 0 || i > 100) {
            return -2147482645;
        }
        return super.set(mDeviceType, 36, i);
    }

    public int sendMusicSource(int i) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendMusicSource: the source is " + i);
        if (i < 0 || i > 6) {
            return -2147482645;
        }
        return super.set(mDeviceType, 40, i);
    }

    public int sendMusicState(int i) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendMusicState: the state is " + i);
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            return super.set(mDeviceType, 33, i);
        }
        return -2147482645;
    }

    public int sendNextPathName(String str) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        if (str == null) {
            Log.e(TAG, "sendNextPathName: name is null!");
            return -2147482645;
        }
        try {
            byte[] bytes = str.getBytes("UnicodeLittleUnmarked");
            int length = bytes.length;
            Log.d(TAG, "sendNextPathName: the name length is " + length);
            if (length >= 0 && length <= 255) {
                return super.set(mDeviceType, 157, bytes);
            }
            return -2147482645;
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public int sendRadioInfo(byte[] bArr) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        if (bArr == null) {
            Log.e(TAG, "sendRadioInfo: info is null!");
            return -2147482645;
        }
        int length = bArr.length;
        Log.d(TAG, "sendRadioInfo: the info length is " + length);
        if (length >= 0 && length <= 255) {
            return super.set(mDeviceType, 43, bArr);
        }
        return -2147482645;
    }

    public int sendRadioState(int i) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendRadioState: the state is " + i);
        if (i == 0 || i == 1 || i == 2) {
            return super.set(mDeviceType, 35, i);
        }
        return -2147482645;
    }

    public int sendRestRouteInfo(int i, int i2, int i3) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "rest hour is " + i + ", and rest minute is " + i2 + ", and rest mileage is " + i3);
        if (i < 0 || i > 254 || i2 < 0 || i2 > 59 || i3 < 0) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{150, 151, 152}, new int[]{i, i2, i3});
    }

    public int sendSafeGuidanceInfo(int i, int i2, int i3) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendCameraGuidanceInfo: the safety type is " + i + ", and front compress diatance is " + i2 + ", and state is " + i3);
        if ((i3 == 2 || i3 == 1) && i >= 0 && i <= 32) {
            return super.set(mDeviceType, new int[]{155, 156}, new int[]{i, i3});
        }
        return -2147482645;
    }

    public int sendSimpleGuidanceInfo(int i, int i2) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "sendSimpleGuidanceInfo: the simple type is " + i + ", and front compress diatance is " + i2);
        if (i < 0 || i > 102 || i2 < 0 || i2 > 16777214) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{148, 149}, new int[]{i, i2});
    }

    public void setAllStatus() {
    }

    public int setBacklightBrightness(int i) {
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "setBacklightBrightness: the brightness is " + i);
        if (i < 1 || i > 11) {
            return -2147482645;
        }
        return super.set(mDeviceType, 24, i);
    }

    public int setBacklightModeState(int i, int i2) {
        int i3;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "setBacklightModeState: the backlightMode is " + i + ", and state is " + i2);
        if (i2 == 1 || i2 == 0) {
            if (i == 1) {
                i3 = 23;
            } else if (i != 2) {
                return -2147482645;
            } else {
                i3 = 31;
            }
            return super.set(mDeviceType, i3, i2);
        }
        return -2147482645;
    }

    public int setMaintenanceInfo(int i, int i2) {
        int i3;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "setMaintenanceInfo: the type name is " + i + ", and info value is " + i2);
        if (i == 1) {
            if (i2 < 0 || i2 > 991) {
                return -2147482645;
            }
            i3 = 29;
        } else if (i != 2 || i2 < 0 || i2 > 20001) {
            return -2147482645;
        } else {
            i3 = 30;
        }
        return super.set(mDeviceType, i3, i2);
    }

    public int setUnit(int i, int i2) {
        int i3;
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_SET_PERM, null);
        Log.d(TAG, "setUnit: the unit name is " + i + ", and unit value is " + i2);
        if (i == 1) {
            if (i2 != 1 && i2 != 2) {
                return -2147482645;
            }
            i3 = 25;
        } else if (i == 2) {
            if (i2 != 1 && i2 != 2 && i2 != 3) {
                return -2147482645;
            }
            i3 = 26;
        } else if (i == 3) {
            if (i2 < 1 || i2 > 6) {
                return -2147482645;
            }
            i3 = 27;
        } else if (i != 4) {
            return -2147482645;
        } else {
            if (i2 != 1 && i2 != 2) {
                return -2147482645;
            }
            i3 = 28;
        }
        return super.set(mDeviceType, i3, i2);
    }

    public void unregisterListener(AbsBYDAutoInstrumentListener absBYDAutoInstrumentListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        if (absBYDAutoInstrumentListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoInstrumentListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + d2);
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }

    public void registerListener(AbsBYDAutoInstrumentListener absBYDAutoInstrumentListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(INSTRUMENT_GET_PERM, null);
        if (absBYDAutoInstrumentListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoInstrumentListener, iArr);
        }
    }
}
