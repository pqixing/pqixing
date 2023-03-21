package android.hardware.bydauto.phone;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoPhoneListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoPhoneListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        a parse = parse(iBYDAutoEvent.getData());
        int eventType = iBYDAutoEvent.getEventType();
        int value = iBYDAutoEvent.getValue();
        Log.d(TAG, "onDataChanged: type is " + eventType);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        if (eventType == 1) {
            if (value != 0 && value != 1) {
                return;
            }
            onPhoneMuteChanged(value);
        } else if (eventType != 2) {
        } else {
            if (value != 2 && value != 1 && value != 3) {
                return;
            }
            onPhoneEventChanged(value);
        }
    }

    public void onPhoneEventChanged(int i) {
    }

    public void onPhoneMuteChanged(int i) {
    }
}
