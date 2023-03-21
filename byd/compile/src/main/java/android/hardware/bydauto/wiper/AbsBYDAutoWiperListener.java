package android.hardware.bydauto.wiper;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoWiperListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoWiperListener";

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
        int i = 1;
        if (eventType == 1 || eventType == 2) {
            if (value != 1 && value != 2 && value != 0) {
                return;
            }
            if (eventType == 1 || eventType != 2) {
                i = 0;
            }
            onWindscreenWiperResetStateChanged(i, value);
        } else if (eventType == 3) {
            if (value < 0 || value > 4) {
                return;
            }
            onWindscreenWiperSensitivityChanged(value);
        } else if (eventType != 4) {
        } else {
            if (value != 1 && value != 2 && value != 0) {
                return;
            }
            onWindscreenWiperRelayStateChanged(value);
        }
    }

    public void onWindscreenWiperRelayStateChanged(int i) {
    }

    public void onWindscreenWiperResetStateChanged(int i, int i2) {
    }

    public void onWindscreenWiperSensitivityChanged(int i) {
    }
}
