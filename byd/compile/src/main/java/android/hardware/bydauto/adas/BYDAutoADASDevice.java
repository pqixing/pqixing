package android.hardware.bydauto.adas;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoADASDevice extends AbsBYDAutoDevice {
    public static final int ADAS_CMD_CST_ONLINE = 52;
    public static final int ADAS_COMMAND_BUSY = -2147482647;
    public static final int ADAS_COMMAND_FAILED = -2147482648;
    public static final int ADAS_COMMAND_INVALID_VALUE = -2147482645;
    public static final int ADAS_COMMAND_SUCCESS = 0;
    public static final int ADAS_COMMAND_TIMEOUT = -2147482646;
    public static final int ADAS_DRIVE_RESET = 42;
    static final String ADAS_GET_PERM = "android.permission.BYDAUTO_ADAS_GET";
    public static final int ADAS_LKS_LDWS_RESET = 41;
    public static final int ADAS_SAFETY_RESET = 40;
    static final String ADAS_SET_PERM = "android.permission.BYDAUTO_ADAS_SET";
    protected static final int ADAS_SLA_STATE_DEFECT = 4;
    protected static final int ADAS_SLA_STATE_FUSION_MODE = 1;
    protected static final int ADAS_SLA_STATE_NV_ONLY_MODE = 3;
    protected static final int ADAS_SLA_STATE_OFF = 0;
    protected static final int ADAS_SLA_STATE_VISION_MODE = 2;
    public static final int ADAS_TJA_ICA_STATE = 39;
    public static final int ADAS_TJA_ICA_SWITCH = 38;
    public static final int AEB_STATE = 9;
    public static final int AUTO_ESP_STATE_OFF = 1;
    public static final int AUTO_ESP_STATE_ON = 0;
    protected static final int AUTO_HOLD_STATE1 = 0;
    protected static final int AUTO_HOLD_STATE2 = 1;
    protected static final int AUTO_HOLD_STATE3 = 2;
    protected static final int AUTO_HOLD_STATE4 = 3;
    public static final int AUTO_IBOOSTER_STATE_COMFORTABLE = 2;
    public static final int AUTO_IBOOSTER_STATE_SPORT = 1;
    public static final int AUTO_IBOOSTER_STATE_STANDARD = 0;
    public static final int AVH_STATE = 11;
    public static final int BRAKE_FOOT_SENSE_COMFORTABLE = 2;
    public static final int BRAKE_FOOT_SENSE_INVALID = 3;
    public static final int BRAKE_FOOT_SENSE_SPORT = 1;
    public static final int BRAKE_FOOT_SENSE_STANDARD = 0;
    public static final int BSD_STATE = 14;
    public static final int BSD_STATIC_CALIBRATION = 36;
    public static final int BSD_STATIC_CALIBRATION_INVALID = 0;
    public static final int BSD_STATIC_CALIBRATION_START = 1;
    public static final int CMD_ADAS_ESP_KEY = 46;
    public static final int CMD_ADAS_ESP_ONLINE = 45;
    public static final int CMD_BRAKE_FOOT_SENSE = 48;
    public static final int CMD_BRAKE_FOOT_SENSE_ONLINE = 47;
    public static final int CMD_CST_SWITCH = 51;
    public static final int CMD_HDC_STATE = 44;
    public static final int CMD_HDC_SWITCH = 43;
    protected static final int CST_STATE_ACTIVE_GET = 2;
    protected static final int CST_STATE_DISABLED_GET = 0;
    protected static final int CST_STATE_FAILURE_GET = 3;
    protected static final int CST_STATE_STANDBY_GET = 1;
    protected static final int CST_SWITCH_INVALID_SET = 0;
    protected static final int CST_SWITCH_OFF_SET = 2;
    protected static final int CST_SWITCH_ON_SET = 1;
    private static final boolean DEBUG = true;
    public static final int DEVICE_HAS_THE_FEATURE = 1;
    public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
    public static final int ESP_KEY_NO_ACTION = 0;
    public static final int ESP_KEY_PRESSED = 1;
    public static final int ESP_OFFLINE = 3;
    public static final int ESP_STATE = 10;
    public static final int ESP_WITHOUT_HARD_SWITCH = 2;
    public static final int ESP_WITH_HARD_SWITCH = 1;
    public static final String FEATURE_ADAS_AVH = "AVH";
    public static final String FEATURE_ADAS_BRAKE_FOOT_SENSE = "BrakeFootSense";
    public static final String FEATURE_ADAS_CST = "CST";
    public static final String FEATURE_ADAS_LDW = "LDW";
    public static final String FEATURE_ADAS_LKS = "LKS";
    public static final String FEATURE_ADAS_TJA = "TJA";
    public static final String FEATURE_AEB = "AutomaticEmergencyBrake";
    public static final String FEATURE_BSD = "BlindSpotDetection";
    public static final String FEATURE_HMA = "IntelligentFarAndNearLight";
    public static final String FEATURE_LDSW = "LaneDepartureWarning";
    public static final String FEATURE_LKS_MODE = "LaneKeepingAssistMode";
    public static final String FEATURE_LKS_SENSITIVITY = "LaneKeepingAssistSensitivity";
    public static final String FEATURE_PCW = "PredictionCollisionWarning";
    public static final String FEATURE_SLA = "TrafficSignRecognition";
    public static final int FUNCATION_DEFECT = 2;
    public static final int FUNCATION_OFF = 0;
    public static final int FUNCATION_ON = 1;
    public static final int HAS2_ACC = 27;
    public static final int HAS2_AEB = 28;
    public static final int HAS2_FCW = 29;
    public static final int HAS2_HMA = 32;
    public static final int HAS2_LDW = 31;
    public static final int HAS2_LKS = 30;
    public static final int HAS2_SLA = 33;
    public static final int HAS2_TJA = 34;
    public static final int HAS_AEB = 18;
    public static final int HAS_AVH = 26;
    public static final int HAS_BSD = 22;
    public static final int HAS_ESP = 25;
    public static final int HAS_HMA = 24;
    public static final int HAS_LDSW = 21;
    public static final int HAS_LKS_MODE = 19;
    public static final int HAS_LKS_SENSITIVITY = 20;
    public static final int HAS_PCW = 17;
    public static final int HAS_SLA = 23;
    protected static final int HDC_STATE_OFFLINE = 3;
    protected static final int HDC_STATE_OFF_NO_LAMP = 0;
    protected static final int HDC_STATE_ON_LAMP_FLASH = 2;
    protected static final int HDC_STATE_ON_LAMP_ON = 1;
    public static final int HMA_STATE = 1;
    public static final int HMA_STATE_ACTIVE = 3;
    public static final int HMA_STATE_CAMERA_BLOCKED = 5;
    public static final int HMA_STATE_FAULT = 4;
    public static final int HMA_STATE_OFF = 0;
    public static final int HMA_STATE_PASSIVE = 1;
    public static final int HMA_STATE_STANDBY = 2;
    public static final int IBOOSTER_STATE = 12;
    public static final int LDSW_TYPE = 5;
    public static final int LDSW_TYPE_ALL = 2;
    public static final int LDSW_TYPE_SOUND = 1;
    public static final int LDSW_TYPE_VIBRATE = 0;
    public static final int LDW_STATIC_CALIBRATION = 37;
    public static final int LDW_STATIC_CALIBRATION_INVALID = 0;
    public static final int LDW_STATIC_CALIBRATION_START = 1;
    public static final int LKS_MODE = 2;
    public static final int LKS_MODE_ALL = 3;
    public static final int LKS_MODE_DIVERGE = 1;
    public static final int LKS_MODE_KEEPING = 2;
    public static final int LKS_MODE_OFF = 0;
    public static final int LKS_SENSITIVITY = 3;
    public static final int LKS_SENSITIVITY_INTELLIGENCE = 0;
    public static final int LKS_SENSITIVITY_STANDARD = 1;
    public static final int PCW_STATE = 8;
    public static final int RESET_INVALID = 0;
    public static final int RESET_ITEM_DRIVE = 2;
    public static final int RESET_ITEM_LKS_LDWS = 1;
    public static final int RESET_ITEM_SAFETY = 0;
    public static final int RESET_VALID = 1;
    public static final int SLA_STATE = 13;
    protected static final String TAG = "BYDAutoADASDevice";
    public static final int TJA_INVALID = 0;
    public static final int TJA_OFF = 1;
    public static final int TJA_ON = 2;
    public static final int TJA_STATE_ACTIVE1 = 2;
    public static final int TJA_STATE_ACTIVE2 = 3;
    public static final int TJA_STATE_FAULT = 4;
    public static final int TJA_STATE_OFF = 0;
    public static final int TJA_STATE_PASSIVE = 1;
    private static int mDeviceType = 1038;
    private static BYDAutoADASDevice mInstance;
    private final Context mContext;
    protected final int HDC_SWITCH_INVALID = 0;
    protected final int HDC_SWITCH_ON = 1;
    protected final int HDC_SWITCH_OFF = 2;

    private BYDAutoADASDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoADASDevice getInstance(Context context) {
        BYDAutoADASDevice bYDAutoADASDevice;
        synchronized (BYDAutoADASDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoADASDevice(context);
            }
            bYDAutoADASDevice = mInstance;
        }
        return bYDAutoADASDevice;
    }

    public int get123State() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 45);
        Log.d(TAG, "get123State: state is " + i);
        return i;
    }

    public int getAEBState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getAEBState: state is " + i);
        return i;
    }

    public int getAVHState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 11);
        Log.d(TAG, "getAVHState: state is " + i);
        if (i == 0) {
            return 0;
        }
        return (i == 1 || i == 2 || i == 3) ? 1 : -2147482645;
    }

    public int getBSDState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 14);
        Log.d(TAG, "getBSDState: state is " + i);
        return i;
    }

    public int getBrakeFootSenseState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 48);
        Log.d(TAG, "getBrakeFootSenseState: state is " + i);
        return i;
    }

    public int getCSTState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 51);
        int i2 = 1;
        if (i != 2 && i != 1) {
            i2 = i == 0 ? 0 : 2;
        }
        Log.d(TAG, "getCSTState: state is " + i2 + " state_hal is: " + i);
        return i2;
    }

    public int getESPOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 25);
        Log.d(TAG, "getESPOnlineState: state is " + i);
        return i;
    }

    public int getESPState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 10);
        Log.d(TAG, "getESPState: state is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getHDCState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 44);
        int i2 = 2;
        if (i == 0) {
            i2 = 0;
        } else if (i == 1 || i == 2) {
            i2 = 1;
        }
        Log.d(TAG, "getHDCState: state is " + i2);
        return i2;
    }

    public int getHMAState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getHMAState: state is " + i);
        return i;
    }

    public int getIboosterState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 12);
        Log.d(TAG, "getIbooterState: state is " + i);
        return i;
    }

    public int getLDSWType() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 5);
        Log.d(TAG, "getLDSWType: type is " + i);
        return i;
    }

    public int getLKSMode() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getLKSMode: mode is " + i);
        return i;
    }

    public int getLKSSensitivity() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getLKSSensitivity: sensitivity is " + i);
        return i;
    }

    public int getPCWState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 8);
        Log.d(TAG, "getPCWState: state is " + i);
        return i;
    }

    public int getSLAState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 13);
        Log.d(TAG, "getSLAState: state is " + i);
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2 || i == 3) {
            return 1;
        }
        if (i != 4) {
            return i;
        }
        return 2;
    }

    public int getTJAState() {
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        int i = super.get(mDeviceType, 39);
        int i2 = 2;
        if (i == 0) {
            i2 = 0;
        } else if (i == 1 || i == 2 || i == 3) {
            i2 = 1;
        }
        Log.d(TAG, "getTJAState: state is " + i2);
        return i2;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_ADAS;
    }

    public int hasFeature(String str) {
        int i;
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        if (str.equals(FEATURE_PCW)) {
            i = 29;
        } else if (str.equals(FEATURE_AEB)) {
            i = 28;
        } else if (str.equals(FEATURE_LKS_MODE)) {
            i = 19;
        } else if (str.equals(FEATURE_LKS_SENSITIVITY)) {
            i = 20;
        } else if (str.equals(FEATURE_LDSW)) {
            i = 21;
        } else if (str.equals(FEATURE_BSD)) {
            i = 22;
        } else if (str.equals(FEATURE_SLA)) {
            i = 33;
        } else if (str.equals(FEATURE_HMA)) {
            i = 32;
        } else if (str.equals(FEATURE_ADAS_AVH)) {
            i = 26;
        } else if (!str.equals(FEATURE_ADAS_CST)) {
            return -2147482645;
        } else {
            i = 52;
        }
        int i2 = super.get(mDeviceType, i);
        Log.d(TAG, "hasFeature: If has the feature(" + str + "): " + i2);
        return i2;
    }

    public int hasFeature2(String str) {
        int i;
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        if (str.equals(FEATURE_ADAS_LDW)) {
            i = 31;
        } else if (str.equals(FEATURE_ADAS_LKS)) {
            i = 30;
        } else if (str.equals(FEATURE_ADAS_TJA)) {
            i = 34;
        } else if (!str.equals(FEATURE_ADAS_BRAKE_FOOT_SENSE)) {
            return -2147482645;
        } else {
            i = 47;
        }
        int i2 = super.get(mDeviceType, i);
        Log.d(TAG, "hasFeature2: If has the feature(" + str + "): " + i2);
        return i2;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoADASListener absBYDAutoADASListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        if (absBYDAutoADASListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoADASListener);
        }
    }

    public int reset(int i, int i2) {
        int i3;
        Log.d(TAG, "resetADAS item is: " + i + " and value is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i2 == 0 || i2 == 1) {
            if (i == 0) {
                i3 = 40;
            } else if (i == 1) {
                i3 = 41;
            } else if (i != 2) {
                return -2147482645;
            } else {
                i3 = 42;
            }
            return super.set(mDeviceType, i3, i2);
        }
        return -2147482645;
    }

    public int setAEBState(int i) {
        Log.d(TAG, "setAEBState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 9, i);
        }
        return -2147482645;
    }

    public int setAVHState(int i) {
        Log.d(TAG, "setAVHState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 11, i);
        }
        return -2147482645;
    }

    public int setBSDState(int i) {
        Log.d(TAG, "setBSDState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 14, i);
        }
        return -2147482645;
    }

    public int setBSDStaticCalibration(int i) {
        Log.d(TAG, "setBSDStaticCalibration: value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 36, i);
        }
        return -2147482645;
    }

    public int setBrakeFootSenseState(int i) {
        Log.d(TAG, "setFootSenseState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i < 0 || i > 3) {
            return -2147482645;
        }
        return super.set(mDeviceType, 48, i);
    }

    public int setCSTState(int i) {
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        int i2 = 1;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            return -2147482645;
        }
        Log.d(TAG, "setCSTState: state is: " + i + " state_hal is: " + i2);
        return super.set(mDeviceType, 51, i2);
    }

    public int setESPState(int i) {
        Log.d(TAG, "setESPState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 10, i);
        }
        return -2147482645;
    }

    public int setHDCState(int i) {
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        int i2 = 1;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            return -2147482645;
        }
        Log.d(TAG, "setHDCState: state is " + i2);
        return super.set(mDeviceType, 43, i2);
    }

    public int setHMAState(int i) {
        Log.d(TAG, "setHMAState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 1, i);
        }
        return -2147482645;
    }

    public int setIboosterState(int i) {
        Log.d(TAG, "setIbooterState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i < 0 || i > 2) {
            return -2147482645;
        }
        return super.set(mDeviceType, 12, i);
    }

    public int setLDSWType(int i) {
        Log.d(TAG, "setLDSWType: type is " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i < 0 || i > 2) {
            return -2147482645;
        }
        return super.set(mDeviceType, 5, i);
    }

    public int setLDWStaticCalibration(int i) {
        Log.d(TAG, "setLDWStaticCalibration: value is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 37, i);
        }
        return -2147482645;
    }

    public int setLKSMode(int i) {
        Log.d(TAG, "setLKSMode: mode is " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i < 0 || i > 3) {
            return -2147482645;
        }
        return super.set(mDeviceType, 2, i);
    }

    public int setLKSSensitivity(int i) {
        Log.d(TAG, "setLKSSensitivity: sensitivity is " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, 3, i);
        }
        return -2147482645;
    }

    public int setPCWState(int i) {
        Log.d(TAG, "setPCWState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 8, i);
        }
        return -2147482645;
    }

    public int setSLAState(int i) {
        Log.d(TAG, "setSLAState: state is: " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i == 0 || i == 1) {
            return super.set(mDeviceType, 13, i);
        }
        return -2147482645;
    }

    public int setTJAState(int i) {
        Log.d(TAG, "setTJAState: state is " + i);
        this.mContext.enforceCallingOrSelfPermission(ADAS_SET_PERM, null);
        if (i != 0) {
            if (i == 1) {
                return super.set(mDeviceType, 38, 2);
            }
            return -2147482645;
        }
        return super.set(mDeviceType, 38, 1);
    }

    public void unregisterListener(AbsBYDAutoADASListener absBYDAutoADASListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        if (absBYDAutoADASListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoADASListener);
        }
    }

    public void registerListener(AbsBYDAutoADASListener absBYDAutoADASListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(ADAS_GET_PERM, null);
        if (absBYDAutoADASListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoADASListener, iArr);
        }
    }
}
