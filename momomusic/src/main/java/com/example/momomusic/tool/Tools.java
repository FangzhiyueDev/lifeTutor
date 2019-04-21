package com.example.momomusic.tool;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.momomusic.R;
import com.example.momomusic.activity.MainActivity;
import com.example.momomusic.activity.ParentActivity;
import com.example.momomusic.activity.PrimaryActivity;
import com.example.momomusic.fragment.CommentListFragment;
import com.example.momomusic.view.HotCommentList;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;

public class Tools {


    public static int[] getScreenDimension(Context context) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int[] val = {
                displayMetrics.widthPixels,
                displayMetrics.heightPixels
        };
        return val;
    }


    /**
     * 这个方法实现的是传递相对应的view设置对应的compoundDrwable的颜色
     *
     * @param color
     * @param t
     * @param <T>
     */
    public static <T extends TextView> void setDrawableColor(int color, T t) {
        Drawable[] dws = t.getCompoundDrawables();
        for (Drawable dw : dws) {
            if (dw != null) {
                dw.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
            }
        }
    }


    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }


    /**
     * 将px转为  dp
     *
     * @param value
     * @param context
     * @return
     */
    public static int px2dp(int value, Context context) {

        float scale = (int) context.getResources().getDisplayMetrics().density;
        return (int) (value / scale + 0.5f);
    }


    public static Dialog showWarnDialog(String title, String message, Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setNegativeButton("确定", (dialog, which) -> {

                    dialog.cancel();
                })
                .setNegativeButton("取消", (dialog, which) -> {
                    dialog.cancel();
                })
                .setMessage(message);
        return builder.create();

    }


    public static void loadPop(Context context, EventProgress eventProgress, int height, @LayoutRes int res, @StyleRes int anim) {

        WindowManager windowManager = ((ParentActivity) context).getWindowManager();

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, (int) height, WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_DITHER, PixelFormat.TRANSPARENT
        );
        layoutParams.windowAnimations = anim;
        layoutParams.gravity = Gravity.BOTTOM;
        View view = LayoutInflater.from(context).inflate(res, null, false);
        eventProgress.eventProgress(view);
        windowManager.addView(view, layoutParams);
        //设置背景变暗
    }


    public interface EventProgress {

        void eventProgress(View view);

    }


    public String getFilterCondition(String value) {

        String[] v = value.split("&");
        if (v.length == 1) {//代表的是当前过滤条件为单条


        }


        return value;
    }


    /**
     * 获得软件的版本
     *
     * @return
     */
    public static long getSoftWareVersion(Context context) {
        PackageManager pm = context.getPackageManager();
        PackageInfo pi = null;
        try {
            pi = pm.getPackageInfo(context.getPackageName(), 0);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        long versionCode;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            versionCode = pi.getLongVersionCode();
        } else {
            versionCode = pi.versionCode;
        }
        return versionCode;
    }

    /**
     * "HH:mm
     *
     * @param param
     * @return
     */
    public static String dateFormat(String param) {
        SimpleDateFormat sdf = new SimpleDateFormat(param);
        Date date = new Date(System.currentTimeMillis());
        String value = sdf.format(date);
        return value;
    }


    /**
     * 设置drawableLeft
     *
     * @param imgRes
     * @param context
     * @param textView
     */
    public static void drawableChangeLeft(@DrawableRes int imgRes, Context context, TextView textView) {
        Drawable drawable = context.getResources().getDrawable(imgRes);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    /**
     * 设置drawableRight
     *
     * @param imgRes
     * @param context
     * @param textView
     */
    public static void drawableChangeRight(@DrawableRes int imgRes, Context context, TextView textView) {
        Drawable drawable = context.getResources().getDrawable(imgRes);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, null, drawable, null);
    }

    /**
     * 设置drawableRight
     *
     * @param context
     * @param textView
     */
    public static void drawableChangeRight(Drawable drawable, Context context, TextView textView) {
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, null, drawable, null);
    }


    /**
     * 设置drawableTop
     *
     * @param imgRes
     * @param context
     * @param textView
     */
    public static void drawableChangeTop(@DrawableRes int imgRes, Context context, TextView textView) {
        Drawable drawable = context.getResources().getDrawable(imgRes);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }


    /**
     * 启动一个path
     *
     * @param context
     * @param path
     */
    public static void startActivity(Context context, String path) {
        Intent intent = new Intent(context, PrimaryActivity.class);
        intent.putExtra(PrimaryActivity.INTENT_KEY, path);
        context.startActivity(intent);
    }


}
