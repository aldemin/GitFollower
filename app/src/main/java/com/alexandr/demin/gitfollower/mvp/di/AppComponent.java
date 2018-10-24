package com.alexandr.demin.gitfollower.mvp.di;

import com.alexandr.demin.gitfollower.mvp.di.modul.AndroidSchedulerModule;
import com.alexandr.demin.gitfollower.mvp.di.modul.AppModule;
import com.alexandr.demin.gitfollower.mvp.di.modul.GitApiHolderModule;
import com.alexandr.demin.gitfollower.mvp.di.modul.ImageLoaderModule;
import com.alexandr.demin.gitfollower.mvp.di.modul.NavigationModule;
import com.alexandr.demin.gitfollower.mvp.di.modul.NetworkStatusModule;
import com.alexandr.demin.gitfollower.mvp.di.modul.UserRepositoryModule;
import com.alexandr.demin.gitfollower.mvp.presenter.MainActivityPresenter;
import com.alexandr.demin.gitfollower.mvp.presenter.SubscriptionsFragmentPresenter;
import com.alexandr.demin.gitfollower.mvp.presenter.UserRequestFragmentPresenter;
import com.alexandr.demin.gitfollower.ui.activity.MainActivity;
import com.alexandr.demin.gitfollower.ui.fragments.subscriptionsFragment.SubscriptionsFragment;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.android.schedulers.AndroidSchedulers;

@Singleton
@Component(modules = {
        AppModule.class,
        NavigationModule.class,
        GitApiHolderModule.class,
        NetworkStatusModule.class,
        UserRepositoryModule.class,
        ImageLoaderModule.class,
        AndroidSchedulerModule.class
})
public interface AppComponent {

    void inject(MainActivityPresenter presenter);

    void inject(SubscriptionsFragmentPresenter presenter);

    void inject(UserRequestFragmentPresenter presenter);

    void inject(MainActivity activity);

    void inject(SubscriptionsFragment fragment);

}
