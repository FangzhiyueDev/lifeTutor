package com.rcs.nchumanity.ul;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.tool.Tool;

import java.io.IOException;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;


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

                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("退出登录")
                        .setMessage("确认退出登录吗?")
                        .setNegativeButton("取消", ((dialog, which) -> {

                            dialog.dismiss();

                        })).setPositiveButton("确定", (dialog, which) -> {
                            PersistenceData.clear(this);
                            dialog.dismiss();
                            Tool.startActivity(this, MainActivity.class);
                        });

                builder.create().show();

                break;
            case R.id.softwareUpdate:

                AlertDialog.Builder builder1 = new AlertDialog.Builder(this)
                        .setTitle("更新提醒")
                        .setMessage("确定检验更新吗?")
                        .setNegativeButton("取消", ((dialog, which) -> {

                            dialog.dismiss();

                        })).setPositiveButton("确定", (dialog, which) -> {

                            /**
                             * 使用网络加载数据
                             */


                        });

                builder1.create().show();


                break;

            case R.id.aboutWe:

                Tool.startActivity(this, AboutWeActivity.class);

                break;

            case R.id.cancelSignup:

                AlertDialog.Builder builder2 = new AlertDialog.Builder(this)
                        .setTitle("取消报名")
                        .setMessage("确定取消报名吗，将会清除你的报名信息")
                        .setNegativeButton("取消", ((dialog, which) -> {
                            dialog.dismiss();

                        })).setPositiveButton("确定", (dialog, which) -> {

                            dialog.dismiss();
                            /**
                             * 使用网络加载数据
                             */
                            loadDataPost(NetConnectionUrl.cancelSignUp, "cancelSignUp", new HashMap<>());

                        });
                builder2.create().show();

                break;

            case R.id.helpCenter:

                Tool.startActivity(this, HelpCenterActivity.class);

                break;

            case R.id.feedback:

                loadDataGet(NetConnectionUrl.getFeedback, "getFeedback");

                break;

            case R.id.changePhone:
                Tool.startActivity(this, ChangePhoneNumberActivity.class);

                break;

            case R.id.changePassword:

                Tool.startActivity(this, ChangePasswordActivity.class);

                break;
        }
    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (br.code == BasicResponse.RESPONSE_SUCCESS) {

            if (what.equals("cancelSignUp")) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("取消报名成功")
                        .setPositiveButton("确定", (dialog, which) -> {
                            dialog.dismiss();
                        });
                builder.create().show();

            } else if (what.equals("getFeedback")) {

                Bundle bundle = new Bundle();
                bundle.putSerializable(FeedbackActivity.DATA,"");

                Tool.startActivity(this, FeedbackActivity.class);
            }


        } else if (br.code == BasicResponse.NOT_LOGIN) {
            Tool.loginCheck(this);
        } else {
            Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
        }
    }
}
