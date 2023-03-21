package android.hardware.bydauto.bodywork;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;

/* loaded from: classes.dex */
public final class BYDAutoBodyworkDevice extends AbsBYDAutoDevice {
    public static final int AUTO_MODEL_NEW_QIN_EV = 2;
    public static final int AUTO_MODEL_NEW_QIN_FUEL = 3;
    public static final int AUTO_MODEL_NEW_QIN_HEV = 1;
    public static final int AUTO_MODEL_NEW_TANG_EV = 6;
    public static final int AUTO_MODEL_NEW_TANG_FUEL = 5;
    public static final int AUTO_MODEL_NEW_TANG_HEV = 4;
    public static final int AUTO_MODEL_NULL = 11;
    public static final int AUTO_MODEL_SONG_18_EV = 9;
    public static final int AUTO_MODEL_SONG_18_FUEL = 7;
    public static final int AUTO_MODEL_SONG_18_HEV = 8;
    public static final int AUTO_MODEL_SONG_MAX_HEV = 10;
    public static final int AUTO_TYPE_3A = 20;
    public static final int AUTO_TYPE_3B = 36;
    public static final int AUTO_TYPE_5A = 5;
    public static final int AUTO_TYPE_5AEV = 29;
    public static final int AUTO_TYPE_5B = 22;
    public static final int AUTO_TYPE_5BH = 27;
    public static final int AUTO_TYPE_5BHE = 53;
    public static final int AUTO_TYPE_5BHI = 64;
    public static final int AUTO_TYPE_6A = 7;
    public static final int AUTO_TYPE_6B = 8;
    public static final int AUTO_TYPE_EL = 96;
    public static final int AUTO_TYPE_EMEA = 95;
    public static final int AUTO_TYPE_F0 = 0;
    public static final int AUTO_TYPE_F3 = 1;
    public static final int AUTO_TYPE_F3R = 2;
    public static final int AUTO_TYPE_F6 = 6;
    public static final int AUTO_TYPE_G3 = 3;
    public static final int AUTO_TYPE_HA = 13;
    public static final int AUTO_TYPE_HAC = 46;
    public static final int AUTO_TYPE_HAD = 50;
    public static final int AUTO_TYPE_HADA = 63;
    public static final int AUTO_TYPE_HADE = 51;
    public static final int AUTO_TYPE_HADF = 66;
    public static final int AUTO_TYPE_HADG = 85;
    public static final int AUTO_TYPE_HAEA = 49;
    public static final int AUTO_TYPE_HAEC = 62;
    public static final int AUTO_TYPE_HAEV = 28;
    public static final int AUTO_TYPE_HA_15A = 37;
    public static final int AUTO_TYPE_HB = 14;
    public static final int AUTO_TYPE_HC = 15;
    public static final int AUTO_TYPE_HCE = 92;
    public static final int AUTO_TYPE_HCF = 93;
    public static final int AUTO_TYPE_HD = 31;
    public static final int AUTO_TYPE_HDE = 98;
    public static final int AUTO_TYPE_HDF = 99;
    public static final int AUTO_TYPE_L3 = 4;
    public static final int AUTO_TYPE_L3G = 33;
    public static final int AUTO_TYPE_M6 = 10;
    public static final int AUTO_TYPE_MEE = 44;
    public static final int AUTO_TYPE_MEF = 42;
    public static final int AUTO_TYPE_MEFD = 81;
    public static final int AUTO_TYPE_MEH = 43;
    public static final int AUTO_TYPE_MEHD = 67;
    public static final int AUTO_TYPE_RSA = 45;
    public static final int AUTO_TYPE_S6 = 9;
    public static final int AUTO_TYPE_S6DM = 17;
    public static final int AUTO_TYPE_S8 = 16;
    public static final int AUTO_TYPE_SA = 11;
    public static final int AUTO_TYPE_SA2E = 84;
    public static final int AUTO_TYPE_SA2FC = 82;
    public static final int AUTO_TYPE_SA2H = 83;
    public static final int AUTO_TYPE_SA3E = 72;
    public static final int AUTO_TYPE_SA3F = 68;
    public static final int AUTO_TYPE_SA3H = 71;
    public static final int AUTO_TYPE_SADM = 12;
    public static final int AUTO_TYPE_SAEA = 40;
    public static final int AUTO_TYPE_SAEC = 70;
    public static final int AUTO_TYPE_SAED = 97;
    public static final int AUTO_TYPE_SAEG = 94;
    public static final int AUTO_TYPE_SAEV = 39;
    public static final int AUTO_TYPE_SAFG = 73;
    public static final int AUTO_TYPE_SAH = 32;
    public static final int AUTO_TYPE_SAHA = 88;
    public static final int AUTO_TYPE_SAHB = 89;
    public static final int AUTO_TYPE_SAHC = 90;
    public static final int AUTO_TYPE_SAHE = 65;
    public static final int AUTO_TYPE_SAHG = 61;
    public static final int AUTO_TYPE_SAHX = 74;
    public static final int AUTO_TYPE_SC = 30;
    public static final int AUTO_TYPE_SCEA = 41;
    public static final int AUTO_TYPE_SCED = 69;
    public static final int AUTO_TYPE_SCH = 35;
    public static final int AUTO_TYPE_SE = 23;
    public static final int AUTO_TYPE_SEF = 24;
    public static final int AUTO_TYPE_SEH = 48;
    public static final int AUTO_TYPE_ST = 47;
    public static final int AUTO_TYPE_STC = 56;
    public static final int AUTO_TYPE_STE = 58;
    public static final int AUTO_TYPE_STEB = 59;
    public static final int AUTO_TYPE_STEM = 60;
    public static final int AUTO_TYPE_STF = 54;
    public static final int AUTO_TYPE_STFD = 55;
    public static final int AUTO_TYPE_STM = 57;
    public static final int AUTO_TYPE_VA = 18;
    public static final int AUTO_TYPE_VB = 19;
    public static final int AUTO_TYPE_VBEV = 26;
    public static final int AUTO_TYPE_VBH = 25;
    public static final int AUTO_TYPE_VC = 21;
    public static final int AUTO_TYPE_e6B = 38;
    public static final int AUTO_TYPE_e6H = 34;
    public static final int AUTO_TYPE_e6K = 52;
    public static final int BD_LEFT_FRONT_WINDOW_PERMIT = 52;
    public static final int BD_SUNROOF_CLOSE_NOTICE = 54;
    public static final int BD_SUNROOF_INIT_STATE = 55;
    public static final int BD_SUNROOF_POSITION = 56;
    public static final int BD_SUNROOF_STATE = 51;
    public static final int BD_SUNROOF_WINDOBLIND_INIT_STATE = 53;
    public static final int BD_SUNROOF_WINDOBLIND_POSITION = 57;
    public static final int BODYWORK_ALARM_STATE = 25;
    public static final int BODYWORK_ALARM_STATE_OFF = 0;
    public static final int BODYWORK_ALARM_STATE_ON = 1;
    public static final int BODYWORK_ALL_WINDOW_ANTI_PINCH = 4;
    public static final int BODYWORK_ANTI_PINCH_INVLAID = 0;
    public static final int BODYWORK_AUTO_SYSTEM_STATE = 9;
    public static final int BODYWORK_AUTO_SYSTEM_STATE_NORMAL = 0;
    public static final int BODYWORK_AUTO_SYSTEM_STATE_SET_SECURE = 1;
    public static final int BODYWORK_AUTO_SYSTEM_STATE_START_SECURE = 2;
    public static final int BODYWORK_AUTO_SYSTEM_STATE_UNDEFINED = 255;
    public static final int BODYWORK_AUTO_TYPE = 13;
    public static final int BODYWORK_AUTO_VIN = 15;
    public static final int BODYWORK_BATTERY_CAPACITY = 40;
    public static final int BODYWORK_BATTERY_MODE_DAY = 0;
    public static final int BODYWORK_BATTERY_MODE_INVALID = 255;
    public static final int BODYWORK_BATTERY_MODE_NIGHT = 1;
    public static final int BODYWORK_BATTERY_VOLTAGE_LEVEL = 16;
    public static final int BODYWORK_BATTERY_VOLTAGE_LEVEL_INVALID = 255;
    public static final int BODYWORK_BATTERY_VOLTAGE_LEVEL_LOW = 0;
    public static final int BODYWORK_BATTERY_VOLTAGE_LEVEL_NORMAL = 1;
    public static final int BODYWORK_CLOSE_WINDOW_FOR_RAIN = 38;
    public static final int BODYWORK_CLOSE_WINDOW_FOR_RAIN_ONLINE = 39;
    public static final int BODYWORK_CMD_DOOR_FUEL_TANK_CAP = 7;
    public static final int BODYWORK_CMD_DOOR_HOOD = 5;
    public static final int BODYWORK_CMD_DOOR_LEFT_FRONT = 1;
    public static final int BODYWORK_CMD_DOOR_LEFT_REAR = 3;
    public static final int BODYWORK_CMD_DOOR_LUGGAGE_DOOR = 6;
    public static final int BODYWORK_CMD_DOOR_RIGHT_FRONT = 2;
    public static final int BODYWORK_CMD_DOOR_RIGHT_REAR = 4;
    public static final int BODYWORK_CMD_MOON_ROOF = 5;
    public static final int BODYWORK_CMD_STEERING_WHEEL_ANGEL = 1;
    public static final int BODYWORK_CMD_STEERING_WHEEL_SPEED = 2;
    public static final int BODYWORK_CMD_SUNSHADE_PANEL = 6;
    public static final int BODYWORK_CMD_WINDOW_LEFT_FRONT = 1;
    public static final int BODYWORK_CMD_WINDOW_LEFT_REAR = 3;
    public static final int BODYWORK_CMD_WINDOW_RIGHT_FRONT = 2;
    public static final int BODYWORK_CMD_WINDOW_RIGHT_REAR = 4;
    public static final int BODYWORK_COMMAND_BUSY = -2147482647;
    public static final int BODYWORK_COMMAND_FAILED = -2147482648;
    public static final int BODYWORK_COMMAND_INVALID_VALUE = -2147482645;
    public static final int BODYWORK_COMMAND_SUCCESS = 0;
    public static final int BODYWORK_COMMAND_TIMEOUT = -2147482646;
    public static final int BODYWORK_FRONT_WINDOW_ANTI_PINCH = 3;
    public static final int BODYWORK_FUEL_ELEC_LOW_POWER = 24;
    public static final int BODYWORK_FUEL_OIL_VER_0X342_ONLINE = 58;
    public static final int BODYWORK_FUEL_TANK_CAP = 8;
    public static final int BODYWORK_HOOD = 6;
    public static final int BODYWORK_LEFT_FRONT_WINDOW = 26;
    public static final int BODYWORK_LEFT_HAND_FRONT_DOOR = 2;
    public static final int BODYWORK_LEFT_HAND_REAR_DOOR = 4;
    public static final int BODYWORK_LEFT_REAR_WINDOW = 28;
    public static final int BODYWORK_LEFT_WINDOW_ANTI_PINCH_CONFIG = 2;
    public static final int BODYWORK_LOW_POWER_BOTH = 3;
    public static final int BODYWORK_LOW_POWER_ELEC = 2;
    public static final int BODYWORK_LOW_POWER_FUEL = 1;
    public static final int BODYWORK_LOW_POWER_NORMAL = 0;
    public static final int BODYWORK_LUGGAGE_DOOR = 7;
    public static final int BODYWORK_MESSAGE_CAN_10D = 48;
    public static final int BODYWORK_MOON_ROOF = 20;
    public static final int BODYWORK_MOON_ROOF_CONFIG = 32;
    public static final int BODYWORK_MOON_ROOF_CTL = 20;
    public static final int BODYWORK_MOON_ROOF_ONLINE = 19;
    public static final int BODYWORK_MOON_ROOF_OPEN_PERCENT = 30;
    public static final int BODYWORK_NO_ANTI_PINCH = 1;
    public static final int BODYWORK_POWER_DAY_MODE = 17;
    public static final int BODYWORK_POWER_LEVEL = 14;
    public static final int BODYWORK_POWER_LEVEL_ACC = 1;
    public static final int BODYWORK_POWER_LEVEL_FAKE_OK = 4;
    public static final int BODYWORK_POWER_LEVEL_INVALID = 255;
    public static final int BODYWORK_POWER_LEVEL_OFF = 0;
    public static final int BODYWORK_POWER_LEVEL_OK = 3;
    public static final int BODYWORK_POWER_LEVEL_ON = 2;
    public static final int BODYWORK_RIGHT_FRONT_WINDOW = 27;
    public static final int BODYWORK_RIGHT_HAND_FRONT_DOOR = 3;
    public static final int BODYWORK_RIGHT_HAND_REAR_DOOR = 5;
    public static final int BODYWORK_RIGHT_REAR_WINDOW = 29;
    public static final int BODYWORK_SMART_VOICE_LIMIT = 59;
    public static final int BODYWORK_STATE_CLOSED = 0;
    public static final int BODYWORK_STATE_OPEN = 1;
    public static final int BODYWORK_STATE_UNDEFINED = 255;
    public static final int BODYWORK_STEERING_WHEEL_ANGEL = 10;
    public static final double BODYWORK_STEERING_WHEEL_ANGEL_MAX = 780.0d;
    public static final double BODYWORK_STEERING_WHEEL_ANGEL_MIN = -780.0d;
    public static final int BODYWORK_STEERING_WHEEL_SPEED = 11;
    public static final double BODYWORK_STEERING_WHEEL_SPEED_MAX = 1016.0d;
    public static final double BODYWORK_STEERING_WHEEL_SPEED_MIN = 0.0d;
    public static final int BODYWORK_STWHEEL_SENSOR_CALIBRATION_STATE = 50;
    public static final int BODYWORK_STWHEEL_SENSOR_STATE = 49;
    public static final int BODYWORK_SUNSHADE_PANEL = 21;
    public static final int BODYWORK_SUNSHADE_PANEL_CTL = 21;
    public static final int BODYWORK_SUNSHADE_PANEL_PERCENT = 31;
    public static final int BODYWORK_VIN_QUERY = 18;
    public static final int BODYWORK_WINDOW_ANTIPINCH_CONFIG = 37;
    public static final int BODYWORK_WINDOW_LEFT_FRONT_PERCENT = 33;
    public static final int BODYWORK_WINDOW_LEFT_REAR_PERCENT = 35;
    public static final int BODYWORK_WINDOW_RIGHT_FRONT_PERCENT = 34;
    public static final int BODYWORK_WINDOW_RIGHT_REAR_PERCENT = 36;
    public static final int BODY_LF_WINDOW_CTRL = 43;
    public static final int BODY_LR_WINDOW_CTRL = 45;
    public static final int BODY_RF_WINDOW_CTRL = 44;
    public static final int BODY_RR_WINDOW_CTRL = 46;
    public static final int CLOSE_WINDOW_FOR_RAIN_INVALID = 0;
    public static final int CLOSE_WINDOW_FOR_RAIN_OFF = 2;
    public static final int CLOSE_WINDOW_FOR_RAIN_ON = 1;
    public static final int CMD_55_ONLINE = 42;
    public static final int CONFIG_ANTI_PINCH_MOON_ROOF = 3;
    public static final int CONFIG_MOON_ROOF_SUNSHADE_PANEL = 1;
    public static final int CONFIG_NONE = 0;
    public static final int CONFIG_SUNSHADE_PANEL = 2;
    public static final int DATA_FLAG_INVALID = 0;
    public static final int DATA_FLAG_VALID = 1;
    public static final int DATA_STWHEEL_SENSOR_CALIBRATION_STATE = 1;
    public static final int DATA_STWHEEL_SENSOR_STATE = 0;
    public static final int DEVICE_HAS_THE_FEATURE = 1;
    public static final int DEVICE_NOT_HAS_THE_FEATURE = 0;
    public static final String FEATURE_FUEL_OIL_VER_0X342_ONLINE = "FuelOilVersion0x342Online";
    public static final String FEATURE_RAIN_CLOSE_WINDOW = "RainAutoCloseWindow";
    public static final int MESSAGE_10D = 2;
    public static final int MESSAGE_55 = 1;
    public static final int MESSAGE_OFFLINE = 0;
    public static final int MESSAGE_ONLINE = 1;
    public static final int MOONROOF_BREATH = 253;
    public static final int MOONROOF_CLOSED = 0;
    public static final int MOONROOF_COMFORTABLE = 252;
    public static final int MOONROOF_INVALID = 255;
    public static final int MOONROOF_MIN = 21;
    public static final int MOONROOF_OPEN = 100;
    public static final int MOONROOF_STOP = 254;
    public static final int SMART_VOICE_LIMIT_INVALID = 0;
    public static final int SMART_VOICE_LIMIT_VALID = 1;
    public static final int STATE_INITIALIZED = 1;
    public static final int STATE_INVALID = 0;
    public static final int STATE_UNINITIALIZED = 2;
    public static final int SUNROOF_CLOSE = 4;
    public static final int SUNROOF_CLOSE_NOTICE_CLOSE = 1;
    public static final int SUNROOF_CLOSE_NOTICE_INVALID = 0;
    public static final int SUNROOF_INVALID = 0;
    public static final int SUNROOF_OPEN = 3;
    public static final int SUNROOF_POSITION_COMFORTABLE = 6;
    public static final int SUNROOF_POSITION_FULL_CLOSE = 2;
    public static final int SUNROOF_POSITION_FULL_OPEN = 1;
    public static final int SUNROOF_POSITION_HALF_OPEN = 3;
    public static final int SUNROOF_POSITION_INVALID = 0;
    public static final int SUNROOF_POSITION_STOP = 4;
    public static final int SUNROOF_POSITION_UPDIP = 5;
    public static final int SUNROOF_STOP = 1;
    public static final int SUNROOF_TILTUP = 2;
    public static final int SUNSHADE_INVALID = 255;
    public static final int SUNSHADE_STOP = 254;
    protected static final String TAG = "BYDAutoBodyworkDevice";
    public static final int VOICE_CMD_CLOSE = 2;
    public static final int VOICE_CMD_HALF_OPEN = 3;
    public static final int VOICE_CMD_OPEN = 1;
    public static final int VOICE_CMD_STOP = 4;
    public static final int VOICE_CMD_VENTILATE = 5;
    public static final int WINDOW_BREATH = 5;
    public static final int WINDOW_CLOSE = 2;
    public static final int WINDOW_DISABLE = 1;
    public static final int WINDOW_ENABLE = 0;
    public static final int WINDOW_INVALID = 0;
    public static final int WINDOW_OPEN_FULL = 1;
    public static final int WINDOW_OPEN_HALF = 4;
    public static final int WINDOW_OPEN_PERCENT_MAX = 100;
    public static final int WINDOW_OPEN_PERCENT_MIN = 0;
    public static final int WINDOW_STOP = 3;

