package com.example.gsce;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerDic extends FragmentPagerAdapter {
    public ViewPagerDic(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                MeanFragment meanFragment = new MeanFragment();
                return meanFragment;
            case 1:
                SynonymFragment synonymFragment = new SynonymFragment();
                return synonymFragment;
            default:
                MeanFragment meanFragment1 = new MeanFragment();
                return meanFragment1;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
