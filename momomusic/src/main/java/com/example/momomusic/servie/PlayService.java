package com.example.momomusic.servie;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;


import com.example.momomusic.R;
import com.example.momomusic.model.Music;
import com.example.momomusic.tool.Looger;

import org.greenrobot.eventbus.Logger;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class PlayService extends Service implements MediaPlayer.OnPreparedListener {


    public static final String ACTION = "action";

    /**
     * 这个data是用来直接设置播放源的  得到的是String
     */
    public static final String DATA = "data";

    /**
     * 设置或附加加当前的数据源，得到 的是一个List<Music></>
     */

    public static final String SOURCE = "source";


    /**
     * 下面是几种播放状态
     */
    public static final String UP = "up";

    public static final String DOWN = "down";

    public static final String PAUSE_OR_PLAY = "pauseOrPlay";

    public static final String WITH_DATA_PLAY = "withDataPlay";

    public static final String ADDITIONAL_DATA = "add";


    private MyBinder binder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Looger.D("binder");
        return binder = new MyBinder();
    }


    private int id = 12;

    private NotificationManager manager;

    private String channelId = "12";

    /**
     * 在这里进行前台服务的开启
     */
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate() {
        super.onCreate();
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(new NotificationChannel("123", "通知", NotificationManager.IMPORTANCE_HIGH));
        createNoti();
        startForeground(12, notification);
    }


    Notification notification;
    RemoteViews remoteViews;

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void createNoti() {

        notification = new Notification.Builder(this)
                .setCustomContentView(remoteViews = new RemoteViews(getPackageName(), R.layout.noti_play_music))
                .setSmallIcon(R.drawable.rice)
                .setChannelId("123")
                .build();

        Intent intent = new Intent(this, PlayService.class);
        intent.putExtra(ACTION, UP);
        PendingIntent upPend = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.up, upPend);

        Intent intent1 = new Intent(this, PlayService.class);
        intent1.putExtra(ACTION, DOWN);
        PendingIntent downPend = PendingIntent.getService(this, 1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.down, downPend);


        Intent intent2 = new Intent(this, PlayService.class);
        intent2.putExtra(ACTION, PAUSE_OR_PLAY);
        PendingIntent pauseOrPlayPend = PendingIntent.getService(this, 2, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.pauseOrPlay, pauseOrPlayPend);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Looger.D("onStartCommand");

        String action = intent.getStringExtra(ACTION);
        String data = intent.getStringExtra(DATA);
        ArrayList<Music> musics = intent.getParcelableArrayListExtra(SOURCE);

        if (action == null) {
            return super.onStartCommand(intent, flags, startId);
        }
        switch (action) {
            case UP:
                binder.upMusic();
                break;
            case DOWN:
                binder.downMusic();
                break;
            case PAUSE_OR_PLAY:
                binder.pauseOrPlayMusic();
                break;
            case WITH_DATA_PLAY:
                binder.playMusic(data);
                break;
            case ADDITIONAL_DATA:
                binder.additionalData(musics);
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }


    private MediaPlayer mediaPlayer = new MediaPlayer();


    /**
     * 播放数据准备好的监听回调
     *
     * @param mp
     */
    @Override
    public void onPrepared(MediaPlayer mp) {

        if (mp.isPlaying()) {
        } else {
            mp.start();
        }
    }


    public class MyBinder extends Binder implements MusicPlayOpration {

        private String currentMusic;


        public MyBinder() {

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    downMusic();
                }
            });
        }


        @Override
        public void playMusic(String dataSource) {
            this.currentMusic = dataSource;
            mediaPlayer.reset();//重置
            try {
                mediaPlayer.setDataSource(dataSource);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(PlayService.this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void pauseOrPlayMusic() {
            /**
             * 如果当前music播放的歌曲为null，代表的是没有播放，也就是没有数据
             * 对于这种情况，我们需要重新设置数据源
             *
             */
            if (currentMusic == null) {
                playMusic(musics.get(0).getDataUrl());
                return;
            }

            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {//在这里我们需要判断当前是否存在播放的数据，如果没有，我们需要从新设置
                mediaPlayer.start();
            }
        }


        @Override
        public void upMusic() {
            playMusic(getUpResource());
        }

        @Override
        public void downMusic() {
            playMusic(getNextResource());
        }

        public String getUpResource() {
            Music upMusic = null;
            if (this.musics.size() > 0) {

                for (int i = 0; i < musics.size(); i++) {
                    if (currentMusic.equals(musics.get(i).getDataUrl())) {
                        if (i == 0) {
                            upMusic = musics.get(musics.size() - 1);
                        } else {
                            upMusic = musics.get(i - 1);
                        }
                    }
                }
            }
            return upMusic.getDataUrl();
        }


        public String getNextResource() {

            Music nextMusic = null;

            if (this.musics.size() > 0) {

                for (int i = 0; i < musics.size(); i++) {
                    if (currentMusic.equals(musics.get(i).getDataUrl())) {
                        if (i == musics.size() - 1) {
                            nextMusic = musics.get(0);
                        } else {
                            nextMusic = musics.get(i + 1);
                        }
                    }
                }
            }

            return nextMusic.getDataUrl();
        }

        private List<Music> musics;

        /**
         * 代表的是重新设置数据源
         * 会清空之前的数据
         *
         * @param musics
         */
        @Override
        public void setDataSources(List<Music> musics) {
            this.musics = musics;
        }


        /**
         * 附加新的数据，对之前播放的数据进行保留
         *
         * @param data
         */
        public void additionalData(List<Music> data) {
            if (this.musics == null) {//代表的是不在运行状态
                this.musics = new ArrayList<>();
            }

            this.musics.addAll(data);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer = null;

    }


    interface MusicPlayOpration {

        void playMusic(String dataSource);

        void pauseOrPlayMusic();

        void upMusic();

        void downMusic();

        void setDataSources(List<Music> music);

    }


}





