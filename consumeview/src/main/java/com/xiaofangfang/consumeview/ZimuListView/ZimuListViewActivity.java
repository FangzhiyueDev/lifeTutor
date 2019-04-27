package com.xiaofangfang.consumeview.ZimuListView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xiaofangfang.consumeview.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ZimuListViewActivity extends AppCompatActivity {


    private static final String TAG = "test";
    String[][] city = {{"安庆"},
            {"北京", "八达岭", "八公山", "蚌埠"},
            {"成都", "长安", "重庆", "池州"},
            {"东京", "东北", "大连"},
            {"阜阳", "福州", "福建"},
            {"广州", "广东"}};
    //这里我只是给出了部分的数据，懒得去写，太多了，只是一个例子
    String[] title = {"A", "B", "C", "D", "F", "G"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhimu);
        maginData();
    }

    private List<String> stringList;
    private ListView listView;

    private ListAdapter myAdapter;

    private void maginData() {

        stringList = new ArrayList<>();

        for (int i = 0; i < city.length; i++) {

            stringList.add(title[i]);

            for (int j = 0; j < city[i].length; j++) {
                stringList.add(city[i][j]);
            }
        }

        listView = findViewById(R.id.listView);

        myAdapter = new ListAdapter();

        listView.setAdapter(myAdapter);

    }


    class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return stringList.size();
        }

        @Override
        public Object getItem(int position) {
            return stringList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyViewHolder myViewHolder;

            String value = stringList.get(position);


            if (convertView != null) {
                myViewHolder = (MyViewHolder) convertView.getTag();
            } else {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item, null);
                myViewHolder = new MyViewHolder();
                myViewHolder.name = convertView.findViewById(R.id.name);
                myViewHolder.title = convertView.findViewById(R.id.title);
                myViewHolder.touxiang = convertView.findViewById(R.id.touxiang);
                myViewHolder.down = convertView.findViewById(R.id.down);
                convertView.setTag(myViewHolder);
            }


            if (value.length() == 1) {//代表是字母标题
                myViewHolder.down.setVisibility(View.INVISIBLE);
                myViewHolder.name.setVisibility(View.INVISIBLE);
                myViewHolder.touxiang.setVisibility(View.INVISIBLE);
                myViewHolder.title.setVisibility(View.VISIBLE);
                myViewHolder.title.setText(value);

            } else {//代表的是显示列表
                myViewHolder.down.setVisibility(View.VISIBLE);
                myViewHolder.name.setVisibility(View.VISIBLE);
                myViewHolder.touxiang.setVisibility(View.VISIBLE);
                myViewHolder.title.setVisibility(View.INVISIBLE);
                myViewHolder.name.setText(value);
            }
            return convertView;
        }


        class MyViewHolder {
            ImageView touxiang;
            TextView name;
            TextView title;
            ImageView down;
        }
    }


}
