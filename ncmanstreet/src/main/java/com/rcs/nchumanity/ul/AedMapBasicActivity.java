package com.rcs.nchumanity.ul;

import android.view.View;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.model.AedDistributionInfo;

public class AedMapBasicActivity extends MapBasicActivity<AedDistributionInfo> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_aed_map;
    }

    @Override
    protected void bindView(View view, AedDistributionInfo aedDistributionInfo) {
        
    }
}
