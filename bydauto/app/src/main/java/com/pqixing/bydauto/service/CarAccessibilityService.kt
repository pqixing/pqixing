package com.pqixing.bydauto.service

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.pqixing.bydauto.App
import com.pqixing.bydauto.utils.UiManager

class CarAccessibilityService : AccessibilityService() {
    companion object {
        private var mInstance: CarAccessibilityService? = null
        fun get(): CarAccessibilityService? {
            return mInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

    override fun onDestroy() {
        super.onDestroy()
        mInstance = null
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        App.log("onServiceConnected ---- ")
        mInstance = this
    }


    override fun onAccessibilityEvent(event: AccessibilityEvent) {
//        App.log("onAccessibilityEvent: ${event.eventType} ${event.packageName}")
        when (event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> handleWindowChange(event)
        }
    }

    private fun handleWindowChange(event: AccessibilityEvent) {
        val pkg = event.packageName?.toString() ?: ""
        val clazz = event.className?.toString() ?: ""
        App.log("handleWindowChange ->${event.eventType} $pkg $clazz")
        UiManager.onActivityResume(clazz, pkg)
    }

    override fun onInterrupt() {
        mInstance = null
    }
}