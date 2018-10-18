package com.alexandr.demin.gitfollower.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitFile {
    @SerializedName("sha")
    @Expose
    private String sha;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("additions")
    @Expose
    private Integer additions;
    @SerializedName("deletions")
    @Expose
    private Integer deletions;
    @SerializedName("changes")
    @Expose
    private Integer changes;
    @SerializedName("patch")
    @Expose
    private String patch;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAdditions() {
        return additions;
    }

    public void setAdditions(Integer additions) {
        this.additions = additions;
    }

    public Integer getDeletions() {
        return deletions;
    }

    public void setDeletions(Integer deletions) {
        this.deletions = deletions;
    }

    public Integer getChanges() {
        return changes;
    }

    public void setChanges(Integer changes) {
        this.changes = changes;
    }

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }
}
