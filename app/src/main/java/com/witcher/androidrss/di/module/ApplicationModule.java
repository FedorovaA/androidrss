package com.witcher.androidrss.di.module;

import com.witcher.androidrss.api.IRestApi;
import com.witcher.androidrss.model.ThemesModel;
import com.witcher.androidrss.presenters.ThemesPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.witcher.androidrss.util.Constants.SERVER_URL;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    @Provides
    @Singleton
    public IRestApi provideRestApi(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(IRestApi.class);
    }

    @Provides
    @Singleton
    public ThemesPresenter themesPresenter() {
        return new ThemesPresenter();
    }

    @Provides
    @Singleton
    public ThemesModel themesModel() {
        return new ThemesModel();
    }
}
