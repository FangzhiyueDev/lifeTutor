package com.example.componentasystemtest.density.DensityConvertUtil;

import android.content.Context;
import android.util.TypedValue;

public class DensityConvertUtil {

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

    /**
     * `
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
