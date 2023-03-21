package android.hardware.bydauto.vehicledata;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoVehicleDataListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoVehicleDataListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        if (iBYDAutoEvent instanceof BYDAutoVehicleDataEvent) {
            BYDAutoVehicleDataEvent bYDAutoVehicleDataEvent = (BYDAutoVehicleDataEvent) iBYDAutoEvent;
            byte[] bufferData = bYDAutoVehicleDataEvent.getBufferData();
            int eventType = bYDAutoVehicleDataEvent.getEventType();
            Log.d(TAG, "onDataChanged: bufData: " + Arrays.toString(bufferData));
            Log.d(TAG, "onDataChanged: type: " + eventType);
            if (bufferData == null || bufferData.length < 1) {
                Log.e(TAG, "onDataChanged: Invalid data!");
            } else if (eventType == 1) {
                onVehicleDataAcqReceived(bufferData);
            } else if (eventType == 2) {
                onEventDataAcqReceived(bufferData);
            } else if (eventType != 3) {
            } else {
                onPeriodDataAcqReceived(bufferData);
            }
        }
    }

    public void onEventDataAcqReceived(byte[] bArr) {
    }

    public void onPeriodDataAcqReceived(byte[] bArr) {
    }

    public void onVehicleDataAcqReceived(byte[] bArr) {
    }
}
