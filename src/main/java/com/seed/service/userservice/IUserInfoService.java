package com.seed.service.userservice;


import com.seed.entity.user.WXUserInfo;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 22:02
 */
public interface IUserInfoService{
    WXUserInfo getOneUserByUserId(Integer userId);

}
