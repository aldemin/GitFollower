package com.alexandr.demin.gitfollower.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alexandr.demin.gitfollower.R;
import com.arellomobile.mvp.MvpAppCompatFragment;

public class SubscriptionsFragment extends MvpAppCompatFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriptions, container, false);



        return view;
    }
}
