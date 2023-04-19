//refactor
package android.hardware.bydauto.charging;
public class ChargingTimerInfo {
public static final int TIMER_24H_HOUR_INVALID = 24;
public static final int TIMER_24H_HOUR_MAX = 23;
public static final int TIMER_24H_HOUR_MIN = 0;
public static final int TIMER_24H_MINITE_INVALID = 60;
public static final int TIMER_24H_MINITE_MAX = 59;
public static final int TIMER_24H_MINITE_MIN = 0;
public static final int TIMER_CYCLE_DAY_DISABLE = 0;
public static final int TIMER_CYCLE_DAY_ENABLE = 1;
public static final int TIMER_SWITCH_INVALID = -1;
public static final int TIMER_SWITCH_OFF = 0;
public static final int TIMER_SWITCH_ON = 1;
public static final int TIMER_TYPE_1 = 3;
public static final int TIMER_TYPE_2 = 4;
public int getTimerCycleFri() { return 0; }
public int getTimerCycleMon() { return 0; }
public int getTimerCycleSat() { return 0; }
public int getTimerCycleSun() { return 0; }
public int getTimerCycleThu() { return 0; }
public int getTimerCycleTue() { return 0; }
public int getTimerCycleWed() { return 0; }
public int getTimerSwitch() { return 0; }
public int getTimerType() { return 0; }
public int getTimerUnitHour() { return 0; }
public int getTimerUnitMinite() { return 0; }
public void setTimerCycleFri(int i) { }
public void setTimerCycleMon(int i) { }
public void setTimerCycleSat(int i) { }
public void setTimerCycleSun(int i) { }
public void setTimerCycleThu(int i) { }
public void setTimerCycleTue(int i) { }
public void setTimerCycleWed(int i) { }
public void setTimerSwitch(int i) { }
public void setTimerType(int i) { }
public void setTimerUnitHour(int i) { }
public void setTimerUnitMinite(int i) { }
 }
