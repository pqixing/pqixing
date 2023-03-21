package android.hardware.bydauto.location;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoLocationListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoLocationListener";

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
        Log.d(TAG, "onDataChanged: type is " + eventType);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        if (eventType != 5) {
            return;
        }
        double[] locationLongitudeLatitudeValue = BYDAutoLocationDevice.getInstance(null).getLocationLongitudeLatitudeValue();
        onLocationLongitudeLatitudeValueChanged((int) locationLongitudeLatitudeValue[0], locationLongitudeLatitudeValue[1], (int) locationLongitudeLatitudeValue[2], locationLongitudeLatitudeValue[3], (int) locationLongitudeLatitudeValue[4], (float) locationLongitudeLatitudeValue[5], locationLongitudeLatitudeValue[6]);
    }

    public void onLocationLongitudeLatitudeValueChanged(int i, double d2, int i2, double d3, int i3, float f2, double d4) {
    }
}
