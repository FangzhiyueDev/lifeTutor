package com.example.componentasystemtest.density;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import android.util.Log;

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
    public int px2dpi(Context context, int pxValue) {

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
    public int dpi2px(Context context, int dpiValue) {
        int density = (int) context.getResources().getDisplayMetrics().density;
        return dpiValue * density;
    }


    /**
     * 将sp转换为px
     * @param context
     * @param spValue
     */
    public int sp2px(Context context, int spValue) {
        int spDensity = (int) context.getResources().getDisplayMetrics().scaledDensity;
        return spValue * spDensity;
    }

    /**
     * 将px转化为sp
     * @param context
     * @param pxValue
     * @return
     */
    public int px2sp(Context context, int pxValue) {
        int spDensity = (int) context.getResources().getDisplayMetrics().scaledDensity;
        return pxValue * spDensity;
    }


}
