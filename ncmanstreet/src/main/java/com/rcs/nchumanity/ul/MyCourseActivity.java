package com.rcs.nchumanity.ul;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.ul.list.ComplexListActivity;

/**
 * 我的课程界面的实现
 */
public class MyCourseActivity extends ParentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_course);
    }


}
