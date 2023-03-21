package android.hardware.bydauto.engine;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoEngineListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoEngineListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        a parse = parse(iBYDAutoEvent.getData());
        int value = iBYDAutoEvent.getValue();
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType + " value is " + value);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        if (eventType == 6) {
            if (value < 0 || value > 8000) {
                return;
            }
            onEngineSpeedChanged(value);
        } else if (eventType == 7) {
            if (value < 0 || value > 254) {
                return;
            }
            onOilLevelChanged(value);
        } else {
            switch (eventType) {
                case 12:
                    if (value != 2 && value != 1) {
                        return;
                    }
                    onEngineCoolantLevelChanged(value);
                    return;
                case 13:
                case 15:
                    if (value != 1 && value != 0) {
                        return;
                    }
                    String str = null;
                    if (eventType == 13) {
                        str = BYDAutoEngineDevice.FEATURE_ENGINE_VOICE_SIMULATOR;
                    } else if (eventType == 15) {
                        str = BYDAutoEngineDevice.FEATURE_ENGINE_VOICE_SOURCE;
                    }
                    onFeatureChanged(str, value);
                    return;
                case 14:
                    if (value != 0 && value != 1) {
                        return;
                    }
                    onEngineVoiceSimulatorStateChanged(value);
                    return;
                case 16:
                    if (value < 1 || value > 3) {
                        return;
                    }
                    onEngineSimulatorVoiceSourceChanged(value);
                    return;
                default:
                    return;
            }
        }
    }

    public void onEngineCoolantLevelChanged(int i) {
    }

    public void onEngineSimulatorVoiceSourceChanged(int i) {
    }

    public void onEngineSpeedChanged(int i) {
    }

    public void onEngineStateChanged(byte[] bArr) {
    }

    public void onEngineVoiceSimulatorStateChanged(int i) {
    }

    public void onFeatureChanged(String str, int i) {
    }

    public void onOilLevelChanged(int i) {
    }
}
