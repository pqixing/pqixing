package com.pqixing.api.model

interface IApi {
    fun query(path: String, callBack: IResponse<ApiFile>)
    fun lists(path: String, callBack: IResponse<List<ApiFile>>)
    fun update(info: ApiFile, bytes: ByteArray, callBack: IResponse<Boolean>)
    fun delete(info: ApiFile, callBack: IResponse<Boolean>)
}