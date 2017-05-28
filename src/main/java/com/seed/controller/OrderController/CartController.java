package com.seed.controller.OrderController;

import com.seed.controller.SeedBaseController;
import com.seed.entity.user.WXUserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/5/28.
 * 2017/5/28 17:01
 */
@Controller
@RequestMapping("cart")
public class CartController extends SeedBaseController{

    @RequestMapping("toMyCartPage")
    public String toMyCartPage(HttpServletRequest request , Model model){

        WXUserInfo wf = getUserInfoFromSession(request);
        if(null == wf) return null;
        System.out.println("用户ID："+wf.getUserid());
        // 查询当前用户的购物车。
        List<HashMap<String ,Object>> mycart  = cartService.searchCartinfo(wf.getUserid());
        model.addAttribute("mycart",mycart);

        return "orders/myCart";
    }


}
