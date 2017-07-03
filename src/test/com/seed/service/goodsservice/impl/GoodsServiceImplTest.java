package com.seed.service.goodsservice.impl;

import com.seed.entity.goods.GoodsDetail;
import com.seed.entity.goods.GoodsImgs;
import com.seed.entity.goods.GoodsInfo;
import com.seed.entity.goods.SimpGoods;
import com.seed.myUtil.ToStringUtils;
import com.seed.service.goodsservice.IGoodsService;
import com.seed.service.userservice.IUserInfoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by summer on 2017/5/24.
 * 2017/5/24 14:54
 */
public class GoodsServiceImplTest {


    private IGoodsService goodsService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:springConfig/spring-*.xml"});
        goodsService = (IGoodsService) context.getBean("goodsServiceImpl");
    }


    @Test
    public void getSimpGoodsList() throws Exception {
    /*    List<GoodsInfo> gds =  goodsService.getGoodsList();
        for (GoodsInfo sd : gds){
            System.out.println(sd.getName());
        }*/

        List<SimpGoods> gds = goodsService.getSimpGoodsList();
        for (SimpGoods sd : gds) {
            System.out.println(sd.getName() + "==" + sd.getCreatetime());
        }
    }

    @Test
    public void sortGoodsList() throws Exception {
        List<SimpGoods> gds = goodsService.getSortGoodsList(1);
        for (SimpGoods sd : gds) {
            System.out.println(sd.getName() + "==" + sd.getCreatetime());
        }
    }

    @Test
    public void getOneDetail() throws NoSuchFieldException, IllegalAccessException {

        GoodsInfo gf =  goodsService.getOneGoodsInfoById(1);
        //字段输出查看结果。
        StringBuffer sb  =  ToStringUtils.fieldToString(new StringBuffer(),gf);
        System.out.println(sb);
    }

    @Test
    public void getDetail() throws NoSuchFieldException, IllegalAccessException {

        GoodsDetail gd = goodsService.getDetailById(1);
        StringBuffer sb  =  ToStringUtils.fieldToString(new StringBuffer(),gd);
        System.out.println(sb);

    }

    @Test
    public void getImgs() throws NoSuchFieldException, IllegalAccessException {

        List<GoodsImgs> gm =  goodsService.getGoodsImgsByGoodsId(1);
        System.out.println(gm.size());
    }


    public void test (){

    }


}