package com.example.gsce;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAccount extends FragmentPagerAdapter {

    public ViewPagerAccount(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ProcessFragment processFragment = new ProcessFragment();
                return processFragment;
            case 1:
                SettingFragment settingFragment = new SettingFragment();
                return settingFragment;
            default:
                ProcessFragment processFragment1 = new ProcessFragment();
                return processFragment1;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
