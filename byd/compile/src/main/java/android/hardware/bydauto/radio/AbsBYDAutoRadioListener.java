package android.hardware.bydauto.radio;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoRadioListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoRadioListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onCurFreqChanged(int i, int i2, int i3) {
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        if (iBYDAutoEvent instanceof BYDAutoRadioEvent) {
            BYDAutoRadioEvent bYDAutoRadioEvent = (BYDAutoRadioEvent) iBYDAutoEvent;
            byte[] bufferData = bYDAutoRadioEvent.getBufferData();
            int eventType = bYDAutoRadioEvent.getEventType();
            Log.d(TAG, "onDataChanged: type: " + eventType);
            if (bufferData != null && bufferData.length >= 1) {
                if (eventType != 21 || bufferData.length <= 4) {
                    return;
                }
                int i = bufferData[0] & 255;
                int i2 = ((bufferData[1] & 255) << 8) + (bufferData[2] & 255);
                int i3 = bufferData[3] & 255;
                int i4 = bufferData[4] & 255;
                Log.d(TAG, "onSearchResultChanged: band = " + i + ", frequencyRec = " + i2 + ", searchProcessState = " + i3 + ", isEffective = " + i4);
                if (i == 1) {
                    onSearchResultChanged(i, i2 * 10, i4, i3);
                    return;
                } else {
                    onSearchResultChanged(i, i2, i4, i3);
                    return;
                }
            }
            Log.e(TAG, "onDataChanged: Invalid data!");
            return;
        }
        a parse = parse(iBYDAutoEvent.getData());
        int value = iBYDAutoEvent.getValue();
        int eventType2 = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType2 + " value is " + value);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        switch (eventType2) {
            case 1:
            case 2:
            case 3:
                int[] radioParam = BYDAutoRadioDevice.getInstance(null).getRadioParam(1);
                onRadioParamChanged(1, radioParam[0], radioParam[1], radioParam[2]);
                return;
            case 4:
            case 5:
            case 6:
                int[] radioParam2 = BYDAutoRadioDevice.getInstance(null).getRadioParam(2);
                onRadioParamChanged(2, radioParam2[0], radioParam2[1], radioParam2[2]);
                return;
            case 7:
                if (value < 0 || value > 3) {
                    return;
                }
                onRadioStateChanged(value);
                return;
            case 8:
                onCurFreqChanged(BYDAutoRadioDevice.getInstance(null).getRadioState(), BYDAutoRadioDevice.getInstance(null).getRadioBand(), value);
                return;
            case 9:
            default:
                return;
            case 10:
                onEffectiveFreqSearched(BYDAutoRadioDevice.getInstance(null).getRadioState(), BYDAutoRadioDevice.getInstance(null).getRadioBand(), BYDAutoRadioDevice.getInstance(null).getSearchProcessState(), value);
                return;
        }
    }

    public void onEffectiveFreqSearched(int i, int i2, int i3, int i4) {
    }

    public void onRadioParamChanged(int i, int i2, int i3, int i4) {
    }

    public void onRadioStateChanged(int i) {
    }

    public void onSearchResultChanged(int i, int i2, int i3, int i4) {
    }
}
