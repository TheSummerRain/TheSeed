package com.seed.mydict;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * 重要的字典信息对象
 * 2017/5/1 22:18
 */
public class ImportDict {

    private ImportDict(){/*不允许被实现的类，只能存储静态的常量数据*/};


    //session中用户信息的 key-Name。
    public static String USER_IN_SESSION = "userInfo";


    //redis-keyName
    //公共失效时间，单位：秒
    public static int pubOutOfServiceTime = 60;

    //URL地址信息
    public static String BaseUri = "http://www.lzyj666.com/seed/";



    //菜单-授权_跳转：用户个人中心。
    public static String userRedirectURI=BaseUri+"user/getOneUser";
    public static String homeRedirectURI=BaseUri+"home/shouye";




    //数据字典
    public static HashedMap topType =  new HashedMap(){
        {
            put(1,"车载电器");
            put(2,"汽车装饰");
            put(3,"美容清洗");
        }
    };


}
