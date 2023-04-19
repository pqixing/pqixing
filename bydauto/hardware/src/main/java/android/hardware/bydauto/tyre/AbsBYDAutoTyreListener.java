//refactor
package android.hardware.bydauto.tyre;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoTyreListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onFeatureChanged(String str, int i) { }
public void onIndirectTyreSystemStateChanged(int i) { }
public void onTyreAirLeakStateChanged(int i, int i2) { }
public void onTyreBatteryStateChanged(int i) { }
public void onTyreBatteryValueChanged(int i, double d2) { }
public void onTyrePressureStateChanged(int i, int i2) { }
public void onTyrePressureValueChanged(int i, int i2) { }
public void onTyreSignalStateChanged(int i, int i2) { }
public void onTyreSystemStateChanged(int i) { }
public void onTyreTemperatureStateChanged(int i) { }
 }
