package com.alexandr.demin.gitfollower.mvp.di.modul;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Singleton
@Module
public class NavigationModule {

    private Cicerone<Router> cicerone;

    public NavigationModule() {
        cicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    public Router getRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @Singleton
    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }
}
