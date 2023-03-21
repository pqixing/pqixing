//refactor
package android.hardware.bydauto.light;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoLightDevice extends AbsBYDAutoDevice {
public static final int AFS_SWITCH = 2;
public static final int CMD_DAY_RUNNING_LIGHT_STATE = 15;
public static final int CMD_DOUBLE_FLASH_STATE = 17;
public static final int CMD_REVERSING_LIGHT_STATE = 18;
public static final int CMD_SEQUENTIAL_STATE = 16;
public static final int CMD_STOP_LIGHT_STATE = 14;
public static final int DAY_RUNNING_LIGHT_INVALID = 0;
public static final int DAY_RUNNING_LIGHT_OFF = 2;
public static final int DAY_RUNNING_LIGHT_ON = 1;
public static final int DOUBLE_FLASH_INVALID = 0;
public static final int DOUBLE_FLASH_OFF = 2;
public static final int DOUBLE_FLASH_ON = 1;
public static final int FOOT_LIGHT = 11;
public static final int FRONT_FOG_LIGHT = 9;
public static final int GROUP_LEFT_LIGHT = 12;
public static final int GROUP_RIGHT_LIGHT = 13;
public static final int HIGH_BEAM_LIGHT = 6;
public static final int ILLUMINATION_LEVEL = 1;
public static final int LEFT_TURN_SIGNAL_LIGHT = 7;
public static final int LIGHT_AUTO_SWITCH = 3;
public static final int LIGHT_COMMAND_BUSY = -2147482647;
public static final int LIGHT_COMMAND_FAILED = -2147482648;
public static final int LIGHT_COMMAND_INVALID = -2147482645;
public static final int LIGHT_COMMAND_SUCCESS = 0;
public static final int LIGHT_COMMAND_TIMEOUT = -2147482646;
public static final int LIGHT_FOOT = 8;
public static final int LIGHT_FRONT_FOG = 6;
public static final int LIGHT_GROUP_LEFT = 0;
public static final int LIGHT_GROUP_RIGHT = 1;
public static final int LIGHT_HIGH_BEAM = 3;
public static final int LIGHT_ILLUM_LEVEL1 = 1;
public static final int LIGHT_ILLUM_LEVEL2 = 2;
public static final int LIGHT_ILLUM_LEVEL3 = 3;
public static final int LIGHT_ILLUM_LEVEL4 = 4;
public static final int LIGHT_ILLUM_LEVEL5 = 5;
public static final int LIGHT_LEFT_TURN_SIGNAL = 4;
public static final int LIGHT_LOW_BEAM = 2;
public static final int LIGHT_OFF = 0;
public static final int LIGHT_ON = 1;
public static final int LIGHT_REAR_FOG = 7;
public static final int LIGHT_RIGHT_TURN_SIGNAL = 5;
public static final int LIGHT_SIDE = 1;
public static final int LIGHT_STATE_FAULT = 1;
public static final int LIGHT_STATE_INVALID = 2;
public static final int LIGHT_STATE_NORMAL = 0;
public static final int LOW_BEAM_LIGHT = 5;
public static final int REAR_FOG_LIGHT = 10;
public static final int REVERSING_LIGHT_INVALID = 0;
public static final int REVERSING_LIGHT_OFF = 2;
public static final int REVERSING_LIGHT_ON = 1;
public static final int RIGHT_TURN_SIGNAL_LIGHT = 8;
public static final int SEQUENTIAL_LIGHT_INVALID = 3;
public static final int SEQUENTIAL_LIGHT_OFF = 1;
public static final int SEQUENTIAL_LIGHT_ON = 0;
public static final int SIDE_LIGHT = 4;
public static final int STOP_LIGHT_FLASH = 2;
public static final int STOP_LIGHT_INVALID = 0;
public static final int STOP_LIGHT_OFF = 3;
public static final int STOP_LIGHT_ON = 1;
public static synchronized BYDAutoLightDevice getInstance(Context context) { return null; }
public int getAFSSwitch() { return 0; }
public void getAllStatus() { }
public int getDayRunningLightState() { return 0; }
public int getDoubleFlashLightState() { return 0; }
public int[] getFeatureList() { return null; }
public int getGroupHeadlightState(int i) { return 0; }
public int getIlluminationIntensityLevel() { return 0; }
public int getLightAutoStatus() { return 0; }
public int getLightStatus(int i) { return 0; }
public int getReversingLightState() { return 0; }
public int getSequentialLightState() { return 0; }
public int getStopLightState() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoLightListener absBYDAutoLightListener) { }
public void unregisterListener(AbsBYDAutoLightListener absBYDAutoLightListener) { }
public void registerListener(AbsBYDAutoLightListener absBYDAutoLightListener, int[] iArr) { }
 }
