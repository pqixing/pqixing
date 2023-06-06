package com.cgutman.androidremotedebugger.service;

import android.content.Context;
import com.cgutman.adblib.AdbCrypto;
import com.cgutman.androidremotedebugger.AdbUtils;
import com.cgutman.androidremotedebugger.console.ConsoleBuffer;
import com.cgutman.androidremotedebugger.devconn.DeviceConnection;
import com.cgutman.androidremotedebugger.devconn.DeviceConnectionListener;

public abstract class SimpleLister implements DeviceConnectionListener {

    public abstract Context getContext();

    @Override
    public void notifyConnectionEstablished(DeviceConnection devConn) {
        onResponse("连接成功:" + devConn.getHost());
    }

    public void onResponse(String s) {

    }

    public void onClose(DeviceConnection devConn, Exception e) {

    }

    @Override
    public void notifyConnectionFailed(DeviceConnection devConn, Exception e) {
        onResponse("连接失败:" + devConn.getHost() + " -> " + e.getMessage());
        onClose(devConn, e);
    }

    @Override
    public void notifyStreamFailed(DeviceConnection devConn, Exception e) {
        onResponse("连接失败:" + devConn.getHost() + " -> " + e.getMessage());
        onClose(devConn, e);

    }

    @Override
    public void notifyStreamClosed(DeviceConnection devConn) {
        onResponse("连接关闭:" + devConn.getHost());
        onClose(devConn, null);

    }

    @Override
    public AdbCrypto loadAdbCrypto(DeviceConnection devConn) {
        return AdbUtils.readCryptoConfig(getContext().getFilesDir());
    }

    @Override
    public boolean canReceiveData() {
        return true;
    }

    @Override
    public void receivedData(DeviceConnection devConn, byte[] data, int offset, int length) {
        onResponse(new String(data, offset, length));
    }

    @Override
    public boolean isConsole() {
        return false;
    }

    @Override
    public void consoleUpdated(DeviceConnection devConn, ConsoleBuffer console) {
        onResponse(console.getString());
    }
}
