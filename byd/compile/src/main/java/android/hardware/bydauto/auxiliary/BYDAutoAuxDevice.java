//refactor
package android.hardware.bydauto.auxiliary;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoAuxDevice extends AbsBYDAutoDevice {
public static final int AUX_COMMAND_BUSY = -2147482647;
public static final int AUX_COMMAND_FAILED = -2147482648;
public static final int AUX_COMMAND_INVALID_VALUE = -2147482645;
public static final int AUX_COMMAND_SUCCESS = 0;
public static final int AUX_COMMAND_TIMEOUT = -2147482646;
public static final int AUX_CONNECTED = 1;
public static final int AUX_CONNECT_STATE = 1;
public static final int AUX_DISCONNECTED = 0;
public static final int AUX_NO_SIGNAL = 0;
public static final int AUX_SIGNAL = 1;
public static final int AUX_SIGNAL_STATE = 2;
public static synchronized BYDAutoAuxDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int getAuxConnectStatus() { return 0; }
public int getAuxSignalStatus() { return 0; }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoAuxListener absBYDAutoAuxListener) { }
public void setAllStatus() { }
public void unregisterListener(AbsBYDAutoAuxListener absBYDAutoAuxListener) { }
public void registerListener(AbsBYDAutoAuxListener absBYDAutoAuxListener, int[] iArr) { }
 }
