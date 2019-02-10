package com.witcher.androidrss.util;

import com.witcher.androidrss.api.data.ThemeData;
import com.witcher.androidrss.domain.Theme;

import java.util.ArrayList;
import java.util.List;


public final class ThemeConverter {

    private ThemeConverter() {
    }

    /**
     * Преобразование DTO в доменный объект.
     * @param themeData объект DTO
     * @return доменный объект
     */
    public static Theme convertToDomain(ThemeData themeData) {
        return new Theme(themeData.getId(), themeData.getTitle());
    }

    /**
     * Преобразование списка DTO в список доменных объектов.
     * @param dataList список DTO
     * @return список доменных объектов
     */
    public static List<Theme> convertToListDomain(List<ThemeData> dataList) {
        final List<Theme> themes = new ArrayList<>();
        for (ThemeData themeData : dataList) {
            themes.add(convertToDomain(themeData));
        }
        return themes;
    }
}
