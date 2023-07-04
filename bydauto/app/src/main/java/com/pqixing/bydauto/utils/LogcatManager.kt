package com.pqixing.bydauto.utils

import com.pqixing.bydauto.App
import java.util.LinkedList
import java.util.regex.Pattern
import kotlin.concurrent.thread

class LogcatManager(val catTags: List<String> = listOf("ActivityTaskManager:I", "BYDAutoRadarDevice:D")) {

    private var startProTs: Long = -1L

    private var sCallBack = arrayListOf<LogCatCallBack>()

    private var patterns = arrayListOf<Pattern>()
    private var allPatterns: Pattern? = null

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
    }

    fun start(): Boolean {
        if (startProTs != -1L) return false

        startProTs = System.currentTimeMillis()
        val watch = { curTs: Long ->
            while (curTs == startProTs) {
                //监听雷达距离和页面切换启动
                val pro =
                    Runtime.getRuntime().exec("logcat -T 0 -s ${catTags.joinToString(" ")} *:S")
//                    Runtime.getRuntime().exec("logcat -T 0")
                pro.inputStream.bufferedReader().use {
                    while (curTs == startProTs) {
                        val line = it.readLine()
                        if (allPatterns?.matcher(line)?.matches() != true) continue

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
            }
        }
        thread {
            kotlin.runCatching { watch(startProTs) }.onFailure {
                App.log(null, it)
            }
        }
        return true
    }

    interface LogCatCallBack {
        fun getFilterRex(): String
        fun onReceiveLog(line: String)
    }
}