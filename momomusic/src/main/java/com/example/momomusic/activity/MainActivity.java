package com.example.momomusic.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.momomusic.R;
import com.example.momomusic.activity.ui.MainView;
import com.example.momomusic.component.DaggerMainActivityComponent;
import com.example.momomusic.fragment.JingXuanFragment;
import com.example.momomusic.fragment.MeFragment;
import com.example.momomusic.fragment.ShiPinFragment;
import com.example.momomusic.fragment.ZhiBoFragment;
import com.example.momomusic.precenter.MainPresenter;
import com.example.momomusic.tool.Tools;
import com.example.momomusic.view.Adapter.MyFragmentPageAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<Fragment> fragments;

    private int defaultSelectIndex = 0;

    private MyFragmentPageAdapter myPageAdapter;

    private String tintColor = "#d81e06";
    private String primaryColor = "#111111";

    private int oldIndex;

    @BindView(R.id.my)
    Button my;
    @BindView(R.id.jingxuan)
    Button jingxuan;
    @BindView(R.id.zhibo)
    Button zhidao;
    @BindView(R.id.shipin)
    Button shipin;


    @BindView(R.id.bofang)
    ImageButton bofang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainActivityComponent.create().inject(this);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        Button[] buttons = {
                my, jingxuan, zhidao, shipin
        };

        Tools.setDrawableColor(Color.parseColor(tintColor), buttons[defaultSelectIndex]);

        for (int i = 0; i < buttons.length; i++) {

            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(finalI);
                    Tools.setDrawableColor(Color.parseColor(primaryColor), buttons[oldIndex]);
                    Tools.setDrawableColor(Color.parseColor(tintColor), buttons[finalI]);
                    oldIndex = finalI;
                }
            });

        }


        fragments = new ArrayList<>();
        fragments.add(new MeFragment());
        fragments.add(new JingXuanFragment());//精选
        fragments.add(new ZhiBoFragment());//直播
        fragments.add(new ShiPinFragment());//视频
        myPageAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(myPageAdapter);
        viewPager.setOffscreenPageLimit(4);//设置页面缓存为4个，但是使用了懒加载机制
        viewPager.setCurrentItem(defaultSelectIndex);

        oldIndex = defaultSelectIndex;

    }


    @Override
    public MainView createView() {
        return this;
    }

    @Override
    public MainPresenter createPresenter() {
        return mainPresenter;
    }


    @OnClick(
    )
    public void menuClick(View view) {


    }


}
