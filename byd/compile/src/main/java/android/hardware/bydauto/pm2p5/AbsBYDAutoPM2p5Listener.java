//refactor
package android.hardware.bydauto.pm2p5;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoPM2p5Listener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onPM2p5CheckStateChanged(int i, int i2) { }
public void onPM2p5LevelChanged(int i, int i2) { }
public void onPM2p5OnlineStateChanged(int i) { }
public void onPM2p5ValueChanged(int i, int i2) { }
public void onPM2p5WarningInfoChanged(int i) { }
public void onPromptInfoChanged(int i) { }
 }
