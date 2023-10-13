package com.pqixing.bydauto.utils

import android.content.pm.ApplicationInfo
import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.AppInfo
import java.util.LinkedList

object UiManager : LogcatManager.LogCatCallBack {
    private var sCallBack = arrayListOf<IActivityLife>()
    private val logcat = LogcatManager(listOf("ActivityTaskManager:D"))

    private var maps = hashMapOf<String, String>()
    private var stacks = LinkedList<String>()

    var inSplitMode = false
        private set

    private var apps = mutableMapOf<String, AppInfo>()


    init {
        logcat.addCallBack(this@UiManager)
        logcat.start()
    }


    @Synchronized
    private fun initApps() {
        val context = App.get()
        val pm = context.packageManager
        apps = pm.getInstalledApplications(0).mapNotNull { info ->
            kotlin.runCatching {
                val name = pm.getApplicationLabel(info).toString()
                val icon = pm.getApplicationIcon(info)
                AppInfo(
                    info.packageName,
                    name,
                    icon,
                    info.flags.and(ApplicationInfo.FLAG_SYSTEM) != 0,
                    info.sourceDir,
                    info,
                    pm.getLaunchIntentForPackage(info.packageName) != null
                )
            }.getOrNull()?.let { info.packageName to it }
        }.toMap().toMutableMap()
        apps.remove(context.packageName)
    }

    fun getAppInfo(pkg: Collection<String>? = null): List<AppInfo> {
        if (apps.isEmpty()) initApps()
        return pkg?.mapNotNull { apps[it] } ?: apps.values.toList()
    }

    fun addCallBack(callBack: IActivityLife) {
        sCallBack.add(callBack)
    }

    fun removeCallBack(callBack: IActivityLife) {
        sCallBack.remove(callBack)
    }

    fun isResume(pkg: String?): Boolean {
        pkg ?: return false
        return stacks.getOrNull(0) == pkg || (inSplitMode && stacks.getOrNull(1) == pkg)
    }


    interface IActivityLife {
        fun onPkgResume(pkg: String?, ac: String)
    }

    override fun getFilterRex(): String {
        return ".*ActivityTaskManager.*(START|topComponentName|activityResumedForAcBar|onConfigurationChanged|startPausingLocked).*"
    }

    fun onPkgResume(pkg: String?, ac: String) {
        if (isResume(pkg)) return
        stacks.remove(pkg)
        stacks.addFirst(pkg)
        sCallBack.forEach { it.onPkgResume(pkg, ac) }
    }

    override fun onReceiveLog(line: String) {
        when {
            line.contains("activityResumedForAcBar") -> {
                val activity = line.substringAfter("className:").trim()
                onPkgResume(maps[activity], activity)
            }

            line.contains("onConfigurationChanged") -> {
                val mode = line.substringAfter("windowingMode:").trim()
                inSplitMode = (mode == "3" || mode == "4")
            }

            line.contains("startPausingLocked") -> {
                val pkg = line.substringAfter("mPausingPkg =").substringBefore(",").trim()
                stacks.remove(pkg)
                stacks.addLast(pkg)
            }

            else -> {
                //类似 com.miui.home/.launcher.Launcher格式
                val name = line.substringAfterLast("{").substringBefore("}").trim().split(" ")
                    .find { it.contains("/") }
                    ?: return

                val pkg = name.substringBefore("/").replace("cmp=", "")
                val clazz =
                    name.substringAfter("/").let { if (it.startsWith(".")) pkg + it else it }
                maps[clazz] = pkg
                onPkgResume(pkg, clazz)
            }
        }
    }
}