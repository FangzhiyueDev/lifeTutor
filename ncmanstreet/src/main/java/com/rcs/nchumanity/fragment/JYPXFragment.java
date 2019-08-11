package com.rcs.nchumanity.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.dialog.DialogCollect;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.IdentityInfoRecordActivity;
import com.rcs.nchumanity.ul.IdentitySelectActivity;
import com.rcs.nchumanity.ul.MainActivity;
import com.rcs.nchumanity.ul.OnlineAssessmentActivity;
import com.rcs.nchumanity.ul.list.CourseComplexListActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Response;

public class JYPXFragment extends ParentFragment {


    @Override
    protected void onViewCreated(View view, Bundle savedInstanceState, boolean isViewCreated) {
        super.onViewCreated(view, savedInstanceState, isViewCreated);

    }


    @Override
    protected int getCreateView() {
        return R.layout.fragment_jhpx;
    }

    @OnClick({R.id.one, R.id.two, R.id.three, R.id.four, R.id.five_signUp,
            R.id.five_signIn, R.id.five_query,
            R.id.six_signUp, R.id.sixSignIn, R.id.sixQuery})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.one:

                //懒加载用户的状态

                String param = NetConnectionUrl.getSignInStatus;

                loadDataGet(param, "getSignInStatus");

//                Tool.startActivity(getContext(), IdentityInfoRecordActivity.class);

                break;

            case R.id.two:
                Bundle bundle = new Bundle();
                if(PersistenceData.DEF_VAL.equals(PersistenceData.getSessionId(getContext()))){
                    bundle.putString(CourseComplexListActivity.NET_URL,NetConnectionUrl.getOnlineClass);
                }else {
                    bundle.putString(CourseComplexListActivity.NET_URL,
                            NetConnectionUrl.getOnlineClassAndRecordByUser);
                }
                bundle.putString(CourseComplexListActivity.FUN,CourseComplexListActivity.FUN_NEED);
                Tool.startActivity(getContext(), CourseComplexListActivity.class,bundle);

                break;

            case R.id.three:

                Bundle bundle1 = new Bundle();
                bundle1.putString(CourseComplexListActivity.FUN,CourseComplexListActivity.FUN_SELECT);
                if(PersistenceData.DEF_VAL.equals(PersistenceData.getSessionId(getContext()))){
                    bundle1.putString(CourseComplexListActivity.NET_URL,NetConnectionUrl.getNotRequiredOnlineClass);
                }else {
                    bundle1.putString(CourseComplexListActivity.NET_URL,
                            NetConnectionUrl.getNotRequiredOnlineClassAndRecordByUser);
                }
                Tool.startActivity(getContext(),CourseComplexListActivity.class,bundle1);

                break;

            case R.id.four:

                Tool.startActivity(getContext(), OnlineAssessmentActivity.class);

                break;

            case R.id.five_signUp:

                break;

            case R.id.five_signIn:

                break;

            case R.id.five_query:

                break;

            case R.id.six_signUp:


                break;

            case R.id.sixSignIn:


                break;

            case R.id.sixQuery:


                break;
        }
    }


    @Override
    public void onSucess(Response response, String what, String... backData) throws IOException {
        super.onSucess(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);
        try {

            if (br.code == BasicResponse.NOT_LOGIN) {
                Tool.loginCheck(getContext());

            } else if (br.code == BasicResponse.RESPONSE_SUCCESS) {

                JSONObject jsonObject = new JSONObject(backData[0]);

                JSONObject data = null;

                if (jsonObject.has("object")) {
                    data = jsonObject.getJSONObject("object");
                } else if (jsonObject.has("data")) {
                    data = jsonObject.getJSONObject("data");
                }

                int studyStatus = data.getInt("studyStatus");

                if (studyStatus == 1 || studyStatus == 8) {
                    //进入报名
                    Tool.startActivity(getContext(), IdentityInfoRecordActivity.class);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                            .setTitle("温馨提示")
                            .setMessage("你已报名")
                            .setPositiveButton("确定", (dialog, which) -> {
                                dialog.dismiss();
                            });
                    builder.create().show();
                }
            } else {
                Toast.makeText(getContext(), "系统出错" + br.message, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
