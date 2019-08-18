package com.rcs.nchumanity.ul.detail;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.entity.model.OfflineTrainClass;
import com.rcs.nchumanity.tool.DateProce;
import com.rcs.nchumanity.tool.StringTool;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.IdentityInfoRecordActivity;
import com.rcs.nchumanity.ul.ParentActivity;
import com.rcs.nchumanity.view.CommandBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

public class OfflineTrainClassDetailActivity extends ParentActivity {


    public static final String CLASS_ID = "classId";


    @BindViews({R.id.courseImg, R.id.courseImg1})
    List<ImageView> courseImgs;

    /**
     * 培训机构
     */
    @BindView(R.id.pxzx)
    TextView pxzx;

    @BindView(R.id.trainer)
    TextView trainer;

    @BindView(R.id.toolbar)
    CommandBar toolbar;

    @OnClick(R.id.submitSignUp)
    public void onClick(View view) {

        new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("确定报名吗?")
                .setPositiveButton("确定", (dialog, which) -> {

                    loadDataGet(NetConnectionUrl.getSignInStatus, "signUpStatus");
                }).setNegativeButton("取消", (dialog, which) -> {

        }).create().show();

    }


    private String classId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_offline_class_detail);
        ButterKnife.bind(this);

        toolbar.setTitle("课程详情");

        classId = getIntent().getExtras().getString(CLASS_ID);

        String param = String.format(NetConnectionUrl.getOfflineTrainClassDetail, classId);

        loadDataGetForForce(param, "load");

    }

    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (br.code == BasicResponse.RESPONSE_SUCCESS) {
            if (what.equals("load")) {
                //
                try {

                    ComplexModelSet.ClassDetail classDetail = parseClassDetail(backData[0]);

                    String imgs[] = classDetail.imgUrl.split(StringTool.DELIMITER);

                    for (int i = 0; i < Math.min(imgs.length, courseImgs.size()); i++) {
                        String img = imgs[i];
                        if (img != null) {
                            Glide.with(this).load(img).into(courseImgs.get(i));
                        }
                    }

                    if (classDetail.trainer != null) {
                        trainer.setText(classDetail.trainer);
                    }

                    if (classDetail.org != null) {
                        pxzx.setText(classDetail.org);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (what.equals("signUpStatus")) {

                try {

                    JSONObject jsonObject = new JSONObject(backData[0]);

                    JSONObject data = null;

                    if (jsonObject.has("object")) {
                        data = jsonObject.getJSONObject("object");
                    } else if (jsonObject.has("data")) {
                        data = jsonObject.getJSONObject("data");
                    }

                    int studyStatus = data.getInt("studyStatus");

                    if (studyStatus == 4 || studyStatus == 5) {
                        //进入报名

                        Map<String, String> param = new HashMap<>();
                        param.put("classId", classId);
                        loadDataPost(NetConnectionUrl.offlineTrainClassSignUp, "offlineTrainClassSignUp", param);

                    } else if (studyStatus > 5) {
                        new AlertDialog.Builder(this)
                                .setTitle("温馨提示")
                                .setMessage("你已完成线下考核")
                                .setPositiveButton("确定", (dialog, which) -> {
                                    dialog.dismiss();
                                }).create().show();
                    } else if (studyStatus < 4) {
                        new AlertDialog.Builder(this)
                                .setTitle("温馨提示")
                                .setMessage("你暂未达到考试条件，请保证完成线上学习和考核")
                                .setPositiveButton("确定", (dialog, which) -> {
                                    dialog.dismiss();
                                }).create().show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (what.equals("offlineTrainClassSignUp")) {
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("选课成功,请准时去参加课程")
                        .setPositiveButton("确定", (dialog, which) -> {
                            dialog.dismiss();
                            finish();
                        }).create().show();
            }
        } else if (br.code == BasicResponse.REPEAT_SIGN_UP) {
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("请不要重复选课，如果需要重选，请进入我们课程进行操作")
                    .setPositiveButton("确定", (dialog, which) -> {
                        dialog.dismiss();
                        finish();
                    }).create().show();
        } else {

            try {

                JSONObject jsonObject = new JSONObject(backData[0]);
                String message = jsonObject.has("message") ? jsonObject.getString("message") : jsonObject.getString("message");
                new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage(message)
                        .setPositiveButton("确定", (dialog, which) -> {
                            dialog.dismiss();
                        }).create().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private ComplexModelSet.ClassDetail parseClassDetail(String backDatum) throws JSONException {

        JSONObject br = new JSONObject(backDatum);

        JSONObject obj = br.getJSONObject("object");

        int classId = obj.getInt("classId");
        String className = obj.getString("className");
        String startTime = obj.getString("startTime");
        String endTime = obj.getString("endTime");
        String trainer = obj.getString("trainer");
        String intro = obj.getString("intro");
        String org = obj.getString("org");
        String imgUrl = obj.getString("imgUrl");
        String position = obj.getString("position");
        boolean vrClass = obj.getBoolean("vrClass");
        String vrAttr = obj.getString("vrAttr");
        int currentNum = obj.getInt("currentNum");
        int maxNum = obj.getInt("maxNum");

        ComplexModelSet.ClassDetail classDetail = new ComplexModelSet.ClassDetail(
                classId,
                className,
                DateProce.parseDate(startTime),
                DateProce.parseDate(endTime),
                trainer,
                intro,
                imgUrl,
                position,
                vrAttr,
                vrClass,
                currentNum,
                maxNum,
                org
        );
        return classDetail;
    }
}
