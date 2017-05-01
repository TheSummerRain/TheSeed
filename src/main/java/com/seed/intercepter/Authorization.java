package com.seed.intercepter;


import com.seed.entity.user.BaseUserInfo;
import com.seed.entity.user.WXUserInfo;
import com.seed.mydict.ImportDict;
import com.seed.service.userservice.IUserInfoService;
import org.apache.http.client.ClientProtocolException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jack
 * @description 微信授权，用户管理拦截器。
 * @date 2017/5/1 20:54
 */
public class Authorization implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {

        //防止中文乱码。
        response.setCharacterEncoding("UTF-8");

        System.out.println("[ 拦截器Authorization ] .. do preHandle() .....");

        //从微信服务器发起的动作。
        System.out.println("[ 微信 signature ]："+request.getParameter("signature"));
        System.out.println("[ 微信 timestamp ]："+request.getParameter("timestamp"));
        System.out.println("[ 微信 nonce ]："+request.getParameter("nonce"));
        if (request.getParameter("signature") != null && request.getParameter("timestamp") != null && request.getParameter("nonce") != null) {
            return true;//这里要确定下，是不是微信的所有请求都带有这个。
        }


        String url = request.getRequestURI();
        System.out.println("请求的url地址信息..."+url);
        System.out.println("请求地址来源："+request.getRemoteAddr());

        String checkSource = request.getHeader("user-agent").toLowerCase();
        System.out.println("请求中的头信息，检测是否含有微信发起的请求的标示... "+checkSource);

		if (!checkSource.toLowerCase().contains("micromessenger")) {
            //头信息里不存在：micromessenger，说明不是微信发起的请求。中断请求。
           // response.setCharacterEncoding("UTF-8");
            response.getWriter().println("非法请求~");
            return true;
        }

        //查找session是否有值。
		BaseUserInfo userSession = (WXUserInfo) request.getSession().getAttribute(ImportDict.USER_IN_SESSION);
		if (userSession != null) {
		    //如果在涉及用户信息变更的地方，update了session，这里就不需要重新获取用户数据，更新session .
			return true;
		}




        //数据服务
        ApplicationContext context = WebApplicationContextUtils
                .getWebApplicationContext(request.getSession()
                        .getServletContext());

        IUserInfoService userInfoService = (IUserInfoService) context
                .getBean("userInfoService");


        //【授权更新】用户基础数据。
       // WXUserInfo userInfo = newAuth(request, response, request.getSession().getId());
		/*if(userInfo != null){
			if (userInfoService.new_upateUserInfo(userInfo) == 1) {
				request.getSession().setAttribute(Cts.USER_IN_SESSION,userInfoService
						.new_GetUserInfoByOpenId(userInfo.getOpenid()));                    //从新的数据表中获取数据。
			}
		}*/

        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
                           Object arg2, ModelAndView mv) throws Exception {

        System.out.println("[ 拦截器Authorization ] ..do  postHandle() .....");

        if (mv != null) {
            System.out.println("全局路径：" + request.getContextPath());
            mv.addObject("ctx", request.getContextPath());
        }
        String param = null;
        String basePath = null;
        if (request.getQueryString() == null) {
            basePath = request.getRequestURL().toString();
        } else {
            param = request.getQueryString();
            basePath = request.getRequestURL().toString() + "?" + param;
        }
        System.out.println("BasePath = "+basePath);

		/*WxJsConfig wc = WeixinUtil.getJsSdkConfig(basePath);
		if(null != wc && null !=mv){
			mv.addObject("wxConfig",wc);
		}*/
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {

        System.out.println("【Authorization】 .. do afterCompletion() ...");
    }



    //-------------------------------------------------------------------------------------
    //新的授权代码：12.12 ;只增不改
    @SuppressWarnings("unused")
    private WXUserInfo newAuth(HttpServletRequest request, HttpServletResponse response, String key)
            throws ClientProtocolException, IOException {
		
		/*String code = request.getParameter("_c_o_d_e_");
		if(code==null){
			return null;
		}

		WXUserInfo user =null;
		AccessToken token = null;
		token = TokenProxy.getOuthToken(code,key);

		if (token != null && token.getOpenid()!=null) {
			String url=WxConfig.USERINFO_URL.replace("ACCESS_TOKEN", token.getToken()).replace("OPENID",
					token.getOpenid());
			
			JSONObject userInfo = HttpUtil.doGet(url);
			//https://api.weixin.qq.com/sns/userinfo?access_token=dL83AQEsp90A19EKQEhlZjkguEACNiryrUMOCqbX3K3wKIFCmPEjT8oOGEqz2ArWONCmnA7-Y5jUCzscpjaRmOGXFhmVVEOlHCgrL7Yjk8o&openid=oxoAruMi_Gv22n3YDDzCQFHs4P60&lang=zh_CN
			
			if (userInfo != null) {
				
				user=new NewUserInfo();
				//用户的地址信息这里暂时没有收录。
					
				if (userInfo.get("sex") != null) {
					user.setSex(userInfo.getInt("sex"));
				}
				if (userInfo.get("headimgurl") != null) {
					user.setOssheadpic(userInfo.getString("headimgurl"));
				}
				if (userInfo.get("nickname") != null) {
					user.setNickname(userInfo.getString("nickname"));
				}
				if (userInfo.get("openid") != null) {
					user.setOpenid(userInfo.getString("openid"));
				}
				if (userInfo.get("unionid") != null) {
					user.setWxunionid(userInfo.getString("unionid"));
				}
				user.setLastlandingtime(new Date());  //更新最后一次登录时间。
			}
		}*/
        return null;
    }


}

