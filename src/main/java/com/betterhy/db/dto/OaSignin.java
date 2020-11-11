package com.betterhy.db.dto;

import java.util.Date;

public class OaSignin {
    private Long signinId;

    private Integer userId;

    private String username;

    private String latitude;

    private String longitude;

    private String signinPlace;

    private Date signinTime;

    private Integer signinStatus;

    private Integer signinType;

    private Date signinDate;

    private Long applyId;

    private Integer applyType;

    private Date createTime;

    private Date updateTime;

    public Long getSigninId() {
        return signinId;
    }

    public void setSigninId(Long signinId) {
        this.signinId = signinId;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getSigninPlace() {
        return signinPlace;
    }

    public void setSigninPlace(String signinPlace) {
        this.signinPlace = signinPlace == null ? null : signinPlace.trim();
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public Integer getSigninStatus() {
        return signinStatus;
    }

    public void setSigninStatus(Integer signinStatus) {
        this.signinStatus = signinStatus;
    }

    public Integer getSigninType() {
        return signinType;
    }

    public void setSigninType(Integer signinType) {
        this.signinType = signinType;
    }

    public Date getSigninDate() {
        return signinDate;
    }

    public void setSigninDate(Date signinDate) {
        this.signinDate = signinDate;
    }

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Integer getApplyType() {
        return applyType;
    }

    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
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