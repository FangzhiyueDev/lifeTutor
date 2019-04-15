package com.xiaofangfang.consumeview.banner;

import android.os.Bundle;

import com.xiaofangfang.consumeview.R;

import java.util.Arrays;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BannerActivity extends AppCompatActivity {

    BannerFlip bannerFlip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);


        Integer[] value = {
                R.drawable.banner1,
                R.drawable.banner2,
                R.drawable.banner3,
                R.drawable.banner4,
                R.drawable.banner5,
                R.drawable.banner6
        };
        bannerFlip = findViewById(R.id.banner);
        bannerFlip.setImageUrl(Arrays.asList(value));
        bannerFlip.setBannerHeight(600);
        bannerFlip.startAutoRoll(2000);
    }
}
