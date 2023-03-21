package android.hardware.bydauto.light;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoLightListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoLightListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onAFSSwitchStateChange(int i) {
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
        int i = 1;
        switch (eventType) {
            case 1:
                if (value < 1 || value > 5) {
                    return;
                }
                onIlluminationIntensityLevelChange(value);
                return;
            case 2:
                if (value != 0 && value != 1) {
                    return;
                }
                onAFSSwitchStateChange(value);
                return;
            case 3:
                if (value == 0) {
                    onLightAutoSwitchOff();
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightAutoSwitchOn();
                    return;
                }
            case 4:
                if (value == 0) {
                    onLightOff(1);
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightOn(1);
                    return;
                }
            case 5:
                if (value == 0) {
                    onLightOff(2);
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightOn(2);
                    return;
                }
            case 6:
                if (value == 0) {
                    onLightOff(3);
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightOn(3);
                    return;
                }
            case 7:
                if (value == 0) {
                    onLightOff(4);
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightOn(4);
                    return;
                }
            case 8:
                if (value == 0) {
                    onLightOff(5);
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightOn(5);
                    return;
                }
            case 9:
                if (value == 0) {
                    onLightOff(6);
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightOn(6);
                    return;
                }
            case 10:
                if (value == 0) {
                    onLightOff(7);
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightOn(7);
                    return;
                }
            case 11:
                if (value == 0) {
                    onLightOff(8);
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onLightOn(8);
                    return;
                }
            case 12:
            case 13:
                if (value != 0 && value != 1 && value != 2) {
                    return;
                }
                if (eventType == 12 || eventType != 13) {
                    i = 0;
                }
                onGroupHeadlightStateChanged(i, value);
                return;
            case 14:
                if (value < 0 || value > 3) {
                    return;
                }
                onStopLightStateChanged(value);
                return;
            case 15:
                if (value < 0 || value > 2) {
                    return;
                }
                onDayRunningLightStateChanged(value);
                return;
            case 16:
                if (value != 0 && value != 1 && value != 3) {
                    return;
                }
                onSequentialLightStateChanged(value);
                return;
            case 17:
                if (value < 0 || value > 2) {
                    return;
                }
                onDoubleFlashLightStateChanged(value);
                return;
            case 18:
                if (value < 0 || value > 2) {
                    return;
                }
                onReversingLightStateChanged(value);
                return;
            default:
                return;
        }
    }

    public void onDayRunningLightStateChanged(int i) {
    }

    public void onDoubleFlashLightStateChanged(int i) {
    }

    public void onGroupHeadlightStateChanged(int i, int i2) {
    }

    public void onIlluminationIntensityLevelChange(int i) {
    }

    public void onLightAutoSwitchOff() {
    }

    public void onLightAutoSwitchOn() {
    }

    public void onLightOff(int i) {
    }

    public void onLightOn(int i) {
    }

    public void onReversingLightStateChanged(int i) {
    }

    public void onSequentialLightStateChanged(int i) {
    }

    public void onStopLightStateChanged(int i) {
    }
}
