//refactor
package android.hardware.bydauto.time;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoTimeDevice extends AbsBYDAutoDevice {
public static final int TIME_CHANGE = 11;
public static final int TIME_COMMAND_BUSY = -2147482647;
public static final int TIME_COMMAND_FAILED = -2147482648;
public static final int TIME_COMMAND_INVALID_VALUE = -2147482645;
public static final int TIME_COMMAND_SUCCESS = 0;
public static final int TIME_COMMAND_TIMEOUT = -2147482646;
public static final int TIME_DATE_FORMAT = 13;
public static final int TIME_DATE_FORMAT1 = 1;
public static final int TIME_DATE_FORMAT2 = 2;
public static final int TIME_DATE_FORMAT3 = 3;
public static final int TIME_DAY = 4;
public static final int TIME_DAY_MAX = 31;
public static final int TIME_DAY_MIN = 1;
public static final int TIME_FORMAT_24H = 9;
public static final int TIME_FORMAT_24H_OFF = 0;
public static final int TIME_FORMAT_24H_ON = 1;
public static final int TIME_HOUR = 5;
public static final int TIME_HOUR_MAX = 23;
public static final int TIME_HOUR_MIN = 0;
public static final int TIME_MINUTE = 6;
public static final int TIME_MINUTE_MAX = 59;
public static final int TIME_MINUTE_MIN = 0;
public static final int TIME_MONTH = 3;
public static final int TIME_MONTH_MAX = 12;
public static final int TIME_MONTH_MIN = 1;
public static final int TIME_SECOND = 7;
public static final int TIME_SECOND_MAX = 59;
public static final int TIME_SECOND_MIN = 0;
public static final int TIME_SET_AUTO = 1;
public static final int TIME_SET_MANUAL = 2;
public static final int TIME_SET_MODE = 1;
public static final int TIME_SUMMERTIME_OFF = 0;
public static final int TIME_SUMMERTIME_ON = 1;
public static final int TIME_SUMMERTIME_STATE = 14;
public static final int TIME_WEEKDAY = 8;
public static final int TIME_WEEKDAY_MAX = 7;
public static final int TIME_WEEKDAY_MIN = 1;
public static final int TIME_YEAR = 2;
public static final int TIME_YEAR_MAX = 2255;
public static final int TIME_YEAR_MIN = 2001;
public static final int TIME_ZONE = 10;
public static final int TIME_ZONE_MAX = 23;
public static final int TIME_ZONE_MIN = 0;
public static synchronized BYDAutoTimeDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int getDateFormat() { return 0; }
public int[] getFeatureList() { return null; }
public int getSummertimeState() { return 0; }
public int[] getTime() { return null; }
public int getTimeFormat() { return 0; }
public int getTimeZone() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoTimeListener absBYDAutoTimeListener) { }
public void setAllStatus() { }
public int setDate(int i, int i2, int i3, int i4) { return 0; }
public int setFullTime(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) { return 0; }
public int setTime(int i, int i2, int i3) { return 0; }
public int setTimeFormat(int i) { return 0; }
public int setTimeZone(int i) { return 0; }
public void unregisterListener(AbsBYDAutoTimeListener absBYDAutoTimeListener) { }
public void registerListener(AbsBYDAutoTimeListener absBYDAutoTimeListener, int[] iArr) { }
 }
