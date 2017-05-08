package com.seed.controller.userController;

import com.seed.controller.SeedBaseController;
import com.seed.entity.user.BaseUserInfo;
import com.seed.entity.user.WXUserInfo;
import com.seed.mydict.ImportDict;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 22:01
 */
@Controller
@RequestMapping("/user")
public class UserInfoController extends SeedBaseController{


    //测试
    @RequestMapping(value="/getOneUser",method={RequestMethod.GET,RequestMethod.POST})
    public String getOneUserInfo(HttpServletRequest request, Model model) throws WxErrorException {

        WXUserInfo uf = (WXUserInfo)request.getSession().getAttribute(ImportDict.USER_IN_SESSION);
        if(null == uf){
            return "/error/error";
        }
        System.out.println("执行controller........"+uf.getBirth());
        model.addAttribute("userInfo",uf);
        return "/userinfo/userCenter";
    }



}
