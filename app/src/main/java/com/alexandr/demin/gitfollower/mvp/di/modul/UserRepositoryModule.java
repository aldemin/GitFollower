package com.alexandr.demin.gitfollower.mvp.di.modul;

import com.alexandr.demin.gitfollower.mvp.model.repository.UserRepository;
import com.alexandr.demin.gitfollower.utils.RealmObjectParser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = RealmObjectParserModule.class)
@Singleton
public class UserRepositoryModule {

    @Provides
    @Singleton
    public UserRepository getUserRepository(RealmObjectParser parser) {
        return new UserRepository(parser);
    }

}
