package com.alexandr.demin.gitfollower.mvp.model.loader;

import com.alexandr.demin.gitfollower.mvp.model.api.GitApiHolder;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitCommit;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitRepository;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitUser;
import com.alexandr.demin.gitfollower.utils.Constants;
import com.alexandr.demin.gitfollower.utils.NetworkStatus;

import java.io.IOException;
import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserLoader {

    private NetworkStatus networkStatus;
    private GitApiHolder api;

    private GitUser gitUser;
    private List<GitRepository> gitRepositories;

    public UserLoader(GitApiHolder api, NetworkStatus networkStatus) {
        this.networkStatus = networkStatus;
        this.api = api;
    }

    public void loadUser(String username) {
        if (networkStatus.isOffline()) {
            //emitter.onError(new RuntimeException(Constants.NETWORK_UNREACHABLE));
        }

        api.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    //emitter.onSuccess(gitUser);
                });
    }

/*    private Single<GitUser> loadUserFromApi(String username) throws IOException {
        return api.getUser(username);
    }

    private Single<List<GitRepository>> loadRepositoriesFromApi(String username) {
        return api.getUserRepos(username);
    }

    private Single<List<GitCommit>> loadCommitsFromApi(String username, String repositoryName) {
        return api.getRepoCommits(username, repositoryName);
    }*/

}
