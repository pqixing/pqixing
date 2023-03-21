//refactor
package android.hardware.bydauto.version;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoVersionListener implements IBYDAutoListener {
public void onBatteryCtrlVersionChanged(String str) { }
public void onCarChargerVersionChanged(String str) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDspVersionChanged(String str) { }
public void onDtcVersionChanged(String str) { }
public void onEngineCtrlVersionChanged(String str) { }
public void onInstrumentVersionChanged(String str) { }
public void onMcuBootVersionChanged(String str) { }
public void onMcuVersionChanged(String str) { }
public void onMotorCtrl1VersionChanged(String str) { }
public void onMotorCtrl2VersionChanged(String str) { }
public void onMotorCtrl3VersionChanged(String str) { }
public void onTransmissionCtrlVersionChanged(String str) { }
 }
