package android.hardware.bydauto.qcfs;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoQcfsListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoQcfsListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        if (iBYDAutoEvent instanceof BYDAutoQcfsEvent) {
            BYDAutoQcfsEvent bYDAutoQcfsEvent = (BYDAutoQcfsEvent) iBYDAutoEvent;
            byte[] bufferData = bYDAutoQcfsEvent.getBufferData();
            int event = bYDAutoQcfsEvent.getEvent();
            Log.d(TAG, "onDataChanged [S] bufData: " + Arrays.toString(bufferData));
            Log.d(TAG, "onDataChanged [S] type: " + event);
            if (event == 1) {
                onEcuVersionInd(bufferData);
                return;
            } else if (event == 9) {
                onUpgradeCond(bufferData);
                return;
            } else if (event != 10) {
                return;
            } else {
                onKeyIdInd(bufferData);
                return;
            }
        }
        a parse = parse(iBYDAutoEvent.getData());
        int value = iBYDAutoEvent.getValue();
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType + " value is " + value);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        switch (eventType) {
            case 6:
                onFsQurQcStateInd();
                return;
            case 7:
                onNewVerUpgradeCond(value);
                return;
            case 8:
                onRcvKeyCond(value);
                return;
            case 9:
                onUpgradeCond(value);
                return;
            case 10:
            default:
                return;
            case 11:
                onOtaStateInd(value);
                return;
        }
    }

    public void onEcuVersionInd(byte[] bArr) {
    }

    public void onFsQurQcStateInd() {
    }

    public void onKeyIdInd(byte[] bArr) {
    }

    public void onNewVerUpgradeCond(int i) {
    }

    public void onOtaStateInd(int i) {
    }

    public void onRcvKeyCond(int i) {
    }

    public void onUpgradeCond(int i) {
    }

    public void onUpgradeCond(byte[] bArr) {
    }
}
