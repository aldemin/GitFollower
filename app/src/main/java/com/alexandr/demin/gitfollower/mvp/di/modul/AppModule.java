package com.alexandr.demin.gitfollower.mvp.di.modul;

import com.alexandr.demin.gitfollower.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    public App getApp() {
        return app;
    }
}
