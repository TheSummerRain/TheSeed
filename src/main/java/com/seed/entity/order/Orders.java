package com.seed.entity.order;

import java.util.Date;

public class Orders {
    private Integer orderid;

    private Integer userid;

    private String goodlist;

    private Integer paymoney;

    private Integer paystate;

    private Integer addrid;

    private String addrbackup;

    private Date createtime;

    private String orderno;

    private String wecatorderno;

    private Date finishtime;

    private String returnmsg;

    private String cartlist;

    private String detail;

    private String createip;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGoodlist() {
        return goodlist;
    }

    public void setGoodlist(String goodlist) {
        this.goodlist = goodlist == null ? null : goodlist.trim();
    }

    public Integer getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Integer paymoney) {
        this.paymoney = paymoney;
    }

    public Integer getPaystate() {
        return paystate;
    }

    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    public Integer getAddrid() {
        return addrid;
    }

    public void setAddrid(Integer addrid) {
        this.addrid = addrid;
    }

    public String getAddrbackup() {
        return addrbackup;
    }

    public void setAddrbackup(String addrbackup) {
        this.addrbackup = addrbackup == null ? null : addrbackup.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getWecatorderno() {
        return wecatorderno;
    }

    public void setWecatorderno(String wecatorderno) {
        this.wecatorderno = wecatorderno == null ? null : wecatorderno.trim();
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public String getReturnmsg() {
        return returnmsg;
    }

    public void setReturnmsg(String returnmsg) {
        this.returnmsg = returnmsg == null ? null : returnmsg.trim();
    }

    public String getCartlist() {
        return cartlist;
    }

    public void setCartlist(String cartlist) {
        this.cartlist = cartlist == null ? null : cartlist.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getCreateip() {
        return createip;
    }

    public void setCreateip(String createip) {
        this.createip = createip == null ? null : createip.trim();
    }
}