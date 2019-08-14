package com.rcs.nchumanity.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.rcs.nchumanity.R;
import com.rcs.nchumanity.entity.BasicResponse;
import com.rcs.nchumanity.entity.NetConnectionUrl;
import com.rcs.nchumanity.entity.PersistenceData;
import com.rcs.nchumanity.entity.model.EmergencyInfo;
import com.rcs.nchumanity.service.JG.MyReceiver;
import com.rcs.nchumanity.tool.ActivityStackManager;
import com.rcs.nchumanity.tool.DateProce;
import com.rcs.nchumanity.tool.Tool;
import com.rcs.nchumanity.ul.MainActivity;
import com.rcs.nchumanity.ul.list.EmergencyComplexListActivity;
import com.rcs.nchumanity.view.CommandBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import okhttp3.Response;

/**
 * 志愿救援的信息的显示
 */
public class ZYJYFragment extends ParentFragment {


    private static final String TAG = "test";
    @BindView(R.id.toolbar)
    public CommandBar commandBar;

    private String title = "救护员救援";

    @BindView(R.id.sendHelp)
    ImageButton sendHelp;

    @BindView(R.id.rootHelpView)
      LinearLayout rootHelpView;


    public static final String ACTION_HELP_DATA = "com.fang.getHelpData.ACTION";


    @Override
    protected int getCreateView() {
        return R.layout.zyjy;
    }


    private HelpDataBroadcastReceiver helpDataBroadcastReceiver;

    @Override
    protected void onViewCreated(View view, Bundle savedInstanceState, boolean isViewCreated) {
        super.onViewCreated(view, savedInstanceState, isViewCreated);
        commandBar.setTitle(title);
        helpDataBroadcastReceiver = new HelpDataBroadcastReceiver();

        IntentFilter intentFilter = new IntentFilter(getActivity().getPackageName());

        getActivity().registerReceiver(helpDataBroadcastReceiver, intentFilter);


        ActivityStackManager asm = ActivityStackManager.getInstance(getContext());

        String packName = getContext().getPackageName() + File.separator + MainActivity.class.getName();

        Log.d(TAG, "onViewCreated: " + packName);

        loadDataGet(NetConnectionUrl.selectInfo, "selectInfo");


        if (getMyActivity() instanceof MainActivity) {
            commandBar.hiddenBack();
        }

        commandBar.setBackGroundColor1(android.R.color.transparent);
        commandBar.setMenu(R.drawable.ic_30, (view1 -> {

            Tool.startActivity(getActivity(), EmergencyComplexListActivity.class);


        }));
    }

    public void setToolbarOffsetY(int dimensionPixel) {
        commandBar.setTranslationY(dimensionPixel);
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onSucess(Response response, String what, String... backData) throws IOException {
        super.onSucess(response, what, backData);
        BasicResponse br = new Gson().fromJson(backData[0], BasicResponse.class);
        if (br.code == BasicResponse.RESPONSE_SUCCESS) {

            if(what.equals("selectInfo")){
                try {
                    List<EmergencyInfo> emergencyInfos1 = new ArrayList<>();
                    List<EmergencyInfo> emergencyInfos = parseEmergencyData(backData[0]);

                    for (EmergencyInfo emergencyInfo : emergencyInfos) {

                        if (emergencyInfo.getCreateTime().after(getBeforeDay())) {
                            emergencyInfos1.add(emergencyInfo);
                        }
                    }


                    rootHelpView.removeAllViews();

                    for (EmergencyInfo emergencyInfo : emergencyInfos1) {

                        String title = emergencyInfo.getTitle();
                        String content = emergencyInfo.getContent();
                        double lantitute = emergencyInfo.getLatitude();
                        double longitude = emergencyInfo.getLongitude();
                        String mobile = emergencyInfo.getMobilePhone();

                        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_help_emergy, null);
                        TextView titleS = view.findViewById(R.id.title);
                        titleS.setText(title);
                        TextView des = view.findViewById(R.id.des);
                        des.setText(content);
                        view.findViewById(R.id.join).setOnClickListener((v) -> {
                            //进入地图显示界面


                        });
                        rootHelpView.addView(view);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


            }




        } else if (br.code == BasicResponse.NOT_LOGIN) {
            Tool.loginCheck(getActivity());
        } else {
            Toast.makeText(getActivity(), "发生错误", Toast.LENGTH_SHORT).show();
        }
    }


    @OnClick(R.id.sendHelp)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sendHelp:

                Intent intent = new Intent();
                intent.setAction(getActivity().getPackageName());
                intent.putExtra(MyReceiver.FUNC, MyReceiver.FUN_SEND_HELP);
                getActivity().sendBroadcast(intent);

                break;
        }
    }


    public  class HelpDataBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("test", "onReceive: -----------接受到广播通知");

            String func = intent.getStringExtra(MyReceiver.FUNC);

            if (func.equals(MyReceiver.FUN_NOTIFICATION)){
                loadDataGet(NetConnectionUrl.selectInfo, "selectInfo");
            }
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





    public static Date getBeforeDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        return date;
    }




}
