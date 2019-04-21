package com.example.momomusic.fragment;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.momomusic.R;
import com.example.momomusic.activity.ui.MusicPlayView;
import com.example.momomusic.precenter.MusicPlayPresenter;
import com.example.momomusic.view.HotCommentList;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

public class MusicPlayFragment extends BaseFragment<MusicPlayView, MusicPlayPresenter> {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_music_play, null);
        ButterKnife.bind(this, view);
        return view;
    }


    @BindView(R.id.seekbar)
    SeekBar seekBar;

    @BindView(R.id.commentList)
    HotCommentList commentList;

    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    @BindView(R.id.tuijian)
    FrameLayout tuijian;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        seekBar.setOnTouchListener((v, event) -> true);//禁用触摸事件

        scrollView.setOnScrollChangeListener((NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) -> {

            //在这里我们获得
            if (scrollY > tuijian.getTop()) {

                //在这里我们创建一个view，动态的添加到



            }

            Logger.d(scrollY + "\t" + tuijian.getTop());


        });

        commentList.initView(null);
    }

    @Override
    public MusicPlayPresenter createPresenter() {
        return null;
    }

    @Override
    public MusicPlayView createView() {
        return null;
    }

    @Override
    protected void loadData() {
        Logger.d("当前可见的fargment" + this.getClassName());

    }

    @Override
    public void onError(IOException e, String what) {

    }

    @Override
    public void onSucess(Response response, String what, String... backData) throws IOException {

    }

    @Override
    public Class getClassName() {
        return null;
    }
}
