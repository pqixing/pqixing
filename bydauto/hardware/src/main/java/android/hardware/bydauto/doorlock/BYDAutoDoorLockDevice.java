//refactor
package android.hardware.bydauto.doorlock;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoDoorLockDevice extends AbsBYDAutoDevice {
public static final int DOOR_LOCK_AREA_BACK = 5;
public static final int DOOR_LOCK_AREA_CHILDLOCK_LEFT = 6;
public static final int DOOR_LOCK_AREA_CHILDLOCK_RIGHT = 7;
public static final int DOOR_LOCK_AREA_LEFT_FRONT = 1;
public static final int DOOR_LOCK_AREA_LEFT_REAR = 2;
public static final int DOOR_LOCK_AREA_RIGHT_FRONT = 3;
public static final int DOOR_LOCK_AREA_RIGHT_REAR = 4;
public static final int DOOR_LOCK_COMMAND_AREA_BACK = 5;
public static final int DOOR_LOCK_COMMAND_AREA_CHILDLOCK_LEFT = 6;
public static final int DOOR_LOCK_COMMAND_AREA_CHILDLOCK_RIGHT = 7;
public static final int DOOR_LOCK_COMMAND_AREA_LEFT_FRONT = 1;
public static final int DOOR_LOCK_COMMAND_AREA_LEFT_REAR = 2;
public static final int DOOR_LOCK_COMMAND_AREA_RIGHT_FRONT = 3;
public static final int DOOR_LOCK_COMMAND_AREA_RIGHT_REAR = 4;
public static final int DOOR_LOCK_COMMAND_BUSY = -2147482647;
public static final int DOOR_LOCK_COMMAND_FAILED = -2147482648;
public static final int DOOR_LOCK_COMMAND_INVALID_VALUE = -2147482645;
public static final int DOOR_LOCK_COMMAND_SUCCESS = 0;
public static final int DOOR_LOCK_COMMAND_TIMEOUT = -2147482646;
public static final int DOOR_LOCK_STATE_INVALID = 0;
public static final int DOOR_LOCK_STATE_LOCK = 2;
public static final int DOOR_LOCK_STATE_UNLOCK = 1;
public static synchronized BYDAutoDoorLockDevice getInstance(Context context) { return null; }
public int getDoorLockStatus(int i) { return 0; }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoDoorLockListener absBYDAutoDoorLockListener) { }
public void unregisterListener(AbsBYDAutoDoorLockListener absBYDAutoDoorLockListener) { }
public void registerListener(AbsBYDAutoDoorLockListener absBYDAutoDoorLockListener, int[] iArr) { }
 }
