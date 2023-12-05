package com.pqixing.bydauto.model

import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.log
import com.pqixing.bydauto.utils.toast

class Properties<V>(var value: V, init: () -> V) {


    val fetch: () -> V = { kotlin.runCatching { init() }.getOrElse { value } }

    private var onSet: ((v: V) -> Unit)? = null

    private var onChanges = hashMapOf<Int, IChange<V>>()

    fun update() {
        set(fetch(), false)
    }

    fun set(value: V, fromUser: Boolean = true) {
        if (this.value == value) return
        this.value = value
        onChanges.mapNotNull { it.value }.forEach {
            App.mHandle.post { it.invoke(value) }
        }

        if (fromUser) kotlin.runCatching { onSet?.invoke(value) }.onFailure { it.message?.toast() }
    }

    fun get(): V {
        return value
    }

    internal fun onSetFromUser(block: (v: V) -> Unit): Properties<V> {
        this.onSet = block
        return this
    }

    fun observe(onChange: IChange<V>): Properties<V> {
        onChange.invoke(get())
        onChanges[onChange.hashCode()] = onChange
        return this
    }

}

typealias IChange<V> = (value: V) -> Unit