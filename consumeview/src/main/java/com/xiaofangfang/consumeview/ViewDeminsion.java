package com.xiaofangfang.consumeview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xiaofangfang.consumeview.view.MyView;

public class ViewDeminsion extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_deminsion);

        MyView myView=findViewById(R.id.myview);
        myView.autoRun();

    }
}
