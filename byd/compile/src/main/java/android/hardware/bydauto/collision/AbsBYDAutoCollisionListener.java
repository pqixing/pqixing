//refactor
package android.hardware.bydauto.collision;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;
public abstract class AbsBYDAutoCollisionListener implements IBYDAutoListener {
public void onCollisionSignalStateChanged(byte[] bArr) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
 }
