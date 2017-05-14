package com.seed.entity.user;


import com.seed.myUtil.DateUtils;

public class WXUserInfo extends BaseUserInfo {

    //微信方用户基础信息

    //微信OpernID
    private String wxOpenid;
    //微信昵称
    private String wxNickName;
    //微信头像地址
    private String wxHeadimgurl;
    //性别
    private Integer wxSex;
    //微信数据-省份
    private String wxProvince;
    //微信数据-城市
    private String wxCity;
    //微信数据-乡镇
    private String wxCountry;
    //微信 Unionid.
    private String wxUnionid;



    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim();
    }

    public String getWxHeadimgurl() {
        return wxHeadimgurl;
    }

    public void setWxHeadimgurl(String wxHeadimgurl) {
        this.wxHeadimgurl = wxHeadimgurl == null ? null : wxHeadimgurl.trim();
    }

    public Integer getWxSex() {
        return wxSex;
    }

    public void setWxSex(Integer wxSex) {
        this.wxSex = wxSex;
    }

    public String getWxProvince() {
        return wxProvince;
    }

    public void setWxProvince(String wxProvince) {
        this.wxProvince = wxProvince == null ? null : wxProvince.trim();
    }

    public String getWxCity() {
        return wxCity;
    }

    public void setWxCity(String wxCity) {
        this.wxCity = wxCity == null ? null : wxCity.trim();
    }

    public String getWxCountry() {
        return wxCountry;
    }

    public void setWxCountry(String wxCountry) {
        this.wxCountry = wxCountry == null ? null : wxCountry.trim();
    }

    public String getWxUnionid() {
        return wxUnionid;
    }

    public void setWxUnionid(String wxUnionid) {
        this.wxUnionid = wxUnionid == null ? null : wxUnionid.trim();
    }

    //重写
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("对象："+this.getClass().getName()).append("\n");
        sb.append("{ userId = ").append(getUserid()).append("\n");
        sb.append("nickname = ").append(getNickName()).append("\n");
        sb.append("mobile = ").append(getMobile()).append("\n");
        sb.append("birth = ").append(DateUtils.getStringDate(getBirth())).append("\n");
        sb.append("createtime = ").append(DateUtils.getStringDate(getCreatetime())).append("\n");
        sb.append("lasttime = ").append(DateUtils.getStringDate(getLasttime())).append("\n");
        sb.append("remark = ").append(getRemark()).append("\n");

        sb.append("wxOpenid = ").append(getWxOpenid()).append("\n");
        sb.append("wxNickName = ").append(getWxNickName()).append("\n");
        sb.append("wxHeadimgurl = ").append(getWxHeadimgurl()).append("\n");
        sb.append("wxSex = ").append(getWxSex()).append("\n");
        sb.append("wxProvince = ").append(getWxProvince()).append("\n");
        sb.append("wxCity = ").append(getWxCity()).append("\n");
        sb.append("wxCountry = ").append(getWxCountry()).append("\n");
        sb.append("wxUnionid = ").append(getWxUnionid()+" }").append("\n");
        return sb.toString();
    }



}