//refactor
package android.hardware.bydauto.time;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoTimeListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onTimeChanged(int[] iArr) { }
public void onTimeFormatChanged(int i) { }
 }
