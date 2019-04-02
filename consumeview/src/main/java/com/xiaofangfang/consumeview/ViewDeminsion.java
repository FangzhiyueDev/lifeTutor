package com.xiaofangfang.consumeview;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
