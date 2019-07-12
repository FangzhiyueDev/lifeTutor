package com.rcs.nchumanity.ul;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.rcs.nchumanity.R;

import com.rcs.nchumanity.dialog.DialogTool;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.net.NetRequest;
import com.rcs.nchumanity.tool.*;

import org.json.JSONObject;

import com.rcs.nchumanity.service.thirdParty.*;
import com.rcs.nchumanity.view.CommandBar;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.SMSSDK;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RegisterUserActivity extends ParentActivity {


    @BindView(R.id.phoneNumber)
    EditText phoneNumber;

    @BindView(R.id.registerSubmit)
    Button registerSubmit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_register);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.registerSubmit, R.id.privacyClause, R.id.userProtocol})
    public void registerSubmit(View view) {
        switch (view.getId()) {
            case R.id.registerSubmit:
                String userPhone = phoneNumber.getText().toString();
                if (TextUtils.isEmpty(userPhone) || userPhone.length() != 11) {
                    Toast.makeText(this, "请输入合法的手机号码", Toast.LENGTH_SHORT).show();
                    return;
                }
                //发送验证码到该手机上
                ValidateCodeServler.sendValidateCode("86", userPhone);

                //进入验证码填写界面
                Tool.startActivity(this, ValidateCodeActivity.class);

                break;

            case R.id.privacyClause:

                //弹出一个窗口 隐私政策

                break;

            case R.id.userProtocol:

                //弹出一个窗口用户协议

                break;
        }
    }
}