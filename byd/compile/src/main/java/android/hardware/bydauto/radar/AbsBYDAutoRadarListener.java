package android.hardware.bydauto.radar;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoRadarListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoRadarListener";

    /* renamed from: android.hardware.bydauto.radar.AbsBYDAutoRadarListener$a */
    /* loaded from: classes.dex */
    private class C0040a {
    }

    private C0040a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        C0040a parse = parse(iBYDAutoEvent.getData());
        int eventType = iBYDAutoEvent.getEventType();
        int value = iBYDAutoEvent.getValue();
        Log.d(TAG, "onDataChanged: type is " + eventType + " value is " + value);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        switch (eventType) {
            case 1:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(1, value);
                return;
            case 2:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(1, value);
                return;
            case 3:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(2, value);
                return;
            case 4:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(2, value);
                return;
            case 5:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(3, value);
                return;
            case 6:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(3, value);
                return;
            case 7:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(4, value);
                return;
            case 8:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(4, value);
                return;
            case 9:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(5, value);
                return;
            case 10:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(5, value);
                return;
            case 11:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(6, value);
                return;
            case 12:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(6, value);
                return;
            case 13:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(7, value);
                return;
            case 14:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(7, value);
                return;
            case 15:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(8, value);
                return;
            case 16:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(8, value);
                return;
            case 17:
                if (value != 1 && value != 0) {
                    return;
                }
                onReverseRadarSwitchStateChanged(value);
                return;
            case 18:
            case 19:
            default:
                return;
            case 20:
                if (value > 4 || value < 0) {
                    return;
                }
                onRadarProbeStateChanged(9, value);
                return;
            case 21:
                if (value < 0 || value > 155) {
                    return;
                }
                onRadarObstacleDistanceChanged(9, value);
                return;
        }
    }

    public void onRadarObstacleDistanceChanged(int i, int i2) {
    }

    public void onRadarProbeStateChanged(int i, int i2) {
    }

    public void onReverseRadarSwitchStateChanged(int i) {
    }
}
