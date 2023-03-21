package android.hardware.bydauto;

import android.hardware.IBYDAutoEvent;

/* loaded from: classes.dex */
public class BYDAutoEvent implements IBYDAutoEvent {
    private Object mData;
    private int mDeviceSubType;
    private int mDeviceType;
    private double mDoubleValue;

    public BYDAutoEvent(int i, int i2, int i3) {
        this.mDeviceType = i;
        this.mDeviceSubType = i2;
        this.mDoubleValue = i3;
        this.mData = null;
    }

    @Override // android.hardware.IBYDAutoEvent
    public Object getData() {
        return this.mData;
    }

    @Override // android.hardware.IBYDAutoEvent
    public int getDeviceType() {
        return this.mDeviceType;
    }

    @Override // android.hardware.IBYDAutoEvent
    public double getDoubleValue() {
        return this.mDoubleValue;
    }

    @Override // android.hardware.IBYDAutoEvent
    public int getEventType() {
        return this.mDeviceSubType;
    }

    @Override // android.hardware.IBYDAutoEvent
    public int getValue() {
        return (int) this.mDoubleValue;
    }

    @Override // android.hardware.IBYDAutoEvent
    public void setData(Object obj) {
        this.mData = obj;
    }

    public BYDAutoEvent(int i, int i2, int i3, Object obj) {
        this.mDeviceType = i;
        this.mDeviceSubType = i2;
        this.mDoubleValue = i3;
        this.mData = obj;
    }

    public BYDAutoEvent(int i, int i2, double d2) {
        this.mDeviceType = i;
        this.mDeviceSubType = i2;
        this.mDoubleValue = d2;
        this.mData = null;
    }

    public BYDAutoEvent(int i, int i2, double d2, Object obj) {
        this.mDeviceType = i;
        this.mDeviceSubType = i2;
        this.mDoubleValue = d2;
        this.mData = obj;
    }
}
