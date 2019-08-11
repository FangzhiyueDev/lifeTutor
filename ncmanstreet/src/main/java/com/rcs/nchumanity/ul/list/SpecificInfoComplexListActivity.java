package com.rcs.nchumanity.ul.list;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
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

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import okhttp3.Response;

/**
 * 特定信息的复合列表的接口实现Activity
 */
public class SpecificInfoComplexListActivity extends ComplexListActivity<SpecificInfoWithLocation> {


    @Override
    protected void bindViewValue(ListViewCommonsAdapter.ViewHolder holder, SpecificInfoWithLocation obj) {
        holder.setText(R.id.itemName, obj.getTitle());
    }

    @Override
    protected void itemClick(AdapterView<?> parent, View view, int position, long id, SpecificInfoWithLocation item) {
        Bundle bundle = new Bundle();
        if(item.getLatitude()!=null){

            //进入


        }else {



        }
    }

    @Override
    protected int getLayout() {
        return R.layout.item_basic_down;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SpecificInfoClassification spclass = (SpecificInfoClassification) getIntent().getExtras().getSerializable(SpecificInfoClassification.class.getSimpleName());

        if (spclass == null) {
            throw new InvalidParameterException("param is not match");
        }
        setTitle(spclass.getTitle());

        loadDataForNet();

    }


    private void loadDataForNet() {
        String param = String.format(NetConnectionUrl.getSpecificInfoForClassId, size, page);
        loadDataGetForForce(param, "loadData");
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
            loadDataForNet();
        }
    }


    @Override
    public void onSucessful(Response response, String what, String... backData) throws IOException {

        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);

        switch (what) {
            case "loadData":

                ComplexModelSet.M_speinf_speinfClaLoca specificInfoClassWidthLoca = (ComplexModelSet.M_speinf_speinfClaLoca) br.object;

                List<SpecificInfoWithLocation> specificInfos = specificInfoClassWidthLoca.infoWithLocations;

                if (specificInfos.size() < size) {
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
                addDataList(specificInfos);
                break;
        }
    }
}
