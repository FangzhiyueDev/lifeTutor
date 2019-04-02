package com.xiaofangfang.consumeview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("test", "scrollview的高度=" + findViewById(R.id.scrollview).getMeasuredHeight());
        Log.d("test", "scrollview的宽度=" + findViewById(R.id.scrollview).getMeasuredWidth());


        View view;








    }


}
