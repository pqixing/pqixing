package com.pqixing.bydauto.setting.item

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.view.View
import android.widget.CheckBox
import android.widget.HorizontalScrollView
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MusicForward : SettingImpl(R.layout.setting_music) {
    override fun getNameId(): Int = R.string.setting_name_music

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val radio: RadioGroup = viewHolder.findViewById(R.id.group)

        val musicBackGround = viewHolder.findViewById<CheckBox>(R.id.cb_music_background)
        musicBackGround.isChecked = Const.SP_MUSIC_BACKGROUND
        musicBackGround.setOnCheckedChangeListener { _, isChecked -> Const.SP_MUSIC_BACKGROUND = isChecked }

        val autoSwitch = viewHolder.findViewById<CheckBox>(R.id.cb_auto_switch)
        val groupContent = viewHolder.findViewById<HorizontalScrollView>(R.id.hsv_group)
        autoSwitch.setOnCheckedChangeListener { _, isChecked ->
            Const.SP_MUSIC_SWITCH = isChecked
            groupContent.visibility = if (isChecked) View.GONE else View.VISIBLE
            viewHolder.bindingAdapter?.notifyItemChanged(viewHolder.bindingAdapterPosition)
        }
        autoSwitch.isChecked = Const.SP_MUSIC_SWITCH
        if (groupContent.visibility != View.VISIBLE) {
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
            Intent(Const.ACTION_AUTOVOICE_SEARCH_PLUS),
            PackageManager.GET_META_DATA
        ).map { it.activityInfo.packageName }.minus(
            pm.queryBroadcastReceivers(
                Intent(Const.MEDIA_TRANSFORM),
                PackageManager.GET_META_DATA
            ).map { it.activityInfo.packageName }.toSet()
        ).minus(
            pm.queryBroadcastReceivers(
                Intent(Const.MEDIA_HOST),
                PackageManager.GET_META_DATA
            ).map { it.activityInfo.packageName }.toSet()
        )
    }

    suspend fun resend(context: Context, intent: Intent) {
        val pkg = findResendPkg(context) ?: return

        context.packageManager.getLaunchIntentForPackage(pkg)?.runCatching {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(this)
            delay(500)
        }
        UiUtils.tryLaunch(context, pkg)

        val bg = Const.SP_MUSIC_BACKGROUND
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
        if (currentPlayPkg.isNotEmpty() && Const.SP_MUSIC_PKG == currentPlayPkg) {
            return currentPlayPkg
        }

        val matchs = withContext(Dispatchers.IO) { matchPkgs(context) }
        if (Const.SP_MUSIC_SWITCH) {
            return if (matchs.contains(currentPlayPkg)) {
                Const.SP_MUSIC_PKG = currentPlayPkg
                currentPlayPkg
            } else null
        }
        val lastSelect = Const.SP_MUSIC_PKG.takeIf { matchs.contains(it) } ?: matchs.firstOrNull()
        if (!lastSelect.isNullOrBlank()) {
            Const.SP_MUSIC_PKG = lastSelect
        }
        return lastSelect
    }
}