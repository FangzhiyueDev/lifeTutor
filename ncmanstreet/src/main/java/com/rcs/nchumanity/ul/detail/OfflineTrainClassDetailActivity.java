package com.rcs.nchumanity.ul.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.ul.ParentActivity;

import java.io.IOException;

import okhttp3.Response;

public class OfflineTrainClassDetailActivity extends ParentActivity {


    public static final String CLASS_ID = "classId";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_offline_class_detail);


        String classId = getIntent().getExtras().getString(CLASS_ID);

        String param = String.format(NetConnectionUrl.getOfflineTrainClassDetail, classId);

        loadDataGetForForce(param, "load");

    }

    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);
        if (what.equals("load")) {
            if (br.code == BasicResponse.RESPONSE_SUCCESS) {
                //
                try {




                } catch (Exception e) {

                }
            }
        }
    }
}
