package com.witcher.androidrss.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.witcher.androidrss.R;
import com.witcher.androidrss.RSSApplication;
import com.witcher.androidrss.domain.Theme;
import com.witcher.androidrss.presenters.ThemesPresenter;
import com.witcher.androidrss.ui.adapters.ThemeAdapter;
import com.witcher.androidrss.view.ThemesListView;

import java.util.List;

import javax.inject.Inject;

public class ThemesFragment extends Fragment implements ThemesListView {

    private static final String TAG = ThemesFragment.class.getName();

    protected RecyclerView themeRecyclerView;

    @Inject
    protected ThemesPresenter presenter;

    private ThemeAdapter themeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RSSApplication.getApplicationComponent().inject(this);

        presenter.setView(this);

        themeAdapter = new ThemeAdapter(theme -> {
            Log.d(TAG, "Click on theme with title - " + theme.getTitle());
            // TODO добавить логику при выборе темы
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.themes_fragment, container, false);
        themeRecyclerView = view.findViewById(R.id.theme_recycler_view);
        themeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        themeRecyclerView.setAdapter(themeAdapter);

        presenter.onCreate(savedInstanceState);

        return view;
    }

    @Override
    public void showThemes(List<Theme> themes) {
        themeAdapter.setThemes(themes);
        themeAdapter.notifyDataSetChanged();
    }

    @Override
    public Context geContext() {
        return getActivity();
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        presenter.onStart();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();

        super.onDestroy();
    }
}
