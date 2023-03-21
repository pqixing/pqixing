package android.hardware.bydauto.statistic;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoStatisticListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoStatisticListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onAverageElectricConsumptionChanged(int i, double d2) {
    }

    public void onAverageFuelConsumptionChanged(int i, double d2) {
    }

    public void onAverageSpeedChanged(int i, double d2) {
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        a parse = parse(iBYDAutoEvent.getData());
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        int i = 0;
        switch (eventType) {
            case 1:
                int value = iBYDAutoEvent.getValue();
                if (value < 0 || value > 999999) {
                    return;
                }
                onTotalMileageValueChanged(value);
                return;
            case 2:
            case 13:
            case 14:
                double doubleValue = iBYDAutoEvent.getDoubleValue();
                if (doubleValue < 0.0d || doubleValue > 104858.4d) {
                    return;
                }
                if (eventType == 2) {
                    onTotalFuelConChanged(doubleValue);
                    i = 1;
                } else if (eventType == 13) {
                    i = 2;
                } else if (eventType == 14) {
                    i = 3;
                }
                onFuelConsumptionChanged(i, doubleValue);
                return;
            case 3:
            case 15:
            case 16:
                double doubleValue2 = iBYDAutoEvent.getDoubleValue();
                if (doubleValue2 < -1000.0d || doubleValue2 > 1676722.4d) {
                    return;
                }
                if (eventType == 3) {
                    onTotalElecConChanged(doubleValue2);
                    i = 1;
                } else if (eventType == 15) {
                    i = 2;
                } else if (eventType == 16) {
                    i = 3;
                }
                onElectricConsumptionChanged(i, doubleValue2);
                return;
            case 4:
            case 21:
            case 22:
                double doubleValue3 = iBYDAutoEvent.getDoubleValue();
                if (doubleValue3 < 0.0d || doubleValue3 > 100000.0d) {
                    return;
                }
                if (eventType == 4) {
                    onDrivingTimeChanged(doubleValue3);
                    i = 1;
                } else if (eventType == 21) {
                    i = 2;
                } else if (eventType == 22) {
                    i = 3;
                }
                onTravelTimeChanged(i, doubleValue3);
                return;
            case 5:
                onLastFuelConPHMChanged(iBYDAutoEvent.getDoubleValue());
                return;
            case 6:
            case 17:
            case 18:
                double doubleValue4 = iBYDAutoEvent.getDoubleValue();
                if (eventType == 6) {
                    onTotalFuelConPHMChanged(doubleValue4);
                    i = 1;
                } else if (eventType == 17) {
                    i = 2;
                } else if (eventType == 18) {
                    i = 3;
                }
                onAverageFuelConsumptionChanged(i, doubleValue4);
                return;
            case 7:
                onLastElecConPHMChanged(iBYDAutoEvent.getDoubleValue());
                return;
            case 8:
            case 19:
            case 20:
                double doubleValue5 = iBYDAutoEvent.getDoubleValue();
                if (eventType == 8) {
                    onTotalElecConPHMChanged(doubleValue5);
                    i = 1;
                } else if (eventType == 19) {
                    i = 2;
                } else if (eventType == 20) {
                    i = 3;
                }
                onAverageElectricConsumptionChanged(i, doubleValue5);
                return;
            case 9:
                onElecDrivingRangeChanged(iBYDAutoEvent.getValue());
                return;
            case 10:
                onFuelDrivingRangeChanged(iBYDAutoEvent.getValue());
                return;
            case 11:
                int value2 = iBYDAutoEvent.getValue();
                if (value2 < 0 || value2 > 100) {
                    return;
                }
                onFuelPercentageChanged(value2);
                return;
            case 12:
                double doubleValue6 = iBYDAutoEvent.getDoubleValue();
                if (0.0d > doubleValue6 || doubleValue6 > 101.0d) {
                    return;
                }
                onElecPercentageChanged(doubleValue6);
                return;
            case 23:
            case 24:
            case 25:
                double doubleValue7 = iBYDAutoEvent.getDoubleValue();
                if (doubleValue7 < 0.0d || doubleValue7 > 282.5d) {
                    return;
                }
                if (eventType == 23) {
                    i = 1;
                } else if (eventType == 24) {
                    i = 2;
                } else if (eventType == 25) {
                    i = 3;
                }
                onAverageSpeedChanged(i, doubleValue7);
                return;
            case 26:
                int value3 = iBYDAutoEvent.getValue();
                if (value3 < 0 || value3 > 4095) {
                    return;
                }
                onFuelADValueChanged(value3);
                return;
            case 27:
                int value4 = iBYDAutoEvent.getValue();
                if (value4 != 1 && value4 != 2) {
                    return;
                }
                onKeyBatteryLevelChanged(value4);
                return;
            case 28:
                int value5 = iBYDAutoEvent.getValue();
                if (value5 < 0 || value5 > 100) {
                    return;
                }
                onSOCBatteryPercentageChanged(value5);
                return;
            case 29:
                int value6 = iBYDAutoEvent.getValue();
                if (value6 < 0 || value6 > 999999) {
                    return;
                }
                onEVMileageValueChanged(value6);
                return;
            case 30:
                int value7 = iBYDAutoEvent.getValue();
                if (value7 < 0 || value7 > 999999) {
                    return;
                }
                onHEVMileageValueChanged(value7);
                return;
            case 31:
                int value8 = iBYDAutoEvent.getValue();
                if (value8 < 0 || value8 > 255) {
                    return;
                }
                onWaterTemperatureChanged(value8);
                return;
            case 32:
                int value9 = iBYDAutoEvent.getValue();
                if (value9 < 0 || value9 > 2) {
                    return;
                }
                onEVDrivingMileageModeChanged(value9);
                return;
            case 33:
                int value10 = iBYDAutoEvent.getValue();
                if (1 > value10 || value10 > 2) {
                    return;
                }
                onEVDrivingMileageConfigChanged(value10);
                return;
            case 34:
                double doubleValue8 = iBYDAutoEvent.getDoubleValue();
                if (doubleValue8 < -2000.0d || doubleValue8 > 2000.0d) {
                    return;
                }
                onInstantElecConChanged(doubleValue8);
                return;
            case 35:
                double doubleValue9 = iBYDAutoEvent.getDoubleValue();
                if (doubleValue9 < 0.0d || doubleValue9 > 65.0d) {
                    return;
                }
                onInstantFuelConChanged(doubleValue9);
                return;
            case 36:
                int value11 = iBYDAutoEvent.getValue();
                if (value11 != 0 && value11 != 1) {
                    return;
                }
                onMessage5sOnlineStateChanged(1, value11);
                return;
            case 37:
                int value12 = iBYDAutoEvent.getValue();
                if (value12 != 0 && value12 != 1) {
                    return;
                }
                onMessage5sOnlineStateChanged(2, value12);
                return;
            default:
                return;
        }
    }

    public void onDrivingTimeChanged(double d2) {
    }

    public void onEVDrivingMileageConfigChanged(int i) {
    }

    public void onEVDrivingMileageModeChanged(int i) {
    }

    public void onEVMileageValueChanged(int i) {
    }

    public void onElecDrivingRangeChanged(int i) {
    }

    public void onElecPercentageChanged(double d2) {
    }

    public void onElectricConsumptionChanged(int i, double d2) {
    }

    public void onFuelADValueChanged(int i) {
    }

    public void onFuelConsumptionChanged(int i, double d2) {
    }

    public void onFuelDrivingRangeChanged(int i) {
    }

    public void onFuelPercentageChanged(int i) {
    }

    public void onHEVMileageValueChanged(int i) {
    }

    public void onInstantElecConChanged(double d2) {
    }

    public void onInstantFuelConChanged(double d2) {
    }

    public void onKeyBatteryLevelChanged(int i) {
    }

    public void onLastElecConPHMChanged(double d2) {
    }

    public void onLastFuelConPHMChanged(double d2) {
    }

    public void onMessage5sOnlineStateChanged(int i, int i2) {
    }

    public void onSOCBatteryPercentageChanged(int i) {
    }

    public void onTotalElecConChanged(double d2) {
    }

    public void onTotalElecConPHMChanged(double d2) {
    }

    public void onTotalFuelConChanged(double d2) {
    }

    public void onTotalFuelConPHMChanged(double d2) {
    }

    public void onTotalMileageValueChanged(int i) {
    }

    public void onTravelTimeChanged(int i, double d2) {
    }

    public void onWaterTemperatureChanged(int i) {
    }
}
