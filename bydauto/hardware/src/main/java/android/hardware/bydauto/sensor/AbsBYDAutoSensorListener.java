//refactor
package android.hardware.bydauto.sensor;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoSensorListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onHumiditySensorValueChanged(double d2) { }
public void onLightIntensityChanged(int i) { }
public void onSlopeValueChanged(int i) { }
public void onTemperatureSensorValueChanged(double d2) { }
 }
