package com.witcher.androidrss.ui.activities;

import android.support.v4.app.Fragment;

import com.witcher.androidrss.ui.fragments.ThemesFragment;

public class ThemesActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return new ThemesFragment();
    }
}
