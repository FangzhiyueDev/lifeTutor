package com.example.componentasystemtest.photoZip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.LruCache;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.componentasystemtest.R;


/**
 * 图片压缩的实现
 * <p>
 */

public class PhotoZipActivity extends AppCompatActivity {


    private static final String TAG = "test";
    private String url = "http://10.109.3.112:8080/GF/app.jpg";


    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_zip);
        imageView = findViewById(R.id.image);

    }


    public void onClick(View view) {
        Bitmap bitmap;
        bitmap = NativeImageLoader.getInstance().loadNativeImage(url, new Point(imageView.getWidth(),imageView.getHeight()), new NativeImageLoader.NativeImageCallBack() {
            @Override
            public void onImageLoader(Bitmap bitmap, String path) {
                Log.d(TAG, "onImageLoader: " + bitmap);
                imageView.setImageBitmap(bitmap);
            }
        });
        imageView.setImageBitmap(bitmap);
    }
}
