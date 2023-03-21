package android.hardware.bydauto.collision;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoCollisionListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoCollisionListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onCollisionSignalStateChanged(byte[] bArr) {
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        if (iBYDAutoEvent instanceof BYDAutoCollisionEvent) {
            byte[] bufferData = ((BYDAutoCollisionEvent) iBYDAutoEvent).getBufferData();
            Log.d(TAG, "onDataChanged [S] bufData: " + Arrays.toString(bufferData));
            onCollisionSignalStateChanged(bufferData);
        }
    }
}
