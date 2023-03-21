package android.hardware.bydauto.speed;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoSpeedListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoSpeedListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onAccelerateDeepnessChanged(int i) {
    }

    public void onAccelerateValueChanged(double d2) {
    }

    public void onBrakeDeepnessChanged(int i) {
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        a parse = parse(iBYDAutoEvent.getData());
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        if (eventType == 1) {
            double doubleValue = iBYDAutoEvent.getDoubleValue();
            if (doubleValue < 0.0d || doubleValue > 282.0d) {
                return;
            }
            onSpeedChanged(doubleValue);
        } else if (eventType == 2) {
            int value = iBYDAutoEvent.getValue();
            if (value < 0 || value > 100) {
                return;
            }
            onAccelerateDeepnessChanged(value);
        } else if (eventType == 3) {
            int value2 = iBYDAutoEvent.getValue();
            if (value2 < 0 || value2 > 100) {
                return;
            }
            onBrakeDeepnessChanged(value2);
        } else if (eventType == 4) {
            double doubleValue2 = iBYDAutoEvent.getDoubleValue();
            if (doubleValue2 < -30.0d || doubleValue2 > 31.0d) {
                return;
            }
            onAccelerateValueChanged(doubleValue2);
        } else if (eventType != 6) {
        } else {
            double doubleValue3 = iBYDAutoEvent.getDoubleValue();
            if (doubleValue3 < 0.0d || doubleValue3 > 282.0d) {
                return;
            }
            onSpeedFromGatewayChanged(doubleValue3);
        }
    }

    public void onSpeedChanged(double d2) {
    }

    public void onSpeedFromGatewayChanged(double d2) {
    }
}
