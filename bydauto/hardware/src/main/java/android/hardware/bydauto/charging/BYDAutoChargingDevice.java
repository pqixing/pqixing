//refactor
package android.hardware.bydauto.charging;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
public final class BYDAutoChargingDevice extends AbsBYDAutoDevice {
public static final int BATTERY_TYPE = 53;
public static final int BATTERY_TYPE_INVALID = 65535;
public static final int BATTERY_TYPE_IRON = 1;
public static final int BATTERY_TYPE_LEAD_ACID = 0;
public static final int CHARGER_FAULT_STATE = 18;
public static final int CHARGER_WORK_STATE = 19;
public static final int CHARGE_BATTERY_VOLT = 44;
public static final int CHARGE_CURRENT = 45;
public static final int CHARGE_DISCHARGE_WARNING = 46;
public static final int CHARGE_PORT_LOCK_REBACK = 26;
public static final int CHARGE_RESET = 50;
public static final int CHARGE_TEMPERATURE_CTL_ONLINE = 52;
public static final int CHARGE_TEMPERATURE_CTL_STATE = 51;
public static final int CHARGE_TEMP_CTL_STATE_INVALID = 0;
public static final int CHARGE_TEMP_CTL_STATE_OFF = 2;
public static final int CHARGE_TEMP_CTL_STATE_ON = 1;
public static final int CHARGE_WIRELESS_CHARGING_INVALID = 0;
public static final int CHARGE_WIRELESS_CHARGING_OFF = 2;
public static final int CHARGE_WIRELESS_CHARGING_ON = 1;
public static final int CHARGE_WIRELESS_CHARGING_ONLINE_OFF = 0;
public static final int CHARGE_WIRELESS_CHARGING_ONLINE_ON = 1;
public static final int CHARGE_WIRELESS_CHARGING_STATE = 49;
public static final int CHARGE_WIRELESS_CHARGING_SWITCH = 54;
public static final int CHARGING_BATTERRY_DEVICE_STATE = 30;
public static final int CHARGING_BATTERY_STATE_BREAKDOWN_AC = 8;
public static final int CHARGING_BATTERY_STATE_BREAKDOWN_C10 = 5;
public static final int CHARGING_BATTERY_STATE_BREAKDOWN_CHARGER = 7;
public static final int CHARGING_BATTERY_STATE_BREAKDOWN_CHARGING_GUN = 6;
public static final int CHARGING_BATTERY_STATE_CHARGING = 1;
public static final int CHARGING_BATTERY_STATE_CHARGING_PAUSE = 13;
public static final int CHARGING_BATTERY_STATE_CHARG_FINISH = 2;
public static final int CHARGING_BATTERY_STATE_CHARG_TERMINATE = 4;
public static final int CHARGING_BATTERY_STATE_DISCHARG = 3;
public static final int CHARGING_BATTERY_STATE_DISCHARG_CBU = 10;
public static final int CHARGING_BATTERY_STATE_DISCHARG_FINISH = 12;
public static final int CHARGING_BATTERY_STATE_READY = 0;
public static final int CHARGING_BATTERY_STATE_SCHEDULE = 9;
public static final int CHARGING_BATTERY_STATE_TIMEOUT = 11;
public static final int CHARGING_CAPACITY = 20;
public static final double CHARGING_CAPACITY_MAX = 131.07d;
public static final double CHARGING_CAPACITY_MIN = 0.0d;
public static final int CHARGING_CAP_AC = 1;
public static final int CHARGING_CAP_DC = 2;
public static final int CHARGING_CAP_STATE_AC = 24;
public static final int CHARGING_CAP_STATE_DC = 25;
public static final int CHARGING_CAP_STATE_OFF = 0;
public static final int CHARGING_CAP_STATE_ON = 1;
public static final int CHARGING_CHARGER_CONNECT_STATE = 1;
public static final int CHARGING_CHARGER_STATE_CONNECTED = 1;
public static final int CHARGING_CHARGER_STATE_NOT_CONNECTED = 0;
public static final int CHARGING_COMMAND_BUSY = -2147482647;
public static final int CHARGING_COMMAND_FAILED = -2147482648;
public static final int CHARGING_COMMAND_INVALID_VALUE = -2147482645;
public static final int CHARGING_COMMAND_SUCCESS = 0;
public static final int CHARGING_COMMAND_TIMEOUT = -2147482646;
public static final int CHARGING_ENTER = 1;
public static final int CHARGING_EXIT = 2;
public static final int CHARGING_FAILURE = 1;
public static final int CHARGING_FAULT_STATE_MAJOR = 3;
public static final int CHARGING_FAULT_STATE_MINOR = 2;
public static final int CHARGING_FAULT_STATE_NORMAL = 1;
public static final int CHARGING_FULL_REST_HOUR = 22;
public static final int CHARGING_FULL_REST_MINUTE = 23;
public static final int CHARGING_FULL_REST_TIME_CHANGE = 37;
public static final int CHARGING_GUN_CONNECT_STATE = 28;
public static final int CHARGING_GUN_NOTINSERT_WARN_STATE = 32;
public static final int CHARGING_GUN_STATE_CONNECTED_AC = 2;
public static final int CHARGING_GUN_STATE_CONNECTED_AC_DC = 4;
public static final int CHARGING_GUN_STATE_CONNECTED_DC = 3;
public static final int CHARGING_GUN_STATE_CONNECTED_NONE = 1;
public static final int CHARGING_GUN_STATE_CONNECTED_VTOL = 5;
public static final int CHARGING_GUN_STATE_OFF = 2;
public static final int CHARGING_GUN_STATE_ON = 1;
public static final int CHARGING_MODE = 36;
public static final int CHARGING_PORT_STATE_LOCK_FINISH = 1;
public static final int CHARGING_PORT_STATE_LOCK_INVALID = 2;
public static final int CHARGING_PORT_STATE_UNLOCK_FINISH = 3;
public static final int CHARGING_PORT_STATE_UNLOCK_INVALID = 4;
public static final int CHARGING_POWER = 29;
public static final double CHARGING_POWER_MAX = 500.0d;
public static final double CHARGING_POWER_MIN = -500.0d;
public static final int CHARGING_SCHEDULE_ENABLE_STATE = 2;
public static final int CHARGING_SCHEDULE_STATE = 31;
public static final int CHARGING_SCHEDULE_STATE_CANCEL = 2;
public static final int CHARGING_SCHEDULE_STATE_INVALID = 1;
public static final int CHARGING_SCHEDULE_STATE_LOCAL = 4;
public static final int CHARGING_SCHEDULE_STATE_NONE = 3;
public static final int CHARGING_SCHEDULE_STATE_REMOTE = 5;
public static final int CHARGING_SCHEDULE_TIME_CHANGE = 38;
public static final int CHARGING_SCHEDULE_TIME_HOUR = 33;
public static final int CHARGING_SCHEDULE_TIME_MINUTE = 34;
public static final int CHARGING_STATE = 35;
public static final int CHARGING_STATE_DISABLE = 1;
public static final int CHARGING_STATE_ENABLE = 0;
public static final int CHARGING_SUCCESS = 2;
public static final int CHARGING_TIMER_CYCLE_FRI = 12;
public static final int CHARGING_TIMER_CYCLE_MON = 8;
public static final int CHARGING_TIMER_CYCLE_SAT = 13;
public static final int CHARGING_TIMER_CYCLE_SUN = 14;
public static final int CHARGING_TIMER_CYCLE_THU = 11;
public static final int CHARGING_TIMER_CYCLE_TUR = 9;
public static final int CHARGING_TIMER_CYCLE_WED = 10;
public static final int CHARGING_TIMER_INFO_CHANGED = 15;
public static final int CHARGING_TIMER_SWITCH = 3;
public static final int CHARGING_TIMER_TYPE_1 = 4;
public static final int CHARGING_TIMER_TYPE_2 = 5;
public static final int CHARGING_TIMER_UNIT_HOUR = 6;
public static final int CHARGING_TIMER_UNIT_MIMITE = 7;
public static final int CHARGING_TYPE = 21;
public static final int CHARGING_TYPE_AC = 2;
public static final int CHARGING_TYPE_DEFAULT = 1;
public static final int CHARGING_TYPE_GB_DC = 4;
public static final int CHARGING_TYPE_GB_NON_DC = 5;
public static final int CHARGING_TYPE_VTOG = 3;
public static final int CHARGING_WORK_STATE_FINISH = 3;
public static final int CHARGING_WORK_STATE_READY = 1;
public static final int CHARGING_WORK_STATE_START = 2;
public static final int CHARGING_WORK_STATE_TERMINATE = 4;
public static final int DEVICE_HAS_THE_FEATURE = 1;
public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
public static final int DISCHARGE_REQUEST_STATE = 27;
public static final int DISCHARGE_STATE_FINISH = 2;
public static final int DISCHARGE_STATE_HOUSEHOLD_APPLIANCE = 2;
public static final int DISCHARGE_STATE_INNER_SOCKET = 41;
public static final int DISCHARGE_STATE_NON = 1;
public static final int DISCHARGE_STATE_ONGOING = 1;
public static final int DISCHARGE_STATE_POWER_SYSTEM = 5;
public static final int DISCHARGE_STATE_READY = 0;
public static final int DISCHARGE_STATE_SINGLE_PHASE_VEHICLE = 7;
public static final int DISCHARGE_STATE_SOCKET = 6;
public static final int DISCHARGE_STATE_THREE_PHASE_EQUIPMENT = 3;
public static final int DISCHARGE_STATE_THREE_PHASE_VEHICLE = 4;
public static final int DISCHARGE_STATE_VTOL = 40;
public static final int DISCHARGE_TYPE_INNER_SOCKET = 2;
public static final int DISCHARGE_TYPE_VTOL = 1;
public static final int DISCHARGE_WARNING_STATE_INVALID = 1;
public static final int DISCHARGE_WARNING_STATE_VALID = 2;
public static final String FEATURE_CHARGE_BY_APPOINTMENT = "ChargeByAppointment";
public static final String FEATURE_CHARGE_TEMP_CTL = "ChargeTemperatureControl";
public static final String FEATURE_CHARGE_WIRELESS_CHARGING = "ChargeWirlessCharging";
public static final int HAS_CHARGE_BY_APPOINTMENT = 47;
public static final int HAS_CHARGE_WIRELESS_CHARGING = 48;
public static final int HOUR_MAX = 23;
public static final int HOUR_MIN = 0;
public static final int MINUTE_MAX = 59;
public static final int MINUTE_MIN = 0;
public static final int NOT_SMART_CHARGING_STATE = 3;
public static final int RESET_INVALID = 0;
public static final int RESET_ITEM_CHARGE = 0;
public static final int RESET_VALID = 1;
public static final int REST_HOUR_MAX = 254;
public static final int REST_HOUR_MIN = 0;
public static final int SMART_CHARGING_STATE = 39;
public static final int SMART_CHARGING_STATE_ENTER = 0;
public static final int SMART_CHARGING_STATE_EXIT = 2;
public static final int SMART_CHARGING_STATE_ONGOING = 1;
public static final int WIRELESS_CHARGING_ONLINE5S = 55;
public static final int WIRELESS_CHARGING_STATE_FAULT = 2;
public static final int WIRELESS_CHARGING_STATE_FULL = 1;
public static final int WIRELESS_CHARGING_STATE_ONGOING = 0;
public static final int WIRELESS_CHARGING_STATE_STANDBY = 3;
public static synchronized BYDAutoChargingDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int getBatteryManagementDeviceState() { return 0; }
public int getBatteryType() { return 0; }
public int getChargeTempCtlState() { return 0; }
public int getChargerFaultState() { return 0; }
public int getChargerState() { return 0; }
public int getChargerWorkState() { return 0; }
public int getChargingCapState(int i) { return 0; }
public double getChargingCapacity() { return 0; }
public int getChargingGunNotInsertedState() { return 0; }
public int getChargingGunState() { return 0; }
public int getChargingMode() { return 0; }
public int getChargingPortLockRebackState() { return 0; }
public double getChargingPower() { return 0; }
public int[] getChargingRestTime() { return null; }
public int getChargingScheduleEnableState() { return 0; }
public int getChargingScheduleState() { return 0; }
public int[] getChargingScheduleTime() { return null; }
public int getChargingState() { return 0; }
public ChargingTimerInfo getChargingTimerInfo(int i) { return null; }
public int getChargingType() { return 0; }
public int getDischargeRequestState() { return 0; }
public int getDischargeState(int i) { return 0; }
public int getDischargeWarningState() { return 0; }
public int[] getFeatureList() { return null; }
public int getSmartChargingState() { return 0; }
public int getType() { return 0; }
public int getWirelessChargingOnline5sState() { return 0; }
public int getWirelessChargingState() { return 0; }
public int getWirelessChargingSwitchState() { return 0; }
public int hasFeature(String str) { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoChargingListener absBYDAutoChargingListener) { }
public int reset(int i, int i2) { return 0; }
public void setAllStatus() { }
public int setChargeTempCtlState(int i) { return 0; }
public int setChargingMode(int i) { return 0; }
public int setChargingTimerInfo(ChargingTimerInfo chargingTimerInfo) { return 0; }
public int setWirelessChargingSwitchState(int i) { return 0; }

 public int setSocSaveSwitch(int i){return 0;}
 public int getWirelessChargingState(int i){return 0;}
 public int getSocSaveSwitch(){return 0;}
public void unregisterListener(AbsBYDAutoChargingListener absBYDAutoChargingListener) { }
public boolean postEvent(int i, int i2, double d2, Object obj) { return false; }
public void registerListener(AbsBYDAutoChargingListener absBYDAutoChargingListener, int[] iArr) { }
 }