    BYDAutoBodyworkDevice() {
        super(null);
        throw new RuntimeException("Stub!");
    }

    public static synchronized BYDAutoBodyworkDevice getInstance(Context context) {
        synchronized (BYDAutoBodyworkDevice.class) {
            throw new RuntimeException("Stub!");
        }
    }

    public int getAlarmState() {
        throw new RuntimeException("Stub!");
    }

    public void getAllStatus() {
        throw new RuntimeException("Stub!");
    }

    public int getAutoModelName() {
        throw new RuntimeException("Stub!");
    }

    public int getAutoSystemState() {
        throw new RuntimeException("Stub!");
    }

    public int getAutoType() {
        throw new RuntimeException("Stub!");
    }

    public String getAutoVIN() {
        throw new RuntimeException("Stub!");
    }

    public int getBatteryCapacity() {
        throw new RuntimeException("Stub!");
    }

    public int getBatteryVoltageLevel() {
        throw new RuntimeException("Stub!");
    }

    public int getCarWindowAntiPinchConfig() {
        throw new RuntimeException("Stub!");
    }

    public int getDataFlag(int i) {
        throw new RuntimeException("Stub!");
    }

    public int getDoorState(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        throw new RuntimeException("Stub!");
    }

    public int getFuelElecLowPower() {
        throw new RuntimeException("Stub!");
    }

