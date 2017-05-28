package com.seed.dao.orderMapper;


import com.seed.entity.order.Cart;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface ICartMapper {
    int deleteByPrimaryKey(Integer cartid);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer cartid);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

//-----------------------------------------------

//根据用户ID查询用户的购物车信息。
    //为了减少查询的结果集，吧*换成需要的字符串吧。减少遍历时间。
    @Select("select * from seed_cart sc LEFT JOIN seed_goods sg on sc.goodsId=sg.gdid where sc.userId=6")
    List<HashMap<String, Object>> searchCartInfo(int userId);


}