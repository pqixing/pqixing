//refactor
package android.hardware.bydauto.panorama;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
public class BYDAutoPanoramaDevice extends AbsBYDAutoDevice {
public static final int BACK_LINE_CONFIG = 7;
public static final int BACK_LINE_MULTIMEDIA = 2;
public static final int BACK_LINE_NOT_SUPPORT = 0;
public static final int BACK_LINE_PAN_INTERNAL = 1;
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
public static final int PANORAMA_COORDINATE = 1;
public static final int PANORAMA_EMERGENCY_BUTTON_INVALID = 0;
public static final int PANORAMA_EMERGENCY_BUTTON_PRESS = 1;
public static final int PANORAMA_EMERGENCY_BUTTON_STATE = 18;
public static final int PANORAMA_FOCUS = 3;
public static final int PANORAMA_FOCUS_OFF = 0;
public static final int PANORAMA_FOCUS_ON = 1;
public static final int PANORAMA_FRONT = 4;
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
public static synchronized BYDAutoPanoramaDevice getInstance(Context context) { return null; }
public int getACUState() { return 0; }
public int getBackLineConfig() { return 0; }
public int getCarInfo() { return 0; }
public int getDisplayMode() { return 0; }
public int getEmergencyButtonState() { return 0; }
public int[] getFeatureList() { return null; }
public int getLVDSState() { return 0; }
public int getPanoOutputSignal() { return 0; }
public int getPanoOutputState() { return 0; }
public int getPanoRotation() { return 0; }
public int getPanoTransparence() { return 0; }
public int getPanoWorkState() { return 0; }
public int getPanoramaOnlineState() { return 0; }
public int getRFCameraSwitchState() { return 0; }
public int getRightCameraSwitchState() { return 0; }
public int getType() { return 0; }
public int hasFeature(String str) { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoPanoramaListener absBYDAutoPanoramaListener) { }
public void setAllStatus() { }
public int setDisplayMode(int i) { return 0; }
public int setLVDSState(int i) { return 0; }
public int setPanoFocusState(int i) { return 0; }
public int setPanoOperation(int i) { return 0; }
public int setPanoOutputState(int i) { return 0; }
public int setPanoParams(int i, int i2, int i3) { return 0; }
public int setPanoRotation(int i) { return 0; }
public int setPanoTouchCoordinateAndShowArea(double d2, double d3, int i, double d4, double d5) { return 0; }
public int setPanoramaTransparence(int i) { return 0; }
public int setRFCameraSwitchState(int i) { return 0; }
public void unregisterListener(AbsBYDAutoPanoramaListener absBYDAutoPanoramaListener) { }
public boolean postEvent(int i, int i2, double d2, Object obj) { return false; }
public void registerListener(AbsBYDAutoPanoramaListener absBYDAutoPanoramaListener, int[] iArr) { }
 }
