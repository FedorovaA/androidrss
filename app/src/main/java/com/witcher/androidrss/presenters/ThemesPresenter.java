package com.witcher.androidrss.presenters;

import android.os.Bundle;
import android.util.Log;

import com.witcher.androidrss.RSSApplication;
import com.witcher.androidrss.model.ThemesModel;
import com.witcher.androidrss.view.ThemesListView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ThemesPresenter extends BasePresenter<ThemesListView> {

    private static final String TAG = ThemesPresenter.class.getName();

    @Inject
    protected ThemesModel themesModel;

    public ThemesPresenter() {
        RSSApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onCreate(Bundle saveInstance) {
        Disposable disposable = themesModel.getAllThemes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> view.showThemes(list),
                        e -> Log.e(TAG, "error load themes"));
        addSubscription(disposable);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
