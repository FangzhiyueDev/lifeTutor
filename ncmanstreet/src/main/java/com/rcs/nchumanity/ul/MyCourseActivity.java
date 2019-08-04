package com.rcs.nchumanity.ul;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.ul.list.ComplexListActivity;

/**
 * 我的课程界面的实现
 */
public class MyCourseActivity extends ComplexListActivity<ComplexModelSet.M_offliTraClas_M_traPoi_areaInf> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 在这里加载数据，然后将数据通过setDataList设置进去
         */
    }

    @Override
    protected void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, ComplexModelSet.M_offliTraClas_M_traPoi_areaInf obj) {
        holder.setOnClickListener(R.id.cancel, (v) -> {

        });

        holder.setOnClickListener(R.id.reSelect, (v) -> {

        });

    }

    @Override
    protected void itemClick(AdapterView<?> parent, View view, int position, long id, ComplexModelSet.M_offliTraClas_M_traPoi_areaInf item) {

    }

    @Override
    protected int getLayout() {
        return R.layout.item_me_course;
    }


}
