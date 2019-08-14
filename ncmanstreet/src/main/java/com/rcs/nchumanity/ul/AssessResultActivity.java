package com.rcs.nchumanity.ul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.tool.Tool;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

/**
 * 考核结果的界面
 */
public class AssessResultActivity extends ParentActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assess_result);
        ButterKnife.bind(this);

        loadDataGetForForce(NetConnectionUrl.getMyScore,"myCourse");

    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br=new Gson().fromJson(backData[0],BasicResponse.class);

        if(br.code==BasicResponse.RESPONSE_SUCCESS){


        }else if(br.code==BasicResponse.NOT_LOGIN){



        }else {
            Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
        }




    }
}
