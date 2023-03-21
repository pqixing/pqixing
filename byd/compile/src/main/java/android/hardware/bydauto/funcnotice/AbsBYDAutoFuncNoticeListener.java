//refactor
package android.hardware.bydauto.funcnotice;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoFuncNoticeListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onFuncNoticeChanged(int i) { }
 }
