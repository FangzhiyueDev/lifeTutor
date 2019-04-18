package com.example.momomusic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.momomusic.activity.ui.ShiPinView;
import com.example.momomusic.precenter.ShiPinPresenter;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.Response;

public class ShiPinFragment extends BaseFragment<ShiPinView, ShiPinPresenter> {


    private static final String TAG = "test";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public ShiPinPresenter createPresenter() {
        return null;
    }

    @Override
    public ShiPinView createView() {
        return null;
    }

    @Override
    protected void loadData() {
        Log.d(TAG, "loadData: ShiPinFragment");
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
