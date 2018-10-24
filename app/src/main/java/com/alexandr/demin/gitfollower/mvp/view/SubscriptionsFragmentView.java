package com.alexandr.demin.gitfollower.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface SubscriptionsFragmentView extends MvpView {

    void updateRepoList();

    void showListContainer();

    void showEmptyContainer();

    void showLoading();

    void hideLoading();

}
