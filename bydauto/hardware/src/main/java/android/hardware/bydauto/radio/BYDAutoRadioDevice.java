//refactor
package android.hardware.bydauto.radio;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;
public final class BYDAutoRadioDevice extends AbsBYDAutoDevice {
public static final int AM_STEP_10KHZ = 10;
public static final int AM_STEP_9KHZ = 9;
public static final int FM_STEP_100KHZ = 100;
public static final int FM_STEP_50KHZ = 50;
public static final int RADIO_AM_INIT_ENDFREQ = 5;
public static final int RADIO_AM_INIT_STARTFREQ = 4;
public static final int RADIO_AM_INIT_STEP = 6;
public static final int RADIO_BAND_AM = 2;
public static final int RADIO_BAND_FM = 1;
public static final int RADIO_COMMAND_BUSY = -2147482647;
public static final int RADIO_COMMAND_FAILED = -2147482648;
public static final int RADIO_COMMAND_INVALID_VALUE = -2147482645;
public static final int RADIO_COMMAND_SUCCESS = 0;
public static final int RADIO_COMMAND_TIMEOUT = -2147482646;
public static final int RADIO_CURRENT_FREQ = 8;
public static final int RADIO_CURRENT_STATUS = 7;
public static final int RADIO_FM_INIT_ENDFREQ = 2;
public static final int RADIO_FM_INIT_STARTFREQ = 1;
public static final int RADIO_FM_INIT_STEP = 3;
public static final int RADIO_NEXT_STATUS = 12;
public static final int RADIO_PLAY_BAND = 14;
public static final int RADIO_PLAY_FREQ = 15;
public static final int RADIO_POWER = 20;
public static final int RADIO_PREV_STATUS = 13;
public static final int RADIO_SEARCH_BAND = 9;
public static final int RADIO_SEARCH_FREQ = 10;
public static final int RADIO_SEARCH_NEXT = 17;
public static final int RADIO_SEARCH_PREV = 18;
public static final int RADIO_SEARCH_RESULT = 21;
public static final int RADIO_SEARCH_START = 16;
public static final int RADIO_SEARCH_STATUS = 11;
public static final int RADIO_SEARCH_STOP = 19;
public static final int RADIO_STATE_OFF = 0;
public static final int RADIO_STATE_PLAY = 1;
public static final int RADIO_STATE_SEARCH_ALL = 3;
public static final int RADIO_STATE_SEARCH_NEXT_PREV = 2;
public static final int SEARCH_FREQUENCY_EFFECTIVE = 1;
public static final int SEARCH_FREQUENCY_INVALID = 0;
public static final int SEARCH_PROCESS_STATE_FINISH = 0;
public static final int SEARCH_PROCESS_STATE_UNFINISH = 1;
public static final int TURN_OFF_RADIO = 0;
public static final int TURN_ON_RADIO = 1;
public static synchronized BYDAutoRadioDevice getInstance(Context context) { return null; }
public int autoSearch() { return 0; }
public int cancelAutoSearch() { return 0; }
public int getCurFreq() { return 0; }
public int[] getFeatureList() { return null; }
public int getRadioBand() { return 0; }
public int[] getRadioParam(int i) { return null; }
public int getRadioState() { return 0; }
public int getSearchProcessState() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public int radioOff() { return 0; }
public int radioOn() { return 0; }
public void registerListener(AbsBYDAutoRadioListener absBYDAutoRadioListener) { }
public int seek(boolean z) { return 0; }
public int setCurFreq(int i, int i2) { return 0; }
public int setRadioParam(int i, int i2, int i3, int i4) { return 0; }
public void unregisterListener(AbsBYDAutoRadioListener absBYDAutoRadioListener) { }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public void registerListener(AbsBYDAutoRadioListener absBYDAutoRadioListener, int[] iArr) { }
 }
