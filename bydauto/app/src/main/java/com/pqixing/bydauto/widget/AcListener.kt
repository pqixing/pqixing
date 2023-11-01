package com.pqixing.bydauto.widget

import android.hardware.bydauto.ac.AbsBYDAutoAcListener

class AcListener(val info: AutoInfo) : AbsBYDAutoAcListener() {

    override fun onAcCtrlModeChanged(i: Int) {
        super.onAcCtrlModeChanged(i)
        info.exeLoad { it.ac_control_model }
    }


    override fun onTemperatureChanged(i: Int, i2: Int) {
        super.onTemperatureChanged(i, i2)
        info.exeLoad { it.ac_temp }
    }

    override fun onAcWindLevelChanged(i: Int) {
        super.onAcWindLevelChanged(i)
        info.exeLoad { it.ac_wind }
    }

    override fun onAcStarted() {
        super.onAcStarted()
        info.exeLoad { it.ac_open }
    }

    override fun onAcStoped() {
        super.onAcStoped()
        info.exeLoad { it.ac_open }
    }

    override fun onAcCycleModeChanged(i: Int) {
        super.onAcCycleModeChanged(i)
        info.exeLoad { it.ac_loop }
    }

    override fun onAcTemperatureControlModeChanged(i: Int) {
        super.onAcTemperatureControlModeChanged(i)
        info.exeLoad { it.ac_separate;it.ac_temp }
    }

    override fun onAcVentilationStateChanged(i: Int) {
        super.onAcVentilationStateChanged(i)
        info.exeLoad { it.ac_vent }
    }

}