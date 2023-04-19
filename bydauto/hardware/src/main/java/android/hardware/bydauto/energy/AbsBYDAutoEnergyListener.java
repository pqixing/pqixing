//refactor
package android.hardware.bydauto.energy;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoEnergyListener implements IBYDAutoListener {
public void onBCMStateChanged(int i) { }
public void onDCWorkModeChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onEnergyModeChanged(int i) { }
public void onEnergyStateChanged(int i) { }
public void onOperationModeChanged(int i) { }
public void onPowerGenerationStateChanged(int i) { }
public void onPowerGenerationValueChanged(int i) { }
public void onRoadSurfaceChanged(int i) { }
 }
