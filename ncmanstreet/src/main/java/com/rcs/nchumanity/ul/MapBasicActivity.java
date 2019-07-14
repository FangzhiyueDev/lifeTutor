package com.rcs.nchumanity.ul;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * 用来实现的是地图的展示，
 * 传递的参数是地图上面的标记点，以及标记点的相关的描述信息，我们
 * 通过经纬度在地图上面进行地图地点标记
 * <p>
 * <p>
 * 该类作为一个基本的信息点的构建模块
 * 需要继承实现不同的类，传递对应的基础点的信息
 * <p>
 * 对于该类传递的具体数据是ArrayList，请注意
 */
public abstract class MapBasicActivity<T> extends ParentActivity implements View.OnTouchListener {


    /**
     * 用于实现各个模块的信息数据的收集
     * 对子类屏蔽实现细节
     */
    private ArrayList<T> tList;


    /**
     * 当前的LinearLayout代表的是用来显示定位信息的界面，
     * 我们对程序进行约束 ，这个布局的坐标的高度不能超过屏幕的一半，如果>屏幕一半，
     * 会衍生到最下面，我们可以通过滑动的方式看见下面的内容详情
     */
    @BindView(R.id.mapPoints)
    LinearLayout mapPoint;


    /**
     * 代表的mapPoint的列表能不能进行移动
     * 默认false
     */
    private boolean canMove = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_basic);
        ButterKnife.bind(this);

        tList = (ArrayList<T>) getIntent().getBundleExtra(Bundle.class.getSimpleName()).getSerializable(tList.getClass().getSimpleName());
        if (tList == null) {
            throw new RuntimeException("please translation Bundle data,this data is ArrayList type");
        }
        setData();

        mapPoint.setOnTouchListener(this);
    }

    protected void setData() {
        for (T t : tList) {
            View view = LayoutInflater.from(this).inflate(getLayoutId(), null);
            bindView(view, t);
            mapPoint.addView(view);
        }
    }

    /**
     * 获得布局的数据
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 将内部的事件交给子类进行实现
     *
     * @param view
     * @param t
     */
    protected abstract void bindView(View view, T t);


    /**
     * 代表的是开始的y值和移动中的Y值
     */
    private int startY, moveY;

    /**
     * 对Map 的点进行触摸事件的处理，可以实现上下滑动的效果
     *
     * @param v
     * @param event
     * @return
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY = (int) event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                moveY = (int) event.getY();
                if (canMove) {

                    int offsetY = moveY - startY;
                    mapPoint.setTranslationY(offsetY);

                }
            case MotionEvent.ACTION_UP:

                break;
        }


        /**
         * 进行事件的拦截
         */
        return true;
    }
}
