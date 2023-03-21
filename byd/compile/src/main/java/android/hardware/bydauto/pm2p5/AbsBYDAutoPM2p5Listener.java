package android.hardware.bydauto.pm2p5;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoPM2p5Listener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoPM2p5Listener";
    private BYDAutoPM2p5Device mPM2p5Device;

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        a parse = parse(iBYDAutoEvent.getData());
        int[] iArr = new int[2];
        int value = iBYDAutoEvent.getValue();
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is: " + eventType + ", value inside is: " + iArr[0] + ", value outside is: " + iArr[1]);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        BYDAutoPM2p5Device bYDAutoPM2p5Device = BYDAutoPM2p5Device.getInstance(null);
        this.mPM2p5Device = bYDAutoPM2p5Device;
        switch (eventType) {
            case 7:
                int[] pM2p5Value = bYDAutoPM2p5Device.getPM2p5Value();
                int i = pM2p5Value[0];
                int i2 = pM2p5Value[1];
                if ((i > 3000 || i < 0) && (i2 > 3000 || i2 < 0)) {
                    return;
                }
                onPM2p5ValueChanged(i, i2);
                return;
            case 8:
                int[] pM2p5CheckState = bYDAutoPM2p5Device.getPM2p5CheckState();
                int i3 = pM2p5CheckState[0];
                int i4 = pM2p5CheckState[1];
                if (i3 != 1 && i3 != 0 && i4 != 1 && i4 != 0) {
                    return;
                }
                onPM2p5CheckStateChanged(i3, i4);
                return;
            case 9:
                int[] pM2p5Level = bYDAutoPM2p5Device.getPM2p5Level();
                int i5 = pM2p5Level[0];
                int i6 = pM2p5Level[1];
                if ((i5 > 6 || i5 < 0) && (i6 > 6 || i6 < 0)) {
                    return;
                }
                onPM2p5LevelChanged(i5, i6);
                return;
            case 10:
                int value2 = iBYDAutoEvent.getValue();
                if (value2 < 0 || value2 > 2) {
                    return;
                }
                onPM2p5OnlineStateChanged(value2);
                return;
            case 11:
            default:
                return;
            case 12:
                if (value < 0 || value > 2) {
                    return;
                }
                onPromptInfoChanged(value);
                return;
            case 13:
                if (value < 0 || value > 2) {
                    return;
                }
                onPM2p5WarningInfoChanged(value);
                return;
        }
    }

    public void onPM2p5CheckStateChanged(int i, int i2) {
    }

    public void onPM2p5LevelChanged(int i, int i2) {
    }

    public void onPM2p5OnlineStateChanged(int i) {
    }

    public void onPM2p5ValueChanged(int i, int i2) {
    }

    public void onPM2p5WarningInfoChanged(int i) {
    }

    public void onPromptInfoChanged(int i) {
    }
}
