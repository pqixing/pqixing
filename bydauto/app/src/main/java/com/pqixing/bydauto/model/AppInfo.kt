package com.pqixing.bydauto.model

import android.content.pm.ApplicationInfo
import android.graphics.drawable.Drawable

data class AppInfo(val pkg: String, var name: String, var icon: Drawable, var system: Boolean, var sourceDir: String, var info: ApplicationInfo)