package com.seed.controller;

import com.seed.myUtil.PropertyManager;
import com.seed.service.bookservice.IBookInfoService;
import com.seed.service.userservice.IUserInfoService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author Jack
 * @Des Seed种子基类的开头字母。如果文件名带有这个字母:必然是代表了一种基础的顶文件。
 * @Date 2017/3/17 18:08
 */
@Controller
public abstract class SeedBaseController {

    /*======================0、参数区域==============================================*/
    protected WxMpInMemoryConfigStorage config;
    protected WxMpService wxMpService = new WxMpServiceImpl();

    /*===================== 1、注册公用 service服务 =========================*/

    @Autowired
    protected IBookInfoService bookInfoService;

    @Autowired
    protected IUserInfoService userInfoService;

    /*===================== 2、注册其他服务 =========================*/



    /*=======================3、功能区域====================================*/
    /**
     * @description 加载微信的基础配置信息。使得WxMpService生效。
     * @author Jack
     * @date 15:18
     */
    protected void loadWeixinConfig(){

        config = new WxMpInMemoryConfigStorage();
        config.setAppId(PropertyManager.getProperty("wx_appid")); // 设置微信公众号的appid
        config.setSecret(PropertyManager.getProperty("wx_appsecret")); // 设置微信公众号的app corpSecret
        config.setToken(PropertyManager.getProperty("wx_token")); // 设置微信公众号的token
        config.setAesKey(PropertyManager.getProperty("wx_aeskey")); // 设置微信公众号的EncodingAESKey
        wxMpService.setWxMpConfigStorage(config);

    }







}
