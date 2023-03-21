package android.hardware.bydauto.funcnotice;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoFuncNoticeDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int FUNCNOTICE_COMMAND_BUSY = -2147482647;
    public static final int FUNCNOTICE_COMMAND_FAILED = -2147482648;
    public static final int FUNCNOTICE_COMMAND_INVALID_VALUE = -2147482645;
    public static final int FUNCNOTICE_COMMAND_SUCCESS = 0;
    public static final int FUNCNOTICE_COMMAND_TIMEOUT = -2147482646;
    static final String FUNCNOTICE_GET_PERM = "android.permission.BYDAUTO_FUNCNOTICE_GET";
    static final String FUNCNOTICE_SET_PERM = "android.permission.BYDAUTO_FUNCNOTICE_SET";
    public static final int FUNC_3RD_APP = 9;
    public static final int FUNC_APP_MENU = 8;
    public static final int FUNC_BACK = 0;
    public static final int FUNC_BL_OFF = 11;
    public static final int FUNC_MEDIA = 2;
    public static final int FUNC_NAVI = 1;
    public static final int FUNC_PANORAMA = 3;
    public static final int FUNC_PHONE = 5;
    public static final int FUNC_PHONE_LINK = 4;
    public static final int FUNC_SCREENS = 10;
    public static final int FUNC_SCREEN_NOTICE = 1;
    public static final int FUNC_SETTIGN = 6;
    public static final int FUNC_STATUSBAR = 7;
    protected static final String TAG = "BYDAutoFuncNoticeDevice";
    private static int mDeviceType = 1028;
    private static BYDAutoFuncNoticeDevice mInstance;
    private final Context mContext;

    private BYDAutoFuncNoticeDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoFuncNoticeDevice getInstance(Context context) {
        BYDAutoFuncNoticeDevice bYDAutoFuncNoticeDevice;
        synchronized (BYDAutoFuncNoticeDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoFuncNoticeDevice(context);
            }
            bYDAutoFuncNoticeDevice = mInstance;
        }
        return bYDAutoFuncNoticeDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    public int getFuncNotice() {
        this.mContext.enforceCallingOrSelfPermission(FUNCNOTICE_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getFuncNotice value is : " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_FUNCNOTICE;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoFuncNoticeListener absBYDAutoFuncNoticeListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(FUNCNOTICE_GET_PERM, null);
        if (absBYDAutoFuncNoticeListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoFuncNoticeListener);
        }
    }

    public void setAllStatus() {
    }

    public int setFuncNotice(int i) {
        Log.d(TAG, "setFuncNotice value is : " + i);
        this.mContext.enforceCallingOrSelfPermission(FUNCNOTICE_SET_PERM, null);
        if (i < 1 || i > 11) {
            return -2147482645;
        }
        return super.set(mDeviceType, 1, i);
    }

    public void unregisterListener(AbsBYDAutoFuncNoticeListener absBYDAutoFuncNoticeListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(FUNCNOTICE_GET_PERM, null);
        if (absBYDAutoFuncNoticeListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoFuncNoticeListener);
        }
    }

    public void registerListener(AbsBYDAutoFuncNoticeListener absBYDAutoFuncNoticeListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(FUNCNOTICE_GET_PERM, null);
        if (absBYDAutoFuncNoticeListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoFuncNoticeListener, iArr);
        }
    }
}
