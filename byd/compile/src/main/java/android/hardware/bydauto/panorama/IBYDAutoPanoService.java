package android.hardware.bydauto.panorama;

import android.hardware.bydauto.panorama.IBYDAutoPanoListener;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import java.util.Map;

/* loaded from: classes.dex */
public interface IBYDAutoPanoService extends IInterface {
    public static final String NAME = "android.hardware.bydauto.panorama.IBYDAutoPanoService";

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IBYDAutoPanoService {
        private static final String DESCRIPTOR = "android.hardware.bydauto.panorama.IBYDAutoPanoService";
        static final int TRANSACTION_getBuffer = 3;
        static final int TRANSACTION_getValue = 1;
        static final int TRANSACTION_registerUser = 6;
        static final int TRANSACTION_setBuffer = 4;
        static final int TRANSACTION_setMap = 5;
        static final int TRANSACTION_setValue = 2;
        static final int TRANSACTION_unregisterUser = 7;

        /* loaded from: classes.dex */
        public static class a implements IBYDAutoPanoService {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // android.hardware.bydauto.panorama.IBYDAutoPanoService
            public byte[] getBuffer(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                    obtain.writeInt(i);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.hardware.bydauto.panorama.IBYDAutoPanoService
            public int getValue(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                    obtain.writeInt(i);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.hardware.bydauto.panorama.IBYDAutoPanoService
            public int registerUser(IBYDAutoPanoListener iBYDAutoPanoListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                    obtain.writeStrongBinder(iBYDAutoPanoListener != null ? iBYDAutoPanoListener.asBinder() : null);
                    this.a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.hardware.bydauto.panorama.IBYDAutoPanoService
            public int setBuffer(int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.hardware.bydauto.panorama.IBYDAutoPanoService
            public int setMap(String[] strArr, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                    obtain.writeStringArray(strArr);
                    obtain.writeMap(map);
                    this.a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.hardware.bydauto.panorama.IBYDAutoPanoService
            public int setValue(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.hardware.bydauto.panorama.IBYDAutoPanoService
            public int unregisterUser(IBYDAutoPanoListener iBYDAutoPanoListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                    obtain.writeStrongBinder(iBYDAutoPanoListener != null ? iBYDAutoPanoListener.asBinder() : null);
                    this.a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "android.hardware.bydauto.panorama.IBYDAutoPanoService");
        }

        public static IBYDAutoPanoService asInterface() {
            return asInterface(ServiceManager.getService("android.hardware.bydauto.panorama.IBYDAutoPanoService"));
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                        int value = getValue(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(value);
                        return true;
                    case 2:
                        parcel.enforceInterface("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                        int value2 = setValue(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(value2);
                        return true;
                    case 3:
                        parcel.enforceInterface("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                        byte[] buffer = getBuffer(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(buffer);
                        return true;
                    case 4:
                        parcel.enforceInterface("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                        int buffer2 = setBuffer(parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(buffer2);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                        int map = setMap(parcel.createStringArray(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        parcel2.writeInt(map);
                        return true;
                    case 6:
                        parcel.enforceInterface("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                        int registerUser = registerUser(IBYDAutoPanoListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(registerUser);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.hardware.bydauto.panorama.IBYDAutoPanoService");
                        int unregisterUser = unregisterUser(IBYDAutoPanoListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(unregisterUser);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("android.hardware.bydauto.panorama.IBYDAutoPanoService");
            return true;
        }

        private static IBYDAutoPanoService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.hardware.bydauto.panorama.IBYDAutoPanoService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBYDAutoPanoService)) {
                return (IBYDAutoPanoService) queryLocalInterface;
            }
            return new a(iBinder);
        }
    }

    byte[] getBuffer(int i) throws RemoteException;

    int getValue(int i) throws RemoteException;

    int registerUser(IBYDAutoPanoListener iBYDAutoPanoListener) throws RemoteException;

    int setBuffer(int i, byte[] bArr) throws RemoteException;

    int setMap(String[] strArr, Map map) throws RemoteException;

    int setValue(int i, int i2) throws RemoteException;

    int unregisterUser(IBYDAutoPanoListener iBYDAutoPanoListener) throws RemoteException;
}
