package android.hardware.bydauto.ota;

import android.hardware.bydauto.BYDAutoEvent;

/* loaded from: classes.dex */
public class BYDAutoOtaEvent extends BYDAutoEvent {
    private byte[] mBufData;

    public BYDAutoOtaEvent(int i, int i2, byte[] bArr, Object obj) {
        super(i, i2, -1, obj);
        this.mBufData = null;
        this.mBufData = bArr;
    }

    public byte[] getBufferData() {
        return this.mBufData;
    }
}
