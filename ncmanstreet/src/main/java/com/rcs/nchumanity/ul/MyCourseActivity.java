package com.rcs.nchumanity.ul;

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
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.list.ComplexListActivity;

import java.io.IOException;

import okhttp3.Response;

/**
 * 我的课程界面的实现
 */
public class MyCourseActivity extends ComplexListActivity<ComplexModelSet.M_offliTraClas_M_traPoi_areaInf> {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 在这里加载数据，然后将数据通过setDataList设置进去
         */

        loadDataGetForForce(NetConnectionUrl.myCourse, "myCourse");
    }

    @Override
    protected void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, ComplexModelSet.M_offliTraClas_M_traPoi_areaInf obj) {
        holder.setOnClickListener(R.id.cancel, (v) -> {



        });

        holder.setOnClickListener(R.id.reSelect, (v) -> {

        });

    }

    @Override
    protected void itemClick(AdapterView<?> parent, View view, int position, long id, ComplexModelSet.M_offliTraClas_M_traPoi_areaInf item) {

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



        } else if (basicResponse.code == BasicResponse.NOT_LOGIN) {

            Tool.loginCheck(this);

        }else{
            Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
        }


    }
}
