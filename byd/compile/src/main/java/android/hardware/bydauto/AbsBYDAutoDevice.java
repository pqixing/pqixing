//refactor
package android.hardware.bydauto;
import android.content.Context;
import android.hardware.IBYDAutoDevice;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
import java.util.ArrayList;
public abstract class AbsBYDAutoDevice implements IBYDAutoDevice {
public int get(int i, int i2) { return 0; }
public byte[] getBuffer(int i, int i2) { return null; }
public double getDouble(int i, int i2) { return 0; }
public double[] getDoubleArray(int i, int[] iArr) { return null; }
public int[] getIntArray(int i, int[] iArr) { return null; }
public boolean onPostEvent(IBYDAutoEvent iBYDAutoEvent) { return false; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(IBYDAutoListener iBYDAutoListener) { }
public int set(int i, int i2, int i3) { return 0; }
public void unregisterListener(IBYDAutoListener iBYDAutoListener) { }
public boolean postEvent(int i, int i2, double d2, Object obj) { return false; }
public boolean postEvent(int i, int i2, byte[] bArr, Object obj) { return false; }
public int set(int i, int i2, byte[] bArr) { return 0; }
public int set(int i, int i2, double d2) { return 0; }
public void registerListener(IBYDAutoListener iBYDAutoListener, int[] iArr) { }
public int set(int i, int[] iArr, int[] iArr2) { return 0; }
public int set(int i, int[] iArr, double[] dArr) { return 0; }
 }
