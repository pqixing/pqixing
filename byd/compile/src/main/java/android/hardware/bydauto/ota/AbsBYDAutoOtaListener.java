package android.hardware.bydauto.ota;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoOtaListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoOtaListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onBatteryPowerVoltageChanged(double d2) {
    }

    public void onBatteryVoltageChanged(double d2) {
    }

    public void onCanInfoReceived(byte[] bArr) {
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        if (iBYDAutoEvent instanceof BYDAutoOtaEvent) {
            BYDAutoOtaEvent bYDAutoOtaEvent = (BYDAutoOtaEvent) iBYDAutoEvent;
            byte[] bufferData = bYDAutoOtaEvent.getBufferData();
            int eventType = bYDAutoOtaEvent.getEventType();
            Log.d(TAG, "onDataChanged: bufData: " + Arrays.toString(bufferData));
            Log.d(TAG, "onDataChanged: type: " + eventType);
            if (bufferData == null || bufferData.length < 1) {
                Log.e(TAG, "onDataChanged: Invalid data!");
                return;
            } else if (eventType == 1) {
                onOTAInfoACKChanged(bufferData);
                return;
            } else if (eventType == 34) {
                onCanInfoReceived(bufferData);
                return;
            } else if (eventType == 37) {
                onFaultCodeInfoReceived(bufferData);
                return;
            } else if (eventType == 6) {
                onECUVersionReceived(bufferData);
                return;
            } else if (eventType != 7) {
                return;
            } else {
                onECUSoftcodeReceived(bufferData);
                return;
            }
        }
        int eventType2 = iBYDAutoEvent.getEventType();
        if (eventType2 == 10) {
            int value = iBYDAutoEvent.getValue();
            if (value != 0 && value != 1) {
                return;
            }
            onPoweroffInformChanged(value);
        } else if (eventType2 == 27) {
            int value2 = iBYDAutoEvent.getValue();
            if (value2 != 0 && value2 != 1) {
                return;
            }
            onDischargeMainContactorStateChanged(value2);
        } else if (eventType2 == 36) {
            double doubleValue = iBYDAutoEvent.getDoubleValue();
            if (doubleValue < 6.0d || doubleValue > 17.0d) {
                return;
            }
            onBatteryPowerVoltageChanged(doubleValue);
        } else if (eventType2 == 40) {
            int value3 = iBYDAutoEvent.getValue();
            if (value3 != 1 && value3 != 0) {
                return;
            }
            onSyncMcuStateChanged(value3);
        } else if (eventType2 == 17) {
            int value4 = iBYDAutoEvent.getValue();
            if (value4 != 0 && value4 != 1) {
                return;
            }
            onOTAStateChanged(value4);
        } else if (eventType2 != 18) {
            switch (eventType2) {
                case 30:
                    double doubleValue2 = iBYDAutoEvent.getDoubleValue();
                    if (doubleValue2 < 8.0d || doubleValue2 > 16.0d) {
                        return;
                    }
                    onBatteryVoltageChanged(doubleValue2);
                    return;
                case 31:
                    int value5 = iBYDAutoEvent.getValue();
                    if (value5 != 0 && value5 != 1) {
                        return;
                    }
                    onPowerOnForbidStateChanged(value5);
                    return;
                case 32:
                    int value6 = iBYDAutoEvent.getValue();
                    if (value6 < 0 || value6 > 2) {
                        return;
                    }
                    onLFDoorLockStateChanged(value6);
                    return;
                default:
                    return;
            }
        } else {
            int value7 = iBYDAutoEvent.getValue();
            if (value7 != 0 && value7 != 1) {
                return;
            }
            onOTATimecountStateChanged(value7);
        }
    }

    public void onDischargeMainContactorStateChanged(int i) {
    }

    public void onECUSoftcodeReceived(byte[] bArr) {
    }

    public void onECUVersionReceived(byte[] bArr) {
    }

    public void onFaultCodeInfoReceived(byte[] bArr) {
    }

    public void onLFDoorLockStateChanged(int i) {
    }

    public void onOTAInfoACKChanged(byte[] bArr) {
    }

    public void onOTAStateChanged(int i) {
    }

    public void onOTATimecountStateChanged(int i) {
    }

    public void onPowerOnForbidStateChanged(int i) {
    }

    public void onPoweroffInformChanged(int i) {
    }

    public void onSyncMcuStateChanged(int i) {
    }
}
