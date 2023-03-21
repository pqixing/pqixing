//refactor
package android.hardware.bydauto.funcnotice;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoFuncNoticeDevice extends AbsBYDAutoDevice {
public static final int FUNCNOTICE_COMMAND_BUSY = -2147482647;
public static final int FUNCNOTICE_COMMAND_FAILED = -2147482648;
public static final int FUNCNOTICE_COMMAND_INVALID_VALUE = -2147482645;
public static final int FUNCNOTICE_COMMAND_SUCCESS = 0;
public static final int FUNCNOTICE_COMMAND_TIMEOUT = -2147482646;
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
public static synchronized BYDAutoFuncNoticeDevice getInstance(Context context) { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getFuncNotice() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoFuncNoticeListener absBYDAutoFuncNoticeListener) { }
public void setAllStatus() { }
public int setFuncNotice(int i) { return 0; }
public void unregisterListener(AbsBYDAutoFuncNoticeListener absBYDAutoFuncNoticeListener) { }
public void registerListener(AbsBYDAutoFuncNoticeListener absBYDAutoFuncNoticeListener, int[] iArr) { }
 }
