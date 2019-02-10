package com.witcher.androidrss.di.component;

import com.witcher.androidrss.di.module.ApplicationModule;
import com.witcher.androidrss.model.ThemesModel;
import com.witcher.androidrss.presenters.ThemesPresenter;
import com.witcher.androidrss.ui.fragments.ThemesFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(ThemesModel themesModel);
    void inject(ThemesPresenter presenter);
    void inject(ThemesFragment fragment);
}
