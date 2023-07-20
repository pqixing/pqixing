package com.pqixing.bydauto.service

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.pqixing.bydauto.App

class CAService : AccessibilityService() {
    companion object {
        private var mInstance: CAService? = null
        fun perform(action: Int) {
            kotlin.runCatching {
                mInstance?.performGlobalAction(action)
            }.onFailure { App.toast("performGlobalAction :$action ${it.message}") }
        }
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
//        App.log("onAccessibilityEvent[${event.packageName}]: ${event.eventType}  ${event.className}")
        mInstance = this
//        when (event.eventType) {
//            AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED -> handleWindowChange(event)
//        }
    }

    override fun onInterrupt() {

    }

    private fun handleWindowChange(event: AccessibilityEvent) {
    }
}