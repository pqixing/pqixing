package com.pqixing.bydauto.service

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

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
        Log.i("CarAccessibilityService", "onServiceConnected ---- ")
        mInstance = this
    }


    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        getRootInActiveWindow()
        Log.i("CarAccessibilityService", "onAccessibilityEvent: ${event.eventType} ${event.packageName}")
    }

    override fun onInterrupt() {
        mInstance = null
    }
}