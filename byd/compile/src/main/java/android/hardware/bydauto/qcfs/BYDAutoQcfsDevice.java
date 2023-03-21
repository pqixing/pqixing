//refactor
package android.hardware.bydauto.qcfs;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.util.Arrays;
public final class BYDAutoQcfsDevice extends AbsBYDAutoDevice {
public static final int AFTER_DOWNLOAD_UPGRADE_NO = 12;
public static final int AFTER_DOWNLOAD_UPGRADE_NOW_YES = 11;
public static final int AFTER_DOWNLOAD_UPGRADE_RESERVE = 13;
public static final int BEFORE_DOWNLOAD_UPGRADE_NO = 2;
public static final int BEFORE_DOWNLOAD_UPGRADE_YES = 1;
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
public static synchronized BYDAutoQcfsDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public int qurCondNewVer(byte[] bArr) { return 0; }
public int qurCondRcvKey() { return 0; }
public int qurCondUpgrade() { return 0; }
public int qurEcuVersion() { return 0; }
public int qurFsCondFakeok() { return 0; }
public void registerListener(AbsBYDAutoQcfsListener absBYDAutoQcfsListener) { }
public int reqSpecifiedEcuVersion(byte[] bArr) { return 0; }
public int sendKeyToFs(byte[] bArr) { return 0; }
public void setAllStatus() { }
public int setAllUpgradeStatus(byte[] bArr) { return 0; }
public int setQcomUpgradeStatus(int i) { return 0; }
public int setSecureIcUpgradeStatus(int i) { return 0; }
public int setUserConfirm(int i) { return 0; }
public void unregisterListener(AbsBYDAutoQcfsListener absBYDAutoQcfsListener) { }
public void registerListener(AbsBYDAutoQcfsListener absBYDAutoQcfsListener, int[] iArr) { }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
 }
