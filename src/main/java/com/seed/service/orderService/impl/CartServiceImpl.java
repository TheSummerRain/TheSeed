package com.seed.service.orderService.impl;

import com.seed.dao.orderMapper.ICartMapper;
import com.seed.entity.order.Cart;
import com.seed.service.orderService.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by summer on 2017/5/28.
 * 2017/5/28 17:42
 */
@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartMapper cartMapper;

    //这个可以把相关数据都获取。供展示用
    public List<HashMap<String, Object>> searchCartinfo(int userId) {
        return cartMapper.searchCartInfo(userId);
    }

    //只需要查询购物车数据即可。
    public List<Cart> getCartListByUserId(Integer userid) {
        return cartMapper.getCartListByUserId(userid);
    }

    //每次 -1数量
    public void minAmount(Integer cartid) {
        cartMapper.minAmount(cartid);
    }

    public void addAmount(Integer cartid) {
        cartMapper.addAmount(cartid);
    }
}
