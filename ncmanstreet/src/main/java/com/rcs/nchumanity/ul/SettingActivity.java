package com.rcs.nchumanity.ul;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.dialog.DialogCollect;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.entity.model.FeedbackRecord;
import com.rcs.nchumanity.tool.DateProce;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.list.SpecificInfoComplexListActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
            R.id.feedback, R.id.changePassword})
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
//                            backStackLower();
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
                            dialog.dismiss();

                            final Dialog dialog1 = DialogCollect.openLoadDialog(this);
                            dialog1.setCancelable(false);
                            dialog1.show();
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dialog1.dismiss();
                                    new AlertDialog.Builder(SettingActivity.this)
                                            .setTitle("提示")
                                            .setMessage("暂无更新?")
                                            .setPositiveButton("确定", (dialog, which) -> {
                                                dialog.dismiss();
                                            }).create().show();
                                }
                            }, 2000);
                        });
                builder1.create().show();

                break;

            case R.id.aboutWe:

                Bundle bundle3 = new Bundle();
                bundle3.putString(SpecificInfoComplexListActivity.CLASS_NAME, "帮助中心");
                bundle3.putString(SpecificInfoComplexListActivity.URL, NetConnectionUrl.getAboutUs);
                Tool.startActivity(this, SpecificInfoComplexListActivity.class, bundle3);

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

                Bundle bundle = new Bundle();
                bundle.putString(SpecificInfoComplexListActivity.CLASS_NAME, "帮助中心");
                bundle.putString(SpecificInfoComplexListActivity.URL, NetConnectionUrl.getHelpInfo);
                Tool.startActivity(this, SpecificInfoComplexListActivity.class, bundle);

                break;

            case R.id.feedback:

                loadDataPost(NetConnectionUrl.getFeedback, "getFeedback", new HashMap<>());

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

                try {
                    JSONObject brJ = new JSONObject(backData[0]);
                    JSONArray objS = brJ.getJSONArray("object");

                    ArrayList<FeedbackRecord> feedbackRecords = new ArrayList<>();

                    for (int i = 0; i < objS.length(); i++) {
                        JSONObject obj = objS.getJSONObject(i);
                        String createTime = obj.getString("createTime");
                        String message = obj.getString("message");
                        String replay = obj.getString("reply");

                        FeedbackRecord feedbackRecord = new FeedbackRecord();
                        feedbackRecord.setCreateTime(DateProce.parseDate(createTime));
                        feedbackRecord.setMessage(message);
                        feedbackRecord.setReply(replay);
                        feedbackRecords.add(feedbackRecord);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(FeedbackActivity.DATA, feedbackRecords);
                    Tool.startActivity(this, FeedbackActivity.class, bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } else if (br.code == BasicResponse.NOT_LOGIN) {
            PersistenceData.clear(this);
            Tool.loginCheck(this);
        } else if (br.code == BasicResponse.NOT_CANCEL) {
            try {
                JSONObject brJ = new JSONObject(backData[0]);

                String message = brJ.has("message") ? brJ.getString("message") : brJ.getString("msg");

                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage(message)
                        .setPositiveButton("确定", (dialog, which) -> {
                            dialog.dismiss();
                        });
                builder.create().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(br.code==BasicResponse.CANCEL_FAIL) {

            if(what.equals("cancelSignUp")){

                try {
                    JSONObject brJ = new JSONObject(backData[0]);
                    String message = brJ.has("message") ? brJ.getString("message") : brJ.getString("msg");

                     new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage(message)
                            .setPositiveButton("确定", (dialog, which) -> {
                                dialog.dismiss();
                            }).create().show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }else {
            Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
        }
    }
}
