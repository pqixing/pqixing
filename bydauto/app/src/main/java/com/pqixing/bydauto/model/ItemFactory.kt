package com.pqixing.bydauto.model

import android.accessibilityservice.AccessibilityService
import android.content.ComponentName
import android.content.Intent
import com.pqixing.bydauto.App
import com.pqixing.bydauto.R
import com.pqixing.bydauto.service.CAService
import com.pqixing.bydauto.ui.MainUI
import com.pqixing.bydauto.ui.SingleItem
import com.pqixing.bydauto.utils.AdbManager
import com.pqixing.bydauto.utils.BYDUtils
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.widget.AutoInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object ItemFactory {

    fun createMenus(autoInfo: AutoInfo) = listOf(
        SingleItem("下拉菜单", R.drawable.icon_menu_pull_down) {
            App.uiScope.launch {
                AdbManager.getClient().runSync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
                delay(100)
                AdbManager.getClient().runSync("input swipe 100 ${if (Const.SP_FULL_SCREEN) -10 else 0} 100 300")
            }
        },

        SingleItem("强保", R.drawable.icon_menu_soc_save) {
            autoInfo.soc_mode = !autoInfo.soc_mode
        }.update {
            it.select = autoInfo.soc_mode
            it.name = "强保:" + autoInfo.soc_target
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


    fun createAc(autoInfo: AutoInfo) = listOf(
        SingleItem("空调", R.drawable.icon_menu_ac_start) {
            autoInfo.ac_open = !autoInfo.ac_open
        }.update { it.select = autoInfo.ac_open },

        SingleItem("自动模式", R.drawable.icon_menu_ac_auto) {
            autoInfo.ac_control_model = !autoInfo.ac_control_model
        }.update {
            it.select = autoInfo.ac_control_model
        },

        SingleItem("主驾通风", R.drawable.icon_menu_seat_vent) {
            autoInfo.ac_vent_main = !autoInfo.ac_vent_main
        }.update {
            it.select = autoInfo.ac_vent_main
        },

        SingleItem("副驾通风", R.drawable.icon_menu_seat_vent) {
            autoInfo.ac_vent_deputy = !autoInfo.ac_vent_deputy
        }.update {
            it.select = autoInfo.ac_vent_deputy
        },

        SingleItem("内循环", R.drawable.icon_menu_ac_inloop) {
            autoInfo.ac_loop = !autoInfo.ac_loop
        }.update {
            it.name = if (autoInfo.ac_loop) "内循环" else "外循环"
            it.select = autoInfo.ac_loop
            it.icon = if (autoInfo.ac_loop) R.drawable.icon_menu_ac_inloop else R.drawable.icon_menu_ac_outloop
        },

        SingleItem("通风", R.drawable.icon_menu_ac_ventilation) {
            autoInfo.ac_vent = !autoInfo.ac_vent
        }.update {
            it.select = autoInfo.ac_vent
        },

        SingleItem("分控", R.drawable.icon_menu_split) {
            autoInfo.ac_separate = !autoInfo.ac_separate
        }.update {
            it.select = autoInfo.ac_separate
        },
        SingleItem("空调面板", R.drawable.icon_menu_ac_more) {
            val intent = Intent().setComponent(
                ComponentName("com.byd.airconditioning", "com.byd.airconditioning.mainactivity.FullScreenMainActivity")
            )
            UiUtils.tryLaunch(it.context, intent)
        },

        SingleItem("主驾加热", R.drawable.icon_menu_seat_heat) {
            autoInfo.ac_heat_main = !autoInfo.ac_heat_main
        }.update {
            it.select = autoInfo.ac_heat_main
        },

        SingleItem("副驾加热", R.drawable.icon_menu_seat_heat) {
            autoInfo.ac_heat_deputy = !autoInfo.ac_heat_deputy
        }.update {
            it.select = autoInfo.ac_heat_deputy
        },
    )

    fun createWinds(autoInfo: AutoInfo): List<SingleItem> {
        return (1..7).toList().map { i ->
            SingleItem("$i") {
                autoInfo.ac_wind = i
            }.update {
                it.select = autoInfo.ac_wind == i
            }
        }
    }

    fun createTemps(autoInfo: AutoInfo): List<SingleItem> {
        return (17..33).toList().map { i ->
            SingleItem(if (i == 17) "Lo" else if (i == 33) "Hi" else i.toString()) {
                autoInfo.ac_temp = i
            }.update {
                it.select = autoInfo.ac_temp == i
            }
        }
    }
}