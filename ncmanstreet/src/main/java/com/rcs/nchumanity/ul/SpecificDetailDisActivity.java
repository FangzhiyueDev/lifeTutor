package com.rcs.nchumanity.ul;


import android.os.Bundle;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.model.SpecificInfo;

/**
 * 用于显示特定信息的数据的接口
 */
public class SpecificDetailDisActivity extends ParentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_detail);
        bundleData();

    }

    private void bundleData() {

        SpecificInfo specificInfo = (SpecificInfo) getIntent().getBundleExtra(Bundle.class.getSimpleName()).getSerializable(SpecificInfo.class.getSimpleName());

        if (specificInfo == null) {
            throw new RuntimeException("bundle的数据为空");
        }
    }


}
