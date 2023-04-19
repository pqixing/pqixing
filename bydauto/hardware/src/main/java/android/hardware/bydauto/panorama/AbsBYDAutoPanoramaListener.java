//refactor
package android.hardware.bydauto.panorama;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoPanoramaListener implements IBYDAutoListener {
public void onACUStateChanged(int i) { }
public void onBackLineConfigChanged(int i) { }
public void onCarInfoChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDisplayModeChanged(int i) { }
public void onEmergencyButtonStateChanged(int i) { }
public void onFeatureChanged(String str, int i) { }
public void onLVDSStateChanged(int i) { }
public void onPanOutputSignalChanged(int i) { }
public void onPanOutputStateChanged(int i) { }
public void onPanoRotationChanged(int i) { }
public void onPanoWorkStateChanged(int i) { }
public void onPanoramaOnlineStateChanged(int i) { }
public void onPanoramaTransparenceChanged(int i) { }
public void onRFCameraSwitchStateChanged(int i) { }
public void onRightCameraSwitchStateChanged(int i) { }
 }
