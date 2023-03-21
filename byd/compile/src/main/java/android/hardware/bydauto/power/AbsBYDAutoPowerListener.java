package android.hardware.bydauto.power;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoPowerListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoPowerListener";

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
        if (eventType != 3) {
            if (eventType == 4) {
                if (value != 1 && value != 0) {
                    return;
                }
                onMcuStatusChanged(value);
                return;
            } else if (eventType != 6 && eventType != 7 && eventType != 8) {
                switch (eventType) {
                    case 12:
                    case 13:
                    case 14:
                    case 16:
                    case 17:
                        break;
                    case 15:
                        if (value < 0 || value > 11) {
                            return;
                        }
                        onTftBacklightChanged(value);
                        return;
                    case 18:
                    case 19:
                        if (value != 1 && value != 2) {
                            return;
                        }
                        onTpDisplayControllerChanged(eventType, value);
                        return;
                    case 20:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onShutdownInfoChanged(1, value);
                        return;
                    default:
                        return;
                }
            }
        }
        if (value == 0 || value == 1) {
            onPowerCtlStatusChanged(eventType, value);
        }
    }

    public void onMcuStatusChanged(int i) {
    }

    public void onPowerCtlStatusChanged(int i, int i2) {
    }

    public void onShutdownInfoChanged(int i, int i2) {
    }

    public void onTftBacklightChanged(int i) {
    }

    public void onTpDisplayControllerChanged(int i, int i2) {
    }
}
