package com.example.componentasystemtest.density;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ContentFrameLayout;

import android.util.Log;
import android.util.TypedValue;

/**
 * Created by fang on 2018/6/7.
 */

public class Density extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int density = (int) getResources().getDisplayMetrics().density;//获得dpi转换px的换算比例
        int densityDpi = getResources().getDisplayMetrics().densityDpi;//得到当前手机的dpi值
        int piexsY = getResources().getDisplayMetrics().heightPixels;//获得高的像素点
        int piexsX = getResources().getDisplayMetrics().widthPixels;//获得宽的像素点
        int scaleDensity = (int) getResources().getDisplayMetrics().scaledDensity;
        int xdpi = (int) getResources().getDisplayMetrics().xdpi;//取得的就是densityDpi
        int ydpi = (int) getResources().getDisplayMetrics().ydpi;//取得的就是densityDpi
        Log.d("test", "density=" + density + ";   densityDpi=" + densityDpi + ";   piexsY=" + piexsY + ";   piexsX=" + piexsX + ";  scaleDeinsity=" + scaleDensity + ";    xdpi=" + xdpi + ";    ydpi=" + ydpi);
    }

    /**
     * 实现px到dpi的转换
     *
     * @param context
     * @param pxValue
     */
    public static int px2dpi(Context context, int pxValue) {

        int density = (int) context.getResources().getDisplayMetrics().density;
        return pxValue / density;
    }

    /**
     * 将dpi转换为px
     *
     * @param context
     * @param dpiValue
     * @return
     */
    public static int dpi2px(Context context, int dpiValue) {
        int density = (int) context.getResources().getDisplayMetrics().density;
        return dpiValue * density;
    }


    /**
     * 将sp转换为px
     *
     * @param context
     * @param spValue
     */
    public static int sp2px(Context context, int spValue) {
        int spDensity = (int) context.getResources().getDisplayMetrics().scaledDensity;
        return spValue * spDensity;
    }


    /**
     * 将px转为sp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /** `
     * 将sp转为px
     *
     * @param context
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }


    public static int dp2px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(int sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }




}
