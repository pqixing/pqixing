package android.hardware.bydauto.charging;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
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
    static final String CHARGING_GET_PERM = "android.permission.BYDAUTO_CHARGING_GET";
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
    static final String CHARGING_SET_PERM = "android.permission.BYDAUTO_CHARGING_SET";
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
    private static final boolean DEBUG = true;
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
    protected static final String TAG = "BYDAutoChargingDevice";
    public static final int WIRELESS_CHARGING_ONLINE5S = 55;
    public static final int WIRELESS_CHARGING_STATE_FAULT = 2;
    public static final int WIRELESS_CHARGING_STATE_FULL = 1;
    public static final int WIRELESS_CHARGING_STATE_ONGOING = 0;
    public static final int WIRELESS_CHARGING_STATE_STANDBY = 3;
    private static int mDeviceType = 1009;
    private static BYDAutoChargingDevice mInstance;
    private final Context mContext;

    private BYDAutoChargingDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoChargingDevice getInstance(Context context) {
        BYDAutoChargingDevice bYDAutoChargingDevice;
        synchronized (BYDAutoChargingDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoChargingDevice(context);
            }
            bYDAutoChargingDevice = mInstance;
        }
        return bYDAutoChargingDevice;
    }

    public void getAllStatus() {
    }

    public int getBatteryManagementDeviceState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 30);
        Log.d(TAG, "getBatteryManagementDeviceState state is: " + i);
        return i;
    }

    public int getBatteryType() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 53);
        Log.d(TAG, "getBatteryType type is: " + i);
        return i;
    }

    public int getChargeTempCtlState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 51);
        Log.d(TAG, "getChargeTempCtlState: state is " + i);
        return i;
    }

    public int getChargerFaultState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 18);
        Log.d(TAG, "getChargerFaultState state is: " + i);
        return i;
    }

    public int getChargerState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getChargerState state is: " + i);
        return i;
    }

    public int getChargerWorkState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 19);
        Log.d(TAG, "getChargerWorkState state is: " + i);
        return i;
    }

    public int getChargingCapState(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        Log.d(TAG, "getChargingCapState type is: " + i);
        if (i == 1) {
            i2 = 24;
        } else if (i != 2) {
            return -2147482645;
        } else {
            i2 = 25;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getChargingCapState state is: " + i3);
        return i3;
    }

    public double getChargingCapacity() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 20);
        Log.d(TAG, "getChargingCapacity value is: " + d2);
        return d2;
    }

    public int getChargingGunNotInsertedState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 32);
        Log.d(TAG, "getChargingGunNotInsertedState state is: " + i);
        return i;
    }

    public int getChargingGunState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 28);
        Log.d(TAG, "getChargingGunState state is: " + i);
        return i;
    }

    public int getChargingMode() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 36);
        Log.d(TAG, "getChargingMode mode is: " + i);
        return i;
    }

    public int getChargingPortLockRebackState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 26);
        Log.d(TAG, "getChargingPortLockRebackState state is: " + i);
        return i;
    }

    public double getChargingPower() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 29);
        if (d2 < 0.0d) {
            return 0.0d;
        }
        Log.d(TAG, "getChargingPower value is: " + d2);
        return d2;
    }

    public int[] getChargingRestTime() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int[] intArray = super.getIntArray(mDeviceType, new int[]{22, 23});
        if (intArray.length < 2) {
            Log.e(TAG, "getChargingRestTime: error is " + intArray[0]);
            return new int[]{intArray[0], intArray[0]};
        }
        Log.d(TAG, " getChargingRestTime hour time is: " + intArray[0] + "minute time is: " + intArray[1]);
        return intArray;
    }

    public int getChargingScheduleEnableState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getChargingScheduleEnableState state is: " + i);
        return i;
    }

    public int getChargingScheduleState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 31);
        Log.d(TAG, "getChargingScheduleState state is: " + i);
        return i;
    }

    public int[] getChargingScheduleTime() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int[] intArray = super.getIntArray(mDeviceType, new int[]{33, 34});
        if (intArray.length < 2) {
            Log.e(TAG, "getChargingScheduleTime: error is " + intArray[0]);
            return new int[]{intArray[0], intArray[0]};
        }
        Log.d(TAG, " getChargingScheduleTime hour time is: " + intArray[0] + "minute time is: " + intArray[1]);
        return intArray;
    }

    public int getChargingState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 35);
        Log.d(TAG, "getChargingState state is: " + i);
        return i;
    }

    public ChargingTimerInfo getChargingTimerInfo(int i) {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        byte[] buffer = super.getBuffer(mDeviceType, i == 3 ? 4 : 5);
        byte[] copyOfRange = Arrays.copyOfRange(buffer, 4, buffer.length);
        byte b2 = copyOfRange[0];
        byte b3 = copyOfRange[1];
        byte b4 = copyOfRange[2];
        byte b5 = copyOfRange[3];
        byte b6 = copyOfRange[4];
        byte b7 = copyOfRange[5];
        byte b8 = copyOfRange[6];
        byte b9 = copyOfRange[7];
        byte b10 = copyOfRange[8];
        byte b11 = copyOfRange[9];
        byte b12 = copyOfRange[10];
        Log.d(TAG, "getChargingTimerInfo: timerSwitch = " + ((int) b2) + ", timerType = " + ((int) b3) + ", timerUnitHour = " + ((int) b4) + ", timerUnitMinite = " + ((int) b5) + ", timerCycleMon = " + ((int) b6) + ", timerCycleTue = " + ((int) b7) + ", timerCycleWed = " + ((int) b8) + ", timerCycleThu = " + ((int) b9) + ", timerCycleFri = " + ((int) b10) + ", timerCycleSat = " + ((int) b11) + ", timerCycleSun = " + ((int) b12));
        ChargingTimerInfo chargingTimerInfo = new ChargingTimerInfo();
        chargingTimerInfo.setTimerSwitch(b2);
        chargingTimerInfo.setTimerType(b3);
        chargingTimerInfo.setTimerUnitHour(b4);
        chargingTimerInfo.setTimerUnitMinite(b5);
        chargingTimerInfo.setTimerCycleMon(b6);
        chargingTimerInfo.setTimerCycleTue(b7);
        chargingTimerInfo.setTimerCycleWed(b8);
        chargingTimerInfo.setTimerCycleThu(b9);
        chargingTimerInfo.setTimerCycleFri(b10);
        chargingTimerInfo.setTimerCycleSat(b11);
        chargingTimerInfo.setTimerCycleSun(b12);
        return chargingTimerInfo;
    }

    public int getChargingType() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 21);
        Log.d(TAG, "getChargingType value is: " + i);
        return i;
    }

    public int getDischargeRequestState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 27);
        Log.d(TAG, "getDischargeRequestState state is: " + i);
        return i;
    }

    public int getDischargeState(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        if (i == 1) {
            i2 = 40;
        } else if (i != 2) {
            return -2147482645;
        } else {
            i2 = 41;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getDischargeState: state is " + i3);
        return i3;
    }

    public int getDischargeWarningState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 46);
        Log.d(TAG, "getDischargeWarningState: state is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getSmartChargingState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 39);
        Log.d(TAG, "getSmartChargingState: state is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1009;
    }

    public int getWirelessChargingOnline5sState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 55);
        Log.d(TAG, "getWirelessChargingOnline5sState state is: " + i);
        return i;
    }

    public int getWirelessChargingState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 49);
        Log.d(TAG, "getWirelessChargingState: state is " + i);
        return i;
    }

    public int getWirelessChargingSwitchState() {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        int i = super.get(mDeviceType, 54);
        Log.d(TAG, "getWirelessChargingSwitchState state is: " + i);
        return i;
    }

    public int hasFeature(String str) {
        int i;
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        if (str.equals(FEATURE_CHARGE_BY_APPOINTMENT)) {
            i = 47;
        } else if (str.equals(FEATURE_CHARGE_WIRELESS_CHARGING)) {
            i = 48;
        } else if (!str.equals(FEATURE_CHARGE_TEMP_CTL)) {
            return -2147482645;
        } else {
            i = 52;
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

    public void registerListener(AbsBYDAutoChargingListener absBYDAutoChargingListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        if (absBYDAutoChargingListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoChargingListener);
        }
    }

    public int reset(int i, int i2) {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_SET_PERM, null);
        Log.d(TAG, "resetCharge: item is " + i + " and value is: " + i2);
        if ((i2 == 0 || i2 == 1) && i == 0) {
            return super.set(mDeviceType, 50, i2);
        }
        return -2147482645;
    }

    public void setAllStatus() {
    }

    public int setChargeTempCtlState(int i) {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_SET_PERM, null);
        Log.d(TAG, "setChargeTempCtlState: state is " + i);
        if (i == 0 || i == 1 || i == 2) {
            return super.set(mDeviceType, 51, i);
        }
        return -2147482645;
    }

    public int setChargingMode(int i) {
        Log.d(TAG, "setChargingMode mode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(CHARGING_SET_PERM, null);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 36, i);
        }
        return -2147482645;
    }

    public int setChargingTimerInfo(ChargingTimerInfo chargingTimerInfo) {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_SET_PERM, null);
        if (chargingTimerInfo == null) {
            return -2147482645;
        }
        int timerSwitch = chargingTimerInfo.getTimerSwitch();
        int timerType = chargingTimerInfo.getTimerType();
        int timerUnitHour = chargingTimerInfo.getTimerUnitHour();
        int timerUnitMinite = chargingTimerInfo.getTimerUnitMinite();
        int timerCycleMon = chargingTimerInfo.getTimerCycleMon();
        int timerCycleTue = chargingTimerInfo.getTimerCycleTue();
        int timerCycleWed = chargingTimerInfo.getTimerCycleWed();
        int timerCycleThu = chargingTimerInfo.getTimerCycleThu();
        int timerCycleFri = chargingTimerInfo.getTimerCycleFri();
        int timerCycleSat = chargingTimerInfo.getTimerCycleSat();
        int timerCycleSun = chargingTimerInfo.getTimerCycleSun();
        Log.d(TAG, "setChargingTimerInfo: timerSwitch = " + timerSwitch + ", timerType = " + timerType + ", timerUnitHour = " + timerUnitHour + ", timerUnitMinite = " + timerUnitMinite + ", timerCycleMon = " + timerCycleMon + ", timerCycleTue = " + timerCycleTue + ", timerCycleWed = " + timerCycleWed + ", timerCycleThu = " + timerCycleThu + ", timerCycleFri = " + timerCycleFri + ", timerCycleSat = " + timerCycleSat + ", timerCycleSun = " + timerCycleSun);
        if (timerSwitch != 1 && timerSwitch != 0 && timerSwitch != -1) {
            return -2147482645;
        }
        if ((timerType != 3 && timerType != 4) || timerUnitHour < 0 || timerUnitHour > 24 || timerUnitMinite < 0 || timerUnitHour > 60 || ((timerCycleMon != 1 && timerCycleMon != 0) || ((timerCycleTue != 1 && timerCycleTue != 0) || ((timerCycleWed != 1 && timerCycleWed != 0) || ((timerCycleThu != 1 && timerCycleThu != 0) || ((timerCycleFri != 1 && timerCycleFri != 0) || ((timerCycleSat != 1 && timerCycleSat != 0) || (timerCycleSun != 1 && timerCycleSun != 0)))))))) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{3, timerType == 3 ? 4 : 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, new int[]{timerSwitch, timerType, timerUnitHour, timerUnitMinite, timerCycleMon, timerCycleTue, timerCycleWed, timerCycleThu, timerCycleFri, timerCycleSat, timerCycleSun});
    }

    public int setWirelessChargingSwitchState(int i) {
        this.mContext.enforceCallingOrSelfPermission(CHARGING_SET_PERM, null);
        Log.d(TAG, "setWirelessChargingSwitchState state is " + i);
        if (i < 0 || i > 2) {
            return -2147482645;
        }
        return super.set(mDeviceType, 54, i);
    }

    public void unregisterListener(AbsBYDAutoChargingListener absBYDAutoChargingListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        if (absBYDAutoChargingListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoChargingListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + d2);
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }

    public void registerListener(AbsBYDAutoChargingListener absBYDAutoChargingListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(CHARGING_GET_PERM, null);
        if (absBYDAutoChargingListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoChargingListener, iArr);
        }
    }
}
