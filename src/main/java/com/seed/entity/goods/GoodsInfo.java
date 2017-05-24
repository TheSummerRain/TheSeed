package com.seed.entity.goods;

import java.util.Date;

public class GoodsInfo extends SeedGoods {

    //商品ID
    private Integer gdid;

    //顶级分类ID
    private Integer topid;
    //分类ID
    private Integer typeid;

    //规格关系ID：规格关系表
    private Integer sdrtid;

    //品牌ID
    private Integer brandid;

    //商品名称
    private String name;

    //商品图片集合，用json存储;或者string字符集合，用|表示多张图片。
    private String imgs;

    //商品简介；别超过200字最好
    private String intro;

    //图文内容表；详细介绍图文内容ID。分开吧。分流。
    private Integer dtid;

    //参数表：参数内容ID
    private Integer parmid;

    //点击量,前期可以不做这个
    private Integer pagepv;

    //原价（统一用分表示）
    private Integer price;

    //折扣价
    private Integer salesprice;

    //库存量，整数
    private Integer inventory;

    //实际销量
    private Integer realsales;

    //虚拟销量
    private Integer virtualsales;

    //商品状态0-创建；1-上架销售
    private Boolean gdstatus;
    //创建时间
    private Date createtime;
    //上架时间
    private Date pubtime;
    //下架时间
    private Date outtime;

    public Integer getGdid() {
        return gdid;
    }

    public void setGdid(Integer gdid) {
        this.gdid = gdid;
    }

    public Integer getTopid() {
        return topid;
    }

    public void setTopid(Integer topid) {
        this.topid = topid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getSdrtid() {
        return sdrtid;
    }

    public void setSdrtid(Integer sdrtid) {
        this.sdrtid = sdrtid;
    }

    public Integer getBrandid() {
        return brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getDtid() {
        return dtid;
    }

    public void setDtid(Integer dtid) {
        this.dtid = dtid;
    }

    public Integer getParmid() {
        return parmid;
    }

    public void setParmid(Integer parmid) {
        this.parmid = parmid;
    }

    public Integer getPagepv() {
        return pagepv;
    }

    public void setPagepv(Integer pagepv) {
        this.pagepv = pagepv;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(Integer salesprice) {
        this.salesprice = salesprice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getRealsales() {
        return realsales;
    }

    public void setRealsales(Integer realsales) {
        this.realsales = realsales;
    }

    public Integer getVirtualsales() {
        return virtualsales;
    }

    public void setVirtualsales(Integer virtualsales) {
        this.virtualsales = virtualsales;
    }

    public Boolean getGdstatus() {
        return gdstatus;
    }

    public void setGdstatus(Boolean gdstatus) {
        this.gdstatus = gdstatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }
}