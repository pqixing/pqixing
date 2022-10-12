package com.pqixing.android.music

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.android.R
import com.pqixing.android.setting.DSetting
import com.pqixing.android.byd.BYDAutoInstrumentUtils

class MusicTestSetting : DSetting("设置测试") {

    override fun onUiCreate(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.setting_music, container, false)
        val radio = view.findViewById<RadioGroup>(R.id.group)

        radio.addView(RadioButton(activity).apply {
            text = "设置音乐"
            setOnClickListener {
                BYDAutoInstrumentUtils.sendMusicName("天地龙樱")
            }
        })
        radio.addView(RadioButton(activity).apply {
            text = "设置歌词"
            setOnClickListener {
                BYDAutoInstrumentUtils.sendMusicInfo("这是歌词测试".toByteArray(Charsets.UTF_32LE))
            }
        })
        radio.addView(RadioButton(activity).apply {
            text = "设置进度"
            setOnClickListener {
                BYDAutoInstrumentUtils.sendMusicPlaybackProgress(50)
            }
        })
        radio.addView(RadioButton(activity).apply {
            text = "设置来源"
            setOnClickListener {
                BYDAutoInstrumentUtils.sendMusicSource(6)
            }
        })
        radio.addView(RadioButton(activity).apply {
            text = "设置状态"
            setOnClickListener {
                BYDAutoInstrumentUtils.sendMusicState(1)
            }
        })

        return view
    }


}