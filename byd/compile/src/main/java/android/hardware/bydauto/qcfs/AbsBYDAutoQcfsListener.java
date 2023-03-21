//refactor
package android.hardware.bydauto.qcfs;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.Arrays;
public abstract class AbsBYDAutoQcfsListener implements IBYDAutoListener {
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onEcuVersionInd(byte[] bArr) { }
public void onFsQurQcStateInd() { }
public void onKeyIdInd(byte[] bArr) { }
public void onNewVerUpgradeCond(int i) { }
public void onOtaStateInd(int i) { }
public void onRcvKeyCond(int i) { }
public void onUpgradeCond(int i) { }
public void onUpgradeCond(byte[] bArr) { }
 }
