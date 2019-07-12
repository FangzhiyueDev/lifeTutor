package com.rcs.nchumanity.ul;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 这个列表是复用功能模块的代码
 * 用来实现的具体的操作从数据库中获取相对应的数据的信息
 * ，本身是一个列表，的展示，对于这个界面，存在两种情况、
 * <p>
 * 1.对于基本的信息展示的话，只需要跳转到
 * #{{@link ComplexListDetailActivity}} 界面进行文本信息的展示
 * 2.另一种情况，需要跳转到 地图的展示界面，传递的数据类似于一个地图点，我们根据地图点，进入
 */
public abstract class ComplexListActivity<T> extends ParentActivity {


    @BindView(R.id.listView)
    ListView listView;

    ListViewCommonsAdapter<T> lvca;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);
        ButterKnife.bind(this);
        listView.setAdapter(lvca = new ListViewCommonsAdapter<T>(getDataList(), getLayout()) {
            @Override
            public void bindView(ViewHolder holder, T obj) {
                bindViewValue(holder, obj);
            }

            @Override
            public int getCount() {
                return getDataList().size();
            }
        });

        listView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            itemClick(parent, view, position, id, lvca.getItem(position));
        });

    }

    /**
     * 用来实现对应的ListView不同的view的数据初始化操作
     *
     * @param holder
     * @param obj
     */
    protected abstract void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, T obj);

    /**
     * @param parent
     * @param view
     * @param position
     * @param id
     * @param item
     */
    protected abstract void itemClick(AdapterView<?> parent, View view, int position, long id, T item);

    /**
     * 获得对应的布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 获得数据信息
     *
     * @return
     */
    public abstract ArrayList<T> getDataList();


}
