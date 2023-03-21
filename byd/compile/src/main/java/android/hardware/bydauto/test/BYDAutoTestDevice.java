//refactor
package android.hardware.bydauto.test;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoTestDevice extends AbsBYDAutoDevice {
public static final int AUDIO_DEBUG_MODE_ENTER = 1;
public static final int AVAH_DEBUG_1K = 1;
public static final int AVAH_DEBUG_2K = 2;
public static final int AVAH_DEBUG_3K = 3;
public static final int CMD_FEATURE_MCU_STATE = 3;
public static final int CMD_TEST_AUDIO_AVAH = 9;
public static final int CMD_TEST_AUDIO_FM = 11;
public static final int CMD_TEST_AUDIO_MODE = 8;
public static final int CMD_TEST_AUDIO_XF = 10;
public static final int DEBUG_EXIT = 0;
public static final int FM_DEBUG_1K = 1;
public static final int FM_DEBUG_2K = 2;
public static final int FM_DEBUG_3K = 3;
public static final int IFLY_DEBUG_FUNCTION = 2;
public static final int IFLY_DEBUG_RECORDING = 1;
public static final int TEST_COMMAND_BUSY = -2147482647;
public static final int TEST_COMMAND_FAILED = -2147482648;
public static final int TEST_COMMAND_INVALID_VALUE = -2147482645;
public static final int TEST_COMMAND_SUCCESS = 0;
public static final int TEST_COMMAND_TIMEOUT = -2147482646;
public static final int TEST_SET_TEC_LEVEL = 1;
public static final int TEST_SET_TEC_LEVEL_0 = 0;
public static final int TEST_SET_TEC_LEVEL_1 = 1;
public static final int TEST_SET_TEC_LEVEL_2 = 2;
public static final int TEST_SET_TEC_LEVEL_3 = 3;
public static final int TEST_SET_TEC_LEVEL_4 = 4;
public static final int TEST_SET_TEC_LEVEL_5 = 5;
public static synchronized BYDAutoTestDevice getInstance(Context context) { return null; }
public int getAVAHDebugMode() { return 0; }
public int getAudioDebugMode() { return 0; }
public int getFMDebugMode() { return 0; }
public int[] getFeatureList() { return null; }
public int getIflyDebugMode() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoTestListener absBYDAutoTestListener) { }
public int setAVAHDebugMode(int i) { return 0; }
public int setAudioDebugMode(int i) { return 0; }
public int setFMDebugMode(int i) { return 0; }
public int setIflyDebugMode(int i) { return 0; }
public int setTecLevel(int i) { return 0; }
public void unregisterListener(AbsBYDAutoTestListener absBYDAutoTestListener) { }
public void registerListener(AbsBYDAutoTestListener absBYDAutoTestListener, int[] iArr) { }
 }
