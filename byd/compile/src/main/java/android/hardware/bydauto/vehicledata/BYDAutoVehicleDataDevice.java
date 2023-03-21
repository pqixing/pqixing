//refactor
package android.hardware.bydauto.vehicledata;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoVehicleDataDevice extends AbsBYDAutoDevice {
public static final int EVENT_DATA_ACQ = 2;
public static final int PERIOD_DATA_ACQ = 3;
public static final int VEHICLE_DATA_ACQ_CONFIGURE = 1;
public static final int VEHICLE_DATA_COMMAND_BUSY = -2147482647;
public static final int VEHICLE_DATA_COMMAND_FAILED = -2147482648;
public static final int VEHICLE_DATA_COMMAND_INVALID_VALUE = -2147482645;
public static final int VEHICLE_DATA_COMMAND_SUCCESS = 0;
public static final int VEHICLE_DATA_COMMAND_TIMEOUT = -2147482646;
public static synchronized BYDAutoVehicleDataDevice getInstance(Context context) { return null; }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoVehicleDataListener absBYDAutoVehicleDataListener) { }
public int sendVehicleDataAcq(byte[] bArr) { return 0; }
public void unregisterListener(AbsBYDAutoVehicleDataListener absBYDAutoVehicleDataListener) { }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public void registerListener(AbsBYDAutoVehicleDataListener absBYDAutoVehicleDataListener, int[] iArr) { }
 }
