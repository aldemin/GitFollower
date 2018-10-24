package com.alexandr.demin.gitfollower.mvp.di.modul;

import com.alexandr.demin.gitfollower.utils.RealmObjectParser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class RealmObjectParserModule {

    @Provides
    @Singleton
    public RealmObjectParser getRealmObjectParser() {
        return new RealmObjectParser();
    }

}
