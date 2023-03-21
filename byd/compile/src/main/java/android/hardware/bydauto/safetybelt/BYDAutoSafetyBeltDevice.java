//refactor
package android.hardware.bydauto.safetybelt;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoSafetyBeltDevice extends AbsBYDAutoDevice {
public static final int MESSAGE_481 = 1;
public static final int MESSAGE_OFFLINE = 0;
public static final int MESSAGE_ONLINE = 1;
public static final int MSR_481_ONLINE = 12;
public static final int MSR_STATE = 11;
public static final int SAFETY_BELT_AREA_DEPUTY = 2;
public static final int SAFETY_BELT_AREA_MAIN = 1;
public static final int SAFETY_BELT_AREA_SECOND_ROW_SEAT_LEFT = 3;
public static final int SAFETY_BELT_AREA_SECOND_ROW_SEAT_MID = 5;
public static final int SAFETY_BELT_AREA_SECOND_ROW_SEAT_RIGHT = 4;
public static final int SAFETY_BELT_COMMAND_AREA_DEPUTY = 2;
public static final int SAFETY_BELT_COMMAND_AREA_MAIN = 1;
public static final int SAFETY_BELT_COMMAND_AREA_SECOND_ROW_SEAT_LEFT = 3;
public static final int SAFETY_BELT_COMMAND_AREA_SECOND_ROW_SEAT_MID = 5;
public static final int SAFETY_BELT_COMMAND_AREA_SECOND_ROW_SEAT_RIGHT = 4;
public static final int SAFETY_BELT_COMMAND_BUSY = -2147482647;
public static final int SAFETY_BELT_COMMAND_FAILED = -2147482648;
public static final int SAFETY_BELT_COMMAND_INVALID_VALUE = -2147482645;
public static final int SAFETY_BELT_COMMAND_SUCCESS = 0;
public static final int SAFETY_BELT_COMMAND_TIMEOUT = -2147482646;
public static final int SAFETY_BELT_MSR_SWITCH_OFF = 1;
public static final int SAFETY_BELT_MSR_SWITCH_ON = 0;
public static final int SAFETY_BELT_PASSENGER_COMMAND_DEPUTY = 6;
public static final int SAFETY_BELT_PASSENGER_COMMAND_SECOND_ROW_SEAT_LEFT = 7;
public static final int SAFETY_BELT_PASSENGER_COMMAND_SECOND_ROW_SEAT_MID = 9;
public static final int SAFETY_BELT_PASSENGER_COMMAND_SECOND_ROW_SEAT_RIGHT = 8;
public static final int SAFETY_BELT_PASSENGER_DEPUTY = 1;
public static final int SAFETY_BELT_PASSENGER_SECOND_ROW_SEAT_LEFT = 2;
public static final int SAFETY_BELT_PASSENGER_SECOND_ROW_SEAT_MID = 4;
public static final int SAFETY_BELT_PASSENGER_SECOND_ROW_SEAT_RIGHT = 3;
public static final int SAFETY_BELT_PASSENGER_STATE_INVALID = 2;
public static final int SAFETY_BELT_PASSENGER_STATE_NOBODY = 0;
public static final int SAFETY_BELT_PASSENGER_STATE_SOMEBODY = 1;
public static final int SAFETY_BELT_REMINDER = 10;
public static final int SAFETY_BELT_REMINDER_ENABLED = 1;
public static final int SAFETY_BELT_SBCD_INVALID = 0;
public static final int SAFETY_BELT_SBCD_OFF = 1;
public static final int SAFETY_BELT_SBCD_ON = 2;
public static final int SAFETY_BELT_STATE_INVALID = 2;
public static final int SAFETY_BELT_STATE_LOCK = 1;
public static final int SAFETY_BELT_STATE_UNLOCK = 0;
public static synchronized BYDAutoSafetyBeltDevice getInstance(Context context) { return null; }
public int[] getFeatureList() { return null; }
public int getMessage5sOnlineState(int i) { return 0; }
public int getPassengerStatus(int i) { return 0; }
public int getSafetyBeltMsrState() { return 0; }
public int getSafetyBeltReminder() { return 0; }
public int getSafetyBeltStatus(int i) { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoSafetyBeltListener absBYDAutoSafetyBeltListener) { }
public int setSafetyBeltSbcdState(int i) { return 0; }
public void unregisterListener(AbsBYDAutoSafetyBeltListener absBYDAutoSafetyBeltListener) { }
public void registerListener(AbsBYDAutoSafetyBeltListener absBYDAutoSafetyBeltListener, int[] iArr) { }
 }
