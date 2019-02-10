package com.witcher.androidrss.model;

import com.witcher.androidrss.RSSApplication;
import com.witcher.androidrss.api.IRestApi;
import com.witcher.androidrss.api.data.ResultResponse;
import com.witcher.androidrss.domain.Theme;
import com.witcher.androidrss.util.ThemeConverter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ThemesModel {

    @Inject
    protected IRestApi restApi;

    public ThemesModel() {
        RSSApplication.getApplicationComponent().inject(this);
    }

    public Observable<List<Theme>> getAllThemes() {
//        List<Theme> themes = new ArrayList<>(); // TODO нужно удалить, использовал для тестирования recyclerView без сервера
//        for (long i = 0; i < 50; ++i) {
//            themes.add(new Theme(i, "test" + i));
//        }
//        return Observable.fromArray(themes);
        return restApi.getAllThemes()
                .filter(response -> response.getMeta().getStatus() == ResultResponse.Status.OK)
                .map(ResultResponse::getData)
                .map(ThemeConverter::convertToListDomain);

    }
}
