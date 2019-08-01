package com.rcs.nchumanity.ul;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.fragment.ZYJYFragment;

public class AmbulanceRescueActivity extends ParentActivity {

    private static final String TAG = "test";

    int statuBarHeight = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams mParams;

        mParams = new WindowManager.LayoutParams();
        mParams.format = PixelFormat.TRANSLUCENT;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            mParams.flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;  //设置状态栏透明

            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                statuBarHeight = getResources().getDimensionPixelSize(resourceId);
            }
        }
        getWindow().setAttributes(mParams);

        /**
         * 上面实现的是透明的状态栏，实现了很多的方案，发现上面的实现
         * 是实现的最好的，之前自己实现的都有问题
         */

        setContentView(R.layout.activity_ambulance_rescue);

        ZYJYFragment fragment =
                (ZYJYFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.zyjyFragment);
        fragment.setToolbarOffsetY(statuBarHeight);


    }
}
