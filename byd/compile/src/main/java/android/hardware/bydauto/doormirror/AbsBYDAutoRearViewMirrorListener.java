package android.hardware.bydauto.doormirror;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoRearViewMirrorListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDRearViewMirrorListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onAutoExternalRearMirrorAntiglareStateChanged(int i) {
    }

    public void onAutoExternalRearMirrorStateChanged(int i) {
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
            if (value != 0 && value != 1 && value != 2) {
                return;
            }
            onAutoExternalRearMirrorStateChanged(value);
        } else if (eventType != 2) {
        } else {
            if (value != 0 && value != 1 && value != 2 && value != 3) {
                return;
            }
            onAutoExternalRearMirrorAntiglareStateChanged(value);
        }
    }
}
