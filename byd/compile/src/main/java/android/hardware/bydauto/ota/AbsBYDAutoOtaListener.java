//refactor
package android.hardware.bydauto.ota;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;
public abstract class AbsBYDAutoOtaListener implements IBYDAutoListener {
public void onBatteryPowerVoltageChanged(double d2) { }
public void onBatteryVoltageChanged(double d2) { }
public void onCanInfoReceived(byte[] bArr) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDischargeMainContactorStateChanged(int i) { }
public void onECUSoftcodeReceived(byte[] bArr) { }
public void onECUVersionReceived(byte[] bArr) { }
public void onFaultCodeInfoReceived(byte[] bArr) { }
public void onLFDoorLockStateChanged(int i) { }
public void onOTAInfoACKChanged(byte[] bArr) { }
public void onOTAStateChanged(int i) { }
public void onOTATimecountStateChanged(int i) { }
public void onPowerOnForbidStateChanged(int i) { }
public void onPoweroffInformChanged(int i) { }
public void onSyncMcuStateChanged(int i) { }
 }
