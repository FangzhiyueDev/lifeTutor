package com.rcs.nchumanity.ul;

import android.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.ParentActivity;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Response;


/**
 * 处理数据请求的操作
 * <p>
 * 当前的activity的处理过程 与当前的软件逻辑存在耦合，不具有可抽取作为独立公共代码的能力
 */
public class BasicResponseProcessHandleActivity extends ParentActivity {


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);


        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);
        try {
            if (br.code == BasicResponse.RESPONSE_SUCCESS) {
                responseDataSuccess(what, backData[0], response);
            } else if (br.code == BasicResponse.NOT_LOGIN) {
                PersistenceData.clear(this);
                Tool.loginCheck(this);
            } else if (br.code == BasicResponse.LOGIN_SUCCESS) {
                responseDataSuccess(what, backData[0], response);
            } else  if (br.code == BasicResponse.CHANGE_PASSWORD_SUCCESS) {
                    responseDataSuccess(what,backData[0],response);
            } else{
                JSONObject o = new JSONObject(backData[0]);
                String message = o.has("message") ? o.getString("message") : o.getString("msg");
                Toast.makeText(this, "加载失败" + message, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void responseDataSuccess(String what, String backData, Response response) throws Exception {
        Log.d("test", "responseDataSuccess: ");

    }
}
