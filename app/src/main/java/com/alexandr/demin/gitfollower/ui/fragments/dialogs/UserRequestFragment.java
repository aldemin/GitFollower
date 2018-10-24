package com.alexandr.demin.gitfollower.ui.fragments.dialogs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.alexandr.demin.gitfollower.R;
import com.alexandr.demin.gitfollower.mvp.presenter.UserRequestFragmentPresenter;
import com.alexandr.demin.gitfollower.mvp.view.UserRequestFragmentView;
import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserRequestFragment extends MvpAppCompatDialogFragment implements UserRequestFragmentView {

    @InjectPresenter
    UserRequestFragmentPresenter presenter;

    @BindView(R.id.fr_user_request_username)
    TextInputEditText usernameText;
    @BindView(R.id.fr_user_request_load_btn)
    Button loadBtn;
    @BindView(R.id.fr_user_request_cancel_btn)
    Button cancelBtn;
    @BindView(R.id.fr_user_request_load_bar)
    ProgressBar loadBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_request, container, false);
        ButterKnife.bind(this, view);
        // TODO: 24.10.2018 add check textView
        cancelBtn.setOnClickListener(view1 -> presenter.onCancelBtnPressed());
        loadBtn.setOnClickListener(view1 -> presenter.onLoadBtnPressed(usernameText.getText().toString()));
        return view;
    }

    @Override
    public void showLoadBar() {
        loadBar.setVisibility(View.VISIBLE);
        loadBtn.setVisibility(View.GONE);
    }

    @Override
    public void showLoadButton() {
        loadBar.setVisibility(View.GONE);
        loadBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void cancelDialog() {
        getDialog().cancel();
    }

    @Override
    public void showLoadError() {
        // TODO: 24.10.2018  
    }

    @Override
    public void showUserInfo() {

    }
}
