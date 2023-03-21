package android.hardware;

/* loaded from: classes.dex */
public interface IBYDAutoDevice {
    int[] getFeatureList();

    int getType();

    boolean onPostEvent(IBYDAutoEvent iBYDAutoEvent);

    boolean postEvent(int i, int i2, double d2, Object obj);

    boolean postEvent(int i, int i2, int i3, Object obj);

    boolean postEvent(int i, int i2, byte[] bArr, Object obj);

    void registerListener(IBYDAutoListener iBYDAutoListener);

    void unregisterListener(IBYDAutoListener iBYDAutoListener);
}
