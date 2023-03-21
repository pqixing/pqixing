package android.hardware.bydauto.engine;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoEngineDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int DEVICE_HAS_THE_FEATURE = 1;
    public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
    public static final int ENGINE_CAPACITY_MAX = 250;
    public static final int ENGINE_CAPACITY_MIN = 0;
    public static final int ENGINE_CODE = 3;
    public static final int ENGINE_COMMAND_BUSY = -2147482647;
    public static final int ENGINE_COMMAND_FAILED = -2147482648;
    public static final int ENGINE_COMMAND_INVALID_VALUE = -2147482645;
    public static final int ENGINE_COMMAND_SUCCESS = 0;
    public static final int ENGINE_COMMAND_TIMEOUT = -2147482646;
    public static final int ENGINE_COOLANT_LEVEL = 12;
    public static final int ENGINE_COOLANT_LEVEL_LOW = 2;
    public static final int ENGINE_COOLANT_LEVEL_NORMAL = 1;
    public static final int ENGINE_COOLING_FAN_TEMPERATURE_MAX = 1;
    public static final int ENGINE_COOLING_FAN_TEMPERATURE_MIN = 0;
    public static final int ENGINE_DISPLACEMENT = 4;
    public static final double ENGINE_DISPLACEMENT_MAX = 25.5d;
    public static final double ENGINE_DISPLACEMENT_MIN = 0.0d;
    private static final String ENGINE_GET_PERM = "android.permission.BYDAUTO_ENGINE_GET";
    public static final int ENGINE_IDLING_STATE_OFF = 0;
    public static final int ENGINE_IDLING_STATE_ON = 1;
    public static final double ENGINE_MILEAGE_MAX = 1677721.5d;
    public static final double ENGINE_MILEAGE_MIN = 0.0d;
    public static final int ENGINE_OIL_LEVEL = 7;
    public static final int ENGINE_OIL_MAX = 254;
    public static final int ENGINE_OIL_MIN = 0;
    public static final int ENGINE_POWER = 2;
    public static final int ENGINE_POWER_MAX = 300;
    public static final int ENGINE_POWER_MIN = -100;
    private static final String ENGINE_SET_PERM = "android.permission.BYDAUTO_ENGINE_SET";
    public static final int ENGINE_SIMULATOR_SOURCE_TYPE = 16;
    public static final int ENGINE_SIMULATOR_VOICE_SOURCE_1 = 1;
    public static final int ENGINE_SIMULATOR_VOICE_SOURCE_2 = 2;
    public static final int ENGINE_SIMULATOR_VOICE_SOURCE_3 = 3;
    public static final int ENGINE_SPEED = 6;
    public static final int ENGINE_SPEED_MAX = 8000;
    public static final int ENGINE_SPEED_MIN = 0;
    public static final int ENGINE_STATE_BREAKDOWN = 2;
    public static final int ENGINE_STATE_NORMAL = 1;
    public static final int ENGINE_STATE_S = 11;
    public static final int ENGINE_TARGET_IDLING_VALUE_MAX = 2540;
    public static final int ENGINE_TARGET_IDLING_VALUE_MIN = 0;
    public static final String ENGINE_TYPE1 = "371QA";
    public static final String ENGINE_TYPE10 = "488QA";
    public static final String ENGINE_TYPE11 = "4G15";
    public static final String ENGINE_TYPE12 = "4G18";
    public static final String ENGINE_TYPE13 = "4G69";
    public static final String ENGINE_TYPE14 = "473QE";
    public static final String ENGINE_TYPE15 = "471ZQA";
    public static final String ENGINE_TYPE2 = "473QB";
    public static final String ENGINE_TYPE3 = "473QC";
    public static final String ENGINE_TYPE4 = "473QD";
    public static final String ENGINE_TYPE5 = "476ZQA";
    public static final String ENGINE_TYPE6 = "483QA";
    public static final String ENGINE_TYPE7 = "483QB";
    public static final String ENGINE_TYPE8 = "483QB CNG";
    public static final String ENGINE_TYPE9 = "487ZQA";
    public static final int ENGINE_VOICE_SIMULATOR_OFF = 0;
    public static final int ENGINE_VOICE_SIMULATOR_ON = 1;
    public static final int ENGINE_VOICE_SIMULATOR_STATE = 14;
    public static final int ENGINE_WATER_TEMPERATURE_ABNORMAL = 255;
    public static final int ENGINE_WATER_TEMPERATURE_MAX = 194;
    public static final int ENGINE_WATER_TEMPERATURE_MIN = -60;
    public static final String FEATURE_ENGINE_VOICE_SIMULATOR = "EngineVoiceSimulator";
    public static final String FEATURE_ENGINE_VOICE_SOURCE = "EngineVoiceSource";
    public static final int HAS_ENGINE_VOICE_SIMULATOR = 13;
    public static final int HAS_ENGINE_VOICE_SOURCE = 15;
    protected static final String TAG = "BYDAutoEngineDevice";
    private static int mDeviceType = 1012;
    private static BYDAutoEngineDevice mInstance;
    private final Context mContext;

    private BYDAutoEngineDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoEngineDevice getInstance(Context context) {
        BYDAutoEngineDevice bYDAutoEngineDevice;
        synchronized (BYDAutoEngineDevice.class) {
            if (mInstance == null && context != null) {
                mInstance = new BYDAutoEngineDevice(context);
            }
            bYDAutoEngineDevice = mInstance;
        }
        return bYDAutoEngineDevice;
    }

    public void getAllStatus() {
    }

    public String getEngineCode() {
        String str;
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getEngineCode: The engine value is " + i);
        switch (i) {
            case 0:
                str = ENGINE_TYPE1;
                break;
            case 1:
                str = ENGINE_TYPE2;
                break;
            case 2:
                str = ENGINE_TYPE3;
                break;
            case 3:
                str = ENGINE_TYPE4;
                break;
            case 4:
                str = ENGINE_TYPE5;
                break;
            case 5:
                str = ENGINE_TYPE6;
                break;
            case 6:
                str = ENGINE_TYPE7;
                break;
            case 7:
                str = ENGINE_TYPE8;
                break;
            case 8:
                str = ENGINE_TYPE9;
                break;
            case 9:
                str = ENGINE_TYPE10;
                break;
            case 10:
                str = ENGINE_TYPE11;
                break;
            case 11:
                str = ENGINE_TYPE12;
                break;
            case 12:
                str = ENGINE_TYPE13;
                break;
            case 13:
                str = ENGINE_TYPE14;
                break;
            case 14:
                str = ENGINE_TYPE15;
                break;
            default:
                return "NULL";
        }
        Log.d(TAG, "getEngineCode: The engine code is " + str);
        return str;
    }

    public int getEngineCoolantLevel() {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        int i = super.get(mDeviceType, 12);
        Log.d(TAG, "getEngineCoolantLevel: The engine coolant level is " + i);
        return i;
    }

    public double getEngineDisplacement() {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        double d2 = super.getDouble(mDeviceType, 4);
        Log.d(TAG, "getEngineDisplacement: The engine displacement is " + d2);
        return d2;
    }

    public int getEnginePower() {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getEnginePower: The engine power is " + i);
        return i;
    }

    public int getEngineSimulatorVoiceSource() {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        int i = super.get(mDeviceType, 16);
        Log.d(TAG, "getEngineSimulatorVoiceSource: The engine simulator voice source type is " + i);
        return i;
    }

    public int getEngineSpeed() {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        int i = super.get(mDeviceType, 6);
        Log.d(TAG, "getEngineSpeed: The engine speed is " + i);
        return i;
    }

    public byte[] getEngineState() {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        return super.getBuffer(mDeviceType, 11);
    }

    public int getEngineVoiceSimulatorState() {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        int i = super.get(mDeviceType, 14);
        Log.d(TAG, "getEngineVoiceSimulatorState: The state of engine voice simulator is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getOilLevel() {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        int i = super.get(mDeviceType, 7);
        Log.d(TAG, "getOilLevel: The engine oil level is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1012;
    }

    public int hasFeature(String str) {
        int i;
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        if (str.equals(FEATURE_ENGINE_VOICE_SIMULATOR)) {
            i = 13;
        } else if (!str.equals(FEATURE_ENGINE_VOICE_SOURCE)) {
            return -2147482645;
        } else {
            i = 15;
        }
        int i2 = super.get(mDeviceType, i);
        Log.d(TAG, "hasFeature: If has the feature(" + str + "): " + i2);
        return i2;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + Arrays.toString(bArr));
        return onPostEvent(new BYDAutoEngineEvent(i, i2, bArr, obj));
    }

    public void registerListener(AbsBYDAutoEngineListener absBYDAutoEngineListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        if (absBYDAutoEngineListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoEngineListener);
        }
    }

    public void setAllStatus() {
    }

    public int setEngineSimulatorVoiceSource(int i) {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_SET_PERM, null);
        Log.d(TAG, "setEngineSimulatorVoiceSource: the type of engine voice source is " + i);
        if (i == 1 || i == 2 || i == 3) {
            return super.set(mDeviceType, 16, i);
        }
        return -2147482645;
    }

    public int setEngineVoiceSimulatorState(int i) {
        this.mContext.enforceCallingOrSelfPermission(ENGINE_SET_PERM, null);
        Log.d(TAG, "setEngineVoiceSimulatorState: the state of engine voice simulator is " + i);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, 14, i);
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoEngineListener absBYDAutoEngineListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        if (absBYDAutoEngineListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoEngineListener);
        }
    }

    public void registerListener(AbsBYDAutoEngineListener absBYDAutoEngineListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(ENGINE_GET_PERM, null);
        if (absBYDAutoEngineListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoEngineListener, iArr);
        }
    }
}
