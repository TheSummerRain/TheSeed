package com.seed.entity.banner;

import java.util.Date;

import java.util.Date;

public class BannerInfo {
    private Integer bid;

    private String bimgurl;

    private Integer linkid;

    private Integer sort;

    //是否处于活动状态。true的时候才会在前台显示。
    private Boolean isalive;

    private Date createtime;

    private String remark;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBimgurl() {
        return bimgurl;
    }

    public void setBimgurl(String bimgurl) {
        this.bimgurl = bimgurl == null ? null : bimgurl.trim();
    }

    public Integer getLinkid() {
        return linkid;
    }

    public void setLinkid(Integer linkid) {
        this.linkid = linkid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsalive() {
        return isalive;
    }

    public void setIsalive(Boolean isalive) {
        this.isalive = isalive;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}