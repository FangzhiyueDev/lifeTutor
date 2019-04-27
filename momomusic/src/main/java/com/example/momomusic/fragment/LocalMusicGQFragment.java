package com.example.momomusic.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.momomusic.R;
import com.example.momomusic.adapter.MyAdapter;
import com.example.momomusic.model.Music;
import com.example.momomusic.servie.LocalMusicIndexUtil;
import com.example.momomusic.servie.PlayService;
import com.example.momomusic.tool.UiThread;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;

/**
 * 本地音乐的歌曲fragment,本身来说并不需要
 */
public class LocalMusicGQFragment extends ParentFragment implements AdapterView.OnItemClickListener {


    @BindView(R.id.listView)
    ListView listView;

    private MyAdapter<Music> musicMyAdapter;

    private List<Music> musics;

    static {
        LitePal.getDatabase();
    }

    private LocalMusicIndexUtil localMusicIndexUtil;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        musics = DataSupport.findAll(Music.class);
        if (musics.size() == 0) {
            localMusicIndexUtil = LocalMusicIndexUtil.getInstance();
            localMusicIndexUtil.setMusicScaleListener(new LocalMusicIndexUtil.MusicScaleListener() {
                @Override
                public void scaling(Music music) {
                    music.save();
                    musics.add(music);
                }

                @Override
                public void scaleComplate() {
                    UiThread.getUiThread().post(new Runnable() {
                        @Override
                        public void run() {
                            musicMyAdapter.notifyDataSetChanged();
                        }
                    });
                }
            });
            localMusicIndexUtil.indexLocalMusicI(getActivity());
        }

        musicMyAdapter = new MyAdapter<Music>((ArrayList<Music>) musics, R.layout.listview_music_list) {
            @Override
            public void bindView(ViewHolder holder, Music obj) {
                holder.setText(R.id.musicName, obj.getTitle());
                holder.setText(R.id.singerAndAlbumName, obj.getArtist() + " | " + obj.getAlbumName());
                holder.setText(R.id.title, obj.getTitle());
                holder.setOnClickListener(R.id.menu, (v) -> {

                });
            }
            @Override
            public int getCount() {
                return musics.size();
            }
        };

        listView.setAdapter(musicMyAdapter);

        listView.setOnItemClickListener(this);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_localmusic_gq, null);
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

    PlayService.MyBinder myBinder;

    boolean isBind = false;


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Music music = musics.get(position);

        if (!isBind) {
            //绑定
            Intent intent = new Intent(getActivity(), PlayService.class);
            isBind = !isBind;
            getActivity().bindService(intent, new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    myBinder = (PlayService.MyBinder) service;
                    myBinder.setDataSources(musics);
                    myBinder.playMusic(music.getDataUrl());
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            }, Context.BIND_AUTO_CREATE);

            getActivity().startService(intent);

        } else {
            myBinder.playMusic(music.getDataUrl());
        }

    }
}
