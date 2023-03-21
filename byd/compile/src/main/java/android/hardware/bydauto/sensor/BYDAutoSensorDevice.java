//refactor
package android.hardware.bydauto.sensor;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoSensorDevice extends AbsBYDAutoDevice {
public static final int AUTO_SLOPE_MAX = 60;
public static final int AUTO_SLOPE_MIN = -60;
public static final int G_SENSOR_OR_ANGLE = 4;
public static final int G_SENSOR_OR_ANGLE_MAX = 359;
public static final int G_SENSOR_OR_ANGLE_MIN = 0;
public static final double HUMIDITY_MAX = 100.0d;
public static final double HUMIDITY_MIN = 0.0d;
public static final int LIGHT_INTENSITY_LEVEL1 = 1;
public static final int LIGHT_INTENSITY_LEVEL2 = 2;
public static final int LIGHT_INTENSITY_LEVEL3 = 3;
public static final int LIGHT_INTENSITY_LEVEL4 = 4;
public static final int LIGHT_INTENSITY_LEVEL5 = 5;
public static final int SENSOR_AUTO_SLOPE = 5;
public static final int SENSOR_COMMAND_BUSY = -2147482647;
public static final int SENSOR_COMMAND_FAILED = -2147482648;
public static final int SENSOR_COMMAND_INVALID_VALUE = -2147482645;
public static final int SENSOR_COMMAND_SUCCESS = 0;
public static final int SENSOR_COMMAND_TIMEOUT = -2147482646;
public static final int SENSOR_HUMIDITY = 2;
public static final int SENSOR_LIGHT = 3;
public static final int SENSOR_TEMPERATURE = 1;
public static final double TEMPERATURE_MAX = 125.0d;
public static final double TEMPERATURE_MIN = -40.0d;
public static synchronized BYDAutoSensorDevice getInstance(Context context) { return null; }
public int[] getFeatureList() { return null; }
public double getHumiditySensorValue() { return 0; }
public int getLightIntensity() { return 0; }
public int getSlope() { return 0; }
public double getTemperatureSensorValue() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoSensorListener absBYDAutoSensorListener) { }
public int setOrientationAngle(int i) { return 0; }
public void unregisterListener(AbsBYDAutoSensorListener absBYDAutoSensorListener) { }
public boolean postEvent(int i, int i2, double d2, Object obj) { return false; }
public void registerListener(AbsBYDAutoSensorListener absBYDAutoSensorListener, int[] iArr) { }
 }
