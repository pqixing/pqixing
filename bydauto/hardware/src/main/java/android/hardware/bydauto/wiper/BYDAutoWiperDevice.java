//refactor
package android.hardware.bydauto.wiper;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoWiperDevice extends AbsBYDAutoDevice {
public static final int WINDSCREEN_WIPER_SENSITIVITY = 3;
public static final int WIPER_AREA_FRONT = 0;
public static final int WIPER_AREA_FRONT_STATE = 1;
public static final int WIPER_AREA_REAR = 1;
public static final int WIPER_AREA_REAR_STATE = 2;
public static final int WIPER_COMMAND_BUSY = -2147482647;
public static final int WIPER_COMMAND_FAILED = -2147482648;
public static final int WIPER_COMMAND_INVALID = -2147482645;
public static final int WIPER_COMMAND_SUCCESS = 0;
public static final int WIPER_COMMAND_TIMEOUT = -2147482646;
public static final int WIPER_RELAY_STATE = 4;
public static final int WIPER_RELAY_STATE_ACTUATION = 1;
public static final int WIPER_RELAY_STATE_DISCONNECT = 2;
public static final int WIPER_RELAY_STATE_INVALID = 0;
public static final int WIPER_SENSITIVITY_1 = 1;
public static final int WIPER_SENSITIVITY_2 = 2;
public static final int WIPER_SENSITIVITY_3 = 3;
public static final int WIPER_SENSITIVITY_4 = 4;
public static final int WIPER_SENSITIVITY_INVALID = 0;
public static final int WIPER_STATE_INVALID = 0;
public static final int WIPER_STATE_NOT_RESET = 1;
public static final int WIPER_STATE_RESET = 2;
public static synchronized BYDAutoWiperDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public int getWindscreenWiperRelayState() { return 0; }
public int getWindscreenWiperResetState(int i) { return 0; }
public int getWindscreenWiperSensitivity() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoWiperListener absBYDAutoWiperListener) { }
public void unregisterListener(AbsBYDAutoWiperListener absBYDAutoWiperListener) { }
public void registerListener(AbsBYDAutoWiperListener absBYDAutoWiperListener, int[] iArr) { }
 }
