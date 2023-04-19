//refactor
package android.hardware.bydauto.pm2p5;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoPM2p5Device extends AbsBYDAutoDevice {
public static final int PM2P5_ALL_STATUS = 11;
public static final int PM2P5_COMMAND_BUSY = -2147482647;
public static final int PM2P5_COMMAND_FAILED = -2147482648;
public static final int PM2P5_COMMAND_INVALID_VALUE = -2147482645;
public static final int PM2P5_COMMAND_SUCCESS = 0;
public static final int PM2P5_COMMAND_TIMEOUT = -2147482646;
public static final int PM2P5_LEVEL_CHANGED = 9;
public static final int PM2P5_LEVEL_EXCELLENT = 1;
public static final int PM2P5_LEVEL_GOOD = 2;
public static final int PM2P5_LEVEL_HEAVY = 5;
public static final int PM2P5_LEVEL_IN = 2;
public static final int PM2P5_LEVEL_INVALID = 0;
public static final int PM2P5_LEVEL_LOW_GRADE = 3;
public static final int PM2P5_LEVEL_MIDDLE = 4;
public static final int PM2P5_LEVEL_OUT = 5;
public static final int PM2P5_LEVEL_SERIOUS = 6;
public static final int PM2P5_ONLINE_STATE = 10;
public static final int PM2P5_ONLINE_STATE_NULL = 0;
public static final int PM2P5_ONLINE_STATE_OFF = 2;
public static final int PM2P5_ONLINE_STATE_ON = 1;
public static final int PM2P5_PROMPT_INFO = 12;
public static final int PM2P5_STATE_CHANGED = 8;
public static final int PM2P5_STATE_IN = 1;
public static final int PM2P5_STATE_OFF = 0;
public static final int PM2P5_STATE_ON = 1;
public static final int PM2P5_STATE_OUT = 4;
public static final int PM2P5_VALUE_CHANGED = 7;
public static final int PM2P5_VALUE_IN = 3;
public static final int PM2P5_VALUE_MAX = 3000;
public static final int PM2P5_VALUE_MIN = 0;
public static final int PM2P5_VALUE_OUT = 6;
public static final int PM2P5_WARNING_INFO = 13;
public static final int PROMPT_INFO_INNER_LOOP = 2;
public static final int PROMPT_INFO_NORMAL = 0;
public static final int PROMPT_INFO_START_AC = 1;
public static final int WARNING_INFO_EXCESS_IN = 1;
public static final int WARNING_INFO_EXCESS_OUT = 2;
public static final int WARNING_INFO_NORMAL = 0;
public static synchronized BYDAutoPM2p5Device getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int[] getPM2p5CheckState() { return null; }
public int[] getPM2p5Level() { return null; }
public int getPM2p5OnlineState() { return 0; }
public int[] getPM2p5Value() { return null; }
public int getPM2p5WarningInfo() { return 0; }
public int getPromptInfo() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoPM2p5Listener absBYDAutoPM2p5Listener) { }
public void setAllStatus() { }
public int syncPM2p5AllStatus() { return 0; }
public void unregisterListener(AbsBYDAutoPM2p5Listener absBYDAutoPM2p5Listener) { }
public void registerListener(AbsBYDAutoPM2p5Listener absBYDAutoPM2p5Listener, int[] iArr) { }
 }
