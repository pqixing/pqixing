package android.hardware.bydauto.safetybelt;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoSafetyBeltListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoSafetyBeltListener";

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
        int i = 4;
        switch (eventType) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (value != 0 && value != 1) {
                    return;
                }
                if (eventType == 1) {
                    i = 1;
                } else if (eventType == 2) {
                    i = 2;
                } else if (eventType == 3) {
                    i = 3;
                } else if (eventType != 4) {
                    i = eventType == 5 ? 5 : -1;
                }
                onSafetyBeltStatusChanged(i, value);
                return;
            case 6:
            case 7:
            case 8:
            case 9:
                if (value != 1 && value != 0) {
                    return;
                }
                if (eventType == 6) {
                    i = 1;
                } else if (eventType == 7) {
                    i = 2;
                } else if (eventType == 8) {
                    i = 3;
                } else if (eventType != 9) {
                    i = 0;
                }
                onPassengerStatusChanged(i, value);
                return;
            case 10:
                if (value != 1) {
                    return;
                }
                onSafetyBeltReminderReceived(value);
                return;
            case 11:
                if (value != 0 && value != 1) {
                    return;
                }
                onSafetyBeltMsrStateChanged(value);
                return;
            case 12:
                if (value != 1 && value != 0) {
                    return;
                }
                onMessage5sOnlineStateChanged(1, value);
                return;
            default:
                return;
        }
    }

    public void onMessage5sOnlineStateChanged(int i, int i2) {
    }

    public void onPassengerStatusChanged(int i, int i2) {
    }

    public void onSafetyBeltMsrStateChanged(int i) {
    }

    public void onSafetyBeltReminderReceived(int i) {
    }

    public void onSafetyBeltStatusChanged(int i, int i2) {
    }
}
