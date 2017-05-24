package com.seed.dao.usermapper;

import com.seed.entity.user.WXUserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface IWXUserInfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(WXUserInfo record);

    int insertSelective(WXUserInfo record);

    WXUserInfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(WXUserInfo record);

    int updateByPrimaryKey(WXUserInfo record);

    //add by jack ,date 2017-5-7
    /**
     * @description  根据openid，查询一条数据
     * @author Jack
     * @date 2017/5/7 22:32
     */
    @Select(" select * from seed_user where wx_openid=#{openId} limit 1")
    @ResultMap("BaseResultMap")
    WXUserInfo selectByOpenID(@Param("openId")String OpenId);

    /**
     * @description 根据openid，检查数据是否已经存在。
     * @author Jack
     * @date 2017/5/7 22:32
     */
    @Select("select count(1) from seed_user where wx_openid=#{openId}")
    int checkByOpenId(@Param("openId")String OpenId);







}