package com.wxw.rubbishApp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wxw.rubbishApp.fragment.VPFragment1;
import com.wxw.rubbishApp.fragment.VPFragment2;
import com.wxw.rubbishApp.fragment.VPFragment3;
import com.wxw.rubbishApp.fragment.VPFragment4;

/**
 * @Author: pyz
 * @Package: com.pyz.viewpagerdemo.adapter
 * @Description: TODO
 * @Project: ViewPagerDemo
 * @Date: 2016/8/18 11:49
 */
public class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private String[] tabTilte;

    public MyFragmentStatePagerAdapter(FragmentManager fm, String[] tabTitle) {
        super(fm);
        this.tabTilte = tabTitle;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VPFragment1();
            case 1:
                return new VPFragment2();
            case 2:
                return new VPFragment3();
            case 3:
                return new VPFragment4();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTilte.length;
    }
}
