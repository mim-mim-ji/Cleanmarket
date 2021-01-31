package com.example.cleanmarket.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cleanmarket.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class MyAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;
    private int mCount;

    public MyAdapter(FragmentManager fm, int count, Context context) {
        super(fm);
        mCount = count;
        mContext = context;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        int index = getRealPosition(position);

        if(index==0) return new FragmentFirst();
        else if(index==1) return new FragmentSecond();
        else return new FragmentThird();

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }

    public int getRealPosition(int position) { return position % mCount; }
}