package com.seed.service.userservice.impl;

import com.seed.entity.user.UserInfo;
import com.seed.service.RegisterMapperService;
import com.seed.service.userservice.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 22:07
 */
@Service
public class UserInfoServiceImpl extends RegisterMapperService implements IUserInfoService{


    /**
     * @Author Jack
     * @param userId 用户ID
     * @return UserInfo 返回一条用户信息
     */
    public UserInfo getOneUserByUserId(Integer userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }
}
