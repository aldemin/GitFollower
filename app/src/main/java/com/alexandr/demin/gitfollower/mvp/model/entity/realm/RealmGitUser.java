package com.alexandr.demin.gitfollower.mvp.model.entity.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmGitUser extends RealmObject {

    @PrimaryKey
    private String login;
    private Integer id;
    private String nodeId;
    private String avatarUrl;
    private String lastUpdate;

    private RealmList<RealmGitRepository> repositories;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public RealmList<RealmGitRepository> getRepositories() {
        return repositories;
    }

    public void setRepositories(RealmList<RealmGitRepository> repositories) {
        this.repositories = repositories;
    }
}
