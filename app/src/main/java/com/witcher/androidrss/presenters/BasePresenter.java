package com.witcher.androidrss.presenters;

import com.witcher.androidrss.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<T extends BaseView> implements LifePresenter {

    /**
     * Набор подписок.
     */
    protected CompositeDisposable compositeDisposable;

    /**
     * Представление, которое обслуживает презентер.
     */
    protected T view;

    public BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    public void setView(T view) {
        this.view = view;
    }

    /**
     * Добавить подписку.
     * @param disposable подписчик
     */
    public void addSubscription(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    /**
     * Отписать всех подписчиков.
     */
    public void unSubscriptions() {
        compositeDisposable.dispose();
    }

    @Override
    public void onDestroy() {
        unSubscriptions();
    }
}
