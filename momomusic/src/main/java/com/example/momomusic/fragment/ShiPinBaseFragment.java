package com.example.momomusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.momomusic.R;
import com.example.momomusic.adapter.MyCommandAdapter;
import com.example.momomusic.model.Video;
import com.example.momomusic.model.ZhiBoHouse;

import java.io.IOException;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

public class ShiPinBaseFragment extends ParentFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shipin_base, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private MyCommandAdapter<Video> myCommandAdapter;

    private ArrayList<Video> videos = new ArrayList<>();


    private int page;

    private int size = 10;

    private String what = "12";


    private String url = "http://www.baidu.com?page" + page + "&size=" + size;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myCommandAdapter = new MyCommandAdapter<Video>(getContext(), R.layout.recyclerview_shipin_base, videos) {

            @Override
            public void bind(MyViewHolder holder, Video video) {

            }
        };
        recyclerView.setAdapter(myCommandAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
    }

    @Override
    protected void loadData() {
        loadData(url, what);
    }

    @Override
    public void onError(IOException e, String what) {

    }

    @Override
    public void onSucess(Response response, String what, String... backData) throws IOException {
        if (what.equals(this.what)) {

        }
    }

    @Override
    public Class getClassName() {
        return this.getClass();
    }
}
