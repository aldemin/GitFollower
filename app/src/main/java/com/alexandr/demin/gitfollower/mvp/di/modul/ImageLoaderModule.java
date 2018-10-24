package com.alexandr.demin.gitfollower.mvp.di.modul;

import com.alexandr.demin.gitfollower.mvp.model.loader.ImageLoader;
import com.alexandr.demin.gitfollower.utils.NetworkStatus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class ImageLoaderModule {

    @Provides
    @Singleton
    public ImageLoader getImageLoader(NetworkStatus networkStatus) {
        return new ImageLoader(networkStatus);
    }

}
