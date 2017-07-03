package com.seed.controller.wxController;

import com.github.binarywang.wxpay.bean.WxPayOrderNotifyResponse;
import com.github.binarywang.wxpay.bean.result.WxPayBaseResult;
import com.github.binarywang.wxpay.bean.result.WxPayOrderNotifyResult;
import com.seed.controller.SeedBaseController;
import com.seed.myUtil.ToStringUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by summer on 2017/6/18.
 * 2017/6/18 13:51
 */
@Controller
@RequestMapping("wxpay")
public class WxPayController extends SeedBaseController{

    protected static final Logger log = LoggerFactory.getLogger(WxPayController.class);

    //微信支付返回

    @RequestMapping("/notify")
    public String notifyUrl(HttpServletRequest request, HttpServletResponse response){

        System.out.println(" ==========   [微信返回处理结果]    ===============");
        try {
            String xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            WxPayOrderNotifyResult result = getWxPayService().getOrderNotifyResult(xmlResult);
            System.out.println(ToStringUtils.fieldToString(new StringBuffer(),request));
            // 结果正确
            String orderId = result.getOutTradeNo();
            String tradeNo = result.getTransactionId();
            String totalFee = WxPayBaseResult.feeToYuan(result.getTotalFee());

            System.out.println("订单ID == "+orderId);
            System.out.println("tradeNo =="+tradeNo);
            System.out.println("totalFee == "+totalFee);
            System.out.println("   ======= [微信处理成功] =============");
            //自己处理订单的业务逻辑，需要判断订单是否已经支付过，否则可能会重复调用
            return WxPayOrderNotifyResponse.success("处理成功!");
        } catch (Exception e) {
            log.error("微信回调结果异常,异常原因{}", e.getMessage());
            return WxPayOrderNotifyResponse.fail(e.getMessage());
        }


    }


}
