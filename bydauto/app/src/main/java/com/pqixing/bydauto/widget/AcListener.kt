package com.pqixing.bydauto.widget

import android.hardware.bydauto.ac.AbsBYDAutoAcListener
import com.pqixing.bydauto.utils.toast

class AcListener(val info: AcControlInfo) : AbsBYDAutoAcListener() {

    override fun onAcCtrlModeChanged(i: Int) {
        super.onAcCtrlModeChanged(i)
        info.exeLoad { it.auto }
    }


    override fun onTemperatureChanged(i: Int, i2: Int) {
        super.onTemperatureChanged(i, i2)
        info.exeLoad { it.temp }
    }

    override fun onAcWindLevelChanged(i: Int) {
        super.onAcWindLevelChanged(i)
        info.exeLoad { it.wind }
    }

    override fun onAcStarted() {
        super.onAcStarted()
        info.exeLoad { it.open }
    }

    override fun onAcStoped() {
        super.onAcStoped()
        info.exeLoad { it.open }
    }

    override fun onAcCycleModeChanged(i: Int) {
        super.onAcCycleModeChanged(i)
        info.exeLoad { it.inLoop }
    }

    override fun onAcTemperatureControlModeChanged(i: Int) {
        super.onAcTemperatureControlModeChanged(i)
        info.exeLoad { it.separate;it.temp }
    }

    override fun onAcVentilationStateChanged(i: Int) {
        super.onAcVentilationStateChanged(i)
        info.exeLoad { it.ventilation }
    }

}