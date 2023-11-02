package com.pqixing.bydauto.service

import android.accessibilityservice.AccessibilityGestureEvent
import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.utils.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CAService : AccessibilityService() {
    companion object {

        private var mInstance: CAService? = null
        private val actions: MutableList<Pair<CASExe, Long>> = mutableListOf()

        fun perform(action: Int, delay: Long = 0) {
            performs(ActionCASExe(action) to delay)
        }

        fun performs(vararg actions: Pair<CASExe, Long>) {
            if (mInstance != null) {
                mInstance?.performs(actions.toList())
            } else {
                this.actions.addAll(actions)
                UiUtils.enableAccessibility(App.get(), true)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        App.log("CAService onCreate")
        mInstance = this
    }

    override fun onDestroy() {
        super.onDestroy()
        App.log("CAService onDestroy")
        mInstance = null
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        App.log("CAService onServiceConnected")
        mInstance = this
        performs(actions.toList())
        actions.clear()
    }

    override fun onGesture(gestureId: Int): Boolean {
        App.log("onGesture ${gestureId}")

        return true
    }
    override fun onGesture(gestureEvent: AccessibilityGestureEvent): Boolean {
        App.log("onGesture ${gestureEvent}")
        return super.onGesture(gestureEvent)
    }
    fun performs(actions: List<Pair<CASExe, Long>>) {
        App.uiScope.launch {
            actions.forEach { action ->
                kotlin.runCatching {
                    delay(action.second)
                    action.first.execute(this@CAService)
                    App.log("CAService perform[${action.first}]: ${action.second}")

                }.onFailure { App.toast("performGlobalAction :${action.first} ${it.message}") }
            }
//            UiUtils.enableAccessibility(App.get(), false)
        }
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        App.log("CAService onAccessibilityEvent[${event.packageName}]: ${event.eventType}  ${event.className}")
        mInstance = this
    }

    override fun onInterrupt() {
        App.log("CAService onInterrupt")
        mInstance = null
    }

    private fun handleWindowChange(event: AccessibilityEvent) {
    }
}