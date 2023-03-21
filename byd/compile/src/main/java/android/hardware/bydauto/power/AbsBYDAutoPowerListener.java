//refactor
package android.hardware.bydauto.power;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoPowerListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onMcuStatusChanged(int i) { }
public void onPowerCtlStatusChanged(int i, int i2) { }
public void onShutdownInfoChanged(int i, int i2) { }
public void onTftBacklightChanged(int i) { }
public void onTpDisplayControllerChanged(int i, int i2) { }
 }
