//refactor
package android.hardware.bydauto.signal;
import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.util.Log;
public final class BYDAutoSignalDevice extends AbsBYDAutoDevice {
public static final int SIGNAL_COMMAND_BUSY = -2147482647;
public static final int SIGNAL_COMMAND_FAILED = -2147482648;
public static final int SIGNAL_COMMAND_INVALID_VALUE = -2147482645;
public static final int SIGNAL_COMMAND_SUCCESS = 0;
public static final int SIGNAL_COMMAND_TIMEOUT = -2147482646;
public static final int SIGNAL_STATUS = 1;
public static final int SIGNAL_STATUS_NORMAL = 1;
public static final int SIGNAL_STATUS_WORSE = 2;
public static synchronized BYDAutoSignalDevice getInstance(Context context) { return null; }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public void setAllStatus() { }
public int setSignalStatus(int i) { return 0; }
 }
