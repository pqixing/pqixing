package com.pqixing.api

import com.alibaba.fastjson2.JSON
import com.pqixing.api.model.ApiFile
import com.pqixing.api.model.ApiToken
import com.pqixing.api.model.IApi
import com.pqixing.api.model.IResponse
import com.pqixing.api.model.SimpleCallBack
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.Base64

class GtApi private constructor(val token: ApiToken) : IApi {
    companion object {
        private var api: GtApi? = null
        fun get(): IApi {
            if (api == null) {
                throw RuntimeException("has not set default api !!")
            }
            return api!!
        }

        fun init(token: String, appId: String, initAsDefaultApi: Boolean = true): IApi {
            val api = GtApi(ApiToken(token, appId, "pqixing2"))
            if (initAsDefaultApi) {
                this.api = api
            }
            api.tryCreateRepo()
            return api
        }
    }

    private val client: OkHttpClient = OkHttpClient()
    private fun tryCreateRepo() {
        val body = FormBody.Builder().add("access_token", token.token).add("name", token.repo).add("private", "true")
            .add("auto_init", "true").build()
        client.newCall(Request.Builder().url("https://gitee.com/api/v5/user/repos").post(body).build())
            .enqueue(SimpleCallBack())
    }


    override fun query(path: String, callBack: IResponse<ApiFile>) {
        client.newCall(Request.Builder().url(getFileUrl(path)).get().build()).enqueue(SimpleCallBack { s, r, e ->
            if (!s) {
                return@SimpleCallBack callBack.onCall(false, null, e)
            }
            callBack.onCall(true, JSON.parseObject(r, ApiFile::class.java), null)
        })
    }

    override fun lists(path: String, callBack: IResponse<List<ApiFile>>) {
        client.newCall(Request.Builder().url(getFileUrl(path)).get().build()).enqueue(SimpleCallBack { s, r, e ->
            if (!s) {
                return@SimpleCallBack callBack.onCall(false, null, e)
            }
            callBack.onCall(true, JSON.parseArray(r, ApiFile::class.java), null)
        })
    }

    override fun update(info: ApiFile, bytes: ByteArray, callBack: IResponse<Boolean>) {
        val content = String(Base64.getEncoder().encode(bytes))
        val body = FormBody.Builder().add("access_token", token.token).add("content", content)
            .add("message", "${System.currentTimeMillis()}")
        val builder = Request.Builder().url(getFileUrl(info.path))
        if (info.sha.isEmpty()) {
            body.add("sha", info.sha)
            builder.put(body.build())
        } else {
            builder.post(body.build())
        }
        client.newCall(builder.build()).enqueue(SimpleCallBack { s, r, e ->
            callBack.onCall(s, s, e)
        })
    }

    override fun delete(info: ApiFile, callBack: IResponse<Boolean>) {
        val body = FormBody.Builder().add("access_token", token.token).add("sha", info.sha)
            .add("message", "${System.currentTimeMillis()}")

        val builder = Request.Builder().url(getFileUrl(info.path)).delete(body.build())
        client.newCall(builder.build()).enqueue(SimpleCallBack { s, r, e ->
            callBack.onCall(s, s, e)
        })
    }


    private fun getFileUrl(path: String): String {
        return "https://gitee.com/api/v5/repos/${token.owner}/${token.repo}/contents/${path}"
    }
}
