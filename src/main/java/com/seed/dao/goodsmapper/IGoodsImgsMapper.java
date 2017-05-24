package com.seed.dao.goodsmapper;


import com.seed.entity.goods.GoodsImgs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IGoodsImgsMapper {

    GoodsImgs selectByPrimaryKey(Integer picid);

    //获取商品的所有 展示图片，并按照排序字段，倒叙排列 0-999
    @Select("select * from seed_goods_imgs where gdid = #{goodsId} ORDER BY odnum desc ")
    @ResultMap("BaseResultMap")
    List<GoodsImgs> getGoodsImgsByGoodsId(@Param("goodsId") int goodsId);

}