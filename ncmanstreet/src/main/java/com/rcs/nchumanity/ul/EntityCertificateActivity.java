package com.rcs.nchumanity.ul;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.tool.Tool;

import org.json.JSONObject;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

/**
 * 实体证书
 */
public class EntityCertificateActivity extends ParentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity_certificate);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ziqu, R.id.youji})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ziqu:
                Intent intent = new Intent(this, SelfTakeActivity.class);
                startActivity(intent);
                break;
            case R.id.youji:

                /**
                 * 确定用户考核状态，必须是已完成线下考核
                 */

                loadDataGetForForce(NetConnectionUrl.getStatusByUser, "getStatusByUser");


                break;
        }
    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (br.code == BasicResponse.RESPONSE_SUCCESS) {

            if (what.equals("getStatusByUser")) {
                try {
                    JSONObject brJ = new JSONObject(backData[0]);
                    JSONObject obj = brJ.getJSONObject("object");
                    int studyStatus = obj.getInt("studyStatus");

                    if (studyStatus == 7) {

                        loadDataGetForForce(NetConnectionUrl.getPostInfoByUser, "getPostInfoByUser");

                    } else {
                        new AlertDialog.Builder(this)
                                .setTitle("提示")
                                .setMessage("暂未达到要求，请完成相关培训后重试")
                                .setPositiveButton("确定", (dialog, which) -> {

                                }).create().show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (what.equals("getPostInfoByUser")) {

                try {
                    JSONObject brJ = new JSONObject(backData[0]);
                    JSONObject obj = brJ.getJSONObject("object");

                    String name = obj.getString("name");
                    String mobilePhone = obj.getString("mobilephone");
                    String address = obj.getString("address");


                    Bundle bundle = new Bundle();
                    bundle.putString(MailPostActivity.NAME,name);
                    bundle.putString(MailPostActivity.MOBILE_PHONE,mobilePhone);
                    bundle.putString(MailPostActivity.ADDRESS,address);

                  Tool.startActivity(this,MailPostActivity.class,bundle);

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        } else if (br.code == BasicResponse.NOT_LOGIN) {
            PersistenceData.clear(this);
            Tool.loginCheck(this);
        }


    }
}
