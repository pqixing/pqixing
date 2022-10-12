package com.pqixing.android.charger

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.pqixing.android.App
import com.pqixing.android.setting.DSetting
import com.pqixing.android.byd.BYDAutoInstrumentUtils
import com.pqixing.android.R

class ChargeSetting : DSetting("无线充电") {
    companion object {
        const val IS_CHARGE: String = "IS_CHARGE"
    }

    override fun onUiCreate(activity: Activity, inflater: LayoutInflater, container: ViewGroup): View {
        val charge = inflater.inflate(R.layout.setting_charge, container, false) as RadioGroup
        val lastCheckId = App.sp.getInt(IS_CHARGE, R.id.rbChargeNone)
        onChargeSet(activity, lastCheckId)
        charge.findViewById<RadioButton>(lastCheckId)?.isChecked = true
        charge.setOnCheckedChangeListener { _, checkedId ->
            App.sp.edit().putInt(IS_CHARGE, checkedId).apply()
            onChargeSet(activity, checkedId)
        }
        return charge
    }

    override fun onServiceCreate(context: Context) {
        super.onServiceCreate(context)
        onChargeSet(context, App.sp.getInt(IS_CHARGE, R.id.rbChargeNone))
    }

    private fun onChargeSet(context: Context, id: Int) {
        when (id) {
            R.id.rbChargeOpen -> BYDAutoInstrumentUtils.setAir(1)
            R.id.rbChargeClose -> BYDAutoInstrumentUtils.setAir(2)
        }
    }
}