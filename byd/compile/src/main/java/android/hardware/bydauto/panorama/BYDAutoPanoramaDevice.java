package android.hardware.bydauto.panorama;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.os.SystemProperties;
import android.provider.CarSettings;
import android.util.Log;

/* loaded from: classes.dex */
public class BYDAutoPanoramaDevice extends AbsBYDAutoDevice {
    public static final int BACK_LINE_CONFIG = 7;
    public static final int BACK_LINE_MULTIMEDIA = 2;
    public static final int BACK_LINE_NOT_SUPPORT = 0;
    public static final int BACK_LINE_PAN_INTERNAL = 1;
    private static final boolean DEBUG = true;
    public static final int DEVICE_HAS_THE_FEATURE = 1;
    public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
    public static final int DISPLAY_MODE_FULL_SCREEN = 1;
    public static final int DISPLAY_MODE_PANORAMA = 0;
    public static final int DISPLAY_MODE_REVERSE = 5;
    public static final int DISPLAY_MODE_RF_REVERSE = 4;
    public static final int DISPLAY_MODE_WIDGET = 3;
    public static final String FEATURE_ACU = "AbilityControlUnit";
    public static final int FUNCATION_DEFECT = 2;
    public static final int FUNCATION_OFF = 0;
    public static final int FUNCATION_ON = 1;
    public static final String GET_PANORAMA_CAMERA = "vehicle.config.cam_sort";
    public static final int HAS_ACU = 20;
    public static final int LVDS_DRIVING_RECORDER_VIEW = 2;
    public static final int LVDS_PANORMA_RF_VIEW = 1;
    public static final int LVDS_TOP_LIGHT_CAMERA_VIEW = 3;
    public static final int PANORAMA_ACU_STATE = 19;
    public static final int PANORAMA_ACU_STATE_CLOSE = 2;
    public static final int PANORAMA_ACU_STATE_INVALID = 0;
    public static final int PANORAMA_ACU_STATE_OPEN = 1;
    public static final int PANORAMA_CAR_BODY_STATE = 21;
    public static final int PANORAMA_CHECK = 3;
    public static final int PANORAMA_COMMAND_BUSY = -2147482647;
    public static final int PANORAMA_COMMAND_FAILED = -2147482648;
    public static final int PANORAMA_COMMAND_INVALID = -2147482645;
    public static final int PANORAMA_COMMAND_SUCCESS = 0;
    public static final int PANORAMA_COMMAND_TIMEOUT = -2147482646;
    private static final String PANORAMA_COMMON_PERM = "android.permission.BYDAUTO_PANORAMA_COMMON";
    public static final int PANORAMA_COORDINATE = 1;
    public static final int PANORAMA_EMERGENCY_BUTTON_INVALID = 0;
    public static final int PANORAMA_EMERGENCY_BUTTON_PRESS = 1;
    public static final int PANORAMA_EMERGENCY_BUTTON_STATE = 18;
    public static final int PANORAMA_FOCUS = 3;
    public static final int PANORAMA_FOCUS_OFF = 0;
    public static final int PANORAMA_FOCUS_ON = 1;
    public static final int PANORAMA_FRONT = 4;
    static final String PANORAMA_GET_PERM = "android.permission.BYDAUTO_PANORAMA_GET";
    public static final int PANORAMA_INVALID = 0;
    public static final int PANORAMA_LEFT = 6;
    public static final int PANORAMA_LVDS_STATE = 16;
    public static final int PANORAMA_NEW_CAR_BODY = 1;
    public static final int PANORAMA_OFF = 2;
    public static final int PANORAMA_OFFLINE = 255;
    public static final int PANORAMA_OFFLINE_STATE = 8;
    public static final int PANORAMA_OLD_CAR_BODY = 0;
    public static final int PANORAMA_ON = 1;
    public static final int PANORAMA_ONLINE = 1;
    public static final int PANORAMA_ONLINE_STATE = 17;
    public static final int PANORAMA_OPERATION = 2;
    public static final int PANORAMA_OUTPUT_COMPOSE = 6;
    public static final int PANORAMA_OUTPUT_FRONT = 2;
    public static final int PANORAMA_OUTPUT_FRONT_LEFT = 8;
    public static final int PANORAMA_OUTPUT_FRONT_RIGHT = 9;
    public static final int PANORAMA_OUTPUT_INVALID = 0;
    public static final int PANORAMA_OUTPUT_LEFT = 4;
    public static final int PANORAMA_OUTPUT_MATCHING = 7;
    public static final int PANORAMA_OUTPUT_OFF = 1;
    public static final int PANORAMA_OUTPUT_REAR = 3;
    public static final int PANORAMA_OUTPUT_REAR_LEFT = 10;
    public static final int PANORAMA_OUTPUT_REAR_RIGHT = 11;
    public static final int PANORAMA_OUTPUT_RIGHT = 5;
    public static final int PANORAMA_OUTPUT_SIGNAL = 6;
    public static final int PANORAMA_OUTPUT_SIGNAL_CVBS = 0;
    public static final int PANORAMA_OUTPUT_SIGNAL_LVDS = 1;
    public static final int PANORAMA_OUTPUT_STATE = 5;
    public static final int PANORAMA_REAR = 5;
    public static final int PANORAMA_REVERSE = 3;
    public static final int PANORAMA_RF_REVERSE = 2;
    public static final int PANORAMA_RIGHT = 7;
    public static final int PANORAMA_RINGHT_CAMERA_SWITCH = 13;
    public static final int PANORAMA_RINGHT_CAMERA_SWITCH_OFF = 2;
    public static final int PANORAMA_RINGHT_CAMERA_SWITCH_ON = 1;
    public static final int PANORAMA_ROTATION = 9;
    public static final int PANORAMA_ROTATION_HORIZONTAL = 1;
    public static final int PANORAMA_ROTATION_VERTICAL = 2;
    public static final int PANORAMA_SD_ONLINE = 4;
    static final String PANORAMA_SET_PERM = "android.permission.BYDAUTO_PANORAMA_SET";
    public static final int PANORAMA_TRANSPARENCE_SWITCH = 22;
    public static final int PANORAMA_TRANSPARENT_STATE = 24;
    public static final int PANORAMA_WORK_MODE = 15;
    public static final int PANORAMA_WORK_OFF = 0;
    public static final int PANORAMA_WORK_ON = 1;
    public static final int PANORAMA_WORK_STATE = 4;
    public static final int PANO_OPERATE_DOWN = 1;
    public static final int PANO_OPERATE_INVALID = 0;
    public static final int PANO_OPERATE_MOVE = 3;
    public static final int PANO_OPERATE_UP = 2;
    public static final int PANO_TRANS_STATE_INVALID = 0;
    public static final int PANO_TRANS_STATE_OFF = 2;
    public static final int PANO_TRANS_STATE_ON = 1;
    protected static final String TAG = "BYDAutoPanoramaDevice";
    private static int mDeviceType = 1031;
    private static BYDAutoPanoramaDevice mInstance;
    private final Context mContext;

