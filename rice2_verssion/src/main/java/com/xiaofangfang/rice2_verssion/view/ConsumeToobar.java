package com.xiaofangfang.rice2_verssion.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaofangfang.rice2_verssion.ParentActivity;
import com.xiaofangfang.rice2_verssion.R;
import com.xiaofangfang.rice2_verssion.model.City;
import com.xiaofangfang.rice2_verssion.model.Province;
import com.xiaofangfang.rice2_verssion.network.NetRequest;
import com.xiaofangfang.rice2_verssion.tool.DialogTool;
import com.xiaofangfang.rice2_verssion.tool.Looger;
import com.xiaofangfang.rice2_verssion.tool.UiThread;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.xiaofangfang.rice2_verssion.ParentActivity.city;


/**
 * 自定义的toolbar,是一个头部的控件，用来实现程序的地理位置的切换
 */
public class ConsumeToobar extends LinearLayout implements View.OnClickListener {

    /**
     * 定义的一些主题资源
     */
    public static int transparentTheme = 1;
    public static int writeTheme = 2;

    public ConsumeToobar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ConsumeToobar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    public Button locationChange;
    public TextView titleText;
    public RelativeLayout bgContainer;
    private DialogTool.AddressSelectDialog addressSelectDialog;

    public void setTitle(String title) {
        titleText.setText(title);
    }

    public void setLocation(String title) {
        locationChange.setText(title);
    }

    private void initView() {

        ViewGroup viewRoot = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.consume_toolbar_layout, null, false);

        locationChange = viewRoot.findViewById(R.id.locationButton);
        titleText = viewRoot.findViewById(R.id.title);
        locationChange.setOnClickListener(this);
        bgContainer = viewRoot.findViewById(R.id.bgContainer);

        LayoutParams layoutParams = new LayoutParams(-1, 160);
        this.addView(viewRoot, layoutParams);

    }


    public void setTheme(int theme) {
        if (theme == transparentTheme) {

            bgContainer.setBackgroundColor(getResources().getColor(android.R.color.transparent));

            return;
        }
        if (theme == writeTheme) {

            bgContainer.setBackgroundColor(getResources().getColor(android.R.color.white));
            titleText.setTextColor(getResources().getColor(android.R.color.black));

            return;
        }
    }

    /**
     * 设置颜色
     *
     * @param color
     */
    public void setTitleColor(int color) {
        titleText.setTextColor(getResources().getColor(color));
    }

    public void setTitleAlpha(float alpha) {
        titleText.setAlpha(alpha);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.locationButton:
                addressSelectDialog = new DialogTool.AddressSelectDialog(getContext());
                addressSelectDialog.setLocationChangeListener((City city, Province province) -> {
                    locationChange.setText(city.getName());
                    if (lo != null) {
                        lo.change(province, city);
                    }
                });
                addressSelectDialog.progress();

                break;
        }
    }


    private LocationChangeListener lo;

    public void setLocationChange(LocationChangeListener lo) {
        this.lo = lo;
    }

    public static interface LocationChangeListener {
        void change(Province province, City city);
    }


}
