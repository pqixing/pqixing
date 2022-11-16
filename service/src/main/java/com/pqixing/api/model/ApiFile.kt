package com.pqixing.api.model

import com.alibaba.fastjson2.JSON
import com.pqixing.api.GtApi
import java.util.Base64

class ApiFile {
    val type: String = ""
    val name: String = ""
    val encoding: String = "base64"
    val path: String = ""
    val size: String? = ""
    val url: String = ""
    val sha: String = ""
    private var content: String = ""


    fun <T> model(clazz: Class<T>): T {
        return JSON.parseObject(str(), clazz)
    }

    fun bytes(): ByteArray {
        return Base64.getDecoder().decode(content)
    }

    fun str(): String {
        return String(bytes())
    }

    fun maps(): Map<String, Any> {
        return JSON.parseObject(str()).toMap()
    }

    fun update(byteArray: ByteArray, callBack: IResponse<Boolean>) {
        this.content = String(Base64.getEncoder().encode(byteArray))
        GtApi.get().update(this, byteArray, callBack)
    }

    fun update(content: String, callBack: IResponse<Boolean>) {
        update(content.toByteArray(), callBack)
    }

    fun delete(callBack: IResponse<Boolean>) {
        GtApi.get().delete(this, callBack)
    }
}