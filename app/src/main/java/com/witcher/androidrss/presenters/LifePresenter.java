package com.witcher.androidrss.presenters;

import android.os.Bundle;

public interface LifePresenter {

    /**
     * Вызывается при вызове метода onCreate фрагмента.
     * (для предварительной инициализации компонентов)
     * @param saveInstance данные для сохранения состояния
     */
    void onCreate(Bundle saveInstance);

    /**
     * Вызывается при вызове метода onStart фрагмента.
     * (для запуска каких-либо сервисов)
     */
    void onStart();

    /**
     * Вызывается при вызове метода onStop фрагмента.
     * (для остановки каких-либо сервисов)
     */
    void onStop();

    /**
     * Вызывается при вызове метода onDestroy фрагмента.
     * (для освобождения памяти)
     */
    void onDestroy();
}
