//refactor
package android.hardware.bydauto.radar;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoRadarListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onRadarObstacleDistanceChanged(int i, int i2) { }
public void onRadarProbeStateChanged(int i, int i2) { }
public void onReverseRadarSwitchStateChanged(int i) { }
 }
