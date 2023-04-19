//refactor
package android.hardware.bydauto.instrument;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoInstrumentListener implements IBYDAutoListener {
public void onAlarmBuzzleStateChange(int i) { }
public void onAverageSpeedChanged(int i) { }
public void onBacklightBrightnessChanged(int i) { }
public void onBacklightModeStateChanged(int i, int i2) { }
public void onCallInfoResultChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onExternalChargingPowerChanged(double d2) { }
public void onInstrumentScreenTypeChanged(int i) { }
public void onKeyDetectionReminderChanged(int i) { }
public void onMaintenanceInfoChanged(int i, int i2) { }
public void onMalfunctionInfoChanged(int i, int i2) { }
public void onMalfunctionInfoChanged2(int i, int i2) { }
public void onMusicInfoResultChanged(int i) { }
public void onPowerOffErrInfoChanged(int i) { }
public void onPowerOnErrInfoChanged(int i) { }
public void onRadioInfoResultChanged(int i) { }
public void onRemoteDrivingReminderChanged(int i) { }
public void onUnitChanged(int i, int i2) { }
 }
