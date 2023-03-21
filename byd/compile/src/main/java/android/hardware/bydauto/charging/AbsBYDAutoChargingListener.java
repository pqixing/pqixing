package android.hardware.bydauto.charging;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoChargingListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoChargingListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onBatteryManagementDeviceStateChanged(int i) {
    }

    public void onBatteryTypeChanged(int i) {
    }

    public void onChargeTempCtlStateChanged(int i) {
    }

    public void onChargerFaultStateChanged(int i) {
    }

    public void onChargerStateChanged(int i) {
    }

    public void onChargerWorkStateChanged(int i) {
    }

    public void onChargingCapStateChanged(int i, int i2) {
    }

    public void onChargingCapacityChanged(double d2) {
    }

    public void onChargingGunNotInsertedStateChanged(int i) {
    }

    public void onChargingGunStateChanged(int i) {
    }

    public void onChargingModeChanged(int i) {
    }

    public void onChargingPortLockRebackStateChanged(int i) {
    }

    public void onChargingPowerChanged(double d2) {
    }

    public void onChargingRestTimeChanged(int i, int i2) {
    }

    public void onChargingScheduleEnableStateChanged(int i) {
    }

    public void onChargingScheduleStateChanged(int i) {
    }

    public void onChargingScheduleTimeChanged(int i, int i2) {
    }

    public void onChargingStateChanged(int i) {
    }

    public void onChargingTimerInfoChanged(ChargingTimerInfo chargingTimerInfo) {
    }

    public void onChargingTypeChanged(int i) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        a parse = parse(iBYDAutoEvent.getData());
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        int i = 1;
        if (eventType == 1) {
            int value = iBYDAutoEvent.getValue();
            if (value != 0 && value != 1) {
                return;
            }
            onChargerStateChanged(value);
        } else if (eventType == 2) {
            int value2 = iBYDAutoEvent.getValue();
            if (value2 != 0 && value2 != 1) {
                return;
            }
            onChargingScheduleEnableStateChanged(value2);
        } else {
            int i2 = 4;
            if (eventType == 15) {
                if (iBYDAutoEvent.getValue() == 3) {
                    i2 = 3;
                }
                onChargingTimerInfoChanged(BYDAutoChargingDevice.getInstance(null).getChargingTimerInfo(i2));
            } else if (eventType != 51) {
                switch (eventType) {
                    case 18:
                        int value3 = iBYDAutoEvent.getValue();
                        if (value3 != 1 && value3 != 2 && value3 != 3) {
                            return;
                        }
                        onChargerFaultStateChanged(value3);
                        return;
                    case 19:
                        int value4 = iBYDAutoEvent.getValue();
                        if (value4 < 1 || value4 > 4) {
                            return;
                        }
                        onChargerWorkStateChanged(value4);
                        return;
                    case 20:
                        double doubleValue = iBYDAutoEvent.getDoubleValue();
                        if (doubleValue < 0.0d || doubleValue > 131.07d) {
                            return;
                        }
                        onChargingCapacityChanged(doubleValue);
                        return;
                    case 21:
                        int value5 = iBYDAutoEvent.getValue();
                        if (value5 < 1 || value5 > 5) {
                            return;
                        }
                        onChargingTypeChanged(value5);
                        return;
                    default:
                        switch (eventType) {
                            case 24:
                            case 25:
                                int value6 = iBYDAutoEvent.getValue();
                                if (value6 != 1 && value6 != 0) {
                                    return;
                                }
                                if (eventType != 24) {
                                    i = eventType == 25 ? 2 : -1;
                                }
                                onChargingCapStateChanged(i, value6);
                                return;
                            case 26:
                                int value7 = iBYDAutoEvent.getValue();
                                if (value7 < 1 || value7 > 4) {
                                    return;
                                }
                                onChargingPortLockRebackStateChanged(value7);
                                return;
                            case 27:
                                int value8 = iBYDAutoEvent.getValue();
                                if (value8 < 1 || value8 > 7) {
                                    return;
                                }
                                onDischargeRequestStateChanged(value8);
                                return;
                            case 28:
                                int value9 = iBYDAutoEvent.getValue();
                                if (value9 != 1 && value9 != 5) {
                                    return;
                                }
                                onChargingGunStateChanged(value9);
                                return;
                            case 29:
                                break;
                            case 30:
                                int value10 = iBYDAutoEvent.getValue();
                                if (value10 < 0 || value10 > 13) {
                                    return;
                                }
                                onBatteryManagementDeviceStateChanged(value10);
                                return;
                            case 31:
                                int value11 = iBYDAutoEvent.getValue();
                                if (value11 < 1 || value11 > 5) {
                                    return;
                                }
                                onChargingScheduleStateChanged(value11);
                                return;
                            case 32:
                                int value12 = iBYDAutoEvent.getValue();
                                if (value12 != 1 && value12 != 2) {
                                    return;
                                }
                                onChargingGunNotInsertedStateChanged(value12);
                                return;
                            default:
                                switch (eventType) {
                                    case 35:
                                        int value13 = iBYDAutoEvent.getValue();
                                        if (value13 != 2 && value13 != 1) {
                                            return;
                                        }
                                        onChargingStateChanged(value13);
                                        return;
                                    case 36:
                                        int value14 = iBYDAutoEvent.getValue();
                                        if (value14 != 1 && value14 != 2) {
                                            return;
                                        }
                                        onChargingModeChanged(value14);
                                        return;
                                    case 37:
                                        int[] chargingRestTime = BYDAutoChargingDevice.getInstance(null).getChargingRestTime();
                                        if (chargingRestTime[0] < 0 || chargingRestTime[0] > 254 || chargingRestTime[1] < 0 || chargingRestTime[1] > 59) {
                                            return;
                                        }
                                        onChargingRestTimeChanged(chargingRestTime[0], chargingRestTime[1]);
                                        return;
                                    case 38:
                                        int[] chargingScheduleTime = BYDAutoChargingDevice.getInstance(null).getChargingScheduleTime();
                                        if (chargingScheduleTime[0] < 0 || chargingScheduleTime[0] > 23 || chargingScheduleTime[1] < 0 || chargingScheduleTime[1] > 59) {
                                            return;
                                        }
                                        onChargingScheduleTimeChanged(chargingScheduleTime[0], chargingScheduleTime[1]);
                                        return;
                                    case 39:
                                        int value15 = iBYDAutoEvent.getValue();
                                        if (value15 < 0 || value15 > 3) {
                                            return;
                                        }
                                        onSmartChargingStateChanged(value15);
                                        return;
                                    case 40:
                                    case 41:
                                        int value16 = iBYDAutoEvent.getValue();
                                        if (value16 < 0 || value16 > 2) {
                                            return;
                                        }
                                        if (eventType != 40) {
                                            i = eventType == 41 ? 2 : 0;
                                        }
                                        onDischargeStateChanged(i, value16);
                                        return;
                                    default:
                                        switch (eventType) {
                                            case 44:
                                            case 45:
                                                break;
                                            case 46:
                                                onDisChargeWarningStateChanged(iBYDAutoEvent.getValue());
                                                return;
                                            case 47:
                                            case 48:
                                                int value17 = iBYDAutoEvent.getValue();
                                                if (value17 != 1 && value17 != 0) {
                                                    return;
                                                }
                                                onFeatureChanged(eventType == 47 ? BYDAutoChargingDevice.FEATURE_CHARGE_BY_APPOINTMENT : eventType == 48 ? BYDAutoChargingDevice.FEATURE_CHARGE_WIRELESS_CHARGING : "Default", value17);
                                                return;
                                            case 49:
                                                int value18 = iBYDAutoEvent.getValue();
                                                if (value18 < 0 || value18 > 3) {
                                                    return;
                                                }
                                                onWirlessChargingStateChanged(value18);
                                                return;
                                            default:
                                                switch (eventType) {
                                                    case 53:
                                                        int value19 = iBYDAutoEvent.getValue();
                                                        if (value19 != 65535 && value19 != 1 && value19 != 0) {
                                                            return;
                                                        }
                                                        onBatteryTypeChanged(value19);
                                                        return;
                                                    case 54:
                                                        int value20 = iBYDAutoEvent.getValue();
                                                        if (value20 != 0 && value20 != 1 && value20 != 2) {
                                                            return;
                                                        }
                                                        onWirelessChargingSwitchStateChanged(value20);
                                                        return;
                                                    case 55:
                                                        int value21 = iBYDAutoEvent.getValue();
                                                        if (value21 != 1 && value21 != 0) {
                                                            return;
                                                        }
                                                        onWirelessChargingOnline5sStateChanged(value21);
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                }
                        }
                        onChargingPowerChanged(BYDAutoChargingDevice.getInstance(null).getChargingPower());
                        return;
                }
            } else {
                int value22 = iBYDAutoEvent.getValue();
                if (value22 != 0 && value22 != 1 && value22 != 2) {
                    return;
                }
                onChargeTempCtlStateChanged(value22);
            }
        }
    }

    public void onDisChargeWarningStateChanged(int i) {
    }

    public void onDischargeRequestStateChanged(int i) {
    }

    public void onDischargeStateChanged(int i, int i2) {
    }

    public void onFeatureChanged(String str, int i) {
    }

    public void onSmartChargingStateChanged(int i) {
    }

    public void onWirelessChargingOnline5sStateChanged(int i) {
    }

    public void onWirelessChargingSwitchStateChanged(int i) {
    }

    public void onWirlessChargingStateChanged(int i) {
    }
}
