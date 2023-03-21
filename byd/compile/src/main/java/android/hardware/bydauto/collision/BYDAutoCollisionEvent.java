package android.hardware.bydauto.collision;

import android.hardware.bydauto.BYDAutoEvent;

/* loaded from: classes.dex */
public class BYDAutoCollisionEvent extends BYDAutoEvent {
    private byte[] mBufData;

    public BYDAutoCollisionEvent(int i, int i2, int i3) {
        super(i, i2, i3);
        this.mBufData = null;
    }

    public byte[] getBufferData() {
        return this.mBufData;
    }

    public BYDAutoCollisionEvent(int i, int i2, int i3, Object obj) {
        super(i, i2, i3, obj);
        this.mBufData = null;
    }

    public BYDAutoCollisionEvent(int i, int i2, double d2) {
        super(i, i2, d2);
        this.mBufData = null;
    }

    public BYDAutoCollisionEvent(int i, int i2, double d2, Object obj) {
        super(i, i2, d2, obj);
        this.mBufData = null;
    }

    public BYDAutoCollisionEvent(int i, int i2, byte[] bArr, Object obj) {
        super(i, i2, -1, obj);
        this.mBufData = null;
        this.mBufData = bArr;
    }
}
