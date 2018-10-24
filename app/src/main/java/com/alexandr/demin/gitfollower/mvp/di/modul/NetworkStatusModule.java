package com.alexandr.demin.gitfollower.mvp.di.modul;

import com.alexandr.demin.gitfollower.App;
import com.alexandr.demin.gitfollower.utils.NetworkStatus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class NetworkStatusModule {

    @Provides
    @Singleton
    public NetworkStatus getNetworkStatus(App app) {
        return new NetworkStatus(app);
    }

}
