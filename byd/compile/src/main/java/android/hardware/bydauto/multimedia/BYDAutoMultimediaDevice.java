package android.hardware.bydauto.multimedia;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.IMultiMediaDispatcher;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
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
    private static final boolean DEBUG = true;
    public static final String MEDIA_ACTION = "MediaAction";
    private static final String MEDIA_CENTER_APP = "com.byd.mediacenter";
    public static final String MEDIA_MODE = "MediaMode";
    public static final String MEDIA_PARAM = "MediaParam";
    public static final int MODE_MUSIC = 1;
    public static final int MODE_NONE = -1;
    public static final int MODE_PHOTO = 3;
    public static final int MODE_RADIO = 0;
    public static final int MODE_VIDEO = 2;
    private static final int MSG_MULTIMEDIA_INFO_CHANGE = 3;
    private static final int MSG_MULTIMEDIA_MODE_CHANGE = 1;
    private static final int MSG_MULTIMEDIA_PROGRESS_CHANGE = 4;
    private static final int MSG_MULTIMEDIA_STATE_CHANGE = 2;
    private static final int MSG_MULTIMEDIA_TYPE_CHANGE = 0;
    public static final int MULTIMEDIA_COMMAND_BUSY = -2147482647;
    public static final int MULTIMEDIA_COMMAND_FAILED = -2147482648;
    public static final int MULTIMEDIA_COMMAND_INVALID_VALUE = -2147482645;
    public static final int MULTIMEDIA_COMMAND_SUCCESS = 0;
    public static final int MULTIMEDIA_COMMAND_TIMEOUT = -2147482646;
    static final String MULTIMEDIA_GET_PERM = "android.permission.BYDAUTO_MULTIMEDIA_GET";
    public static final int MULTIMEDIA_PLAY_MODE_ALL_REPEAT = 5;
    public static final int MULTIMEDIA_PLAY_MODE_INVAID = 6;
    public static final int MULTIMEDIA_PLAY_MODE_PREVIEW = 2;
    public static final int MULTIMEDIA_PLAY_MODE_RANDOM = 1;
    public static final int MULTIMEDIA_PLAY_MODE_SCAN = 3;
    public static final int MULTIMEDIA_PLAY_MODE_SINGLE_REPEAT = 0;
    public static final int MULTIMEDIA_PLAY_MODE_STEREO = 4;
    static final String MULTIMEDIA_SET_PERM = "android.permission.BYDAUTO_MULTIMEDIA_SET";
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
    protected static final String TAG = "BYDAutoMultimediaDevice";
    private static BYDAutoMultimediaDevice mInstance;
    private AudioManager mAudioManager;
    private final Context mContext;
    private Handler mMainHandler;
    private final ArrayList<AbsBYDAutoMultimediaListener> mMultiMediaListener = new ArrayList<>();
    private final Object mMultiMediaListenerLock = new Object();
    private final IMultiMediaDispatcher mMultiMediaDispatcher = new a(this);

    /* loaded from: classes.dex */
    public class MediaControlParam {
        private HashMap<String, String> mParam;

        public MediaControlParam() {
            BYDAutoMultimediaDevice.this = r1;
            this.mParam = new HashMap<>();
        }

        public int getIntParam(String str) {
            String str2 = this.mParam.get(str);
            if (str2 != null) {
                int parseInt = Integer.parseInt(str2);
                Log.d(BYDAutoMultimediaDevice.TAG, "getIntParam, key is: " + str + " value is: " + parseInt);
                return parseInt;
            }
            return -1;
        }

        public HashMap<String, String> getParam() {
            return this.mParam;
        }

        public String getStringParam(String str) {
            return this.mParam.get(str);
        }

        public void setParam(String str, int i) {
            this.mParam.put(str, String.valueOf(i));
        }

        public void setParam(String str, String str2) {
            this.mParam.put(str, str2);
        }

        public MediaControlParam(HashMap<String, String> hashMap) {
            BYDAutoMultimediaDevice.this = r1;
            this.mParam = new HashMap<>();
            if (hashMap == null) {
                Log.d(BYDAutoMultimediaDevice.TAG, "MediaControlParam, param is null");
            } else {
                this.mParam = hashMap;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends IMultiMediaDispatcher.Stub {
        a(BYDAutoMultimediaDevice bYDAutoMultimediaDevice) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper) {
            super(looper);
            BYDAutoMultimediaDevice.this = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                BYDAutoMultimediaDevice.this.onMediaTypeChanged(message.arg1);
            } else if (i == 1) {
                BYDAutoMultimediaDevice.this.onPlayModeChanged(message.arg1);
            } else if (i == 2) {
                BYDAutoMultimediaDevice.this.onPlayStateChanged(message.arg1);
            } else if (i == 3) {
                BYDAutoMultimediaDevice.this.onPlayMediaInfoChanged((MediaInfo) message.obj);
            } else {
                if (i == 4) {
                    BYDAutoMultimediaDevice.this.onPlayProgressChanged(message.arg1);
                }
                Log.e(BYDAutoMultimediaDevice.TAG, "Unknown event " + message.what);
            }
        }
    }

    private BYDAutoMultimediaDevice(Context context) {
        this.mAudioManager = null;
        this.mMainHandler = null;
        this.mContext = context;
        this.mAudioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.mMainHandler = new b(Looper.getMainLooper());
    }

    public static BYDAutoMultimediaDevice getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new BYDAutoMultimediaDevice(context);
        }
        return mInstance;
    }

    public void onMediaTypeChanged(int i) {
        Log.d(TAG, "onMediaTypeChanged");
        synchronized (this.mMultiMediaListenerLock) {
            for (int i2 = 0; i2 < this.mMultiMediaListener.size(); i2++) {
                this.mMultiMediaListener.get(i2).onMediaTypeChanged(i);
            }
        }
    }

    public void onPlayMediaInfoChanged(MediaInfo mediaInfo) {
        Log.d(TAG, "onPlayMediaInfoChanged, info is: " + mediaInfo);
        synchronized (this.mMultiMediaListenerLock) {
            for (int i = 0; i < this.mMultiMediaListener.size(); i++) {
                this.mMultiMediaListener.get(i).onPlayMediaInfoChanged(mediaInfo);
            }
        }
    }

    public void onPlayModeChanged(int i) {
        Log.d(TAG, "onPlayModeChanged");
        synchronized (this.mMultiMediaListenerLock) {
            for (int i2 = 0; i2 < this.mMultiMediaListener.size(); i2++) {
                this.mMultiMediaListener.get(i2).onPlayModeChanged(i);
            }
        }
    }

    public void onPlayProgressChanged(int i) {
        Log.d(TAG, "onPlayProgressChanged, progress is: " + i);
        synchronized (this.mMultiMediaListenerLock) {
            for (int i2 = 0; i2 < this.mMultiMediaListener.size(); i2++) {
                this.mMultiMediaListener.get(i2).onPlayProgressChanged(i);
            }
        }
    }

    public void onPlayStateChanged(int i) {
        Log.d(TAG, "onPlayStateChanged");
        synchronized (this.mMultiMediaListenerLock) {
            for (int i2 = 0; i2 < this.mMultiMediaListener.size(); i2++) {
                this.mMultiMediaListener.get(i2).onPlayStateChanged(i);
            }
        }
    }

    public int controlMedia(int i, int i2, MediaControlParam mediaControlParam) {
        Log.d(TAG, "controlMedia, mode is: " + i + " action is: " + i2);
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_SET_PERM, null);
        int i3 = -2147482645;
        if (i == 0 ? i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 6 || i2 == 9 : (i == 1 || i == 2) && (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5)) {
            i3 = 0;
        }
        if (i3 == 0) {
            Intent intent = new Intent("byd.intent.action.START_MEDIA");
            intent.setPackage(MEDIA_CENTER_APP);
            intent.putExtra("MediaMode", i);
            intent.putExtra("MediaAction", i2);
            if (mediaControlParam == null) {
                mediaControlParam = new MediaControlParam();
            }
            mediaControlParam.setParam("withui", "true");
            intent.putExtra("MediaParam", mediaControlParam.getParam());
            this.mContext.startService(intent);
        }
        Log.d(TAG, "controlMedia, status is: " + i3);
        return i3;
    }

    public int getMediaMode() {
        int parseInt = Integer.parseInt(SystemProperties.get("persist.sys.byd.mediaMode", "0"));
        Log.d(TAG, "getMediaMode, mode is: " + parseInt);
        if (parseInt < 0 || parseInt > 2) {
            return 0;
        }
        return parseInt;
    }

    public int getMediaType() {
        Log.d(TAG, "getMediaType");
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_GET_PERM, null);
        return this.mAudioManager.getMediaType();
    }

    public MediaInfo getPlayMediaInfo() {
        Log.d(TAG, "getPlayMediaInfo");
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_GET_PERM, null);
        MediaInfo playMediaInfo = this.mAudioManager.getPlayMediaInfo();
        Log.d(TAG, "mediaInfo is: " + playMediaInfo);
        return playMediaInfo;
    }

    public int getPlayMode() {
        Log.d(TAG, "getPlayMode");
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_GET_PERM, null);
        return this.mAudioManager.getPlayMode();
    }

    public int getPlayProgress() {
        Log.d(TAG, "getPlayProgress");
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_GET_PERM, null);
        int playProgress = this.mAudioManager.getPlayProgress();
        Log.d(TAG, "progress is: " + playProgress);
        return playProgress;
    }

    public int getPlayState() {
        Log.d(TAG, "getPlayState");
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_GET_PERM, null);
        return this.mAudioManager.getPlayState();
    }

    public void registerListener(AbsBYDAutoMultimediaListener absBYDAutoMultimediaListener) {
        Log.i(TAG, "registerListener");
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_GET_PERM, null);
        synchronized (this.mMultiMediaListenerLock) {
            if (absBYDAutoMultimediaListener == null) {
                return;
            }
            if (this.mMultiMediaListener.contains(absBYDAutoMultimediaListener)) {
                return;
            }
            this.mMultiMediaListener.add(absBYDAutoMultimediaListener);
            if (this.mMultiMediaListener.size() == 1) {
                this.mAudioManager.registerMultiMediaListener(this.mMultiMediaDispatcher);
            }
        }
    }

    public int setMediaType(int i) {
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_SET_PERM, null);
        Log.d(TAG, "setMediaType: " + i);
        if (i < 0 || i > 18) {
            return -2147482645;
        }
        this.mAudioManager.setMediaType(i);
        return 0;
    }

    public int setPlayMediaInfo(int i, MediaInfo mediaInfo) {
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_SET_PERM, null);
        Log.d(TAG, "setPlayMediaInfo: " + i + " mediaInfo is: " + mediaInfo);
        this.mAudioManager.setPlayMediaInfo(i, mediaInfo);
        return 0;
    }

    public int setPlayMode(int i, int i2) {
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_SET_PERM, null);
        Log.d(TAG, "setPlayMode: " + i2);
        if (i2 < 0 || i2 > 6) {
            return -2147482645;
        }
        this.mAudioManager.setPlayMode(i, i2);
        return 0;
    }

    public int setPlayProgress(int i, int i2) {
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_SET_PERM, null);
        Log.d(TAG, "setPlayProgress: mode is " + i + " progress is " + i2);
        this.mAudioManager.setPlayProgress(i, i2);
        return 0;
    }

    public int setPlayState(int i, int i2) {
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_SET_PERM, null);
        Log.d(TAG, "setPlayState: " + i + " playState is: " + i2);
        this.mAudioManager.setPlayState(i, i2);
        return 0;
    }

    public void unregisterListener(AbsBYDAutoMultimediaListener absBYDAutoMultimediaListener) {
        Log.i(TAG, "unregisterListener");
        this.mContext.enforceCallingOrSelfPermission(MULTIMEDIA_GET_PERM, null);
        synchronized (this.mMultiMediaListenerLock) {
            if (absBYDAutoMultimediaListener == null) {
                return;
            }
            this.mMultiMediaListener.remove(absBYDAutoMultimediaListener);
            if (this.mMultiMediaListener.size() == 0) {
                this.mAudioManager.unregisterMultiMediaListener(this.mMultiMediaDispatcher);
            }
        }
    }
}
