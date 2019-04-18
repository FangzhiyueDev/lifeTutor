package com.example.momomusic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.momomusic.R;
import com.example.momomusic.activity.ui.MusicPlayView;
import com.example.momomusic.precenter.MusicPlayPresenter;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        seekBar.setOnTouchListener((v, event) -> true);//禁用触摸事件



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
