package android.hardware.bydauto.motor;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoMotorListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoMotorListener";

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
        switch (eventType) {
            case 1:
                if (value != 0 && value != 1) {
                    return;
                }
                onMotorPowerChanged(value);
                return;
            case 2:
                if (value != 0 && value != 1) {
                    return;
                }
                onMotorLockChanged(value);
                return;
            case 3:
                if (value != 0) {
                    return;
                }
                onMotorAngleChanged(value);
                return;
            case 4:
                if (value < -500 || value > 500) {
                    return;
                }
                onMotorPositionChanged(value);
                return;
            case 5:
                if (value < 0 || value > 8) {
                    return;
                }
                onMotorDirectionChanged(value);
                return;
            case 6:
                if (value != 0) {
                    return;
                }
                onMotorSpeedChanged(value);
                return;
            default:
                return;
        }
    }

    public void onMotorAngleChanged(int i) {
    }

    public void onMotorDirectionChanged(int i) {
    }

    public void onMotorLockChanged(int i) {
    }

    public void onMotorPositionChanged(int i) {
    }

    public void onMotorPowerChanged(int i) {
    }

    public void onMotorSpeedChanged(int i) {
    }
}
