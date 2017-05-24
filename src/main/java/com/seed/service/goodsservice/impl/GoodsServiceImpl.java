package com.seed.service.goodsservice.impl;

import com.seed.dao.goodsmapper.IGoodsDetailMapper;
import com.seed.dao.goodsmapper.IGoodsImgsMapper;
import com.seed.dao.goodsmapper.IGoodsInfoMapper;
import com.seed.entity.goods.GoodsDetail;
import com.seed.entity.goods.GoodsImgs;
import com.seed.entity.goods.GoodsInfo;
import com.seed.entity.goods.SimpGoods;
import com.seed.service.goodsservice.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by summer on 2017/5/24.
 * 2017/5/24 14:44
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IGoodsInfoMapper goodsInfoMapper;
    @Autowired
    private IGoodsDetailMapper iGoodsDetailMapper;
    @Autowired
    private IGoodsImgsMapper goodsImgsMapper;


    public List<SimpGoods> getSimpGoodsList() {
        return goodsInfoMapper.getSimpGoodsList();
    }

    public List<GoodsInfo> getGoodsList() {
        return goodsInfoMapper.getGoodsList();
    }

    public List<SimpGoods> getSortGoodsList(int typeId) {
        return goodsInfoMapper.getSortGoodsList(typeId);
    }

    //获取一条商品数据。
    public GoodsInfo getOneGoodsInfoById(int goodsId) {
        return goodsInfoMapper.selectByPrimaryKey(goodsId);
    }

    //根据商品ID，获取一条商品的详细数据
    public GoodsDetail getDetailById(int goodsId){
        return iGoodsDetailMapper.selectByPrimaryKey(goodsId);
    }


    public List<GoodsImgs> getGoodsImgsByGoodsId(int goodsId) {
        return goodsImgsMapper.getGoodsImgsByGoodsId(goodsId);
    }


}
