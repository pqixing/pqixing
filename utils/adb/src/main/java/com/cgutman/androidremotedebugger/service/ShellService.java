package com.cgutman.androidremotedebugger.service;


import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.cgutman.adblib.AdbCrypto;
import com.cgutman.androidremotedebugger.AdbShell;
import com.cgutman.androidremotedebugger.R;
import com.cgutman.androidremotedebugger.console.ConsoleBuffer;
import com.cgutman.androidremotedebugger.devconn.DeviceConnection;
import com.cgutman.androidremotedebugger.devconn.DeviceConnectionListener;

import java.util.HashMap;

public class ShellService extends Service implements DeviceConnectionListener {

    private ShellServiceBinder binder = new ShellServiceBinder();
    private ShellListener listener = new ShellListener(this);

    private HashMap<String, DeviceConnection> currentConnectionMap =
            new HashMap<String, DeviceConnection>();

    private WifiLock wlanLock;
    private WakeLock wakeLock;

    private final static int FOREGROUND_PLACEHOLDER_ID = 1;
    private final static int CONN_BASE = 12131;
    private final static int FAILED_BASE = 12111;
    private final static String CHANNEL_ID = "connectionInfo";
    private static ShellService mThis = null;


    @Nullable
    public static ShellServiceBinder getBinder(Context context) {
        if (mThis == null) {
            context.startService(new Intent(context, ShellService.class));
        }
        return mThis == null ? null : mThis.binder;
    }

    private int foregroundId;

    public class ShellServiceBinder extends Binder {

        public DeviceConnection findOrCreate(String host, int port) {
            DeviceConnection connection = findConnection(host, port);
            if (connection == null) {
                connection = createConnection(host, port);
                connection.startConnect();
            }
            return connection;
        }

        public DeviceConnection createConnection(String host, int port) {
            DeviceConnection conn = new DeviceConnection(listener, host, port);
            listener.addListener(conn, ShellService.this);
            return conn;
        }

        public DeviceConnection findConnection(String host, int port) {
            String connStr = host + ":" + port;
            return currentConnectionMap.get(connStr);
        }

        public void notifyPausingActivity(DeviceConnection devConn) {
            devConn.setForeground(false);
        }

        public void notifyResumingActivity(DeviceConnection devConn) {
            devConn.setForeground(true);
        }

        public void notifyDestroyingActivity(DeviceConnection devConn) {
            /* If we're pausing before destruction after the connection is closed, remove the failure
             * notification */
            if (devConn.isClosed()) {
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.cancel(getFailedNotificationId(devConn));
            }
        }

        public void addListener(DeviceConnection conn, DeviceConnectionListener listener) {
            ShellService.this.listener.addListener(conn, listener);
        }

        public void removeListener(DeviceConnection conn, DeviceConnectionListener listener) {
            ShellService.this.listener.removeListener(conn, listener);
        }
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        /* Stop the the service if no connections remain */
        if (currentConnectionMap.isEmpty()) {
            stopSelf();
        }

        return false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (foregroundId == 0) {
            // If we're not already running in the foreground, use a placeholder
            // notification until a real connection is established. After connection
            // establishment, the real notification will replace this one.
            startForeground(FOREGROUND_PLACEHOLDER_ID, createForegroundPlaceholderNotification());
        }

