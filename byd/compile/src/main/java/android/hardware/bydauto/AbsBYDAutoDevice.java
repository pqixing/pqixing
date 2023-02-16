package android.hardware.bydauto;

import android.content.Context;

public abstract class AbsBYDAutoDevice {

    public AbsBYDAutoDevice(Context context) {
    }

    public int get(int i, int i2) {
        return 0;
    }

    public byte[] getBuffer(int i, int i2) {
        return null;
    }

    public double getDouble(int i, int i2) {
        return 0;
    }

    public double[] getDoubleArray(int i, int[] iArr) {
        return null;
    }

    public int[] getIntArray(int i, int[] iArr) {
        return null;
    }

    public int set(int i, int i2, int i3) {
        return 0;
    }


    public int set(int i, int i2, byte[] bArr) {
        return 0;
    }

    public int set(int i, int i2, double d) {
        return 0;
    }


    public int set(int i, int[] iArr, int[] iArr2) {
        return 0;
    }

    public int set(int i, int[] iArr, double[] dArr) {
        return 0;
    }
}
