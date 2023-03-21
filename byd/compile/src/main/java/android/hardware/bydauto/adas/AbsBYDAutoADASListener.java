package android.hardware.bydauto.adas;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbsBYDAutoADASListener implements IBYDAutoListener {
    private static final boolean DEBUG = true;
    protected static final String TAG = "AbsBYDAutoADASListener";

    /* loaded from: classes.dex */
    private class a {
    }

    private a parse(Object obj) {
        return null;
    }

    public void onAEBStateChanged(int i) {
    }

    public void onAVHStateChanged(int i) {
    }

    public void onBSDStateChanged(int i) {
    }

    public void onBrakeFootSenseStateChanged(int i) {
    }

    public void onCSTStateChanged(int i) {
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
        int i = 1;
        if (eventType == 1) {
            if (value < 0 || value > 5) {
                return;
            }
            onHMAStateChanged(value);
        } else if (eventType == 2) {
            if (value < 0 || value > 3) {
                return;
            }
            onLKSModeChanged(value);
        } else if (eventType == 3) {
            if (value != 1 && value != 0) {
                return;
            }
            onLKSSensitivityChanged(value);
        } else if (eventType == 5) {
            if (value < 0 || value > 2) {
                return;
            }
            onLDSWTypeChanged(value);
        } else if (eventType == 39) {
            if (value == 0) {
                onTJAStateChanged(0);
            } else if (value != 1 && value != 2 && value != 3) {
                onTJAStateChanged(2);
            } else {
                onTJAStateChanged(1);
            }
        } else if (eventType == 44) {
            if (value == 0) {
                onHDCStateChanged(0);
            } else if (value != 1 && value != 2) {
                onHDCStateChanged(2);
            } else {
                onHDCStateChanged(1);
            }
        } else if (eventType == 46) {
            if (value != 0 && value != 1) {
                return;
            }
            onESPKeyStateChanged(value);
        } else if (eventType == 48) {
            if (value < 0 || value > 3) {
                return;
            }
            onBrakeFootSenseStateChanged(value);
        } else if (eventType == 51) {
            if (value == 1 || value == 2) {
                onCSTStateChanged(1);
            } else if (value == 0) {
                onCSTStateChanged(0);
            } else if (value != 3) {
            } else {
                onCSTStateChanged(2);
            }
        } else {
            if (eventType != 25 && eventType != 26 && eventType != 28 && eventType != 29 && eventType != 32 && eventType != 33) {
                switch (eventType) {
                    case 8:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onPCWStateChanged(value);
                        return;
                    case 9:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onAEBStateChanged(value);
                        return;
                    case 10:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onESPStateChanged(value);
                        return;
                    case 11:
                        if (value == 0 || (value != 1 && value != 2 && value != 3)) {
                            i = 0;
                        }
                        onAVHStateChanged(i);
                        return;
                    case 12:
                        if (value < 0 || value > 2) {
                            return;
                        }
                        onIboosterStateChanged(value);
                        return;
                    case 13:
                        if (value < 0 || value > 4) {
                            return;
                        }
                        if (value != 0) {
                            if (value != 1 && value != 2 && value != 3) {
                                if (value == 4) {
                                    i = 2;
                                }
                            }
                            onSLAStateChanged(i);
                            return;
                        }
                        i = 0;
                        onSLAStateChanged(i);
                        return;
                    case 14:
                        if (value != 0 && value != 1) {
                            return;
                        }
                        onBSDStateChanged(value);
                        return;
                    default:
                        switch (eventType) {
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                break;
                            default:
                                return;
                        }
                }
            }
            if (value != 1 && value != 0) {
                return;
            }
            onFeatureChanged(eventType == 29 ? BYDAutoADASDevice.FEATURE_PCW : eventType == 28 ? BYDAutoADASDevice.FEATURE_AEB : eventType == 19 ? BYDAutoADASDevice.FEATURE_LKS_MODE : eventType == 20 ? BYDAutoADASDevice.FEATURE_LKS_SENSITIVITY : eventType == 21 ? BYDAutoADASDevice.FEATURE_LDSW : eventType == 22 ? BYDAutoADASDevice.FEATURE_BSD : eventType == 33 ? BYDAutoADASDevice.FEATURE_SLA : eventType == 32 ? BYDAutoADASDevice.FEATURE_HMA : eventType == 26 ? BYDAutoADASDevice.FEATURE_ADAS_AVH : "Default", value);
        }
    }

    public void onESPKeyStateChanged(int i) {
    }

    public void onESPStateChanged(int i) {
    }

    public void onFeatureChanged(String str, int i) {
    }

    public void onHDCStateChanged(int i) {
    }

    public void onHMAStateChanged(int i) {
    }

    public void onIboosterStateChanged(int i) {
    }

    public void onLDSWTypeChanged(int i) {
    }

    public void onLKSModeChanged(int i) {
    }

    public void onLKSSensitivityChanged(int i) {
    }

    public void onPCWStateChanged(int i) {
    }

    public void onSLAStateChanged(int i) {
    }

    public void onTJAStateChanged(int i) {
    }
}