        // Don't restart if we've been killed. We will have already lost our connections
        // when we died, so we'll just be running doing nothing if the OS restarted us.
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mThis = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, getString(R.string.channel_name), NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wlanLock = wm.createWifiLock(WifiManager.WIFI_MODE_FULL, "RemoteADBShell:ShellService");

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "RemoteADBShell:ShellService");
    }

    @Override
    public void onDestroy() {
        mThis = null;
        if (wlanLock.isHeld()) {
            wlanLock.release();
        }
        if (wakeLock.isHeld()) {
            wakeLock.release();
        }

        super.onDestroy();
    }

    private int getFailedNotificationId(DeviceConnection devConn) {
        return FAILED_BASE + getConnectionString(devConn).hashCode();
    }

    private int getConnectedNotificationId(DeviceConnection devConn) {
        return CONN_BASE + getConnectionString(devConn).hashCode();
    }

    private PendingIntent createPendingIntentForConnection(DeviceConnection devConn) {
        Context appContext = getApplicationContext();

        Intent i = new Intent(appContext, AdbShell.class);
        i.putExtra("IP", devConn.getHost());
        i.putExtra("Port", devConn.getPort());
        i.setAction(getConnectionString(devConn));

        int flags = PendingIntent.FLAG_UPDATE_CURRENT;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }

        return PendingIntent.getActivity(appContext, 0, i, flags);
    }

    private PendingIntent createPendingIntentToLaunchShellActivity() {
        Context appContext = getApplicationContext();

        Intent i = new Intent(appContext, AdbShell.class);

        int flags = PendingIntent.FLAG_UPDATE_CURRENT;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            flags |= PendingIntent.FLAG_IMMUTABLE;
        }

        return PendingIntent.getActivity(appContext, 0, i, flags);
    }

    private Notification createForegroundPlaceholderNotification() {
        return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setOngoing(true)
                .setSilent(true)
                .setContentTitle("Remote ADB Shell")
                .setContentText("Connecting...")
                .setContentIntent(createPendingIntentToLaunchShellActivity())
                .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
                .build();
    }

    private Notification createConnectionNotification(DeviceConnection devConn, boolean connected) {
        String ticker;
        String message;

        if (connected) {
            ticker = "Connection Established";
            message = "Connected to " + getConnectionString(devConn);
        } else {
            ticker = "Connection Terminated";
            message = "Connection to " + getConnectionString(devConn) + " failed";
        }

        return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setTicker("Remote ADB Shell - " + ticker)
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setOnlyAlertOnce(true)
                .setOngoing(connected)
                .setAutoCancel(!connected)
                .setSilent(connected)
                .setContentTitle("Remote ADB Shelol")
                .setContentText(message)
                .setContentIntent(createPendingIntentForConnection(devConn))
                .setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
                .build();
    }

    private void updateNotification(DeviceConnection devConn, boolean connected) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        removeNotification(devConn);

        if (connected) {
            if (foregroundId != 0) {
                /* There's already a foreground notification, so use the normal notification framework */
                nm.notify(getConnectedNotificationId(devConn), createConnectionNotification(devConn, connected));
            } else {
                /* This is the first notification so make it the foreground one */
                foregroundId = getConnectedNotificationId(devConn);
                startForeground(foregroundId, createConnectionNotification(devConn, connected));
            }
        } else if (!devConn.isForeground()) {
            nm.notify(getFailedNotificationId(devConn), createConnectionNotification(devConn, connected));
        }
    }

    private void removeNotification(DeviceConnection devConn) {
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        /* Removing failure notifications is easy */
        nm.cancel(getFailedNotificationId(devConn));

        /* Connected notifications is a bit more complex */
        if (getConnectedNotificationId(devConn) == foregroundId) {
            /* We're the foreground notification, so we need to switch in another
             * notification to take our place */

            /* Search for a new device connection to promote */
            DeviceConnection newConn = null;
            for (DeviceConnection conn : currentConnectionMap.values()) {
                if (devConn == conn) {
                    continue;
                } else {
                    newConn = conn;
                    break;
                }
            }

            if (newConn == null) {
                /* None found, so we're done in foreground */
                stopForeground(true);
                foregroundId = 0;
            } else {
                /* Found one, so cancel this guy's original notification
                 * and start it as foreground */
                foregroundId = getConnectedNotificationId(newConn);
                nm.cancel(foregroundId);
                startForeground(foregroundId, createConnectionNotification(newConn, true));
            }
        } else {
            /* This just a normal connected notification */
            nm.cancel(getConnectedNotificationId(devConn));
        }
    }

    private String getConnectionString(DeviceConnection devConn) {
        return devConn.getHost() + ":" + devConn.getPort();
    }

    private synchronized void addNewConnection(DeviceConnection devConn) {
        if (currentConnectionMap.isEmpty()) {
            wakeLock.acquire();
            wlanLock.acquire();
        }

        currentConnectionMap.put(getConnectionString(devConn), devConn);
    }

    private synchronized void removeConnection(DeviceConnection devConn) {
        currentConnectionMap.remove(getConnectionString(devConn));

        /* Stop the the service if no connections remain */
        if (currentConnectionMap.isEmpty()) {
            stopSelf();
        }
    }

    @Override
    public void notifyConnectionEstablished(DeviceConnection devConn) {
        addNewConnection(devConn);
        updateNotification(devConn, true);
    }

    @Override
    public void notifyConnectionFailed(DeviceConnection devConn, Exception e) {
        /* No notification is displaying here */
    }

    @Override
    public void notifyStreamFailed(DeviceConnection devConn, Exception e) {
        updateNotification(devConn, false);
        removeConnection(devConn);
    }

    @Override
    public void notifyStreamClosed(DeviceConnection devConn) {
        updateNotification(devConn, false);
        removeConnection(devConn);
    }

    @Override
    public AdbCrypto loadAdbCrypto(DeviceConnection devConn) {
        return null;
    }

    @Override
    public void receivedData(DeviceConnection devConn, byte[] data, int offset,
                             int length) {
    }

    @Override
    public boolean canReceiveData() {
        return false;
    }

    @Override
    public boolean isConsole() {
        return true;
    }

    @Override
    public void consoleUpdated(DeviceConnection devConn,
                               ConsoleBuffer console) {
    }
}