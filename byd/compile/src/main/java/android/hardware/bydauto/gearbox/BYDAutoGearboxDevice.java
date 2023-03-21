package android.hardware.bydauto.gearbox;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoGearboxDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int EPB_STATE_APPLIED = 3;
    public static final int EPB_STATE_APPLYING = 2;
    public static final int EPB_STATE_FAULT = 4;
    public static final int EPB_STATE_RELEASED = 1;
    public static final int EPB_STATE_RELEASING = 0;
    public static final int GEARBOX_AUTO_MODE_D = 4;
    public static final int GEARBOX_AUTO_MODE_M = 5;
    public static final int GEARBOX_AUTO_MODE_N = 3;
    public static final int GEARBOX_AUTO_MODE_P = 1;
    public static final int GEARBOX_AUTO_MODE_R = 2;
    public static final int GEARBOX_AUTO_MODE_S = 6;
    public static final int GEARBOX_AUTO_MODE_TYPE = 2;
    public static final int GEARBOX_BRAKE_FLUID_LEVEL = 4;
    public static final int GEARBOX_BRAKE_FLUID_LEVEL_LOW = 1;
    public static final int GEARBOX_BRAKE_FLUID_LEVEL_NORMAL = 2;
    public static final int GEARBOX_BRAKE_PEDAL = 6;
    public static final int GEARBOX_BREAK_PADAL_NOT_PRESS = 2;
    public static final int GEARBOX_BREAK_PADAL_PRESS = 1;
    public static final int GEARBOX_CODE = 8;
    public static final String GEARBOX_CODE_0 = "DABS15-41";
    public static final String GEARBOX_CODE_1 = "F4A4";
    public static final String GEARBOX_CODE_10 = "5RT14";
    public static final String GEARBOX_CODE_11 = "6T25";
    public static final String GEARBOX_CODE_12 = "6DT25";
    public static final String GEARBOX_CODE_13 = "6DT33";
    public static final String GEARBOX_CODE_14 = "6T18";
    public static final String GEARBOX_CODE_15 = "6DT35";
    public static final String GEARBOX_CODE_16 = "AF636";
    public static final String GEARBOX_CODE_17 = "AF640";
    public static final String GEARBOX_CODE_18 = "F625";
    public static final String GEARBOX_CODE_2 = "F4A4B";
    public static final String GEARBOX_CODE_3 = "VT2-04O";
    public static final String GEARBOX_CODE_4 = "SSG";
    public static final String GEARBOX_CODE_5 = "5T09";
    public static final String GEARBOX_CODE_6 = "5T14";
    public static final String GEARBOX_CODE_7 = "5T19";
    public static final String GEARBOX_CODE_8 = "5T19-1";
    public static final String GEARBOX_CODE_9 = "5RT10";
    public static final int GEARBOX_COMMAND_BUSY = -2147482647;
    public static final int GEARBOX_COMMAND_FAILED = -2147482648;
    public static final int GEARBOX_COMMAND_INVALID_VALUE = -2147482645;
    public static final int GEARBOX_COMMAND_SUCCESS = 0;
    public static final int GEARBOX_COMMAND_TIMEOUT = -2147482646;
    public static final int GEARBOX_EPB_STATE = 9;
    private static final String GEARBOX_GET_PERM = "android.permission.BYDAUTO_GEARBOX_GET";
    public static final int GEARBOX_MANUAL_MODE_LEVEL = 3;
    public static final int GEARBOX_PARK_BRAKE_SWITCH = 5;
    public static final int GEARBOX_PARK_BREAK_SWITCH_INVALID = 0;
    public static final int GEARBOX_PARK_BREAK_SWITCH_VALID = 1;
    public static final int GEARBOX_REAL_LEVEL_D = 0;
    public static final int GEARBOX_REAL_LEVEL_N = 2;
    public static final int GEARBOX_REAL_LEVEL_R = 1;
    public static final int GEARBOX_STATE = 7;
    public static final int GEARBOX_STATE_OFF = 0;
    public static final int GEARBOX_STATE_ON = 1;
    public static final int GEARBOX_TYPE = 1;
    public static final int GEARBOX_TYPE_AMT = 1;
    public static final int GEARBOX_TYPE_AT = 2;
    public static final int GEARBOX_TYPE_CVT = 3;
    public static final int GEARBOX_TYPE_DCT = 4;
    public static final int GEARBOX_TYPE_INVALID = 255;
    public static final int GEARBOX_TYPE_INVALID1 = 5;
    public static final int GEARBOX_TYPE_INVALID2 = 6;
    public static final int GEARBOX_TYPE_MT = 0;
    public static final int GEARBOX_TYPE_NONE = 7;
    protected static final String TAG = "BYDAutoGearboxDevice";
    private static int mDeviceType = 1011;
    private static BYDAutoGearboxDevice mInstance;
    private final Context mContext;

    private BYDAutoGearboxDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoGearboxDevice getInstance(Context context) {
        BYDAutoGearboxDevice bYDAutoGearboxDevice;
        synchronized (BYDAutoGearboxDevice.class) {
            if (mInstance == null && context != null) {
                mInstance = new BYDAutoGearboxDevice(context);
            }
            bYDAutoGearboxDevice = mInstance;
        }
        return bYDAutoGearboxDevice;
    }

    public void getAllStatus() {
    }

    public int getBrakeFluidLevel() {
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        int i = super.get(mDeviceType, 4);
        Log.d(TAG, "getBrakeFluidLevel state is: " + i);
        return i;
    }

    public int getBrakePedalState() {
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        int i = super.get(mDeviceType, 6);
        Log.d(TAG, "getBrakePedalState state is: " + i);
        return i;
    }

    public int getEPBState() {
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        int i = super.get(mDeviceType, 9);
        Log.d(TAG, "getEPBState: state is " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getGearboxAutoModeType() {
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getGearboxAutoModeType type is: " + i);
        return i;
    }

    public String getGearboxCode() {
        String str;
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        int i = super.get(mDeviceType, 8);
        Log.d(TAG, "getGearboxCode code is: " + i);
        switch (i) {
            case 0:
                str = GEARBOX_CODE_0;
                break;
            case 1:
                str = GEARBOX_CODE_1;
                break;
            case 2:
                str = GEARBOX_CODE_2;
                break;
            case 3:
                str = GEARBOX_CODE_3;
                break;
            case 4:
                str = GEARBOX_CODE_4;
                break;
            case 5:
                str = GEARBOX_CODE_5;
                break;
            case 6:
                str = GEARBOX_CODE_6;
                break;
            case 7:
                str = GEARBOX_CODE_7;
                break;
            case 8:
                str = GEARBOX_CODE_8;
                break;
            case 9:
                str = GEARBOX_CODE_9;
                break;
            case 10:
                str = GEARBOX_CODE_10;
                break;
            case 11:
                str = GEARBOX_CODE_11;
                break;
            case 12:
                str = GEARBOX_CODE_12;
                break;
            case 13:
                str = GEARBOX_CODE_13;
                break;
            case 14:
                str = GEARBOX_CODE_14;
                break;
            case 15:
                str = GEARBOX_CODE_15;
                break;
            case 16:
                str = GEARBOX_CODE_16;
                break;
            case 17:
                str = GEARBOX_CODE_17;
                break;
            case 18:
                str = GEARBOX_CODE_18;
                break;
            default:
                return "NULL";
        }
        Log.d(TAG, "getGearboxCode: The name is " + str);
        return str;
    }

    public int getGearboxManualModeLevel() {
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        int i = super.get(mDeviceType, 3);
        Log.d(TAG, "getGearboxManualModeLevel level is: " + i);
        return i;
    }

    public int getGearboxState() {
        return getParkBrakeSwitch();
    }

    public int getGearboxType() {
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getGearboxType type is: " + i);
        return i;
    }

    public int getParkBrakeSwitch() {
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        int i = super.get(mDeviceType, 5);
        Log.d(TAG, "getParkBrakeSwitch state is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return 1011;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (2 == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (1 == r0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isInReverseGear() {
        /*
            r6 = this;
            android.content.Context r0 = r6.mContext
            java.lang.String r1 = "android.permission.BYDAUTO_GEARBOX_GET"
            r2 = 0
            r0.enforceCallingOrSelfPermission(r1, r2)
            int r0 = android.hardware.bydauto.gearbox.BYDAutoGearboxDevice.mDeviceType
            r1 = 1
            int r0 = super.get(r0, r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "isInReverseGear gearboxtype is: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "BYDAutoGearboxDevice"
            android.util.Log.d(r3, r2)
            r2 = 3
            r4 = 0
            if (r0 == 0) goto L40
            r5 = 2
            if (r0 == r1) goto L37
            if (r0 == r5) goto L37
            if (r0 == r2) goto L37
            r2 = 4
            if (r0 == r2) goto L37
            r2 = 7
            if (r0 == r2) goto L37
            goto L4a
        L37:
            int r0 = android.hardware.bydauto.gearbox.BYDAutoGearboxDevice.mDeviceType
            int r0 = super.get(r0, r5)
            if (r5 != r0) goto L49
            goto L48
        L40:
            int r0 = android.hardware.bydauto.gearbox.BYDAutoGearboxDevice.mDeviceType
            int r0 = super.get(r0, r2)
            if (r1 != r0) goto L49
        L48:
            r4 = r1
        L49:
            r1 = r0
        L4a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "isInReverseGear level is: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isInReverseGear isReverse: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r3, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.hardware.bydauto.gearbox.BYDAutoGearboxDevice.isInReverseGear():boolean");
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoGearboxListener absBYDAutoGearboxListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        if (absBYDAutoGearboxListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoGearboxListener);
        }
    }

    public void setAllStatus() {
    }

    public void unregisterListener(AbsBYDAutoGearboxListener absBYDAutoGearboxListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        if (absBYDAutoGearboxListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoGearboxListener);
        }
    }

    public void registerListener(AbsBYDAutoGearboxListener absBYDAutoGearboxListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(GEARBOX_GET_PERM, null);
        if (absBYDAutoGearboxListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoGearboxListener, iArr);
        }
    }
}
