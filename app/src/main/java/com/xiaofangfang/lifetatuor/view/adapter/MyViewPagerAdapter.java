package com.xiaofangfang.lifetatuor.view.adapter;

import androidx.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {


    FragmentManager fm;
    List<Fragment> fragmentList = new ArrayList<>();

    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fm = fm;
        this.fragmentList = fragments;

    }

    /**
     * 获得fragment的列表
     * @return
     */
    public List<Fragment> getFragmentList() {
        return fragmentList;
    }

    public void removeFragment(int indx){
        fragmentList.remove(indx);
        //通知进行更新
        notifyDataSetChanged();
    }

    public void addFragment(int index,Fragment fragment){
        fragmentList.add(index,fragment);
        notifyDataSetChanged();
    }

    /**
     * 在这里对fragment进行处理
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        Fragment frament = fragmentList.get(position);
        return frament;
    }




    @Override
    public int getCount() {
        return fragmentList.size();
    }


    @Override
    public void destroyItem(ViewGroup container,
                            int position, Object object) {
        super.destroyItem(container,position,object);
    }


}
