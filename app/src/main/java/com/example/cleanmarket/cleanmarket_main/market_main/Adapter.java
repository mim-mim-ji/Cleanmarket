package com.example.cleanmarket.cleanmarket_main.market_main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cleanmarket.main.FragmentFirst;
import com.example.cleanmarket.main.FragmentSecond;
import com.example.cleanmarket.main.FragmentThird;

public class Adapter extends FragmentPagerAdapter {

    private int mCount;

    public Adapter(FragmentManager fm, int count) {
        super(fm);
        mCount = count;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        int index = getRealPosition(position);

        if(index==0) return new FragmentHome();
        else if(index==1) return new FragmentDashboard();
        else if(index==2) return new FragmentPlace();
        else if(index==3) return new FragmentSearch();
        else return new FragmentMyaccount();

    }
    @Override
    public int getCount() {
        return 5;
    }

    public int getRealPosition(int position) { return position % mCount; }

}
