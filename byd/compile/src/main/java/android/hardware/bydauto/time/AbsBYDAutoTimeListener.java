package android.hardware.bydauto.time;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoTimeListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoTimeListener";

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
        if (eventType == 9) {
            if (value != 0 && value != 1) {
                return;
            }
            onTimeFormatChanged(value);
        } else if (eventType != 11) {
        } else {
            int[] time = BYDAutoTimeDevice.getInstance(null).getTime();
            if (time[0] >= 2001 && time[1] >= 1 && time[1] <= 12 && time[2] >= 1 && time[2] <= 31 && time[3] >= 0 && time[3] <= 23 && time[4] >= 0 && time[4] <= 59 && time[5] >= 0 && time[5] <= 59) {
                onTimeChanged(time);
            } else {
                Log.d(TAG, "onTimeChanged:time is outof scope");
            }
        }
    }

    public void onTimeChanged(int[] iArr) {
    }

    public void onTimeFormatChanged(int i) {
    }
}
