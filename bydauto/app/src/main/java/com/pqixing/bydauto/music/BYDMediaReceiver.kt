package com.pqixing.bydauto.music

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.SystemClock
import com.pqixing.bydauto.App
import com.pqixing.bydauto.byd.BYDAutoUtils


class BYDMediaReceiver : BroadcastReceiver() {
    companion object {
        const val LAST_SELECT_MUSIC = "LAST_SELECT_MUSIC"
    }

    override fun onReceive(context: Context, intent: Intent?) {
        val aciton = intent?.action ?: return
        val resend = { pkg: String, bg: Boolean ->
            val newIntent = Intent(aciton)
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
        App.mThread.post { checkLastPkg(context, resend) }
    }

    private fun tryLaunch(context: Context, pkg: String): Boolean {
        return kotlin.runCatching {
            val start: Intent = context.packageManager.getLaunchIntentForPackage(pkg) ?: return false
            start.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(start)
            App.log("checkLastPkg : start launch $pkg")
            SystemClock.sleep(1500L)
        }.onFailure {
            App.log(null, it)
        }.isSuccess
    }

    private fun checkLastPkg(context: Context, invoke: (pkg: String, backGround: Boolean) -> Unit) {

        val pm = context.packageManager

        val modePkg = App.sp.getString(MusicSetting.MUSIC_PKG, MusicSetting.DEFAULT_PKG)!!

        //获取当前正在播放的软件
        val currentPlayPkg = BYDAutoUtils.getCurrentAudioFocusPackage()

        //支持小迪语音的软件
        val matchPkgs = pm.queryBroadcastReceivers(
            Intent("com.byd.action.AUTOVOICE_SEARCH_PLUS"), PackageManager.GET_META_DATA
        ).map { it.activityInfo.packageName }.minus(context.packageName)

        if (matchPkgs.isEmpty()) {
            App.toast("当前没有可以播放的软件")
            return
        }

        if (modePkg != MusicSetting.DEFAULT_PKG && matchPkgs.contains(modePkg)) {
            App.sp.edit().putString(LAST_SELECT_MUSIC, modePkg).apply()
            if (currentPlayPkg != modePkg) {
                tryLaunch(context, modePkg)
            }
            return invoke(modePkg, true)
        }

        App.sp.edit().putString(MusicSetting.MUSIC_PKG, MusicSetting.DEFAULT_PKG).apply()
        if (currentPlayPkg?.isNotEmpty() == true && matchPkgs.contains(currentPlayPkg)) {
            App.sp.edit().putString(LAST_SELECT_MUSIC, currentPlayPkg).apply()
            return invoke(currentPlayPkg, true)
        }

        //上次选择的应用
        val lastSelectPkg = App.sp.getString(LAST_SELECT_MUSIC, null)
        if (lastSelectPkg?.isNotEmpty() == true && matchPkgs.contains(lastSelectPkg)) {
            tryLaunch(context, lastSelectPkg)
            return invoke(currentPlayPkg, true)
        }

        //随机选中第一个
        val firstPkg =
            matchPkgs.find { it.contains("kugou") } ?: matchPkgs.find { it.contains("kuwo") } ?: matchPkgs.first()
        App.toast("use $firstPkg")
        App.sp.edit().putString(LAST_SELECT_MUSIC, firstPkg).apply()
        tryLaunch(context, firstPkg)
        invoke(firstPkg, true)
    }
}