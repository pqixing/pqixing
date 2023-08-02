package com.pqixing.bydauto.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.delay

interface CASExe {

    suspend fun execute(service: AccessibilityService)
}

class ActionCASExe(val action: Int) : CASExe {
    override suspend fun execute(service: AccessibilityService) {
        service.performGlobalAction(action)
    }

    override fun toString(): String {
        return "ActionCASExe(action=$action)"
    }

}

class LaunchCASExe(val pkg: String) : CASExe {
    override suspend fun execute(service: AccessibilityService) {
        UiUtils.tryLaunch(service.applicationContext, pkg)
    }

    override fun toString(): String {
        return "LaunchCASExe(pkg='$pkg')"
    }
}
class LaunchSplitCASExe(val pkg: String) : CASExe {
    override suspend fun execute(service: AccessibilityService) {
        UiUtils.startForSplit(service.applicationContext, pkg)
    }

    override fun toString(): String {
        return "LaunchCASExe(pkg='$pkg')"
    }
}

class GestureCASExe() : CASExe {
    val path: Path = Path()
    fun moveTo(x: Float, y: Float): GestureCASExe {
        path.moveTo(x, y)
        return this
    }

    fun lineTo(x: Float, y: Float): GestureCASExe {
        path.lineTo(x, y)
        return this
    }

    fun addPath(path: Path): GestureCASExe {
        this.path.addPath(path)
        return this
    }

    fun close(): GestureCASExe {
        path.close()
        return this
    }

    override suspend fun execute(service: AccessibilityService) {
        val builder =
            GestureDescription.Builder().addStroke(GestureDescription.StrokeDescription(path, 10L, 300L)).build()
        service.dispatchGesture(builder,null, null)
        delay(350L)
    }

    override fun toString(): String {
        return "LaunchCASExe(path='$path')"
    }
}