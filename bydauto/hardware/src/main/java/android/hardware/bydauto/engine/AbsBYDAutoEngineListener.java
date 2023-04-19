//refactor
package android.hardware.bydauto.engine;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoEngineListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onEngineCoolantLevelChanged(int i) { }
public void onEngineSimulatorVoiceSourceChanged(int i) { }
public void onEngineSpeedChanged(int i) { }
public void onEngineStateChanged(byte[] bArr) { }
public void onEngineVoiceSimulatorStateChanged(int i) { }
public void onFeatureChanged(String str, int i) { }
public void onOilLevelChanged(int i) { }
 }
