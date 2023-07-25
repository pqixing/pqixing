package com.pqixing.bydauto.utils

import com.pqixing.bydauto.App

object UiManager : LogcatManager.LogCatCallBack {
    private var sCallBack = arrayListOf<IActivityLife>()
    private val logcat = LogcatManager(listOf("ActivityTaskManager:I"))
    private var lastPkg = ""
    private var lastActivity = ""

    private var windowMode = 1


    init {
        logcat.addCallBack(this)
        logcat.start()
    }

    fun addCallBack(callBack: IActivityLife) {
        sCallBack.add(callBack)
    }

    fun removeCallBack(callBack: IActivityLife) {
        sCallBack.remove(callBack)
    }

    fun curActivity() = lastActivity
    fun curPkg() = lastPkg

    fun onActivityResume(activity: String, pkg: String) {
        if (lastPkg == pkg && lastActivity == activity) {
            return
        }
        App.log("onActivityResume $pkg/$activity")
        if (lastActivity.isNotEmpty()) {
            onActivityPause(activity, pkg)
        }
        lastActivity = activity
        lastPkg = pkg
        sCallBack.forEach { it.onActivityResume(activity, pkg) }
    }

    fun onActivityPause(activity: String, pkg: String) {
        sCallBack.forEach { it.onActivityPause(activity, pkg) }
    }

    interface IActivityLife {
        abstract fun onActivityResume(activity: String, pkg: String)
        abstract fun onActivityPause(activity: String, pkg: String)
    }

    override fun getFilterRex(): String {
        return ".*ActivityTaskManager.*(START|topComponentName|activityResumedForAcBar|onConfigurationChanged).*"
    }

    override fun onReceiveLog(line: String) {
        //类似 com.miui.home/.launcher.Launcher格式
        val name =
            line.substringAfterLast("{").substringBefore("}").trim().split(" ").find { it.contains("/") } ?: return

        val pkg = name.substringBefore("/").replace("cmp=", "")
        val clazz = name.substringAfter("/").let { if (it.startsWith(".")) pkg + it else it }
        onActivityResume(clazz, pkg)
    }
}