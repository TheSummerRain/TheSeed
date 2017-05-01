package com.seed.controller.userController;

import com.seed.controller.SeedBaseController;
import com.seed.entity.user.BaseUserInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping("/getOneUser")
    public String getOneUserInfo(Model model){

        BaseUserInfo uf = userInfoService.getOneUserByUserId(1);

        System.out.println("执行controller........"+uf.getBirth());
        model.addAttribute("userInfo",uf);
        return "/userinfo/userCenter";
    }

    //用来处理日期 的办法之一。
 /*   @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }*/
}
