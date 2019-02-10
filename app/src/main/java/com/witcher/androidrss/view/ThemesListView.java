package com.witcher.androidrss.view;

import com.witcher.androidrss.domain.Theme;

import java.util.List;

public interface ThemesListView extends BaseView {

    /**
     * Отобразить на экране темы.
     * @param themes список тем
     */
    void showThemes(List<Theme> themes);
}
