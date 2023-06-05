package com.pqixing.bydauto.utils

import com.cgutman.androidremotedebugger.devconn.DeviceConnection
import com.cgutman.androidremotedebugger.service.ShellService
import com.cgutman.androidremotedebugger.service.SimpleLister
import com.pqixing.bydauto.App
import kotlinx.coroutines.delay

object LocalHostAdb : SimpleLister(App.get()) {

    private val buffer: StringBuilder = StringBuilder()

    fun isConnect(): Boolean {
        return ShellService.getBinder(App.get())?.findConnection("127.0.0.1", 5555) != null
    }

    override fun setText(log: String?) {
        buffer.append(log).append("\n")
    }

    suspend fun runCmd(cmd: String): String {
        buffer.clear()
        val conn = tryToConnection() ?: return "连接失败"
        conn.queueCommand("$cmd \n")
        delay(500)
        return buffer.toString()
    }

    suspend fun tryToConnection(): DeviceConnection? {
        val context = App.get()
        var binder = ShellService.getBinder(context) ?: run {
            delay(500)
            ShellService.getBinder(context)
        } ?: return null


        return binder.findConnection("127.0.0.1", 5555) ?: run {
            binder.createConnection("127.0.0.1", 5555).also {
                binder.addListener(it, this@LocalHostAdb)
                it.startConnect()
                delay(500)
            }
        }
    }
}