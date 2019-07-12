package com.rcs.nchumanity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.rcs.nchumanity.R;
import com.rcs.nchumanity.net.NetRequest;
import com.rcs.nchumanity.tool.LoadProgress;
import com.rcs.nchumanity.tool.UiThread;
import com.rcs.nchumanity.ul.ParentActivity;

import java.io.IOException;

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
