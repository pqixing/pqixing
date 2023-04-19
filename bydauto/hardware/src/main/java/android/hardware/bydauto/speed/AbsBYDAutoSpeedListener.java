//refactor
package android.hardware.bydauto.speed;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoSpeedListener implements IBYDAutoListener {
public void onAccelerateDeepnessChanged(int i) { }
public void onAccelerateValueChanged(double d2) { }
public void onBrakeDeepnessChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onSpeedChanged(double d2) { }
public void onSpeedFromGatewayChanged(double d2) { }
 }
