package com.rcs.nchumanity.ul.detail;

import android.view.View;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;

/**
 * 这个是必修课程的实现，
 * 用于实现的功能是视频的播放，以及播放
 * 以及包括试题的实现
 */
public class ObligatoryCourseInfoComplexDetailActivity extends ComplexDetailActivity<ComplexModelSet.M__speinf_speinfCla_onLiExamQues> {


    @Override
    protected int getViewLayoutId() {
        return R.layout.activity_complex_obligatory;
    }

    @Override
    protected Class<?> getInfoClass() {
        return info.getClass();
    }

    @Override
    protected void bindView(View view, ComplexModelSet.M__speinf_speinfCla_onLiExamQues item) {

    }
}
