package com.seed.intercepter;



import com.seed.entity.user.WXUserInfo;
import org.apache.http.client.ClientProtocolException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authorization implements HandlerInterceptor  {

	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2, ModelAndView mv) throws Exception {
		if(mv!=null){
			System.out.println("====路径："+request.getContextPath());
			mv.addObject("ctx",request.getContextPath());
		}
		String param = null;
		String basePath=null;
		if(request.getQueryString()==null){
			 basePath = request.getRequestURL().toString();
		}else{
			param=request.getQueryString();
			basePath = request.getRequestURL().toString()+"?"+param;
		}
		/*WxJsConfig wc = WeixinUtil.getJsSdkConfig(basePath);
		if(null != wc && null !=mv){
			mv.addObject("wxConfig",wc);
		}*/
	}
	

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {

		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(request.getSession()
						.getServletContext());

		/*IUserInfoService userInfoService = (IUserInfoService) context
				.getBean("UserInfoService");*/
		
		String ua = request.getHeader("user-agent").toLowerCase();
		//从微信服务器发起的动作，会先调用一次这个方法，判断通不通。通了之后才会走下面的。
		if (request.getParameter("signature") != null && request.getParameter("timestamp") != null 	&& request.getParameter("nonce") != null) {
			return true;
		}
		
		//上线用这里
		/*if (ua.toLowerCase().indexOf("micromessenger") == -1 ) {
			return false;
		}*/
		
		//本地用这里
		if (ua.toLowerCase().indexOf("micromessenger") != 0 ) {
			System.out.println(".....no mobile request..........IP:..."+request.getMethod());
			request.getSession()
			.setAttribute(
					"userInfo", "");
			return true;
		}
		
		//查找session是否有值。
		/*NewUserInfo userSession = (NewUserInfo) request.getSession().getAttribute(Cts.USER_IN_SESSION);
		if (userSession != null) {
			return true;
		}*/
		
		//【授权更新】用户基础数据。
		WXUserInfo userInfo = newAuth(request,response,request.getSession().getId());
		/*if(userInfo != null){
			if (userInfoService.new_upateUserInfo(userInfo) == 1) {
				request.getSession().setAttribute(Cts.USER_IN_SESSION,userInfoService
						.new_GetUserInfoByOpenId(userInfo.getOpenid()));                    //从新的数据表中获取数据。
			}
		}*/
		
		return true;
	}
	
	
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

