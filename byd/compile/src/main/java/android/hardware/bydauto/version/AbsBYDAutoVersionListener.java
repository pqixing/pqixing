package android.hardware.bydauto.version;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoVersionListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoVersionListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onBatteryCtrlVersionChanged(String str) {
    }

    public void onCarChargerVersionChanged(String str) {
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        a parse = parse(iBYDAutoEvent.getData());
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        switch (eventType) {
            case 1:
                onMcuVersionChanged(BYDAutoVersionDevice.getInstance(null).getMcuVersion());
                return;
            case 2:
                onDspVersionChanged(BYDAutoVersionDevice.getInstance(null).getDspVersion());
                return;
            case 3:
                onInstrumentVersionChanged(BYDAutoVersionDevice.getInstance(null).getInstrumentVersion());
                return;
            case 4:
                onEngineCtrlVersionChanged(BYDAutoVersionDevice.getInstance(null).getEngineCtrlVersion());
                return;
            case 5:
                onTransmissionCtrlVersionChanged(BYDAutoVersionDevice.getInstance(null).getTransmissionCtrlVersion());
                return;
            case 6:
                onMotorCtrl1VersionChanged(BYDAutoVersionDevice.getInstance(null).getMotorCtrl1Version());
                return;
            case 7:
                onMotorCtrl2VersionChanged(BYDAutoVersionDevice.getInstance(null).getMotorCtrl2Version());
                return;
            case 8:
                onMotorCtrl3VersionChanged(BYDAutoVersionDevice.getInstance(null).getMotorCtrl3Version());
                return;
            case 9:
                onBatteryCtrlVersionChanged(BYDAutoVersionDevice.getInstance(null).getBatteryCtrlVersion());
                return;
            case 10:
                onCarChargerVersionChanged(BYDAutoVersionDevice.getInstance(null).getCarChargerVersion());
                return;
            case 11:
                onMcuBootVersionChanged(BYDAutoVersionDevice.getInstance(null).getMcuBootVersion());
                return;
            case 12:
                onDtcVersionChanged(BYDAutoVersionDevice.getInstance(null).getDtcVersion());
                return;
            default:
                return;
        }
    }

    public void onDspVersionChanged(String str) {
    }

    public void onDtcVersionChanged(String str) {
    }

    public void onEngineCtrlVersionChanged(String str) {
    }

    public void onInstrumentVersionChanged(String str) {
    }

    public void onMcuBootVersionChanged(String str) {
    }

    public void onMcuVersionChanged(String str) {
    }

    public void onMotorCtrl1VersionChanged(String str) {
    }

    public void onMotorCtrl2VersionChanged(String str) {
    }

    public void onMotorCtrl3VersionChanged(String str) {
    }

    public void onTransmissionCtrlVersionChanged(String str) {
    }
}
