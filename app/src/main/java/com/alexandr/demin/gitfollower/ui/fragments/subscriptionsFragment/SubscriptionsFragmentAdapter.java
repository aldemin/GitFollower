package com.alexandr.demin.gitfollower.ui.fragments.subscriptionsFragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alexandr.demin.gitfollower.R;
import com.alexandr.demin.gitfollower.mvp.presenter.SubscriptionsFragmentPresenter;
import com.alexandr.demin.gitfollower.mvp.view.SubscriptionsFragmentHolderView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubscriptionsFragmentAdapter extends  RecyclerView.Adapter<SubscriptionsFragmentAdapter.ViewHolder>{

    private SubscriptionsFragmentPresenter.SubscriptionsListPresenter presenter;

    public SubscriptionsFragmentAdapter(SubscriptionsFragmentPresenter.SubscriptionsListPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.iter_git_user, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        presenter.bindRepoListRow(i, viewHolder);
    }

    @Override
    public int getItemCount() {
        return presenter.getRepoCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements SubscriptionsFragmentHolderView {

        @BindView(R.id.item_user_name)
        TextView nameView;
        @BindView(R.id.item_user_avatar)
        ImageView avatarView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            // TODO: 21.10.2018 add listener
        }

        @Override
        public void setAvatar(String avatarUrl) {
            // TODO: 21.10.2018 add avatar loader
        }

        @Override
        public void setName(String name) {
            nameView.setText(name);
        }
    }

}
