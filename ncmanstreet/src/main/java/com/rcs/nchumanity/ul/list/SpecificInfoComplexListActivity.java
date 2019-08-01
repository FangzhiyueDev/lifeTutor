package com.rcs.nchumanity.ul.list;

import android.view.View;
import android.widget.AdapterView;

import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;
import com.rcs.nchumanity.entity.model.SpecificInfo;
import com.rcs.nchumanity.ul.list.ComplexListActivity;

/**
 *
 * 特定信息的复合列表的接口实现Activity
 *
 *
 */
public class SpecificInfoComplexListActivity extends ComplexListActivity<SpecificInfo> {



    @Override
    protected void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, SpecificInfo obj) {

    }

    @Override
    protected void itemClick(AdapterView<?> parent, View view, int position, long id, SpecificInfo item) {

    }

    @Override
    protected int getLayout() {
        return 0;
    }
}
