package com.example.componentasystemtest.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;


import com.example.componentasystemtest.R;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

/**
 * Created by fang on 2018/6/10.
 */

public class MyNotification extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo11);
        Button send = (Button) findViewById(R.id.button1);
        send.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
      //  notification1();
        notification2();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void notification2() {
        Notification.Builder builder = new Notification.Builder(this);
        //实现悬挂式的效果
        builder.setFullScreenIntent(PendingIntent.getActivity(this, 1, new Intent(this, MyNotification.class), FLAG_UPDATE_CURRENT), false);
        builder.setContentText("你有一封邮件");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private void notification1() {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification1);
        remoteViews.setTextViewText(R.id.removeViewButton, "点击");
        remoteViews.setOnClickPendingIntent(R.id.removeViewButton, PendingIntent.getActivity(this, 1, new Intent(this, MyNotification.class), FLAG_UPDATE_CURRENT));
        RemoteViews remoteViews1 = new RemoteViews(getPackageName(), R.layout.bignotification);
        builder.setCustomContentView(remoteViews);
        builder.setCustomBigContentView(remoteViews1);
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}
