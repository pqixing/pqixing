package android.hardware.bydauto.rescue;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoRescueListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoRescueListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onAirbagStateChanged(int i) {
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
        if (eventType == 1) {
            onInfoFromMCUChanged(value);
        } else if (eventType != 3) {
        } else {
            onAirbagStateChanged(value);
        }
    }

    public void onInfoFromMCUChanged(int i) {
    }
}
