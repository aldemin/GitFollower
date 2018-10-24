package com.alexandr.demin.gitfollower.mvp.presenter;

import com.alexandr.demin.gitfollower.App;
import com.alexandr.demin.gitfollower.mvp.model.api.GitApiHolder;
import com.alexandr.demin.gitfollower.mvp.view.UserRequestFragmentView;
import com.alexandr.demin.gitfollower.ui.Screens;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class UserRequestFragmentPresenter extends MvpPresenter<UserRequestFragmentView> {

    @Inject
    GitApiHolder api;
    @Inject
    @Named("mainThread")
    Scheduler scheduler;
    @Inject
    Router router;

    Disposable disposable;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        App.getApp().getAppComponent().inject(this);
    }

    public void onCancelBtnPressed() {
        if (disposable == null) {
            getViewState().cancelDialog();
        } else if (disposable.isDisposed()) {
            getViewState().cancelDialog();
        } else {
            disposable.dispose();
            getViewState().showLoadButton();
        }
    }

    public void onLoadBtnPressed(String username) {
        getViewState().showLoadBar();
        disposable = api.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler)
                .subscribe(gitUser -> {
                            //getViewState().showLoadButton();
                            getViewState().cancelDialog();
                            router.navigateTo(new Screens.UserInfoFragmentScreen(gitUser));
                        }
                        , throwable -> {
                            getViewState().showLoadError();
                            getViewState().showLoadButton();
                        });
    }

}
