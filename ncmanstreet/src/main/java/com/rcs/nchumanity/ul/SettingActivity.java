package com.rcs.nchumanity.ul;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.rcs.nchumanity.R;
import com.rcs.nchumanity.tool.Tool;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 系統設置的相关的显示
 */
public class SettingActivity extends ParentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.backLogin, R.id.softwareUpdate,
            R.id.aboutWe, R.id.cancelSignup, R.id.helpCenter,
            R.id.feedback, R.id.changePhone, R.id.changePassword})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backLogin:


                break;
            case R.id.softwareUpdate:

                break;

            case R.id.aboutWe:

                Tool.startActivity(this, AboutWeActivity.class);

                break;

            case R.id.cancelSignup:


                break;

            case R.id.helpCenter:

                Tool.startActivity(this, HelpCenterActivity.class);

                break;

            case R.id.feedback:

                Tool.startActivity(this, FeedbackActivity.class);

                break;

            case R.id.changePhone:
                Tool.startActivity(this, ChangePhoneNumberActivity.class);

                break;

            case R.id.changePassword:

                Tool.startActivity(this, ChangePasswordActivity.class);

                break;
        }
    }


}
