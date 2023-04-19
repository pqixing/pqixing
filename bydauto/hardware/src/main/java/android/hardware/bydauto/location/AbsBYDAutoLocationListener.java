//refactor
package android.hardware.bydauto.location;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoLocationListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onLocationLongitudeLatitudeValueChanged(int i, double d2, int i2, double d3, int i3, float f2, double d4) { }
 }
