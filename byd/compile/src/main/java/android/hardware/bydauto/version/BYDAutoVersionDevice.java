//refactor
package android.hardware.bydauto.version;
import android.content.Context;
import android.hardware.IBYDAutoListener;
import android.hardware.bydauto.AbsBYDAutoDevice;
import android.hardware.bydauto.BYDAutoConstants;
import android.hardware.bydauto.BYDAutoEvent;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
public final class BYDAutoVersionDevice extends AbsBYDAutoDevice {
public static final int VERSION_AC = 13;
public static final int VERSION_BATTERY_CTRL = 9;
public static final int VERSION_CAR_CHARGER = 10;
public static final int VERSION_COMMAND_BUSY = -2147482647;
public static final int VERSION_COMMAND_FAILED = -2147482648;
public static final int VERSION_COMMAND_INVALID_VALUE = -2147482645;
public static final int VERSION_COMMAND_SUCCESS = 0;
public static final int VERSION_COMMAND_TIMEOUT = -2147482646;
public static final int VERSION_DSP = 2;
public static final int VERSION_DSP_BOOT = 12;
public static final int VERSION_DTC = 12;
public static final int VERSION_ENGINE_CTRL = 4;
public static final int VERSION_INSTRUMENT = 3;
public static final int VERSION_MCU = 1;
public static final int VERSION_MCU_BOOT = 11;
public static final int VERSION_MOTOR_CTRL = 6;
public static final int VERSION_MOTOR_CTRL_F = 7;
public static final int VERSION_MOTOR_CTRL_R = 8;
public static final int VERSION_TRANS_CTRL = 5;
public static synchronized BYDAutoVersionDevice getInstance(Context context) { return null; }
public String getACEcuVersion() { return null; }
public void getAllStatus() { }
public String getBatteryCtrlVersion() { return null; }
public String getCarChargerVersion() { return null; }
public String getDSPBootVersion() { return null; }
public String getDspVersion() { return null; }
public String getDtcVersion() { return null; }
public String getEngineCtrlVersion() { return null; }
public int[] getFeatureList() { return null; }
public String getInstrumentVersion() { return null; }
public String getMcuBootVersion() { return null; }
public String getMcuVersion() { return null; }
public String getMotorCtrl1Version() { return null; }
public String getMotorCtrl2Version() { return null; }
public String getMotorCtrl3Version() { return null; }
public String getTransmissionCtrlVersion() { return null; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public int queryAcEcuVersion() { return 0; }
public int queryBatteryCtrlVersion() { return 0; }
public int queryCarChargerVersion() { return 0; }
public int queryDSPBootVersion() { return 0; }
public int queryDspVersion() { return 0; }
public int queryEngineCtrlVersion() { return 0; }
public int queryInstrumentVersion() { return 0; }
public int queryMcuBootVersion() { return 0; }
public int queryMcuVersion() { return 0; }
public int queryMotorCtrl1Version() { return 0; }
public int queryMotorCtrl2Version() { return 0; }
public int queryMotorCtrl3Version() { return 0; }
public int queryTransmissionCtrlVersion() { return 0; }
public void registerListener(AbsBYDAutoVersionListener absBYDAutoVersionListener) { }
public void setAllStatus() { }
public void unregisterListener(AbsBYDAutoVersionListener absBYDAutoVersionListener) { }
public void registerListener(AbsBYDAutoVersionListener absBYDAutoVersionListener, int[] iArr) { }
 }
