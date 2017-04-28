package com.seed.controller.wxController;

import com.seed.myUtil.PropertyManager;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack
 * @description 这里直接main方法执行。记得在微信端“启用”开发者模式。否则不能正常使用。
 * @date 21:34
 */
public class MenuManager {

    //官方文档地址：https://mp.weixin.qq.com/wiki
    public static void main(String[] args) {

        //获取配置信息。
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(PropertyManager.getProperty("wx_appid")); // 设置微信公众号的appid
        config.setSecret(PropertyManager.getProperty("wx_appsecret")); // 设置微信公众号的app corpSecret
        config.setToken(PropertyManager.getProperty("wx_token")); // 设置微信公众号的token
        config.setAesKey(PropertyManager.getProperty("wx_aeskey")); // 设置微信公众号的EncodingAESKey
        wxMpService.setWxMpConfigStorage(config);

        //声明菜单
        WxMenu wxMenu = new WxMenu();
        List<WxMenuButton> buttons = new ArrayList<WxMenuButton>();
        //1、第一菜单，只有一个主按钮（名字不能超过4个字符，数量1~3个）
        buttons.add(getNewButton("最新上", "view", "http://www.lzyj666.com/seed/book/toBookInfoPage"));
        buttons.add(getNewButton("正在测试", "view", "http://www.lzyj666.com/seed/book/toBookInfoPage"));

        //2、有二级菜单的情况。
        //2.1、新建一个一级菜单。
        WxMenuButton baseButton = getNewButton("用户信息", "view", "http://www.lzyj666.com/seed/user/getOneUser");
        //2.2、新建一个子菜单数组，准备存放菜单。
        List<WxMenuButton> subButtons = new ArrayList();
        subButtons.add(getNewButton("充值", "view", "http://www.lzyj666.com/seed/user/getOneUser"));
        subButtons.add(getNewButton("续费", "view", "http://www.lzyj666.com/seed/user/getOneUser"));

        //2.3、把子菜单列表set到某个主菜单的：subButtons属性。
        baseButton.setSubButtons(subButtons);
        //2.4、把主菜单添加到主菜单列表。
        buttons.add(baseButton);

        //3、把按钮列表添加到：菜单对象中。
        wxMenu.setButtons(buttons);
        System.out.println("===" + wxMenu.toJson());

        try {
            //调用创建菜单服务。
            wxMpService.getMenuService().menuCreate(wxMenu);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name 按钮名称
     * @param type 按钮类型，详见腾讯官方API：https://mp.weixin.qq.com/wiki 自定义菜单创建接口；view表示网页类型，click表示点击类型，miniprogram表示小程序类型
     * @param url  view、miniprogram类型必须填写。
     * @return WxMenuButton
     * @description 获取一个button对象。
     */
    public static WxMenuButton getNewButton(String name, String type, String url) {
        WxMenuButton button = new WxMenuButton();
        button.setName(name);
        button.setType(type);
        button.setUrl(url);
        return button;
    }


}
