package com.xiaofangfang.opensourceframeworkdemo.U_ment.U_shared;

import android.app.Application;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;

public class MyApplication extends Application {

    private static final String TAG = "test";

    @Override
    public void onCreate() {
        super.onCreate();


//        MultiDex.install(this);

        UMConfigure.setLogEnabled(true);


        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数3:Push推送业务的secret
         */
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null);

//微信
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //新浪微博(第三个参数为回调地址)
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com/sina2/callback");
        //QQ
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        //支付宝
        PlatformConfig.setAlipay("2015111700822536");

        //钉钉
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");

    }
}
