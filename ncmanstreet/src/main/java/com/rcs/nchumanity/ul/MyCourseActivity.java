package com.rcs.nchumanity.ul;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.tool.DateProce;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.list.ComplexListActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

/**
 * 我的课程界面的实现
 */
public class MyCourseActivity extends ComplexListActivity<ComplexModelSet.ClassDetail> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 在这里加载数据，然后将数据通过setDataList设置进去
         */

        loadDataGetForForce(NetConnectionUrl.myCourse, "myCourse");
    }

    @Override
    protected void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, ComplexModelSet.ClassDetail obj) {

        holder.setText(R.id.trainOrg, obj.org);
        holder.setText(R.id.currentCount, obj.currentNum + "人");
        holder.setText(R.id.trainPosition, obj.position);
        holder.setText(R.id.dateTime, DateProce.formatDate(obj.startTime));
        View view = holder.getItemView().findViewById(R.id.cancel);
        view.setTag(obj);
        view.setOnClickListener((v) -> {

            ComplexModelSet.ClassDetail classDetail = (ComplexModelSet.ClassDetail) v.getTag();

            int id = classDetail.classId;

            String url = String.format(NetConnectionUrl.cancelChooseClass, id);

            loadDataGet(url, "cancelChooseClass");
        });

        View reSelect = holder.getItemView().findViewById(R.id.reSelect);
        reSelect.setTag(obj);
        reSelect.setOnClickListener((v) -> {
            
        });

    }

    @Override
    protected void itemClick(AdapterView<?> parent, View view, int position, long id, ComplexModelSet.ClassDetail item) {

    }

    @Override
    protected int getLayout() {
        return R.layout.item_me_course;
    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {
        super.onSucessful(response, what, backData);

        BasicResponse basicResponse = new Gson().fromJson(backData[0], BasicResponse.class);
        if (basicResponse.code == BasicResponse.RESPONSE_SUCCESS) {

            try {
                if (basicResponse != null) {

                    if (what.equals("myCourse")) {
                        List<ComplexModelSet.ClassDetail> classDetails = new ArrayList<>();

                        JSONObject brJ = new JSONObject(backData[0]);
                        JSONArray objects = brJ.getJSONArray("object");
                        for (int i = 0; i < objects.length(); i++) {
                            JSONObject obj = objects.getJSONObject(i);

                            int id = obj.getInt("id");
                            String startTime = obj.getString("startTime");
                            String position = obj.getString("position");
                            int currentNum = obj.getInt("currentNum");
                            String org = obj.getString("org");
                            String trainer = obj.getString("trainer");

                            ComplexModelSet.ClassDetail classDetail =
                                    new ComplexModelSet.ClassDetail();

                            classDetail.classId = id;
                            classDetail.startTime = DateProce.parseDate(startTime);
                            classDetail.position = position;
                            classDetail.currentNum = currentNum;
                            classDetail.org = org;
                            classDetail.trainer = trainer;
                            classDetails.add(classDetail);

                            setDataList(classDetails);
                        }
                    } else if (what.equals("cancelChooseClass")) {
                        new AlertDialog.Builder(this).setTitle("提示")
                                .setMessage("已取消选课，七天内无法再选课")
                                .setPositiveButton("确定", (dialog, which) -> {
                                    dialog.dismiss();
                                    finish();
                                }).setCancelable(false).create().show();
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (basicResponse.code == BasicResponse.NOT_LOGIN) {

            Tool.loginCheck(this);

        } else {
            Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
        }


    }
}
