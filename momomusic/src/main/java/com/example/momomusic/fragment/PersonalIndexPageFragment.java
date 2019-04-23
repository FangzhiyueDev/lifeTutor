package com.example.momomusic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.momomusic.R;
import com.example.momomusic.view.Adapter.MyFragmentPageAdapter;
import com.example.momomusic.view.MeasureProgressReleativeLayout;
import com.example.momomusic.view.MyLinearLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class PersonalIndexPageFragment extends ParentFragment implements View.OnTouchListener {


    private static final String TAG = "test";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_index_page, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    @BindView(R.id.head)
    MeasureProgressReleativeLayout rl;

    private List<Fragment> fragments;

    private MyFragmentPageAdapter myPageAdapter;

    private int defaultSelectIndex = 0;


    private int headHeight;

    private String[] tabTitle;

    /**
     * 这个界面的布局存在滑动冲突，所以需要解决滑动冲突的问题
     * <p>
     * scrollView 嵌套TabLayout+viewPager 嵌套ListView
     */

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        rl.setViewInflater(new MyLinearLayout.ViewInflater() {
            @Override
            public void viewInflating(View view) {
                if (view.getId() == R.id.head) {
                    headHeight = view.getMeasuredHeight();
                }
            }

            @Override
            public void viewInflaterComplete() {

            }
        });


        fragments = new ArrayList<>();
        fragments.add(new PersonalZLFragment());
        fragments.add(new PersonalXCFragment());//精选

        tabTitle = getResources().getStringArray(R.array.zhuye);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        /**
         * 记住，这里只能使用getChildFragmentManager()
         */
        myPageAdapter = new MyFragmentPageAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(myPageAdapter);
        viewPager.setCurrentItem(defaultSelectIndex);
        for (int i = 0; i < tabTitle.length; i++) {
            tabLayout.addTab(tabLayout.newTab());
        }


        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabTitle.length; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setText(tabTitle[i]);
        }

        scrollView.setOnTouchListener(this);

        scrollView.setOnScrollChangeListener((NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) -> {
        });

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onError(IOException e, String what) {

    }

    @Override
    public void onSucess(Response response, String what, String... backData) throws IOException {

    }

    @Override
    public Class getClassName() {
        return null;
    }


    private int startY;
    private int moveY;

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        boolean interceped = false;

        switch (event.getAction()) {


            case MotionEvent.ACTION_DOWN:
                interceped = false;
                startY = (int) event.getY();

                break;
            case MotionEvent.ACTION_MOVE:

                moveY = (int) event.getY();


                int scrollY = scrollView.getScrollY();

                if (moveY < startY) {//代表的是上滑动
                    /**
                     * 在这里就是去判断我们在什么时候不去触发自己的滑动，也就是scrollview的滑动 ，返回true，代表的是不去执行scroll.onTouchEvent()方法，也就不能进行滑动
                     */
                    if (scrollY > tabLayout.getTop() - headHeight) {
                        Log.d(TAG, "需要禁止scrollview的滑动");
                        interceped = true;
                    } else {

                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                interceped = false;
                break;
        }

        return false;//事件不在向上进行传递
    }
}
