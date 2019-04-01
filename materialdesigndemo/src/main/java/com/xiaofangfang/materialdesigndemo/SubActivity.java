package com.xiaofangfang.materialdesigndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {


    TabLayout tablayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tablayout);

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.addTab(tablayout.newTab().setText("Tab 1"));
        tablayout.addTab(tablayout.newTab().setText("Tab 2"));
        tablayout.addTab(tablayout.newTab().setText("Tab 3"));
        tablayout.addTab(tablayout.newTab().setText("Tab 4"));
        tablayout.addTab(tablayout.newTab().setText("Tab 5"));
        tablayout.addTab(tablayout.newTab().setText("Tab 6"));








    }
}