    public int getMessage5sOnlineState(int i) {
        throw new RuntimeException("Stub!");
    }

    public int getMoonRoofConfig() {
        throw new RuntimeException("Stub!");
    }

    public int getPowerDayMode() {
        throw new RuntimeException("Stub!");
    }

    public int getPowerLevel() {
        throw new RuntimeException("Stub!");
    }

    public int getRainCloseWindow() {
        throw new RuntimeException("Stub!");
    }

    public int getSmartVoiceLimit() {
        throw new RuntimeException("Stub!");
    }

    public double getSteeringWheelValue(int i) {
        throw new RuntimeException("Stub!");
    }

    public int getSunroofCloseNotice() {
        throw new RuntimeException("Stub!");
    }

    public int getSunroofInitState() {
        throw new RuntimeException("Stub!");
    }

    public int getSunroofPosition() {
        throw new RuntimeException("Stub!");
    }

    public int getSunroofState() {
        throw new RuntimeException("Stub!");
    }

    public int getSunroofWindowblindPosition() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        throw new RuntimeException("Stub!");
    }

    public int getWindoblindInitState() {
        throw new RuntimeException("Stub!");
    }

    public int getWindowOpenPercent(int i) {
        throw new RuntimeException("Stub!");
    }

    public int getWindowPermitState() {
        throw new RuntimeException("Stub!");
    }

    public int getWindowState(int i) {
        throw new RuntimeException("Stub!");
    }

    public int hasFeature(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        throw new RuntimeException("Stub!");
    }

    public int queryAutoVIN() {
        throw new RuntimeException("Stub!");
    }

    public void registerListener(AbsBYDAutoBodyworkListener absBYDAutoBodyworkListener) {
        throw new RuntimeException("Stub!");
    }

    public void setAllStatus() {
        throw new RuntimeException("Stub!");
    }

    public int setAllWindowState(int i, int i2, int i3, int i4) {
        throw new RuntimeException("Stub!");
    }

    public int setBodyWindowCtrlState(int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public int setMoonRoofAndSunshadeStop() {
        throw new RuntimeException("Stub!");
    }

    public int setMoonRoofState(int i) {
        throw new RuntimeException("Stub!");
    }

    public int setRainCloseWindow(int i) {
        throw new RuntimeException("Stub!");
    }

    public int setSunshadeState(int i) {
        throw new RuntimeException("Stub!");
    }

    public void unregisterListener(AbsBYDAutoBodyworkListener absBYDAutoBodyworkListener) {
        throw new RuntimeException("Stub!");
    }

    public int voiceCtlMoonRoof(int i) {
        throw new RuntimeException("Stub!");
    }

    public int voiceCtlSunshadePanel(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, double d2, Object obj) {
        throw new RuntimeException("Stub!");
    }

    public void registerListener(AbsBYDAutoBodyworkListener absBYDAutoBodyworkListener, int[] iArr) {
        throw new RuntimeException("Stub!");
    }
}
