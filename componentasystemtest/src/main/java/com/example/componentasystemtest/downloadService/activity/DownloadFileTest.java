package com.example.componentasystemtest.downloadService.activity;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.RemoteViews;

import com.example.componentasystemtest.R;
import com.example.componentasystemtest.downloadService.service.DownloadService;

public class DownloadFileTest extends AppCompatActivity {


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_file);


        findViewById(R.id.down).setOnClickListener((v) -> {

            Intent intent = new Intent(DownloadFileTest.this, DownloadService.class);
            startService(intent);

        });

    }


}
