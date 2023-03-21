//refactor
package android.hardware.bydauto.phone;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
public final class BYDAutoPhoneDevice extends AbsBYDAutoDevice {
public static final int PHONE_COMMAND_BUSY = -2147482647;
public static final int PHONE_COMMAND_FAILED = -2147482648;
public static final int PHONE_COMMAND_INVALID = -2147482645;
public static final int PHONE_COMMAND_SUCCESS = 0;
public static final int PHONE_COMMAND_TIMEOUT = -2147482646;
public static final int PHONE_EVENT = 2;
public static final int PHONE_EVENT_ANSWER = 1;
public static final int PHONE_EVENT_HANGUP = 3;
public static final int PHONE_EVENT_REJECT = 2;
public static final int PHONE_INFO_CALLING = 2;
public static final int PHONE_INFO_DAIL = 1;
public static final int PHONE_INFO_HANGUP = 4;
public static final int PHONE_INFO_ONLINE = 3;
public static final int PHONE_INFO_ST = 3;
public static final int PHONE_MUTE = 1;
public static final int PHONE_MUTE_OFF = 1;
public static final int PHONE_MUTE_ON = 0;
public static final int PHONE_NAME = 5;
public static final int PHONE_NAME_LEN_MAX = 160;
public static final int PHONE_NAME_LEN_MIN = 1;
public static final int PHONE_NUMBER = 4;
public static final int PHONE_NUMBER_LEN_MAX = 20;
public static final int PHONE_NUMBER_LEN_MIN = 1;
public static synchronized BYDAutoPhoneDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getPhoneEvent() { return 0; }
public int getPhoneMute() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoPhoneListener absBYDAutoPhoneListener) { }
public void setAllStatus() { }
public int setPhoneInfoState(int i) { return 0; }
public int setPhoneMute(int i) { return 0; }
public int[] setPhoneNameNumber(String str, String str2) { return null; }
public void unregisterListener(AbsBYDAutoPhoneListener absBYDAutoPhoneListener) { }
public void registerListener(AbsBYDAutoPhoneListener absBYDAutoPhoneListener, int[] iArr) { }
 }
