//refactor
package android.hardware.bydauto.audio;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
public abstract class AbsBYDAutoAudioListener implements IBYDAutoListener {
public void onArkamysModeChanged(int i) { }
public void onArkamysStateChanged(int i) { }
public void onAudioMicAmpGainChanged(int i) { }
public void onBackPadVolStateChanged(int i) { }
public void onBeamFormChanged(int i) { }
public void onChannelChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDiracLiveModeChanged(int i) { }
public void onDiracLiveStateChanged(int i) { }
public void onEqualizerChanged(int i, int i2) { }
public void onIflytekFunctionModeChanged(int i) { }
public void onIflytekWorkModeChanged(int i) { }
public void onKaraokeEqualizerChanged(int i, int i2) { }
public void onLoudnessStateChanged(int i) { }
public void onLoudspeakerNumChanged(int i) { }
public void onMuteStateChanged(int i) { }
public void onNaviMuteStateChanged(int i) { }
public void onNaviVolumeChanged(int i) { }
public void onSoundEffectChanged(int i) { }
public void onSoundFieldChanged(int i, int i2) { }
public void onVolumeChanged(int i, int i2) { }
public void onVolumeCtrlModeChanged(int i) { }
 }
