//refactor
package android.hardware.bydauto.engine;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.util.Log;
import java.util.Arrays;
public final class BYDAutoEngineDevice extends AbsBYDAutoDevice {
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
public static synchronized BYDAutoEngineDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public String getEngineCode() { return null; }
public int getEngineCoolantLevel() { return 0; }
public double getEngineDisplacement() { return 0; }
public int getEnginePower() { return 0; }
public int getEngineSimulatorVoiceSource() { return 0; }
public int getEngineSpeed() { return 0; }
public byte[] getEngineState() { return null; }
public int getEngineVoiceSimulatorState() { return 0; }
public int[] getFeatureList() { return null; }
public int getOilLevel() { return 0; }
public int getType() { return 0; }
public int hasFeature(String str) { return 0; }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public void registerListener(AbsBYDAutoEngineListener absBYDAutoEngineListener) { }
public void setAllStatus() { }
public int setEngineSimulatorVoiceSource(int i) { return 0; }
public int setEngineVoiceSimulatorState(int i) { return 0; }
public void unregisterListener(AbsBYDAutoEngineListener absBYDAutoEngineListener) { }
public void registerListener(AbsBYDAutoEngineListener absBYDAutoEngineListener, int[] iArr) { }
 }
