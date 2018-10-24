package com.alexandr.demin.gitfollower.ui.activity;

import android.os.Bundle;

import com.alexandr.demin.gitfollower.App;
import com.alexandr.demin.gitfollower.R;
import com.alexandr.demin.gitfollower.mvp.presenter.MainActivityPresenter;
import com.alexandr.demin.gitfollower.mvp.view.MainActivityView;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainActivityView {

    @InjectPresenter
    MainActivityPresenter presenter;

    @Inject
    NavigatorHolder navigatorHolder;

    private Navigator navigator = new SupportAppNavigator(this, R.id.ac_main_container);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getApp().getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

}
