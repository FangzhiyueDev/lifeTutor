package com.example.momomusic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.momomusic.activity.ParentActivity;
import com.example.momomusic.servie.NetRequest;
import com.example.momomusic.tool.LoadProgress;
import com.example.momomusic.tool.UiThread;


import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import okhttp3.Call;
import okhttp3.Response;


/**
 * fragment的父集，用来实现一些通用的操作
 */
public abstract class ParentFragment extends Fragment implements FramgentOprate {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

    }

    /**
     * 当view创建成功后的回调
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    private ProgressBar progressBar;

    private MyCallHandler myCallHandler;


    /**
     * 这个方法是用来加载网络资源的
     *
     * @param url
     * @param what
     * @param <T>
     */
    public <T> void loadData(final String url, final String what) {
        progressBar = LoadProgress.loadProgress(getMyActivity());
        new Thread(new Runnable() {
            @Override
            public void run() {
                myCallHandler = new MyCallHandler(what);
                NetRequest.requestUrl(url, myCallHandler);
            }
        }).start();
    }

    public <T extends ParentActivity> T getMyActivity() {
        return (T) getActivity();
    }


    public class MyCallHandler implements okhttp3.Callback {

        private String what;

        public MyCallHandler(String what) {
            this.what = what;
        }

        @Override
        public void onFailure(Call call, final IOException e) {
            UiThread.getUiThread().post(new Runnable() {
                @Override
                public void run() {
                    LoadProgress.removeLoadProgress(getMyActivity(), progressBar);
                    Toast.makeText(getMyActivity(), "加载数据出错,请稍后再试", Toast.LENGTH_SHORT).show();
                    onError(e, what);
                }
            });
        }

        @Override
        public void onResponse(Call call, final Response response) throws IOException {
            final String value = response.body().string();
            UiThread.getUiThread().post(new Runnable() {
                @Override
                public void run() {
                    LoadProgress.removeLoadProgress(getMyActivity(), progressBar);
                    try {
                        //这里返回的数据比较复杂,需要解析
                        onSucess(response, what, value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    public abstract void onError(IOException e, String what);

    public abstract void onSucess(Response response, String what, String... backData) throws IOException;

    private Bundle bundle;

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public Bundle getBundle() {
        return bundle;
    }
}
