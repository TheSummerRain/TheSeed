package com.seed.service.userservice.impl;

import com.seed.dao.usermapper.ISeedAddrsMapper;
import com.seed.dao.usermapper.IWXUserInfoMapper;
import com.seed.entity.user.SeedAddrs;
import com.seed.entity.user.WXUserInfo;
import com.seed.service.userservice.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 22:07
 */

@Service("userService")
public class UserInfoServiceImpl implements IUserInfoService {


    @Autowired
    private IWXUserInfoMapper wxUserInfoMapper;  //idea，对mybatis需要插件支持，不用理会。

    @Autowired
    private ISeedAddrsMapper addrsMapper;


    /**
     * @param userId 用户ID
     * @return WXUserInfo 返回一条用户信息
     * @Author Jack
     */
    public WXUserInfo getOneUserByUserId(Integer userId) {
        return wxUserInfoMapper.selectByPrimaryKey(userId);
    }

    /**
     * @description 插入一条数据。
     * @author Jack
     * @param
     * @return
     * @date 2017/5/7 22:20
     */
    public int insertUserByObject(WXUserInfo wxUserInfo) {
        wxUserInfoMapper.insertSelective(wxUserInfo);
        return wxUserInfo.getUserid();
    }

    /**
     * @description 更新一条数据
     * @author Jack
     * @param
     * @return 
     * @date 2017/5/7 22:23
     */
    public int updateUserInfoByPk(WXUserInfo wxUserInfo) {
        wxUserInfoMapper.updateByPrimaryKeySelective(wxUserInfo);
        return wxUserInfo.getUserid();
    }


    public WXUserInfo getUserInfoByOpenId(String openId) {
        return wxUserInfoMapper.selectByOpenID(openId);
    }

    public int checkHasByOpenId(String openId) {
        return wxUserInfoMapper.checkByOpenId(openId);
    }

    public int insertAddrs(SeedAddrs seedAddrs) {
        return addrsMapper.insertSelective(seedAddrs);
    }

    public int updateAddrs(SeedAddrs seedAddrs) {
        return addrsMapper.updateByPrimaryKeySelective(seedAddrs);
    }

    public SeedAddrs searchAddrsByUserId(int userid) {
        return addrsMapper.searchAddrsByUserId(userid);
    }

    public List<SeedAddrs> getMyAddrListByUserId(Integer userid) {
        return addrsMapper.getMyAddrListByUserId(userid);
    }


    public void updateAddrDefaultByAddrId(Integer userid, int addrId) {
        addrsMapper.cleanAddrDefault(userid);
        addrsMapper.updateAddrDefaultByAddrId(addrId);
    }


}
