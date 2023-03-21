package android.hardware.bydauto.doorlock;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoDoorLockListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoDoorLockListener";

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
        switch (eventType) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                int i = 2;
                if (value != 1 && value != 2) {
                    return;
                }
                if (eventType == 1) {
                    i = 1;
                } else if (eventType != 2) {
                    i = eventType == 3 ? 3 : eventType == 4 ? 4 : eventType == 5 ? 5 : eventType == 6 ? 6 : eventType == 7 ? 7 : 0;
                }
                onDoorLockStatusChanged(i, value);
                return;
            default:
                return;
        }
    }

    public void onDoorLockStatusChanged(int i, int i2) {
    }
}
