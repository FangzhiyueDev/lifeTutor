package com.example.momomusic.tool;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class ResourceUtil {


    public static String getString(int resId, Context context) {
        return context.getResources().getString(resId);
    }

    public static Drawable getDrawable(int resId, Context context) {
        return context.getResources().getDrawable(resId);
    }

}
