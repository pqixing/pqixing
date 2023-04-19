//refactor
package android.hardware.bydauto.radio;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoRadioListener implements IBYDAutoListener {
public void onCurFreqChanged(int i, int i2, int i3) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onEffectiveFreqSearched(int i, int i2, int i3, int i4) { }
public void onRadioParamChanged(int i, int i2, int i3, int i4) { }
public void onRadioStateChanged(int i) { }
public void onSearchResultChanged(int i, int i2, int i3, int i4) { }
 }
