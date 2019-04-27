package com.example.momomusic.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.momomusic.R;
import com.example.momomusic.activity.BaseActivity;
import com.example.momomusic.activity.ui.MeFragmentView;
import com.example.momomusic.precenter.MeFragmentPresenter;
import com.example.momomusic.tool.Tools;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

public class MeFragment extends BaseFragment<MeFragmentView, MeFragmentPresenter<MeFragmentView>> implements MeFragmentView {


    private static final String TAG = "test";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);
        ButterKnife.bind(this, view);
        return view;
    }


    @BindView(R.id.localMusic)
    Button localMusic;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public MeFragmentView createView() {
        return this;
    }


    @OnClick(R.id.localMusic)
    public void onClick(View view) {
        Log.d(TAG, "onClick: ");
        Tools.startActivity(getActivity(), "com.example.momomusic.fragment.LocalMusicListFragment");
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
