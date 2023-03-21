//refactor
package android.hardware.bydauto.rescue;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoRescueListener implements IBYDAutoListener {
public void onAirbagStateChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onInfoFromMCUChanged(int i) { }
 }
