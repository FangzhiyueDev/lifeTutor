package com.xiaofangfang.consumeview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xiaofangfang.consumeview.view.FullRoLLView;

import java.util.Arrays;

public class ViewPagerDownActivity extends AppCompatActivity {


    String[] value = {
            "sgwerehwerrherh",
            "爱上风格为规范围观啊飒飒发夫妻为请问而过",
            "s问过他问问啊",
            "asfaag是高温高",
            "sgwerehwerrherh",
            "爱上风格为规范围观",
            "s问过他问问啊",
            "asfaag是高温高"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpagerdown);

        FullRoLLView fullRoLLView = findViewById(R.id.fullRoll);
        fullRoLLView.setData(Arrays.asList(value));
        fullRoLLView.autoRun(3000);
    }
}






