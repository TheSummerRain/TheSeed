package com.seed.entity.user;

import java.util.Date;

public class SeedAddrs {
    private Integer id;

    private String province;

    private String city;

    private String county;

    private String detailaddrs;

    private String recname;

    private String recmobile;

    private Integer userid;

    private Boolean isdefault;
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getDetailaddrs() {
        return detailaddrs;
    }

    public void setDetailaddrs(String detailaddrs) {
        this.detailaddrs = detailaddrs == null ? null : detailaddrs.trim();
    }

    public String getRecname() {
        return recname;
    }

    public void setRecname(String recname) {
        this.recname = recname == null ? null : recname.trim();
    }

    public String getRecmobile() {
        return recmobile;
    }

    public void setRecmobile(String recmobile) {
        this.recmobile = recmobile == null ? null : recmobile.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}