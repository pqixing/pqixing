//refactor
package android.hardware.bydauto.radar;

import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
public final class BYDAutoRadarDevice extends AbsBYDAutoDevice {
public static final int RADAR_AREA_FRONT_LEFT_MID = 7;
public static final int RADAR_AREA_FRONT_RIGHT_MID = 8;
public static final int RADAR_AREA_LEFT = 5;
public static final int RADAR_AREA_LEFT_FRONT = 1;
public static final int RADAR_AREA_LEFT_REAR = 3;
public static final int RADAR_AREA_MIDDLE_REAR = 9;
public static final int RADAR_AREA_RIGHT = 6;
public static final int RADAR_AREA_RIGHT_FRONT = 2;
public static final int RADAR_AREA_RIGHT_REAR = 4;
public static final int RADAR_COMMAND_BUSY = -2147482647;
public static final int RADAR_COMMAND_FAILED = -2147482648;
public static final int RADAR_COMMAND_INVALID_VALUE = -2147482645;
public static final int RADAR_COMMAND_SUCCESS = 0;
public static final int RADAR_COMMAND_TIMEOUT = -2147482646;
public static final int RADAR_DISTANCE_MAX = 155;
public static final int RADAR_DISTANCE_MIN = 0;
public static final int RADAR_MANUFACTURE = 19;
public static final int RADAR_MANUFACTURE_15_SECTOR = 0;
public static final int RADAR_MANUFACTURE_VALEO = 1;
public static final int RADAR_MR_OBSTACLE_DIS = 21;
public static final int RADAR_MR_SONDE_STATUS = 20;
public static final int RADAR_OBSTACLE_DISTANCE_ALL = 2;
public static final int RADAR_OBSTACLE_DISTANCE_FRONT_LEFT_MID = 14;
public static final int RADAR_OBSTACLE_DISTANCE_FRONT_RIGHT_MID = 16;
public static final int RADAR_OBSTACLE_DISTANCE_LEFT = 10;
public static final int RADAR_OBSTACLE_DISTANCE_LEFT_FRONT = 2;
public static final int RADAR_OBSTACLE_DISTANCE_LEFT_REAR = 6;
public static final int RADAR_OBSTACLE_DISTANCE_MAX = 6;
public static final int RADAR_OBSTACLE_DISTANCE_MIN = 0;
public static final int RADAR_OBSTACLE_DISTANCE_RIGHT = 12;
public static final int RADAR_OBSTACLE_DISTANCE_RIGHT_FRONT = 4;
public static final int RADAR_OBSTACLE_DISTANCE_RIGHT_REAR = 8;
public static final int RADAR_OBSTACLE_DISTANCE_SAFE = 14;
public static final int RADAR_OBSTACLE_DIS_MAX = 12;
public static final int RADAR_PROBE_STATE_ABNORMAL = 0;
public static final int RADAR_PROBE_STATE_ALL = 1;
public static final int RADAR_PROBE_STATE_FRONT_LEFT_MID = 13;
public static final int RADAR_PROBE_STATE_FRONT_RIGHT_MID = 15;
public static final int RADAR_PROBE_STATE_GREEN = 2;
public static final int RADAR_PROBE_STATE_LEFT = 9;
public static final int RADAR_PROBE_STATE_LEFT_FRONT = 1;
public static final int RADAR_PROBE_STATE_LEFT_REAR = 5;
public static final int RADAR_PROBE_STATE_RED = 4;
public static final int RADAR_PROBE_STATE_RIGHT = 11;
public static final int RADAR_PROBE_STATE_RIGHT_FRONT = 3;
public static final int RADAR_PROBE_STATE_RIGHT_REAR = 7;
public static final int RADAR_PROBE_STATE_SAFE = 1;
public static final int RADAR_PROBE_STATE_YELLOW = 3;
public static final int RADAR_REVERSE_SWITCH_OFF = 0;
public static final int RADAR_REVERSE_SWITCH_ON = 1;
public static final int RADAR_SOUND_STATE = 18;
public static final int RADAR_SOUND_STATE_OFF = 0;
public static final int RADAR_SOUND_STATE_ON = 1;
public static final int RADAR_STATUS_ALL = 1;
public static final int REVERSE_RADAR_SWITCH_STATE = 17;
public static synchronized BYDAutoRadarDevice getInstance(Context context) { return null; }
public int[] getAllRadarDistance() { return null; }
public int[] getAllRadarObstacleDistances() { return null; }
public int[] getAllRadarProbeStates() { return null; }
public int[][] getAllRadarStatus() { return null; }
public void getAllStatus() { }
public int[] getFeatureList() { return null; }
public int getRadarManufacture() { return 0; }
public int getRadarObstacleDistance(int i) { return 0; }
public int getRadarProbeState(int i) { return 0; }
public int getReverseRadarSwitchState() { return 0; }
public int getType() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoRadarListener absBYDAutoRadarListener) { }
public void setAllStatus() { }
public int setRadarSoundState(int i) { return 0; }
public int setReverseRadarSwitchState(int i) { return 0; }
public void unregisterListener(AbsBYDAutoRadarListener absBYDAutoRadarListener) { }
public void registerListener(AbsBYDAutoRadarListener absBYDAutoRadarListener, int[] iArr) { }
 }
