package android.hardware.bydauto.energy;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoEnergyListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoEnergyListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onBCMStateChanged(int i) {
    }

    public void onDCWorkModeChanged(int i) {
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
        switch (eventType) {
            case 1:
                if (value < 0 || value > 255) {
                    return;
                }
                if (value > 22 && value <= 255) {
                    value = 255;
                }
                onEnergyStateChanged(value);
                return;
            case 2:
                if (value < 0 || value > 4) {
                    return;
                }
                onRoadSurfaceChanged(value);
                return;
            case 3:
                if (value != 1 && value != 2) {
                    return;
                }
                onOperationModeChanged(value);
                return;
            case 4:
                if (value < 0 || value > 3) {
                    return;
                }
                onPowerGenerationStateChanged(value);
                return;
            case 5:
                if (value < 1 || value > 31) {
                    return;
                }
                onPowerGenerationValueChanged(value);
                return;
            case 6:
                if (value != 0 && value != 1 && value != 2) {
                    return;
                }
                onDCWorkModeChanged(value);
                return;
            case 7:
                if (value != 1 && value != 0) {
                    return;
                }
                onBCMStateChanged(value);
                return;
            case 8:
            default:
                return;
            case 9:
                if (value < 0 || value > 3) {
                    return;
                }
                onEnergyModeChanged(value);
                return;
        }
    }

    public void onEnergyModeChanged(int i) {
    }

    public void onEnergyStateChanged(int i) {
    }

    public void onOperationModeChanged(int i) {
    }

    public void onPowerGenerationStateChanged(int i) {
    }

    public void onPowerGenerationValueChanged(int i) {
    }

    public void onRoadSurfaceChanged(int i) {
    }
}
