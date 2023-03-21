package android.hardware.bydauto.energy;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoEnergyDevice extends AbsBYDAutoDevice {
    public static final int BCM_STATE = 7;
    public static final int BCM_STATE_CLOSE = 1;
    public static final int BCM_STATE_OPEN = 0;
    public static final int DC_WORK_MODE = 6;
    public static final int DC_WORK_MODE_STATE_BOOST = 1;
    public static final int DC_WORK_MODE_STATE_CLOSE = 0;
    public static final int DC_WORK_MODE_STATE_STEP_DOWN = 2;
    private static final boolean DEBUG = true;
    public static final int ENERGY_COMMAND_BUSY = -2147482647;
    public static final int ENERGY_COMMAND_FAILED = -2147482648;
    public static final int ENERGY_COMMAND_INVALID = -2147482645;
    public static final int ENERGY_COMMAND_SUCCESS = 0;
    public static final int ENERGY_COMMAND_TIMEOUT = -2147482646;
    static final String ENERGY_GET_PERM = "android.permission.BYDAUTO_ENERGY_GET";
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
    static final String ENERGY_SET_PERM = "android.permission.BYDAUTO_ENERGY_SET";
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
    private static final int EV_FOUR_WHEEL_DRIVE = 1;
    private static final int EV_FRONT_WHEEL_DRIVE = 6;
    private static final int EV_REAR_WHEEL_DRIVE = 7;
    private static final int HEV_FOUR_WHEEL_DRIVE = 3;
    private static final int HEV_THREE_POWER_FOUR_WHEEL_DRIVE = 2;
    private static final int HEV_TWO_WHEEL_DRIVE = 4;
    private static final int POWER_SYSTEM_DISABLE = 8;
    private static final int PURE_FUEL = 5;
    protected static final String TAG = "BYDAutoEnergyDevice";
    private static int mDeviceType = 1006;
    private static BYDAutoEnergyDevice mInstance;
    private final Context mContext;

    private BYDAutoEnergyDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoEnergyDevice getInstance(Context context) {
        BYDAutoEnergyDevice bYDAutoEnergyDevice;
        synchronized (BYDAutoEnergyDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoEnergyDevice(context);
            }
            bYDAutoEnergyDevice = mInstance;
        }
        return bYDAutoEnergyDevice;
    }

    public void getAllStatus() {
    }

    public int getBCMState() {
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        int i = super.get(mDeviceType, 7);
        Log.d(TAG, "getBCMState: state is " + i);
        return i;
    }

    public int getDCWorkMode() {
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        int i = super.get(mDeviceType, 6);
        Log.d(TAG, "getDCWorkMode: state is " + i);
        return i;
    }

    public int getEnergyMode() {
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getEnergyMode mode is: " + i);
        return i;
    }

    public int getEnergyState() {
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        if (i > 22 && i <= 255) {
            i = 255;
        }
        Log.d(TAG, "getEnergyState: state is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getOperationMode() {
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getOperationMode value is: " + i);
        return i;
    }

    public int getPowerGenerationState() {
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        int i = super.get(mDeviceType, 4);
        Log.d(TAG, "getPowerGenerationState value is: " + i);
        return i;
    }

    public int getPowerGenerationValue() {
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        int i = super.get(mDeviceType, 5);
        Log.d(TAG, "getPowerGenerationValue value is: " + i);
        return i;
    }

    public int getRoadSurfaceMode() {
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, " getRoadSurfaceMode type is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1006;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoEnergyListener absBYDAutoEnergyListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        if (absBYDAutoEnergyListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoEnergyListener);
        }
    }

    public void setAllStatus() {
    }

    public int setEnergyMode(int i) {
        Log.d(TAG, "setEnergyMode value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ENERGY_SET_PERM, null);
        if (i < 1 || i > 5) {
            return -2147482645;
        }
        return super.set(mDeviceType, 8, i);
    }

    public int setOperationMode(int i) {
        Log.d(TAG, "setOperationState value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ENERGY_SET_PERM, null);
        if (i < 1 || i > 3) {
            return -2147482645;
        }
        return super.set(mDeviceType, 3, i);
    }

    public int setRoadSurfaceMode(int i) {
        Log.d(TAG, "setRoadSurfaceMode value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ENERGY_SET_PERM, null);
        if (i < 0 || i > 4) {
            return -2147482645;
        }
        return super.set(mDeviceType, 2, i);
    }

    public void unregisterListener(AbsBYDAutoEnergyListener absBYDAutoEnergyListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        if (absBYDAutoEnergyListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoEnergyListener);
        }
    }

    public void registerListener(AbsBYDAutoEnergyListener absBYDAutoEnergyListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(ENERGY_GET_PERM, null);
        if (absBYDAutoEnergyListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoEnergyListener, iArr);
        }
    }
}
