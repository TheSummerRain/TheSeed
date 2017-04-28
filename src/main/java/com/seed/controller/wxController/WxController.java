package com.seed.controller.wxController;

import com.seed.controller.SeedBaseController;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by summer on 2017/4/27.
 * 2017/4/27 13:06
 */
@Controller
@RequestMapping("wxController")
public class WxController extends SeedBaseController {

    /**
     * @description 微信接入验证函数。
     * @author Jack
     * @date 13:14
     */
    @RequestMapping(method = RequestMethod.GET)
    public void handshake(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        System.out.println(request.toString());


        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");

        PrintWriter out = response.getWriter();

        //装载微信基础配置。
        loadWeixinConfig();
        //开发者通过检验signature对请求进行校验。若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            // 消息签名不正确，说明不是公众平台发过来的消息
            out.println("非法请求");
            return;
        }

        // 随机字符串
        String echostr = request.getParameter("echostr");
        if (StringUtils.isNotBlank(echostr)) {
            // 说明是一个仅仅用来验证的请求，回显echostr
            response.getWriter().println(echostr);
            return;
        }

        String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type")) ?
                "raw" :
                request.getParameter("encrypt_type");
        System.out.println("encryptType:"+encryptType);

    }





}
