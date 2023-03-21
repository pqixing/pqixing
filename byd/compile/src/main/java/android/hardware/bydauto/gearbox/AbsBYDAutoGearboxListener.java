package android.hardware.bydauto.gearbox;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoGearboxListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoGearboxListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onBrakeFluidLevelChanged(int i) {
    }

    public void onBrakePedalStateChanged(int i) {
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
        if (eventType == 2) {
            if (value < 1 || value > 6) {
                return;
            }
            onGearboxAutoModeTypeChanged(value);
        } else if (eventType == 3) {
            int gearboxType = BYDAutoGearboxDevice.getInstance(null).getGearboxType();
            if (value < 0 || value > 2 || gearboxType != 0) {
                return;
            }
            onGearboxManualModeLevelChanged(value);
        } else if (eventType == 4) {
            if (value != 1 && value != 2) {
                return;
            }
            onBrakeFluidLevelChanged(value);
        } else if (eventType == 5) {
            if (value != 1 && value != 0) {
                return;
            }
            onParkBrakeSwitchChanged(value);
            onGearboxStateChanged(value);
        } else if (eventType == 6) {
            if (value != 1 && value != 2) {
                return;
            }
            onBrakePedalStateChanged(value);
        } else if (eventType != 9) {
        } else {
            if (value < 0 && value > 4) {
                return;
            }
            onEPBStateChanged(value);
        }
    }

    public void onEPBStateChanged(int i) {
    }

    public void onGearboxAutoModeTypeChanged(int i) {
    }

    public void onGearboxManualModeLevelChanged(int i) {
    }

    public void onGearboxStateChanged(int i) {
    }

    public void onParkBrakeSwitchChanged(int i) {
    }
}
