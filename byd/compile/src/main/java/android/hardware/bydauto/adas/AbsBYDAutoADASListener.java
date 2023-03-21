//refactor
package android.hardware.bydauto.adas;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoADASListener implements IBYDAutoListener {
public void onAEBStateChanged(int i) { }
public void onAVHStateChanged(int i) { }
public void onBSDStateChanged(int i) { }
public void onBrakeFootSenseStateChanged(int i) { }
public void onCSTStateChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onESPKeyStateChanged(int i) { }
public void onESPStateChanged(int i) { }
public void onFeatureChanged(String str, int i) { }
public void onHDCStateChanged(int i) { }
public void onHMAStateChanged(int i) { }
public void onIboosterStateChanged(int i) { }
public void onLDSWTypeChanged(int i) { }
public void onLKSModeChanged(int i) { }
public void onLKSSensitivityChanged(int i) { }
public void onPCWStateChanged(int i) { }
public void onSLAStateChanged(int i) { }
public void onTJAStateChanged(int i) { }
 }
