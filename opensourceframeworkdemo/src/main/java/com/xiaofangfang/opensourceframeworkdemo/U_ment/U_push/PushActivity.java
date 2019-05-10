package com.xiaofangfang.opensourceframeworkdemo.U_ment.U_push;

import android.os.Bundle;

import com.umeng.message.PushAgent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PushActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();

    }
}
