//refactor
package android.hardware.bydauto.doormirror;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoRearViewMirrorListener implements IBYDAutoListener {
public void onAutoExternalRearMirrorAntiglareStateChanged(int i) { }
public void onAutoExternalRearMirrorStateChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
 }
