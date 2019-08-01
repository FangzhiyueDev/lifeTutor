package com.rcs.nchumanity.ul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 考核结果的界面
 */
public class AssessResultActivity extends ParentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assess_result);
        ButterKnife.bind(this);
    }


}
