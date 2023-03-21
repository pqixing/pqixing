package android.hardware.bydauto.tyre;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoTyreListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoTyreListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
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
                int value = iBYDAutoEvent.getValue();
                if (value < 0 || value > 2) {
                    return;
                }
                onTyreAirLeakStateChanged(1, value);
                return;
            case 2:
                double doubleValue = iBYDAutoEvent.getDoubleValue();
                if (0.0d > doubleValue || doubleValue > 40.0d) {
                    return;
                }
                onTyreBatteryValueChanged(1, doubleValue);
                return;
            case 3:
                int value2 = iBYDAutoEvent.getValue();
                if (value2 < 0 || value2 > 4094) {
                    return;
                }
                onTyrePressureValueChanged(1, value2);
                return;
            case 4:
                int value3 = iBYDAutoEvent.getValue();
                if (value3 < 0 || value3 > 3) {
                    return;
                }
                onTyrePressureStateChanged(1, value3);
                return;
            case 5:
                int value4 = iBYDAutoEvent.getValue();
                if (value4 != 0 && value4 != 1) {
                    return;
                }
                onTyreSignalStateChanged(1, value4);
                return;
            case 6:
                int value5 = iBYDAutoEvent.getValue();
                if (value5 < 0 || value5 > 2) {
                    return;
                }
                onTyreAirLeakStateChanged(2, value5);
                return;
            case 7:
                double doubleValue2 = iBYDAutoEvent.getDoubleValue();
                if (0.0d > doubleValue2 || doubleValue2 > 40.0d) {
                    return;
                }
                onTyreBatteryValueChanged(2, doubleValue2);
                return;
            case 8:
                int value6 = iBYDAutoEvent.getValue();
                if (value6 < 0 || value6 > 4094) {
                    return;
                }
                onTyrePressureValueChanged(2, value6);
                return;
            case 9:
                int value7 = iBYDAutoEvent.getValue();
                if (value7 < 0 || value7 > 3) {
                    return;
                }
                onTyrePressureStateChanged(2, value7);
                return;
            case 10:
                int value8 = iBYDAutoEvent.getValue();
                if (value8 != 0 && value8 != 1) {
                    return;
                }
                onTyreSignalStateChanged(2, value8);
                return;
            case 11:
                int value9 = iBYDAutoEvent.getValue();
                if (value9 < 0 || value9 > 2) {
                    return;
                }
                onTyreAirLeakStateChanged(3, value9);
                return;
            case 12:
                double doubleValue3 = iBYDAutoEvent.getDoubleValue();
                if (0.0d > doubleValue3 || doubleValue3 > 40.0d) {
                    return;
                }
                onTyreBatteryValueChanged(3, doubleValue3);
                return;
            case 13:
                int value10 = iBYDAutoEvent.getValue();
                if (value10 < 0 || value10 > 4094) {
                    return;
                }
                onTyrePressureValueChanged(3, value10);
                return;
            case 14:
                int value11 = iBYDAutoEvent.getValue();
                if (value11 < 0 || value11 > 3) {
                    return;
                }
                onTyrePressureStateChanged(3, value11);
                return;
            case 15:
                int value12 = iBYDAutoEvent.getValue();
                if (value12 != 0 && value12 != 1) {
                    return;
                }
                onTyreSignalStateChanged(3, value12);
                return;
            case 16:
                int value13 = iBYDAutoEvent.getValue();
                if (value13 < 0 || value13 > 2) {
                    return;
                }
                onTyreAirLeakStateChanged(4, value13);
                return;
            case 17:
                double doubleValue4 = iBYDAutoEvent.getDoubleValue();
                if (0.0d > doubleValue4 || doubleValue4 > 40.0d) {
                    return;
                }
                onTyreBatteryValueChanged(4, doubleValue4);
                return;
            case 18:
                int value14 = iBYDAutoEvent.getValue();
                if (value14 < 0 || value14 > 4094) {
                    return;
                }
                onTyrePressureValueChanged(4, value14);
                return;
            case 19:
                int value15 = iBYDAutoEvent.getValue();
                if (value15 < 0 || value15 > 3) {
                    return;
                }
                onTyrePressureStateChanged(4, value15);
                return;
            case 20:
                int value16 = iBYDAutoEvent.getValue();
                if (value16 != 0 && value16 != 1) {
                    return;
                }
                onTyreSignalStateChanged(4, value16);
                return;
            case 21:
                int value17 = iBYDAutoEvent.getValue();
                if (value17 < 0 || value17 > 4) {
                    return;
                }
                onTyreSystemStateChanged(value17);
                return;
            case 22:
                int value18 = iBYDAutoEvent.getValue();
                if (value18 < 0 || value18 > 3) {
                    return;
                }
                onTyreTemperatureStateChanged(value18);
                return;
            case 23:
                int value19 = iBYDAutoEvent.getValue();
                if (value19 != 0 && value19 != 1) {
                    return;
                }
                onTyreBatteryStateChanged(value19);
                return;
            case 24:
            case 25:
                int value20 = iBYDAutoEvent.getValue();
                if (value20 != 1 && value20 != 0) {
                    return;
                }
                onFeatureChanged(eventType == 24 ? BYDAutoTyreDevice.FEATURE_TYRE_PRESSURE_ONLINE : eventType == 25 ? BYDAutoTyreDevice.FEATURE_INDIRECT_TYRE_PRESSURE_ONLINE : "Default", value20);
                return;
            case 26:
                int value21 = iBYDAutoEvent.getValue();
                if (value21 < 1 || value21 > 3) {
                    return;
                }
                onIndirectTyreSystemStateChanged(value21);
                return;
            default:
                return;
        }
    }

    public void onFeatureChanged(String str, int i) {
    }

    public void onIndirectTyreSystemStateChanged(int i) {
    }

    public void onTyreAirLeakStateChanged(int i, int i2) {
    }

    public void onTyreBatteryStateChanged(int i) {
    }

    public void onTyreBatteryValueChanged(int i, double d2) {
    }

    public void onTyrePressureStateChanged(int i, int i2) {
    }

    public void onTyrePressureValueChanged(int i, int i2) {
    }

    public void onTyreSignalStateChanged(int i, int i2) {
    }

    public void onTyreSystemStateChanged(int i) {
    }

    public void onTyreTemperatureStateChanged(int i) {
    }
}
