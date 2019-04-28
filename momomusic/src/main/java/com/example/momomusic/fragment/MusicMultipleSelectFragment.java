package com.example.momomusic.fragment;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.momomusic.R;
import com.example.momomusic.adapter.MyAdapter;
import com.example.momomusic.model.Music;
import com.example.momomusic.servie.ColorSerivice;
import com.example.momomusic.tool.Tools;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Response;

/**
 * 歌曲多选的界面实现
 * 这个界面可能需要复用
 */
public class MusicMultipleSelectFragment extends ParentFragment implements AdapterView.OnItemClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_music_multiple_select, null);
        ButterKnife.bind(this, view);
        return view;
    }

    private List<Music> musicList;


    @BindView(R.id.listView)
    ListView listView;

    private List<String> strings;

    private MyAdapter<Music> myAdapter;

    @BindViews({R.id.addGeDan, R.id.del, R.id.shoucang, R.id.share})
    List<TextView> menus;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        strings = new ArrayList<>();

        musicList = DataSupport.findAll(Music.class);

        myAdapter = new MyAdapter<Music>((ArrayList<Music>) musicList, R.layout.listview_multiple_music) {
            @Override
            public void bindView(ViewHolder holder, Music obj) {
                holder.setText(R.id.musicName, obj.getTitle());
                holder.setText(R.id.singerAndAlbumName, obj.getArtist() + " | " + obj.getAlbumName());
                holder.setText(R.id.title, obj.getTitle());
                holder.setTag(R.id.menu, new Boolean(false));
            }

            @Override
            public int getCount() {
                return musicList.size();
            }
        };

        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);


    }


    @OnClick({R.id.addGeDan, R.id.del, R.id.shoucang, R.id.share})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addGeDan:

                //弹出一个窗口,选泽播放列表



                break;
            case R.id.del:
                for (String value : strings) {
                    Music music = DataSupport.where("dataUrl=?", value).find(Music.class).get(0);
                    music.delete();
                }

                break;

            case R.id.shoucang:
                //在这里将addUrl的相关music里面的收藏属性更改为true,也就是更新
                for (String value : strings) {

                    Music music = DataSupport.where("dataUrl=?", value).find(Music.class).get(0);
                    music.setCollect(true);
                    music.save();//因为是已经保存的数据,就会执行更新
                }
                break;

            case R.id.share:

                break;
        }
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CheckBox checkBox = view.findViewById(R.id.menu);
        checkBox.setChecked(!(Boolean) checkBox.getTag());
        checkBox.setTag(checkBox.isChecked());
        Music music = myAdapter.getItem(position);
        if (checkBox.isChecked()) {
            strings.add(music.getDataUrl());
        } else {
            strings.remove(music.getDataUrl());
        }

        if (strings.size() > 0) {
            setMenuEnable(true);
        } else if (strings.size() == 0) {
            setMenuEnable(false);
        }
    }

    /**
     * 设置菜单是否可用
     *
     * @param b
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setMenuEnable(boolean b) {
        if (b) {

            for (TextView textView : menus) {
                textView.setEnabled(true);
                Tools.setDrawableColor(Color.BLACK, textView);
            }
        } else {
            for (TextView textView : menus) {
                textView.setEnabled(false);
                Tools.setDrawableColor(ColorSerivice.DARK_GRAY, textView);
            }
        }
    }
}
