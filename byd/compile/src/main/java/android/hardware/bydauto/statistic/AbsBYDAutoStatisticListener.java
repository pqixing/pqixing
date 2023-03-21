//refactor
package android.hardware.bydauto.statistic;
import android.hardware.IBYDAutoEvent;
import android.hardware.IBYDAutoListener;
import android.util.Log;
public abstract class AbsBYDAutoStatisticListener implements IBYDAutoListener {
public void onAverageElectricConsumptionChanged(int i, double d2) { }
public void onAverageFuelConsumptionChanged(int i, double d2) { }
public void onAverageSpeedChanged(int i, double d2) { }
public void onDataChanged(IBYDAutoEvent iBYDAutoEvent) { }
public void onDrivingTimeChanged(double d2) { }
public void onEVDrivingMileageConfigChanged(int i) { }
public void onEVDrivingMileageModeChanged(int i) { }
public void onEVMileageValueChanged(int i) { }
public void onElecDrivingRangeChanged(int i) { }
public void onElecPercentageChanged(double d2) { }
public void onElectricConsumptionChanged(int i, double d2) { }
public void onFuelADValueChanged(int i) { }
public void onFuelConsumptionChanged(int i, double d2) { }
public void onFuelDrivingRangeChanged(int i) { }
public void onFuelPercentageChanged(int i) { }
public void onHEVMileageValueChanged(int i) { }
public void onInstantElecConChanged(double d2) { }
public void onInstantFuelConChanged(double d2) { }
public void onKeyBatteryLevelChanged(int i) { }
public void onLastElecConPHMChanged(double d2) { }
public void onLastFuelConPHMChanged(double d2) { }
public void onMessage5sOnlineStateChanged(int i, int i2) { }
public void onSOCBatteryPercentageChanged(int i) { }
public void onTotalElecConChanged(double d2) { }
public void onTotalElecConPHMChanged(double d2) { }
public void onTotalFuelConChanged(double d2) { }
public void onTotalFuelConPHMChanged(double d2) { }
public void onTotalMileageValueChanged(int i) { }
public void onTravelTimeChanged(int i, double d2) { }
public void onWaterTemperatureChanged(int i) { }
 }
