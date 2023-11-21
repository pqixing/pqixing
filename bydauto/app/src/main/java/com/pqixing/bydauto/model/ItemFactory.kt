package com.pqixing.bydauto.model

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.ui.MainUI
import com.pqixing.bydauto.ui.SingleItem
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.BYDUtils
import com.pqixing.bydauto.utils.UiUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object ItemFactory {

    fun minMenus() = createMenus().subList(0, 4)
    fun maxMenus() = createMenus()


    fun createMenus() = listOf(
        SingleItem("下拉菜单", R.drawable.icon_menu_pull_down) {
            App.uiScope.launch {
                AdbManager.getClient().runSync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
                delay(100)
                AdbManager.getClient().runSync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
            }
        },

        SingleItem("地图|音乐", R.drawable.icon_menu_app) {
            UiUtils.fastLauch(it.context)
        },
        SingleItem("返回", R.drawable.icon_menu_back) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_BACK)
        },
        SingleItem("桌面", R.drawable.icon_menu_home) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_HOME)
        },
        SingleItem("最近", R.drawable.icon_menu_recent) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_RECENTS)
        },
        SingleItem("分屏", R.drawable.icon_menu_split) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
        },

        SingleItem("互换", R.drawable.icon_menu_change) {
            BYDUtils.sendDiCmd("左右屏幕互换")
        },

        SingleItem("全屏", R.drawable.icon_menu_full) {
            UiUtils.switchFullScreen(it.context, !Const.SP_FULL_SCREEN)
        },
        SingleItem("锁屏", R.drawable.icon_menu_lock_screen) {
            BYDUtils.sendDiCmd("关闭屏幕")
        },
        SingleItem("设置", R.drawable.icon_menu_setting) {
            UiUtils.tryLaunch(it.context, Intent(it.context, MainUI::class.java))
        },
        SingleItem("通知", R.drawable.icon_menu_notify) {
            CAService.perform(AccessibilityService.GLOBAL_ACTION_NOTIFICATIONS)
        },
    )

}