package android.hardware.bydauto.sensor;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoSensorListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoSensorListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        int value;
        a parse = parse(iBYDAutoEvent.getData());
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        if (eventType == 1) {
            iBYDAutoEvent.getDoubleValue();
            double d2 = 0;
            if (d2 < -40.0d || d2 > 125.0d) {
                return;
            }
            onTemperatureSensorValueChanged(d2);
        } else if (eventType == 2) {
            iBYDAutoEvent.getDoubleValue();
            double d3 = 0;
            if (d3 < 0.0d || d3 > 100.0d) {
                return;
            }
            onHumiditySensorValueChanged(d3);
        } else if (eventType != 3) {
            if (eventType != 5 || (value = iBYDAutoEvent.getValue()) < -60 || value > 60) {
                return;
            }
            onSlopeValueChanged(value);
        } else {
            int value2 = iBYDAutoEvent.getValue();
            if (value2 < 1 || value2 > 5) {
                return;
            }
            onLightIntensityChanged(value2);
        }
    }

    public void onHumiditySensorValueChanged(double d2) {
    }

    public void onLightIntensityChanged(int i) {
    }

    public void onSlopeValueChanged(int i) {
    }

    public void onTemperatureSensorValueChanged(double d2) {
    }
}
