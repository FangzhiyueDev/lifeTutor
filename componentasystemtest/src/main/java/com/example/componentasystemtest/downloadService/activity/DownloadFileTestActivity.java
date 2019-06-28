package com.example.componentasystemtest.downloadService.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.componentasystemtest.R;
import com.example.componentasystemtest.downloadService.service.DownloadService;

public class DownloadFileTestActivity extends AppCompatActivity {


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.down_file);


        findViewById(R.id.down).setOnClickListener((v) -> {

            Intent intent = new Intent(DownloadFileTestActivity.this, DownloadService.class);
            startService(intent);

        });

    }


}
