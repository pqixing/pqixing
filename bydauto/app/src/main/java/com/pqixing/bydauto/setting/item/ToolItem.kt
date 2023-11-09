package com.pqixing.bydauto.setting.item

import android.content.Context
import com.pqixing.bydauto.R
import com.pqixing.bydauto.setting.GridSetting
import com.pqixing.bydauto.ui.SingleItem
import com.pqixing.bydauto.ui.SingleItemAdapter

class ToolItem : GridSetting(R.string.app_main_name) {


    override fun getGridDatas(context: Context, adapter: SingleItemAdapter): List<SingleItem> {
        return emptyList()
    }
//
//    private fun onChildCick(view: View) {
//
//        App.uiScope.launch {
//            val text = runCatching {
//                when (view.id) {
//                    R.id.tv_shell_ui -> view.context.startActivity(
//                        Intent(
//                            view.context,
//                            ConnectActivity::class.java
//                        )
//                    )
//
//                    R.id.tv_pull_setting -> {
////                        BYDAutoChargingDevice.getInstance(App.get()).registerListener(object :AbsBYDAutoChargingListener(){
////                            override fun onSocSaveSwitchChanged(i: Int) {
////                                super.onSocSaveSwitchChanged(i)
////                                "onSocSaveSwitchChanged $i".toast()
////                            }
////                        })
//                        BYDAutoInstrumentDevice::class.java.methods.filter {
//                            it.name.toUpperCase().contains("WIRELESS")
//                        }.joinToString { it.name }.toast()
//                    }
//
//                    R.id.tv_action_split -> {
//                        CAService.perform(AccessibilityService.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN)
//                    }
//
//                    R.id.tv_action_taiya -> {
//                        UiUtils.sendDiCmd("胎压查询")
//                    }
//
//                    else -> null
//                }.toString()
//            }.getOrElse {
//                it.printStackTrace()
//                it.message
//            }
//            App.toast("result : $text")
////            AlertDialog.Builder(view.context).setTitle("执行结果").setMessage(text).show()
//        }
//    }
}