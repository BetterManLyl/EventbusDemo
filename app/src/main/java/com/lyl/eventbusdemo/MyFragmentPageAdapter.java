package com.lyl.eventbusdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyl
 * @date 2017/12/8.
 */

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private List<MyFragment> fragmentList = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private Context context;

    public void addFragment(int position) {
        fragmentList.add(MyFragment._instanceMyFragment(position));
        titles.add("第" + position + "个");
    }

    public MyFragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**
     * 返回标题
     *
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
