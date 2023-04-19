//refactor
package android.hardware.bydauto.adas;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoADASDevice extends AbsBYDAutoDevice {
public static final int ADAS_CMD_CST_ONLINE = 52;
public static final int ADAS_COMMAND_BUSY = -2147482647;
public static final int ADAS_COMMAND_FAILED = -2147482648;
public static final int ADAS_COMMAND_INVALID_VALUE = -2147482645;
public static final int ADAS_COMMAND_SUCCESS = 0;
public static final int ADAS_COMMAND_TIMEOUT = -2147482646;
public static final int ADAS_DRIVE_RESET = 42;
public static final int ADAS_LKS_LDWS_RESET = 41;
public static final int ADAS_SAFETY_RESET = 40;
public static final int ADAS_TJA_ICA_STATE = 39;
public static final int ADAS_TJA_ICA_SWITCH = 38;
public static final int AEB_STATE = 9;
public static final int AUTO_ESP_STATE_OFF = 1;
public static final int AUTO_ESP_STATE_ON = 0;
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
public static final int TJA_INVALID = 0;
public static final int TJA_OFF = 1;
public static final int TJA_ON = 2;
public static final int TJA_STATE_ACTIVE1 = 2;
public static final int TJA_STATE_ACTIVE2 = 3;
public static final int TJA_STATE_FAULT = 4;
public static final int TJA_STATE_OFF = 0;
public static final int TJA_STATE_PASSIVE = 1;
public static synchronized BYDAutoADASDevice getInstance(Context context) { return null; }
public int get123State() { return 0; }
public int getAEBState() { return 0; }
public int getAVHState() { return 0; }
public int getBSDState() { return 0; }
public int getBrakeFootSenseState() { return 0; }
public int getCSTState() { return 0; }
public int getESPOnlineState() { return 0; }
public int getESPState() { return 0; }
public int[] getFeatureList() { return null; }
public int getHDCState() { return 0; }
public int getHMAState() { return 0; }
public int getIboosterState() { return 0; }
public int getLDSWType() { return 0; }
public int getLKSMode() { return 0; }
public int getLKSSensitivity() { return 0; }
public int getPCWState() { return 0; }
public int getSLAState() { return 0; }
public int getTJAState() { return 0; }
public int getType() { return 0; }
public int hasFeature(String str) { return 0; }
public int hasFeature2(String str) { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoADASListener absBYDAutoADASListener) { }
public int reset(int i, int i2) { return 0; }
public int setAEBState(int i) { return 0; }
public int setAVHState(int i) { return 0; }
public int setBSDState(int i) { return 0; }
public int setBSDStaticCalibration(int i) { return 0; }
public int setBrakeFootSenseState(int i) { return 0; }
public int setCSTState(int i) { return 0; }
public int setESPState(int i) { return 0; }
public int setHDCState(int i) { return 0; }
public int setHMAState(int i) { return 0; }
public int setIboosterState(int i) { return 0; }
public int setLDSWType(int i) { return 0; }
public int setLDWStaticCalibration(int i) { return 0; }
public int setLKSMode(int i) { return 0; }
public int setLKSSensitivity(int i) { return 0; }
public int setPCWState(int i) { return 0; }
public int setSLAState(int i) { return 0; }
public int setTJAState(int i) { return 0; }
public void unregisterListener(AbsBYDAutoADASListener absBYDAutoADASListener) { }
public void registerListener(AbsBYDAutoADASListener absBYDAutoADASListener, int[] iArr) { }
 }
