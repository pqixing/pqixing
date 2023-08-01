package com.pqixing.bydauto.setting.item

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.view.View
import android.widget.CheckBox
import android.widget.HorizontalScrollView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.UiManager
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MusicItem : SettingImpl(R.layout.setting_music) {
    companion object {
        const val SEARCH_TYPE_AUTO = 0
        const val SEARCH_TYPE_BACK = 1
        const val SEARCH_TYPE_FORE = 2
    }

    override fun getNameId(): Int = R.string.setting_name_music

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val radio: RadioGroup = viewHolder.findViewById(R.id.group)

        val searchType = viewHolder.findViewById<RadioGroup>(R.id.group_search_type)
        searchType.check(
            when (Const.SP_MUSIC_SEARCH_TYPE) {
                SEARCH_TYPE_BACK -> R.id.cb_music_back
                SEARCH_TYPE_FORE -> R.id.cb_music_fore
                else -> R.id.cb_music_auto
            }
        )
        searchType.setOnCheckedChangeListener { group, checkedId ->
            Const.SP_MUSIC_SEARCH_TYPE = when (checkedId) {
                R.id.cb_music_back -> SEARCH_TYPE_BACK
                R.id.cb_music_fore -> SEARCH_TYPE_FORE
                else -> SEARCH_TYPE_AUTO
            }
        }

        val autoSwitch = viewHolder.findViewById<CheckBox>(R.id.cb_auto_switch)
        val groupContent = viewHolder.findViewById<HorizontalScrollView>(R.id.hsv_group)
        autoSwitch.setOnCheckedChangeListener { _, isChecked ->
            Const.SP_MUSIC_SWITCH = isChecked
            groupContent.visibility = if (isChecked) View.GONE else View.VISIBLE
            viewHolder.bindingAdapter?.notifyItemChanged(viewHolder.bindingAdapterPosition)
        }
        autoSwitch.isChecked = Const.SP_MUSIC_SWITCH
        if (autoSwitch.isChecked) {
            return
        }

        val infos = withContext(Dispatchers.IO) {
            UiUtils.loadAppInfos(viewHolder.context, matchPkgs(viewHolder.context))
        }

        val lastPkg = Const.SP_MUSIC_PKG

        radio.removeAllViews()
        infos.forEachIndexed { index, appInfo ->
            val auto = RadioButton(viewHolder.context)
            auto.id = index
            auto.text = appInfo.name
            auto.isChecked = appInfo.pkg == lastPkg
            radio.addView(auto)
        }
        radio.setOnCheckedChangeListener { _, id ->
            val item = infos[id]
            Const.SP_MUSIC_PKG = item.pkg
            App.toast("${item.name} : ${item.pkg}")
        }
    }

    fun matchPkgs(context: Context): List<String> {
        val pm = context.packageManager
        return pm.queryBroadcastReceivers(
            Intent(Const.ACTION_AUTOVOICE_SEARCH_PLUS), PackageManager.GET_META_DATA
        ).map { it.activityInfo.packageName }.minus(
            pm.queryBroadcastReceivers(
                Intent(Const.MEDIA_TRANSFORM), PackageManager.GET_META_DATA
            ).map { it.activityInfo.packageName }.toSet()
        ).minus(
            pm.queryBroadcastReceivers(
                Intent(Const.MEDIA_HOST), PackageManager.GET_META_DATA
            ).map { it.activityInfo.packageName }.toSet()
        )
    }

    suspend fun resend(context: Context, intent: Intent) {
        val pkg = findResendPkg(context) ?: return run {
            Toast.makeText(context, "没有可播放的音乐App", Toast.LENGTH_SHORT).show()
        }
        Const.SP_MUSIC_PKG = pkg

        val type = Const.SP_MUSIC_SEARCH_TYPE

        //当前应用不是正在播放的应用
        if (type == SEARCH_TYPE_FORE || pkg != BYDAutoUtils.getCurrentAudioFocusPackage()) {
            UiUtils.tryLaunch(context, pkg)
            delay(1000)
        }


        val bg = when (type) {
            SEARCH_TYPE_BACK -> true
            SEARCH_TYPE_FORE -> false
            else -> UiManager.isResumePkg(BYDAutoUtils.getCurrentAudioFocusPackage())
        }


        val newIntent = Intent(intent.action)
        newIntent.flags = intent.flags
        newIntent.putExtras(intent)
        newIntent.setPackage(pkg)
        newIntent.putExtra("pkgName", pkg)
        newIntent.putExtra("HAD_BEEN_RESEND_TO", context.packageName)
        newIntent.putExtra("IS_BACKGROUND", if (bg) "TRUE" else "FALSE")
        newIntent.putExtra("is_background", bg)
        context.sendBroadcast(newIntent)
        App.log("sendBroadcast : pkg=$pkg ; background=$bg ; intent=$newIntent")
    }


    suspend fun findResendPkg(context: Context): String? {
        //获取当前正在播放的软件
        val currentPlayPkg = BYDAutoUtils.getCurrentAudioFocusPackage()
        val lastPkg = Const.SP_MUSIC_PKG
        if (currentPlayPkg.isNotEmpty() && Const.SP_MUSIC_PKG == currentPlayPkg) {
            return currentPlayPkg
        }

        val matchs = withContext(Dispatchers.IO) { matchPkgs(context) }
        if (Const.SP_MUSIC_SWITCH) {
            return when {
                matchs.contains(currentPlayPkg) -> currentPlayPkg
                matchs.contains(lastPkg) -> lastPkg
                else -> matchs.firstOrNull()
            }
        }
        return if (matchs.contains(lastPkg)) lastPkg else matchs.firstOrNull()
    }
}