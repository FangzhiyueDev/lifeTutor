package com.example.componentasystemtest.broadcastTest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.componentasystemtest.R;
import com.example.componentasystemtest.tools.Looger;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ActivityTest braodcast = new ActivityTest();
//        IntentFilter intentFilter = new IntentFilter("com.example.componentasystemtest.broadcastTest");
//        registerReceiver(braodcast, intentFilter);

        setContentView(R.layout.broadcast_test);

        findViewById(R.id.send).setOnClickListener((v) -> {
            Intent intent = new Intent("com.example.componentasystemtest.broadcastTest");
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                intent.setComponent(new ComponentName(this.getPackageName(), "com.example.componentasystemtest.broadcastTest"));
            }
            Looger.d("发送广播");

            sendBroadcast(intent);

            /**
             * 下边的代码是动态的注册了一个本地广播
             */

            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
            ActivityTest activityTest = new ActivityTest();

            localBroadcastManager.registerReceiver(activityTest, new IntentFilter("com.example.componentasystemtest.broadcastTest"));


            localBroadcastManager.sendBroadcast(new Intent("com.example.componentasystemtest.broadcastTest"));//发送本地广播

            //发送有序广播
            sendOrderedBroadcast(intent, "LifeTatour");
        });
    }
}
