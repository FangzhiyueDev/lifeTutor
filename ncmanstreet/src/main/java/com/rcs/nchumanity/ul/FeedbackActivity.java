package com.rcs.nchumanity.ul;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.model.FeedbackRecord;
import com.rcs.nchumanity.tool.Tool;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

public class FeedbackActivity extends ParentActivity {


    public static final String DATA = "data";

    private ArrayList<FeedbackRecord> feedbackRecords;


    @BindView(R.id.content)
    EditText content;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);
        ButterKnife.bind(this);

        feedbackRecords = (ArrayList<FeedbackRecord>) getIntent().getExtras().getSerializable(DATA);

        if (feedbackRecords == null) {

        }


    }


    @OnClick(R.id.submit)
    public void onClick(View view) {
        loadDataPost(NetConnectionUrl.commitFeedback, "commitFeedback", new HashMap<>());
    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (br.code == BasicResponse.RESPONSE_SUCCESS) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("取消报名成功")
                    .setPositiveButton("确定", (dialog, which) -> {
                        dialog.dismiss();
                    });
            builder.create().show();


        } else {
            Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
        }


    }
}
