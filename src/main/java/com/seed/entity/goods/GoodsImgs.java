package com.seed.entity.goods;

public class GoodsImgs {

    private Integer picid;

    private Integer gdid;

    private Integer odnum; //同一个商品的 众多图片，如何排序？按照数字从大到小。0-999

    private String imgurl;

    private String imgname;

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public Integer getGdid() {
        return gdid;
    }

    public void setGdid(Integer gdid) {
        this.gdid = gdid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname == null ? null : imgname.trim();
    }

    public Integer getOdnum() {
        return odnum;
    }

    public void setOdnum(Integer odnum) {
        this.odnum = odnum;
    }
}