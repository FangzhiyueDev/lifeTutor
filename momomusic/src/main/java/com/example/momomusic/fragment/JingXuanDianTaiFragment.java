package com.example.momomusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.momomusic.R;
import com.example.momomusic.activity.ui.JingXuanDianTaiView;
import com.example.momomusic.activity.ui.JingXuanView;
import com.example.momomusic.precenter.JingXuanDianTaiPresenter;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import okhttp3.Response;

public class JingXuanDianTaiFragment extends BaseFragment<JingXuanDianTaiView, JingXuanDianTaiPresenter> {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_diantai, null);

        ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public JingXuanDianTaiPresenter createPresenter() {
        return null;
    }

    @Override
    public JingXuanDianTaiView createView() {
        return null;
    }

    @Override
    protected void loadData() {
        Logger.d("开始执行加载 JingXuanDianTaiFragment");
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
