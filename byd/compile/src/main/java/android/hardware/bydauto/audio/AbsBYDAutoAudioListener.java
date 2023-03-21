package android.hardware.bydauto.audio;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoAudioListener implements IBYDAutoListener {
    protected static final String TAG = "AbsBYDAutoAudioListener";

    public AbsBYDAutoAudioListener() {
        throw new RuntimeException("Stub!");
    }

    public void onArkamysModeChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onArkamysStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onAudioMicAmpGainChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onBackPadVolStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onBeamFormChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onChannelChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        throw new RuntimeException("Stub!");
    }

    public void onDiracLiveModeChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onDiracLiveStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onEqualizerChanged(int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public void onIflytekFunctionModeChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onIflytekWorkModeChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onKaraokeEqualizerChanged(int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public void onLoudnessStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onLoudspeakerNumChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onMuteStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onNaviMuteStateChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onNaviVolumeChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onSoundEffectChanged(int i) {
        throw new RuntimeException("Stub!");
    }

    public void onSoundFieldChanged(int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public void onVolumeChanged(int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    public void onVolumeCtrlModeChanged(int i) {
        throw new RuntimeException("Stub!");
    }
}
