package com.pqixing.bydauto.utils

import android.annotation.SuppressLint
import android.content.Context
import com.cgutman.androidremotedebugger.devconn.DeviceConnection
import com.cgutman.androidremotedebugger.service.SimpleLister
import com.pqixing.bydauto.App
import kotlinx.coroutines.delay

@SuppressLint("StaticFieldLeak")
object LocalHostAdb : SimpleLister() {

    private val LOCALHOST = "127.0.0.1"
    private var conn: DeviceConnection? = null

    private val buffer: StringBuilder = StringBuilder()

    fun isConnect(): Boolean {
        return conn != null
    }

    override fun notifyConnectionEstablished(devConn: DeviceConnection?) {
        super.notifyConnectionEstablished(devConn)
        if (devConn?.host == LOCALHOST) {
            conn = devConn
        }
    }

    override fun onClose(devConn: DeviceConnection?, e: Exception?) {
        super.onClose(devConn, e)
        conn = null
    }

    fun close() {
        conn?.close()
    }

    override fun onResponse(log: String?) {
        buffer.append(log).append("\n")
    }

    suspend fun runCmd(cmd: String): String {
        buffer.clear()
        val conn = connection() ?: return "连接失败"
        conn.queueCommand("$cmd \n")
        delay(500)
        return buffer.toString()
    }

    suspend fun connection(): DeviceConnection? {
        if (conn == null) {
            DeviceConnection(this, "127.0.0.1", 5555).also {
                it.startConnect()
            }
            val start = System.currentTimeMillis()
            while (conn == null && System.currentTimeMillis() - start <= 15000) {
                delay(50)
            }
        }
        return conn
    }

    override fun getContext(): Context {
        return App.get()
    }
}