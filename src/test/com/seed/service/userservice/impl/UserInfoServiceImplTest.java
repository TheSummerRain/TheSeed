package com.seed.service.userservice.impl;

import com.seed.entity.user.BaseUserInfo;
import com.seed.entity.user.WXUserInfo;
import com.seed.service.userservice.IUserInfoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


/**
 * Created by summer on 2017/5/14.
 * 2017/5/14 13:37
 */
public class UserInfoServiceImplTest {

    private IUserInfoService userInfoService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:springConfig/spring-*.xml"});
        userInfoService = (IUserInfoService) context.getBean("userService");
    }

    @Test
    public void getOneUserByUserId() throws Exception {

      BaseUserInfo uf =   userInfoService.getOneUserByUserId(6);

        System.out.println(uf.toString());
        //System.out.println(ToStringUtils.fieldToString(new StringBuffer(),uf));
    }

    @Test
    public void GetUserByOpenId()throws  Exception{

        WXUserInfo bf = userInfoService.getUserInfoByOpenId("oY0PHw3X2faN-EAjdNcrE-0hL4kE");
        System.out.println(bf.getUserid());
        System.out.println(bf.getMobile());
    }


    @Test
    public void insertUserByObject() throws Exception {
        int id = userInfoService.insertUserByObject(getOneUserObject(null,null,null));
        System.out.println("插入ID："+id);
    }


    @Test
    public void updateUserInfoByPk() throws Exception {
        userInfoService.updateUserInfoByPk(getOneUserObject("塔罗牌","卡卡西是我",6));
    }

    @Test
    public void getUserInfoByOpenId() throws Exception {
        BaseUserInfo uf =  userInfoService.getUserInfoByOpenId("saasdfasfasf1231232");
        if(null == uf){
            return;
        }
        System.out.println(uf.toString());

    }

    @Test
    public void checkHasByOpenId() throws Exception {

    }


    //临时获取对象方法。
   private WXUserInfo getOneUserObject(String name,String openId,Integer userId){

       WXUserInfo uf =  new WXUserInfo();

       if(null != userId){
           uf.setUserid(userId);
       }

       if (null != name ){
           uf.setWxNickName(name);
           uf.setNickName(name);
       }else{
           uf.setWxNickName("测试-kakaxi");
           uf.setNickName("父对象-昵称");
       }

       if(null != openId){
           uf.setWxOpenid(openId);
       }else{
           uf.setWxOpenid("saasdfasfasf12312");
       }

           uf.setWxHeadimgurl("http://baidu.com");


           uf.setBirth(new Date());


       //父类属性更新。
        uf.setRemark("beizhu");
        uf.setMobile("18612037596");


       return uf;
   }



}