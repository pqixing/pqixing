package android.hardware.bydauto.doormirror;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class BYDAutoRearViewMirrorDevice extends AbsBYDAutoDevice {
    private static final boolean DEBUG = true;
    public static final int REAR_VIEW_MIRROR_ANTIGLARE_STATE = 2;
    public static final int REAR_VIEW_MIRROR_ANTIGLARE_STATE_INVALID = 0;
    public static final int REAR_VIEW_MIRROR_ANTIGLARE_STATE_MILD = 1;
    public static final int REAR_VIEW_MIRROR_ANTIGLARE_STATE_MODERATE = 2;
    public static final int REAR_VIEW_MIRROR_ANTIGLARE_STATE_SERIOUS = 3;
    public static final int REAR_VIEW_MIRROR_COMMAND_BUSY = -2147482647;
    public static final int REAR_VIEW_MIRROR_COMMAND_FAILED = -2147482648;
    public static final int REAR_VIEW_MIRROR_COMMAND_INVALID = -2147482645;
    public static final int REAR_VIEW_MIRROR_COMMAND_SUCCESS = 0;
    public static final int REAR_VIEW_MIRROR_COMMAND_TIMEOUT = -2147482646;
    public static final int REAR_VIEW_MIRROR_FOLD = 1;
    static final String REAR_VIEW_MIRROR_GET_PERM = "android.permission.BYDAUTO_REAR_VIEW_MIRROR_GET";
    public static final int REAR_VIEW_MIRROR_NO_ACTION = 0;
    static final String REAR_VIEW_MIRROR_SET_PERM = "android.permission.BYDAUTO_REAR_VIEW_MIRROR_SET";
    public static final int REAR_VIEW_MIRROR_STATE = 1;
    public static final int REAR_VIEW_MIRROR_UNFOLD = 2;
    protected static final String TAG = "BYDAutoRearViewMirrorDevice";
    private static int mDeviceType = 1047;
    private static BYDAutoRearViewMirrorDevice mInstance;
    private final Context mContext;

    private BYDAutoRearViewMirrorDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoRearViewMirrorDevice getInstance(Context context) {
        BYDAutoRearViewMirrorDevice bYDAutoRearViewMirrorDevice;
        synchronized (BYDAutoRearViewMirrorDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoRearViewMirrorDevice(context);
            }
            bYDAutoRearViewMirrorDevice = mInstance;
        }
        return bYDAutoRearViewMirrorDevice;
    }

    public int getAutoExternalRearMirrorAntiglareState() {
        this.mContext.enforceCallingOrSelfPermission(REAR_VIEW_MIRROR_GET_PERM, null);
        int i = super.get(mDeviceType, 2);
        Log.d(TAG, "getAutoExternalRearMirrorAntiglareState result is: " + i);
        return i;
    }

    public int getAutoExternalRearMirrorState() {
        this.mContext.enforceCallingOrSelfPermission(REAR_VIEW_MIRROR_GET_PERM, null);
        int i = super.get(mDeviceType, 1);
        Log.d(TAG, "getAutoExternalRearMirrorState result is: " + i);
        return i;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_REAR_VIEW_MIRROR;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }

    public void registerListener(AbsBYDAutoRearViewMirrorListener absBYDAutoRearViewMirrorListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(REAR_VIEW_MIRROR_GET_PERM, null);
        if (absBYDAutoRearViewMirrorListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoRearViewMirrorListener);
        }
    }

    public void unregisterListener(AbsBYDAutoRearViewMirrorListener absBYDAutoRearViewMirrorListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(REAR_VIEW_MIRROR_GET_PERM, null);
        if (absBYDAutoRearViewMirrorListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoRearViewMirrorListener);
        }
    }

    public void registerListener(AbsBYDAutoRearViewMirrorListener absBYDAutoRearViewMirrorListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(REAR_VIEW_MIRROR_GET_PERM, null);
        if (absBYDAutoRearViewMirrorListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoRearViewMirrorListener, iArr);
        }
    }
}
