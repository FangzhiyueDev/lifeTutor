package com.xiaofangfang.filterrice.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.xiaofangfang.filterrice.R;


/**
 * 这个界面是产品销售的主界面，
 * 套餐卡的视图，最新手机的视图，二手机的视图
 * 全部通过该界面进行
 */

public class ProductSalePageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_sale_page);

        initViewLayout();


    }


    DrawerLayout drawerLayout;


    /**
     * 动态的初始化view的布局
     */
    private void initViewLayout() {

         drawerLayout = findViewById(R.id.drawableLayout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);




    }


}
