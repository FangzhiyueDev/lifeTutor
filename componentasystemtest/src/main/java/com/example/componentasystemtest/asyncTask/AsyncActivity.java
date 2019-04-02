package com.example.componentasystemtest.asyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.componentasystemtest.R;

public class AsyncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);


        AsyncTask.handlerThread1Process(this);

        findViewById(R.id.button).setOnClickListener((v) -> {
            AsyncTask.handler.sendEmptyMessage(20);

        });


    }
}
