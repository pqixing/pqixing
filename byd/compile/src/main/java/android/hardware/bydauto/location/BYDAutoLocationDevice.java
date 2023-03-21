//refactor
package android.hardware.bydauto.location;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoLocationDevice extends AbsBYDAutoDevice {
public static final int LOCATION_ALTITUDE = 8;
public static final double LOCATION_ALTITUDE_INVALID = 8001.0d;
public static final double LOCATION_ALTITUDE_MAX = 8000.0d;
public static final double LOCATION_ALTITUDE_MIN = -8000.0d;
public static final int LOCATION_CHANGE = 5;
public static final int LOCATION_COMMAND_BUSY = -2147482647;
public static final int LOCATION_COMMAND_FAILED = -2147482648;
public static final int LOCATION_COMMAND_INVALID_VALUE = -2147482645;
public static final int LOCATION_COMMAND_SUCCESS = 0;
public static final int LOCATION_COMMAND_TIMEOUT = -2147482646;
public static final int LOCATION_FIXPOSITION = 6;
public static final int LOCATION_FIXPOSITION_FAIL = 0;
public static final int LOCATION_FIXPOSITION_SUCCESS = 1;
public static final int LOCATION_GPS_SPEED_MAX = 240;
public static final int LOCATION_GPS_SPEED_MIN = 0;
public static final int LOCATION_GPS_SPPED = 9;
public static final double LOCATION_LATITUDE_MAX = 90.0d;
public static final double LOCATION_LATITUDE_MIN = 0.0d;
public static final int LOCATION_LATITUDE_TYPE = 1;
public static final int LOCATION_LATITUDE_TYPE_NORTH = 2;
public static final int LOCATION_LATITUDE_TYPE_SOUTH = 1;
public static final int LOCATION_LATITUDE_VALUE = 2;
public static final double LOCATION_LONGITUDE_MAX = 180.0d;
public static final double LOCATION_LONGITUDE_MIN = 0.0d;
public static final int LOCATION_LONGITUDE_TYPE = 3;
public static final int LOCATION_LONGITUDE_TYPE_EAST = 1;
public static final int LOCATION_LONGITUDE_TYPE_WEST = 2;
public static final int LOCATION_LONGITUDE_VALUE = 4;
public static final int LOCATION_ORIENTATION = 7;
public static final float LOCATION_ORIENTATION_INVALID = 360.0f;
public static final float LOCATION_ORIENTATION_MAX = 359.0f;
public static final float LOCATION_ORIENTATION_MIN = 0.0f;
public static final int VISIBLE_SATELLITE_NUMBER = 10;
public static final int VISIBLE_SATELLITE_NUMBER_MAX = 50;
public static final int VISIBLE_SATELLITE_NUMBER_MIN = 0;
public static synchronized BYDAutoLocationDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public double[] getLocationLongitudeLatitudeValue() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoLocationListener absBYDAutoLocationListener) { }
public int setLocationInfo(int i, double d2, int i2, double d3, int i3, float f2, double d4, int i4, int i5) { return 0; }
public void unregisterListener(AbsBYDAutoLocationListener absBYDAutoLocationListener) { }
public boolean postEvent(int i, int i2, double d2, Object obj) { return false; }
public void registerListener(AbsBYDAutoLocationListener absBYDAutoLocationListener, int[] iArr) { }
 }
