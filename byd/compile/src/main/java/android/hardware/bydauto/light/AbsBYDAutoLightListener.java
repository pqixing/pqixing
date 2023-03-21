//refactor
package android.hardware.bydauto.light;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoLightListener implements IBYDAutoListener {
public void onAFSSwitchStateChange(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDayRunningLightStateChanged(int i) { }
public void onDoubleFlashLightStateChanged(int i) { }
public void onGroupHeadlightStateChanged(int i, int i2) { }
public void onIlluminationIntensityLevelChange(int i) { }
public void onLightAutoSwitchOff() { }
public void onLightAutoSwitchOn() { }
public void onLightOff(int i) { }
public void onLightOn(int i) { }
public void onReversingLightStateChanged(int i) { }
public void onSequentialLightStateChanged(int i) { }
public void onStopLightStateChanged(int i) { }
 }
