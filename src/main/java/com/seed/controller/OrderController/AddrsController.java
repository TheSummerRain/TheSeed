package com.seed.controller.OrderController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by summer on 2017/6/7.
 * 2017/6/7 21:32
 */
@Controller
@RequestMapping("addrs")
public class AddrsController {


    @RequestMapping("toaddrs")
    public String toAddrPage(HttpServletRequest request){

        return "addrs/useraddrs";
    }

}
