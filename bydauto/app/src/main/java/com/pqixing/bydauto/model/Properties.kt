package com.pqixing.bydauto.model

import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.toast
import java.lang.ref.WeakReference
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

open class BaseSuper<V> {
    val type: Type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
}

class Properties<V>(default: V, fetch: () -> V = { default }) : BaseSuper<V>() {


    val fetchValue: () -> V =
        { kotlin.runCatching { fetch() }.getOrElse { default } }
    private var value: V? = null

    private var onSet: ((v: V) -> Unit)? = null
    private var onChanges = hashMapOf<Int, WeakReference<IChange<V>>>()

    fun update(value: V = fetchValue.invoke()) {
        val old = getValue()
        this.value = value
        if (old == value) return
        onChanges.mapNotNull {
            val l = it.value.get()
            App.mHandle.post { l?.invoke(value) }
            if (l == null) it.key else null
        }.forEach { onChanges.remove(it) }
    }

    fun setValue(value: V) {
        update(value)
        if (onSet != null && value != fetchValue.invoke()) kotlin.runCatching {
            onSet?.invoke(value)
        }.onFailure { it.message?.toast() }
    }

    fun getValue(): V {
        if (value == null) value = fetchValue.invoke()
        return value!!
    }

    internal fun onSet(block: (v: V) -> Unit): Properties<V> {
        this.onSet = block
        return this
    }

    fun observe(onChange: IChange<V>): Properties<V> {
        onChange.invoke(getValue())
        onChanges[onChange.hashCode()] = WeakReference(onChange)
        return this
    }

}

typealias IChange<V> = (value: V) -> Unit