package android.hardware.bydauto.qcfs;

import android.hardware.bydauto.BYDAutoEvent;

/* loaded from: classes.dex */
public class BYDAutoQcfsEvent extends BYDAutoEvent {
    private byte[] mBufData;
    private int mEventType;

    public BYDAutoQcfsEvent(int i, int i2, int i3) {
        super(i, i2, i3);
        this.mBufData = null;
    }

    public byte[] getBufferData() {
        return this.mBufData;
    }

    public int getEvent() {
        return this.mEventType;
    }

    public BYDAutoQcfsEvent(int i, int i2, int i3, Object obj) {
        super(i, i2, i3, obj);
        this.mBufData = null;
    }

    public BYDAutoQcfsEvent(int i, int i2, double d2) {
        super(i, i2, d2);
        this.mBufData = null;
    }

    public BYDAutoQcfsEvent(int i, int i2, double d2, Object obj) {
        super(i, i2, d2, obj);
        this.mBufData = null;
    }

    public BYDAutoQcfsEvent(int i, int i2, byte[] bArr, Object obj) {
        super(i, i2, -1, obj);
        this.mBufData = null;
        this.mBufData = bArr;
        this.mEventType = i2;
    }
}
