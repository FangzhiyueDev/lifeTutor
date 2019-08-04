package com.rcs.nchumanity.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import com.rcs.nchumanity.tool.StringTool;
import com.rcs.nchumanity.ul.InputPasswordActivity;

/**
 * 持久化参数
 */
public class PersistenceData {


    public static final String DATA = "RCS";


    public static final String DEF_USER = "-1";
    public static final Object DEF_VAL = "-1";


    public static String USER_ID = "userId";

    public static String PASSWORD = "password";


    public static String PHONE = "phone";

    public static String DEF_PHONE = "-1";

    public static String NICKNAME = "nickName";

    public static String PICTURE = "picture";


    public static SharedPreferences getSp(Context context) {
        return context.getSharedPreferences(DATA, Context.MODE_PRIVATE);
    }


    public static void setUserId(Context context, String userId) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(USER_ID, userId);
        editor.commit();
    }

    public static String getUserId(Context context) {
        SharedPreferences sp = getSp(context);
        return sp.getString(USER_ID, DEF_USER);
    }

    public static void setPhoneNumber(Context context, String phoneNumber) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(PHONE, phoneNumber);
        editor.commit();
    }

    public static String getPhoneNumber(Context context) {
        SharedPreferences sp = getSp(context);
        return sp.getString(PHONE, DEF_PHONE);
    }

    public static void setNickName(Context context, String nickname) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(NICKNAME, nickname);
        editor.commit();
    }

    public static void setUserPicture(Context context, String pictureUrl) {
        SharedPreferences sp = getSp(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(PICTURE, pictureUrl);
        editor.commit();
    }


    public static String getNickName(Context context) {
        SharedPreferences sp = getSp(context);
        return sp.getString(NICKNAME, DEF_USER);
    }

    public static CharSequence getPicture(Context context) {
        SharedPreferences sp = getSp(context);
        return sp.getString(PICTURE, "-1");
    }
}
