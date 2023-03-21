package android.hardware;

import android.annotation.SystemApi;
import android.content.Context;
import android.hardware.ISensorPrivacyListener;
import android.hardware.ISensorPrivacyManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import com.android.internal.annotations.GuardedBy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class SensorPrivacyManager {
    public static final long TIME_PERIOD_FOR_CLOSE = 1004;
    public static final long TIME_PERIOD_FOR_ONE_TIME = 1001;
    public static final long TIME_PERIOD_FOR_ONE_YEAR = 1003;
    public static final long TIME_PERIOD_FOR_SIX_MONTH = 1002;
    @GuardedBy({"sInstanceLock"})
    private static SensorPrivacyManager sInstance;
    private final Context mContext;
    private final ISensorPrivacyManager mService;
    private static final Object sInstanceLock = new Object();
    public static final String EXTRA_ALL_SENSORS = SensorPrivacyManager.class.getName() + ".extra.all_sensors";
    public static final String EXTRA_SENSOR = SensorPrivacyManager.class.getName() + ".extra.sensor";
    private final SparseArray<Boolean> mToggleSupportCache = new SparseArray<>();
    private IBinder token = new Binder();
    private final ArrayMap<OnSensorPrivacyChangedListener, ISensorPrivacyListener> mListeners = new ArrayMap<>();
    private final ArrayMap<Pair<OnSensorPrivacyChangedListener, Integer>, ISensorPrivacyListener> mIndividualListeners = new ArrayMap<>();

    /* loaded from: classes.dex */
    public interface OnSensorPrivacyChangedListener {
        void onSensorPrivacyChanged(int i, boolean z);
    }

    /* loaded from: classes.dex */
    public static class Sensors {
        public static final int CAMERA = 2;
        public static final int MICROPHONE = 1;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface Sensor {
        }

        private Sensors() {
        }
    }

    /* loaded from: classes.dex */
    public static class Sources {
        public static final int DIALOG = 3;
        public static final int OTHER = 5;
        public static final int QS_TILE = 1;
        public static final int SETTINGS = 2;
        public static final int SHELL = 4;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface Source {
        }

        private Sources() {
        }
    }

    /* loaded from: classes.dex */
    public class a extends ISensorPrivacyListener.Stub {
        final /* synthetic */ OnSensorPrivacyChangedListener a;

        a(SensorPrivacyManager sensorPrivacyManager, Executor executor, OnSensorPrivacyChangedListener onSensorPrivacyChangedListener, int i) {
            this.a = onSensorPrivacyChangedListener;
        }
    }

    /* loaded from: classes.dex */
    class b extends ISensorPrivacyListener.Stub {
        b(SensorPrivacyManager sensorPrivacyManager) {
        }
    }

    private SensorPrivacyManager(Context context, ISensorPrivacyManager iSensorPrivacyManager) {
        this.mContext = context;
        this.mService = iSensorPrivacyManager;
    }

    public static SensorPrivacyManager getInstance(Context context) {
        SensorPrivacyManager sensorPrivacyManager;
        synchronized (sInstanceLock) {
            if (sInstance == null) {
                try {
                    sInstance = new SensorPrivacyManager(context, ISensorPrivacyManager.Stub.asInterface(ServiceManager.getServiceOrThrow("sensor_privacy")));
                } catch (ServiceManager.ServiceNotFoundException e2) {
                    throw new IllegalStateException((Throwable) e2);
                }
            }
            sensorPrivacyManager = sInstance;
        }
        return sensorPrivacyManager;
    }

    @SystemApi
    public void addSensorPrivacyListener(int i, OnSensorPrivacyChangedListener onSensorPrivacyChangedListener) {
        addSensorPrivacyListener(i, this.mContext.getMainExecutor(), onSensorPrivacyChangedListener);
    }

    public List<Integer> getAvailableSensorIds() {
        return Arrays.asList(1, 2);
    }

    public long getSensorPrivacyDeadTime(int i) {
        return getSensorPrivacyDeadTime(i, -2);
    }

    public long getSensorStateForPeriod(int i) {
        return getSensorStateForPeriod(i, -2);
    }

    @SystemApi
    public boolean isSensorPrivacyEnabled(int i) {
        return isSensorPrivacyEnabled(i, -2);
    }

    @SystemApi
    public void removeSensorPrivacyListener(int i, OnSensorPrivacyChangedListener onSensorPrivacyChangedListener) {
        synchronized (this.mListeners) {
            int i2 = 0;
            while (i2 < this.mIndividualListeners.size()) {
                Pair<OnSensorPrivacyChangedListener, Integer> keyAt = this.mIndividualListeners.keyAt(i2);
                if (((Integer) keyAt.second).intValue() == i && ((OnSensorPrivacyChangedListener) keyAt.first).equals(onSensorPrivacyChangedListener)) {
                    try {
                        this.mService.removeIndividualSensorPrivacyListener(i, this.mIndividualListeners.valueAt(i2));
                        this.mIndividualListeners.removeAt(i2);
                        i2--;
                    } catch (RemoteException e2) {
                        throw e2.rethrowFromSystemServer();
                    }
                }
                i2++;
            }
        }
    }

    public void setSensorPrivacy(int i, int i2, boolean z) {
        setSensorPrivacy(i, i2, z, -2, TIME_PERIOD_FOR_ONE_TIME);
    }

    public boolean supportsSensorToggle(int i) {
        try {
            Boolean bool = this.mToggleSupportCache.get(i);
            if (bool == null) {
                bool = Boolean.valueOf(this.mService.supportsSensorToggle(i));
                this.mToggleSupportCache.put(i, bool);
            }
            return bool.booleanValue();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void suppressSensorPrivacyReminders(int i, boolean z) {
        suppressSensorPrivacyReminders(i, z, -2);
    }

    private long getSensorPrivacyDeadTime(int i, int i2) {
        try {
            return this.mService.getIndividualSensorPrivacyDeadDate(i2, i);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    private long getSensorStateForPeriod(int i, int i2) {
        try {
            return this.mService.getIndividualSensorPrivacyPeriodType(i2, i);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    @SystemApi
    public void addSensorPrivacyListener(int i, Executor executor, OnSensorPrivacyChangedListener onSensorPrivacyChangedListener) {
        Pair<OnSensorPrivacyChangedListener, Integer> pair = new Pair<>(onSensorPrivacyChangedListener, Integer.valueOf(i));
        synchronized (this.mIndividualListeners) {
            ISensorPrivacyListener iSensorPrivacyListener = this.mIndividualListeners.get(pair);
            if (iSensorPrivacyListener == null) {
                iSensorPrivacyListener = new a(this, executor, onSensorPrivacyChangedListener, i);
                this.mIndividualListeners.put(pair, iSensorPrivacyListener);
            }
            try {
                this.mService.addUserGlobalIndividualSensorPrivacyListener(i, iSensorPrivacyListener);
            } catch (RemoteException e2) {
                throw e2.rethrowFromSystemServer();
            }
        }
    }

    public boolean isSensorPrivacyEnabled(int i, int i2) {
        try {
            return this.mService.isIndividualSensorPrivacyEnabled(i2, i);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void setSensorPrivacy(int i, int i2, boolean z, int i3, long j) {
        try {
            this.mService.setIndividualSensorPrivacy(i3, i, i2, z, j);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void suppressSensorPrivacyReminders(int i, boolean z, int i2) {
        try {
            this.mService.suppressIndividualSensorPrivacyReminders(i2, i, this.token, z);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public boolean isSensorPrivacyEnabled() {
        try {
            return this.mService.isSensorPrivacyEnabled();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void setSensorPrivacy(boolean z) {
        try {
            this.mService.setSensorPrivacy(z);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void setSensorPrivacy(int i, int i2, boolean z, long j) {
        setSensorPrivacy(i, i2, z, -2, j);
    }

    public void addSensorPrivacyListener(OnSensorPrivacyChangedListener onSensorPrivacyChangedListener) {
        synchronized (this.mListeners) {
            ISensorPrivacyListener iSensorPrivacyListener = this.mListeners.get(onSensorPrivacyChangedListener);
            if (iSensorPrivacyListener == null) {
                iSensorPrivacyListener = new b(this);
                this.mListeners.put(onSensorPrivacyChangedListener, iSensorPrivacyListener);
            }
            try {
                this.mService.addSensorPrivacyListener(iSensorPrivacyListener);
            } catch (RemoteException e2) {
                throw e2.rethrowFromSystemServer();
            }
        }
    }

    public void removeSensorPrivacyListener(OnSensorPrivacyChangedListener onSensorPrivacyChangedListener) {
        synchronized (this.mListeners) {
            ISensorPrivacyListener iSensorPrivacyListener = this.mListeners.get(onSensorPrivacyChangedListener);
            if (iSensorPrivacyListener != null) {
                this.mListeners.remove(iSensorPrivacyListener);
                try {
                    this.mService.removeSensorPrivacyListener(iSensorPrivacyListener);
                } catch (RemoteException e2) {
                    throw e2.rethrowFromSystemServer();
                }
            }
        }
    }
}
