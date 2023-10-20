//refactor
package android.hardware.bydauto.charging;

import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
public abstract class AbsBYDAutoChargingListener implements IBYDAutoListener {
public void onBatteryManagementDeviceStateChanged(int i) { }
public void onBatteryTypeChanged(int i) { }
public void onChargeTempCtlStateChanged(int i) { }
public void onChargerFaultStateChanged(int i) { }
public void onChargerStateChanged(int i) { }
public void onChargerWorkStateChanged(int i) { }
public void onChargingCapStateChanged(int i, int i2) { }
public void onChargingCapacityChanged(double d2) { }
public void onChargingGunNotInsertedStateChanged(int i) { }
public void onChargingGunStateChanged(int i) { }
public void onChargingModeChanged(int i) { }
public void onChargingPortLockRebackStateChanged(int i) { }
public void onChargingPowerChanged(double d2) { }
public void onChargingRestTimeChanged(int i, int i2) { }
public void onChargingScheduleEnableStateChanged(int i) { }
public void onChargingScheduleStateChanged(int i) { }
public void onChargingScheduleTimeChanged(int i, int i2) { }
public void onChargingStateChanged(int i) { }
public void onChargingTimerInfoChanged(ChargingTimerInfo chargingTimerInfo) { }
public void onChargingTypeChanged(int i) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDisChargeWarningStateChanged(int i) { }
public void onDischargeRequestStateChanged(int i) { }
public void onDischargeStateChanged(int i, int i2) { }
public void onFeatureChanged(String str, int i) { }
public void onSmartChargingStateChanged(int i) { }
public void onWirelessChargingOnline5sStateChanged(int i) { }
public void onWirelessChargingSwitchStateChanged(int i) { }
public void onWirlessChargingStateChanged(int i) { }
public void onSocSaveSwitchChanged(int i) { }

 }
