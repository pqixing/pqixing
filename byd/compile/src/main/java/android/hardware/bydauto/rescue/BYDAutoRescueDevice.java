//refactor
package android.hardware.bydauto.rescue;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoRescueDevice extends AbsBYDAutoDevice {
public static final int CALL_AIRBAG_STATE = 3;
public static final int INFO_FROM_MCU = 1;
public static final int INFO_TO_MCU = 2;
public static final int RESCUE_COMMAND_BUSY = -2147482647;
public static final int RESCUE_COMMAND_FAILED = -2147482648;
public static final int RESCUE_COMMAND_INVALID_VALUE = -2147482645;
public static final int RESCUE_COMMAND_SUCCESS = 0;
public static final int RESCUE_COMMAND_TIMEOUT = -2147482646;
public static synchronized BYDAutoRescueDevice getInstance(Context context) { return null; }
public int getAirbagState() { return 0; }
public int[] getFeatureList() { return null; }
public int getInfoFromMCU() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoRescueListener absBYDAutoRescueListener) { }
public int setInfoToMCU(byte[] bArr) { return 0; }
public void unregisterListener(AbsBYDAutoRescueListener absBYDAutoRescueListener) { }
public void registerListener(AbsBYDAutoRescueListener absBYDAutoRescueListener, int[] iArr) { }
 }
