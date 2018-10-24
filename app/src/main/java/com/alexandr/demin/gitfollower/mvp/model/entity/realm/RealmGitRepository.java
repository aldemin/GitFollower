package com.alexandr.demin.gitfollower.mvp.model.entity.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmGitRepository extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String nodeId;
    private String name;
    private String createdAt;
    private String updatedAt;
    private String pushedAt;

    private RealmList<RealmGitCommit> commits;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public RealmList<RealmGitCommit> getCommits() {
        return commits;
    }

    public void setCommits(RealmList<RealmGitCommit> commits) {
        this.commits = commits;
    }
}
