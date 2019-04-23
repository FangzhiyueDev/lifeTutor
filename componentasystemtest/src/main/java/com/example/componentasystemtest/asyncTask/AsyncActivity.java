package com.example.componentasystemtest.asyncTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

import com.example.componentasystemtest.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AsyncActivity extends AppCompatActivity {

    private static final String TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 10);

        AsyncTask.handlerThread1Process(this);

        findViewById(R.id.button).setOnClickListener((v) -> {
//            AsyncTask.handler.sendEmptyMessage(20);

            AsyncTask.asyncQueryHandlerProcess(this);
        });

        findViewById(R.id.query).setOnClickListener((v) -> {
            Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{
                    MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DATA
            }, null, null, null);

            List<String> musics = new ArrayList<>();
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));

                musics.add(data);
                Log.d(TAG, "onCreate: 标题=\t" + name + "\turl=" + data);
            }


            File file = new File(musics.get(0));

            MediaPlayer mediaPlayer = new MediaPlayer();

            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(musics.get(0));
                mediaPlayer.prepare();
                mediaPlayer.start();




            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
