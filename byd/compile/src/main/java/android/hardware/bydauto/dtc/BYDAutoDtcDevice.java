//refactor
package android.hardware.bydauto.dtc;
import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.util.Log;
public final class BYDAutoDtcDevice extends AbsBYDAutoDevice {
public static final int DTC_COMMAND_BUSY = -2147482647;
public static final int DTC_COMMAND_FAILED = -2147482648;
public static final int DTC_COMMAND_INVALID_VALUE = -2147482645;
public static final int DTC_COMMAND_SUCCESS = 0;
public static final int DTC_COMMAND_TIMEOUT = -2147482646;
public static final int DTC_SET_FAULT_CODE = 1;
public static synchronized BYDAutoDtcDevice getInstance(Context context) { return null; }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public int sendFaultCodeData(byte[] bArr) { return 0; }
 }
