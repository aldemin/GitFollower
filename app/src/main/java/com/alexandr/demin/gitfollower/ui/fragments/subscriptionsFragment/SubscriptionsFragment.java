package com.alexandr.demin.gitfollower.ui.fragments.subscriptionsFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.alexandr.demin.gitfollower.R;
import com.alexandr.demin.gitfollower.mvp.presenter.SubscriptionsFragmentPresenter;
import com.alexandr.demin.gitfollower.mvp.view.SubscriptionsFragmentView;
import com.alexandr.demin.gitfollower.ui.fragments.dialogs.UserRequestFragment;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SubscriptionsFragment extends MvpAppCompatFragment implements SubscriptionsFragmentView {

    @InjectPresenter
    SubscriptionsFragmentPresenter presenter;

    @BindView(R.id.fr_subscriptions_empty)
    RelativeLayout emptyLayout;
    @BindView(R.id.fr_subscriptions_users_container)
    RelativeLayout usersLayout;
    @BindView(R.id.fr_subscriptions_users_list)
    RecyclerView usersList;
    @BindView(R.id.fr_subscriptions_fab)
    FloatingActionButton fabAddUser;

    private SubscriptionsFragmentAdapter adapter;

    @ProvidePresenter
    public SubscriptionsFragmentPresenter providePresenter() {
        return new SubscriptionsFragmentPresenter(AndroidSchedulers.mainThread());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriptions, container, false);
        ButterKnife.bind(this, view);

        adapter = new SubscriptionsFragmentAdapter(presenter.getListPresenter());
        usersList.setAdapter(adapter);
        usersList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        usersList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        fabAddUser.setOnClickListener(view1 -> {
            DialogFragment dialogFragment = new UserRequestFragment();
            dialogFragment.setCancelable(false);
            dialogFragment.show(getFragmentManager(),"dialog");
        });

        return view;
    }

    @Override
    public void updateRepoList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showListContainer() {
        emptyLayout.setVisibility(View.GONE);
        usersLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyContainer() {
        emptyLayout.setVisibility(View.VISIBLE);
        usersLayout.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        // TODO: 21.10.2018
    }

    @Override
    public void hideLoading() {
        // TODO: 21.10.2018
    }
}
