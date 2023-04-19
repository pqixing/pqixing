//refactor
package android.hardware.bydauto.safetybelt;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoSafetyBeltListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onMessage5sOnlineStateChanged(int i, int i2) { }
public void onPassengerStatusChanged(int i, int i2) { }
public void onSafetyBeltMsrStateChanged(int i) { }
public void onSafetyBeltReminderReceived(int i) { }
public void onSafetyBeltStatusChanged(int i, int i2) { }
 }
