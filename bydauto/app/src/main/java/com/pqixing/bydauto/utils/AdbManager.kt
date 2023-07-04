package com.pqixing.bydauto.utils

import android.annotation.SuppressLint
import android.content.Context
import com.cgutman.androidremotedebugger.devconn.DeviceConnection
import com.cgutman.androidremotedebugger.service.SimpleLister
import com.pqixing.bydauto.App
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

@SuppressLint("StaticFieldLeak")
class AdbManager private constructor(val host: String = "127.0.0.1", val port: Int = 5555) : SimpleLister() {
    companion object {
        private val clients = hashMapOf<String, AdbManager>()

        fun getClient(host: String = "127.0.0.1", port: Int = 5555): AdbManager {
            return clients.getOrElse(host) { AdbManager(host, port).also { clients[host] = it } }
        }
    }

    private var conn: DeviceConnection? = null

    private val buffer: StringBuilder = StringBuilder()

    fun isConnect(): Boolean {
        return conn != null
    }

    override fun notifyConnectionEstablished(devConn: DeviceConnection?) {
        super.notifyConnectionEstablished(devConn)
        if (devConn?.host == host) {
            conn = devConn
        }
    }

    override fun onClose(devConn: DeviceConnection?, e: Exception?) {
        super.onClose(devConn, e)
        if (devConn?.host == host) {
            conn = null
            clients.remove(host)
        }
    }

    fun close() {
        conn?.close()
    }

    override fun onResponse(log: String?) {
        buffer.append(log).append("\n")
    }

    fun runAsync(cmd: String): Deferred<Result<String>> {
        return App.uiScope.async { runSync(cmd) }
    }

    suspend fun runSync(cmd: String): Result<String> {
        buffer.clear()
        val conn = connection() ?: return Result.failure(Exception("not connect"))
        conn.queueCommand("$cmd \n")
        delay(500)
        return Result.success(buffer.toString())
    }

    suspend fun connection(): DeviceConnection? {
        if (conn == null) {
            DeviceConnection(this, host, port).also {
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