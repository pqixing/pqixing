//refactor
package android.hardware.bydauto.gearbox;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoGearboxListener implements IBYDAutoListener {
public void onBrakeFluidLevelChanged(int i) { }
public void onBrakePedalStateChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onEPBStateChanged(int i) { }
public void onGearboxAutoModeTypeChanged(int i) { }
public void onGearboxManualModeLevelChanged(int i) { }
public void onGearboxStateChanged(int i) { }
public void onParkBrakeSwitchChanged(int i) { }
 }
