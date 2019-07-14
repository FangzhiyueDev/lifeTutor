package com.rcs.nchumanity.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.IdentitySelectActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class JYPXFragment extends ParentFragment {


    @Override
    protected void onViewCreated(View view, Bundle savedInstanceState, boolean isViewCreated) {
        super.onViewCreated(view, savedInstanceState, isViewCreated);

    }


    @Override
    protected int getCreateView() {
        return R.layout.fragment_jhpx;
    }

    @OnClick({R.id.bm1, R.id.bm2, R.id.query1, R.id.query2, R.id.step_1, R.id.step_2, R.id.step_3, R.id.step_4})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.step_1:

                Tool.startActivity(getContext(), IdentitySelectActivity.class);
                break;

            case R.id.step_2:


                break;

            case R.id.step_3:

                break;

            case R.id.step_4:

                break;

            case R.id.bm1:

                break;

            case R.id.bm2:

                break;

            case R.id.query1:

                break;

            case R.id.query2:


                break;
        }
    }


}
