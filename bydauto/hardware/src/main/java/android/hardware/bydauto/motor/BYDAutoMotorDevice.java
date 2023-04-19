//refactor
package android.hardware.bydauto.motor;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoMotorDevice extends AbsBYDAutoDevice {
public static final int MOTOR_ANGLE = 3;
public static final double MOTOR_ANGLE_MAX = 359.9d;
public static final double MOTOR_ANGLE_MIN = 0.0d;
public static final int MOTOR_ANGLE_VALUE = 0;
public static final int MOTOR_COMMAND_BUSY = -2147482647;
public static final int MOTOR_COMMAND_FAILED = -2147482648;
public static final int MOTOR_COMMAND_INVALID = -2147482645;
public static final int MOTOR_COMMAND_SUCCESS = 0;
public static final int MOTOR_COMMAND_TIMEOUT = -2147482646;
public static final int MOTOR_LOCK = 2;
public static final int MOTOR_OFF = 0;
public static final int MOTOR_ON = 1;
public static final int MOTOR_POS = 4;
public static final int MOTOR_POS_MAX = 500;
public static final int MOTOR_POS_MIN = -500;
public static final int MOTOR_POWER_STATE = 1;
public static final int MOTOR_SPEED = 6;
public static final int MOTOR_SPEED_VALUE = 0;
public static final int MOTOR_STATE = 5;
public static final int MOTOR_STATE_ANTICLOCKWISE = 8;
public static final int MOTOR_STATE_BACKWARD = 6;
public static final int MOTOR_STATE_CLOCKWISE = 7;
public static final int MOTOR_STATE_DOWNWARD = 2;
public static final int MOTOR_STATE_FORWARD = 5;
public static final int MOTOR_STATE_LEFT = 3;
public static final int MOTOR_STATE_RIGHT = 4;
public static final int MOTOR_STATE_STOP = 0;
public static final int MOTOR_STATE_UPWARD = 1;
public static synchronized BYDAutoMotorDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getMotorAngle() { return 0; }
public int getMotorDirection() { return 0; }
public int getMotorLock() { return 0; }
public int getMotorPosition() { return 0; }
public int getMotorPower() { return 0; }
public int getMotorSpeed() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoMotorListener absBYDAutoMotorListener) { }
public void setAllStatus() { }
public int setMotorDirection(int i) { return 0; }
public int setMotorLock(int i) { return 0; }
public int setMotorPower(int i) { return 0; }
public void unregisterListener(AbsBYDAutoMotorListener absBYDAutoMotorListener) { }
public void registerListener(AbsBYDAutoMotorListener absBYDAutoMotorListener, int[] iArr) { }
 }
