package com.rcs.nchumanity.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


import com.rcs.nchumanity.R;
import com.rcs.nchumanity.dialog.DialogCollect;
import com.rcs.nchumanity.net.NetRequest;
import com.rcs.nchumanity.tool.LoadProgress;
import com.rcs.nchumanity.tool.UiThread;
import com.rcs.nchumanity.ul.ParentActivity;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Map;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;


/**
 * fragment的父集，用来实现一些通用的操作
 * <p>
 * 我们在lazyLoad()函数里面实现数据加载---->调用 loadData()加载数据，然后将街而过返回到success和error其中，然后根据烦恼返回的数据进行数据的处理
 */
public abstract class ParentFragment extends Fragment implements FramgentOprate {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getCreateView(), null);
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * 创建view
     *
     * @return
     */
    protected abstract int getCreateView();

    /**
     * 当view创建成功后的回调
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        onViewCreated(view, savedInstanceState, isViewCreated);
        lazyLoad();
    }

    protected void onViewCreated(View view, Bundle savedInstanceState, boolean isViewCreated) {

    }


    private ProgressBar progressBar;

    private MyCallHandler myCallHandler;

    private AlertDialog dialog;


    /**
     * 用来实现对网络资源的加载
     *
     * @param <T>
     * @param url    请求的url
     * @param what   用来生成请求标示
     * @param method 请求的方法
     * @param params 如果使用的是Post请求，该参数代表的是请求的参数
     * @param force  代表是否是强制加载
     */
    public <T> void loadData(final String url, final String what, String method, Map<String, String> params, boolean force, boolean postImg, String imagePath) {
        if (force) {
            progressBar = LoadProgress.loadProgress(getContext());
        } else {
            dialog = (AlertDialog) DialogCollect.openLoadDialog(getContext());
        }
        Thread t = new Thread(() -> {
            myCallHandler = new MyCallHandler(what, force);
            if (method.equalsIgnoreCase("GET")) {
                NetRequest.requestUrl(url, myCallHandler);
            } else if (method.equalsIgnoreCase("POST")) {
                if (postImg) {

                    NetRequest.postImage(url, imagePath, params, myCallHandler);

                } else {
                    NetRequest.requestPost(url, params, myCallHandler);
                }
            }
        });

        t.start();

        dialog.setOnDismissListener((dialog) -> {
//            Log.d(TAG, "onDismiss: ");
            if (t.getState() != Thread.State.TERMINATED) {
                t.interrupt();
                onError(new InterruptedIOException("自己取消异常"), what);
            }
        });
    }

    /**
     * 软加载
     *
     * @param url
     * @param what
     */
    public void loadDataGet(final String url, final String what) {
        loadData(url, what, "GET", null, false, false, null);
    }

    /**
     * 代表的是强制加载 。无法取消
     *
     * @param url
     * @param what
     */
    public void loadDataGetForForce(String url, final String what) {
        loadData(url, what, "GET", null, false, false, null);
    }


    /**
     * 软加载提交
     *
     * @param url
     * @param what
     * @param params
     */
    public void loadDataPost(final String url, final String what, Map<String, String> params) {
        loadData(url, what, "POST", params, false, false, null);
    }


    /**
     * 强制提交
     *
     * @param url
     * @param what
     * @param params
     */
    public void loadDataPostForce(final String url, final String what, Map<String, String> params) {
        loadData(url, what, "POST", params, true, false, null);
    }


    /**
     * 提交图片
     *
     * @param url
     * @param what
     * @param imagePath
     */
    public void loadDataPostImg(final String url, final String what, String imagePath, Map<String, String> params) {
        loadData(url, what, "POST", params, false, true, imagePath);
    }

    /**
     * 强制提交
     *
     * @param url
     * @param what
     * @param imagePath
     */
    public void loadDataPostImgForce(final String url, final String what, String imagePath, Map<String, String> params) {
        loadData(url, what, "POST", params,true,true,imagePath);
    }



    public <T extends ParentActivity> T getMyActivity() {
        return (T) getActivity();
    }


    public class MyCallHandler implements okhttp3.Callback {

        private String what;

        private boolean force;

        public MyCallHandler(String what, boolean force) {
            this.what = what;
            this.force = force;
        }

        @Override
        public void onFailure(Call call, final IOException e) {
            UiThread.getUiThread().post(new Runnable() {
                @Override
                public void run() {
                    if (force) {
                        LoadProgress.removeLoadProgress(getContext(), progressBar);
                    } else {
                        dialog.dismiss();
                    }
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
                    if (force) {
                        LoadProgress.removeLoadProgress(getContext(), progressBar);
                    } else {
                        dialog.dismiss();
                    }
                    try {
                        //这里返回的数据比较复杂,需要解析
                        onSucess(response, what, value);
                        Log.d("test", "run: " + value);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    /**
     * 下面的变量是来控制fragment的加载数据的
     */
    //Fragment的View加载完毕的标记
    private boolean isViewCreated;

    //Fragment对用户可见的标记
    private boolean isUIVisible;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }


    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            onLoadData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }

    /**
     * 在这里面进行数据的加载
     * 是一个空的实现，可以在这里实现数据的加载
     * 例如加载网络数据
     */
    protected void onLoadData() {
    }

    /**
     * 请求网络加载，加载数据出错的情况的回调
     *
     * @param e
     * @param what
     */
    public void onError(IOException e, String what) {
    }

    /**
     * 请求网络加载，加载数据加载成功的回调
     *
     * @param response
     * @param what
     * @param backData
     * @throws IOException
     */
    public void onSucess(Response response, String what, String... backData) throws IOException {

    }


}
