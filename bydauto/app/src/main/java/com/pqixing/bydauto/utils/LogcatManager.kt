package com.pqixing.bydauto.utils

import android.util.Log
import com.pqixing.bydauto.App
import java.util.LinkedList
import java.util.regex.Pattern
import kotlin.concurrent.thread

class LogcatManager(tags: List<String> = listOf("ActivityTaskManager:I", "BYDAutoRadarDevice:D")) {

    private var startProTs: Long = -1L

    private var sCallBack = arrayListOf<LogCatCallBack>()

    private var patterns = arrayListOf<Pattern>()
    private var allPatterns: Pattern? = null
    private var hasLog = false
    private val TAG_START_TEST = "LogcatManagerTest"
    private val catTags = tags.plus("$TAG_START_TEST:I")

    fun addCallBack(callBack: LogCatCallBack) {
        sCallBack.add(callBack)
        patterns.add(Pattern.compile(callBack.getFilterRex()))
        allPatterns =
            if (patterns.isEmpty()) null else Pattern.compile(sCallBack.joinToString("") { "(${it.getFilterRex()})" })
    }

    fun removeCallBack(callBack: LogCatCallBack) {
        val indexOf = sCallBack.indexOf(callBack)
        if (indexOf == -1) return
        sCallBack.removeAt(indexOf)
        patterns.removeAt(indexOf)

        allPatterns =
            if (patterns.isEmpty()) null else Pattern.compile(sCallBack.joinToString("") { "(${it.getFilterRex()})" })
    }

    fun stop() {
        startProTs = -1
        hasLog = false
    }

    fun start(): Boolean {
        if (startProTs != -1L) return false

        startProTs = System.currentTimeMillis()
        val curTs = startProTs
        val watch = {
            while (curTs == startProTs) runCatching {
                //监听雷达距离和页面切换启动
                val cmd = "logcat -T 0 -s ${catTags.joinToString(" ")} *:S"
                val pro = Runtime.getRuntime().exec(cmd)
                App.log("start $cmd")
                Log.i(TAG_START_TEST, "start $cmd $curTs")
//                    Runtime.getRuntime().exec("logcat -T 0")
                pro.inputStream.bufferedReader().use {
                    while (curTs == startProTs) {
                        val line = it.readLine() ?: continue

                        hasLog = true
                        if (allPatterns?.matcher(line)?.matches() != true || line.contains(TAG_START_TEST)) continue

                        val posts = LinkedList<LogCatCallBack>()
                        //解析处理
                        for (i in patterns.indices) {
                            val p = patterns.getOrNull(i) ?: continue
                            val c = sCallBack.getOrNull(i) ?: continue
                            if (p.matcher(line).matches()) {
                                posts.add(c)
                            }
                        }

                        App.mHandle.post { posts.forEach { f -> f.onReceiveLog(line) } }
                    }
                    pro.destroy()
                }
            }.onFailure { it.message?.toast() }
        }
        thread(block = watch)
        checkIfLive()
        return true
    }

    private fun checkIfLive() {
        App.mHandle.postDelayed({
            if (!hasLog) {
                "重启日志管理器".toast()
                stop()
                start()
            }
        }, 2000)
    }

    interface LogCatCallBack {
        fun getFilterRex(): String
        fun onReceiveLog(line: String)
    }
}