package com.seed.dao.goodsmapper;


import com.seed.entity.goods.GoodsDetail;
import com.seed.entity.goods.GoodsImgs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IGoodsDetailMapper {
    GoodsDetail selectByPrimaryKey(Integer dtid);




}