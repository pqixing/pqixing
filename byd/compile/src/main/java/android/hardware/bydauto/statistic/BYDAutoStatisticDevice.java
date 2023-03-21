package android.hardware.bydauto.statistic;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoStatisticDevice extends AbsBYDAutoDevice {
    public static final double AVERAGE_ELEC_CON_PHM_MAX = 99.9d;
    public static final double AVERAGE_ELEC_CON_PHM_MIN = -99.9d;
    public static final double AVERAGE_FUEL_CON_PHM_MAX = 51.1d;
    public static final double AVERAGE_FUEL_CON_PHM_MIN = 0.0d;
    public static final double AVERAGE_SPEED_MAX = 281.5d;
    public static final double AVERAGE_SPEED_MIN = 0.0d;
    private static final boolean DEBUG = true;
    public static final int DRIVING_MILEAGE_CONFIG_DISABLE = 1;
    public static final int DRIVING_MILEAGE_CONFIG_SELECTABLE = 2;
    public static final int DRIVING_MILEAGE_MODE_DYNAMIC = 2;
    public static final int DRIVING_MILEAGE_MODE_INVALID = 0;
    public static final int DRIVING_MILEAGE_MODE_STANDARD = 1;
    public static final double ELEC_CONSUMPTION_MAX = 1676721.4d;
    public static final double ELEC_CONSUMPTION_MIN = -1000.0d;
    public static final double FUEL_CONSUMPTION_MAX = 104857.4d;
    public static final double FUEL_CONSUMPTION_MIN = 0.0d;
    public static final int INSTANT_EV_CONSUME = 34;
    public static final int INSTANT_FUEL_CONSUME = 35;
    public static final int MESSAGE_3D9_SUBID_55 = 1;
    public static final int MESSAGE_3D9_SUBID_57 = 2;
    public static final int MESSAGE_OFFLINE = 0;
    public static final int MESSAGE_ONLINE = 1;
    public static final int MILEAGE1_AVERAGE_SPEED = 24;
    public static final int MILEAGE1_DRIVE_TIME = 21;
    public static final int MILEAGE1_ELEC_CONSUMPTION = 15;
    public static final int MILEAGE1_ELEC_CON_PHKM = 19;
    public static final int MILEAGE1_FULE_CONSUMPTION = 13;
    public static final int MILEAGE1_FULE_CON_PHKM = 17;
    public static final int MILEAGE2_AVERAGE_SPEED = 25;
    public static final int MILEAGE2_DRIVE_TIME = 22;
    public static final int MILEAGE2_ELEC_CONSUMPTION = 16;
    public static final int MILEAGE2_ELEC_CON_PHKM = 20;
    public static final int MILEAGE2_FULE_CONSUMPTION = 14;
    public static final int MILEAGE2_FULE_CON_PHKM = 18;
    public static final int MILEAGE_EV = 29;
    public static final int MILEAGE_HEV = 30;
    public static final int ONLINE_3D9_SUBID_55 = 36;
    public static final int ONLINE_3D9_SUBID_57 = 37;
    public static final int SOC_BATTERY_PERCENTAGE = 28;
    public static final int SOC_BATTERY_PERCENTAGE_MAX = 100;
    public static final int SOC_BATTERY_PERCENTAGE_MIN = 0;
    public static final int STATISTIC_COMMAND_BUSY = -2147482647;
    public static final int STATISTIC_COMMAND_FAILED = -2147482648;
    public static final int STATISTIC_COMMAND_INVALID_VALUE = -2147482645;
    public static final int STATISTIC_COMMAND_SUCCESS = 0;
    public static final int STATISTIC_COMMAND_TIMEOUT = -2147482646;
    public static final int STATISTIC_DRIVING_TIME = 4;
    public static final double STATISTIC_DRIVING_TIME_MAX = 9999.9d;
    public static final double STATISTIC_DRIVING_TIME_MIN = 0.0d;
    public static final int STATISTIC_ELEC_DRIVING_RANGE = 9;
    public static final int STATISTIC_ELEC_DRIVING_RANGE_MAX = 1000;
    public static final int STATISTIC_ELEC_DRIVING_RANGE_MIN = 0;
    public static final int STATISTIC_ELEC_PERCENTAGE = 12;
    public static final double STATISTIC_ELEC_PERCENTAGE_MAX = 100.0d;
    public static final double STATISTIC_ELEC_PERCENTAGE_MIN = 0.0d;
    public static final int STATISTIC_EV_DRIVING_MILEAGE_CONFIG = 33;
    public static final int STATISTIC_EV_DRIVING_MILEAGE_MODE = 32;
    public static final int STATISTIC_FUEL_AD_MAX = 4095;
    public static final int STATISTIC_FUEL_AD_MIN = 0;
    public static final int STATISTIC_FUEL_AD_VALUE = 26;
    public static final int STATISTIC_FUEL_DRIVING_RANGE = 10;
    public static final int STATISTIC_FUEL_DRIVING_RANGE_MAX = 4095;
    public static final int STATISTIC_FUEL_DRIVING_RANGE_MIN = 0;
    public static final int STATISTIC_FUEL_PERCENTAGE = 11;
    public static final int STATISTIC_FUEL_PERCENTAGE_MAX = 100;
    public static final int STATISTIC_FUEL_PERCENTAGE_MIN = 0;
    static final String STATISTIC_GET_PERM = "android.permission.BYDAUTO_STATISTIC_GET";
    public static final double STATISTIC_INSTANT_ELEC_CON_MAX = 2000.0d;
    public static final double STATISTIC_INSTANT_ELEC_CON_MIN = -2000.0d;
    public static final double STATISTIC_INSTANT_FUEL_CON_MAX = 65.0d;
    public static final double STATISTIC_INSTANT_FUEL_CON_MIN = 0.0d;
    public static final int STATISTIC_KEY_BATTERY_LEVEL = 27;
    public static final int STATISTIC_KEY_BATTERY_LEVEL_LOW = 1;
    public static final int STATISTIC_KEY_BATTERY_LEVEL_NORMAL = 2;
    public static final int STATISTIC_LAST_ELEC_CON_PHM = 7;
    public static final double STATISTIC_LAST_ELEC_CON_PHM_MAX = 99.9d;
    public static final double STATISTIC_LAST_ELEC_CON_PHM_MIN = -99.9d;
    public static final int STATISTIC_LAST_FUEL_CON_PHM = 5;
    public static final double STATISTIC_LAST_FUEL_CON_PHM_MAX = 51.1d;
    public static final double STATISTIC_LAST_FUEL_CON_PHM_MIN = 0.0d;
    public static final int STATISTIC_MILEAGE_MAX = 999999;
    public static final int STATISTIC_MILEAGE_MIN = 0;
    static final String STATISTIC_SET_PERM = "android.permission.BYDAUTO_STATISTIC_SET";
    public static final int STATISTIC_TOTAL_ELEC_CONSUMPTION = 3;
    public static final double STATISTIC_TOTAL_ELEC_CONSUMPTION_MAX = 1676721.4d;
    public static final double STATISTIC_TOTAL_ELEC_CONSUMPTION_MIN = -1000.0d;
    public static final int STATISTIC_TOTAL_ELEC_CON_PHM = 8;
    public static final double STATISTIC_TOTAL_ELEC_CON_PHM_MAX = 99.9d;
    public static final double STATISTIC_TOTAL_ELEC_CON_PHM_MIN = -99.9d;
    public static final int STATISTIC_TOTAL_FUEL_CONSUMPTION = 2;
    public static final double STATISTIC_TOTAL_FUEL_CONSUMPTION_MAX = 104857.4d;
    public static final double STATISTIC_TOTAL_FUEL_CONSUMPTION_MIN = 0.0d;
    public static final int STATISTIC_TOTAL_FUEL_CON_PHM = 6;
    public static final double STATISTIC_TOTAL_FUEL_CON_PHM_MAX = 51.1d;
    public static final double STATISTIC_TOTAL_FUEL_CON_PHM_MIN = 0.0d;
    public static final int STATISTIC_TOTAL_MILEAGE = 1;
    public static final int STATISTIC_TOTAL_MILEAGE_MAX = 999999;
    public static final int STATISTIC_TOTAL_MILEAGE_MIN = 0;
    public static final int STATISTIC_WATER_TEMPERATURE = 31;
    public static final int STATISTIC_WATER_TEMPERATURE_MAX = 255;
    public static final int STATISTIC_WATER_TEMPERATURE_MIN = 0;
    protected static final String TAG = "BYDAutoStatisticDevice";
    public static final int TARGET_MILEAGE1 = 2;
    public static final int TARGET_MILEAGE2 = 3;
    public static final int TARGET_TOTAL = 1;
    public static final int TOTAL_AVERAGE_SPEED = 23;
    public static final double TRAVEL_TIME_MAX = 99999.0d;
    public static final double TRAVEL_TIME_MIN = 0.0d;
    private static int mDeviceType = 1014;
    private static BYDAutoStatisticDevice mInstance;
    private final Context mContext;

    private BYDAutoStatisticDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoStatisticDevice getInstance(Context context) {
        BYDAutoStatisticDevice bYDAutoStatisticDevice;
        synchronized (BYDAutoStatisticDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoStatisticDevice(context);
            }
            bYDAutoStatisticDevice = mInstance;
        }
        return bYDAutoStatisticDevice;
    }

    public void getAllStatus() {
    }

    public double getAverageElectricConsumption(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        if (i == 1) {
            i2 = 8;
        } else if (i == 2) {
            i2 = 19;
        } else if (i != 3) {
            Log.e(TAG, "getAverageElectricConsumption: Illegal target!");
            return -2.147482645E9d;
        } else {
            i2 = 20;
        }
        double d2 = super.getDouble(mDeviceType, i2);
        Log.d(TAG, "getAverageElectricConsumption: value is " + d2);
        return d2;
    }

    public double getAverageFuelConsumption(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        if (i == 1) {
            i2 = 6;
        } else if (i == 2) {
            i2 = 17;
        } else if (i != 3) {
            Log.e(TAG, "getAverageFuelConsumption: Illegal target!");
            return -2.147482645E9d;
        } else {
            i2 = 18;
        }
        double d2 = super.getDouble(mDeviceType, i2);
        Log.d(TAG, "getAverageFuelConsumption: value is " + d2);
        return d2;
    }

    public double getAverageSpeed(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        if (i == 1) {
            i2 = 23;
        } else if (i == 2) {
            i2 = 24;
        } else if (i != 3) {
            Log.e(TAG, "getAverageSpeed: Illegal target!");
            return -2.147482645E9d;
        } else {
            i2 = 25;
        }
        double d2 = super.getDouble(mDeviceType, i2);
        Log.d(TAG, "getAverageSpeed: value is " + d2);
        return d2;
    }

    public double getDrivingTimeValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 4);
        Log.d(TAG, "getDrivingTimeValue value is: " + d2);
        return d2;
    }

    public int getEVDrivingMileageConfig() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 33);
        Log.d(TAG, "getEVDrivingMileageConfig: config is " + i);
        return i;
    }

    public int getEVDrivingMileageMode() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 32);
        Log.d(TAG, "getEVDrivingMileageMode: mode is " + i);
        return i;
    }

    public int getEVMileageValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 29);
        Log.d(TAG, "getEVMileageValue: value is " + i);
        return i;
    }

    public int getElecDrivingRangeValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getElecDrivingRangeValue value is: " + i);
        return i;
    }

    public double getElecPercentageValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 12);
        Log.d(TAG, "getElecPercentageValue value is: " + d2);
        return d2;
    }

    public double getElectricConsumption(int i) {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i2 = 3;
        if (i != 1) {
            if (i == 2) {
                i2 = 15;
            } else if (i != 3) {
                Log.e(TAG, "getElectricConsumption: Illegal target!");
                return -2.147482645E9d;
            } else {
                i2 = 16;
            }
        }
        double d2 = super.getDouble(mDeviceType, i2);
        Log.d(TAG, "getElectricConsumption: value is " + d2);
        return d2;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getFuelADValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 26);
        Log.d(TAG, "getFuelADValue value is: " + i);
        return i;
    }

    public double getFuelConsumption(int i) {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i2 = 2;
        if (i != 1) {
            if (i == 2) {
                i2 = 13;
            } else if (i != 3) {
                Log.e(TAG, "getFuelConsumption: Illegal target!");
                return -2.147482645E9d;
            } else {
                i2 = 14;
            }
        }
        double d2 = super.getDouble(mDeviceType, i2);
        Log.d(TAG, "getFuelConsumption: value is " + d2);
        return d2;
    }

    public int getFuelDrivingRangeValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 10);
        Log.d(TAG, "getFuelDrivingRangeValue value is: " + i);
        return i;
    }

    public int getFuelPercentageValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 11);
        Log.d(TAG, "getFuelPercentageValue value is: " + i);
        return i;
    }

    public int getHEVMileageValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 30);
        Log.d(TAG, "getHEVMileageValue: value is " + i);
        return i;
    }

    public double getInstantElecConValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 34);
        Log.d(TAG, "getInstantElecConValue value is: " + d2);
        return d2;
    }

    public double getInstantFuelConValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 35);
        Log.d(TAG, "getInstantFuelConValue value is: " + d2);
        return d2;
    }

    public int getKeyBatteryLevel() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 27);
        Log.d(TAG, "getKeyBatteryLevel level is: " + i);
        return i;
    }

    public double getLastElecConPHMValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 7);
        Log.d(TAG, "getLastElecConPHMValue value is: " + d2);
        return d2;
    }

    public double getLastFuelConPHMValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 5);
        Log.d(TAG, "getLastFuelConPHMValue value is: " + d2);
        return d2;
    }

    public int getMessage5sOnlineState(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        if (i == 1) {
            i2 = 36;
        } else if (i != 2) {
            return -2147482645;
        } else {
            i2 = 37;
        }
        int i3 = super.get(mDeviceType, i2);
        Log.d(TAG, "getMessage5sOnlineState id is: " + i + " and state is: " + i3);
        return i3;
    }

    public int getSOCBatteryPercentage() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 28);
        Log.d(TAG, "getSOCBatteryPercentage: value is " + i);
        return i;
    }

    public double getTotalElecConPHMValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 8);
        Log.d(TAG, "getTotalElecConPHMValue value is: " + d2);
        return d2;
    }

    public double getTotalElecConValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 3);
        Log.d(TAG, "getTotalElecConValue value is: " + d2);
        return d2;
    }

    public double getTotalFuelConPHMValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 6);
        Log.d(TAG, "getTotalFuelConPHMValue value is: " + d2);
        return d2;
    }

    public double getTotalFuelConValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 2);
        Log.d(TAG, "getTotalFuelConValue value is: " + d2);
        return d2;
    }

    public int getTotalMileageValue() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getTotalMileageValue value is: " + i);
        return i;
    }

    public double getTravelTime(int i) {
        int i2;
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        if (i == 1) {
            i2 = 4;
        } else if (i == 2) {
            i2 = 21;
        } else if (i != 3) {
            Log.e(TAG, "getTravelTime: Illegal target!");
            return -2.147482645E9d;
        } else {
            i2 = 22;
        }
        double d2 = super.getDouble(mDeviceType, i2);
        Log.d(TAG, "getTravelTime: value is " + d2);
        return d2;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1014;
    }

    public int getWaterTemperature() {
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        int i = super.get(mDeviceType, 31);
        Log.d(TAG, "getWaterTemperature value is: " + i);
        return i;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoStatisticListener absBYDAutoStatisticListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        if (absBYDAutoStatisticListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoStatisticListener);
        }
    }

    public int setEVDrivingMileageMode(int i) {
        Log.d(TAG, "setEVDrivingMileageMode mode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_SET_PERM, null);
        if (i == 0 || i == 1 || i == 2) {
            return super.set(mDeviceType, 32, i);
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoStatisticListener absBYDAutoStatisticListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        if (absBYDAutoStatisticListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoStatisticListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + d2);
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }

    public void registerListener(AbsBYDAutoStatisticListener absBYDAutoStatisticListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(STATISTIC_GET_PERM, null);
        if (absBYDAutoStatisticListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoStatisticListener, iArr);
        }
    }
}
