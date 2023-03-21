//refactor
package android.hardware.bydauto.tyre;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoTyreDevice extends AbsBYDAutoDevice {
public static final int DEVICE_HAS_THE_FEATURE = 1;
public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
public static final String FEATURE_INDIRECT_TYRE_PRESSURE_ONLINE = "IndirectTyrePressureMonitor";
public static final String FEATURE_TYRE_PRESSURE_ONLINE = "TyrePressureMonitor";
public static final int HAS_INDIRECT_TYRE_PRESSURE_ONLINE = 25;
public static final int HAS_TYRE_PRESSURE_ONLINE = 24;
public static final int INDIRECT_TYRE_PRESSURE_CONFIRM = 1;
public static final int INDIRECT_TYRE_SYSTEM_CONFIRM = 27;
public static final int INDITECT_TYRE_SYSTEM_RESETTING = 1;
public static final int INDITECT_TYRE_SYSTEM_RESET_FAILED = 3;
public static final int INDITECT_TYRE_SYSTEM_RESET_SUCCESS = 2;
public static final int INDITECT_TYRE_SYSTEM_STATE = 26;
public static final int TYRE_AIR_LEAK_STATE_LEFT_FRONT = 1;
public static final int TYRE_AIR_LEAK_STATE_LEFT_REAR = 11;
public static final int TYRE_AIR_LEAK_STATE_NORMAL = 0;
public static final int TYRE_AIR_LEAK_STATE_QUICK = 1;
public static final int TYRE_AIR_LEAK_STATE_RIGHT_FRONT = 6;
public static final int TYRE_AIR_LEAK_STATE_RIGHT_REAR = 16;
public static final int TYRE_AIR_LEAK_STATE_SLOW = 2;
public static final int TYRE_BATTERY_STATE = 23;
public static final int TYRE_BATTERY_STATE_LOW = 1;
public static final int TYRE_BATTERY_STATE_NORMAL = 0;
public static final int TYRE_BATTERY_VALUE_LEFT_FRONT = 2;
public static final int TYRE_BATTERY_VALUE_LEFT_REAR = 12;
public static final int TYRE_BATTERY_VALUE_RIGHT_FRONT = 7;
public static final int TYRE_BATTERY_VALUE_RIGHT_REAR = 17;
public static final double TYRE_BATTERY_VOLTAGE_MAX = 40.0d;
public static final double TYRE_BATTERY_VOLTAGE_MIN = 0.0d;
public static final int TYRE_COMMAND_AREA_LEFT_FRONT = 1;
public static final int TYRE_COMMAND_AREA_LEFT_REAR = 3;
public static final int TYRE_COMMAND_AREA_RIGHT_FRONT = 2;
public static final int TYRE_COMMAND_AREA_RIGHT_REAR = 4;
public static final int TYRE_COMMAND_BUSY = -2147482647;
public static final int TYRE_COMMAND_FAILED = -2147482648;
public static final int TYRE_COMMAND_INVALID_VALUE = -2147482645;
public static final int TYRE_COMMAND_SUCCESS = 0;
public static final int TYRE_COMMAND_TIMEOUT = -2147482646;
public static final int TYRE_PRESSURE_STATE_LEFT_FRONT = 4;
public static final int TYRE_PRESSURE_STATE_LEFT_REAR = 14;
public static final int TYRE_PRESSURE_STATE_NORMAL = 0;
public static final int TYRE_PRESSURE_STATE_OVERPRESSURE = 1;
public static final int TYRE_PRESSURE_STATE_RIGHT_FRONT = 9;
public static final int TYRE_PRESSURE_STATE_RIGHT_REAR = 19;
public static final int TYRE_PRESSURE_STATE_UNDERPRESSURE = 2;
public static final int TYRE_PRESSURE_VALUE_LEFT_FRONT = 3;
public static final int TYRE_PRESSURE_VALUE_LEFT_REAR = 13;
public static final int TYRE_PRESSURE_VALUE_MAX = 4094;
public static final int TYRE_PRESSURE_VALUE_MIN = 0;
public static final int TYRE_PRESSURE_VALUE_RIGHT_FRONT = 8;
public static final int TYRE_PRESSURE_VALUE_RIGHT_REAR = 18;
public static final int TYRE_SIGNAL_STATE_ERROR = 1;
public static final int TYRE_SIGNAL_STATE_LEFT_FRONT = 5;
public static final int TYRE_SIGNAL_STATE_LEFT_REAR = 15;
public static final int TYRE_SIGNAL_STATE_NORMAL = 0;
public static final int TYRE_SIGNAL_STATE_RIGHT_FRONT = 10;
public static final int TYRE_SIGNAL_STATE_RIGHT_REAR = 20;
public static final int TYRE_SYSTEM_STATE = 21;
public static final int TYRE_SYSTEM_STATE_BREAKDOWN = 3;
public static final int TYRE_SYSTEM_STATE_MASKED = 4;
public static final int TYRE_SYSTEM_STATE_NORMAL = 0;
public static final int TYRE_SYSTEM_STATE_SELF_CHECKING = 1;
public static final int TYRE_SYSTEM_STATE_SIGNAL_ANOMAL = 2;
public static final double TYRE_TEMPERATURE_MAX = 369.4d;
public static final double TYRE_TEMPERATURE_MIN = -40.0d;
public static final int TYRE_TEMPERATURE_STATE = 22;
public static final int TYRE_TEMPERATURE_STATE_HIGH = 2;
public static final int TYRE_TEMPERATURE_STATE_NORMAL = 0;
public static final int TYRE_TEMPERATURE_STATE_SLEEP = 3;
public static final int TYRE_TEMPERATURE_STATE_SUPER_HIGH = 1;
public static synchronized BYDAutoTyreDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getIndirectTyreSystemState() { return 0; }
public int getType() { return 0; }
public int getTyreAirLeakState(int i) { return 0; }
public int getTyreBatteryState() { return 0; }
public double getTyreBatteryValue(int i) { return 0; }
public int getTyrePressureState(int i) { return 0; }
public int getTyrePressureValue(int i) { return 0; }
public int getTyreSignalState(int i) { return 0; }
public int getTyreSystemState() { return 0; }
public int getTyreTemperatureState() { return 0; }
public int hasFeature(String str) { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoTyreListener absBYDAutoTyreListener) { }
public int setIndirectTyreConfirm(int i) { return 0; }
public void unregisterListener(AbsBYDAutoTyreListener absBYDAutoTyreListener) { }
public void registerListener(AbsBYDAutoTyreListener absBYDAutoTyreListener, int[] iArr) { }
 }
