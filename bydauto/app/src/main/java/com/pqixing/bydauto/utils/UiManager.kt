package com.pqixing.bydauto.utils

import android.content.pm.ApplicationInfo
import com.pqixing.bydauto.App
import com.pqixing.bydauto.model.AppInfo
import java.util.LinkedList

object UiManager : LogcatManager.LogCatCallBack {
    private var sCallBack = arrayListOf<IActivityLife>()
    private val logcat = LogcatManager(listOf("ActivityTaskManager:D"))

    private var resumes = LinkedList<String>()
    private var history = LinkedList<String>()
    private var c2p = hashMapOf<String, String>()

    var inSplitMode = false
        private set

    val inLauncher: Boolean
        get() = isResume("com.android.launcher3")

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
        return resumes.firstOrNull() == pkg || (inSplitMode && resumes.getOrNull(1) == pkg)
    }


    interface IActivityLife {
        fun onPkgResume(pkg: String)
    }

    override fun getFilterRex(): String {
        return ".*ActivityTaskManager.*(START|activityResumedForAcBar|onConfigurationChanged|startPausingLocked).*"
    }

    fun getPkgByClass(clazz: String): String {
        return c2p.getOrPut(clazz) { clazz.split(".").subList(0, 3).joinToString(".") }
    }

    override fun onReceiveLog(line: String) {
        kotlin.runCatching {
            when {
                line.contains("activityResumedForAcBar") -> {
                    val pkg = getPkgByClass(line.substringAfter("className:").trim())

                    history.remove(pkg)
                    history.addFirst(pkg)

                    resumes.remove(pkg)
                    resumes.addFirst(pkg)

                    sCallBack.forEach { it.onPkgResume(pkg) }
                }

                line.contains("onConfigurationChanged") -> {
                    val mode = line.substringAfter("windowingMode:").trim()
                    inSplitMode = (mode == "3" || mode == "4")
                }

                line.contains("startPausingLocked") -> {
                    val mPausingPkg = line.substringAfter("mPausingPkg =").substringBefore(",").trim()
                    resumes.remove(mPausingPkg)
                }

                line.contains("START") -> {
                    val name = line.substringAfterLast("{").substringBefore("}").trim().split(" ")
                        .find { it.contains("/") }
                        ?: return

                    val pkg = name.substringBefore("/").replace("cmp=", "")
                    val clazz =
                        name.substringAfter("/").let { if (it.startsWith(".")) pkg + it else it }
                    c2p[clazz] = pkg
                }

                else -> {}
            }
        }
    }
}