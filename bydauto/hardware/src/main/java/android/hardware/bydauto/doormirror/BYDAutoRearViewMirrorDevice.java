//refactor
package android.hardware.bydauto.doormirror;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
public final class BYDAutoRearViewMirrorDevice extends AbsBYDAutoDevice {
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
public static final int REAR_VIEW_MIRROR_NO_ACTION = 0;
public static final int REAR_VIEW_MIRROR_STATE = 1;
public static final int REAR_VIEW_MIRROR_UNFOLD = 2;
public static synchronized BYDAutoRearViewMirrorDevice getInstance(Context context) { return null; }
public int getAutoExternalRearMirrorAntiglareState() { return 0; }
public int getAutoExternalRearMirrorState() { return 0; }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoRearViewMirrorListener absBYDAutoRearViewMirrorListener) { }
public void unregisterListener(AbsBYDAutoRearViewMirrorListener absBYDAutoRearViewMirrorListener) { }
public void registerListener(AbsBYDAutoRearViewMirrorListener absBYDAutoRearViewMirrorListener, int[] iArr) { }
 }
