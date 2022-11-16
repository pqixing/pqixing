package com.pqixing.api.model

import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

open class SimpleCallBack(val onCall: (success: Boolean, result: String?, e: IOException?) -> Unit = { _, _, _ -> }) :
    Callback {
    override fun onFailure(call: Call, e: IOException) {
        onCall(false, e.message, e)
    }

    override fun onResponse(call: Call, response: Response) {
        if (response.code == 200 || response.code == 201) {
            val body = response.body?.string() ?: ""
            onCall(true, body, null)
        } else {
            onCall(false, response.body?.string(), IOException("code error"))
        }
    }
}