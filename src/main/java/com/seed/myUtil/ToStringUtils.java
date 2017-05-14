package com.seed.myUtil;
import com.seed.entity.user.WXUserInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * 把Bean的属性输出打印，相当于从写ToString（）方法。
 * Created by summer on 2017/5/14.
 * 2017/5/14 14:38
 */
public class ToStringUtils {

    public static void main(String[] args) {

    }

    public static StringBuffer fieldToString( StringBuffer sb,Object obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
        Field [] fields = obj.getClass().getDeclaredFields();
        sb.append(obj.getClass().getName())
                .append(";").append("\n");

        for(Field f:fields){
            f.setAccessible(true);
            sb.append(f.getName())
                    .append(" = ")
                    .append(f.get(obj)).append(" ;").append("\n");
        }
        return sb;
    }

    public static StringBuffer methodToString(StringBuffer sb,Object obj){
        Method[] methods = obj.getClass().getMethods();

        for(Method m:methods){
            sb.append(m.getName()).append(";").append("\n");
        }
        return sb;
    }

}
