package com.seed.myUtil;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

/**
 * Created by summer on 2017/5/7.
 * 2017/5/7 22:54
 */
public class myWxMpServiceUtils {

    public static  WxMpService wxMpServiceUtil ;

    static {
        WxMpInMemoryConfigStorage configUtil  = new WxMpInMemoryConfigStorage();
        configUtil.setAppId(PropertyManager.getProperty("wx_appid")); // 设置微信公众号的appid
        configUtil.setSecret(PropertyManager.getProperty("wx_appsecret")); // 设置微信公众号的app corpSecret
        configUtil.setToken(PropertyManager.getProperty("wx_token")); // 设置微信公众号的token
        configUtil.setAesKey(PropertyManager.getProperty("wx_aeskey")); // 设置微信公众号的EncodingAESKey
        wxMpServiceUtil = new WxMpServiceImpl();
        wxMpServiceUtil.setWxMpConfigStorage(configUtil);
    }



}
