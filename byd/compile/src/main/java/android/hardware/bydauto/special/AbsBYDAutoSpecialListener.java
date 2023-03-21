//refactor
package android.hardware.bydauto.special;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;
public abstract class AbsBYDAutoSpecialListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onWheelDirectionChanged(byte[] bArr) { }
public void onWheelSpeedChanged(byte[] bArr) { }
 }
