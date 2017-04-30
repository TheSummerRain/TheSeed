package com.seed.entity.user;

import com.seed.entity.base.Seed;

import java.util.Date;

/**
 * 基础用户信息
 * 2017/4/30 23:50
 */
public class BaseUserInfo extends Seed {

    //用户ID
    private Integer userid;
    //用户昵称
    private String nickName;
    //用户手机号
    private String mobile;
    //出生年月
    private Date birth;
    //创建时间
    private Date createtime;
    //最后一次登陆时间
    private Date lasttime;
    //备注。
    private String remark;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


}
