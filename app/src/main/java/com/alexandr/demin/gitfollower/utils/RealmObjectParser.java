package com.alexandr.demin.gitfollower.utils;

import com.alexandr.demin.gitfollower.mvp.model.entity.GitCommit;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitFile;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitRepository;
import com.alexandr.demin.gitfollower.mvp.model.entity.GitUser;
import com.alexandr.demin.gitfollower.mvp.model.entity.realm.RealmGitCommit;
import com.alexandr.demin.gitfollower.mvp.model.entity.realm.RealmGitFile;
import com.alexandr.demin.gitfollower.mvp.model.entity.realm.RealmGitRepository;
import com.alexandr.demin.gitfollower.mvp.model.entity.realm.RealmGitUser;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class RealmObjectParser {

    public GitUser parseToGitUser(RealmGitUser realmGitUser) {
        GitUser gitUser = new GitUser();

        gitUser.setId(realmGitUser.getId());
        gitUser.setNodeId(realmGitUser.getNodeId());
        gitUser.setAvatarUrl(realmGitUser.getAvatarUrl());
        gitUser.setLastUpdate(realmGitUser.getLastUpdate());
        gitUser.setLogin(realmGitUser.getLogin());
        gitUser.setRepositories(parseToGitRepositories(realmGitUser.getRepositories()));

        return gitUser;
    }

    public RealmGitUser parseToRealmGitUser(GitUser gitUser) {
        RealmGitUser realmGitUser = new RealmGitUser();

        realmGitUser.setId(gitUser.getId());
        realmGitUser.setNodeId(gitUser.getNodeId());
        realmGitUser.setAvatarUrl(gitUser.getAvatarUrl());
        realmGitUser.setLastUpdate(gitUser.getLastUpdate());
        realmGitUser.setLogin(gitUser.getLogin());
        realmGitUser.setRepositories(parseToRealmGitRepositories(gitUser.getRepositories()));

        return realmGitUser;
    }

    private List<GitRepository> parseToGitRepositories(List<RealmGitRepository> repositories) {
        List<GitRepository> gitRepositories = new ArrayList<>();
        for (RealmGitRepository repository : repositories) {
            GitRepository gitRepository = new GitRepository();

            gitRepository.setId(repository.getId());
            gitRepository.setName(repository.getName());
            gitRepository.setNodeId(repository.getNodeId());
            gitRepository.setCreatedAt(repository.getCreatedAt());
            gitRepository.setPushedAt(repository.getPushedAt());
            gitRepository.setUpdatedAt(repository.getUpdatedAt());
            gitRepository.setCommits(parseToGitCommits(repository.getCommits()));

            gitRepositories.add(gitRepository);
        }
        return gitRepositories;
    }

    private RealmList<RealmGitRepository> parseToRealmGitRepositories(List<GitRepository> repositories) {
        RealmList<RealmGitRepository> realmGitRepositories = new RealmList<>();
        for (GitRepository repository : repositories) {
            RealmGitRepository realmGitRepository = new RealmGitRepository();

            realmGitRepository.setId(repository.getId());
            realmGitRepository.setName(repository.getName());
            realmGitRepository.setNodeId(repository.getNodeId());
            realmGitRepository.setCreatedAt(repository.getCreatedAt());
            realmGitRepository.setPushedAt(repository.getPushedAt());
            realmGitRepository.setUpdatedAt(repository.getUpdatedAt());
            realmGitRepository.setCommits(parseToRealmGitCommits(repository.getCommits()));

            realmGitRepositories.add(realmGitRepository);
        }
        return realmGitRepositories;
    }

    private List<GitCommit> parseToGitCommits(List<RealmGitCommit> commits) {
        List<GitCommit> gitCommits = new ArrayList<>();
        for (RealmGitCommit commit : commits) {
            GitCommit gitCommit = new GitCommit();

            gitCommit.setSha(commit.getSha());
            gitCommit.setMessage(commit.getMessage());
            gitCommit.setNodeId(commit.getNodeId());
            gitCommit.setPatch(commit.getPatch());
            gitCommit.setFiles(parseToGitFiles(commit.getFiles()));

            gitCommits.add(gitCommit);
        }
        return gitCommits;
    }

    private RealmList<RealmGitCommit> parseToRealmGitCommits(List<GitCommit> commits) {
        RealmList<RealmGitCommit> realmGitCommits = new RealmList<>();
        for (GitCommit commit : commits) {
            RealmGitCommit realmGitCommit = new RealmGitCommit();

            realmGitCommit.setSha(commit.getSha());
            realmGitCommit.setMessage(commit.getMessage());
            realmGitCommit.setNodeId(commit.getNodeId());
            realmGitCommit.setPatch(commit.getPatch());
            realmGitCommit.setFiles(parseToRealmGitFiles(commit.getFiles()));

            realmGitCommits.add(realmGitCommit);
        }
        return realmGitCommits;
    }

    private List<GitFile> parseToGitFiles(List<RealmGitFile> files) {
        List<GitFile> gitFiles = new ArrayList<>();
        for (RealmGitFile file : files) {
            GitFile gitFile = new GitFile();

            gitFile.setAdditions(file.getAdditions());
            gitFile.setChanges(file.getChanges());
            gitFile.setDeletions(file.getDeletions());
            gitFile.setFilename(file.getFilename());
            gitFile.setPatch(file.getPatch());
            gitFile.setSha(file.getSha());
            gitFile.setStatus(file.getStatus());

            gitFiles.add(gitFile);
        }
        return gitFiles;
    }

    private RealmList<RealmGitFile> parseToRealmGitFiles(List<GitFile> files) {
        RealmList<RealmGitFile> realmGitFiles = new RealmList<>();
        for (GitFile file : files) {
            RealmGitFile realmGitFile = new RealmGitFile();

            realmGitFile.setAdditions(file.getAdditions());
            realmGitFile.setChanges(file.getChanges());
            realmGitFile.setDeletions(file.getDeletions());
            realmGitFile.setFilename(file.getFilename());
            realmGitFile.setPatch(file.getPatch());
            realmGitFile.setSha(file.getSha());
            realmGitFile.setStatus(file.getStatus());

            realmGitFiles.add(realmGitFile);
        }
        return realmGitFiles;
    }

}
