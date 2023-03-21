//refactor
package android.hardware.bydauto.audio;
import android.content.Context;
import android.hardware.bydauto.AbsBYDAutoDevice;
public final class BYDAutoAudioDevice extends AbsBYDAutoDevice {
public static final int ARKAMYS_INVALID = 0;
public static final int ARKAMYS_MODE_ALL = 2;
public static final int ARKAMYS_MODE_DRIVER = 1;
public static final int ARKAMYS_MODE_INVALID = 0;
public static final int ARKAMYS_MODE_OFF = 3;
public static final int ARKAMYS_OFF = 2;
public static final int ARKAMYS_ON = 1;
public static final int AUDIO_ARAOKE_MODE = 47;
public static final int AUDIO_BALANCE_RESET = 53;
public static final int AUDIO_CHANNEL = 24;
public static final int AUDIO_COMMAND_BUSY = -2147482647;
public static final int AUDIO_COMMAND_FAILED = -2147482648;
public static final int AUDIO_COMMAND_INVALID_VALUE = -2147482645;
public static final int AUDIO_COMMAND_SUCCESS = 0;
public static final int AUDIO_COMMAND_TIMEOUT = -2147482646;
public static final int AUDIO_CONTROL_IFLYTEK = 32;
public static final int AUDIO_DIRAC_LIVE = 6;
public static final int AUDIO_DIRAC_LIVE_MODE = 64;
public static final int AUDIO_EQUALIZER_FREQ = 16;
public static final int AUDIO_EQUALIZER_FREQUENCY_1 = 37;
public static final int AUDIO_EQUALIZER_FREQUENCY_2 = 38;
public static final int AUDIO_EQUALIZER_FREQUENCY_3 = 39;
public static final int AUDIO_EQUALIZER_FREQUENCY_4 = 40;
public static final int AUDIO_EQUALIZER_FREQUENCY_5 = 41;
public static final int AUDIO_EQUALIZER_PERCENT = 17;
public static final int AUDIO_EQ_RESET = 52;
public static final int AUDIO_FUNCTION_OFF = 0;
public static final int AUDIO_FUNCTION_ON = 1;
public static final int AUDIO_IFLYTEK_FUNCTION_MODE = 11;
public static final int AUDIO_IFLYTEK_WORK_MODE = 12;
public static final int AUDIO_KARA_OK_EQ1 = 49;
public static final int AUDIO_KARA_OK_EQ2 = 50;
public static final int AUDIO_KARA_OK_EQ3 = 51;
public static final int AUDIO_LOUDNESS = 8;
public static final int AUDIO_LOUDSPEAKER_NUM = 44;
public static final int AUDIO_MIC_AMP_GAIN = 46;
public static final int AUDIO_MIC_AMP_GAIN_0 = 0;
public static final int AUDIO_MIC_AMP_GAIN_1 = 1;
public static final int AUDIO_MIC_AMP_GAIN_10 = 10;
public static final int AUDIO_MIC_AMP_GAIN_2 = 2;
public static final int AUDIO_MIC_AMP_GAIN_3 = 3;
public static final int AUDIO_MIC_AMP_GAIN_4 = 4;
public static final int AUDIO_MIC_AMP_GAIN_5 = 5;
public static final int AUDIO_MIC_AMP_GAIN_6 = 6;
public static final int AUDIO_MIC_AMP_GAIN_7 = 7;
public static final int AUDIO_MIC_AMP_GAIN_8 = 8;
public static final int AUDIO_MIC_AMP_GAIN_9 = 9;
public static final int AUDIO_MUSIC_CHANGE_SOURCE = 48;
public static final int AUDIO_MUTE_STATUS = 1;
public static final int AUDIO_NAVI_MUTE_STATUS = 3;
public static final int AUDIO_NAVI_VOLUME = 4;
public static final int AUDIO_NO_DIRAC = 2;
public static final int AUDIO_PLAY_TIME_HOUR = 58;
public static final int AUDIO_PLAY_TIME_MINUTE = 59;
public static final int AUDIO_PLAY_TIME_SECOND = 60;
public static final int AUDIO_SOUND_EFFECT = 15;
public static final int AUDIO_TIME_HOUR_MAX = 23;
public static final int AUDIO_TIME_HOUR_MIN = 0;
public static final int AUDIO_TIME_INVALID = 255;
public static final int AUDIO_TIME_MINUTE_MAX = 59;
public static final int AUDIO_TIME_MINUTE_MIN = 0;
public static final int AUDIO_TIME_SECOND_MAX = 59;
public static final int AUDIO_TIME_SECOND_MIN = 0;
public static final int AUDIO_TOTAL_TIME_HOUR = 61;
public static final int AUDIO_TOTAL_TIME_MINUTE = 62;
public static final int AUDIO_TOTAL_TIME_SECOND = 63;
public static final int AUDIO_VOLUME = 2;
public static final int AUDIO_VOLUME_CTRL_MODE = 45;
public static final int AUDIO_VOLUME_MAX = 100;
public static final int AUDIO_VOLUME_MIN = 0;
public static final int AUDIO_VOLUME_SOURCE = 39;
public static final int AUDIO_VOL_FROM_BACK_PAD = 57;
public static final int AUDIO_X_SOUND_FIELD = 13;
public static final int AUDIO_Y_SOUND_FIELD = 14;
public static final int BACK_PAD_VOL_MAX = 39;
public static final int BACK_PAD_VOL_MIN = 0;
public static final int BACK_PAD_VOL_NO_ACTION = 63;
public static final int BEAM_FORM_ALL = 1;
public static final int BEAM_FORM_AUTO = 4;
public static final int BEAM_FORM_INVALID = 0;
public static final int BEAM_FORM_LEFT = 2;
public static final int BEAM_FORM_RIGHT = 3;
public static final int CHANNEL_KARAOKE = 3;
public static final int CHANNEL_PAD = 2;
public static final int CHANNEL_RADIO = 1;
public static final int CMD_ARKAMYS_SOUNDSTAGE_MODE = 56;
public static final int CMD_ARKAMYS_SOUNDSTAGE_WOOFER = 55;
public static final int CMD_BEAM_FORM = 54;
public static final int CONTROL_IFLYTEK_OFF = 0;
public static final int CONTROL_IFLYTEK_ON = 1;
public static final int CONTROL_IFLYTEK_RESET = 2;
public static final int CTRL_SOURCE_KNOB = 1;
public static final int CTRL_SOURCE_ST = 2;
public static final int DIRAC_MODE_HIFI_ROOM = 1;
public static final int DIRAC_MODE_LIVESTAGE = 2;
public static final int DIRAC_MODE_OFF = 3;
public static final int DIRAC_PERFORMANCE_CLARITY = 5;
public static final int DIRAC_PERFORMANCE_DYNAMIC = 6;
public static final int DIRAC_PERFORMANCE_OFF = 4;
public static final int EQUALIZER_FREQUENCY_1 = 1;
public static final int EQUALIZER_FREQUENCY_2 = 2;
public static final int EQUALIZER_FREQUENCY_3 = 3;
public static final int EQUALIZER_FREQUENCY_4 = 4;
public static final int EQUALIZER_FREQUENCY_5 = 5;
public static final int EQUALIZER_PERCENT_MAX = 30;
public static final int EQUALIZER_PERCENT_MIN = 1;
public static final int IFLYTEK_FUNCTION_MODE_BT_ELIMINATE_ECHO = 3;
public static final int IFLYTEK_FUNCTION_MODE_OFF = 0;
public static final int IFLYTEK_FUNCTION_MODE_RECORD = 1;
public static final int IFLYTEK_FUNCTION_MODE_VOICE_DENOISING = 2;
public static final int IFLYTEK_FUNCTION_MODE_VOICE_WAKE_UP = 4;
public static final int IFLYTEK_WORK_MODE_ADDON = 2;
public static final int IFLYTEK_WORK_MODE_CAR = 3;
public static final int IFLYTEK_WORK_MODE_TOPLIGHT = 1;
public static final int KARAOKE_EQUALIZER_1 = 1;
public static final int KARAOKE_EQUALIZER_2 = 2;
public static final int KARAOKE_EQUALIZER_3 = 3;
public static final int KARAOKE_EQUALIZER_VALUE_MAX = 30;
public static final int KARAOKE_EQUALIZER_VALUE_MIN = 1;
public static final int KARAOKE_MODE_ENTER = 1;
public static final int KARAOKE_MODE_EXIT = 2;
public static final int LOUDSPEAKER_NUM_INVALID = 0;
public static final int LOUDSPEAKER_NUM_MAX = 16;
public static final int LOUDSPEAKER_NUM_MIN = 2;
public static final int MUSIC_CHANGE_SOURCE_ST = 2;
public static final int MUSIC_CHANGE_SOURCE_VOICE = 1;
public static final int MUTE_DISABLE = 0;
public static final int MUTE_ENABLE = 1;
public static final int NAVI_MUTE_DISABLE = 3;
public static final int NAVI_MUTE_ENABLE = 2;
public static final int NAVI_VOLUME_MAX = 10;
public static final int NAVI_VOLUME_MIN = 0;
public static final int RESET_INVALID = 0;
public static final int RESET_ITEM_BALANCE = 1;
public static final int RESET_ITEM_EQ = 0;
public static final int RESET_VALID = 1;
public static final int SOUND_EFFECT_CLASSICAL = 3;
public static final int SOUND_EFFECT_COUNTRY = 4;
public static final int SOUND_EFFECT_CUSTOM = 11;
public static final int SOUND_EFFECT_DANCE = 9;
public static final int SOUND_EFFECT_ELECTRONIC = 5;
public static final int SOUND_EFFECT_JAZZ = 2;
public static final int SOUND_EFFECT_NONE = 1;
public static final int SOUND_EFFECT_OLDIES = 6;
public static final int SOUND_EFFECT_OPERA = 10;
public static final int SOUND_EFFECT_POP = 7;
public static final int SOUND_EFFECT_ROCK = 8;
public static final int SOUND_FIELD_CHANGE = 36;
public static final int SOUND_FIELD_MAX = 14;
public static final int SOUND_FIELD_MIN = 0;
public static final int VOLUME_SOURCE_KNOB = 11;
public static final int VOLUME_SOURCE_PADQUR = 0;
public static final int VOLUME_SOURCE_PADREQ = 1;
public static final int VOLUME_SOURCE_WHEEL = 12;
public static synchronized BYDAutoAudioDevice getInstance(Context context) { return null; }
public int controlIflytek(int i) { return 0; }
public int getArkamysMode() { return 0; }
public int getArkamysState() { return 0; }
public int getAudioMicAmpGain() { return 0; }
public int getBeamForm() { return 0; }
public int getChannel() { return 0; }
public int getDiracLiveMode() { return 0; }
public int getDiracLiveState() { return 0; }
public int getEqualizer(int i) { return 0; }
public int[] getFeatureList() { return null; }
public int getIflytekFunctionMode() { return 0; }
public int getIflytekWorkMode() { return 0; }
public int getKaraokeEqualizer(int i) { return 0; }
public int getLoudnessState() { return 0; }
public int getLoudspeakerNum() { return 0; }
public int getMusicChangeSource() { return 0; }
public int getMuteState() { return 0; }
public int getNaviMuteState() { return 0; }
public int getNaviVolume() { return 0; }
public int getSoundEffect() { return 0; }
public int[] getSoundField() { return null; }
public int getType() { return 0; }
public int getVolume() { return 0; }
public int getVolumeCtrlMode() { return 0; }
public int getVolumeSettingsource() { return 0; }
public boolean postEvent(int i, int i2, int i3, Object obj) { return false; }
public void registerListener(AbsBYDAutoAudioListener absBYDAutoAudioListener) { }
public int reset(int i, int i2) { return 0; }
public int sendAudioPlayingTime(int i, int i2, int i3) { return 0; }
public int sendAudioTotalTime(int i, int i2, int i3) { return 0; }
public int setArkamysMode(int i) { return 0; }
public int setArkamysState(int i) { return 0; }
public int setAudioMicAmpGain(int i) { return 0; }
public int setBeamForm(int i) { return 0; }
public int setChannel(int i) { return 0; }
public int setDiracLiveMode(int i) { return 0; }
public int setDiracLiveState(int i) { return 0; }
public int setEqualizer(int i, int i2) { return 0; }
public int setIflytekFunctionMode(int i) { return 0; }
public int setIflytekWorkMode(int i) { return 0; }
public int setKaraokeEqualizer(int i, int i2) { return 0; }
public int setKaraokeMode(int i) { return 0; }
public int setLoudnessState(int i) { return 0; }
public int setMusicChangeSource(int i) { return 0; }
public int setMuteState(int i) { return 0; }
public int setNaviMuteState(int i) { return 0; }
public int setNaviVolume(int i) { return 0; }
public int setSoundEffect(int i) { return 0; }
public int setSoundField(int i, int i2) { return 0; }
public int setVolume(int i) { return 0; }
public int setVolumeSettingsource() { return 0; }
public void unregisterListener(AbsBYDAutoAudioListener absBYDAutoAudioListener) { }
public void registerListener(AbsBYDAutoAudioListener absBYDAutoAudioListener, int[] iArr) { }
 }
