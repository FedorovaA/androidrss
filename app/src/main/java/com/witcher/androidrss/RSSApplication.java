package com.witcher.androidrss;

import android.app.Application;

import com.witcher.androidrss.di.component.ApplicationComponent;
import com.witcher.androidrss.di.component.DaggerApplicationComponent;
import com.witcher.androidrss.di.module.ApplicationModule;

public class RSSApplication extends Application {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initializeInjector();
    }

    /**
     * Инициализация Dagger
     * (чтобы класс DaggerApplicationComponent появился нужно выполнить сборку проекта)
     */
    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }
}
