//refactor
package android.hardware.bydauto.cputemprature;
import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.util.Log;
public final class BYDAutoCpuTempratureDevice extends AbsBYDAutoDevice {
public static final int CPUTEMPRATURE_COMMAND_BUSY = -2147482647;
public static final int CPUTEMPRATURE_COMMAND_FAILED = -2147482648;
public static final int CPUTEMPRATURE_COMMAND_INVALID_VALUE = -2147482645;
public static final int CPUTEMPRATURE_COMMAND_SUCCESS = 0;
public static final int CPUTEMPRATURE_COMMAND_TIMEOUT = -2147482646;
public static final int CPU_TEMPRATURE = 1;
public static final int CPU_TEMPRATURE_MAX = 155;
public static final int CPU_TEMPRATURE_MIN = -100;
public static final int PMIC_TEMPRATURE = 2;
public static final int PMIC_TEMPRATURE_MAX = 155;
public static final int PMIC_TEMPRATURE_MIN = -100;
public static final int TEC_CTL = 3;
public static final int TEC_CTL_MAX = 100;
public static final int TEC_CTL_MIN = 0;
public static synchronized BYDAutoCpuTempratureDevice getInstance(Context context) { return null; }
public int[] getFeatureList() { return null; }
public int getType() { return 0; }
public void setAllStatus() { }
public int setCpuTemprature(int i) { return 0; }
public int setPmicTemprature(int i) { return 0; }
public int setTecCtrlLevel(int i) { return 0; }
public int setTemprature(int i, int i2) { return 0; }
 }
