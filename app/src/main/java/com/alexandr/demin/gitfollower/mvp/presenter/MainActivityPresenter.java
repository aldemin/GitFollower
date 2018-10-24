package com.alexandr.demin.gitfollower.mvp.presenter;

import com.alexandr.demin.gitfollower.App;
import com.alexandr.demin.gitfollower.ui.Screens;
import com.alexandr.demin.gitfollower.mvp.model.api.GitApiHolder;
import com.alexandr.demin.gitfollower.mvp.view.MainActivityView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {

    @Inject
    GitApiHolder api;

    @Inject
    Router router;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        App.getApp().getAppComponent().inject(this);
        router.navigateTo(new Screens.SubscriptionsFragmentScreen());
    }

/*    @SuppressLint("CheckResult")
    public void loadUser(String username) {
        // TODO: 20.10.2018 android scheduler
        api.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(innerUser -> {
                    GitUser user = innerUser;
                    api.getUserRepos(user.getLogin())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(gitRepositories -> {
                                List<GitRepository> repositories = gitRepositories;
                                user.setRepositories(repositories);
                                getViewState().showUser(user);
                            });
                });
    }*/
}
