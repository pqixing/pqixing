//refactor
package android.hardware.bydauto.statistic;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoStatisticDevice extends AbsBYDAutoDevice {
public static final double AVERAGE_ELEC_CON_PHM_MAX = 99.9d;
public static final double AVERAGE_ELEC_CON_PHM_MIN = -99.9d;
public static final double AVERAGE_FUEL_CON_PHM_MAX = 51.1d;
public static final double AVERAGE_FUEL_CON_PHM_MIN = 0.0d;
public static final double AVERAGE_SPEED_MAX = 281.5d;
public static final double AVERAGE_SPEED_MIN = 0.0d;
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
public static final int TARGET_MILEAGE1 = 2;
public static final int TARGET_MILEAGE2 = 3;
public static final int TARGET_TOTAL = 1;
public static final int TOTAL_AVERAGE_SPEED = 23;
public static final double TRAVEL_TIME_MAX = 99999.0d;
public static final double TRAVEL_TIME_MIN = 0.0d;
public static synchronized BYDAutoStatisticDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public double getAverageElectricConsumption(int i) { return 0; }
public double getAverageFuelConsumption(int i) { return 0; }
public double getAverageSpeed(int i) { return 0; }
public double getDrivingTimeValue() { return 0; }
public int getEVDrivingMileageConfig() { return 0; }
public int getEVDrivingMileageMode() { return 0; }
public int getEVMileageValue() { return 0; }
public int getElecDrivingRangeValue() { return 0; }
public double getElecPercentageValue() { return 0; }
public double getElectricConsumption(int i) { return 0; }
public int[] getFeatureList() { return null; }
public int getFuelADValue() { return 0; }
public double getFuelConsumption(int i) { return 0; }
public int getFuelDrivingRangeValue() { return 0; }
public int getFuelPercentageValue() { return 0; }
public int getHEVMileageValue() { return 0; }
public double getInstantElecConValue() { return 0; }
public double getInstantFuelConValue() { return 0; }
public int getKeyBatteryLevel() { return 0; }
public double getLastElecConPHMValue() { return 0; }
public double getLastFuelConPHMValue() { return 0; }
public int getMessage5sOnlineState(int i) { return 0; }
public int getSOCBatteryPercentage() { return 0; }
public double getTotalElecConPHMValue() { return 0; }
public double getTotalElecConValue() { return 0; }
public double getTotalFuelConPHMValue() { return 0; }
public double getTotalFuelConValue() { return 0; }
public int getTotalMileageValue() { return 0; }
public double getTravelTime(int i) { return 0; }
public int getType() { return 0; }
public int getWaterTemperature() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoStatisticListener absBYDAutoStatisticListener) { }
public int setEVDrivingMileageMode(int i) { return 0; }
public void unregisterListener(AbsBYDAutoStatisticListener absBYDAutoStatisticListener) { }
public boolean postEvent(int i, int i2, double d2, Object obj) { return false; }
public void registerListener(AbsBYDAutoStatisticListener absBYDAutoStatisticListener, int[] iArr) { }
 }
