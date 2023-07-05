package com.pqixing.bydauto.service

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class CarAccessibilityService : AccessibilityService() {
    companion object{
        var connect = false
    }
    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.i("CarAccessibilityService", "onServiceConnected ---- ")
        connect = true
    }

    override fun onDestroy() {
        super.onDestroy()
        connect = false
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        connect = true
        getRootInActiveWindow()
        Log.i("CarAccessibilityService", "onAccessibilityEvent: ${event.eventType} ${event.packageName}")
    }

    override fun onInterrupt() {
    }
}