package com.seed.service.goodsservice;

import com.seed.entity.goods.GoodsDetail;
import com.seed.entity.goods.GoodsImgs;
import com.seed.entity.goods.GoodsInfo;
import com.seed.entity.goods.SimpGoods;

import java.util.List;

/**
 * Created by summer on 2017/5/24.
 * 2017/5/24 14:43
 */
public interface IGoodsService {


    //分类页数据获取。{首页分类列表用}
    List<SimpGoods> getSimpGoodsList();

    List<GoodsInfo> getGoodsList();

    //获取某一类下的：商品数据。大类。pram:1,2,3
    List<SimpGoods> getSortGoodsList(int typeId);

    //获取一条 商品数据。
    GoodsInfo getOneGoodsInfoById(int goodsId);

    //获取一条商品详情数据
    GoodsDetail getDetailById(int goodsId);

    //获取商品的：所有展示图片。按照展示顺序字段，倒叙排列。0-999.数字越大，越靠前。
    List<GoodsImgs> getGoodsImgsByGoodsId(int goodsId);


}
