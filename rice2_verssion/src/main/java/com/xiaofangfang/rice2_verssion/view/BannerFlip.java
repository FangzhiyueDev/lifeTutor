package com.xiaofangfang.rice2_verssion.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.xiaofangfang.rice2_verssion.R;
import com.xiaofangfang.rice2_verssion.tool.Tools;
import com.xiaofangfang.rice2_verssion.view.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class BannerFlip extends FrameLayout {


    public BannerFlip(@NonNull Context context) {
        super(context);
    }

    public BannerFlip(@NonNull Context context, AttributeSet attr) {
        super(context, attr);
        initView();
    }


    private ViewPager viewPager;
    private List<ImageView> imageViews;


    public void setBannerHeight(int height) {
        viewPager.setLayoutParams(new LayoutParams(-1, height));
    }


    /**
     * 这个设置的图片的地址
     */
    public void setImageUrl(List<? extends Object> imageUrl) {

        for (Object obj : imageUrl) {

            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (obj instanceof String) {
                String value = (String) obj;
                Glide.with(getContext()).load(value).into(imageView);
            } else if (obj instanceof Integer) {
                int value = (int) obj;
                Glide.with(getContext()).load(value).into(imageView);
            }
            this.imageViews.add(imageView);
        }

        mvpa.notifyDataSetChanged();

        addPoint(imageUrl.size());
    }

    private void addPoint(int size) {
        for (int i = 0; i < size; i++) {

            View view = new View(getContext());
            LinearLayout.LayoutParams ly = new LinearLayout.LayoutParams(50, 50);
            ly.gravity = Gravity.CENTER_VERTICAL;
            if (i == 0) {
                ly.leftMargin = 40;
            } else {
                ly.leftMargin = 5;
            }
            ly.bottomMargin = 20;
            view.setBackgroundResource(R.drawable.circle);
            view.setLayoutParams(ly);

            linearLayout.addView(view);
        }
    }

    MyViewPagerAdapter mvpa;
    LinearLayout linearLayout;

    private void initView() {
        imageViews = new ArrayList<>();
        viewPager = new ViewPager(getContext());
        viewPager.setAdapter(mvpa = new MyViewPagerAdapter<ImageView>(imageViews));

        linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        FrameLayout.LayoutParams ly = new FrameLayout.LayoutParams(-1, 100);
        ly.gravity = Gravity.BOTTOM | Gravity.CENTER_VERTICAL;
        linearLayout.setLayoutParams(ly);
        this.addView(viewPager);
        this.addView(linearLayout);
    }


    private Timer timer;
    int index;
    int oldIndex;

    public void startAutoRoll(long delay) {

        final android.os.Handler handler = new android.os.Handler(Looper.getMainLooper()) {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    linearLayout.getChildAt(oldIndex).setBackgroundResource(R.drawable.circle);
                    viewPager.setCurrentItem(index);
                    linearLayout.getChildAt(index).setBackgroundResource(R.drawable.circle_select);
                    oldIndex=index;
                }
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                index++;
                index = index % imageViews.size();

                handler.sendEmptyMessage(0);

            }
        }, delay, delay);

    }


}
