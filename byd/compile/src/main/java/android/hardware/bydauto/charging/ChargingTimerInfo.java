package android.hardware.bydauto.charging;

/* loaded from: classes.dex */
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
    private int timerSwitch = 0;
    private int timerType = 3;
    private int timerUnitHour = 0;
    private int timerUnitMinite = 0;
    private int timerCycleMon = 0;
    private int timerCycleTue = 0;
    private int timerCycleWed = 0;
    private int timerCycleThu = 0;
    private int timerCycleFri = 0;
    private int timerCycleSat = 0;
    private int timerCycleSun = 0;

    public int getTimerCycleFri() {
        return this.timerCycleFri;
    }

    public int getTimerCycleMon() {
        return this.timerCycleMon;
    }

    public int getTimerCycleSat() {
        return this.timerCycleSat;
    }

    public int getTimerCycleSun() {
        return this.timerCycleSun;
    }

    public int getTimerCycleThu() {
        return this.timerCycleThu;
    }

    public int getTimerCycleTue() {
        return this.timerCycleTue;
    }

    public int getTimerCycleWed() {
        return this.timerCycleWed;
    }

    public int getTimerSwitch() {
        return this.timerSwitch;
    }

    public int getTimerType() {
        return this.timerType;
    }

    public int getTimerUnitHour() {
        return this.timerUnitHour;
    }

    public int getTimerUnitMinite() {
        return this.timerUnitMinite;
    }

    public void setTimerCycleFri(int i) {
        this.timerCycleFri = i;
    }

    public void setTimerCycleMon(int i) {
        this.timerCycleMon = i;
    }

    public void setTimerCycleSat(int i) {
        this.timerCycleSat = i;
    }

    public void setTimerCycleSun(int i) {
        this.timerCycleSun = i;
    }

    public void setTimerCycleThu(int i) {
        this.timerCycleThu = i;
    }

    public void setTimerCycleTue(int i) {
        this.timerCycleTue = i;
    }

    public void setTimerCycleWed(int i) {
        this.timerCycleWed = i;
    }

    public void setTimerSwitch(int i) {
        this.timerSwitch = i;
    }

    public void setTimerType(int i) {
        this.timerType = i;
    }

    public void setTimerUnitHour(int i) {
        this.timerUnitHour = i;
    }

    public void setTimerUnitMinite(int i) {
        this.timerUnitMinite = i;
    }
}
