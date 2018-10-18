package com.alexandr.demin.gitfollower.mvp.model.api;

import com.alexandr.demin.gitfollower.mvp.model.entity.GitCommit;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitRepository;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitUser;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitApiHolder {

    @GET("users/{user}")
    Single<GitUser> getUser(@Path("user") String login);

    @GET("users/{user}/repos")
    Single<List<GitRepository>> getUserRepos(@Path("user") String login);

    @GET("repos/{user}/{repository}/commits")
    Single<List<GitCommit>> getRepoCommits(@Path("user") String login, @Path("repository") String repository);

}
