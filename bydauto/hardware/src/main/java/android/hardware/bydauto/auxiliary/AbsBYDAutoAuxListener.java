//refactor
package android.hardware.bydauto.auxiliary;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoAuxListener implements IBYDAutoListener {
public void onAuxConnectStatusChanged(int i) { }
public void onAuxSignalStatusChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
 }
