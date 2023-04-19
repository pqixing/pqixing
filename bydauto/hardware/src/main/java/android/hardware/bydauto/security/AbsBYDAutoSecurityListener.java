//refactor
package android.hardware.bydauto.security;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;
public abstract class AbsBYDAutoSecurityListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onSecurityStateChanged(byte[] bArr) { }
 }
