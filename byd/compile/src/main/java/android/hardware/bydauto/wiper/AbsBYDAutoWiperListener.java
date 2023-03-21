//refactor
package android.hardware.bydauto.wiper;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoWiperListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onWindscreenWiperRelayStateChanged(int i) { }
public void onWindscreenWiperResetStateChanged(int i, int i2) { }
public void onWindscreenWiperSensitivityChanged(int i) { }
 }
