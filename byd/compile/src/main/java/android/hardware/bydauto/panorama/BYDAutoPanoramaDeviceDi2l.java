package android.hardware.bydauto.panorama;

import android.content.Context;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.panorama.IBYDAutoPanoListener;
import android.hardware.bydauto.panorama.IBYDAutoPanoService;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import com.iflytek.speech.libissse;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class BYDAutoPanoramaDeviceDi2l extends BYDAutoPanoramaDevice {
    private static final boolean DEBUG = true;
    protected static final String TAG = "BYDAutoPanoramaDeviceDi2l";
    private static int mDeviceType = 1031;
    private final Context mContext;
    private a mListener;
    private IBYDAutoPanoService mPanoService;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends IBYDAutoPanoListener.Stub {
        private Context a;

        /* renamed from: b */
        BYDAutoPanoramaDevice f6b;

        a(Context context, BYDAutoPanoramaDevice bYDAutoPanoramaDevice) {
            this.a = null;
            this.f6b = null;
            this.a = context;
            this.f6b = bYDAutoPanoramaDevice;
        }

        @Override // android.hardware.bydauto.panorama.IBYDAutoPanoListener
        public String getPackageName() throws RemoteException {
            Context context = this.a;
            if (context != null) {
                return context.getPackageName();
            }
            return null;
        }

        @Override // android.hardware.bydauto.panorama.IBYDAutoPanoListener
        public String getProperty(String str) throws RemoteException {
            return null;
        }

        @Override // android.hardware.bydauto.panorama.IBYDAutoPanoListener
        public boolean onBufferValueChanged(int i, byte[] bArr) throws RemoteException {
            BYDAutoPanoramaDevice bYDAutoPanoramaDevice = this.f6b;
            if (bYDAutoPanoramaDevice != null) {
                return bYDAutoPanoramaDevice.postEvent(BYDAutoConstants.BYDAUTO_DEVICE_PANORAMA, i, bArr, (Object) null);
            }
            return false;
        }

        @Override // android.hardware.bydauto.panorama.IBYDAutoPanoListener
        public boolean onIntValueChanged(int i, int i2) throws RemoteException {
            BYDAutoPanoramaDevice bYDAutoPanoramaDevice = this.f6b;
            if (bYDAutoPanoramaDevice != null) {
                return bYDAutoPanoramaDevice.postEvent(BYDAutoConstants.BYDAUTO_DEVICE_PANORAMA, i, i2, (Object) null);
            }
            return false;
        }

        @Override // android.hardware.bydauto.panorama.IBYDAutoPanoListener
        public boolean onMapValueChanged(int i, Map map) throws RemoteException {
            Log.e(BYDAutoPanoramaDeviceDi2l.TAG, "onMapValueChanged: not support now.");
            return false;
        }
    }

    public BYDAutoPanoramaDeviceDi2l(Context context) {
        super(context);
        this.mPanoService = null;
        this.mListener = null;
        this.mContext = context;
        this.mPanoService = IBYDAutoPanoService.Stub.asInterface();
        Log.d(TAG, "BYDAutoPanoramaDeviceDi2l: mPanoService is " + this.mPanoService);
        if (this.mPanoService != null) {
            try {
                a aVar = new a(context, this);
                this.mListener = aVar;
                this.mPanoService.registerUser(aVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getACUState() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getACUState: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(19);
            Log.d(TAG, "getACUState is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getBackLineConfig() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getBackLineConfig: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(7);
            Log.d(TAG, "getBackLineConfig is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getCarInfo() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getCarInfo: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(21);
            Log.d(TAG, "getCarInfo is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getDisplayMode() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getDisplayMode: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(15);
            Log.d(TAG, "getDisplayMode is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getEmergencyButtonState() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getEmergencyButtonState: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(18);
            Log.d(TAG, "getEmergencyButtonState is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice, android.hardware.IBYDAutoDevice
    public int[] getFeatureList() {
        Log.e(TAG, "getFeatureList: not supportted!");
        return null;
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getLVDSState() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getLVDSState: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(16);
            Log.d(TAG, "getLVDSState is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getPanoOutputSignal() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getPanoOutputSignal: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(6);
            Log.d(TAG, "getPanoOutputSignal is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getPanoOutputState() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getPanoOutputState: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(5);
            Log.d(TAG, "getPanoOutputState is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getPanoRotation() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getPanoRotation: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(9);
            Log.d(TAG, "getPanoRotation is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getPanoWorkState() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getPanoWorkState: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(4);
            Log.d(TAG, "getPanoWorkState is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getPanoramaOnlineState() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        String str = SystemProperties.get(BYDAutoPanoramaDevice.GET_PANORAMA_CAMERA);
        Log.d(TAG, "getPanoramaOnlineState is: " + str);
        if (str.contains("pano_h")) {
            return 1;
        }
        if (str.contains("pano_l")) {
            return 4;
        }
        if (str.contains("rf")) {
            return 2;
        }
        return str.contains("rvs") ? 3 : 255;
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getRFCameraSwitchState() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getRFCameraSwitchState: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(13);
            Log.d(TAG, "getRFCameraSwitchState is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int getRightCameraSwitchState() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "getRightCameraSwitchState: mPanoService is null");
            return -2147482648;
        }
        try {
            int value = iBYDAutoPanoService.getValue(13);
            Log.d(TAG, "getRightCameraSwitchState is: " + value);
            return value;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int hasFeature(String str) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_GET", null);
        if (str.equals(BYDAutoPanoramaDevice.FEATURE_ACU)) {
            IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
            if (iBYDAutoPanoService == null) {
                Log.e(TAG, "hasFeature: mPanoService is null");
                return -2147482648;
            }
            try {
                int value = iBYDAutoPanoService.getValue(20);
                Log.d(TAG, "hasFeature: If has the feature(" + str + "): " + value);
                return value;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -2147482648;
            }
        }
        return -2147482645;
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public void setAllStatus() {
        Log.e(TAG, "setAllStatus: not supportted!");
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int setDisplayMode(int i) {
        Log.d(TAG, "setDisplayMode is: " + i);
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_SET", null);
        if (i == 0 || i == 1 || i == 3) {
            IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
            if (iBYDAutoPanoService == null) {
                Log.e(TAG, "setDisplayMode: mPanoService is null");
                return -2147482648;
            }
            try {
                return iBYDAutoPanoService.setValue(15, i);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -2147482648;
            }
        }
        return -2147482645;
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int setLVDSState(int i) {
        Log.d(TAG, "setLVDSState is: " + i);
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_SET", null);
        if (i == 1 || i == 2 || i == 3) {
            IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
            if (iBYDAutoPanoService == null) {
                Log.e(TAG, "setLVDSState: mPanoService is null");
                return -2147482648;
            }
            try {
                return iBYDAutoPanoService.setValue(16, i);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -2147482648;
            }
        }
        return -2147482645;
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int setPanoFocusState(int i) {
        Log.d(TAG, "setPanoFocusState is: " + i);
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_SET", null);
        if (i == 1 || i == 0) {
            try {
                return super.set(mDeviceType, 3, i);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -2147482648;
            }
        }
        return -2147482645;
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int setPanoOperation(int i) {
        Log.d(TAG, "setPanoOperation operation is: " + i);
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_SET", null);
        if (i < 1 || i > 7) {
            return -2147482645;
        }
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "setPanoOperation: mPanoService is null");
            return -2147482648;
        }
        try {
            return iBYDAutoPanoService.setValue(2, i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int setPanoOutputState(int i) {
        Log.d(TAG, "setPanoOutputState is: " + i);
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_SET", null);
        if (i < 1 || i > 11) {
            return -2147482645;
        }
        IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
        if (iBYDAutoPanoService == null) {
            Log.e(TAG, "setPanoOutputState: mPanoService is null");
            return -2147482648;
        }
        try {
            return iBYDAutoPanoService.setValue(5, i);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int setPanoParams(int i, int i2, int i3) {
        Log.d(TAG, "setPanoParams: output=" + i + ", mode=" + i2 + ", rotation=" + i3);
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_SET", null);
        if (i < 1 || i > 11) {
            return -2147482645;
        }
        if (i2 != 0 && i2 != 1 && i2 != 3) {
            return -2147482645;
        }
        if (i3 != 1 && i3 != 2) {
            return -2147482645;
        }
        if (this.mPanoService == null) {
            Log.e(TAG, "setPanoParams: mPanoService is null");
            return -2147482648;
        }
        try {
            String[] strArr = {"5", libissse.ISS_SE_PARAM_VALUE_COMMERCIAL_VEHICAL_MAE, "9"};
            HashMap hashMap = new HashMap();
            hashMap.put("5", "" + i);
            hashMap.put(libissse.ISS_SE_PARAM_VALUE_COMMERCIAL_VEHICAL_MAE, "" + i2);
            hashMap.put("9", "" + i3);
            return this.mPanoService.setMap(strArr, hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -2147482648;
        }
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int setPanoRotation(int i) {
        Log.d(TAG, "setPanoRotation is: " + i);
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_SET", null);
        if (i == 1 || i == 2) {
            IBYDAutoPanoService iBYDAutoPanoService = this.mPanoService;
            if (iBYDAutoPanoService == null) {
                Log.e(TAG, "setPanoRotation: mPanoService is null");
                return -2147482648;
            }
            try {
                return iBYDAutoPanoService.setValue(9, i);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -2147482648;
            }
        }
        return -2147482645;
    }

    @Override // android.hardware.bydauto.panorama.BYDAutoPanoramaDevice
    public int setPanoTouchCoordinateAndShowArea(double d2, double d3, int i, double d4, double d5) {
        Log.d(TAG, "setPanoTouchPointArea x is: " + d2 + " y is:" + d3 + " operate is:" + i);
        StringBuilder sb = new StringBuilder();
        sb.append("setPanoTouchPointArea width is: ");
        sb.append(d4);
        sb.append(" height is:");
        sb.append(d5);
        Log.d(TAG, sb.toString());
        this.mContext.enforceCallingOrSelfPermission("android.permission.BYDAUTO_PANORAMA_SET", null);
        if (i == 0 || i == 2 || i == 1 || i == 3) {
            if (this.mPanoService == null) {
                Log.e(TAG, "setPanoTouchPointArea: mPanoService is null");
                return -2147482648;
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("1_x", "" + d2);
                hashMap.put("1_y", "" + d3);
                hashMap.put("1_operate", "" + i);
                hashMap.put("1_w", "" + d4);
                hashMap.put("1_h", "" + d5);
                return this.mPanoService.setMap(new String[]{"1"}, hashMap);
            } catch (Exception e2) {
                e2.printStackTrace();
                return -2147482648;
            }
        }
        return -2147482645;
    }
}
