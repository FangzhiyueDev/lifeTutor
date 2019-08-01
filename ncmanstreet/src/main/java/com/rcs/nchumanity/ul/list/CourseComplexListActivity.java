package com.rcs.nchumanity.ul.list;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.entity.model.UserOnlineStudyRecord;
import com.rcs.nchumanity.ul.list.ComplexListActivity;

/**
 * 课程列表的实现的Activity
 */
public class CourseComplexListActivity extends ComplexListActivity<ComplexModelSet.M_couClas_usOnStuRec> {


    public String url;

    public static final String NET_URL = "url";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        url = getIntent().getStringExtra(NET_URL);

        if (TextUtils.isEmpty(url)) {
            throw new RuntimeException("please transport load data url pass Intent().putStringExtra(NET_URL) method!!!");
        }
        /**
         * 加载课程数据
         */
        loadData(url, "courseList", "GET", null);
    }

    @Override
    protected void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, ComplexModelSet.M_couClas_usOnStuRec obj) {

        holder.setText(R.id.title, obj.classification.getCourseName());
        if (obj.records == null || obj.records.size() == 0) {
            //没有观看记录，没有看过
            holder.setVisibility(R.id.notComplete, View.VISIBLE);
            return;
        }

        /**
         * 循环遍历观看记录，如果观看的时长超过 5*60秒 就代表看过了
         */
        boolean isCom = false;
        for (UserOnlineStudyRecord record : obj.records) {
            if (record.getTotalTime() >= 5 * 60) {
                isCom = true;
            }
        }
        holder = isCom ? holder.setVisibility(R.id.complete, View.VISIBLE) : holder.setVisibility(R.id.notComplete, View.VISIBLE);

    }

    @Override
    protected void itemClick(AdapterView<?> parent, View view, int position, long id, ComplexModelSet.M_couClas_usOnStuRec item) {
        /**
         * 进入详情界面
         */

    }

    @Override
    protected int getLayout() {
        return R.layout.item_course_list;
    }


}
