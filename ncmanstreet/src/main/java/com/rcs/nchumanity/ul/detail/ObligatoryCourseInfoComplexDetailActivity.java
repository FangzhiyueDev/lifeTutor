package com.rcs.nchumanity.ul.detail;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.entity.model.UserTrainRecord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import okhttp3.Response;

/**
 * 这个是必修课程的实现，
 * 用于实现的功能是视频的播放，以及播放
 * 以及包括试题的实现
 */
public class ObligatoryCourseInfoComplexDetailActivity extends ComplexDetailActivity<ComplexModelSet.M__speinf_speinfCla_onLiExamQues> {


    public static final String COURSE_NO = "courseNo";

    public static final String Division = "&nbsp;";

    public static final int OPTION_SIZE = 4;


    @Override
    protected int getViewLayoutId() {

        return R.layout.activity_complex_obligatory;
    }

    @Override
    protected void bindView(View view, ComplexModelSet.M__speinf_speinfCla_onLiExamQues item) {

        if (error) {
            view.setVisibility(View.VISIBLE);
        } else {

            ListView listView = view.findViewById(R.id.subjectList);


            final List<ComplexModelSet.Question> questions = item.questionList;

            ListViewCommonsAdapter<ComplexModelSet.Question> adapter = new ListViewCommonsAdapter<ComplexModelSet.Question>(
                    (ArrayList<ComplexModelSet.Question>) questions, R.layout.item_question_answer) {
                @Override
                public void bindView(ViewHolder holder, ComplexModelSet.Question obj) {

                    holder.setText(R.id.number, (1 + holder.getItemPosition()) + "、");

                    holder.setText(R.id.question, obj.question + "( )");

                    String[] options = obj.options.split(Division);

                    int optionSize = options.length;

                    String[] optionsBackup = null;
                    optionsBackup = Arrays.copyOf(options, OPTION_SIZE);

                    for (int i = optionSize; i < OPTION_SIZE; i++) {
                        optionsBackup[i] = "暂无选项";
                    }
                    holder.setText(R.id.a, "A、" + optionsBackup[0]);
                    holder.setText(R.id.b, "B、" + optionsBackup[1]);
                    holder.setText(R.id.c, "C、" + optionsBackup[2]);
                    holder.setText(R.id.d, "D、" + optionsBackup[3]);

                    holder.setOnClickListener(R.id.btnQuery, (v) -> {
                        if (totalTime < 5 * 60) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(ObligatoryCourseInfoComplexDetailActivity.this)
                                    .setTitle("提示")
                                    .setMessage("观看到5分钟后才能查看答案")
                                    .setPositiveButton("确定",((dialog, which) -> {
                                            dialog.dismiss();
                                    }));
                            builder.create().show();
                        }else {

                            AlertDialog.Builder builder = new AlertDialog.Builder(ObligatoryCourseInfoComplexDetailActivity.this)
                                    .setTitle("答案")
                                    .setMessage("正确答案: "+obj.answer)
                                    .setPositiveButton("确定",((dialog, which) -> {
                                        dialog.dismiss();
                                    }));
                            builder.create().show();
                        }
                    });

                }

                @Override
                public int getCount() {
                    return questions.size();
                }
            };

            listView.setAdapter(adapter);

            if (!TextUtils.isEmpty(item.videoUrl)) {
                videoPlayFragment.setVisiblity(View.VISIBLE);
                videoPlayFragment.setUrl(item.videoUrl);

                videoPlayFragment.setPlayListener((playing) -> {
                    if (playing && isStartTime == false) {
                        isStartTime = true;
                        thread.start();
                    }
                    this.playingS = playing;
                });
            }
        }
    }


    /**
     * 开始播放，进行及时
     */
    public boolean isStartTime = false;

    /**
     * 播放中 。。。
     */
    public boolean playingS = false;


    private boolean error = false;

    public int totalTime = 0;

    private Thread thread;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        thread = new Thread(() -> {
            while (isStartTime) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (playingS) {
                    totalTime++;
                }
                Log.d("test", "当前观看时长" + totalTime);
            }
        });


        findViewById(R.id.backupPage).setOnClickListener((v) -> {
            onBackPressed();
        });

        String courseNo = getIntent().getExtras().getString(COURSE_NO);

        if (courseNo == null) {
            throw new InvalidParameterException("invalid paramter is COURSE_NO");
        }

        String param = String.format(NetConnectionUrl.getOnlineCourseContentForId, courseNo);
        Log.d("test", "url: " + param);
        loadDataGet(param, "courseDetail");

    }

    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        //对info进行设置数据之后
        //调用 bunddata


        switch (what) {

            case "courseDetail": {

                if (br.code == BasicResponse.RESPONSE_SUCCESS) {


                    try {
                        JSONObject br1 = new JSONObject(backData[0]);

                        JSONObject courseDetail = null;
                        if (br1.getJSONObject("object") != null) {
                            courseDetail = br1.getJSONObject("object");

                            int courseNo = courseDetail.getInt("courseNo");

                            String title = courseDetail.getString("title");

                            String videoUrl=null;
//                          videoUrl  = courseDetail.getString("videoUrl");
                            videoUrl="http://172.27.35.12:8080/GF/video.mp4";

                            String imgUrl = courseDetail.getString("imgUrl");

                            String writing = courseDetail.getString("writing");

                            String remark = courseDetail.getString("remark");

                            JSONArray questionList = courseDetail.getJSONArray("questionList");

                            List<ComplexModelSet.Question> questions = new ArrayList<>();

                            for (int i = 0; i < questionList.length(); i++) {
                                JSONObject questionO = questionList.getJSONObject(i);
                                String question = questionO.getString("question");
                                String options = questionO.getString("options");
                                String answer = questionO.getString("answer");
                                questions.add(new ComplexModelSet.Question(question, options, answer));
                            }
                            info = new ComplexModelSet.M__speinf_speinfCla_onLiExamQues(courseNo, title, videoUrl, imgUrl, writing, remark, questions);
                            bundleData();
                        } else {

                            error = true;
                            Toast.makeText(this, "数据异常", Toast.LENGTH_SHORT).show();

                        }
                        //消息通知
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            break;

            case "postWatchData": {


            }

        }

    }


    @Override
    protected void onDestroy() {

        /**
         * 代表的是超过5分钟
         */
        if (totalTime > 5 * 60) {
            Map<String, String> param = new HashMap<>();
            param.put("courseNo", info.courseNo + "");
            param.put("startTime", System.currentTimeMillis() + "");
            param.put("totalTime", totalTime + "");
            loadDataPost(NetConnectionUrl.submitWatchData, "postWatchData", param);
        }
        if(thread!=null){
            isStartTime=false;
            thread.interrupt();
        }
        super.onDestroy();
    }


    @Override
    public void onBackPressed() {
        if(PersistenceData.getSessionId(this).equals(PersistenceData.DEF_VAL)){

            //未登录
            super.onBackPressed();

        }else {
            if (totalTime < 5 * 60) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提醒");
                builder.setMessage("你当前观看时长低于5分钟，系统将不会记录本次的观看记录，是否继续退出?")
                        .setNegativeButton("退出", (dialog, v) -> {
                            dialog.dismiss();
                            super.onBackPressed();
                        }).setPositiveButton("继续学习", ((dialog, which) -> {
                    dialog.dismiss();
                }));
                builder.create().show();
            } else {
                super.onBackPressed();
            }
        }
    }




}
