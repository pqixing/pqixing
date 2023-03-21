//refactor
package android.hardware.bydauto.speed;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;
public final class BYDAutoSpeedDevice extends AbsBYDAutoDevice {
public static final double ACCELERATE_MAX = 31.0d;
public static final double ACCELERATE_MIN = -30.0d;
public static final int ACCELERATE_VALUE = 4;
public static final int ACCELERATOR_BREAK_DEPTH_CHANGED = 5;
public static final int ACCELERATOR_S = 2;
public static final int AUTO_SPEED = 1;
public static final int BRAKE_S = 3;
public static final int DEEP_PERSENT_MAX = 100;
public static final int DEEP_PERSENT_MIN = 0;
public static final int SPEED_COMMAND_BUSY = -2147482647;
public static final int SPEED_COMMAND_FAILED = -2147482648;
public static final int SPEED_COMMAND_INVALID = -2147482645;
public static final int SPEED_COMMAND_SUCCESS = 0;
public static final int SPEED_COMMAND_TIMEOUT = -2147482646;
public static final int SPEED_FROM_GATEWAY = 6;
public static final double SPEED_MAX = 282.0d;
public static final double SPEED_MIN = 0.0d;
public static synchronized BYDAutoSpeedDevice getInstance(Context context) { return null; }
public int getAccelerateDeepness() { return 0; }
public double getAccelerateValue() { return 0; }
public void getAllStatus() { }
public int getBrakeDeepness() { return 0; }
public double getCurrentSpeed() { return 0; }
public int[] getFeatureList() { return null; }
public double getSpeedFromGateway() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public void registerListener(AbsBYDAutoSpeedListener absBYDAutoSpeedListener) { }
public void unregisterListener(AbsBYDAutoSpeedListener absBYDAutoSpeedListener) { }
public void registerListener(AbsBYDAutoSpeedListener absBYDAutoSpeedListener, int[] iArr) { }
public boolean postEvent(int i, int i2, double d2, Object obj) { return false; }
 }
