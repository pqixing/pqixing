//refactor
package android.hardware.bydauto.doorlock;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoDoorLockListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDoorLockStatusChanged(int i, int i2) { }
 }
