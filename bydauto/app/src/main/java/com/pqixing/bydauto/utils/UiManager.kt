package com.pqixing.bydauto.utils

import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.AppInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        App.get().uiScope.launch(Dispatchers.IO) { initApps() }
    }

    private fun initApps() {
        val context = App.get()
        val pm = context.packageManager
        apps = pm.getInstalledApplications(0).mapNotNull { info ->
            kotlin.runCatching {
                val name = pm.getApplicationLabel(info).toString()
                val icon = pm.getApplicationIcon(info)
                val intent = pm.getLaunchIntentForPackage(info.packageName)
                AppInfo(info.packageName, name, icon, intent)
            }.getOrNull()?.let { info.packageName to it }
        }.toMap().toMutableMap()
        apps.remove(context.packageName)
    }

    fun getAppInfo(pkg: Collection<String>): List<AppInfo> {
        return (if (pkg.isEmpty()) apps.values.toList() else pkg.mapNotNull { apps[it] })
    }

    fun addCallBack(callBack: IActivityLife) {
        sCallBack.add(callBack)
    }

    fun removeCallBack(callBack: IActivityLife) {
        sCallBack.remove(callBack)
    }

    fun isResumeActivity(activity: String): Boolean {
        return stacks.getOrNull(0) == activity || (inSplitMode && stacks.getOrNull(1) == activity)
    }

    fun isResumePkg(pkg: String?): Boolean {
        pkg ?: return false
        return maps[stacks.getOrNull(0)] == pkg || (inSplitMode && maps[stacks.getOrNull(1)] == pkg)
    }


    interface IActivityLife {
        fun onActivityResume(activity: String, pkg: String)
    }

    override fun getFilterRex(): String {
        return ".*ActivityTaskManager.*(START|topComponentName|activityResumedForAcBar|onConfigurationChanged).*"
    }

    fun onActivityResume(activity: String) {
        if (isResumeActivity(activity)) return
        stacks.remove(activity)
        stacks.addFirst(activity)
        sCallBack.forEach { it.onActivityResume(activity, maps[activity] ?: "") }
    }

    override fun onReceiveLog(line: String) {
        when {
            line.contains("activityResumedForAcBar") -> {
                val activity = line.substringAfter("className:").trim()
                onActivityResume(activity)
            }

            line.contains("onConfigurationChanged") -> {
                val mode = line.substringAfter("windowingMode:").trim()
                inSplitMode = (mode == "3" || mode == "4")
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
                onActivityResume(clazz)
            }
        }
    }
}