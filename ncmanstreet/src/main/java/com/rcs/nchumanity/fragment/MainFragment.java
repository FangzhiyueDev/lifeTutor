package com.rcs.nchumanity.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.model.SpecificInfo;
import com.rcs.nchumanity.entity.model.SpecificInfoClassification;
import com.rcs.nchumanity.tool.DensityConvertUtil;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.AmbulanceRescueActivity;
import com.rcs.nchumanity.ul.detail.SpecificInfoComplexListDetailActivity;
import com.rcs.nchumanity.ul.list.ComplexListActivity;
import com.rcs.nchumanity.ul.list.SpecificInfoComplexListActivity;
import com.rcs.nchumanity.ul.TrainStepActivity;
import com.rcs.nchumanity.ul.basicMap.BasicMapActivity;
import com.rcs.nchumanity.view.BannerFlip;
import com.rcs.nchumanity.view.BasicItem;
import com.rcs.nchumanity.view.PercentLinearLayout;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页的界面的显示
 */
public class MainFragment extends ParentFragment {


    @Override
    protected int getCreateView() {
        return R.layout.fragment_main;
    }


    @BindView(R.id.banner)
    BannerFlip banner;

    @BindView(R.id.funcArea)
    LinearLayout funcArea;

    @BindView(R.id.basicItem1)
    BasicItem basicItem1;

    @BindView(R.id.basicInfoArea)
    LinearLayout basicInfoArea;


    private int defBannerHeight = 200;

    /**
     * 定义的是每一行的列的数量
     */
    private static final int COLUMN_LENGTH = 4;

    private int delay = 3000;

    private int rowWidth;

    private static final int marginBottom = 5;


    @Override
    protected void onViewCreated(View view, Bundle savedInstanceState, boolean isViewCreated) {
        banner.setBannerHeight(DensityConvertUtil.dpi2px(getContext(), defBannerHeight));
        banner.setImageUrl(Arrays.asList(new Integer[]{R.drawable.banner1, R.drawable.banner2}));
        banner.startAutoRoll(delay);
        rowWidth = (int) (Tool.getScreenDimension(getContext())[0] / 10 * 9.6);
    }


    /**
     * 用来加载数据
     */
    @Override
    protected void onLoadData() {

        daymicFuncList();

        basicItem1.setAllSet(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.more:

                        SpecificInfoClassification classification = (SpecificInfoClassification) v.getTag();

                        Bundle bundle1 = new Bundle();
                        bundle1.putSerializable(SpecificInfoClassification.class.getSimpleName(),classification);
                        Tool.startActivity(getContext(),SpecificInfoComplexListActivity.class,bundle1);
                        break;

                    default: {
                        //对于其他的点击，就是对item的点击
                        SpecificInfo specificInfo = (SpecificInfo) v.getTag();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(SpecificInfo.class.getSimpleName(), specificInfo);
                        Tool.startActivity(getContext(), SpecificInfoComplexListDetailActivity.class, bundle);
                    }
                }
            }
        }, null);

    }


    private PercentLinearLayout cacheView() {
        return (PercentLinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.include_funclist, null);
    }


    /**
     * 动态获得后端的功能列表
     * <p>
     * 需要传递的参数是图标，和对应的文字
     * 传递的是一组数据
     */
    public void daymicFuncList() {

        /**
         * 算法实现
         * 1.判断funcArea的child的个数，代表  的是每一行数据
         * 2.判断每一行child的个数，如果child<4 就去添加一个子节点，如果=4 就去创建新的行
         */


        LinearLayout lastIndexRow = (LinearLayout)
                (funcArea.getChildCount() == 1 ?
                        funcArea.getChildAt(0) : funcArea.getChildAt(funcArea.getChildCount() - 1));


        //添加元素到ly
        /**
         * 1.PercentLinearLayout
         *    ---PercentFrameLayout
         *          ---ImageButton
         *    ---TextView
         *
         */
        PercentLinearLayout ply = addFuncItem(R.drawable.ic_08, "dfd");
        ply.setOnClickListener((v) -> {
            //对于新添加的view我们设置点击事件
            Tool.startActivity(getContext(), ComplexListActivity.class);
        });


        if (lastIndexRow.getChildCount() == COLUMN_LENGTH) {
            //创建新的行

            LinearLayout ly = new PercentLinearLayout(getContext());
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(rowWidth, -2);
            lp.bottomMargin = DensityConvertUtil.dp2px(getContext(), marginBottom);
            ly.setBackgroundColor(Color.parseColor("#ffffff"));
            ly.setLayoutParams(lp);

            ly.addView(ply);
            //将行添加到funcArea中
            funcArea.addView(ly);

        } else {
            //添加元素到lastIndexRow
            lastIndexRow.addView(ply);
        }


    }


    private PercentLinearLayout addFuncItem(@DrawableRes int drawResId, String text) {
        PercentLinearLayout ply = cacheView();
        ply.setLayoutParams(new LinearLayout.LayoutParams(rowWidth / 4, -2));
        ((ImageButton) ply.findViewById(R.id.menuIcon)).setImageResource(drawResId);
        ((TextView) ply.findViewById(R.id.iconText)).setText(text);
        return ply;
    }


    /**
     * 功能区的其他3个按钮
     */
    @OnClick({R.id.jhypx, R.id.aedfb, R.id.jhyjy, R.id.hjjhy})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.jhypx:

                Tool.startActivity(getContext(), TrainStepActivity.class);

                break;

            case R.id.aedfb:

                Tool.startActivity(getContext(), BasicMapActivity.class);

                break;

            case R.id.jhyjy:

                Tool.startActivity(getContext(),
                        AmbulanceRescueActivity.class
                );

                break;

            case R.id.hjjhy:


                //直接发送激光推送


                break;
        }
    }


}
