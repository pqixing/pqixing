//refactor
package android.hardware.bydauto.motor;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoMotorListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onMotorAngleChanged(int i) { }
public void onMotorDirectionChanged(int i) { }
public void onMotorLockChanged(int i) { }
public void onMotorPositionChanged(int i) { }
public void onMotorPowerChanged(int i) { }
public void onMotorSpeedChanged(int i) { }
 }
