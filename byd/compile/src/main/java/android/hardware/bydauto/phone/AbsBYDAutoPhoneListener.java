//refactor
package android.hardware.bydauto.phone;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoPhoneListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onPhoneEventChanged(int i) { }
public void onPhoneMuteChanged(int i) { }
 }
