package com.xiaofangfang.opensourceframeworkdemo.Dagger2.simple2;


import android.os.Bundle;
import android.widget.Toast;

import com.xiaofangfang.opensourceframeworkdemo.Dagger2.simple1.UserManager;
import com.xiaofangfang.opensourceframeworkdemo.R;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Inject
    SellMoe sellMoe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dagger_activity);

        DaggerMainActivityComponent.create().inject(this);

        Toast.makeText(this, sellMoe.sellMoe(), Toast.LENGTH_SHORT).show();


    }
}
