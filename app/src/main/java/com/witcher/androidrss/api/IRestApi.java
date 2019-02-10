package com.witcher.androidrss.api;

import com.witcher.androidrss.api.data.NewsData;
import com.witcher.androidrss.api.data.ResultResponse;
import com.witcher.androidrss.api.data.ThemeData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRestApi {

    @GET("clients/themes")
    Observable<ResultResponse<List<ThemeData>>> getAllThemes();

    @GET("client/{id}")
    Observable<ResultResponse<ThemeData>> getThemeById(@Path("id") long themeId);

    @GET("client/news/{id}")
    Observable<ResultResponse<NewsData>> getNewsById(@Path("id") long newsId);

    @GET("clients/news")
    Observable<ResultResponse<List<NewsData>>> getNewsByThemeIds(@Query("ids") List<Long> themeIds);

    @PUT("/{id}/preferences")
    Observable<ResultResponse<List<Long>>> updateUserPreferences(@Path("id") long userId, @Body List<Long> themeIds);
}
