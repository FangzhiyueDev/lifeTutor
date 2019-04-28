package com.example.momomusic.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.momomusic.R;
import com.example.momomusic.adapter.MyAdapter;
import com.example.momomusic.exception.ParamNotBindException;
import com.example.momomusic.model.Music;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

/**
 * 这个界面的作用是用来显示专辑点进去的的显示效果
 */
public class LocalMusicSingerZJMusicFragment extends ParentFragment {

    /**
     * 需要传递的bundle的key
     */
    public static final String ALBUM = "album";
    private static final String TAG = "test";


    private String album;

    private List<Music> musics;


    @BindView(R.id.listView)
    ListView listView;

    private MyAdapter<Music> myAdapter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        musics = new ArrayList<>();
        myAdapter = new MyAdapter<Music>((ArrayList<Music>) musics, R.layout.listview_music_not_icon) {
            @Override
            public void bindView(ViewHolder holder, Music obj) {
                holder.setText(R.id.musicName, obj.getTitle());
                holder.setText(R.id.singerAndAlbumName, obj.getArtist() + " | " + obj.getAlbumName());
                holder.setOnClickListener(R.id.menu, (v) -> {
                    //点击事件的处理

                });
            }

            @Override
            public int getCount() {
                return musics.size();
            }
        };
        listView.setAdapter(myAdapter);

        album = getMyActivity().getBundle().getString(ALBUM);
        if (album == null) {
            try {
                throw new ParamNotBindException("当前页面需要传递的参数没有传递" + getClass().getName());
            } catch (ParamNotBindException e) {
                e.printStackTrace();
            }
        }

        musics = DataSupport.where("albumName=?", album).find(Music.class);

        for (int i = 0; i < musics.size(); i++) {
            Log.d(TAG, musics.toString());
        }
        myAdapter.notifyDataSetChanged();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_localmusic_singer_zj_music, null);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    protected void loadData() {

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
