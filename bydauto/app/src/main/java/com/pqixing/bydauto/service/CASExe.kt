package com.pqixing.bydauto.service

import android.accessibilityservice.AccessibilityService
import com.pqixing.bydauto.utils.UiUtils

interface CASExe {

    fun execute(service: AccessibilityService)
}

class ActionCASExe(val action: Int) : CASExe {
    override fun execute(service: AccessibilityService) {
        service.performGlobalAction(action)
    }

    override fun toString(): String {
        return "ActionCASExe(action=$action)"
    }

}

class LaunchCASExe(val pkg: String) : CASExe {
    override fun execute(service: AccessibilityService) {
        UiUtils.tryLaunch(service.applicationContext, pkg)
    }

    override fun toString(): String {
        return "LaunchCASExe(pkg='$pkg')"
    }

}