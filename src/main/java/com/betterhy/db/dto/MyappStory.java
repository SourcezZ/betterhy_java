package com.betterhy.db.dto;

import java.util.Date;

public class MyappStory {
    private Integer storyId;

    private String title;

    private String content;

    private Date addTime;

    private String commitFlag;

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getCommitFlag() {
        return commitFlag;
    }

    public void setCommitFlag(String commitFlag) {
        this.commitFlag = commitFlag == null ? null : commitFlag.trim();
    }
}