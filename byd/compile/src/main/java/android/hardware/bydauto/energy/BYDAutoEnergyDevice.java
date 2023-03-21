//refactor
package android.hardware.bydauto.energy;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoEnergyDevice extends AbsBYDAutoDevice {
public static final int BCM_STATE = 7;
public static final int BCM_STATE_CLOSE = 1;
public static final int BCM_STATE_OPEN = 0;
public static final int DC_WORK_MODE = 6;
public static final int DC_WORK_MODE_STATE_BOOST = 1;
public static final int DC_WORK_MODE_STATE_CLOSE = 0;
public static final int DC_WORK_MODE_STATE_STEP_DOWN = 2;
public static final int ENERGY_COMMAND_BUSY = -2147482647;
public static final int ENERGY_COMMAND_FAILED = -2147482648;
public static final int ENERGY_COMMAND_INVALID = -2147482645;
public static final int ENERGY_COMMAND_SUCCESS = 0;
public static final int ENERGY_COMMAND_TIMEOUT = -2147482646;
public static final int ENERGY_MODE = 8;
public static final int ENERGY_MODE_EV = 1;
public static final int ENERGY_MODE_FORCE_EV = 2;
public static final int ENERGY_MODE_FUEL = 4;
public static final int ENERGY_MODE_HEV = 3;
public static final int ENERGY_MODE_INSTRUMENT = 9;
public static final int ENERGY_MODE_KEEP = 5;
public static final int ENERGY_MODE_STOP = 0;
public static final int ENERGY_OPERATION_ECONOMY = 1;
public static final int ENERGY_OPERATION_KEEP = 3;
public static final int ENERGY_OPERATION_MODE = 3;
public static final int ENERGY_OPERATION_SPORT = 2;
public static final int ENERGY_POWER_GENERATING = 1;
public static final int ENERGY_POWER_GENERATION_END = 2;
public static final int ENERGY_POWER_GENERATION_ERROR = 3;
public static final int ENERGY_POWER_GENERATION_INVALID = 0;
public static final int ENERGY_POWER_GENERATION_STATE = 4;
public static final int ENERGY_POWER_GENERATION_VALUE = 5;
public static final int ENERGY_POWER_GENERATION_VALUE_MAX = 31;
public static final int ENERGY_POWER_GENERATION_VALUE_MIN = 1;
public static final int ENERGY_ROAD_SURFACE_COMMON = 1;
public static final int ENERGY_ROAD_SURFACE_KEEP = 0;
public static final int ENERGY_ROAD_SURFACE_MODE = 2;
public static final int ENERGY_ROAD_SURFACE_MUDDY = 3;
public static final int ENERGY_ROAD_SURFACE_SAND = 4;
public static final int ENERGY_ROAD_SURFACE_SNOW = 2;
public static final int ENERGY_STATE = 1;
public static final int ENERGY_STATE_ELECTRIC_POWER_FOUR_WHEEL_DRIVE = 1;
public static final int ENERGY_STATE_ELECTRIC_POWER_FOUR_WHEEL_DRIVE_FEEDBACK = 4;
public static final int ENERGY_STATE_ELECTRIC_POWER_FRONT_WHEEL_DRIVE = 2;
public static final int ENERGY_STATE_ELECTRIC_POWER_FRONT_WHEEL_DRIVE_FEEDBACK = 5;
public static final int ENERGY_STATE_ELECTRIC_POWER_REAR_WHEEL_DRIVE = 3;
public static final int ENERGY_STATE_ELECTRIC_POWER_REAR_WHEEL_DRIVE_FEEDBACK = 6;
public static final int ENERGY_STATE_FUEL_POWER_DRIVE = 17;
public static final int ENERGY_STATE_GENERATE_ELECTRICITY = 18;
public static final int ENERGY_STATE_HEV_FRONT_WHEEL_DRIVE_PARALLELING = 8;
public static final int ENERGY_STATE_HEV_THREE_POWER = 7;
public static final int ENERGY_STATE_HEV_TWO_POWER_FOUR_WHEEL_DRIVE = 9;
public static final int ENERGY_STATE_HIGH_SPEED_GENERATE_ELECTRICITY = 22;
public static final int ENERGY_STATE_HYBRID_POWER_FEEDBACK_MODE_1 = 14;
public static final int ENERGY_STATE_HYBRID_POWER_FEEDBACK_MODE_2 = 15;
public static final int ENERGY_STATE_HYBRID_POWER_FEEDBACK_MODE_3 = 16;
public static final int ENERGY_STATE_HYBRID_POWER_LOW_POWER_OUTPUT = 10;
public static final int ENERGY_STATE_HYBRID_POWER_RUNNING_GENERATE_ELECTRICITY_1 = 11;
public static final int ENERGY_STATE_HYBRID_POWER_RUNNING_GENERATE_ELECTRICITY_2 = 12;
public static final int ENERGY_STATE_HYBRID_POWER_RUNNING_GENERATE_ELECTRICITY_3 = 13;
public static final int ENERGY_STATE_LOW_SPEED_GENERATE_ELECTRICITY_1 = 20;
public static final int ENERGY_STATE_LOW_SPEED_GENERATE_ELECTRICITY_2 = 21;
public static final int ENERGY_STATE_MAX = 255;
public static final int ENERGY_STATE_NONE = 0;
public static final int ENERGY_STATE_SERIES_REAR_WHEEL_DRIVE = 19;
public static synchronized BYDAutoEnergyDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int getBCMState() { return 0; }
public int getDCWorkMode() { return 0; }
public int getEnergyMode() { return 0; }
public int getEnergyState() { return 0; }
public int[] getFeatureList() { return null; }
public int getOperationMode() { return 0; }
public int getPowerGenerationState() { return 0; }
public int getPowerGenerationValue() { return 0; }
public int getRoadSurfaceMode() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoEnergyListener absBYDAutoEnergyListener) { }
public void setAllStatus() { }
public int setEnergyMode(int i) { return 0; }
public int setOperationMode(int i) { return 0; }
public int setRoadSurfaceMode(int i) { return 0; }
public void unregisterListener(AbsBYDAutoEnergyListener absBYDAutoEnergyListener) { }
public void registerListener(AbsBYDAutoEnergyListener absBYDAutoEnergyListener, int[] iArr) { }
 }
