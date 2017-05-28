package com.seed.service.orderService.impl;

import com.seed.service.goodsservice.IGoodsService;
import com.seed.service.orderService.ICartService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by summer on 2017/5/28.
 * 2017/5/28 18:04
 */
public class CartServiceImplTest {

    private ICartService cartService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:springConfig/spring-*.xml"});
        cartService = (ICartService) context.getBean("cartServiceImpl");
    }

    @Test
    public void searchCartinfo() throws Exception {

        List<HashMap<String, Object>> lists = cartService.searchCartinfo(6);

        System.out.println("=======================");

        for (HashMap<String, Object> sm : lists) {

            Iterator<Map.Entry<String, Object>> it = sm.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                System.out.println("key= " + entry.getKey() + "  |value= " + entry.getValue());
            }

        }


    }

}