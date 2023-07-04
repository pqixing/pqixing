package com.pqixing.bydauto.utils

object UiManager : LogcatManager.LogCatCallBack {
    private var sCallBack = arrayListOf<IActivityLife>()
        private val logcat = LogcatManager(listOf("ActivityTaskManager:I"))
    init {
        logcat.addCallBack(this)
    }

    fun addCallBack(callBack: IActivityLife) {
        sCallBack.add(callBack)
    }

    fun removeCallBack(callBack: IActivityLife) {
        sCallBack.remove(callBack)
    }


    fun onActivityResume(activity: String, pkg: String) {
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
        return ".*ActivityTaskManager.*(START|activityResumed|Displayed|topComponentName).*"
    }

    override fun onReceiveLog(line: String) {
        TODO("Not yet implemented")
    }
}