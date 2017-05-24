package com.seed.dao.goodsmapper;


import com.seed.entity.goods.GoodsInfo;
import com.seed.entity.goods.SimpGoods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IGoodsInfoMapper {
    int deleteByPrimaryKey(Integer gdid);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer gdid);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);


    //我的实现。

    //查询全部货架上的数据【慎用】
    @Select("select * from seed_goods where gdstatus =1 ")
    @ResultMap("BaseResultMap")
    List<GoodsInfo> getGoodsList();


    //获取简单版列表数据。【列表页常用】
    @Select("select gdid,topid,name,imgs,price,salesprice,virtualsales from seed_goods where gdstatus =1 ")
    @ResultMap("SimpResultMap")
    List<SimpGoods> getSimpGoodsList();

    //获取某一种大类下的所有商品。默认按照销量排序，此处暂时不实现分页。
    @Select("select * from seed_goods where gdstatus =1 and topid = #{topId} ORDER BY virtualsales desc  ")
    @ResultMap("SimpResultMap")
    List<SimpGoods> getSortGoodsList(@Param("topId")int topId);


}