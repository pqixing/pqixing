//refactor
package android.hardware.bydauto.special;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;
public final class BYDAutoSpecialDevice extends AbsBYDAutoDevice {
public static final int CMD_WHEEL_DIECTION = 2;
public static final int CMD_WHEEL_SPEED = 1;
public static final int SPECIAL_COMMAND_BUSY = -2147482647;
public static final int SPECIAL_COMMAND_FAILED = -2147482648;
public static final int SPECIAL_COMMAND_INVALID_VALUE = -2147482645;
public static final int SPECIAL_COMMAND_SUCCESS = 0;
public static final int SPECIAL_COMMAND_TIMEOUT = -2147482646;
public static synchronized BYDAutoSpecialDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public byte[] getWheelDirection() { return null; }
public byte[] getWheelSpeed() { return null; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoSpecialListener absBYDAutoSpecialListener) { }
public void unregisterListener(AbsBYDAutoSpecialListener absBYDAutoSpecialListener) { }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public void registerListener(AbsBYDAutoSpecialListener absBYDAutoSpecialListener, int[] iArr) { }
 }
