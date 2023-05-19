package com.pqixing.api.model

import java.io.IOException

interface IResponse<T> {
    abstract fun onCall(success: Boolean, model: T? = null, e: IOException? = null)
}
