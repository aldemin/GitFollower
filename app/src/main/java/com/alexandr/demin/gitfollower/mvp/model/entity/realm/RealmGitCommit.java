package com.alexandr.demin.gitfollower.mvp.model.entity.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmGitCommit extends RealmObject {

    @PrimaryKey
    private int sha;
    private String nodeId;
    private String message;
    private String patch;

    private RealmList<RealmGitFile> files;

    public int getSha() {
        return sha;
    }

    public void setSha(int sha) {
        this.sha = sha;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public RealmList<RealmGitFile> getFiles() {
        return files;
    }

    public void setFiles(RealmList<RealmGitFile> files) {
        this.files = files;
    }
}
