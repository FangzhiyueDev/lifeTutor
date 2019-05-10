package com.example.momomusic.servie;

import android.content.Context;
import android.media.AudioManager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

/**
 * 音频管理服务，后期需要公国该类实现对声音大小的控制
 */
public class AudioMngHelper {


    private final static String TAG = AudioMngHelper.class.getSimpleName();

    private final boolean OpenLog = true;

    private AudioManager audioManager;

    private int NOW_AUDIO_TYPE = TYPE_MUSIC;

    private int NOW_FLAG = FLAG_NOTHING;

    private int VOICE_STEP_100 = 2;//0-100的步进


    /**
     * 封装常用的流的类型
     */
    public final static int TYPE_MUSIC = AudioManager.STREAM_MUSIC;

    public final static int TYPE_ALARM = AudioManager.STREAM_ALARM;

    public final static int TYPE_RING = AudioManager.STREAM_RING;


    @IntDef({TYPE_MUSIC, TYPE_ALARM, TYPE_RING})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
    }

    public final static int FLAG_SHOW_UI = AudioManager.FLAG_SHOW_UI;
    public final static int FLAG_PLAY_SOUND = AudioManager.FLAG_PLAY_SOUND;

    public final static int FLAG_NOTHING = 0;


    @IntDef({FLAG_SHOW_UI, FLAG_PLAY_SOUND, FLAG_NOTHING})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FLAG {
    }


    public AudioMngHelper(Context context) {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public int getSystemMaxVolume() {
        return audioManager.getStreamMaxVolume(NOW_AUDIO_TYPE);
    }

    public int getSystemCurrentVolume() {
        return audioManager.getStreamVolume(NOW_AUDIO_TYPE);
    }

    public int get100CurrentVolume() {
        return 100 * getSystemCurrentVolume() / getSystemMaxVolume();
    }

    public AudioMngHelper setAudioType(@TYPE int type) {
        NOW_AUDIO_TYPE = type;
        return this;
    }

    public AudioMngHelper setFlag(@FLAG int flag) {
        NOW_FLAG = flag;
        return this;
    }

    public AudioMngHelper addVoiceSystem() {
        audioManager.adjustStreamVolume(NOW_AUDIO_TYPE, AudioManager.ADJUST_RAISE, NOW_FLAG);
        return this;
    }

    public AudioMngHelper subVoiceSystem() {
        audioManager.adjustStreamVolume(NOW_AUDIO_TYPE, AudioManager.ADJUST_LOWER, NOW_FLAG);
        return this;
    }

    public int setVoice100(int num) {
        int a = (int) (Math.ceil(num) * getSystemMaxVolume() * 0.01);
        a = a <= 0 ? 0 : a;
        a = a >= 100 ? 100 : a;
        audioManager.setStreamVolume(NOW_AUDIO_TYPE, a, NOW_FLAG);
        return get100CurrentVolume();
    }

    public int addVoice100() {
        int a = (int) Math.ceil((VOICE_STEP_100) + getSystemMaxVolume() * 0.01);
        a = a >= 100 ? 100 : a;
        audioManager.setStreamVolume(NOW_AUDIO_TYPE, a, 0);
        return get100CurrentVolume();
    }

    public int subVoice100() {
        int a = (int) Math.ceil((get100CurrentVolume() - VOICE_STEP_100) * 0.01);
        a = a >= 100 ? 100 : a;
        audioManager.setStreamVolume(NOW_AUDIO_TYPE, a, NOW_FLAG);
        return get100CurrentVolume();
    }


}
