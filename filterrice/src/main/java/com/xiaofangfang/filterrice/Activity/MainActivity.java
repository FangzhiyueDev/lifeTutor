package com.xiaofangfang.filterrice.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xiaofangfang.filterrice.Fragment.BannerFragment;
import com.xiaofangfang.filterrice.Fragment.FragmentPageFour;
import com.xiaofangfang.filterrice.Fragment.FragmentPageOne;
import com.xiaofangfang.filterrice.Fragment.FragmentPageThree;
import com.xiaofangfang.filterrice.Fragment.FragmentPageTwo;
import com.xiaofangfang.filterrice.R;
import com.xiaofangfang.filterrice.consumeView.BannerImgViewContainer;
import com.xiaofangfang.filterrice.model.ImageData;

import java.util.ArrayList;
import java.util.List;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }


    FragmentPageOne fragmentPageOne;
    FragmentPageTwo fragmentPageTwo;
    FragmentPageThree fragmentPageThree;
    FragmentPageFour fragmentPageFour;
    Button button1, button2, button3, button4;
    ViewPager viewPager;
    MyPageAdapter myPageAdapter;
    List<Fragment> fragmentList;


    private void initView() {


        fragmentPageOne = new FragmentPageOne();
        fragmentPageTwo = new FragmentPageTwo();
        fragmentPageThree = new FragmentPageThree();
        fragmentPageFour = new FragmentPageFour();

        fragmentList = new ArrayList<>();
        fragmentList.add(fragmentPageOne);
        fragmentList.add(fragmentPageTwo);
        fragmentList.add(fragmentPageThree);
        fragmentList.add(fragmentPageFour);


        myPageAdapter = new MyPageAdapter(getSupportFragmentManager());


        viewPager = findViewById(R.id.viewPage);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        viewPager.setOffscreenPageLimit(4);

        viewPager.setAdapter(myPageAdapter);


        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        List<Button> buttons = new ArrayList<>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);

        for (int i = 0; i < buttons.size(); i++) {

            int finalI = i;
            buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(finalI);
                }
            });
        }


    }


    class MyPageAdapter extends FragmentPagerAdapter {

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }


}
