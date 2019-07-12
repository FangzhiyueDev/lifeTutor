package com.rcs.nchumanity.fragment;

import android.view.View;
import android.widget.ImageView;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.ComplexListActivity;
import com.rcs.nchumanity.ul.MyCurseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的的界面的显示
 */
public class MeFragment extends ParentFragment {


    @BindView(R.id.photo)
    ImageView photo;//用户头像


    @Override
    protected int getCreateView() {
        return R.layout.fragment_me;
    }


    @OnClick({R.id.curse, R.id.photo, R.id.assessResult, R.id.elecMark, R.id.realMark})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.curse:
                Tool.startActivity(getContext(), MyCurseActivity.class);
                break;

            case R.id.photo:

                break;

            case R.id.assessResult:

                break;

            case R.id.elecMark:

                break;

            case R.id.realMark:

                break;


        }


    }


}
