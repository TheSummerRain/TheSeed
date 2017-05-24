package com.seed.controller;

import com.seed.entity.banner.BannerInfo;
import com.seed.myUtil.PropertyManager;
import com.seed.myUtil.myWxMpServiceUtils;
import com.seed.service.bannerService.IBannerService;
import com.seed.service.bookservice.IBookInfoService;
import com.seed.service.goodsservice.IGoodsService;
import com.seed.service.userservice.IUserInfoService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Jack
 * @Des Seed种子基类的开头字母。如果文件名带有这个字母:必然是代表了一种基础的顶文件。
 * @Date 2017/3/17 18:08
 */
@Controller
public abstract class SeedBaseController {

    /*======================0、参数区域==============================================*/
    protected WxMpService wxMpService = myWxMpServiceUtils.wxMpServiceUtil;

    /*===================== 1、注册公用 service服务 =========================*/

    @Autowired
    protected IBookInfoService bookInfoService;

    @Autowired
    protected IUserInfoService userInfoService;

    @Autowired
    protected IBannerService bannerService;

    @Autowired
    protected IGoodsService goodsService;
    /*===================== 2、注册其他服务 =========================*/



    /*=======================3、功能区域====================================*/

    /**
     * @description 加载微信的基础配置信息。使得WxMpService生效。
     * @author Jack
     * @date 15:18
     */
    protected void loadWeixinConfig() {
   /*   WxMpInMemoryConfigStorage config  = new WxMpInMemoryConfigStorage();
        config.setAppId(PropertyManager.getProperty("wx_appid")); // 设置微信公众号的appid
        config.setSecret(PropertyManager.getProperty("wx_appsecret")); // 设置微信公众号的app corpSecret
        config.setToken(PropertyManager.getProperty("wx_token")); // 设置微信公众号的token
        config.setAesKey(PropertyManager.getProperty("wx_aeskey")); // 设置微信公众号的EncodingAESKey
        wxMpService.setWxMpConfigStorage(config);*/
    }


    /**
     * @return code
     * @description 获取授权的
     * @author Jack
     * @date 2017/5/7 20:11
     */
    protected final String getCode(HttpServletRequest request) {
        return request.getParameter("code");
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("......init Binder......");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }


    public List<BannerInfo> getBanner() {
        //从数据库查询，可以变成从redis里获取。
        List<BannerInfo> lb = bannerService.getBannerList();
        if (lb.size() < 0) {
            BannerInfo bf = new BannerInfo(); //获取默认banner图片地址
            bf.setBimgurl("/images/news/u236.jpg"); //默认图片随便set一张。730*350
            lb.add(bf);
        }
        return lb;
    }


}
