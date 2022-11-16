package com.pqixing.android.byd

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.android.App
import com.pqixing.android.R
import com.pqixing.android.setting.DSetting

class ChargeSetting : DSetting("无线充电") {
    companion object {
        const val CHARGE_TYPE: String = "CHARGE_TYPE"
    }

    val ids = mapOf("NONE" to R.id.rbChargeNone, "OPEN" to R.id.rbChargeOpen, "CLOSE" to R.id.rbChargeClose)
    override fun onUiCreate(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View {
        val charge = inflater.inflate(R.layout.setting_charge, container, false) as RadioGroup
        val lastId = ids[App.sp.getString(CHARGE_TYPE, "NONE")] ?: R.id.rbChargeNone
        onChargeSet(activity, lastId)
        charge.findViewById<RadioButton>(lastId)?.isChecked = true
        charge.setOnCheckedChangeListener { _, checkedId ->
            App.sp.edit().putString(CHARGE_TYPE, ids.entries.find { it.value == checkedId }?.key ?: "NONE").apply()
            onChargeSet(activity, checkedId)
        }
        return charge
    }

    override fun onServiceCreate(context: Context) {
        super.onServiceCreate(context)
        val lastId = ids[App.sp.getString(CHARGE_TYPE, "NONE")] ?: R.id.rbChargeNone
        onChargeSet(context, lastId)
    }

    private fun onChargeSet(context: Context, id: Int) {
        when (id) {
            R.id.rbChargeOpen -> BYDAutoInstrumentUtils.setAir(1)
            R.id.rbChargeClose -> BYDAutoInstrumentUtils.setAir(2)
        }
    }
}