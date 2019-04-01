package com.example.componentasystemtest.broadcastTest;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.componentasystemtest.R;
import com.example.componentasystemtest.tools.Looger;

public class SubActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_test_sub);

        findViewById(R.id.send).setOnClickListener((v) -> {

            Intent intent = new Intent("com.example.componentasystemtest.broadcastTest");
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                intent.setComponent(new ComponentName(this.getPackageName(), "com.example.componentasystemtest.broadcastTest"));
            }
            Looger.d("发送广播");

            sendBroadcast(intent);

        });


    }
}
