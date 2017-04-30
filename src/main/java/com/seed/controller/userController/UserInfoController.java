package com.seed.controller.userController;

import com.seed.controller.SeedBaseController;
import com.seed.entity.user.BaseUserInfo;
import com.seed.entity.user.WXUserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Jack
 * @Des
 * @Date 2017/3/17 22:01
 */
@Controller
@RequestMapping("/user")
public class UserInfoController extends SeedBaseController{


    @RequestMapping("/getOneUser")
    public String getOneUserInfo(Model model){

        WXUserInfo uf = userInfoService.getOneUserByUserId(1);
        model.addAttribute("userInfo",uf);
        return "/userinfo/userCenter";
    }



}
