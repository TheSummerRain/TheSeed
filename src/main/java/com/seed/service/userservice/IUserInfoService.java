package com.seed.service.userservice;


import com.seed.entity.user.SeedAddrs;
import com.seed.entity.user.WXUserInfo;

import java.util.List;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 22:02
 */
public interface IUserInfoService {
    WXUserInfo getOneUserByUserId(Integer userId);

    int insertUserByObject(WXUserInfo wxUserInfo);

    int updateUserInfoByPk(WXUserInfo wxUserInfo);


    /**
     * @param openId 用户openid
     * @return WXUserInfo
     * @description 根据用户openid获取一条用户的数据。
     * @author Jack
     * @date 2017/5/7 22:34
     */
    WXUserInfo getUserInfoByOpenId(String openId);

    /**
     * @param openId 用户openid
     * @return int 0=不存在；1=存在；>1错误结果
     * @description 根据openid判断数据是否存在
     * @author Jack
     * @date 2017/5/7 22:35
     */
    int checkHasByOpenId(String openId);


    /**
     * @param
     * @return
     * @description 插入一条地址信息
     * @author Jack
     * @date 2017/6/10 12:45
     */
    int insertAddrs(SeedAddrs seedAddrs);

    /**
     * @param
     * @return
     * @description 更新一条地址信息。
     * @author Jack
     * @date 2017/6/10 12:46
     */
    int updateAddrs(SeedAddrs seedAddrs);

    /**
     * @description  根据UserId查询一条地址信息。
     * @author Jack
     * @param
     * @return 
     * @date 2017/6/10 12:53
     */
    SeedAddrs searchAddrsByUserId(int userid);

    /**
     * @description 根据useid查询我的地址列表
     * @author Jack
     * @param
     * @return 
     * @date 2017/6/10 16:27
     */
    List<SeedAddrs> getMyAddrListByUserId(Integer userid);

    /**
     * @description 更新默认状态。
     * @author Jack
     * @param
     * @return
     * @date 2017/6/10 17:28
     */
    void updateAddrDefaultByAddrId(Integer userid, int addrId);

    //根据用户选择的地址ID，获取地址信息。
    SeedAddrs getResAddrsByAddrId(int addrid);
}
