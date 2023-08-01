package com.pqixing.bydauto.utils

import java.util.LinkedList

object UiManager : LogcatManager.LogCatCallBack {
    private var sCallBack = arrayListOf<IActivityLife>()
    private val logcat = LogcatManager(listOf("ActivityTaskManager:I"))

    private var maps = hashMapOf<String, String>()
    private var stacks = LinkedList<String>()

    private var inSplitMode = false


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

    fun isResumeActivity(activity: String): Boolean {
        return stacks.getOrNull(0) == activity || (inSplitMode && stacks.getOrNull(1) == activity)
    }

    fun isResumePkg(pkg: String?): Boolean {
        pkg?:return false
        return maps[stacks.getOrNull(0)] == pkg || (inSplitMode && maps[stacks.getOrNull(1)] == pkg)
    }


    interface IActivityLife {
        fun onActivityResume(activity: String, pkg: String)
    }

    override fun getFilterRex(): String {
        return ".*ActivityTaskManager.*(START|topComponentName|activityResumedForAcBar|onConfigurationChanged).*"
    }

    override fun onReceiveLog(line: String) {
        when {
            line.contains("activityResumedForAcBar") -> {
                val activity = line.substringAfter("className:").trim()
                if (!isResumeActivity(activity)) {
                    stacks.remove(activity)
                    stacks.addFirst(activity)
                    sCallBack.forEach { it.onActivityResume(activity, maps[activity] ?: "") }
                }
            }

            line.contains("onConfigurationChanged") -> {
                val mode = line.substringAfter("windowingMode:").trim()
                inSplitMode = (mode == "3" || mode == "4")
            }

            else -> {
                //类似 com.miui.home/.launcher.Launcher格式
                val name = line.substringAfterLast("{").substringBefore("}").trim().split(" ").find { it.contains("/") }
                    ?: return

                val pkg = name.substringBefore("/").replace("cmp=", "")
                val clazz = name.substringAfter("/").let { if (it.startsWith(".")) pkg + it else it }
                maps[clazz] = pkg
            }
        }
    }
}