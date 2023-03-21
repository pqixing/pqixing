//refactor
package android.hardware.bydauto.multimedia;

import android.content.Context;
import android.os.Message;

import java.util.HashMap;
public class BYDAutoMultimediaDevice {
public static final int ACTION_AUTO_SEARCH = 6;
public static final int ACTION_CANCEL_RADIO_SEARCH = 9;
public static final int ACTION_ENTER = 0;
public static final int ACTION_NONE = -1;
public static final int ACTION_PAUSE = 2;
public static final int ACTION_PLAY = 1;
public static final int ACTION_PLAY_NEXT = 4;
public static final int ACTION_PLAY_NEXT_FREQ = 8;
public static final int ACTION_PLAY_PRE = 3;
public static final int ACTION_PLAY_PRE_FREQ = 7;
public static final int ACTION_SET_PLAY_PATTERN = 5;
public static final String ACTION_START_MEDIA = "byd.intent.action.START_MEDIA";
public static final String MEDIA_ACTION = "MediaAction";
public static final String MEDIA_MODE = "MediaMode";
public static final String MEDIA_PARAM = "MediaParam";
public static final int MODE_MUSIC = 1;
public static final int MODE_NONE = -1;
public static final int MODE_PHOTO = 3;
public static final int MODE_RADIO = 0;
public static final int MODE_VIDEO = 2;
public static final int MULTIMEDIA_COMMAND_BUSY = -2147482647;
public static final int MULTIMEDIA_COMMAND_FAILED = -2147482648;
public static final int MULTIMEDIA_COMMAND_INVALID_VALUE = -2147482645;
public static final int MULTIMEDIA_COMMAND_SUCCESS = 0;
public static final int MULTIMEDIA_COMMAND_TIMEOUT = -2147482646;
public static final int MULTIMEDIA_PLAY_MODE_ALL_REPEAT = 5;
public static final int MULTIMEDIA_PLAY_MODE_INVAID = 6;
public static final int MULTIMEDIA_PLAY_MODE_PREVIEW = 2;
public static final int MULTIMEDIA_PLAY_MODE_RANDOM = 1;
public static final int MULTIMEDIA_PLAY_MODE_SCAN = 3;
public static final int MULTIMEDIA_PLAY_MODE_SINGLE_REPEAT = 0;
public static final int MULTIMEDIA_PLAY_MODE_STEREO = 4;
public static final int MULTIMEDIA_STATE_PAUSE = 1;
public static final int MULTIMEDIA_STATE_PLAY = 0;
public static final int MULTIMEDIA_STATE_STOP = 2;
public static final int MULTIMEDIA_TYPE_AM = 0;
public static final int MULTIMEDIA_TYPE_AUDIO_OFF = 6;
public static final int MULTIMEDIA_TYPE_AUX = 7;
public static final int MULTIMEDIA_TYPE_BT = 16;
public static final int MULTIMEDIA_TYPE_CD = 2;
public static final int MULTIMEDIA_TYPE_DVD = 4;
public static final int MULTIMEDIA_TYPE_FM = 1;
public static final int MULTIMEDIA_TYPE_HD_AUDIO = 14;
public static final int MULTIMEDIA_TYPE_HD_VIDEO = 15;
public static final int MULTIMEDIA_TYPE_INVAID = 18;
public static final int MULTIMEDIA_TYPE_LOCAL_AUDIO = 8;
public static final int MULTIMEDIA_TYPE_LOCAL_VIDEO = 9;
public static final int MULTIMEDIA_TYPE_ROBOT = 17;
public static final int MULTIMEDIA_TYPE_SD_AUDIO = 12;
public static final int MULTIMEDIA_TYPE_SD_VIDEO = 13;
public static final int MULTIMEDIA_TYPE_TV = 5;
public static final int MULTIMEDIA_TYPE_USB_AUDIO = 10;
public static final int MULTIMEDIA_TYPE_USB_VIDEO = 11;
public static final int MULTIMEDIA_TYPE_VCD = 3;
public static final String PARAM_ARTIST_NAME = "artistname";
public static final String PARAM_FILE_NAME = "fliename";
public static final String PARAM_PATTERN = "pattern";
public static final String PARAM_RADIO_FREQ = "radiofreq";
public static final String PARAM_RADIO_SEARCH = "searchtype";
public static final String PARAM_SOURCE = "source";
public static final String PARAM_WITH_UI = "withui";
public static final int PATTERN_CYCLE = 0;
public static final int PATTERN_FULL_SCREEN = 1;
public static final int PATTERN_HALF_SCREEN = 0;
public static final int PATTERN_RANDOM = 1;
public static final int PATTERN_SINGLE = 2;
public static final int RADIO_SEARCH_AUTO = 0;
public static final int RADIO_SEARCH_NEXT = 2;
public static final int RADIO_SEARCH_PRE = 1;
public static final int SOURCE_BTMUSIC = 2;
public static final int SOURCE_LOCAL = 0;
public static final int SOURCE_NONE = -1;
public static final int SOURCE_SD = 3;
public static final int SOURCE_USB = 1;
public int getIntParam(String str) { return 0; }
public HashMap<String, String> getParam() { return null; }
public String getStringParam(String str) { return null; }
public void setParam(String str, int i) { }
public void setParam(String str, String str2) { }
public void handleMessage(Message message) { }
public static BYDAutoMultimediaDevice getInstance(Context context) { return null; }
public void onMediaTypeChanged(int i) { }
public void onPlayMediaInfoChanged(MediaInfo mediaInfo) { }
public void onPlayModeChanged(int i) { }
public void onPlayProgressChanged(int i) { }
public void onPlayStateChanged(int i) { }
public int getMediaMode() { return 0; }
public int getMediaType() { return 0; }
public MediaInfo getPlayMediaInfo() { return null; }
public int getPlayMode() { return 0; }
public int getPlayProgress() { return 0; }
public int getPlayState() { return 0; }
public void registerListener(AbsBYDAutoMultimediaListener absBYDAutoMultimediaListener) { }
public int setMediaType(int i) { return 0; }
public int setPlayMediaInfo(int i, MediaInfo mediaInfo) { return 0; }
public int setPlayMode(int i, int i2) { return 0; }
public int setPlayProgress(int i, int i2) { return 0; }
public int setPlayState(int i, int i2) { return 0; }
public void unregisterListener(AbsBYDAutoMultimediaListener absBYDAutoMultimediaListener) { }
 }
