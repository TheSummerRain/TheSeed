package com.seed.service.userservice.impl;

import com.seed.dao.usermapper.IWXUserInfoMapper;
import com.seed.entity.user.BaseUserInfo;
import com.seed.entity.user.WXUserInfo;
import com.seed.service.userservice.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 22:07
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {


    @Autowired
    private IWXUserInfoMapper wxUserInfoMapper;  //idea，对mybatis需要插件支持，不用理会。

    /**
     * @param userId 用户ID
     * @return WXUserInfo 返回一条用户信息
     * @Author Jack
     */
    public WXUserInfo getOneUserByUserId(Integer userId) {
        return wxUserInfoMapper.selectByPrimaryKey(userId);
    }
}
