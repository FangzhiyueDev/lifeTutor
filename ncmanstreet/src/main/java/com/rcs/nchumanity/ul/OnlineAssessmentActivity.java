package com.rcs.nchumanity.ul;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.view.CommandBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Response;

import static com.rcs.nchumanity.ul.detail.ObligatoryCourseInfoComplexDetailActivity.Division;
import static com.rcs.nchumanity.ul.detail.ObligatoryCourseInfoComplexDetailActivity.OPTION_SIZE;

public class OnlineAssessmentActivity extends ParentActivity {


    CommandBar toolbar;

    LinearLayout listRoot;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_assessment);

        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("在线考核");

        listRoot=findViewById(R.id.listRoot);

        findViewById(R.id.submit).setOnClickListener((v)->{

            boolean post = true;
            //提交试卷
            for (int i = 0; i < exams.length(); i++) {

                try {
                    JSONObject exam = exams.getJSONObject(i);
                    if (!exam.has("answer")) {
                        post = false;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (post) {
                //进行提交
                loadDataPostJsonForce(NetConnectionUrl.submitExamSubject,"submitExamSubject",exams.toString());

            } else {
                //没有通过，不能提交
                Toast.makeText(this, "请将试卷填写完整", Toast.LENGTH_SHORT).show();
            }
        });

        loadDataGet(NetConnectionUrl.getExamSubject, "examSubject");

    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (what.equals("examSubject")) {

            if (br.code == BasicResponse.RESPONSE_SUCCESS) {

                try {
                    paramData(backData[0]);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(this, "发生错误" + br.message, Toast.LENGTH_SHORT).show();
            }
        }else if(what.equals("submitExamSubject")){

        }

    }

    /**
     * 测试数据
     */
    private String value = "{\"code\":200,\"message\":null,\"object\":[{\"id\":9,\"question\":\"dsd\",\"options\":\"sss\"},{\"id\":12,\"question\":\"131\",\"options\":\"123\"}]}";


    private JSONArray exams;

    private void paramData(String data) throws JSONException {
        JSONObject brJ = new JSONObject(data);
        exams = brJ.getJSONArray("object");

        for (int i = 0; i < exams.length(); i++) {
            JSONObject exam = exams.getJSONObject(i);
//                        int id = exam.getInt("id");
            String question = exam.getString("question");
            String option = exam.getString("options");

            String[] options = option.split(Division);

            int optionSize = options.length;

            String[] optionsBackup = null;
            optionsBackup = Arrays.copyOf(options, OPTION_SIZE);

            for (int j = optionSize; j < OPTION_SIZE; j++) {
                optionsBackup[j] = "暂无选项";
            }

            View view = LayoutInflater.from(OnlineAssessmentActivity.this).inflate(R.layout.item_exam, null);

            ((TextView) view.findViewById(R.id.number)).setText((i + 1) + "、");
            ((TextView) view.findViewById(R.id.question)).setText(question + "( )");

            RadioButton a = view.findViewById(R.id.a);
            RadioButton b = view.findViewById(R.id.b);
            RadioButton c = view.findViewById(R.id.c);
            RadioButton d = view.findViewById(R.id.d);

            a.setText("A、" + optionsBackup[0]);
            b.setText("B、" + optionsBackup[1]);
            c.setText("C、" + optionsBackup[2]);
            d.setText("D、" + optionsBackup[3]);

            view.setTag(exam);

            RadioGroup groupO = view.findViewById(R.id.options);
            int finalI = i;
            groupO.setOnCheckedChangeListener((group, checkedId) -> {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                try {
                    exams.getJSONObject(finalI).put("answer", radbtn.getText());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });
            listRoot.addView(view);
        }
    }



}
