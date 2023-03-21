package android.hardware.bydauto.instrument;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoInstrumentListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoInstrumentListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onAlarmBuzzleStateChange(int i) {
    }

    public void onAverageSpeedChanged(int i) {
    }

    public void onBacklightBrightnessChanged(int i) {
    }

    public void onBacklightModeStateChanged(int i, int i2) {
    }

    public void onCallInfoResultChanged(int i) {
    }

    @Override // android.hardware.IBYDAutoListener
    public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) {
        int i;
        int i2;
        a parse = parse(iBYDAutoEvent.getData());
        int value = iBYDAutoEvent.getValue();
        int eventType = iBYDAutoEvent.getEventType();
        Log.d(TAG, "onDataChanged: type is " + eventType + " value is " + value);
        if (parse != null) {
            Log.d(TAG, "onDataChanged: data is " + parse);
        }
        switch (eventType) {
            case 0:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(1, value);
                return;
            case 1:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(2, value);
                return;
            case 2:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(3, value);
                return;
            case 3:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(4, value);
                return;
            case 4:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(5, value);
                return;
            case 5:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(6, value);
                return;
            case 6:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(7, value);
                return;
            case 7:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(8, value);
                return;
            case 8:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(9, value);
                return;
            case 9:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(10, value);
                return;
            case 10:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(11, value);
                return;
            case 11:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(12, value);
                return;
            case 12:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(13, value);
                return;
            case 13:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(14, value);
                return;
            case 14:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(15, value);
                return;
            case 15:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(16, value);
                return;
            case 16:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(17, value);
                return;
            case 17:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(18, value);
                return;
            case 18:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(19, value);
                return;
            case 19:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(20, value);
                return;
            case 20:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(21, value);
                return;
            case 21:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(22, value);
                return;
            case 22:
                if (value != 0 && value != 1) {
                    return;
                }
                onMalfunctionInfoChanged(23, value);
                return;
            case 23:
                if (value != 1 && value != 0) {
                    return;
                }
                onBacklightModeStateChanged(1, value);
                return;
            case 24:
                if (value < 1 || value > 11) {
                    return;
                }
                onBacklightBrightnessChanged(value);
                return;
            case 25:
            case 26:
            case 27:
            case 28:
                if (eventType == 25) {
                    if (value != 1 && value != 2) {
                        return;
                    }
                    i = 1;
                } else if (eventType == 26) {
                    if (value != 1 && value != 2 && value != 3) {
                        return;
                    }
                    i = 2;
                } else if (eventType == 27) {
                    if (value < 1 || value > 6) {
                        return;
                    }
                    i = 3;
                } else if (eventType != 28) {
                    i = 0;
                } else if (value != 0 && value != 1 && value != 2) {
                    return;
                } else {
                    i = 4;
                }
                onUnitChanged(i, value);
                return;
            case 29:
            case 30:
                if (eventType == 29) {
                    if (value < 0 || value > 991) {
                        return;
                    }
                    i2 = 1;
                } else if (eventType != 30) {
                    i2 = 0;
                } else if (value < 0 || value > 20001) {
                    return;
                } else {
                    i2 = 2;
                }
                onMaintenanceInfoChanged(i2, value);
                return;
            case 31:
                if (value != 1 && value != 0) {
                    return;
                }
                onBacklightModeStateChanged(2, value);
                return;
            case 32:
                if (value != 1 && value != 0) {
                    return;
                }
                onAlarmBuzzleStateChange(value);
                return;
            default:
                switch (eventType) {
                    case 45:
                        if (value < 0 || value > 2) {
                            return;
                        }
                        onMusicInfoResultChanged(value);
                        return;
                    case 46:
                        if (value < 0 || value > 2) {
                            return;
                        }
                        onCallInfoResultChanged(value);
                        return;
                    case 47:
                        if (value < 0 || value > 2) {
                            return;
                        }
                        onRadioInfoResultChanged(value);
                        return;
                    case 48:
                        if (value < 0 || value > 11) {
                            return;
                        }
                        onPowerOnErrInfoChanged(value);
                        return;
                    case 49:
                        if (value < 0 || value > 6) {
                            return;
                        }
                        onPowerOffErrInfoChanged(value);
                        return;
                    case 50:
                        if (value != 1 && value != 2) {
                            return;
                        }
                        onRemoteDrivingReminderChanged(value);
                        return;
                    case 51:
                        if (value != 0 && value != 1 && value != 2) {
                            return;
                        }
                        onKeyDetectionReminderChanged(value);
                        return;
                    case 52:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(24, value);
                        return;
                    case 53:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(25, value);
                        return;
                    case 54:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(26, value);
                        return;
                    case 55:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(27, value);
                        return;
                    case 56:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(28, value);
                        return;
                    case 57:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(29, value);
                        return;
                    case 58:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(30, value);
                        return;
                    case 59:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(31, value);
                        return;
                    case 60:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(32, value);
                        return;
                    case 61:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(33, value);
                        return;
                    case 62:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(34, value);
                        return;
                    case 63:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(35, value);
                        return;
                    case 64:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(36, value);
                        return;
                    case 65:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(37, value);
                        return;
                    case 66:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(38, value);
                        return;
                    case 67:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(39, value);
                        return;
                    case 68:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(40, value);
                        return;
                    case 69:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(41, value);
                        return;
                    case 70:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(42, value);
                        return;
                    case 71:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(43, value);
                        return;
                    case 72:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(44, value);
                        return;
                    case 73:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(45, value);
                        return;
                    case 74:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(46, value);
                        return;
                    case 75:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onMalfunctionInfoChanged(47, value);
                        return;
                    case 76:
                        if (value < 0 || value > 240) {
                            return;
                        }
                        onAverageSpeedChanged(value);
                        return;
                    case 77:
                        double doubleValue = iBYDAutoEvent.getDoubleValue();
                        if (doubleValue < 0.0d || doubleValue > 10000.0d) {
                            return;
                        }
                        onExternalChargingPowerChanged(doubleValue);
                        return;
                    default:
                        switch (eventType) {
                            case 85:
                                if (value != 0 && value != 1) {
                                    return;
                                }
                                onMalfunctionInfoChanged(48, value);
                                return;
                            case 86:
                                if (value != 0 && value != 1) {
                                    return;
                                }
                                onMalfunctionInfoChanged(49, value);
                                return;
                            case 87:
                                if (value != 0 && value != 1) {
                                    return;
                                }
                                onMalfunctionInfoChanged(50, value);
                                return;
                            case 88:
                                if (value != 0 && value != 1) {
                                    return;
                                }
                                onMalfunctionInfoChanged(51, value);
                                return;
                            case 89:
                                if (value != 0 && value != 1) {
                                    return;
                                }
                                onMalfunctionInfoChanged(52, value);
                                return;
                            case 90:
                                if (value != 0 && value != 1) {
                                    return;
                                }
                                onMalfunctionInfoChanged(53, value);
                                return;
                            case 91:
                                if (value != 0 && value != 1) {
                                    return;
                                }
                                onMalfunctionInfoChanged(54, value);
                                return;
                            default:
                                switch (eventType) {
                                    case 100:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(1, value);
                                        return;
                                    case 101:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(2, value);
                                        return;
                                    case 102:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(3, value);
                                        return;
                                    case 103:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(4, value);
                                        return;
                                    case 104:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(5, value);
                                        return;
                                    case 105:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(6, value);
                                        return;
                                    case 106:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(7, value);
                                        return;
                                    case 107:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(8, value);
                                        return;
                                    case 108:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(9, value);
                                        return;
                                    case 109:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(10, value);
                                        return;
                                    case 110:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(11, value);
                                        return;
                                    case 111:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(12, value);
                                        return;
                                    case 112:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(13, value);
                                        return;
                                    case 113:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(14, value);
                                        return;
                                    case 114:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(15, value);
                                        return;
                                    case 115:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(16, value);
                                        return;
                                    case 116:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(17, value);
                                        return;
                                    case 117:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(18, value);
                                        return;
                                    case 118:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(19, value);
                                        return;
                                    case 119:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(20, value);
                                        return;
                                    case 120:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(21, value);
                                        return;
                                    case 121:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(22, value);
                                        return;
                                    case 122:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(23, value);
                                        return;
                                    case 123:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(24, value);
                                        return;
                                    case 124:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(25, value);
                                        return;
                                    case 125:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(26, value);
                                        return;
                                    case 126:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(27, value);
                                        return;
                                    case 127:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(28, value);
                                        return;
                                    case 128:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(29, value);
                                        return;
                                    case 129:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(30, value);
                                        return;
                                    case 130:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(31, value);
                                        return;
                                    case 131:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(32, value);
                                        return;
                                    case 132:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(33, value);
                                        return;
                                    case 133:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(34, value);
                                        return;
                                    case 134:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(35, value);
                                        return;
                                    case 135:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(36, value);
                                        return;
                                    case 136:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(37, value);
                                        return;
                                    case 137:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(38, value);
                                        return;
                                    case 138:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(39, value);
                                        return;
                                    case 139:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(40, value);
                                        return;
                                    case 140:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(41, value);
                                        return;
                                    case 141:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(42, value);
                                        return;
                                    case 142:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(43, value);
                                        return;
                                    case 143:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(44, value);
                                        return;
                                    case 144:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(45, value);
                                        return;
                                    case 145:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(46, value);
                                        return;
                                    case 146:
                                        if (value != 0 && value != 1) {
                                            return;
                                        }
                                        onMalfunctionInfoChanged2(47, value);
                                        return;
                                    case 147:
                                        if (value < 0 || value > 2) {
                                            return;
                                        }
                                        onInstrumentScreenTypeChanged(value);
                                        return;
                                    default:
                                        switch (eventType) {
                                            case 163:
                                                if (value != 0 && value != 1) {
                                                    return;
                                                }
                                                onMalfunctionInfoChanged(55, value);
                                                return;
                                            case 164:
                                                if (value != 0 && value != 1) {
                                                    return;
                                                }
                                                onMalfunctionInfoChanged(56, value);
                                                return;
                                            case 165:
                                                if (value != 0 && value != 1) {
                                                    return;
                                                }
                                                onMalfunctionInfoChanged(57, value);
                                                return;
                                            case 166:
                                                if (value != 0 && value != 1) {
                                                    return;
                                                }
                                                onMalfunctionInfoChanged(58, value);
                                                return;
                                            default:
                                                return;
                                        }
                                }
                        }
                }
        }
    }

    public void onExternalChargingPowerChanged(double d2) {
    }

    public void onInstrumentScreenTypeChanged(int i) {
    }

    public void onKeyDetectionReminderChanged(int i) {
    }

    public void onMaintenanceInfoChanged(int i, int i2) {
    }

    public void onMalfunctionInfoChanged(int i, int i2) {
    }

    public void onMalfunctionInfoChanged2(int i, int i2) {
    }

    public void onMusicInfoResultChanged(int i) {
    }

    public void onPowerOffErrInfoChanged(int i) {
    }

    public void onPowerOnErrInfoChanged(int i) {
    }

    public void onRadioInfoResultChanged(int i) {
    }

    public void onRemoteDrivingReminderChanged(int i) {
    }

    public void onUnitChanged(int i, int i2) {
    }
}
