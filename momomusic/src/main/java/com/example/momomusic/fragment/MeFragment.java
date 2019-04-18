package com.example.momomusic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.momomusic.R;
import com.example.momomusic.activity.BaseActivity;
import com.example.momomusic.activity.ui.MeFragmentView;
import com.example.momomusic.precenter.MeFragmentPresenter;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.Response;

public class MeFragment extends BaseFragment<MeFragmentView, MeFragmentPresenter<MeFragmentView>> implements MeFragmentView {


    private static final String TAG = "test";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);
        return view;
    }

    @Override
    public MeFragmentView createView() {
        return this;
    }

    /**
     * 加载数据
     */
    @Override
    protected void loadData() {
        Log.d(TAG, "loadData: MeFragment");
    }


    @Override
    public MeFragmentPresenter<MeFragmentView> createPresenter() {
        return null;
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
