package com.alexandr.demin.gitfollower.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GitCommit {

    @SerializedName("sha")
    @Expose
    private int sha;
    @SerializedName("nodeId")
    @Expose
    private String nodeId;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("patch")
    @Expose
    private String patch;
    @SerializedName("files")
    @Expose
    private List<GitFile> files;

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

    public List<GitFile> getFiles() {
        return files;
    }

    public void setFiles(List<GitFile> files) {
        this.files = files;
    }
}
