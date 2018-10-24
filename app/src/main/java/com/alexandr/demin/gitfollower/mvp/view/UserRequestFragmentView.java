package com.alexandr.demin.gitfollower.mvp.view;

import com.arellomobile.mvp.MvpView;

public interface UserRequestFragmentView extends MvpView {
    void showLoadBar();
    void showLoadButton();
    void showLoadError();
    void showUserInfo();
    void cancelDialog();
}
