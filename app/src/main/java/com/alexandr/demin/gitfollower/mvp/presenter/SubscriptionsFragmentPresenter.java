package com.alexandr.demin.gitfollower.mvp.presenter;

import android.annotation.SuppressLint;
import android.support.v4.app.DialogFragment;

import com.alexandr.demin.gitfollower.App;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitUser;
import com.alexandr.demin.gitfollower.mvp.model.repository.UserRepository;
import com.alexandr.demin.gitfollower.mvp.view.SubscriptionsFragmentHolderView;
import com.alexandr.demin.gitfollower.mvp.view.SubscriptionsFragmentView;
import com.alexandr.demin.gitfollower.ui.Screens;
import com.alexandr.demin.gitfollower.ui.fragments.dialogs.UserRequestFragment;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.Screen;

@InjectViewState
public class SubscriptionsFragmentPresenter extends MvpPresenter<SubscriptionsFragmentView> {

    @Inject
    UserRepository repository;

    @Inject
    Router router;

    private SubscriptionsListPresenter listPresenter = new SubscriptionsListPresenter();
    private List<GitUser> users = new ArrayList<>();
    private Scheduler mainScheduler;

    public SubscriptionsFragmentPresenter(Scheduler mainScheduler) {
        this.mainScheduler = mainScheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        App.getApp().getAppComponent().inject(SubscriptionsFragmentPresenter.this);
        writeUsers();
    }

    @SuppressLint("CheckResult")
    private void writeUsers() {
        getViewState().showLoading();
        repository.getAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(mainScheduler)
                .subscribe(userList -> {
                    users = userList;
                    if (users.size() == 0) {
                        getViewState().showEmptyContainer();
                    } else {
                        getViewState().showListContainer();
                        getViewState().updateRepoList();
                    }
                    getViewState().hideLoading();
                });

    }

    public SubscriptionsListPresenter getListPresenter() {
        return listPresenter;
    }

    public class SubscriptionsListPresenter {

        public void bindRepoListRow(int position, SubscriptionsFragmentHolderView view) {
            if (users != null) {
                GitUser user = users.get(position);
                if (user != null) {
                    view.setName(user.getLogin());
                    view.setAvatar(user.getAvatarUrl());
                }
            }
        }

        public int getRepoCount() {
            return users.size();
        }

    }
}
