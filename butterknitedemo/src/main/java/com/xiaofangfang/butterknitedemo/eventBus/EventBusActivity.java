package com.xiaofangfang.butterknitedemo.eventBus;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xiaofangfang.butterknitedemo.R;
import com.xiaofangfang.butterknitedemo.eventBus.event.Boundle;
import com.xiaofangfang.butterknitedemo.eventBus.event.Message;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends AppCompatActivity {


    @BindView(R.id.start)
    public Button start;
    @BindView(R.id.receive)
    public Button receive;
    @BindView(R.id.text)
    public TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ButterKnife.bind(this);

        //注册接收
        EventBus.getDefault().register(this);


    }


    @OnClick(value = {
            R.id.start,
            R.id.receive
    })
    public void onClick(View view) {
        if (view == start) {
            Intent intent = new Intent(this, EventBusTwoActivity.class);
            startActivity(intent);
        }
        if (view == receive) {
            if (EventBus.getDefault().isRegistered(this)) {
                return;
            }
            EventBus.getDefault().register(this);
        }
    }


    //5.接收消息

    /**
     * 函数名称随便定义的,但是参数必须是我们接收的类型
     *
     * @param message
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(Message message) {
        //显示接收的消息
        text.setText(message.name);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void BoundleEventBus(Boundle boundle) {
        //显示接收的消息
        text.setText(boundle.name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
