package com.pqixing.bydauto.setting.item

import android.content.Context
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.bydauto.model.Const
import com.pqixing.bydauto.R
import com.pqixing.bydauto.utils.BYDAutoUtils
import com.pqixing.bydauto.setting.SViewHolder
import com.pqixing.bydauto.setting.SettingImpl

class WirelessCharge : SettingImpl(R.layout.setting_charge) {
    companion object {
        const val CHARGE_TYPE_NONE: String = "CHARGE_TYPE_NONE"
        const val CHARGE_TYPE_OPEN: String = "CHARGE_TYPE_OPEN"
        const val CHARGE_TYPE_CLOSE: String = "CHARGE_TYPE_CLOSE"
    }

    val ids = mapOf(
        CHARGE_TYPE_NONE to R.id.rbChargeNone,
        CHARGE_TYPE_OPEN to R.id.rbChargeOpen,
        CHARGE_TYPE_CLOSE to R.id.rbChargeClose
    )

    override fun onCreate(context: Context) {
        super.onCreate(context)
        setChargeState()
    }

    override fun getNameId(): Int= R.string.setting_name_charge

    override suspend fun onBindViewHolder(viewHolder: SViewHolder) {
        val charge = viewHolder.findViewById<RadioGroup>(R.id.group)

        val lastId = ids[Const.SP_CHARGE_TYPE] ?: R.id.rbChargeNone

        setChargeState()
        charge.findViewById<RadioButton>(lastId)?.isChecked = true
        charge.setOnCheckedChangeListener { _, checkedId ->
            Const.SP_CHARGE_TYPE = ids.entries.find { it.value == checkedId }?.key ?: CHARGE_TYPE_NONE
            setChargeState()
        }
    }

    private fun setChargeState() {
        when (Const.SP_CHARGE_TYPE) {
            CHARGE_TYPE_OPEN -> BYDAutoUtils.setWirelessCharging(true)
            CHARGE_TYPE_CLOSE -> BYDAutoUtils.setWirelessCharging(false)
        }
    }
}