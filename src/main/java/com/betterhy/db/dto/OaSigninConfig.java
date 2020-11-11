package com.betterhy.db.dto;

import java.util.Date;

public class OaSigninConfig {
    private Integer deptId;

    private String longitude;

    private String latitude;

    private Integer signinRange;

    private String onTime;

    private String offTime;

    private Date createTime;

    private Date updateTime;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getSigninRange() {
        return signinRange;
    }

    public void setSigninRange(Integer signinRange) {
        this.signinRange = signinRange;
    }

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime == null ? null : onTime.trim();
    }

    public String getOffTime() {
        return offTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime == null ? null : offTime.trim();
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