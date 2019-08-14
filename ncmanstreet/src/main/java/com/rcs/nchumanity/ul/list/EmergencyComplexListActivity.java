package com.rcs.nchumanity.ul.list;

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
import com.rcs.nchumanity.entity.model.EmergencyInfo;
import com.rcs.nchumanity.tool.DateProce;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

public class EmergencyComplexListActivity extends ComplexListActivity<EmergencyInfo> {





    @Override
    protected void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, EmergencyInfo obj) {


    }

    @Override
    protected void itemClick(AdapterView<?> parent, View view, int position, long id, EmergencyInfo item) {

    }

    @Override
    protected int getLayout() {
        return R.layout.item_emergency;
    }






    private int page = 0;

    private int size = 20;

    /**
     * 代表的是没有数据
     */
    private boolean notData;

    /**
     * 代表的是否能够进行刷新，默认的状态下是true
     * 之所以采用这个的判断是源于我们滑动到底层的时候会一直触发loadData()事件，这时会产生多线程问题
     * 当isFlush=true,代表的是数据刷新成功，也就代表这我们可以在一次的进行刷新
     */
    private boolean isFlush = true;


    @Override
    protected void scrollToBottom() {
        if (isFlush) {
            isFlush = false;
            page++;
            //加载数据
            String param=String.format(NetConnectionUrl.selectInfoSplitPage,size,page);

            loadDataGetForForce(param,"loadData");
        }
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String param=String.format(NetConnectionUrl.selectInfoSplitPage,size,page);

        loadDataGetForForce(param,"loadData");

    }

    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (br.code == BasicResponse.RESPONSE_SUCCESS) {

            switch (what) {
                case "loadData":

                    try {

                       List<EmergencyInfo>  emergencyInfos =parseEmergencyData(backData[0]);

                        if (emergencyInfos.size() < size) {
                            //代表的是没有数据了
                            notData = true;
                        } else {
                            notData = false;
                        }

                        //当数据加载完成后，判断是否是进行的刷新，如果是就代表刷新结束
                        if (!notData) {
                            isFlush = true;//代表我们已经可以再一次的刷新了
                        } else {
                            isFlush = false;//如果没有数据，就不能在刷新
                        }
                        addDataList(emergencyInfos);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                break;
            }
        }else {
            Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
        }
    }



    /**
     * 解析出当前的求救的数据
     *
     * @param backDatum
     * @return
     */
    private ArrayList<EmergencyInfo> parseEmergencyData(String backDatum) throws JSONException {
        JSONObject brJ = new JSONObject(backDatum);
        JSONObject data = brJ.getJSONObject("data");
        JSONArray totalList = data.getJSONArray("list");

        ArrayList<EmergencyInfo> emergencyInfos = new ArrayList<>();

        for (int i = 0; i < totalList.length(); i++) {
            EmergencyInfo emergencyInfo = new EmergencyInfo();
            JSONObject emerO = totalList.getJSONObject(i);
            int emerId = emerO.getInt("emerId");
            String createTime = emerO.getString("createTime");
            String title = emerO.getString("title");
            String content = emerO.getString("content");
            int longitude = emerO.getInt("longitude");
            double latitude = emerO.getDouble("latitude");
            int readCount = emerO.getInt("readCount");
            String mobilePhone = emerO.getString("mobilePhone");
            int userId = emerO.getInt("userId");
            emergencyInfo.setContent(content);
            emergencyInfo.setCreateTime(DateProce.parseDate(createTime));
            emergencyInfo.setEmerId(emerId);
            emergencyInfo.setTitle(title);
            emergencyInfo.setLatitude((float) latitude);
            emergencyInfo.setLongitude((float) longitude);
            emergencyInfo.setUserId(userId);
            emergencyInfo.setReadCount(readCount);
            emergencyInfo.setMobilePhone(mobilePhone);
            emergencyInfos.add(emergencyInfo);
        }
        return emergencyInfos;
    }







}
