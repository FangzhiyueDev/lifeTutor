package com.rcs.nchumanity.ul.list;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.adapter.ListViewCommonsAdapter;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.complexModel.ComplexModelSet;
import com.rcs.nchumanity.entity.model.SpecificInfo;
import com.rcs.nchumanity.entity.model.SpecificInfoClassification;
import com.rcs.nchumanity.entity.modelInter.SpecificInfoWithLocation;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.list.ComplexListActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

/**
 * 特定信息的复合列表的接口实现Activity
 */
public class SpecificInfoComplexListActivity extends ComplexListActivity<SpecificInfoWithLocation> {


    public static final String URL = "url";

    public static final String CLASS_NAME = "className";

    @Override
    protected void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, SpecificInfoWithLocation obj) {
        holder.setText(R.id.itemName, obj.getTitle());
    }

    @Override
    protected void itemClick(AdapterView<?> parent, View view, int position, long id, SpecificInfoWithLocation item) {
        Bundle bundle = new Bundle();
        if (item.getLatitude() != null) {

            //进入







        } else {


        }
    }

    @Override
    protected int getLayout() {
        return R.layout.item_basic_down;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String name = getIntent().getExtras().getString(CLASS_NAME);

        if (name == null) {
            throw new InvalidParameterException("param is not match");
        }
        setTitle(name);

        loadDataForNet();

    }


    /**
     * 加载网络数据
     */
    private void loadDataForNet() {

        String url = getIntent().getExtras().getString(URL);

        if (url == null) {
            throw new IllegalArgumentException("please transport parameter ");
        }
        loadDataGetForForce(url, "loadData");
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
//            loadDataForNet();
        }
    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        if (br.code == BasicResponse.RESPONSE_SUCCESS) {

            switch (what) {
                case "loadData":

                    try {
                        JSONObject brJ = new JSONObject(backData[0]);

                        JSONArray object = brJ.getJSONArray("object");


                        JSONArray infos = object.getJSONArray(0);
                        JSONArray locations = object.getJSONArray(1);


                        margeData(infos, locations);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


//                if (specificInfos.size() < size) {
//                    //代表的是没有数据了
//                    notData = true;
//                } else {
//                    notData = false;
//                }
//
//                //当数据加载完成后，判断是否是进行的刷新，如果是就代表刷新结束
//                if (!notData) {
//                    isFlush = true;//代表我们已经可以再一次的刷新了
//                } else {
//                    isFlush = false;//如果没有数据，就不能在刷新
//                }
//                addDataList(specificInfos);
//                break;
            }
        }else {
            Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
        }
    }

    private void margeData(JSONArray infos, JSONArray locations) throws JSONException {
        for (int i = 0; i < locations.length(); i++) {
            infos.put(locations.getJSONObject(i));
        }


        List<SpecificInfoWithLocation> specificInfoWithLocations = new ArrayList<>();


        for (int i = 0; i < infos.length(); i++) {

            JSONObject specJ = infos.getJSONObject(i);

            String title = specJ.getString("title");
            String createTime = null;
            String icon = null;
            String videoId = null;
            String videoUrl = null;
            String editor = null;
            String imageUrl = null;
            String content = null;
            double longitute = 0;
            double latitude = 0;
            if (specJ.has("createTime")) {
                createTime = specJ.getString("createTime");
            }

            if (specJ.has("icon")) {
                icon = specJ.getString("icon");
            }

            if (specJ.has("videoId")) {
                videoId = specJ.getString("videoId");
            }

            if (specJ.has("videoUrl")) {
                videoUrl = specJ.getString("videoUrl");
            }

            if (specJ.has("editor")) {
                editor = specJ.getString("editor");
            }

            if (specJ.has("imgUrl")) {
                imageUrl = specJ.getString("imgUrl");
            }

            if (specJ.has("content")) {
                content = specJ.getString("content");
            }

            if (specJ.has("longitute")) {
                longitute = specJ.getDouble("longitute");
            }

            if (specJ.has("latitude")) {
                latitude = specJ.getDouble("latitude");
            }

            SpecificInfoWithLocation specificInfo = new SpecificInfoWithLocation();
            specificInfo.setTitle(title);
            specificInfo.setIcon(icon);
            specificInfo.setVideoId(videoId);
            specificInfo.setVideoUrl(videoUrl);
            specificInfo.setEditor(editor);
            specificInfo.setContent(content);
            specificInfo.setImgUrl(imageUrl);
            specificInfo.setLatitude((float) latitude);
            specificInfo.setLongitude((float) longitute);
            specificInfoWithLocations.add(specificInfo);
        }

        setDataList(specificInfoWithLocations);
    }
}
