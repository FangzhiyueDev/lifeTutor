package com.rcs.nchumanity.fragment;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.tool.Tool;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Response;

public abstract class BasicResponseProcessHandleFragment extends ParentFragment {


    @Override
    public void onSucess(Response response, String what, String... backData) throws IOException {
        super.onSucess(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        try {
            JSONObject brJ = new JSONObject(backData[0]);
            String message = brJ.has("msg") ? brJ.getString("msg") : brJ.getString("message");

            if (br.code == BasicResponse.RESPONSE_SUCCESS) {
                responseDataSuccess(what, backData[0], response);
            } else if (br.code == BasicResponse.NOT_LOGIN) {
                   if(message.equals(BasicResponse.MESSAGE_OTHER)) {
                       PersistenceData.clear(getContext());
                       Tool.loginCheck(getContext());
                   }else {
                       br.message = message;
                       responseWithOther401(what,br);
                   }
            }  else if(br.code==BasicResponse.NOT_REQUIRED) {
                br.message = message;
                responseWithNotRequired(what,br);
            }else if(br.code==BasicResponse.NOT_REQUIRED_201) {
                br.message=message;
                responseWithNotRequired(what,br);

            }else if(br.code==BasicResponse.NOT_SIGNIN) {
                br.message=message;
                responseWith207(what,br);

            }else {
                Toast.makeText(getContext(), "" + message, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected  void responseWith207(String what, BasicResponse br){

    }

    protected void responseDataSuccess(String what, String backData, Response response, BasicResponse... br) throws Exception {
        Log.d("test", "responseDataSuccess: ");
    }

    protected void responseWithOther401(String what, BasicResponse br){

    }

    protected void responseWithNotRequired(String what,BasicResponse br){

    }

}
