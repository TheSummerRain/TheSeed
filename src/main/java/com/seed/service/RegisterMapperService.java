package com.seed.service;

import com.seed.dao.bookmapper.IBookInfoMapper;
import com.seed.dao.usermapper.IUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Jack
 * @Des   注册mapper接口的服务类。属于seed种子服务，所以放在这里。
 * @Date 2017/3/17 19:36
 */
@Service
public class RegisterMapperService {

    /*====================== 1、 公共 Mapper 注册区 ======================*/
    @Autowired
    protected IBookInfoMapper bookInfoMapper;

    @Autowired
    protected IUserInfoMapper userInfoMapper;



    /*最好别做其他事情*/


}
