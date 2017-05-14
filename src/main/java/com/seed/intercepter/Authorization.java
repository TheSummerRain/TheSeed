package com.seed.intercepter;

import com.seed.entity.user.WXUserInfo;
import com.seed.myUtil.myWxMpServiceUtils;
import com.seed.mydict.ImportDict;
import com.seed.service.userservice.IUserInfoService;
import com.seed.service.userservice.impl.UserInfoServiceImpl;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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

        //从微信服务器发起验证动作，需要这里。平时不会用到。
        System.out.println("[ 微信 signature ]：" + request.getParameter("signature"));
        System.out.println("[ 微信 timestamp ]：" + request.getParameter("timestamp"));
        System.out.println("[ 微信 nonce ]：" + request.getParameter("nonce"));
        if (request.getParameter("signature") != null && request.getParameter("timestamp") != null && request.getParameter("nonce") != null) {
            return true;
        }

        String url = request.getRequestURI();
        System.out.println("请求的url地址信息..." + url);
        System.out.println("请求地址来源：" + request.getRemoteAddr());

        String checkSource = request.getHeader("user-agent").toLowerCase();
        System.out.println("请求中的头信息，检测是否含有微信发起的请求的标示 : " + checkSource);

        if (!checkSource.toLowerCase().contains("micromessenger")) {
            //头信息里不存在：micromessenger，说明不是微信发起的请求。中断请求。{注意：微信配置验证，这里不会成功，比较特殊}
            response.getWriter().println("客户端异常请求，记录次数 +1 ");
            return false;
        }

        System.out.println("=============================");
        //查找session是否有值。
     /*   WXUserInfo userSession = (WXUserInfo) request.getSession().getAttribute(ImportDict.USER_IN_SESSION);
        if (userSession != null) {
            //如果在涉及用户信息变更的地方，update了session，这里就不需要重新获取用户数据，更新session .
            System.out.println("userSession 不为空.....");
            return true;
        }*/
        //session为空,授权获取数据,从新更新session。
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
        IUserInfoService userInfoService = (UserInfoServiceImpl) context
                .getBean("userService");

        WXUserInfo wxUserInfo = Auth(request, response);
        if (wxUserInfo != null) {
            //判断是否已经存在。存在则更新session.
            int chek = userInfoService.checkHasByOpenId(wxUserInfo.getWxOpenid());
            if (chek == 1) {
                request.getSession().setAttribute(ImportDict.USER_IN_SESSION, wxUserInfo);
                return true;
            }
            //如果不存在，则插入数据库，然后更新session。
            if (chek == 0) {
                userInfoService.insertUserByObject(wxUserInfo);
                request.getSession().setAttribute(ImportDict.USER_IN_SESSION, wxUserInfo);
                return true;
            }
            response.getWriter().println("更新session数据失败~");
            return false;
        } else {
            response.getWriter().println("授权失败~");
            return false;
        }


    }

    /**
     * @description 执行授权
     * @author Jack
     * @date 2017/5/7 22:45
     */
    private WXUserInfo Auth(HttpServletRequest request, HttpServletResponse response) throws WxErrorException {

        String code = request.getParameter("code");
        if (code == null) {
            return null;
        }
        System.out.println("code=" + code);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = myWxMpServiceUtils.wxMpServiceUtil.oauth2getAccessToken(code);
        System.out.println("refresh_token前:" + wxMpOAuth2AccessToken.getRefreshToken());
        WxMpUser wxMpUser = myWxMpServiceUtils.wxMpServiceUtil.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        System.out.println("======获取用户的基本信息如下：=========");
        System.out.println(wxMpUser.toString());
        System.out.println("==================================");

        if (wxMpUser == null) {
            return null;
        }
        WXUserInfo wu = new WXUserInfo();
        wu.setWxOpenid(wxMpUser.getOpenId());
        wu.setWxHeadimgurl(wxMpUser.getHeadImgUrl());
        wu.setWxUnionid(wxMpUser.getUnionId());
        wu.setWxNickName(wxMpUser.getNickname());
        wu.setCreatetime(new Date());
        wu.setWxSex(wxMpUser.getSexId());
        wu.setWxCity(wxMpUser.getCity());
        wu.setWxProvince(wxMpUser.getProvince());
        wu.setWxCountry(wxMpUser.getCountry());

        System.out.println("测试日期："+wu.getCreatetime());

        return wu;
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
        System.out.println("BasePath = " + basePath);

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


}

