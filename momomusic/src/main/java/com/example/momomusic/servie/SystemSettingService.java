package com.example.momomusic.servie;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * 系统设置服务
 */
public class SystemSettingService {

    private static SharedPreferences sharedPreferences;

    private Context context;


    public static final String NAME = "sysSet";

    /**
     * sharedPreferences的参数
     * 代表的是是否进行了音乐运行服务设为绑定,也就代表这前台音乐的运行状态
     * boolean   默认false
     */
    public static final String BIND = "bind";


    private SystemSettingService(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }


    private static SystemSettingService systemSettingService;


    public static SystemSettingService getInstall(Context context) {
        if (systemSettingService == null) {
            systemSettingService = new SystemSettingService(context);
        }
        return systemSettingService;
    }


    /**
     * 获得音乐运行状态
     *
     * @return
     */
    public boolean musicPlayRunStatus() {
        return sharedPreferences.getBoolean(BIND, false);
    }

    /**
     * 绑定音乐运行服务
     *
     * @param isBind
     */
    public void bindMusicPlayService(boolean isBind) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(BIND, isBind);
        editor.commit();
    }


}
