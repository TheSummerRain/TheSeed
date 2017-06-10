package com.seed.controller.OrderController;

import com.seed.controller.SeedBaseController;
import com.seed.entity.user.SeedAddrs;
import com.seed.entity.user.WXUserInfo;
import com.seed.myUtil.PropertyManager;
import com.seed.mydict.ImportDict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by summer on 2017/6/7.
 * 2017/6/7 21:32
 */
@Controller
@RequestMapping("addrs")
public class AddrsController extends SeedBaseController{

    @RequestMapping("toaddrs")
    public String toAddrPage(HttpServletRequest request){
        return "addrs/useraddrs";
    }

    @RequestMapping(value = "istAddr",method = {RequestMethod.POST,RequestMethod.GET})
    public String toInsertAddr(HttpServletRequest request,Model model){
        WXUserInfo uf = (WXUserInfo)request.getSession().getAttribute(ImportDict.USER_IN_SESSION);
        if(null == uf){
            return "/error/error";
        }

        String name = request.getParameter("username");
        String mobile = request.getParameter("mobile");
        String detail = request.getParameter("xiangxi");

        System.out.println(name+"  "+mobile+"  "+detail);

        SeedAddrs seedAddrs = new SeedAddrs();
        seedAddrs.setUserid(uf.getUserid());
        seedAddrs.setCounty("林州市");
        seedAddrs.setCity("安阳市");
        seedAddrs.setProvince("河南省");
        seedAddrs.setDetailaddrs(detail);
        seedAddrs.setCreatetime(new Date());
        seedAddrs.setRecname(name);
        seedAddrs.setRecmobile(mobile);

        try{
            userInfoService.insertAddrs(seedAddrs);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<SeedAddrs> myAddrList = userInfoService.getMyAddrListByUserId(uf.getUserid());
        model.addAttribute("addList",myAddrList);

        return "addrs/addrList";
    }



    //我的收获地址列表
    @RequestMapping("myAddrList")
    public String myAddrList(HttpServletRequest request, Model model){
        WXUserInfo uf = (WXUserInfo)request.getSession().getAttribute(ImportDict.USER_IN_SESSION);
        if(null == uf){
            return "/error/error";
        }

        List<SeedAddrs> myAddrList = userInfoService.getMyAddrListByUserId(uf.getUserid());
        model.addAttribute("addList",myAddrList);

        return "addrs/addrList";
    }



    /**
     * @description 根据地址表ID，修改某个用户的默认值地址。
     * @author Jack
     * @param
     * @return
     * @date 2017/6/10 17:17
     */
    @RequestMapping(value = "upAddrDef",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateAddrDefaultByAddrId(HttpServletRequest request,Model model){
        WXUserInfo uf = (WXUserInfo)request.getSession().getAttribute(ImportDict.USER_IN_SESSION);
        if(null == uf){
            return "/error/error";
        }
        int addrId = Integer.valueOf(request.getParameter("id")).intValue();
        System.out.println("======"+addrId);
        try{
            //先修改用户的 所有状态为：非默认。
            userInfoService.updateAddrDefaultByAddrId(uf.getUserid(),addrId);
        }catch (Exception e){
            return "/error/error";
        }


        return "redirect:/cart/toMyCartPage";
    }


}
