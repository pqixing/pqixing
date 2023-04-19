//refactor
package android.hardware.bydauto.collision;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.util.Log;
import java.util.Arrays;
public final class BYDAutoCollisionDevice extends AbsBYDAutoDevice {
public static final int COLLISION_COMMAND_BUSY = -2147482647;
public static final int COLLISION_COMMAND_FAILED = -2147482648;
public static final int COLLISION_COMMAND_INVALID_VALUE = -2147482645;
public static final int COLLISION_COMMAND_SUCCESS = 0;
public static final int COLLISION_COMMAND_TIMEOUT = -2147482646;
public static final int COLLISION_SIGNAL = 2;
public static final int COLLISION_STATE_S = 1;
public static final int NORMAL_SIGNAL = 1;
public static synchronized BYDAutoCollisionDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public byte[] getCollisionInfo() { return null; }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public void registerListener(AbsBYDAutoCollisionListener absBYDAutoCollisionListener) { }
public void unregisterListener(AbsBYDAutoCollisionListener absBYDAutoCollisionListener) { }
public void registerListener(AbsBYDAutoCollisionListener absBYDAutoCollisionListener, int[] iArr) { }
 }
