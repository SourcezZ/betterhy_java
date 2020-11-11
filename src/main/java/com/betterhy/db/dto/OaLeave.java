package com.betterhy.db.dto;

import java.util.Date;

public class OaLeave {
    private Long leaveId;

    private Integer userId;

    private String username;

    private Date leaveBeginDate;

    private Date leaveEndDate;

    private Integer beginDateType;

    private Integer endDateType;

    private String remark;

    private Integer authStatus;

    private Date applyTime;

    private Date createTime;

    private Date updateTime;

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
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

    public Date getLeaveBeginDate() {
        return leaveBeginDate;
    }

    public void setLeaveBeginDate(Date leaveBeginDate) {
        this.leaveBeginDate = leaveBeginDate;
    }

    public Date getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(Date leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public Integer getBeginDateType() {
        return beginDateType;
    }

    public void setBeginDateType(Integer beginDateType) {
        this.beginDateType = beginDateType;
    }

    public Integer getEndDateType() {
        return endDateType;
    }

    public void setEndDateType(Integer endDateType) {
        this.endDateType = endDateType;
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