package com.seed.service.userservice;


import com.seed.entity.user.WXUserInfo;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 22:02
 */
public interface IUserInfoService{
    WXUserInfo getOneUserByUserId(Integer userId);

    int insertUserByObject(WXUserInfo wxUserInfo);

    int updateUserInfoByPk(WXUserInfo wxUserInfo);


    /**
     * @description 根据用户openid获取一条用户的数据。
     * @author Jack
     * @param openId 用户openid
     * @return  WXUserInfo
     * @date 2017/5/7 22:34
     */
    WXUserInfo getUserInfoByOpenId(String openId);

    /**
     * @description 根据openid判断数据是否存在
     * @author Jack
     * @param openId 用户openid
     * @return int 0=不存在；1=存在；>1错误结果
     * @date 2017/5/7 22:35
     */
    int checkHasByOpenId(String openId);

}
