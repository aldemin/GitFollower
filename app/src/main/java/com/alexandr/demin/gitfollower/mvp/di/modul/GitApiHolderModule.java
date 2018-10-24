package com.alexandr.demin.gitfollower.mvp.di.modul;

import com.alexandr.demin.gitfollower.mvp.model.api.GitApiHolder;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@Singleton
public class GitApiHolderModule {

    @Provides
    @Singleton
    public GitApiHolder getGitApi(@Named("baseUrl") String baseUrl,
                                  RxJava2CallAdapterFactory adapter,
                                  GsonConverterFactory gsonConverter) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(adapter)
                .addConverterFactory(gsonConverter)
                .build()
                .create(GitApiHolder.class);
    }

    @Provides
    @Singleton
    @Named("baseUrl")
    public String getBaseUrl() {
        return "https://api.github.com/";
    }

    @Singleton
    @Provides
    public RxJava2CallAdapterFactory getAdapter() {
        return RxJava2CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    public GsonConverterFactory getGson() {
        return GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create());
    }

}
