package com.example.componentasystemtest.downloadService.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.componentasystemtest.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadService extends Service {


    int id = 12;

    NotificationManager manager;

    MyAsyncTask myAsyncTask;

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        manager.createNotificationChannel(new NotificationChannel("123", "通知", NotificationManager.IMPORTANCE_HIGH));

        createNoti();

        startForeground(12, notification);


        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute("下载");


        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {


        return null;
    }


    Notification notification;
    RemoteViews remoteViews;

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void createNoti() {

        notification = new Notification.Builder(this)
                .setCustomContentView(remoteViews = new RemoteViews(getPackageName(), R.layout.noti_layout))
                .setSmallIcon(R.drawable.rice)
                .setChannelId("123")
                .build();

    }

    class MyAsyncTask extends AsyncTask<String, Integer, Void> {

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(DownloadService.this, "下载完成", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected void onProgressUpdate(Integer... values) {

//            for (int i = 0; i < values.length; i++) {
//                Log.d("test", "onProgressUpdate: ============当前进度" + values[i]);
//            }

            super.onProgressUpdate(values);
            if (values[0] >= 200) {
                Toast.makeText(DownloadService.this, "发生错误", Toast.LENGTH_SHORT).show();
            } else {
                remoteViews.setProgressBar(R.id.progressBar, 100, progress, false);
                manager.notify(id, notification);
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(DownloadService.this, "开始下载", Toast.LENGTH_SHORT).show();
        }


        int progress;
        private String name = "androidStudio.exe";

        @Override
        protected Void doInBackground(String... strings) {

            int total;
            BufferedInputStream bufi = null;
            BufferedOutputStream bfo = null;


            try {
                URLConnection connection = new URL("https://dl.google.com/dl/android/studio/install/3.2.0.26/android-studio-ide-181.5014246-windows.exe").openConnection();

                connection.setDoInput(true);
                connection.setReadTimeout(8000);
                connection.connect();

                InputStream is = connection.getInputStream();
                total = connection.getContentLength();
                bufi = new BufferedInputStream(is);

                File file;

                bfo = new BufferedOutputStream(new FileOutputStream(

                        file = new File(getExternalCacheDir(), name)
                ));

                if (!file.exists()) {
                    file.createNewFile();
                    Log.d("test", "doInBackground: ==============开始创建文件");
                }


                byte[] b = new byte[1024];
                int len;

                int pro = 0;


                while ((len = bufi.read(b, 0, b.length)) != -1) {
                    bfo.write(b, 0, len);

                    pro += len;

                    progress = (int) (pro * 1.0f / total * 100);

                    Log.d("test", "当前进度= " + progress);
                    publishProgress(progress);
                }

                bfo.flush();

            } catch (IOException e) {
                publishProgress(2000);
                e.printStackTrace();
            } finally {

                try {
                    bfo.close();
                    bufi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            return null;
        }


    }


}
