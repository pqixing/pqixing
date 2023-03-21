package android.hardware.bydauto.panorama;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoPanoramaListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoPanoramaListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onACUStateChanged(int i) {
    }

    public void onBackLineConfigChanged(int i) {
    }

    public void onCarInfoChanged(int i) {
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
            case 4:
                if (value != 1 && value != 0) {
                    return;
                }
                onPanoWorkStateChanged(value);
                return;
            case 5:
                if (value < 0 || value > 11) {
                    return;
                }
                onPanOutputStateChanged(value);
                return;
            case 6:
                if (value != 0 && value != 1) {
                    return;
                }
                onPanOutputSignalChanged(value);
                return;
            case 7:
                if (value < 0 || value > 2) {
                    return;
                }
                onBackLineConfigChanged(value);
                return;
            case 8:
            case 17:
                onPanoramaOnlineStateChanged(BYDAutoPanoramaDevice.getInstance(null).getPanoramaOnlineState());
                return;
            case 9:
                if (value != 1 && value != 2) {
                    return;
                }
                onPanoRotationChanged(value);
                return;
            case 10:
            case 11:
            case 12:
            case 14:
            case 22:
            case 23:
            default:
                return;
            case 13:
                if (value != 2 && value != 1) {
                    return;
                }
                onRightCameraSwitchStateChanged(value);
                onRFCameraSwitchStateChanged(value);
                return;
            case 15:
                if (value != 0 && value != 1 && value != 3 && value != 4 && value != 5) {
                    return;
                }
                onDisplayModeChanged(value);
                return;
            case 16:
                if (value != 1 && value != 2 && value != 3) {
                    return;
                }
                onLVDSStateChanged(value);
                return;
            case 18:
                if (value != 0 && value != 1) {
                    return;
                }
                onEmergencyButtonStateChanged(value);
                return;
            case 19:
                if (value != 0 && value != 1 && value != 2) {
                    return;
                }
                onACUStateChanged(value);
                return;
            case 20:
                if (value != 1 && value != 0) {
                    return;
                }
                onFeatureChanged(eventType == 20 ? BYDAutoPanoramaDevice.FEATURE_ACU : "Default", value);
                return;
            case 21:
                if (value != 0 && value != 1) {
                    return;
                }
                onCarInfoChanged(value);
                return;
            case 24:
                if (value != 0 && value != 1 && value != 2) {
                    return;
                }
                onPanoramaTransparenceChanged(value);
                return;
        }
    }

    public void onDisplayModeChanged(int i) {
    }

    public void onEmergencyButtonStateChanged(int i) {
    }

    public void onFeatureChanged(String str, int i) {
    }

    public void onLVDSStateChanged(int i) {
    }

    public void onPanOutputSignalChanged(int i) {
    }

    public void onPanOutputStateChanged(int i) {
    }

    public void onPanoRotationChanged(int i) {
    }

    public void onPanoWorkStateChanged(int i) {
    }

    public void onPanoramaOnlineStateChanged(int i) {
    }

    public void onPanoramaTransparenceChanged(int i) {
    }

    public void onRFCameraSwitchStateChanged(int i) {
    }

    public void onRightCameraSwitchStateChanged(int i) {
    }
}
