package com.betterhy.db.dto;

import java.util.Date;

public class OaBusiness {
    private Long businessId;

    private Integer userId;

    private String username;

    private Date businessBeginDate;

    private Date businessEndDate;

    private Integer beginDateType;

    private Integer endDateType;

    private String businessPlace;

    private String remark;

    private Integer authStatus;

    private Date applyTime;

    private Date createTime;

    private Date updateTime;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
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

    public Date getBusinessBeginDate() {
        return businessBeginDate;
    }

    public void setBusinessBeginDate(Date businessBeginDate) {
        this.businessBeginDate = businessBeginDate;
    }

    public Date getBusinessEndDate() {
        return businessEndDate;
    }

    public void setBusinessEndDate(Date businessEndDate) {
        this.businessEndDate = businessEndDate;
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

    public String getBusinessPlace() {
        return businessPlace;
    }

    public void setBusinessPlace(String businessPlace) {
        this.businessPlace = businessPlace == null ? null : businessPlace.trim();
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