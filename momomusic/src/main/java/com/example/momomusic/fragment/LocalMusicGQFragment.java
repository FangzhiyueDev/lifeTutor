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
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorTreeAdapter;

import com.example.momomusic.R;
import com.example.momomusic.adapter.MyAdapter;
import com.example.momomusic.model.Music;
import com.example.momomusic.servie.AnimationControllService;
import com.example.momomusic.servie.LocalMusicIndexUtil;
import com.example.momomusic.servie.PlayService;
import com.example.momomusic.servie.SystemSettingService;
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


    /**
     * 当前的路径
     */
    public static final String FIEL_PATH = "file_path";


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

        Bundle bundle = getMyActivity().getBundle();

        if (bundle == null) {
            //采用默认的加载机制
            musics = DataSupport.findAll(Music.class);
        } else if (bundle != null) {//如果bundle不为空.同时filepath不为空
            String filePath = bundle.getString(FIEL_PATH);
            if (filePath != null) {
                //取出filepath.进行过滤
                musics = DataSupport.where("dataUrl like ?", filePath + "%").find(Music.class);
            }
        }

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
        listView.setLayoutAnimation(AnimationControllService.setLayoutAnim(R.anim.anim_item, 0.2f, LayoutAnimationController.ORDER_NORMAL, getContext()));
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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Music music = musics.get(position);

        //绑定
        Intent intent = new Intent(getActivity(), PlayService.class);
        SystemSettingService.getInstall(getContext()).bindMusicPlayService(true);
        getActivity().bindService(intent, getMyActivity().conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myBinder = (PlayService.MyBinder) service;
                myBinder.setDataSources(musics);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
            }
        }, Context.BIND_AUTO_CREATE);
        /**
         * 这里我们看出,startService通过这个方式直接进行交互,
         */
        intent.putExtra(PlayService.DATA, music.getDataUrl());
        intent.putExtra(PlayService.ACTION, PlayService.WITH_DATA_PLAY);
        getActivity().startService(intent);
    }
}

