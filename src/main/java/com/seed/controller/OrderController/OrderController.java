package com.seed.controller.OrderController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.seed.controller.SeedBaseController;
import com.seed.entity.order.Cart;
import com.seed.entity.order.Orders;
import com.seed.entity.user.SeedAddrs;
import com.seed.entity.user.WXUserInfo;
import com.seed.myUtil.AmountUtils;
import com.seed.myUtil.DateUtils;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by summer on 2017/5/28.
 * 2017/5/28 17:00
 */
@Controller
@RequestMapping("order")
public class OrderController extends SeedBaseController {

    //创建订单，并等待微信支付。
    @RequestMapping("createOrder")
    @Transactional
    public String createOrder(HttpServletRequest request, Model model) throws WxErrorException, JsonProcessingException {

        //一：杜绝重复下单。创建日期倒序，查询当前用户，在最近三分钟内重复下单3次就禁止在下单。给状态值。
        //"select count(1) from order表 where 用户ID=6 and left(createtime,10)='到分钟' order by createtime limit 3"
        //二：不是重复下单，则生产订单。
        //三：生产微信预支付信息，携带信息跳转。
        String addrid = request.getParameter("param2");
        if (null == addrid || !addrid.endsWith("")) return null;

        //买家留言没有获取。
        WXUserInfo userInfo = getUserInfoFromSession(request);
        if (null == userInfo) {
            System.out.println("userInfo = null");
            return null;
        }

        //金钱，元为单位。
        String param = request.getParameter("param");
        if (null == param || !param.endsWith("")) return null;

        //1、生成订单。
        SeedAddrs adr = userInfoService.getResAddrsByAddrId(Integer.valueOf(addrid));
        List<Cart> lc = cartService.getCartListByUserId(userInfo.getUserid());

        //出入订单表
        Orders orders = getNewOrder(param, adr, lc, userInfo.getUserid());
        int orderid = orderService.InsertNewOrder(orders);
        System.out.println("=================orderid=====" + orderid);

        //接口数据组装
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
        orderRequest.setBody("商品购买");
        orderRequest.setOutTradeNo(orders.getOrderno());

        orderRequest.setTotalFee(Integer.valueOf(AmountUtils.changeY2F(param)));//元转成分
        orderRequest.setOpenid(userInfo.getWxOpenid());
        orderRequest.setSpbillCreateIp(request.getRemoteAddr());

        /*  【这里要注意，永远别用着端代码】
        WxPayUnifiedOrderResult wxresult = getWxPayService().unifiedOrder(orderRequest);
        System.out.println("[对比数据库]微信预下单返回值：prepayId === "+wxresult.getPrepayId());
        //不要用这个，会跟下面的方法里的 预下单重复。导致产生两次预下单。
       */

        Map<String, String> payInfo = getWxPayService().getPayInfo(orderRequest);
        model.addAttribute("wxpay", payInfo);

        return "orders/createOrder";
    }

    //拼装orders数据
    public Orders getNewOrder(String param, SeedAddrs sa, List<Cart> lsc, int userid) throws JsonProcessingException {

        Orders od = new Orders();
        od.setAddrid(sa.getId());
        od.setAddrbackup(sa.getRecname() + "|" + sa.getRecmobile() + "|" + sa.getProvince() + "|" + sa.getCity() + "|" + sa.getCounty() + "|" + sa.getDetailaddrs());
        od.setUserid(userid);
        od.setCreatetime(new Date());
        Map<Integer, Integer> goodsInfo = new HashMap<Integer, Integer>();
        for (Cart cart : lsc) {
            goodsInfo.put(cart.getGoodsid(), cart.getAmount());
        }
        //参考http://blog.csdn.net/jitianxia68/article/details/52304531
        //map-->json工具；jackson包
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(goodsInfo));
        //  od.setCartlist("1,2,3,4"); //购物车列表(后面直接执行清空当前用户的购物车)
        od.setGoodlist(mapper.writeValueAsString(goodsInfo)); //商品列表。从购物车获取。

        od.setOrderno(DateUtils.getOrderNo(userid, "OD")); // OD - 订单
        od.setPaystate(0);
        od.setPaymoney(Integer.valueOf(AmountUtils.changeY2F(param))); //转换为分。统一用分表示
        return od;
    }


}
