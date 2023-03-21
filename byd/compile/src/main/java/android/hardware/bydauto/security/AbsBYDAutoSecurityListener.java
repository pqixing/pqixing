package android.hardware.bydauto.security;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoSecurityListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoSecurityListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        if (iBYDAutoEvent instanceof BYDAutoSecurityEvent) {
            byte[] bufferData = ((BYDAutoSecurityEvent) iBYDAutoEvent).getBufferData();
            Log.d(TAG, "onDataChanged [S] bufData: " + Arrays.toString(bufferData));
            onSecurityStateChanged(bufferData);
            return;
        }
        a parse = parse(iBYDAutoEvent.getData());
        int value = iBYDAutoEvent.getValue();
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType + " value is " + value);
        if (parse == null) {
            return;
        }
        Log.d(TAG, "onDataChanged: data is " + parse);
    }

    public void onSecurityStateChanged(byte[] bArr) {
        Log.d(TAG, "onDataChanged: value is " + Arrays.toString(bArr));
    }
}
