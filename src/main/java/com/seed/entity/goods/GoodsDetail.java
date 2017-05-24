package com.seed.entity.goods;

import java.util.Date;

public class GoodsDetail extends SeedGoods{
    private Integer dtid;

    private Integer gdid;

    private Date createtime;

    private String detail;
    private String pramdetail;


    public Integer getDtid() {
        return dtid;
    }

    public void setDtid(Integer dtid) {
        this.dtid = dtid;
    }

    public Integer getGdid() {
        return gdid;
    }

    public void setGdid(Integer gdid) {
        this.gdid = gdid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPramdetail() {
        return pramdetail;
    }

    public void setPramdetail(String pramdetail) {
        this.pramdetail = pramdetail;
    }
}