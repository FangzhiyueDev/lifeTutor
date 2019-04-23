package com.example.momomusic.dialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;;
import android.widget.TextView;

import com.example.momomusic.R;

import androidx.annotation.LayoutRes;

/**
 * 提供了一些定义好的dialog
 */
public abstract class DialogTool<T> implements DialogSet {


    private ViewGroup view;
    //1.操作成功
    //2,警告弹窗
    //3提示弹窗

    private Context context;

    public Dialog getDialog(Context context, @LayoutRes int viewResId, T... t) {

        this.context = context;

        view = (ViewGroup) LayoutInflater.from(context).inflate(viewResId, null, false);

        Dialog dialog = new AlertDialog.Builder(context)
                .setView(view)
                .setCancelable(true)
                .create();


        bindView(this, dialog, t);
        return dialog;
    }


    public abstract void bindView(DialogTool<T> d, Dialog dialog, T... t);

    @Override
    public void setText(int id, String text) {
        View view1 = view.findViewById(id);
        if (view1 instanceof TextView) {
            ((TextView) view1).setText(text);
        }

    }

    @Override
    public void setClickListener(int id, View.OnClickListener click) {
        View view1 = view.findViewById(id);
        view1.setOnClickListener(click);
    }

    @Override
    public void setAsyncImage(int id, int res) {
        View view2 = view.findViewById(id);
        if (view2 instanceof ImageView) {
            ((ImageView) view2).setImageResource(res);
        }
    }

    public void setTextSize(int id, int size) {

        float realSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, context.getResources().getDisplayMetrics());
        View view2 = view.findViewById(id);
        if (view2 instanceof TextView) {
            ((TextView) view2).setTextSize(realSize);
        }
    }

    public void setVisibility(int id, int visiable) {
        View view1 = view.findViewById(id);
        view1.setVisibility(visiable);
    }

    /**
     * 使用这个方法的同时,传入的dialog必须设置Theme.Dialog的主题
     *
     * <style name="DialogTheme" parent="@android:style/Theme.Dialog">
     * <item name="android:background">@android:color/transparent</item>
     * <item name="android:windowBackground">@android:color/transparent</item>
     *
     * </style>
     *
     * @param dialog
     */
    public void setWidthWithScreen(Dialog dialog) {
        WindowManager windowManager = dialog.getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = (int) (display.getWidth());//设置宽度dialog.getWindow().setAttributes(lp);
    }


}
