package android.hardware.bydauto.qcfs;

import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class BYDAutoQcfsDevice extends AbsBYDAutoDevice {
    public static final int AFTER_DOWNLOAD_UPGRADE_NO = 12;
    public static final int AFTER_DOWNLOAD_UPGRADE_NOW_YES = 11;
    public static final int AFTER_DOWNLOAD_UPGRADE_RESERVE = 13;
    public static final int BEFORE_DOWNLOAD_UPGRADE_NO = 2;
    public static final int BEFORE_DOWNLOAD_UPGRADE_YES = 1;
    private static final boolean DEBUG = true;
    public static final int FS_COND_NEW = 7;
    public static final int FS_COND_RCV_KEY = 8;
    public static final int FS_COND_UPGRADE = 9;
    public static final int FS_CONFIRM = 2;
    public static final int FS_FEEDBACK_FAKEOK_ENTERING = 1;
    public static final int FS_FEEDBACK_TRUE = 0;
    public static final int FS_KEY = 3;
    public static final int FS_KEY_ID = 10;
    public static final int FS_STATUS_ALL = 4;
    public static final int FS_STATUS_OTA = 11;
    public static final int FS_STATUS_QC = 6;
    public static final int FS_STATUS_SECURE_IC = 5;
    public static final int FS_VER = 1;
    public static final int FS_VER_DID = 12;
    public static final int QCFS_COMMAND_BUSY = -2147482647;
    public static final int QCFS_COMMAND_FAILED = -2147482648;
    public static final int QCFS_COMMAND_INVALID_VALUE = -2147482645;
    public static final int QCFS_COMMAND_SUCCESS = 0;
    public static final int QCFS_COMMAND_TIMEOUT = -2147482646;
    static final String QCFS_GET_PERM = "android.permission.BYDAUTO_QCFS_GET";
    static final String QCFS_SET_PERM = "android.permission.BYDAUTO_QCFS_SET";
    public static final int QCFS_WAIT_UPGRADE_NO = 0;
    public static final int QCFS_WAIT_UPGRADE_YES = 1;
    public static final int QC_REBOOT_CONFIRM_UPGRADE_END = 4;
    public static final int QC_UPGRADE_BEGIN = 2;
    public static final int QC_UPGRADE_END = 3;
    public static final int QC_WILL_GOTO_RECOVERY = 1;
    public static final int SECURE_IC_UPGRADE_BEGIN = 1;
    public static final int SECURE_IC_UPGRADE_END = 2;
    public static final int SECURE_IC_UPGRADE_ERROR = 3;
    public static final int SEND_KEY = 3;
    public static final int SEND_KEY_BEGIN = 1;
    public static final int SEND_KEY_END = 2;
    protected static final String TAG = "BYDAutoQcfsDevice";
    private static int mDeviceType = 1036;
    private static BYDAutoQcfsDevice mInstance;
    private final Context mContext;

    private BYDAutoQcfsDevice(Context context) {
        super(context);
        this.mContext = context;
    }

    public static synchronized BYDAutoQcfsDevice getInstance(Context context) {
        BYDAutoQcfsDevice bYDAutoQcfsDevice;
        synchronized (BYDAutoQcfsDevice.class) {
            if (mInstance == null) {
                mInstance = new BYDAutoQcfsDevice(context);
            }
            bYDAutoQcfsDevice = mInstance;
        }
        return bYDAutoQcfsDevice;
    }

    public void getAllStatus() {
    }

    @Override // android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        return null;
    }

    @Override // android.hardware.IBYDAutoDevice
    public int getType() {
        return BYDAutoConstants.BYDAUTO_DEVICE_QCFS;
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, byte[] bArr, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + Arrays.toString(bArr));
        return onPostEvent(new BYDAutoQcfsEvent(i, i2, bArr, obj));
    }

    public int qurCondNewVer(byte[] bArr) {
        Log.d(TAG, "qurCondNewVer.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        return super.set(mDeviceType, 7, bArr);
    }

    public int qurCondRcvKey() {
        Log.d(TAG, "qurCondRcvKey.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        return super.set(mDeviceType, 8, 8);
    }

    public int qurCondUpgrade() {
        Log.d(TAG, "qurCondUpgrade.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        return super.set(mDeviceType, 9, 9);
    }

    public int qurEcuVersion() {
        Log.d(TAG, "queryEcuVersion.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        return super.set(mDeviceType, 1, 1);
    }

    public int qurFsCondFakeok() {
        Log.d(TAG, "qurFsCondFakeok.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        return super.set(mDeviceType, 11, 11);
    }

    public void registerListener(AbsBYDAutoQcfsListener absBYDAutoQcfsListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(QCFS_GET_PERM, null);
        if (absBYDAutoQcfsListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoQcfsListener);
        }
    }

    public int reqSpecifiedEcuVersion(byte[] bArr) {
        Log.d(TAG, "reqSpecifiedEcuVersion.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        return super.set(mDeviceType, 12, bArr);
    }

    public int sendKeyToFs(byte[] bArr) {
        Log.d(TAG, "setAllUpgradeStatus.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        if (bArr.length != 1 && bArr.length != 19) {
            Log.d(TAG, "sendKeyToFs size error:" + bArr.length);
            return -2147482645;
        } else if (bArr[0] != 1 && bArr[0] != 2 && bArr[0] != 3) {
            Log.d(TAG, "sendKeyToFs flag error:" + ((int) bArr[0]));
            return -2147482645;
        } else {
            return super.set(mDeviceType, 3, bArr);
        }
    }

    public void setAllStatus() {
    }

    public int setAllUpgradeStatus(byte[] bArr) {
        Log.d(TAG, "setAllUpgradeStatus.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        if (bArr.length != 5) {
            Log.d(TAG, "setAllUpgradeStatus size:" + bArr.length);
            return -2147482645;
        }
        return super.set(mDeviceType, 4, bArr);
    }

    public int setQcomUpgradeStatus(int i) {
        Log.d(TAG, "setQcomUpgradeStatus.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        if (i >= 1 && i <= 4) {
            return super.set(mDeviceType, 6, i);
        }
        Log.d(TAG, "setQcomUpgradeStatus invalid:" + i);
        return -2147482645;
    }

    public int setSecureIcUpgradeStatus(int i) {
        Log.d(TAG, "setSecureIcUpgradeStatus.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        if (i >= 1 && i <= 3) {
            return super.set(mDeviceType, 5, i);
        }
        Log.d(TAG, "setSecureIcUpgradeStatus invalid:" + i);
        return -2147482645;
    }

    public int setUserConfirm(int i) {
        Log.d(TAG, "setUserConfirm.");
        this.mContext.enforceCallingOrSelfPermission(QCFS_SET_PERM, null);
        if (i == 1 || i == 2 || i == 11 || i == 12 || i == 13) {
            return super.set(mDeviceType, 2, i);
        }
        return -2147482645;
    }

    public void unregisterListener(AbsBYDAutoQcfsListener absBYDAutoQcfsListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(QCFS_GET_PERM, null);
        if (absBYDAutoQcfsListener != null) {
            super.unregisterListener((IBYDAutoListener) absBYDAutoQcfsListener);
        }
    }

    public void registerListener(AbsBYDAutoQcfsListener absBYDAutoQcfsListener, int[] iArr) {
        Log.i(TAG, "registerListener2");
        this.mContext.enforceCallingOrSelfPermission(QCFS_GET_PERM, null);
        if (absBYDAutoQcfsListener != null) {
            super.registerListener((IBYDAutoListener) absBYDAutoQcfsListener, iArr);
        }
    }

    @Override // android.hardware.bydauto.AbsBYDAutoDevice, android.hardware.IBYDAutoDevice
    public boolean postEvent(int i, int i2, int i3, Object obj) {
        Log.d(TAG, "postEvent device_type: " + i + ", event_type =" + i2 + ", value = " + i3);
        return onPostEvent(new BYDAutoEvent(i, i2, i3, obj));
    }
}
