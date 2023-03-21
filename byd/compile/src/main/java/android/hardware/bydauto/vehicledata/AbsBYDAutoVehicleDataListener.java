//refactor
package android.hardware.bydauto.vehicledata;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;
public abstract class AbsBYDAutoVehicleDataListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onEventDataAcqReceived(byte[] bArr) { }
public void onPeriodDataAcqReceived(byte[] bArr) { }
public void onVehicleDataAcqReceived(byte[] bArr) { }
 }
