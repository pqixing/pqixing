package com.pqixing.bydauto.setting.item

import android.content.Context
import android.content.pm.ActivityInfo
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.bydauto.R
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.utils.UiUtils
import com.pqixing.bydauto.widget.DefaultFloatView

class BootItem : SettingImpl(R.layout.setting_boot) {
    companion object {
        const val FLOAT_TAG_ROTATION = "FLOAT_TAG_ROTATION"
        const val CHARGE_TYPE_NONE: String = "CHARGE_TYPE_NONE"
        const val CHARGE_TYPE_OPEN: String = "CHARGE_TYPE_OPEN"
        const val CHARGE_TYPE_CLOSE: String = "CHARGE_TYPE_CLOSE"
    }

    val cids = mapOf(
        CHARGE_TYPE_NONE to R.id.rbChargeNone,
        CHARGE_TYPE_OPEN to R.id.rbChargeOpen,
        CHARGE_TYPE_CLOSE to R.id.rbChargeClose
    )


    private val rids = listOf(
        R.id.rbFullSensor to ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR,
        R.id.rbLandScape to ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE,
        R.id.rbPortrait to ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT,
        R.id.rbUndefine to ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    )

    override fun onCreate(context: Context) {
        super.onCreate(context)
        setChargeState()
        showRotation(context)
    }

    private fun showRotation(context: Context) {
        UiUtils.showOrUpdate(RotationItem.FLOAT_TAG_ROTATION) {
            DefaultFloatView(context.applicationContext)
        }
    }

    override fun onDestroy(context: Context) {
        super.onDestroy(context)
        UiUtils.closeFloatView(RotationItem.FLOAT_TAG_ROTATION)
    }

    override fun getNameId(): Int = R.string.setting_name_boot

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        bindChar(viewHolder)
        bindRotation(viewHolder)

    }

    fun bindChar(viewHolder: SViewHolder) {
        val charge = viewHolder.findViewById<RadioGroup>(R.id.rg_charge)
        val lastId = cids[Const.SP_CHARGE_TYPE] ?: R.id.rbChargeNone
        charge.findViewById<RadioButton>(lastId)?.isChecked = true
        charge.setOnCheckedChangeListener { _, checkedId ->
            Const.SP_CHARGE_TYPE = cids.entries.find { it.value == checkedId }?.key ?: CHARGE_TYPE_NONE
            setChargeState()
        }

    }

    fun bindRotation(viewHolder: SViewHolder) {
        val rotate: RadioGroup = viewHolder.findViewById(R.id.rg_orientation)

        val lastCheckedId = rids.find { it.second == Const.SP_ORIENTATION }?.first ?: R.id.rbUndefine
        rotate.findViewById<RadioButton>(lastCheckedId)?.isChecked = true

        rotate.setOnCheckedChangeListener { v, checkedId ->
            val orientation = rids.find { it.first == checkedId }?.second ?: ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            Const.SP_ORIENTATION = orientation
            showRotation(v.context)
        }
    }

    private fun setChargeState() {
        when (Const.SP_CHARGE_TYPE) {
            CHARGE_TYPE_OPEN -> BYDAutoUtils.setWirelessCharging(true)
            CHARGE_TYPE_CLOSE -> BYDAutoUtils.setWirelessCharging(false)
        }
    }
}