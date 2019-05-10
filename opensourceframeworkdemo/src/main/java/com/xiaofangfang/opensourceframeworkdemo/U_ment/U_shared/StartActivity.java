package com.xiaofangfang.opensourceframeworkdemo.U_ment.U_shared;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.xiaofangfang.opensourceframeworkdemo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actiity_start);

        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }

    }

    public void onClick(View view) {

        new ShareAction(StartActivity.this).withText("hello").setDisplayList(SHARE_MEDIA.SINA,
                SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {

                    }
                }).open();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
