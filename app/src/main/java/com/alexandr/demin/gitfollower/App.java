package com.alexandr.demin.gitfollower;

import android.app.Application;

import com.alexandr.demin.gitfollower.mvp.di.AppComponent;
import com.alexandr.demin.gitfollower.mvp.di.DaggerAppComponent;
import com.alexandr.demin.gitfollower.mvp.di.modul.AppModule;

import io.realm.Realm;

public class App extends Application {

    private static App app;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Realm.init(this);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static App getApp() {
        return app;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
