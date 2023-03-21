//refactor
package android.hardware.bydauto.security;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.util.Log;
import java.util.Arrays;
public final class BYDAutoSecurityDevice extends AbsBYDAutoDevice {
public static final int SECURITY_COMMAND_BUSY = -2147482647;
public static final int SECURITY_COMMAND_FAILED = -2147482648;
public static final int SECURITY_COMMAND_SUCCESS = 0;
public static final int SECURITY_COMMAND_TIMEOUT = -2147482646;
public static final int SECURITY_STATE_S = 1;
public static final int SECURITY_STATE_SAFE = 0;
public static final int SECURITY_STATE_WARNING = 1;
public static synchronized BYDAutoSecurityDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public byte[] getSecurityState() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public void registerListener(AbsBYDAutoSecurityListener absBYDAutoSecurityListener) { }
public void setAllStatus() { }
public void unregisterListener(AbsBYDAutoSecurityListener absBYDAutoSecurityListener) { }
public void registerListener(AbsBYDAutoSecurityListener absBYDAutoSecurityListener, int[] iArr) { }
 }
