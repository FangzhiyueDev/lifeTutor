package com.rcs.nchumanity.fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.dialog.DialogCollect;
import com.rcs.nchumanity.dialog.DialogTool;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.entity.model.OfflineTrainClass;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.IdentityInfoRecordActivity;
import com.rcs.nchumanity.ul.IdentitySelectActivity;
import com.rcs.nchumanity.ul.MainActivity;
import com.rcs.nchumanity.ul.OnlineAssessmentActivity;
import com.rcs.nchumanity.ul.list.CourseComplexListActivity;
import com.rcs.nchumanity.ul.list.OfflineTrainClassListActivity;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Response;

public class JYPXFragment extends ParentFragment {


    private static final int REQUEST_CODE_SCAN = 14;
    public int requestPermissionCode_DW = 12;

    public int requestPermissionCode_SCAN = 13;

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
                if (PersistenceData.DEF_VAL.equals(PersistenceData.getSessionId(getContext()))) {
                    bundle.putString(CourseComplexListActivity.NET_URL, NetConnectionUrl.getOnlineClass);
                } else {
                    bundle.putString(CourseComplexListActivity.NET_URL,
                            NetConnectionUrl.getOnlineClassAndRecordByUser);
                }
                bundle.putString(CourseComplexListActivity.FUN, CourseComplexListActivity.FUN_NEED);
                Tool.startActivity(getContext(), CourseComplexListActivity.class, bundle);

                break;

            case R.id.three:

                Bundle bundle1 = new Bundle();
                bundle1.putString(CourseComplexListActivity.FUN, CourseComplexListActivity.FUN_SELECT);
                if (PersistenceData.DEF_VAL.equals(PersistenceData.getSessionId(getContext()))) {
                    bundle1.putString(CourseComplexListActivity.NET_URL, NetConnectionUrl.getNotRequiredOnlineClass);
                } else {
                    bundle1.putString(CourseComplexListActivity.NET_URL,
                            NetConnectionUrl.getNotRequiredOnlineClassAndRecordByUser);
                }
                Tool.startActivity(getContext(), CourseComplexListActivity.class, bundle1);

                break;

            case R.id.four:

                Tool.startActivity(getContext(), OnlineAssessmentActivity.class);

                break;

            case R.id.five_signUp:

                Bundle bundle2 = new Bundle();
                bundle2.putString(OfflineTrainClassListActivity.URL, NetConnectionUrl.getCPRClassList);
                Tool.startActivity(getContext(), OfflineTrainClassListActivity.class, bundle2);

                break;

            case R.id.five_signIn:

                signInOprate(NetConnectionUrl.signInCPRClass);

                break;

            case R.id.five_query:

                queryScoreCPR();

                break;

            case R.id.six_signUp:

                Bundle bundle3 = new Bundle();
                bundle3.putString(OfflineTrainClassListActivity.URL, NetConnectionUrl.getTraumaClassList);
                Tool.startActivity(getContext(), OfflineTrainClassListActivity.class, bundle3);

                break;

            case R.id.sixSignIn:

                signInOprate(NetConnectionUrl.signInTraumaClass);

                break;

            case R.id.sixQuery:

                queryScoreTrauma();

                break;
        }
    }

    /**
     * 查询CPR的分数
     */
    private void queryScoreCPR() {

        DialogTool<String> dialogTool = new DialogTool<String>() {
            @Override
            public void bindView(DialogTool<String> d, Dialog dialog, String... t) {
                EditText input = d.getView().findViewById(R.id.input);
                d.setClickListener(R.id.cancel, (v) -> {
                    dialog.dismiss();
                });
                d.setClickListener(R.id.yes, (v) -> {
                    dialog.dismiss();

                    if (input.length() < 4) {
                        Toast.makeText(getContext(), "请输入4位合法查询码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String param = String.format(NetConnectionUrl.queryXFScore, input.getText());
                    loadDataGet(param, "queryXFScore");
                });

            }
        };

        Dialog dialog = dialogTool.getDialog(getContext(), R.layout.dialog_input);
        dialog.show();

    }

    /**
     * 查询创伤救护的分数
     */
    private void queryScoreTrauma() {

        //调用 扫描二维码将解析数据回传

        String[] permission = {
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        requestPermission(permission, requestPermissionCode_SCAN);


    }


    private String courseSignInUrl;

    private void signInOprate(String url) {

        this.courseSignInUrl = url;
        /**
         * 开启定位授权
         * 调用百度定位api
         *
         *
         */

        String[] permission = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        requestPermission(permission, requestPermissionCode_DW);

    }


    @Override
    public void onSucess(Response response, String what, String... backData) throws IOException {
        super.onSucess(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (what.equals("getSignInStatus")) {
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
        } else if (what.equals("courseSignInUrl")) {

            try {

                if (br.code == BasicResponse.RESPONSE_SUCCESS) {
                    JSONObject jsonObject = new JSONObject(backData[0]);

                    /**
                     *
                     * 在这里进行判断是否签到成功了
                     *
                     */


                } else {
                    Toast.makeText(getContext(), "系统出错" + br.message, Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (what.equals("queryXFScore")) {

            try {

                if (br.code == BasicResponse.RESPONSE_SUCCESS) {
                    JSONObject jsonObject = new JSONObject(backData[0]);

                    /**
                     *
                     * 在这里获得查询分数的结果
                     *
                     */

                } else {
                    Toast.makeText(getContext(), "系统出错" + br.message, Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (what.equals("queryScoreTrauma")) {

            try {

                if (br.code == BasicResponse.RESPONSE_SUCCESS) {
                    JSONObject jsonObject = new JSONObject(backData[0]);

                    /**
                     *
                     * 在这里获得查询分数的结果
                     *
                     */

                } else {
                    Toast.makeText(getContext(), "系统出错" + br.message, Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private LocationClient locationClient;

    @Override
    public void permissionSuccess(int requestCode) {
        super.permissionSuccess(requestCode);
        if (requestCode == requestPermissionCode_DW) {
            locationClient = new LocationClient(getContext());
            locationClient.registerLocationListener(new BDAbstractLocationListener() {
                @Override
                public void onReceiveLocation(BDLocation bdLocation) {
                    String latitute = bdLocation.getLatitude() + "";
                    String longitute = bdLocation.getLongitude() + "";

                    Map<String, String> param = new HashMap<>();
                    param.put("latitute", latitute);
                    param.put("longitute", longitute);
                    param.put("name", "线下培训签到");
                    loadDataPostForce(courseSignInUrl, "courseSignInUrl", param);
                }
            });
            locationClient.start();
        } else if (requestCode == requestPermissionCode_SCAN) {

            Intent intent = new Intent(getContext(), CaptureActivity.class);
            startActivityForResult(intent, REQUEST_CODE_SCAN);

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == getActivity().RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);

                String param = String.format(NetConnectionUrl.queryCSJHScore, content, "心肺复苏");
                loadDataGet(param, "queryXFScore");
            }
        }
    }

    @Override
    public void onDestroy() {
        if (locationClient != null) {
            locationClient.stop();
        }
        super.onDestroy();
    }


}
