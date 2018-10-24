package com.alexandr.demin.gitfollower.mvp.di.modul;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Module
public class AndroidSchedulerModule {

    @Provides
    @Named("mainThread")
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }

}
