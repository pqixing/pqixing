package com.pqixing.bydauto.model

import android.content.Intent
import android.graphics.drawable.Drawable

data class AppInfo(val pkg: String, var name: String, var icon: Drawable, var intent: Intent?)