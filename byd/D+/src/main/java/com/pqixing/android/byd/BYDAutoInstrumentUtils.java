package com.pqixing.android.byd;

import android.app.Application;
import android.content.Context;
import android.hardware.bydauto.instrument.BYDAutoInstrumentDevice;
import android.hardware.bydauto.radar.BYDAutoRadarDevice;
import android.media.AudioManager;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class BYDAutoInstrumentUtils {

    private static final int FAIL = -2147482648;
    private static final String TAG = "BYDAutoInstrumentUtils";
    private static final String FROM_TAG = "HAD_BEEN_RESEND_TO";

    private static final List<String> MATCH_ACTIONS = Arrays.asList(
            "pqx.intent.action.MEDIA",
            "byd.intent.action.MEDIA_MODE",
            "byd.intent.action.MEDIA_BUTTON",
            "kg.intent.action.MEDIA_BUTTON",
            "byd.intent.action.KILL_KUGOU",
            "com.byd.action.FUNCTION_UPDATE_RESULT",
            "com.byd.action.AUTOVOICE_PLAY_MODE",
            "com.byd.action.AUTOVOICE_SEARCH_PLUS",
            "com.kg.action.AUTOVOICE_SEARCH_PLUS",
            "com.byd.action.AUTOVOICE_RECOMMEND",
            "com.byd.action.AUTOVOICE_PLAY_RANDOM",
            "com.byd.action.AUTOVOICE_BOOK",
            "com.byd.action.AUTOVOICE_UNBOOK",
            "com.byd.action.AUTOVOICE_OPEN_LYRIC",
            "com.byd.action.AUTOVOICE_CLOSE_LYRIC",
            "com.byd.action.AUTOVOICE_REVERSE",
            "com.byd.action.AUTOVOICE_ORDER",
            "com.byd.action.AUTOVOICE_PLAY_MODE",
            "com.byd.action.AUTOVOICE_JUMP_TO",
            "com.byd.action.AUTOVOICE_FORWARD",
            "com.byd.action.AUTOVOICE_REWIND",
            "com.byd.action.AUTOVOICE_FULL_SCREEN",
            "com.byd.action.AUTOVOICE_UNFULL_SCREEN",
            "com.byd.action.AUTOVOICE_SPEED_ADJUST",
            "com.byd.action.AUTOVOICE_SKIP_TITLE",
            "com.byd.action.AUTOVOICE_SKIP_END",
            "com.byd.action.AUTOVOICE_DOWNLOAD",
            "com.byd.action.AUTOVOICE_UNDOWNLOAD",
            "com.byd.action.AUTOVOICE_QUIT",
            "com.byd.action.AUTOVOICE_DEFINITION_SET",
            "com.byd.action.AUTOVOICE_PLAY_FAVORITE",
            "com.byd.action.AUTOVOICE_PLAY_LIKE",
            "com.byd.action.AUTOVOICE_PLAY_BOOK",
            "com.byd.action.AUTOVOICE_PLAY_DOWNLOAD",
            "com.byd.action.AUTOVOICE_COLLECT",
            "com.byd.action.AUTOVOICE_UNCOLLECT",
            "com.byd.action.AUTOVOICE_PLAY_LATELY",
            "com.byd.action.AUTOVOICE_PLAY_SONG_SHEET",
            "com.byd.action.AUTOVOICE_OPEN_LIST",
            "com.byd.action.AUTOVOICE_CLOSE_LIST",
            "kugou.intent.action.update.byd.metadata",
            "kugou.intent.action.update.byd.playback.progress",
            "com.byd.action.query_tri_part_account_state",
            "com.byd.action.byd_account_state_change",
            "com.byd.action.byd_account_go_tripart_login_page",
            "byd.intent.action.AUTO_PLAY",
            "com.byd.action.AUTOVOICE_ACTIVECARE",
            "com.byd.action.AUTOVOICE_BOOK",
            "com.byd.action.AUTOVOICE_QUALITY"
    );


    private static Application mContext;

    public static void init(Application context) {
        mContext = context;
        //绕过反射Api限制
        setHiddenApiExemptions();

    }

    /**
     * 设置空调开关
     */
    public static void setAir(int state) {
        invokeSet(getAutoFeatureId("CHARGING_CHARGE_WIRELESS_CHARGING_SWITCH_SET", 82051202), state, int.class);
    }

    /**
     * 设置空调开关
     */
    public static String setWirelessCharging(int state) {
        return call("error", () -> {
            BYDAutoInstrumentDevice instance = BYDAutoInstrumentDevice.getInstance(mContext);
            int deviceType = instance.getType();
            int id = getAutoFeatureId("CHARGING_CHARGE_WIRELESS_CHARGING_SWITCH_SET", 82051202);
            getSetMethod(int.class).invoke(instance, deviceType, id, state);
            return "setWirelessCharging " + deviceType + " ; " + id;
        });
    }

    /**
     * 设置仪表盘音乐名称
     *
     * @param name
     */
    public static int sendMusicName(String name) {
        return call(FAIL, () -> BYDAutoInstrumentDevice.getInstance(mContext).sendMusicName(name));
    }

    /**
     * 设置音乐信息：（歌词）
     *
     * @param bytes
     */
    public static int sendMusicInfo(byte[] bytes) {
        if (bytes.length <= 255) try {
            return BYDAutoInstrumentDevice.getInstance(mContext).sendMusicInfo(bytes);
        } catch (Exception e) {
            Log.w(TAG, "sendMusicInfo: ", e);
        }
        return FAIL;
    }

    /**
     * 设置音乐来源
     *
     * @param source
     */
    public static int sendMusicSource(int source) {
        try {
            return BYDAutoInstrumentDevice.getInstance(mContext).sendMusicSource(source);
        } catch (Exception e) {
            Log.w(TAG, "sendMusicSource: ", e);
        }
        return FAIL;
    }

    /**
     * 设置音乐进度
     *
     * @param source
     */
    public static int sendMusicPlaybackProgress(int source) {
        try {
            return BYDAutoInstrumentDevice.getInstance(mContext).sendMusicPlaybackProgress(source);
        } catch (Exception e) {
            Log.w(TAG, "sendMusicPlaybackProgress: ", e);
        }
        return FAIL;
    }

    /**
     * 设置音乐状态
     *
     * @param source
     */
    public static int sendMusicState(int source) {
        try {
            return BYDAutoInstrumentDevice.getInstance(mContext).sendMusicState(source);
        } catch (Exception e) {
            Log.w(TAG, "sendMusicState: ", e);
        }
        return FAIL;
    }

    private static boolean setHiddenApiExemptions() {
        try {
            // Allow accessing hidden api
            Method forName = Class.class.getDeclaredMethod("forName", String.class);
            Method getDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class vmRuntimeClass = (Class) forName.invoke(null, "dalvik.system.VMRuntime");
            Method getRuntime = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "getRuntime", null);
            Object vmRuntime = getRuntime.invoke(null);
            Method setHiddenApiExemptions = (Method) getDeclaredMethod.invoke(vmRuntimeClass, "setHiddenApiExemptions", new Class[]{String[].class});

            setHiddenApiExemptions.invoke(vmRuntime, (Object) new String[]{"L"});

            return true;
        } catch (Exception e) {
            Log.w(TAG, "setHiddenApiExemptions: ", e);
        }
        return false;
    }

    private static int getAutoFeatureId(String name, int def) {
        try {
            Class featureIdsClass = Class.forName("android.hardware.bydauto.BYDAutoFeatureIds");
            Field chargingSwitchSetField = featureIdsClass.getDeclaredField(name);
            return (int) chargingSwitchSetField.get(null);
        } catch (Exception e) {
            Log.w(TAG, "getAutoFeatureId: ", e);
        }
        return def;
    }

    private static int getDeviceType(Class deviceClass, Object device) {
        try {
            Method getDeviceTypeMethod = deviceClass.getMethod("getDeviceType");
            getDeviceTypeMethod.setAccessible(true);
            return (int) getDeviceTypeMethod.invoke(device);
        } catch (Exception e) {
            Log.w(TAG, "getDeviceType: ", e);
        }
        return 1007;
    }

    /**
     * @param id         需要设置的Id
     * @param value      需要设置的值
     * @param valueClass 值对应的class
     * @return 是否正常调用
     */
    private static Object invokeSet(int id, Object value, Class<?> valueClass) {

        try {
            // Use reflection to get BYD framework classes.
            Class deviceClass = Class.forName("android.hardware.bydauto.charging.BYDAutoChargingDevice");
            Method getInstance = deviceClass.getMethod("getInstance", Context.class);

            Object device = getInstance.invoke(null, mContext);
            int mDeviceType = getDeviceType(deviceClass, device);
            Method setMethod = getSetMethod(valueClass);
            return setMethod.invoke(device, mDeviceType, id, value);
        } catch (Exception e) {
            Log.w(TAG, "invokeSet: ", e);
        }

        return null;
    }

    /**
     * @param valueClass 值对应的class
     * @return 是否正常调用
     */
    private static Method getSetMethod(Class<?> valueClass) {
        return call(null, () -> {
            Class absAutoClass = Class.forName("android.hardware.bydauto.AbsBYDAutoDevice");

            Method setMethod = absAutoClass.getDeclaredMethod("set", int.class, int.class, valueClass);
            setMethod.setAccessible(true);
            return setMethod;
        });
    }


    public static String getCurrentAudioFocusPackage() {
        //获取当前正在播放的软件
        try {
            AudioManager audioManager = mContext.getSystemService(AudioManager.class);
            Method method = AudioManager.class.getDeclaredMethod("getCurrentAudioFocusPackage");
            method.setAccessible(true);
            return (String) method.invoke(audioManager);
        } catch (Exception e) {
            Log.w(TAG, "getCurrentAudioFocusPackage: ", e);
        }
        return null;
    }

    /**
     * 获取雷达数据
     *
     * @return
     */
    public static int[] getAllRadarDistance() {
        return call(new int[9], () -> BYDAutoRadarDevice.getInstance(mContext).getAllRadarDistance());
    }

    public static <T> T call(T t, Callable<T> run) {
        try {
            return (T) run.call();
        } catch (Exception | NoClassDefFoundError e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void run(Runnable run) {
        try {
            run.run();
        } catch (Exception | NoClassDefFoundError e) {
            e.printStackTrace();
        }
    }
}