    public BYDAutoPanoramaDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoPanoramaDevice getInstance(Context context) {
        BYDAutoPanoramaDevice bYDAutoPanoramaDevice;
        synchronized (BYDAutoPanoramaDevice.class) {
            if (mInstance == null) {
                context.enforceCallingOrSelfPermission(PANORAMA_COMMON_PERM, null);
                if (CarSettings.UserTableData.getSystemInt(context.getContentResolver(), CarSettings.UserTableData.PANORAMA_ONLINE) == 5) {
                    Log.d(TAG, "getInstance() the device is APA.");
                    if (context.getApplicationContext() != null) {
                        mInstance = new BYDAutoPanoramaDevice(context.getApplicationContext());
                    } else {
                        mInstance = new BYDAutoPanoramaDevice(context);
                    }
                } else if (context.getApplicationContext() != null) {
                    mInstance = new BYDAutoPanoramaDeviceDi2l(context.getApplicationContext());
                } else {
                    mInstance = new BYDAutoPanoramaDeviceDi2l(context);
                }
            }
            bYDAutoPanoramaDevice = mInstance;
        }
        return bYDAutoPanoramaDevice;
    }

    public int getACUState() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 19);
        Log.d(TAG, "getACUState is: " + i);
        return i;
    }

    public int getBackLineConfig() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 7);
        Log.d(TAG, "getBackLineConfig is: " + i);
        return i;
    }

    public int getCarInfo() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 21);
        Log.d(TAG, "getCarInfo is: " + i);
        return i;
    }

    public int getDisplayMode() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 15);
        Log.d(TAG, "getDisplayMode is: " + i);
        return i;
    }

    public int getEmergencyButtonState() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 18);
        Log.d(TAG, "getEmergencyButtonState is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getLVDSState() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 16);
        Log.d(TAG, "getLVDSState is: " + i);
        return i;
    }

    public int getPanoOutputSignal() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 6);
        Log.d(TAG, "getPanoOutputSignal is: " + i);
        return i;
    }

    public int getPanoOutputState() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 5);
        Log.d(TAG, "getPanoOutputState is: " + i);
        return i;
    }

    public int getPanoRotation() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getPanoRotation is: " + i);
        return i;
    }

    public int getPanoTransparence() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 24);
        Log.d(TAG, "getPanoTransparence is: " + i);
        return i;
    }

    public int getPanoWorkState() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 4);
        Log.d(TAG, "getPanoWorkState is: " + i);
        return i;
    }

    public int getPanoramaOnlineState() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        String str = SystemProperties.get(GET_PANORAMA_CAMERA);
        Log.d(TAG, "getPanoramaOnlineState is: " + str);
        if (str.contains("pano_h")) {
            return 1;
        }
        if (str.contains("pano_l")) {
            return 4;
        }
        if (str.contains("rf")) {
            return 2;
        }
        return str.contains("rvs") ? 3 : 255;
    }

    public int getRFCameraSwitchState() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 13);
        Log.d(TAG, "getRFCameraSwitchState is: " + i);
        return i;
    }

    public int getRightCameraSwitchState() {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        int i = super.get(mDeviceType, 13);
        Log.d(TAG, "getRightCameraSwitchState is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_PANORAMA;
    }

    public int hasFeature(String str) {
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        if (str.equals(FEATURE_ACU)) {
            int i = super.get(mDeviceType, 20);
            Log.d(TAG, "hasFeature: If has the feature(" + str + "): " + i);
            return i;
        }
        return -2147482645;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoPanoramaListener absBYDAutoPanoramaListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        if (absBYDAutoPanoramaListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoPanoramaListener);
        }
    }

    public void setAllStatus() {
    }

    public int setDisplayMode(int i) {
        Log.d(TAG, "setDisplayMode is: " + i);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i == 0 || i == 1 || i == 3) {
            return super.set(mDeviceType, 15, i);
        }
        return -2147482645;
    }

    public int setLVDSState(int i) {
        Log.d(TAG, "setLVDSState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i == 1 || i == 2 || i == 3) {
            return super.set(mDeviceType, 16, i);
        }
        return -2147482645;
    }

    public int setPanoFocusState(int i) {
        Log.d(TAG, "setPanoFocusState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, 3, i);
        }
        return -2147482645;
    }

    public int setPanoOperation(int i) {
        Log.d(TAG, "setPanoOperation operation is: " + i);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i < 1 || i > 7) {
            return -2147482645;
        }
        return super.set(mDeviceType, 2, i);
    }

    public int setPanoOutputState(int i) {
        Log.d(TAG, "setPanoOutputState is: " + i);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i < 1 || i > 11) {
            return -2147482645;
        }
        return super.set(mDeviceType, 5, i);
    }

    public int setPanoParams(int i, int i2, int i3) {
        Log.d(TAG, "setPanoParams: output=" + i + ", mode=" + i2 + ", rotation=" + i3);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i < 1 || i > 11) {
            return -2147482645;
        }
        if (i2 != 0 && i2 != 1 && i2 != 3) {
            return -2147482645;
        }
        if (i3 != 1 && i3 != 2) {
            return -2147482645;
        }
        return super.set(mDeviceType, new int[]{5, 15, 9}, new int[]{i, i2, i3});
    }

    public int setPanoRotation(int i) {
        Log.d(TAG, "setPanoRotation is: " + i);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i == 1 || i == 2) {
            return super.set(mDeviceType, 9, i);
        }
        return -2147482645;
    }

    public int setPanoTouchCoordinateAndShowArea(double d2, double d3, int i, double d4, double d5) {
        Log.d(TAG, "setPanoTouchPointArea x is: " + d2 + " y is:" + d3 + " operate is:" + i);
        StringBuilder sb = new StringBuilder();
        sb.append("setPanoTouchPointArea width is: ");
        sb.append(d4);
        sb.append(" height is:");
        sb.append(d5);
        Log.d(TAG, sb.toString());
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i == 0 || i == 2 || i == 1 || i == 3) {
            int[] iArr = new int[5];
            iArr[0] = 1;
            return super.set(mDeviceType, iArr, new double[]{d2, d3, i, d4, d5});
        }
        return -2147482645;
    }

    public int setPanoramaTransparence(int i) {
        Log.d(TAG, "setPanoramaTransparence state is " + i);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        if (i == 1 || i == 0) {
            return super.set(mDeviceType, 22, i);
        }
        return -2147482645;
    }

    public int setRFCameraSwitchState(int i) {
        Log.d(TAG, "setRFCameraSwitchState state is " + i);
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_SET_PERM, null);
        int i2 = 1;
        if (i == 2) {
            i2 = 0;
        } else if (i != 1) {
            return -2147482645;
        }
        Log.d(TAG, "setRFCameraSwitchState halState is " + i2);
        return super.set(mDeviceType, 13, i2);
    }

    public void unregisterListener(AbsBYDAutoPanoramaListener absBYDAutoPanoramaListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        if (absBYDAutoPanoramaListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoPanoramaListener);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + d2);
        return onPostEvent(new BYDAutoEvent(i, i2, d2, obj));
    }

    public void registerListener(AbsBYDAutoPanoramaListener absBYDAutoPanoramaListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(PANORAMA_GET_PERM, null);
        if (absBYDAutoPanoramaListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoPanoramaListener, iArr);
        }
    }
}
