package android.hardware.bydauto.ac;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoAcListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoAcListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onAcAirQualityCtrlMenuStateChanged(int i) {
    }

    public void onAcCompressorManualSignChanged(int i) {
    }

    public void onAcCompressorModeChanged(int i) {
    }

    public void onAcCtrlModeChanged(int i) {
    }

    public void onAcCycleModeChanged(int i) {
    }

    public void onAcDefrostOnlineStateChanged(int i) {
    }

    public void onAcDefrostStateChanged(int i, int i2) {
    }

    public void onAcFaultNumShownStateChanged(int i) {
    }

    public void onAcKeyActionStateChanged(int i) {
    }

    public void onAcMaxCoolingStateChanged(int i) {
    }

    public void onAcOnlineStateChanged(int i) {
    }

    public void onAcPromptBoxShownStateChanged(int i) {
    }

    public void onAcPtcPreheatSignalChanged(int i) {
    }

    public void onAcRearStarted() {
    }

    public void onAcRearStoped() {
    }

    public void onAcRemoteCtrlTimeChanged(int i) {
    }

    public void onAcStarted() {
    }

    public void onAcStoped() {
    }

    public void onAcTemperatureControlModeChanged(int i) {
    }

    public void onAcVentilationStateChanged(int i) {
    }

    public void onAcWarmStateChanged(int i) {
    }

    public void onAcWarmTypeOnlineStateChanged(int i) {
    }

    public void onAcWindLevelChanged(int i) {
    }

    public void onAcWindLevelManualSignChanged(int i) {
    }

    public void onAcWindModeChanged(int i) {
    }

    public void onAcWindModeManualSignChanged(int i) {
    }

    public void onAcWindModeShownStateChanged(int i) {
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
            case 0:
                if (value == 0) {
                    onAcStoped();
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onAcStarted();
                    return;
                }
            case 1:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcCtrlModeChanged(value);
                return;
            case 2:
                if (value != 1 && value != 0) {
                    return;
                }
                onAcCycleModeChanged(value);
                return;
            case 3:
                if (value < 0 || value > 7) {
                    return;
                }
                onAcWindLevelChanged(value);
                return;
            case 4:
                if (value < 1 || value > 7) {
                    return;
                }
                onAcWindModeChanged(value);
                return;
            case 5:
                int temperatureUnit = BYDAutoAcDevice.getInstance(null).getTemperatureUnit();
                if (BYDAutoAcDevice.getInstance(null).getAcFaultNumShownState() == 2) {
                    onTemperatureChanged(1, value);
                    return;
                } else if (temperatureUnit == 0) {
                    if (value < 64 || value > 91) {
                        return;
                    }
                    onTemperatureChanged(1, value);
                    return;
                } else if (value < 17 || value > 33) {
                    return;
                } else {
                    onTemperatureChanged(1, value);
                    return;
                }
            case 6:
                int temperatureUnit2 = BYDAutoAcDevice.getInstance(null).getTemperatureUnit();
                if (BYDAutoAcDevice.getInstance(null).getAcFaultNumShownState() == 2) {
                    onTemperatureChanged(2, value);
                    return;
                } else if (temperatureUnit2 == 0) {
                    if (value < 64 || value > 91) {
                        return;
                    }
                    onTemperatureChanged(2, value);
                    return;
                } else if (value < 17 || value > 33) {
                    return;
                } else {
                    onTemperatureChanged(2, value);
                    return;
                }
            case 7:
                onTemperatureChanged(4, value);
                return;
            case 8:
                if (value != 0 && value != 1 && value != 3) {
                    return;
                }
                onAcTemperatureControlModeChanged(value);
                return;
            case 9:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcCompressorModeChanged(value);
                return;
            case 10:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcDefrostStateChanged(1, value);
                return;
            case 11:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcDefrostStateChanged(2, value);
                return;
            case 12:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcCompressorManualSignChanged(value);
                return;
            case 13:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcWindLevelManualSignChanged(value);
                return;
            case 14:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcWindModeManualSignChanged(value);
                return;
            case 15:
                if (value != 0 && value != 1) {
                    return;
                }
                onTemperatureUnitChanged(value);
                return;
            case 16:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcMaxCoolingStateChanged(value);
                return;
            case 17:
                if (value != 0 && value != 1) {
                    return;
                }
                onAcOnlineStateChanged(value);
                return;
            case 18:
                if (value != 1 && value != 0) {
                    return;
                }
                onAcVentilationStateChanged(value);
                return;
            case 19:
            case 20:
            case 26:
            case 28:
            case 36:
            case 40:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 51:
            default:
                return;
            case 21:
                if (value != 2 && value != 1) {
                    return;
                }
                onAcPromptBoxShownStateChanged(value);
                return;
            case 22:
                if (value < 0 || value > 3) {
                    return;
                }
                onAcFaultNumShownStateChanged(value);
                return;
            case 23:
                if (value != 1 && value != 0) {
                    return;
                }
                onAcWindModeShownStateChanged(value);
                return;
            case 24:
                if (value != 1 && value != 0) {
                    return;
                }
                onAcAirQualityCtrlMenuStateChanged(value);
                return;
            case 25:
                int temperatureUnit3 = BYDAutoAcDevice.getInstance(null).getTemperatureUnit();
                if (BYDAutoAcDevice.getInstance(null).getAcFaultNumShownState() == 2) {
                    onTemperatureChanged(3, value);
                    return;
                } else if (temperatureUnit3 == 0) {
                    if (value < 64 || value > 91) {
                        return;
                    }
                    onTemperatureChanged(3, value);
                    return;
                } else if (value < 17 || value > 33) {
                    return;
                } else {
                    onTemperatureChanged(3, value);
                    return;
                }
            case 27:
                if (value != 0 && value != 1 && value != 2) {
                    return;
                }
                onAcKeyActionStateChanged(value);
                return;
            case 29:
                if (value == 0) {
                    onAcRearStoped();
                    return;
                } else if (value != 1) {
                    return;
                } else {
                    onAcRearStarted();
                    return;
                }
            case 30:
                if (value < 1 || value > 5) {
                    return;
                }
                onRearAcWindModeChanged(value);
                return;
            case 31:
                if (value < 0 || value > 7) {
                    return;
                }
                onRearAcWindLevelChanged(value);
                return;
            case 32:
                if (value != 0 && value != 1) {
                    return;
                }
                onRearAcCtrlModeChanged(value);
                return;
            case 33:
                if (value != 1 && value != 0) {
                    return;
                }
                onRearAcLockStateChanged(value);
                return;
            case 34:
                if (value < 0 || value > 5) {
                    return;
                }
                onVoiceCmdResultChanged(value);
                return;
            case 35:
            case 38:
                if (value != 1 && value != 0) {
                    return;
                }
                onFeatureChanged(eventType == 35 ? BYDAutoAcDevice.FEATURE_AC_AUTO_MODE : eventType == 38 ? BYDAutoAcDevice.FEATURE_AC_REMOTE_CTL : "Default", value);
                return;
            case 37:
                if (value != 1 && value != 2) {
                    return;
                }
                onRearAcMaxWindLevelChanged(value);
                return;
            case 39:
                if (value < 1 || value > 5) {
                    return;
                }
                onAcRemoteCtrlTimeChanged(value);
                return;
            case 41:
                if (value < 0 || value > 3) {
                    return;
                }
                onAcPtcPreheatSignalChanged(value);
                return;
            case 45:
                if (value != 1 && value != 0) {
                    return;
                }
                onAcDefrostOnlineStateChanged(value);
                return;
            case 49:
                if (value != 0 && value != 1 && value != 2 && value != 3) {
                    return;
                }
                onAcWarmTypeOnlineStateChanged(value);
                return;
            case 50:
                if (value != 0 && value != 1 && value != 2) {
                    return;
                }
                onAcWarmStateChanged(value);
                return;
            case 52:
                onOtaSubBatteryTemperatureChanged(value);
                return;
        }
    }

    public void onFeatureChanged(String str, int i) {
    }

    public void onOtaSubBatteryTemperatureChanged(int i) {
    }

    public void onRearAcCtrlModeChanged(int i) {
    }

    public void onRearAcLockStateChanged(int i) {
    }

    public void onRearAcMaxWindLevelChanged(int i) {
    }

    public void onRearAcWindLevelChanged(int i) {
    }

    public void onRearAcWindModeChanged(int i) {
    }

    public void onTemperatureChanged(int i, int i2) {
    }

    public void onTemperatureUnitChanged(int i) {
    }

    public void onVoiceCmdResultChanged(int i) {
    }
}
