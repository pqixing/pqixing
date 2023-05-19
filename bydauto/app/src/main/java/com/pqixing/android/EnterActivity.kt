package com.pqixing.android

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.pqixing.android.utils.DatatypeConverterImpl
import com.tananaev.adblib.AdbConnection
import com.tananaev.adblib.AdbCrypto
import java.io.IOException
import java.net.Socket
import java.security.NoSuchAlgorithmException
import kotlin.concurrent.thread

class EnterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            thread {
                connect()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.w("EnterActivity", "onCreate: ", e)
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    @Throws(IOException::class, NoSuchAlgorithmException::class, InterruptedException::class)
    private fun connect() {
        val socket = Socket("127.0.0.1", 5555) // put phone IP address here
        val crypto = AdbCrypto.generateAdbKeyPair { data -> DatatypeConverterImpl.printBase64Binary(data) }
        val connection = AdbConnection.create(socket, crypto)
        connection.connect()
        val toString = connection.open("devices").read().toString()
        Log.i("EnterActivity", "connect: $toString")
        runOnUiThread { Toast.makeText(this, toString, Toast.LENGTH_SHORT).show() }
    }
}