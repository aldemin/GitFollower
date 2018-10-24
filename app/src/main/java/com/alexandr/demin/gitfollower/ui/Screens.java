package com.alexandr.demin.gitfollower.ui;

import android.support.v4.app.Fragment;

import com.alexandr.demin.gitfollower.mvp.model.entity.GitUser;
import com.alexandr.demin.gitfollower.ui.fragments.CommitInfoFragment;
import com.alexandr.demin.gitfollower.ui.fragments.UserInfoFragment;
import com.alexandr.demin.gitfollower.ui.fragments.dialogs.UserRequestFragment;
import com.alexandr.demin.gitfollower.ui.fragments.subscriptionsFragment.SubscriptionsFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static final class SubscriptionsFragmentScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new SubscriptionsFragment();
        }
    }

    public static final class UserRequestFragmentScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new UserRequestFragment();
        }
    }

    public static final class UserInfoFragmentScreen extends SupportAppScreen {

        private GitUser user;

        public UserInfoFragmentScreen(GitUser user) {
            this.user = user;
        }

        @Override
        public Fragment getFragment() {
            return new UserInfoFragment();
        }
    }

    public static final class CommitInfoFragmentScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return new CommitInfoFragment();
        }
    }

}
