package com.rcs.nchumanity.ul;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.orhanobut.logger.Logger;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.MyFragmentPageAdapter;
import com.rcs.nchumanity.fragment.JYPXFragment;
import com.rcs.nchumanity.fragment.MainFragment;
import com.rcs.nchumanity.fragment.MeFragment;
import com.rcs.nchumanity.fragment.ZYJYFragment;
import com.rcs.nchumanity.tool.ActivityStackManager;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.view.CommandBar;
import com.rcs.nchumanity.view.MyViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 前后端接口 使用json作为前后端的交互的实现
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 1----用户的主界面的实现
 * 1.banner的接口
 * 传递的是图片的url，因为是多张，使用json数组的形式传递  [{"url":"/img/banner1.jpg"},{"url":"/img/banner2.jpg"},....]
 * 查询的表是特定图片信息表    specific_picture
 * <p>
 * 2.用户功能的接口
 * 传递的是用户功能区的相关数据  传递的数据是父类为培训相关的数据，
 * 查询的表是特定信息分类表 specific_info_classification
 * <p>
 * <p>
 * <p>
 * 3.分类信息的接口
 * 查询首页数据并查询出对应分类的前3条数据的id 和名称
 * <p>
 * <p>
 * <p>
 * 2----救护培训界面  ,没有网络请求
 * <p>
 * 3----我的里面
 */
public class MainActivity extends ParentActivity {


    private static final String TAG = "test";
    @BindViews({R.id.main, R.id.jhpx, R.id.zyjy, R.id.me})
    List<Button> downBtns;


    @BindView(R.id.toolbar)
    public CommandBar toolbar;


    /**
     * 可以提供设置是否可以左右滑动
     */
    @BindView(R.id.viewPager)
    MyViewPager viewPager;


    private int themeColor = Color.parseColor("#d53232");
    private int defColor = Color.parseColor("#999999");

    private String title;

    private List<Fragment> fragments;

    private int cachePage = 4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission(permissions, REQUEST_CODE_PERMISSION);
        ButterKnife.bind(this);
        initView();

    }

    /**
     * 默认的选中索引值
     */
    private int defaultIndex = 0;

    private void initView() {
        Tool.setDrawableColor(themeColor, downBtns.get(defaultIndex));

        title = (String) downBtns.get(defaultIndex).getText();
        toolbar.hiddenBack();
        toolbar.setTitle(title);


        fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new JYPXFragment());//精选
        fragments.add(new ZYJYFragment());//直播
        fragments.add(new MeFragment());//视频
        MyFragmentPageAdapter myPageAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(myPageAdapter);
        viewPager.setOffscreenPageLimit(cachePage);//设置页面缓存为4个，但是使用了懒加载机制
        viewPager.setCurrentItem(defaultIndex);

        ActivityStackManager asm = ActivityStackManager.getInstance(this);

        Log.d(TAG, "当前activity的name=" + asm.getTopStackPackageName());
        Log.d(TAG, "当前活动栈的size=" + asm.getStackSize());

    }


    @OnClick({R.id.main, R.id.zyjy, R.id.jhpx, R.id.me})
    public void onClick(View view) {

        String indexS = (String) view.getTag();
        int index = Integer.parseInt(indexS);
        if (index != defaultIndex) {

            Tool.setDrawableColor(defColor, downBtns.get(defaultIndex));
            Tool.setDrawableColor(themeColor, downBtns.get(index));
            downBtns.get(index).setTextColor(themeColor);
            downBtns.get(defaultIndex).setTextColor(defColor);


            defaultIndex = index;
            title = (String) downBtns.get(defaultIndex).getText();
            toolbar.setTitle(title);
            viewPager.setCurrentItem(defaultIndex);
        }


        if (index == cachePage - 1) {
            toolbar.setVisibility(View.GONE);
            //代表的是我的界面
        } else if (index == cachePage - 2) {
            toolbar.setVisibility(View.GONE);
        } else {
            toolbar.setVisibility(View.VISIBLE);
            toolbar.hideMenu();
        }
    }


}
