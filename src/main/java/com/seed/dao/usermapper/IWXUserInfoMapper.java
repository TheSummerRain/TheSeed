package com.seed.dao.usermapper;

import com.seed.entity.user.WXUserInfo;

public interface IWXUserInfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(WXUserInfo record);

    int insertSelective(WXUserInfo record);

    WXUserInfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(WXUserInfo record);

    int updateByPrimaryKey(WXUserInfo record);
}