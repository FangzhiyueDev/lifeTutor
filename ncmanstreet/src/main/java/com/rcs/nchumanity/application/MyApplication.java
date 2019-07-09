package com.rcs.nchumanity.application;

import android.app.Application;

import com.orhanobut.logger.Logger;

import org.litepal.LitePal;

public class MyApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 数据库框架的初始化
         */
        LitePal.initialize(this);
        /**
         * 日志框架的
         */
        Logger.init("test");
    }
}
