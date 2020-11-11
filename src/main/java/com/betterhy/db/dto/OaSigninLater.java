package com.betterhy.db.dto;

import java.util.Date;

public class OaSigninLater {
    private Long signinLaterId;

    private Integer userId;

    private String username;

    private Date signinLaterDate;

    private Integer dateType;

    private String remark;

    private Integer authStatus;

    private Date applyTime;

    private Date createTime;

    private Date updateTime;

    public Long getSigninLaterId() {
        return signinLaterId;
    }

    public void setSigninLaterId(Long signinLaterId) {
        this.signinLaterId = signinLaterId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getSigninLaterDate() {
        return signinLaterDate;
    }

    public void setSigninLaterDate(Date signinLaterDate) {
        this.signinLaterDate = signinLaterDate;
    }

    public Integer getDateType() {
        return dateType;
    }

    public void setDateType(Integer dateType) {
        this.dateType = dateType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        this.authStatus = authStatus;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}