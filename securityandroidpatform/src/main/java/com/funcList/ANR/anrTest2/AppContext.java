package com.funcList.ANR.anrTest2;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.funcList.ANR.ANRApplication;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.github.moduth.blockcanary.BuildConfig;

public class AppContext extends BlockCanaryContext {


    private Application application;

    public AppContext(Application application){
        this.application=application;
    }



    private static final String TAG = "test";

    @Override
    public String provideQualifier() {
        String qualifier = "";
        try {
            PackageInfo info = application.getPackageManager()
                    .getPackageInfo(application.getPackageName(), 0);
            qualifier += info.versionCode + "_" + info.versionName + "_YYB";
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "provideQualifier exception", e);
        }
        return qualifier;
    }

    @Override
    public int provideBlockThreshold() {
        return 500;
    }

    @Override
    public boolean displayNotification() {
        return BuildConfig.DEBUG;
    }

    @Override
    public boolean stopWhenDebugging() {
        return false;
    }








}
