package android.hardware.bydauto.special;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoSpecialListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoSpecialListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        if (iBYDAutoEvent instanceof BYDAutoSpecialEvent) {
            BYDAutoSpecialEvent bYDAutoSpecialEvent = (BYDAutoSpecialEvent) iBYDAutoEvent;
            byte[] bufferData = bYDAutoSpecialEvent.getBufferData();
            int eventType = bYDAutoSpecialEvent.getEventType();
            Log.d(TAG, "onDataChanged: bufData: " + Arrays.toString(bufferData));
            Log.d(TAG, "onDataChanged: type: " + eventType);
            if (bufferData == null || bufferData.length < 1) {
                Log.e(TAG, "onDataChanged: Invalid data!");
            } else if (eventType == 1) {
                onWheelSpeedChanged(bufferData);
            } else if (eventType != 2) {
            } else {
                onWheelDirectionChanged(bufferData);
            }
        }
    }

    public void onWheelDirectionChanged(byte[] bArr) {
    }

    public void onWheelSpeedChanged(byte[] bArr) {
    }
}
