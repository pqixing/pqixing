package com.cgutman.androidremotedebugger.service;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.cgutman.adblib.AdbCrypto;
import com.cgutman.androidremotedebugger.AdbUtils;
import com.cgutman.androidremotedebugger.console.ConsoleBuffer;
import com.cgutman.androidremotedebugger.devconn.DeviceConnection;
import com.cgutman.androidremotedebugger.devconn.DeviceConnectionListener;

public class SimpleLister implements DeviceConnectionListener {
    private Context context;
    private Handler handler = new Handler(Looper.getMainLooper());

    public SimpleLister(Context context) {
        this.context = context;
    }

    public void setText(String log) {
        handler.post(() -> Toast.makeText(context, log, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void notifyConnectionEstablished(DeviceConnection devConn) {
        setText("连接成功:" + devConn.getHost());
    }

    @Override
    public void notifyConnectionFailed(DeviceConnection devConn, Exception e) {
        setText("连接失败:" + devConn.getHost() + " -> " + e.getMessage());

    }

    @Override
    public void notifyStreamFailed(DeviceConnection devConn, Exception e) {
        setText("连接失败:" + devConn.getHost() + " -> " + e.getMessage());

    }

    @Override
    public void notifyStreamClosed(DeviceConnection devConn) {
        setText("连接关闭:" + devConn.getHost());

    }

    @Override
    public AdbCrypto loadAdbCrypto(DeviceConnection devConn) {
        return AdbUtils.readCryptoConfig(context.getDataDir());
    }

    @Override
    public boolean canReceiveData() {
        return true;
    }

    @Override
    public void receivedData(DeviceConnection devConn, byte[] data, int offset, int length) {
        setText(new String(data, offset, length));
    }

    @Override
    public boolean isConsole() {
        return false;
    }

    @Override
    public void consoleUpdated(DeviceConnection devConn, ConsoleBuffer console) {
        setText(console.getString());
    }
}
